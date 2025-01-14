package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.constants.SchoolVerificationStatus;
import com.school.repository.SchoolDao;

@Service
public class SchoolService {
    @Autowired
    private SchoolDao schoolDao;

    public void updateSchoolStatus(long schoolId, boolean verified) {
        final var school = schoolDao.getById(schoolId);

        school.setId(schoolId);
        school.setVerificationStatus(verified ? SchoolVerificationStatus.VERIFIED : SchoolVerificationStatus.REJECTED);

        schoolDao.update(school);
    }
}
