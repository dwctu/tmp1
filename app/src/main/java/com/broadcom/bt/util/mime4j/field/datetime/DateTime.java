package com.broadcom.bt.util.mime4j.field.datetime;

import com.broadcom.bt.util.mime4j.field.datetime.parser.DateTimeParser;
import com.broadcom.bt.util.mime4j.field.datetime.parser.ParseException;
import com.broadcom.bt.util.mime4j.field.datetime.parser.TokenMgrError;
import java.io.StringReader;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class DateTime {
    private final Date date;
    private final int day;
    private final int hour;
    private final int minute;
    private final int month;
    private final int second;
    private final int timeZone;
    private final int year;

    public DateTime(String str, int i, int i2, int i3, int i4, int i5, int i6) throws NumberFormatException {
        int iConvertToYear = convertToYear(str);
        this.year = iConvertToYear;
        this.date = convertToDate(iConvertToYear, i, i2, i3, i4, i5, i6);
        this.month = i;
        this.day = i2;
        this.hour = i3;
        this.minute = i4;
        this.second = i5;
        this.timeZone = i6;
    }

    public static Date convertToDate(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT+0"));
        gregorianCalendar.set(i, i2 - 1, i3, i4, i5, i6);
        gregorianCalendar.set(14, 0);
        if (i7 != Integer.MIN_VALUE) {
            gregorianCalendar.add(12, (((i7 / 100) * 60) + (i7 % 100)) * (-1));
        }
        return gregorianCalendar.getTime();
    }

    private int convertToYear(String str) throws NumberFormatException {
        int i = Integer.parseInt(str);
        int length = str.length();
        return (length == 1 || length == 2) ? (i < 0 || i >= 50) ? i + 1900 : i + 2000 : length != 3 ? i : i + 1900;
    }

    public static DateTime parse(String str) throws ParseException {
        try {
            return new DateTimeParser(new StringReader(str)).parseAll();
        } catch (TokenMgrError e) {
            throw new ParseException(e.getMessage());
        }
    }

    public Date getDate() {
        return this.date;
    }

    public int getDay() {
        return this.day;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getMonth() {
        return this.month;
    }

    public int getSecond() {
        return this.second;
    }

    public int getTimeZone() {
        return this.timeZone;
    }

    public int getYear() {
        return this.year;
    }

    public void print() {
        System.out.println(getYear() + " " + getMonth() + " " + getDay() + "; " + getHour() + " " + getMinute() + " " + getSecond() + " " + getTimeZone());
    }
}
