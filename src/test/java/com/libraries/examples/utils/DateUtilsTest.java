package com.libraries.examples.utils;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateUtilsTest {

    @Test
    void formatLocalDateToString() {
        LocalDate localDate = LocalDate.of(2021,06,28);
        assertEquals("", DateUtils.formatLocalDateToString(null));
        assertEquals("28-06-2021", DateUtils.formatLocalDateToString(localDate));
    }

    @Test
    void formatLocalDateTimeToString() {
        LocalDateTime localDateTime = LocalDateTime.of(2021,06,28,17,36,00);
        assertEquals("", DateUtils.formatLocalDateTimeToString(null));
        assertEquals("28-06-2021 17:36:00", DateUtils.formatLocalDateTimeToString(localDateTime));
    }

    @Test
    void formatInstantToString() {
        var patternDDMMYYYY = "dd-MM-yyyy";
        var patternDDMMYYYYHHMMSS = "dd-MM-yyyy HH:mm:ss";
        Instant instant = Instant.parse("2021-06-28T10:37:30.00Z");
        assertEquals("", DateUtils.formatInstantToString(null, patternDDMMYYYY));
        assertEquals("28-06-2021", DateUtils.formatInstantToString(instant, patternDDMMYYYY));
        assertEquals("28-06-2021 07:37:30", DateUtils.formatInstantToString(instant, patternDDMMYYYYHHMMSS));
    }

    @Test
    void fomatDateToString() {
        Instant instant = Instant.parse("2021-06-28T10:37:30.00Z");
        Date date = Date.from(instant);
        assertEquals("", DateUtils.formatDateToString(null));
        assertEquals("28-06-2021", DateUtils.formatDateToString(date));
    }
}