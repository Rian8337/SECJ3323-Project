package com.school.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.config.Config;
import com.school.constants.ContentCategory;
import com.school.entity.Content;
import com.school.entity.User;
import com.school.repository.ContentDao;
import com.school.rest.JSONObjectWebRequest;

@Service
public class ContentService {
    @Autowired
    private ContentDao contentDao;

    @Transactional
    public Content uploadContent(final User user, final String videoId, final ContentCategory category)
            throws Exception {
        final var key = Config.getInstance().getYoutubeAPIKey();

        // API reference: https://developers.google.com/youtube/v3/docs/videos/list
        try (var request = new JSONObjectWebRequest("https://www.googleapis.com/youtube/v3/videos")) {
            request.buildUrl(url -> url
                    .addQueryParameter("part", "snippet")
                    .addQueryParameter("id", videoId)
                    .addQueryParameter("key", key));

            final var response = request.execute();

            if (!response.has("items") || response.getJSONArray("items").length() == 0) {
                return null;
            }

            final var item = response.getJSONArray("items").getJSONObject(0);
            final var snippet = item.getJSONObject("snippet");
            final var content = new Content();

            content.setAuthor(user);
            content.setTitle(snippet.getString("title"));
            content.setVideoId(videoId);
            content.setCategory(category);
            content.setUploadedDate(new Date());
            content.setVideoId(videoId);

            contentDao.save(content);

            return content;
        }
    }

    public List<Content> getContents() {
        return contentDao.getAll();
    }

    public List<Content> getContents(final int page, final int pageSize) {
        return contentDao.getPaged(page, pageSize);
    }

    public List<Content> searchContents(final String searchQuery, final int page, final int pageSize) {
        if (searchQuery == null || searchQuery.isBlank()) {
            return getContents(page, pageSize);
        }

        return contentDao.getSearched(searchQuery, page, pageSize);
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
