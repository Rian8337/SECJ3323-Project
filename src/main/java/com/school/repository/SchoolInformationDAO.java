package com.school.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Repository;
import com.school.model.School;
import com.school.constants.SchoolVerificationStatus;

@Repository
public class SchoolInformationDAO {
    private static final List<School> schools = new ArrayList<>();
    private static final AtomicLong idGenerator = new AtomicLong();

    public void saveSchool(School school) {
        // Set creation timestamp
        if (school.getAdmissionDate() == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            school.setAdmissionDate(sdf.format(new Date()));
        }

        // Set ID if not already set
        if (school.getSchoolId() == null) {
            school.setSchoolId(String.valueOf(idGenerator.incrementAndGet()));
        }
        
        // Add to the list
        schools.add(school);
    }

    public List<School> getAllSchools() {
        return new ArrayList<>(schools);
    }

    public List<School> getNewlySubmittedSchools() {
        return schools.stream()
                .filter(s -> SchoolVerificationStatus.PENDING.name().equals(s.getStatus()))
                .collect(Collectors.toList());
    }

    public School findBySchoolId(String schoolId) {
        return schools.stream()
                .filter(s -> schoolId.equals(s.getSchoolId()))
                .findFirst()
                .orElse(null);
    }

    public School findByTeacherEmail(String teacherEmail) {
        return schools.stream()
                .filter(s -> teacherEmail.equals(s.getEmail()))
                .findFirst()
                .orElse(null);
    }

    public void updateSchoolStatus(String schoolId, String status) {
        schools.stream()
                .filter(s -> schoolId.equals(s.getSchoolId()))
                .findFirst()
                .ifPresent(school -> school.setStatus(status));
    }
}