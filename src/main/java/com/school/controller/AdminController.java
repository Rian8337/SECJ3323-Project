package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.school.model.School;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    // Simulate a database with a static list
    private static List<School> schools = new ArrayList<>();

    // Initialize with some default schools
    static {
        School school1 = new School();
        school1.setSchoolName("Sekolah Kebangsaan Taman Pelangi");
        school1.setPrincipalName("Nur Batou Binti Mohd. Waleed");
        school1.setDistrict("Sri Pulai Perdana");
        school1.setAddress("Johor");
        school1.setEmail("KebangsaanTamanPelangi@gmail.com");
        school1.setPhone("+60 12345678");
        school1.setAdmissionDate("24/10/2020");
        school1.setStatus("Verified");
        school1.setSchoolId("AS2233");
        schools.add(school1);
    }

    @GetMapping("/admin")
    public String showAdminDashboard() {
        return "adminDashboard";
    }

    @GetMapping("/newlySubmittedSchools")
    public String showNewlySubmittedSchools(Model model) {
        model.addAttribute("schools", schools);
        return "newlySubmittedSchools";
    }

    @GetMapping("/schoolInfo")
    public String showSchoolInfo(@RequestParam("id") String schoolId, Model model) {
        School school = schools.stream()
            .filter(s -> s.getSchoolId().equals(schoolId))
            .findFirst()
            .orElse(null);
        
        model.addAttribute("school", school);
        return "schoolInfo";
    }

    @GetMapping("/editSchool")
    public String showEditSchoolForm(@RequestParam("id") String schoolId, Model model) {
        School school = schools.stream()
            .filter(s -> s.getSchoolId().equals(schoolId))
            .findFirst()
            .orElse(null);
        
        model.addAttribute("school", school);
        return "editSchool";
    }

    @PostMapping("/updateSchool")
    public String updateSchool(@ModelAttribute School updatedSchool, Model model) {
        // Find and update the existing school
        schools.stream()
            .filter(s -> s.getSchoolId().equals(updatedSchool.getSchoolId()))
            .findFirst()
            .ifPresent(school -> {
                school.setSchoolName(updatedSchool.getSchoolName());
                school.setPrincipalName(updatedSchool.getPrincipalName());
                school.setDistrict(updatedSchool.getDistrict());
                school.setAddress(updatedSchool.getAddress());
                school.setEmail(updatedSchool.getEmail());
                school.setPhone(updatedSchool.getPhone());
                school.setStatus(updatedSchool.getStatus());
            });

        // Redirect to newly submitted schools page with updated list
        return "redirect:/newlySubmittedSchools";
    }
}