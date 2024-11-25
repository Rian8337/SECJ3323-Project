package com.school.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.model.School;
import com.school.model.Video;
import com.school.model.User;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String showAdminDashboard() {
        return "admin/adminDashboard"; // This must match the name of your HTML template
    }

    @GetMapping("/newlySubmittedSchools")
    public String showNewlySubmittedSchools(Model model) {
        model.addAttribute("schools", schools);
        return "admin/newlySubmittedSchools";
    }

    private static List<School> schools = new ArrayList<>();

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
        school1.setEquipment(new ArrayList<>(List.of("Camera")));
        school1.setEquipmentLevel(1);
        school1.setTotalStudents(500);
        school1.setTotalVideos(1);

        // Video details
        Video video1 = new Video("https://youtu.be/lSD_L-xic9o?si=gfS4wXBvG5MKuz5n", "A");
        school1.setVideo(video1); // Set video

        schools.add(school1);

        School school2 = new School();
        school2.setSchoolName("Sekolah Menengah Kebangsaan Sultan Ismail");
        school2.setPrincipalName("Hasanah Binti Salleh");
        school2.setDistrict("Johor Bahru");
        school2.setAddress("Johor");
        school2.setEmail("SMKSultanIsmail@gmail.com");
        school2.setPhone("+60 98765432");
        school2.setAdmissionDate("10/08/2018");
        school2.setStatus("Verified");
        school2.setSchoolId("SI9876");
        List<String> equipmentList = new ArrayList<>(List.of(
                "Smartphone",
                "External Mic (Lavalier/Clip Mic)",
                "Monopod",
                "Ring Light",
                "Editing Corner/Room",
                "Webcam",
                "Tripod",
                "Mobile lighting",
                "Mobile Green Screen set",
                "Editing Software (Open Source)"
        ));
        school2.setEquipment(equipmentList);
        school2.setEquipmentLevel(2);
        school2.setTotalStudents(1200);
        school2.setTotalVideos(1);

        // Video details
        Video video2 = new Video("https://youtu.be/a3ICNMQW7Ok?si=ulufiDWa4BgPdEBX", "Nina Farah");
        school2.setVideo(video2); // Set video

        schools.add(school2);
    }

    @GetMapping("/schoolInfo")
    public String showSchoolInfo(@RequestParam("id") String schoolId, Model model) {
        School school = schools.stream()
                .filter(s -> s.getSchoolId().equals(schoolId))
                .findFirst()
                .orElse(null);

        model.addAttribute("school", school);
        return "admin/schoolInfo";
    }

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
        return "admin/viewUsers";  // View the list of users
    }

    // Edit user
    @GetMapping("/editUser")
    public String showEditUserForm(@RequestParam("id") String userId, Model model) {
        User user = users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElse(null);

        model.addAttribute("user", user);
        return "admin/editUser";  // Form to edit user details
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

        return "redirect:/admin/viewUsers";
    }

    // Delete user
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") String userId, Model model) {
        users.removeIf(u -> u.getId().equals(userId));
        return "redirect:/admin/viewUsers";  // Redirect to user list after deletion
    }
}
