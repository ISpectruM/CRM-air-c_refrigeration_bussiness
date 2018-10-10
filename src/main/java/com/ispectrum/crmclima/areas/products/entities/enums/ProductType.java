package com.ispectrum.crmclima.areas.products.entities.enums;

public enum ProductType {
    AIRCONDS("Климатик"),
    COOLERS("Изпарителни охладители"),
    FRIDGES("Хладилник/фризер"),
    CAMERAS("Хладилна камера"),
    HEATPUMPS("Термо помпи"),
    DEHUMIDIFIER("Влагоуловител"),
    OTHERS("Друго");

    private final String displayName;

    ProductType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
