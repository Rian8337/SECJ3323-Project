package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.school.entity.User;
import com.school.repository.UserDao;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getCurrentLoggedInUser() {
        final var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails details) {
            final var username = details.getUsername();

            return userDao.getByName(username);
        }

        return null;
    }
}
