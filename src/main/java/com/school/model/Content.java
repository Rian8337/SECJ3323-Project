package com.school.model;

import java.util.Date;

import com.school.constants.ContentCategory;

/**
 * Represents a content that is uploaded by a student of a school.
 */
public class Content {
    private String id;
    private String title;
    private String author;
    private Date uploadedDate;
    private ContentCategory category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(Date uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public ContentCategory getCategory() {
        return category;
    }

    public void setCategory(ContentCategory category) {
        this.category = category;
    }
}
