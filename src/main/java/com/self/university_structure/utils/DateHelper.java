package com.self.university_structure.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    public static LocalDate convertStringToDate(String date, String pattern) {
        var localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
        return localDate;
    }

    public static String convertDateToString(LocalDate date,String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String dateString = date.format(formatter);
        return dateString;
    }

    public static String convertDateTimeToString(LocalDateTime date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}
