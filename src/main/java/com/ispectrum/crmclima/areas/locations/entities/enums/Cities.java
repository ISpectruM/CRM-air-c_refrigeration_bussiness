package com.ispectrum.crmclima.areas.locations.entities.enums;

public enum Cities {
    POMORIE("гр.Поморие"),
    BURGAS("гр.Бургас"),
    SL_BRYAG("Сл.Бряг"),
    NESSEBAR("гр.Несебър"),
    ACHELOY("гр.Ахелой"),
    KABLESHKOVO("с.Каблешково"),
    VLAS("КК Св.Влас"),
    RAVDA("с.Равда"),
    KAMENAR("с.Каменар"),
    SARAFOVO("кв.Сарафово"),
    STRACIN("с.Страцин"),
    MEDOVO("с.Медово"),
    LUKA("с.Лъка"),
    BATA("с.Бата"),
    KOSOVEC("с.Косовец"),
    DUBNIK("с.Дъбник"),
    GABEROVO("с.Габерово"),
    ALEXANDROVO("с.Александрово"),
    GORITSA("с.Горица"),
    POROY("с.Порой"),
    GULUBETS("с.Гълъбец"),
    BELODOL("с.Белодол");

    private final String displayName;

    Cities(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
