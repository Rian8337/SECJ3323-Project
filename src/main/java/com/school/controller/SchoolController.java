package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import com.school.model.School;

@Controller
public class SchoolController {

    @GetMapping("/welcome")
    public String showWelcome() {
        return "welcome";
    }

    @GetMapping("/addSchool")
    public String showAddSchoolForm() {
        return "addSchool";
    }

    @PostMapping("/submitSchool")
    public String submitSchool(@ModelAttribute School school) {
        // Add your logic to save the school information
        return "success"; // This will show the success page
    }

    @PostMapping("/cancelOperation")
    public String cancelOperation() {
        return "redirect:/welcome";
    }
}
