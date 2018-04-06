package com.jtd.entity;

public class Fjbf {
    private Long id;

    private Long userId;

    private String positiveWords;

    private String nothingTheMatter;

    private String aboutFuture;

    private String importantThings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPositiveWords() {
        return positiveWords;
    }

    public void setPositiveWords(String positiveWords) {
        this.positiveWords = positiveWords == null ? null : positiveWords.trim();
    }

    public String getNothingTheMatter() {
        return nothingTheMatter;
    }

    public void setNothingTheMatter(String nothingTheMatter) {
        this.nothingTheMatter = nothingTheMatter == null ? null : nothingTheMatter.trim();
    }

    public String getAboutFuture() {
        return aboutFuture;
    }

    public void setAboutFuture(String aboutFuture) {
        this.aboutFuture = aboutFuture == null ? null : aboutFuture.trim();
    }

    public String getImportantThings() {
        return importantThings;
    }

    public void setImportantThings(String importantThings) {
        this.importantThings = importantThings == null ? null : importantThings.trim();
    }
}