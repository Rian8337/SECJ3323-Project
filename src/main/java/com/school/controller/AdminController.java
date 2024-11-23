package com.school.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.model.School;
import com.school.model.User;

@Controller
public class AdminController {

    // Simulate a database with a static list of schools
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
        return "newlySubmittedSchools";
    }
    // Simulate a database with a static list of users
    private static List<User> users = new ArrayList<>();

    // Initialize with some default users
    static {
        User user1 = new User();
        user1.setId("U001");
        user1.setName("Siti Noor");
        user1.setInstitution("PPD");
        user1.setEmail("siti@ppd.com");
        user1.setPhone("+60 23456789");
        users.add(user1);

        User user2 = new User();
        user2.setId("U002");
        user2.setName("Aqilla Noorshaumy");
        user2.setInstitution("JPNJ");
        user2.setEmail("aqilla@jpnj.com");
        user2.setPhone("+60 34567890");
        users.add(user2);

        User user3 = new User();
        user3.setId("U003");
        user3.setName("Ali Ahmad");
        user3.setInstitution("Student");
        user3.setEmail("ali.ahmad@student.com");
        user3.setPhone("+60 45678901");
        users.add(user3);

        User user4 = new User();
        user4.setId("U004");
        user4.setName("Siti Aisyah");
        user4.setInstitution("Teacher");
        user4.setEmail("siti.aisyah@teacher.com");
        user4.setPhone("+60 56789012");
        users.add(user4);
    }

    // Show list of users
    @GetMapping("/viewUsers")
    public String showUsers(Model model) {
        model.addAttribute("users", users);
        return "viewUsers";  // View the list of users
    }

    // Edit user
    @GetMapping("/editUser")
    public String showEditUserForm(@RequestParam("id") String userId, Model model) {
        User user = users.stream()
            .filter(u -> u.getId().equals(userId))
            .findFirst()
            .orElse(null);
        
        model.addAttribute("user", user);
        return "editUser";  // Form to edit user details
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User updatedUser, Model model) {
        users.stream()
            .filter(u -> u.getId().equals(updatedUser.getId()))
            .findFirst()
            .ifPresent(user -> {
                user.setName(updatedUser.getName());
                user.setInstitution(updatedUser.getInstitution());
                user.setEmail(updatedUser.getEmail());
                user.setPhone(updatedUser.getPhone());
            });

        return "redirect:/viewUsers"; 
    }

    // Delete user
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") String userId, Model model) {
        users.removeIf(u -> u.getId().equals(userId));
        return "redirect:/viewUsers";  // Redirect to user list after deletion
    }
}

