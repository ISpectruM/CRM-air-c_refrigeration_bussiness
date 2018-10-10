package com.ispectrum.crmclima.areas.locations.entities.enums;

public enum Cities {
    POMORIE("гр.Поморие", "Поморие"),
    BURGAS("гр.Бургас", "Бургас"),
    SL_BRYAG("Сл.Бряг", "Несебър"),
    NESSEBAR("гр.Несебър", "Несебър"),
    ACHELOY("гр.Ахелой", "Поморие"),
    KABLESHKOVO("с.Каблешково", "Поморие"),
    VLAS("КК Св.Влас", "Несебър"),
    RAVDA("с.Равда", "Несебър"),
    KAMENAR("с.Каменар", "Поморие"),
    SARAFOVO("кв.Сарафово", "Бургас"),
    STRACIN("с.Страцин", "Селата"),
    MEDOVO("с.Медово", "Селата"),
    LUKA("с.Лъка", "Селата"),
    BATA("с.Бата", "Селата"),
    KOSOVEC("с.Косовец", "Селата"),
    DUBNIK("с.Дъбник", "Селата"),
    GABEROVO("с.Габерово", "Селата"),
    ALEXANDROVO("с.Александрово", "Селата"),
    GORITSA("с.Горица", "Селата"),
    POROY("с.Порой", "Селата"),
    GULUBETS("с.Гълъбец", "Селата"),
    BELODOL("с.Белодол", "Селата"),
    OTHER("Друг", "Друг");
    ;

    private final String displayName;
    private final String area;

    Cities(String displayName, String area) {
        this.displayName = displayName;
        this.area = area;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getArea() {
        return area;
    }
}
