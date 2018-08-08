package com.ispectrum.crmclima.areas.orders.entities.enums;

public enum ProphylacticType {
    PROPHYLACTIC("Профилактика"),
    WARRANTY_PROPHYLACTIC("Гаранционна профилактика"),
    LAUNCH("Пускане на съоръжения");

    private final String displayName;

    ProphylacticType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
