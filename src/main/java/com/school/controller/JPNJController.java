package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.school.repository.SchoolInformationDAO;
import com.school.constants.SchoolVerificationStatus;
import com.school.model.School;
import java.util.List;

@Controller
@RequestMapping("/jpnj")
public class JPNJController {
    
    @Autowired
    private SchoolInformationDAO schoolInformationDAO;

    @GetMapping("/home")
    public String showJPNJDashboard() {
        return "jpnj/home";
    }

    @GetMapping("/newlySubmittedSchools")
    public String showNewlySubmittedSchools(Model model) {
        List<School> schools = schoolInformationDAO.getNewlySubmittedSchools();
        model.addAttribute("schools", schools);
        return "jpnj/newlySubmittedSchools";
    }

    @GetMapping("/schoolInfo")
    public String showSchoolInfo(@RequestParam("id") String schoolId, Model model) {
        School school = schoolInformationDAO.findBySchoolId(schoolId);
        model.addAttribute("school", school);
        return "jpnj/schoolInfo";
    }

    @PostMapping("/verifySchool")
    public String verifySchool(@RequestParam("id") String schoolId, 
                             @RequestParam("action") String action) {
        SchoolVerificationStatus status = action.equals("accept") ? 
            SchoolVerificationStatus.VERIFIED : SchoolVerificationStatus.REJECTED;
            
        schoolInformationDAO.updateSchoolStatus(schoolId, status.toString());
        return "redirect:/jpnj/newlySubmittedSchools";
    }
}