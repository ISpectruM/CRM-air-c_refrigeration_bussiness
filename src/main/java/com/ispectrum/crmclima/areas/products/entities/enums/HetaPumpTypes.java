package com.ispectrum.crmclima.areas.products.entities.enums;

public enum HetaPumpTypes {
    GROUND("Земя"),
    AIRTOAIR("Въздух-въздух"),
    AIRTOWATER("Въздух-вода"),
    HYBRID("Хибрид");

    private final String DisplayName;

    HetaPumpTypes(String displayName) {
        DisplayName = displayName;
    }

    public String getDisplayName() {
        return DisplayName;
    }
}
