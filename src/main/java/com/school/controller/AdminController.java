package com.school.controller;

import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.constants.EquipmentType;
import com.school.entity.Equipment;
import com.school.entity.School;
import com.school.entity.User;
import com.school.repository.SchoolDao;
import com.school.repository.UserDao;
import com.school.service.SchoolService;
import com.school.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private SchoolDao schoolDao;

    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public String showAdminDashboard() {
        return "admin/adminDashboard";
    }

    @GetMapping("/newlySubmittedSchools")
    public String showNewlySubmittedSchools(Model model) {
        model.addAttribute("schools", schoolDao.getPendingSchools());
        return "admin/newlySubmittedSchools";
    }

    @GetMapping("/addSchool")
    public String showAddSchoolForm() {
        return "school/addSchool";
    }

    @PostMapping("/cancelOperation")
    public String cancelOperation() {
        return "redirect:/admin";
    }

    @PostMapping("/submitSchool")
    public String submitSchool(final @ModelAttribute School school,
            final @RequestBody MultiValueMap<String, String> formData) {
        final var user = userService.getCurrentLoggedInUser();
        user.setSchool(school);

        school.setAdmin(user);

        final var members = new HashSet<User>();
        members.add(user);
        school.setMembers(members);

        final var equipments = new HashSet<Equipment>();

        // Parse the equipment data
        for (var type : EquipmentType.values()) {
            if (formData.containsKey(type.label)) {
                final var equipment = new Equipment();
                equipment.setType(type);
                equipment.setSchool(school);
                equipments.add(equipment);
            }
        }

        school.setEquipments(equipments);

        schoolService.saveSchool(school);
        userDao.save(user);

        return "school/success"; // This will show the success page
    }

    @GetMapping("/schoolInfo")
    public String showSchoolInfo(@RequestParam("id") Long schoolId, Model model) {
        model.addAttribute("school", schoolDao.getById(schoolId));
        return "admin/schoolInfo";
    }

    @GetMapping("/editSchool")
    public String showEditSchoolForm(@RequestParam("id") Long schoolId, Model model) {
        model.addAttribute("school", schoolDao.getById(schoolId));
        return "admin/editSchool";
    }

    @PostMapping("/updateSchool")
    public String updateSchool(@ModelAttribute School updatedSchool, Model model) {
        schoolDao.update(updatedSchool);

        // Redirect to newly submitted schools page with updated list
        return "redirect:newlySubmittedSchools";
    }

    // Show list of users
    @GetMapping("/viewUsers")
    public String showUsers(Model model) {
        model.addAttribute("users", userDao.getAll());
        return "admin/viewUsers"; // View the list of users
    }

    // Show Edit User Form (GET request)
    @GetMapping("/editUser")
    public String showEditUserForm(@RequestParam("id") Long userId, Model model) {
        model.addAttribute("user", userDao.getById(userId));
        return "admin/editUser"; // Rendering the edit user form
    }

    // Handle Edit User Form submission (POST request)
    @PostMapping("/editUser")
    public String updateUser(@RequestParam("id") Long userId,
            @RequestParam("name") String name,
            @RequestParam("email") String email) {
        userService.updateUser(userId, name, email);

        // Redirect to the viewUser page after updating
        return "redirect:/admin/viewUsers";
    }

    // Delete user
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long userId, Model model) {
        userDao.delete(userId);

        return "redirect:/admin/viewUsers"; // Redirect to user list after deletion
    }
}
