package com.lysenko.entity;

public enum Status {
    ACITVE,
    FALSE;

    public static Status getValue(String source) {
        for (Status value : values()) {
            if (value.name().equals(source.toUpperCase()))
                return value;
        }
        return null;
    }
}
