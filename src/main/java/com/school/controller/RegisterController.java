package com.school.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.constants.AuthorityType;
import com.school.entity.Authority;
import com.school.entity.User;
import com.school.repository.UserDao;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping
    public String getRegister(final Model model) {
        model.addAttribute("selectedRole", "");
        model.addAttribute("roles", AuthorityType.values());

        return "user/register.html";
    }

    @PostMapping
    public String putRegister(@RequestParam("email") String email, @RequestParam("name") String name,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword, @RequestParam("role") String role, Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match!");

            // Retain entered data
            model.addAttribute("email", email);
            model.addAttribute("name", name);
            model.addAttribute("selectedRole", role);

            return "user/register.html";
        }

        if (userDao.getByName(name) != null) {
            model.addAttribute("error", "Username already exists!");

            // Retain entered data
            model.addAttribute("email", email);
            model.addAttribute("name", name);
            model.addAttribute("selectedRole", role);

            return "user/register.html";
        }

        // Create user
        final var user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(passwordEncoder.encode(password));
        user.setEnabled(true);

        // Assign role
        final var authority = new Authority();
        authority.setType(AuthorityType.from(role));
        authority.setUser(user);

        final var authorities = new HashSet<Authority>();
        authorities.add(authority);
        user.setAuthorities(authorities);

        // Save user
        userDao.save(user);

        return "redirect:/login";
    }
}
