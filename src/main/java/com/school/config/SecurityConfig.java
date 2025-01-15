package com.school.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT name, password, enabled FROM user WHERE name = ?")
                .authoritiesByUsernameQuery(
                        "SELECT user.name, authority.type FROM authority INNER JOIN user ON user.id = authority.user_id WHERE authority.user_id = (SELECT id FROM user WHERE name = ?)");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(auth -> {
            try {
                auth.antMatchers("/admin/**").authenticated()
                        .antMatchers("/jpnj/**").authenticated()
                        .antMatchers("/library/**").authenticated()
                        .antMatchers("/school/**").authenticated()
                        .anyRequest().permitAll()
                        .and()
                        .formLogin(login -> login.successHandler((request, response, servletAuth) -> {
                            for (final var authority : servletAuth.getAuthorities()) {
                                switch (authority.getAuthority()) {
                                    case "PPD":
                                    case "JPNJ":
                                        response.sendRedirect("/jpnj/home");
                                        break;

                                    case "STUDENT":
                                    case "TEACHER":
                                        response.sendRedirect("/school/welcome");
                                        break;

                                    case "SCHOOL_ADMINISTRATOR":
                                    case "SYSTEM_ADMINISTRATOR":
                                        response.sendRedirect("/admin/adminDashboard");
                                        break;

                                    default:
                                        response.sendRedirect("/");
                                        break;
                                }
                            }
                        }).permitAll())
                        .logout(logout -> logout.logoutUrl("/logout").permitAll())
                        .csrf(csrf -> csrf.disable());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
