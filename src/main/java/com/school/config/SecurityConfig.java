package com.school.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
                                        response.sendRedirect(request.getContextPath() + "/jpnj/home");
                                        return;

                                    case "STUDENT":
                                    case "TEACHER":
                                        response.sendRedirect(request.getContextPath() + "/school/welcome");
                                        return;

                                    case "SCHOOL_ADMINISTRATOR":
                                    case "SYSTEM_ADMINISTRATOR":
                                        response.sendRedirect(request.getContextPath() + "/admin");
                                        return;

                                    default:
                                        response.sendRedirect(request.getContextPath() + "/library");
                                        return;
                                }
                            }
                        }).permitAll())
                        .logout(logout -> logout.logoutUrl("/logout").permitAll());
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
