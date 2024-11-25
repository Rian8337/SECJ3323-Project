package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.model.School;

@Controller
@RequestMapping("/school")
public class SchoolController {
    @GetMapping("/welcome")
    public String showWelcome() {
        return "school/welcome";
    }

    @GetMapping("/addSchool")
    public String showAddSchoolForm() {
        return "school/addSchool";
    }

    @PostMapping("/submitSchool")
    public String submitSchool(@ModelAttribute School school) {
        // Add your logic to save the school information
        return "school/success"; // This will show the success page
    }

    @PostMapping("/cancelOperation")
    public String cancelOperation() {
        return "redirect:/school/welcome";
    }

    @GetMapping("/editSchool")
    public String editSchool() {
        // Fetch school details and add to model
        return "school/editSchool"; // Returns the name of the view (editSchool.jsp or editSchool.html)
    }
}

