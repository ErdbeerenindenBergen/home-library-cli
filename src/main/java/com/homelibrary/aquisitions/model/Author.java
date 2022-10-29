package com.homelibrary.aquisitions.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {

    @JsonProperty("name")
    private String name;

    @JsonProperty("key")
    private String key;

    @Override
    public String toString() {
        return "Name: " + name;
    }

    public String getName() {
        return name;
    }
}
