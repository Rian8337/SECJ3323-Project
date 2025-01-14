package com.school.constants;

public enum AuthorityType {
    PPD,
    JPNJ,
    STUDENT,
    TEACHER,
    SCHOOL_ADMINISTRATOR,
    SYSTEM_ADMINISTRATOR;

    public static AuthorityType from(final String type) {
        for (AuthorityType authorityType : AuthorityType.values()) {
            if (authorityType.name().equalsIgnoreCase(type)) {
                return authorityType;
            }
        }

        throw new IllegalArgumentException("Invalid authority type: " + type);
    }

    @Override
    public String toString() {
        switch (this) {
            case PPD:
                return "PPD";

            case JPNJ:
                return "JPNJ";

            case STUDENT:
                return "Student";

            case TEACHER:
                return "Teacher";

            case SCHOOL_ADMINISTRATOR:
                return "School Administrator";

            case SYSTEM_ADMINISTRATOR:
                return "System Administrator";

            default:
                return "Other";
        }
    }
}
