package com.school.entity;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.school.constants.AuthorityType;
import com.school.constants.SchoolVerificationStatus;

@Entity
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String address;

    @Column(name = "admission_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date admissionDate;

    @Column(name = "verification_status", nullable = false)
    private SchoolVerificationStatus verificationStatus;

    @OneToOne
    @JoinColumn(name = "admin_id", nullable = false, unique = true)
    private User admin;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private Set<User> members;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private Set<Equipment> equipments;

    @Column(name = "equipment_level", nullable = false)
    private int equipmentLevel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public SchoolVerificationStatus getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(SchoolVerificationStatus verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public Set<User> getStudents() {
        return members.stream()
                .filter(member -> member.getAuthorities().stream()
                        .anyMatch(authority -> authority.getType() == AuthorityType.STUDENT))
                .collect(Collectors.toSet());
    }

    public Set<User> getTeachers() {
        return members.stream()
                .filter(member -> member.getAuthorities().stream()
                        .anyMatch(authority -> authority.getType() == AuthorityType.TEACHER))
                .collect(Collectors.toSet());
    }

    public Set<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(Set<Equipment> equipments) {
        this.equipments = equipments;
    }

    public int getEquipmentLevel() {
        return equipmentLevel;
    }

    public void setEquipmentLevel(int equipmentLevel) {
        this.equipmentLevel = equipmentLevel;
    }
}
