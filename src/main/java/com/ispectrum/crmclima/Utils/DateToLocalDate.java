package com.ispectrum.crmclima.Utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public final class DateToLocalDate {

    public static LocalDate convert(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
