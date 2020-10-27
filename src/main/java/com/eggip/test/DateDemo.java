package com.eggip.test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class DateDemo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.printf(getAllDaysBetween(now, next11(now)).toString());
    }

    private static List<LocalDate> getAllDaysBetween(LocalDate d1, LocalDate d2) {
        return LongStream.range(0, ChronoUnit.DAYS.between(d1, d2) + 1).mapToObj(i -> d1.plusDays(i)).collect(Collectors.toList());
    }

    public static LocalDate next11(LocalDate now) {
        return LocalDate.of(now.getYear() + 1, 11, 1);
    }
}
