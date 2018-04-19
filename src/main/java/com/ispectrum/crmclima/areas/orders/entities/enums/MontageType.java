package com.ispectrum.crmclima.areas.orders.entities.enums;

public enum MontageType {
    MONTAGE("Монтаж"),
    OVERVIEW("Оглед"),
    OFFER("Оферта");

    private final String displayName;

    MontageType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
