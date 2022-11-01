package com.homelibrary.aquisitions.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {

    @JsonProperty("name")
    private String name;

    @JsonProperty("key")
    private String key;

    private String authorId = key.substring(14, key.length() - 1);

    @Override
    public String toString() {
        return "Name: " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
