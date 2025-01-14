package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.school.repository.SchoolDao;
import com.school.service.SchoolService;

@Controller
@RequestMapping("/jpnj")
public class JPNJController {
    @Autowired
    private SchoolDao schoolDao;

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/home")
    public String showJPNJDashboard() {
        return "jpnj/home";
    }

    @GetMapping("/newlySubmittedSchools")
    public String showNewlySubmittedSchools(Model model) {
        model.addAttribute("schools", schoolDao.getAll());
        return "jpnj/newlySubmittedSchools";
    }

    @GetMapping("/schoolInfo")
    public String showSchoolInfo(@RequestParam("id") Long schoolId, Model model) {
        model.addAttribute("school", schoolDao.getById(schoolId));
        return "jpnj/schoolInfo";
    }

    @PostMapping("/verifySchool")
    public String verifySchool(@RequestParam("id") Long schoolId,
            @RequestParam("action") String action) {
        schoolService.updateSchoolStatus(schoolId, action.equals("accept"));

        return "redirect:/jpnj/newlySubmittedSchools";
    }
}