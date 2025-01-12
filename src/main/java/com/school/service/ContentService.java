package com.school.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.constants.ContentCategory;
import com.school.entity.Content;
import com.school.entity.User;
import com.school.repository.ContentDao;

@Service
public class ContentService {
    @Autowired
    private ContentDao contentDao;

    @Transactional
    public Content uploadContent(final User user, final String videoId, final ContentCategory category) {
        // TODO: request YouTube for video information. For now, use dummy data
        final var content = new Content();

        content.setAuthor(user);
        content.setTitle("Introduction to " + category);
        content.setVideoId(videoId);
        content.setCategory(category);
        content.setUploadedDate(new Date());
        content.setVideoId(videoId);

        contentDao.save(content);

        return content;
    }

    public List<Content> getContents() {
        return contentDao.getAll();
    }

    public Content getContentById(final long id) {
        return contentDao.getById(id);
    }

    public List<Content> getContentsByUser(final User user) {
        return getContentsByUser(user.getId());
    }

    public List<Content> getContentsByUser(final long userId) {
        return contentDao.getByUser(userId);
    }

    public void saveContent(final Content content) {
        contentDao.save(content);
    }

    public void updateContent(final Content content) {
        contentDao.update(content);
    }

    public void deleteContent(final Content content) {
        contentDao.delete(content);
    }
}
