package com.ispectrum.crmclima.areas.products.entities.enums;

public enum AircType {
    SPLIT ("Сплит"),
    MULTISPLIT ("Мултисплит");

    private final String displayName;

    AircType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
