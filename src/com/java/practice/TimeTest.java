package com.java.practice;

import java.time.LocalDate;
import java.time.MonthDay;

public class TimeTest {

    public static void main(String[] args) {
        printLocalDate();
        printSpecialDate();
        compareDifferentDate();
        compareSameDate();
        checkDuplicateDate();
    }
    
    public static void printLocalDate() {
        LocalDate today = LocalDate.now();
        System.out.println(today.toString());
    }

    public static void printSpecialDate() {
        LocalDate date = LocalDate.of(1999, 11, 03);
        System.out.println(date.toString());
    }
    
    public static void compareDifferentDate() {
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.of(1999, 11, 03);
        System.out.println(today.equals(date));
    }
    
    public static void compareSameDate() {
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.of(2018, 10, 8);
        System.out.println(today.equals(date));
    }
    
    public static void checkDuplicateDate() {
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.of(1999, 10, 7);
        MonthDay birthday = MonthDay.of(date.getMonthValue(), date.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);
        System.out.println(currentMonthDay.equals(birthday));
    }
    
}
