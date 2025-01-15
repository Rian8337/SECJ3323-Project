package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.constants.SchoolVerificationStatus;
import com.school.entity.School;
import com.school.repository.SchoolDao;

@Service
public class SchoolService {
    @Autowired
    private SchoolDao schoolDao;

    public void saveSchool(final School school) {
        final var equipments = school.getEquipments();

        if (equipments.size() <= 4) {
            school.setEquipmentLevel(1);
        } else if (equipments.size() <= 10) {
            school.setEquipmentLevel(2);
        } else {
            school.setEquipmentLevel(3);
        }

        schoolDao.save(school);
    }

    public void updateSchoolStatus(long schoolId, boolean verified) {
        final var school = schoolDao.getById(schoolId);

        school.setId(schoolId);
        school.setVerificationStatus(verified ? SchoolVerificationStatus.VERIFIED : SchoolVerificationStatus.REJECTED);

        schoolDao.update(school);
    }
}
