package com.school.config;

public class Config {
    private String youtubeAPIKey;

    private static Config instance = null;

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }

        return instance;
    }

    private Config() {
        youtubeAPIKey = "<insert key here or get from somewhere else>";
    }

    public String getYoutubeAPIKey() {
        return youtubeAPIKey;
    }

    public void setYoutubeAPIKey(String youtubeAPIKey) {
        this.youtubeAPIKey = youtubeAPIKey;
    }
}
