package com.libraries.examples.utils;

import org.springframework.util.ObjectUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    private static final String FORMAT_DATE = "dd-MM-yyyy";
    private static final String FORMAT_DATE_TIME = "dd-MM-yyyy HH:mm:ss";

    /**
     * localDate to String dd-MM-yyyy
     * @return localDate in String format dd-MM-yyyy
     */
    public static String formatLocalDateToString(LocalDate localDate){
        if(ObjectUtils.isEmpty(localDate)){
            return "";
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        return localDate.format(dateTimeFormatter);
    }

    /**
     * localDateTime to String dd-MM-yyyy HH:mm:ss
     * @return localDateTime in String format dd-MM-yyyy HH:mm:ss
     */
    public static String formatLocalDateTimeToString(LocalDateTime localDateTime){
        if(ObjectUtils.isEmpty(localDateTime)){
            return "";
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_DATE_TIME);
        return localDateTime.format(dateTimeFormatter);
    }

    /**
     * instant to String
     * @return instant in String
     */
    public static String formatInstantToString(Instant instant, String formatPattern){
        if(ObjectUtils.isEmpty(instant)){
            return "";
        }
        return DateTimeFormatter.ofPattern(formatPattern)
                .withZone(ZoneId.systemDefault()).format(instant);
    }

    /**
     * date to String dd-MM-yyyy
     * @return date in String format dd-MM-yyyy
     */
    public static String formatDateToString(Date date){
        if(ObjectUtils.isEmpty(date)){
            return "";
        }
        DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
        return dateFormat.format(date);

    }
}
