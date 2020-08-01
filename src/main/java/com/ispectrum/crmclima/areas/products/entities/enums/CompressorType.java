package com.ispectrum.crmclima.areas.products.entities.enums;

public enum CompressorType {
    INVERTER("Инвертор"),
    ON_OFF("ON/OFF");

    private final String displayName;

    CompressorType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
