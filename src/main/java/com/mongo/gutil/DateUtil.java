package com.mongo.gutil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    public static String PreviousDate(int noOfDays) {

        return LocalDate.now().minusDays(noOfDays).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }
}

