package com.ispectrum.crmclima.areas.locations.entities.enums;

public enum Cities {
    POMORIE("Поморие"),

    BURGAS("Бургас"),

    KAMENAR("Каменар"),

    SARAFOVO("Сарафово"),

    KABLESHKOVO("Каблешково"),

    SL_BRYAG("Сл.Бряг"),

    NESSEBAR("Несебър"),

    VLAS("Влас"),

    RAVDA("Равда"),

    ACHELOY("Ахелой");

    private final String displayName;

    Cities(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
