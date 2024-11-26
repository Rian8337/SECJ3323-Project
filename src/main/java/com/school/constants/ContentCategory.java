package com.school.constants;

public enum ContentCategory {
    PROGRAMMING,
    MATHEMATICS,
    SCIENCE,
    HISTORY,
    GEOGRAPHY,
    ART,
    MUSIC,
    SPORTS,
    LITERATURE,
    OTHER;

    public static ContentCategory from(String category) {
        for (ContentCategory contentCategory : ContentCategory.values()) {
            if (contentCategory.name().equalsIgnoreCase(category)) {
                return contentCategory;
            }
        }

        return OTHER;
    }

    public String toString() {
        String name = name();

        // Ensure the first letter is capitalized
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
