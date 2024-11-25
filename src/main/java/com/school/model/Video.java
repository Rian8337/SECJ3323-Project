package com.school.model;

public class Video {
    private String videoUrl;
    private String studentName;

    // Constructor
    public Video(String videoUrl, String studentName) {
        this.videoUrl = videoUrl;
        this.studentName = studentName;
    }

    // Getters and setters
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
