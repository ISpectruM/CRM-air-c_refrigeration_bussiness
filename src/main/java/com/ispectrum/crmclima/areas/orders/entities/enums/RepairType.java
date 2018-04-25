package com.ispectrum.crmclima.areas.orders.entities.enums;

public enum RepairType {
    REPAIR("Ремонт"),
    MOVING("Преместване"),
    DISASSEMBLY("Демонтаж");

    private final String displayName;

    RepairType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    }
