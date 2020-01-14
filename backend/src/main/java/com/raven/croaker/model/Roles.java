package com.raven.croaker.model;

public enum Roles {
    USER("USER"),
    ADMIN("ADMIN");

    private String name;

    private Roles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
