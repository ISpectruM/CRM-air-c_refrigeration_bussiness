package com.ispectrum.crmclima.areas.orders.entities.enums;

public enum ProphylacticType {
    PROPHYLACTIC("Профилактика"),
    LAUNCH("Пускане");

    private final String displayName;

    ProphylacticType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
