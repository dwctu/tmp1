package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: CalendarDateTimeParser.java */
/* renamed from: com.huawei.hms.scankit.p.zb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0423zb {
    private static final Pattern a = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})T(\\d{2})(\\d{2})(\\d{2})Z");
    private static final Pattern b = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})T(\\d{2})(\\d{2})(\\d{2})");
    private static final Pattern c = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})");
    private static final Pattern d = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})\\d{6}Z");

    public static void a(String str, HmsScan.EventTime eventTime) {
        Matcher matcher = a.matcher(str);
        Matcher matcher2 = b.matcher(str);
        Matcher matcher3 = c.matcher(str);
        Matcher matcher4 = d.matcher(str);
        try {
            if (matcher.matches()) {
                a(eventTime, Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
                b(eventTime, Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
                eventTime.isUTCTime = true;
                eventTime.originalValue = str;
            } else if (matcher2.matches()) {
                a(eventTime, Integer.parseInt(matcher2.group(1)), Integer.parseInt(matcher2.group(2)), Integer.parseInt(matcher2.group(3)));
                b(eventTime, Integer.parseInt(matcher2.group(4)), Integer.parseInt(matcher2.group(5)), Integer.parseInt(matcher2.group(6)));
                eventTime.originalValue = str;
            } else if (matcher3.matches()) {
                a(eventTime, Integer.parseInt(matcher3.group(1)), Integer.parseInt(matcher3.group(2)), Integer.parseInt(matcher3.group(3)));
                eventTime.originalValue = str;
            } else if (matcher4.matches()) {
                a(eventTime, Integer.parseInt(matcher4.group(1)), Integer.parseInt(matcher4.group(2)), Integer.parseInt(matcher4.group(3)));
            }
        } catch (NullPointerException unused) {
            com.huawei.hms.scankit.util.a.b("exception", "NullPointerException");
        }
    }

    private static void b(HmsScan.EventTime eventTime, int i, int i2, int i3) {
        eventTime.hours = i;
        eventTime.minutes = i2;
        eventTime.seconds = i3;
    }

    private static void a(HmsScan.EventTime eventTime, int i, int i2, int i3) {
        eventTime.year = i;
        eventTime.month = i2;
        eventTime.day = i3;
    }
}
