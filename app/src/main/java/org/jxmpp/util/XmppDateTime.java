package org.jxmpp.util;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.datepicker.UtcDates;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class XmppDateTime {
    private static final Pattern SECOND_FRACTION;
    private static final List<PatternCouplings> couplings;
    private static final DateFormatType dateFormatter;
    private static final Pattern datePattern;
    private static final DateFormatType dateTimeFormatter;
    private static final DateFormatType dateTimeNoMillisFormatter;
    private static final Pattern dateTimeNoMillisPattern;
    private static final Pattern dateTimePattern;
    private static final DateFormatType timeFormatter;
    private static final DateFormatType timeNoMillisFormatter;
    private static final DateFormatType timeNoMillisNoZoneFormatter;
    private static final Pattern timeNoMillisNoZonePattern;
    private static final Pattern timeNoMillisPattern;
    private static final DateFormatType timeNoZoneFormatter;
    private static final Pattern timeNoZonePattern;
    private static final Pattern timePattern;
    private static final DateFormat xep0091Date6DigitFormatter;
    private static final DateFormat xep0091Date7Digit1MonthFormatter;
    private static final DateFormat xep0091Date7Digit2MonthFormatter;
    private static final DateFormat xep0091Formatter;
    private static final Pattern xep0091Pattern;

    public enum DateFormatType {
        XEP_0082_DATE_PROFILE("yyyy-MM-dd"),
        XEP_0082_DATETIME_PROFILE("yyyy-MM-dd'T'HH:mm:ssZ"),
        XEP_0082_DATETIME_MILLIS_PROFILE("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
        XEP_0082_TIME_PROFILE("hh:mm:ss"),
        XEP_0082_TIME_ZONE_PROFILE("hh:mm:ssZ"),
        XEP_0082_TIME_MILLIS_PROFILE("hh:mm:ss.SSS"),
        XEP_0082_TIME_MILLIS_ZONE_PROFILE("hh:mm:ss.SSSZ"),
        XEP_0091_DATETIME("yyyyMMdd'T'HH:mm:ss");

        private final boolean CONVERT_TIMEZONE;
        private final DateFormat FORMATTER;
        private final String FORMAT_STRING;
        private final boolean HANDLE_MILLIS;

        DateFormatType(String str) {
            this.FORMAT_STRING = str;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            this.FORMATTER = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
            this.CONVERT_TIMEZONE = str.charAt(str.length() - 1) == 'Z';
            this.HANDLE_MILLIS = str.contains("SSS");
        }

        public String format(Date date) {
            String str;
            synchronized (this.FORMATTER) {
                str = this.FORMATTER.format(date);
            }
            return this.CONVERT_TIMEZONE ? XmppDateTime.convertRfc822TimezoneToXep82(str) : str;
        }

        public Date parse(String str) throws ParseException {
            Date date;
            if (this.CONVERT_TIMEZONE) {
                str = XmppDateTime.convertXep82TimezoneToRfc822(str);
            }
            if (this.HANDLE_MILLIS) {
                str = XmppDateTime.handleMilliseconds(str);
            }
            synchronized (this.FORMATTER) {
                date = this.FORMATTER.parse(str);
            }
            return date;
        }
    }

    public static class PatternCouplings {
        public final DateFormatType formatter;
        public final Pattern pattern;

        public PatternCouplings(Pattern pattern, DateFormatType dateFormatType) {
            this.pattern = pattern;
            this.formatter = dateFormatType;
        }
    }

    static {
        DateFormatType dateFormatType = DateFormatType.XEP_0082_DATE_PROFILE;
        dateFormatter = dateFormatType;
        Pattern patternCompile = Pattern.compile("^\\d+-\\d+-\\d+$");
        datePattern = patternCompile;
        DateFormatType dateFormatType2 = DateFormatType.XEP_0082_TIME_MILLIS_ZONE_PROFILE;
        timeFormatter = dateFormatType2;
        Pattern patternCompile2 = Pattern.compile("^(\\d+:){2}\\d+.\\d+(Z|([+-](\\d+:\\d+)))$");
        timePattern = patternCompile2;
        DateFormatType dateFormatType3 = DateFormatType.XEP_0082_TIME_MILLIS_PROFILE;
        timeNoZoneFormatter = dateFormatType3;
        Pattern patternCompile3 = Pattern.compile("^(\\d+:){2}\\d+.\\d+$");
        timeNoZonePattern = patternCompile3;
        DateFormatType dateFormatType4 = DateFormatType.XEP_0082_TIME_ZONE_PROFILE;
        timeNoMillisFormatter = dateFormatType4;
        Pattern patternCompile4 = Pattern.compile("^(\\d+:){2}\\d+(Z|([+-](\\d+:\\d+)))$");
        timeNoMillisPattern = patternCompile4;
        DateFormatType dateFormatType5 = DateFormatType.XEP_0082_TIME_PROFILE;
        timeNoMillisNoZoneFormatter = dateFormatType5;
        Pattern patternCompile5 = Pattern.compile("^(\\d+:){2}\\d+$");
        timeNoMillisNoZonePattern = patternCompile5;
        DateFormatType dateFormatType6 = DateFormatType.XEP_0082_DATETIME_MILLIS_PROFILE;
        dateTimeFormatter = dateFormatType6;
        Pattern patternCompile6 = Pattern.compile("^\\d+(-\\d+){2}+T(\\d+:){2}\\d+.\\d+(Z|([+-](\\d+:\\d+)))?$");
        dateTimePattern = patternCompile6;
        DateFormatType dateFormatType7 = DateFormatType.XEP_0082_DATETIME_PROFILE;
        dateTimeNoMillisFormatter = dateFormatType7;
        Pattern patternCompile7 = Pattern.compile("^\\d+(-\\d+){2}+T(\\d+:){2}\\d+(Z|([+-](\\d+:\\d+)))?$");
        dateTimeNoMillisPattern = patternCompile7;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ss");
        xep0091Formatter = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMd'T'HH:mm:ss");
        xep0091Date6DigitFormatter = simpleDateFormat2;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyyMdd'T'HH:mm:ss");
        xep0091Date7Digit1MonthFormatter = simpleDateFormat3;
        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyyMMd'T'HH:mm:ss");
        xep0091Date7Digit2MonthFormatter = simpleDateFormat4;
        xep0091Pattern = Pattern.compile("^\\d+T\\d+:\\d+:\\d+$");
        ArrayList arrayList = new ArrayList();
        couplings = arrayList;
        TimeZone timeZone = TimeZone.getTimeZone(UtcDates.UTC);
        simpleDateFormat.setTimeZone(timeZone);
        simpleDateFormat2.setTimeZone(timeZone);
        simpleDateFormat3.setTimeZone(timeZone);
        simpleDateFormat3.setLenient(false);
        simpleDateFormat4.setTimeZone(timeZone);
        simpleDateFormat4.setLenient(false);
        arrayList.add(new PatternCouplings(patternCompile, dateFormatType));
        arrayList.add(new PatternCouplings(patternCompile6, dateFormatType6));
        arrayList.add(new PatternCouplings(patternCompile7, dateFormatType7));
        arrayList.add(new PatternCouplings(patternCompile2, dateFormatType2));
        arrayList.add(new PatternCouplings(patternCompile3, dateFormatType3));
        arrayList.add(new PatternCouplings(patternCompile4, dateFormatType4));
        arrayList.add(new PatternCouplings(patternCompile5, dateFormatType5));
        SECOND_FRACTION = Pattern.compile(".*\\.(\\d{1,})(Z|((\\+|-)\\d{4}))");
    }

    public static String asString(TimeZone timeZone) {
        int rawOffset = timeZone.getRawOffset();
        int i = rawOffset / 3600000;
        return String.format("%+d:%02d", Integer.valueOf(i), Integer.valueOf(Math.abs((rawOffset / 60000) - (i * 60))));
    }

    public static String convertRfc822TimezoneToXep82(String str) {
        int length = str.length();
        int i = length - 2;
        return (str.substring(0, i) + ':') + str.substring(i, length);
    }

    public static String convertXep82TimezoneToRfc822(String str) {
        return str.charAt(str.length() + (-1)) == 'Z' ? str.replace("Z", "+0000") : str.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
    }

    private static Calendar determineNearestDate(final Calendar calendar, List<Calendar> list) {
        Collections.sort(list, new Comparator<Calendar>() { // from class: org.jxmpp.util.XmppDateTime.1
            @Override // java.util.Comparator
            public int compare(Calendar calendar2, Calendar calendar3) {
                return new Long(calendar.getTimeInMillis() - calendar2.getTimeInMillis()).compareTo(new Long(calendar.getTimeInMillis() - calendar3.getTimeInMillis()));
            }
        });
        return list.get(0);
    }

    private static List<Calendar> filterDatesBefore(Calendar calendar, Calendar... calendarArr) {
        ArrayList arrayList = new ArrayList();
        for (Calendar calendar2 : calendarArr) {
            if (calendar2 != null && calendar2.before(calendar)) {
                arrayList.add(calendar2);
            }
        }
        return arrayList;
    }

    public static String formatXEP0082Date(Date date) {
        String str;
        DateFormatType dateFormatType = dateTimeFormatter;
        synchronized (dateFormatType) {
            str = dateFormatType.format(date);
        }
        return str;
    }

    private static Date handleDateWithMissingLeadingZeros(String str, int i) throws ParseException {
        Date date;
        if (i == 6) {
            DateFormat dateFormat = xep0091Date6DigitFormatter;
            synchronized (dateFormat) {
                date = dateFormat.parse(str);
            }
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        List<Calendar> listFilterDatesBefore = filterDatesBefore(calendar, parseXEP91Date(str, xep0091Date7Digit1MonthFormatter), parseXEP91Date(str, xep0091Date7Digit2MonthFormatter));
        if (listFilterDatesBefore.isEmpty()) {
            return null;
        }
        return determineNearestDate(calendar, listFilterDatesBefore).getTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String handleMilliseconds(String str) {
        int length;
        Matcher matcher = SECOND_FRACTION.matcher(str);
        if (!matcher.matches() || (length = matcher.group(1).length()) == 3) {
            return str;
        }
        int iIndexOf = str.indexOf(".");
        StringBuilder sb = new StringBuilder((str.length() - length) + 3);
        if (length > 3) {
            sb.append(str.substring(0, iIndexOf + 4));
        } else {
            sb.append(str.substring(0, iIndexOf + length + 1));
            for (int i = length; i < 3; i++) {
                sb.append('0');
            }
        }
        sb.append(str.substring(iIndexOf + length + 1));
        return sb.toString();
    }

    public static Date parseDate(String str) throws ParseException {
        Date date;
        if (xep0091Pattern.matcher(str).matches()) {
            int length = str.split(ExifInterface.GPS_DIRECTION_TRUE)[0].length();
            if (length >= 8) {
                DateFormat dateFormat = xep0091Formatter;
                synchronized (dateFormat) {
                    date = dateFormat.parse(str);
                }
                return date;
            }
            Date dateHandleDateWithMissingLeadingZeros = handleDateWithMissingLeadingZeros(str, length);
            if (dateHandleDateWithMissingLeadingZeros != null) {
                return dateHandleDateWithMissingLeadingZeros;
            }
        }
        return parseXEP0082Date(str);
    }

    public static Date parseXEP0082Date(String str) throws ParseException {
        Date date;
        for (PatternCouplings patternCouplings : couplings) {
            if (patternCouplings.pattern.matcher(str).matches()) {
                return patternCouplings.formatter.parse(str);
            }
        }
        DateFormatType dateFormatType = dateTimeNoMillisFormatter;
        synchronized (dateFormatType) {
            date = dateFormatType.parse(str);
        }
        return date;
    }

    private static Calendar parseXEP91Date(String str, DateFormat dateFormat) {
        Calendar calendar;
        try {
            synchronized (dateFormat) {
                dateFormat.parse(str);
                calendar = dateFormat.getCalendar();
            }
            return calendar;
        } catch (ParseException unused) {
            return null;
        }
    }
}
