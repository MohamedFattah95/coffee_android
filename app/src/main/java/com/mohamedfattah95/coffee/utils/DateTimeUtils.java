package com.mohamedfattah95.coffee.utils;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtils {
    public static final String TIME_24 = "HH:mm";
    public static final String TIME_12 = "hh:mm a";
    public static final String DAY_MONTH_YEAR = "dd/MM/yyyy";
    public static final String DAY_MONTH2_YEAR = "dd/MMM/yyyy";
    public static final String DAY_MONTH3_YEAR = "dd.MM.yyyy";
    public static final String DAY_MONTH4_YEAR = "dd.MM.yyyy HH:mm";
    public static final String MONTH_DAY_YEAR = "MM/dd/yyyy";
    public static final String WEEKDAY_DAY_MOTH_YEAR = "EEEE dd MMM yyyy";
    public static final String ISO_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DAY_MONTH_YEAR_SPACE = "dd MMM yyyy";
    public static final String DAY_MONTH_YEAR_TIME = "dd MMM yyyy, HH:mm a";
    public static final String DAY_MONTH = "dd";

    public static final String MONTH = "MMM";

    public static Calendar getDateFromSeconds(long seconds) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(seconds * 1000L);
        cal.setTimeZone( TimeZone.getTimeZone("GMT"));
        return cal;
    }

    public static String getTimeFromIsoDate(String input, String format, Locale locale) {
        try {
            Date date = new SimpleDateFormat(ISO_DATE_TIME_FORMAT, locale).parse(input);
            Log.d("testInput", input);
            Calendar calendar = getDateFromSeconds(date.getTime());

            Log.d("testDateFormat", formatDate(calendar, format, locale));
            return formatDate(calendar, format, locale);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getTimeStampByLocale(String input, String format, Locale locale) {

        try {
            Date date = new SimpleDateFormat(format, locale).parse(input);
            Log.d("testInput", input);
            Calendar calendar = getDateFromSeconds(date.getTime());

            Log.d("testDateFormat", formatDate(calendar, format, locale));
            return formatDate(calendar, format, locale);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getDateFromTimeStamp(String timeStamp, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date netDate = (new Date(Long.parseLong(timeStamp) * 1000));
            return sdf.format(netDate);
        } catch (Exception ex) {
            return "xx";
        }
    }

    public static String getDateFromTimeStamp(String timeStamp, String format, Locale locale) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
            Date netDate = (new Date(Long.parseLong(timeStamp) * 1000));
            return sdf.format(netDate);
        } catch (Exception ex) {
            return "xx";
        }
    }

    public static String getDateFromString(String dateInString, String actualformat, String exceptedFormat) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        SimpleDateFormat form = new SimpleDateFormat(actualformat);

        String formatedDate = null;
        Date date;
        try {
            date = form.parse(dateInString);
            SimpleDateFormat postFormater = new SimpleDateFormat(exceptedFormat);
            formatedDate = postFormater.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatedDate;
    }


    public static String formatTimeStamp(String dateInString, String expectedFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(expectedFormat);
        String dateString = formatter.format(new Date(Long.parseLong(dateInString) * 1000));
        return dateString;
    }


    public static String formatDate(Calendar cal, String format, Locale locale) {
         TimeZone tz = Calendar.getInstance().getTimeZone();
        SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(cal.getTime());
    }

    public static Long getFirstDayOfMonthInSeconds(Calendar cal) {
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTimeInMillis() / 1000;
    }

    public static Long getLastDayOfMonthInSeconds(Calendar cal) {
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTimeInMillis() / 1000;
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }

    public static String formatDateFromSeconds(long seconds, String format, Locale locale) {
        Calendar cal = getDateFromSeconds(seconds);
        return formatDate(cal, format, locale);
    }

    public static boolean isToday(Calendar cal) {
        return isSameDay(cal, Calendar.getInstance());
    }
}