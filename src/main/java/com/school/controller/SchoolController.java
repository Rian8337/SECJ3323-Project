package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.school.repository.UserDao;
import com.school.constants.SchoolVerificationStatus;

@Controller
@RequestMapping("/school")
public class SchoolController {
    private static final String email = "rezahendrian@graduate.utm.my"; // This would come from authentication

    @Autowired
    private UserDao userDao;

    @GetMapping("/welcome")
    public String showWelcome(Model model) {
        final var user = userDao.getByEmail(email);
        final var school = user.getSchool();

        if (school != null && school.getVerificationStatus() == SchoolVerificationStatus.VERIFIED) {
            model.addAttribute("school", school);
            model.addAttribute("hasVerifiedSchool", true);
        } else {
            model.addAttribute("hasVerifiedSchool", false);
        }

        return "school/welcome";
    }

    @PostMapping("/cancelOperation")
    public String cancelOperation() {
        return "redirect:/school/welcome";
    }

    @GetMapping("/editSchool")
    public String editSchool(Model model) {
        var user = userDao.getByEmail(email);
        var school = user.getSchool();

        if (school != null) {
            model.addAttribute("school", school);
            return "school/editSchool";
        }

        return "redirect:/school/welcome";
    }
}