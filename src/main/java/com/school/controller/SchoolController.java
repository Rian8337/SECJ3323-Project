package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.school.repository.SchoolInformationDAO;
import com.school.model.School;
import com.school.constants.SchoolVerificationStatus;

@Controller
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolInformationDAO schoolInformationDAO;

    @GetMapping("/welcome")
    public String showWelcome(Model model) {
        String teacherEmail = "current.teacher@school.com"; // This would come from authentication
        
        School school = schoolInformationDAO.findByTeacherEmail(teacherEmail);
        
        if (school != null && SchoolVerificationStatus.VERIFIED.toString().equals(school.getStatus())) {
            model.addAttribute("school", school);
            model.addAttribute("hasVerifiedSchool", true);
        } else {
            model.addAttribute("hasVerifiedSchool", false);
        }
        
        return "school/welcome";
    }

    @GetMapping("/addSchool")
    public String showAddSchoolForm(Model model) {
        model.addAttribute("school", new School());
        return "school/addSchool";
    }

    @PostMapping("/submitSchool")
    public String submitSchool(@ModelAttribute School school) {
        school.setStatus(SchoolVerificationStatus.PENDING.toString());
        schoolInformationDAO.saveSchool(school);
        return "school/success";
    }

    @PostMapping("/cancelOperation")
    public String cancelOperation() {
        return "redirect:/school/welcome";
    }

    @GetMapping("/editSchool")
    public String editSchool(Model model) {
        String teacherEmail = "current.teacher@school.com"; // This would come from authentication
        School school = schoolInformationDAO.findByTeacherEmail(teacherEmail);
        
        if (school != null) {
            model.addAttribute("school", school);
            return "school/editSchool";
        }
        
        return "redirect:/school/welcome";
    }
}