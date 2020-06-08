package com.ispectrum.crmclima.areas.products.entities.enums;

public enum SplitType {
    SPLIT ("Сплит"),
    MULTISPLIT ("Мултисплит");

    private final String displayName;

    SplitType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
