package com.ispectrum.crmclima.Utils;

import com.ispectrum.crmclima.areas.orders.models.bindingModels.BaseOrderBindingModel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public final class DateToLocalDate {

    public static LocalDate convert(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static LocalDate convert(String date){
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern(
                "yyyy-MM-dd", Locale.getDefault());
        return LocalDate.parse(date, formatter);
    }

    public static <T extends BaseOrderBindingModel> LocalDate setLocalDate(T model) {
        Date orderDate = model.getOrderDate();
        LocalDate localDate = LocalDate.now();
        if (orderDate != null){
            localDate = convert(orderDate);
        }
        return localDate;
    }
}
