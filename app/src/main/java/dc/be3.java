package dc;

import android.content.Context;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.lovense.wear.R;
import com.wear.activity.orgySetting.OrgySetting;
import com.wear.util.WearUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: DateUtils.java */
/* loaded from: classes4.dex */
public class be3 {
    public static DateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static DateFormat b = new SimpleDateFormat("yyyy-MM-dd");
    public static DateFormat c = new SimpleDateFormat("yyyy-MM");
    public static SimpleDateFormat d = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat e = new SimpleDateFormat("HH:mm:ss");
    public static SimpleDateFormat f = new SimpleDateFormat("hh:mm");
    public static DateFormat g;
    public static DateFormat h;
    public static DateFormat i;
    public static DateFormat j;
    public static DateFormat k;
    public static DateFormat l;
    public static DateFormat m;
    public static DateFormat n;
    public static DateFormat o;
    public static DateFormat p;
    public static DateFormat q;
    public static DateFormat r;
    public static DateFormat s;

    static {
        new SimpleDateFormat("hh:mm a");
        g = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        h = new SimpleDateFormat("dd MMMM yyyy");
        i = new SimpleDateFormat("yyyy-MM-dd");
        j = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        k = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        l = new SimpleDateFormat("yyyyMMdd");
        m = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        new SimpleDateFormat("HH:mm:ss MMM d, yyyy");
        DateFormat.getDateInstance(2, Locale.getDefault());
        n = new SimpleDateFormat("yyyy");
        o = new SimpleDateFormat("MM");
        p = new SimpleDateFormat("dd");
        q = new SimpleDateFormat("HH");
        r = new SimpleDateFormat("mm");
        new SimpleDateFormat("dd HH:mm:ss");
        s = new SimpleDateFormat("EEEE");
    }

    public static boolean A(Context context) {
        return android.text.format.DateFormat.is24HourFormat(context);
    }

    public static boolean B(Date date, Date date2, int i2) {
        return date2.getTime() - date.getTime() <= ((long) ((i2 * 60) * 1000));
    }

    public static boolean C(Date date, Date date2, int i2) {
        return date2.getTime() - date.getTime() <= ((long) ((i2 * 1) * 1000));
    }

    public static boolean D() {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.set(1, 2023);
        calendar.set(2, 1);
        calendar.set(5, 7);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(5, 16);
        return timeInMillis <= System.currentTimeMillis() && calendar.getTimeInMillis() > System.currentTimeMillis();
    }

    public static boolean E(Date date, int i2) {
        return i2 == 2 && I().getTime() - date.getTime() <= 1800000;
    }

    public static boolean F(Date date, Date date2) {
        return date.getTime() >= e(date2).getTime() && date.getTime() <= f(date2).getTime();
    }

    public static boolean G(Date date) {
        if (date == null) {
            date = I();
        }
        return F(date, I());
    }

    public static String H(long j2) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date(j2)).substring(10);
    }

    public static Date I() {
        return new Date();
    }

    public static void J() {
        a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        b = new SimpleDateFormat("yyyy-MM-dd");
        c = new SimpleDateFormat("yyyy-MM");
        d = new SimpleDateFormat("HH:mm");
        new SimpleDateFormat("hh:mm a");
        g = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        h = new SimpleDateFormat("dd MMMM yyyy");
        i = new SimpleDateFormat("yyyy-MM-dd");
        j = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        k = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat.getDateInstance(2, Locale.ENGLISH);
        n = new SimpleDateFormat("yyyy");
        o = new SimpleDateFormat("MM");
        p = new SimpleDateFormat("dd");
        q = new SimpleDateFormat("HH");
        r = new SimpleDateFormat("mm");
        s = new SimpleDateFormat("EEEE");
        new SimpleDateFormat("ddd HH:mm:ss");
        m = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
    }

    public static long[] K(int i2) {
        long j2 = i2 / SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT;
        long j3 = i2 - (3600 * j2);
        long j4 = j3 / 60;
        return new long[]{j2, j4, j3 - (60 * j4)};
    }

    public static long a(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            date = new Date();
        }
        calendar.setTime(date);
        return calendar.getTimeInMillis() + 1;
    }

    public static Date b(Date date) {
        return new Date(a(date));
    }

    public static String c(String str, Context context) {
        if (!WearUtils.e1(str) && str.indexOf(SignatureImpl.INNER_SEP) > 0 && context != null) {
            try {
                Date date = d.parse(str);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(date.getTime());
                if (calendar.get(9) == 0) {
                    str = f.format(date) + " " + ah4.e(R.string.app_hourformat_12_am);
                } else {
                    str = f.format(date) + " " + ah4.e(R.string.app_hourformat_12_pm);
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static long d(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            date = new Date();
        }
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    public static Date e(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            date = new Date();
        }
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date f(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            date = new Date();
        }
        calendar.setTime(date);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTime();
    }

    public static String g(long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Date date = new Date(jCurrentTimeMillis);
        long hours = jCurrentTimeMillis - (((((date.getHours() * 60) * 60) + (date.getMinutes() * 60)) + date.getSeconds()) * 1000);
        if (j2 >= hours) {
            return H(j2);
        }
        if (j2 < hours - OrgySetting.ONE_HOURE_MSEC) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date(j2));
        }
        return ah4.e(R.string.yesterday) + " " + H(j2);
    }

    public static String h(long j2) {
        long j3 = j2 / 86400000;
        long j4 = j2 - (86400000 * j3);
        long j5 = j4 / 3600000;
        long j6 = j4 - (3600000 * j5);
        long j7 = j6 / 60000;
        long j8 = (j6 - (60000 * j7)) / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append(j3);
        sb.append("d ");
        sb.append(j5 < 10 ? "0" : "");
        sb.append(j5);
        sb.append(SignatureImpl.INNER_SEP);
        sb.append(j7 < 10 ? "0" : "");
        sb.append(j7);
        sb.append(SignatureImpl.INNER_SEP);
        sb.append(j8 >= 10 ? "" : "0");
        sb.append(j8);
        return sb.toString();
    }

    public static String i(DateFormat dateFormat, Date date) {
        if (dateFormat == null || date == null) {
            return null;
        }
        try {
            return dateFormat.format(date);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Date j(String str, DateFormat dateFormat) {
        if (!WearUtils.e1(str) && dateFormat != null) {
            try {
                return dateFormat.parse(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String k(int i2) {
        String str;
        int i3 = i2 / 60;
        int i4 = i2 % 60;
        if (i3 < 10) {
            str = "0" + i3;
        } else {
            str = "" + i3;
        }
        if (i4 < 10) {
            return str + ":0" + i4;
        }
        return str + SignatureImpl.INNER_SEP + i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String l(long r13) {
        /*
            r0 = 86400000(0x5265c00, double:4.2687272E-316)
            long r2 = r13 / r0
            long r2 = r2 * r0
            long r13 = r13 - r2
            r0 = 3600000(0x36ee80, double:1.7786363E-317)
            long r2 = r13 / r0
            long r0 = r0 * r2
            long r13 = r13 - r0
            r0 = 60000(0xea60, double:2.9644E-319)
            long r4 = r13 / r0
            long r0 = r0 * r4
            long r13 = r13 - r0
            r0 = 1000(0x3e8, double:4.94E-321)
            long r13 = r13 / r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            java.lang.String r6 = "0"
            java.lang.String r7 = ":"
            r8 = 10
            int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r10 >= 0) goto L3d
            r10 = 0
            int r12 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r12 != 0) goto L34
            r2 = r1
            goto L4c
        L34:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r6)
            goto L42
        L3d:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
        L42:
            r10.append(r2)
            r10.append(r7)
            java.lang.String r2 = r10.toString()
        L4c:
            r0.append(r2)
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 >= 0) goto L55
            r2 = r6
            goto L56
        L55:
            r2 = r1
        L56:
            r0.append(r2)
            r0.append(r4)
            r0.append(r7)
            int r2 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r2 >= 0) goto L64
            r1 = r6
        L64:
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.be3.l(long):java.lang.String");
    }

    public static String m(DateFormat dateFormat) {
        String str;
        try {
            str = dateFormat.format(I());
        } catch (Exception unused) {
            str = null;
        }
        return WearUtils.e1(str) ? "" : str;
    }

    public static String n() {
        String str;
        try {
            str = k.format(I());
        } catch (Exception unused) {
            str = null;
        }
        return WearUtils.e1(str) ? "" : str;
    }

    public static String o() {
        return "" + ((TimeZone.getDefault().getRawOffset() / 3600000) + (TimeZone.getDefault().inDaylightTime(new Date()) ? 1 : 0));
    }

    public static Date p(int i2, Date date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(q(i2, date));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String q(int i2, Date date) {
        if (i2 > 13 || i2 < -12) {
            i2 = 0;
        }
        int i3 = i2 * 60 * 60 * 1000;
        String[] availableIDs = TimeZone.getAvailableIDs(i3);
        TimeZone timeZone = availableIDs.length == 0 ? TimeZone.getDefault() : new SimpleTimeZone(i3, availableIDs[0]);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(timeZone);
        if (date == null) {
            date = new Date();
        }
        return simpleDateFormat.format(date);
    }

    public static long r() {
        return System.currentTimeMillis();
    }

    public static long s(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        return date.getTime();
    }

    public static String t(int i2) {
        switch (i2) {
            case 0:
                return ah4.e(R.string.birthday_month_jan);
            case 1:
                return ah4.e(R.string.birthday_month_feb);
            case 2:
                return ah4.e(R.string.birthday_month_mar);
            case 3:
                return ah4.e(R.string.birthday_month_apr);
            case 4:
                return ah4.e(R.string.birthday_month_may);
            case 5:
                return ah4.e(R.string.birthday_month_jun);
            case 6:
                return ah4.e(R.string.birthday_month_jul);
            case 7:
                return ah4.e(R.string.birthday_month_aug);
            case 8:
                return ah4.e(R.string.birthday_month_sept);
            case 9:
                return ah4.e(R.string.birthday_month_oct);
            case 10:
                return ah4.e(R.string.birthday_month_nov);
            case 11:
                return ah4.e(R.string.birthday_month_dec);
            default:
                return "";
        }
    }

    public static Date u() {
        return new Date();
    }

    public static String v() {
        String strValueOf = "";
        try {
            int offset = TimeZone.getDefault().getOffset(new Date().getTime()) / 3600000;
            if (offset > 0) {
                strValueOf = "+" + offset;
            } else {
                strValueOf = String.valueOf(offset);
            }
            String str = "Time zone=" + strValueOf;
        } catch (Exception unused) {
        }
        return strValueOf;
    }

    public static int w(Date date) {
        int[] iArr = {7, 1, 2, 3, 4, 5, 6};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i2 = calendar.get(7) - 1;
        if (i2 < 0) {
            i2 = 0;
        }
        return iArr[i2];
    }

    public static long x() {
        return System.currentTimeMillis();
    }

    public static int y(int i2, int i3, int i4) {
        return (i2 * 60 * 60) + (i3 * 60) + i4;
    }

    public static String z(int i2, int i3, int i4) {
        String str;
        String str2;
        if (i2 == 0) {
            str = "";
        } else if (i2 < 10) {
            str = "0" + i2;
        } else {
            str = "" + i2;
        }
        String str3 = "00";
        if (i3 == 0) {
            str2 = "00";
        } else if (i3 < 10) {
            str2 = "0" + i3;
        } else {
            str2 = "" + i3;
        }
        if (i4 != 0) {
            if (i4 < 10) {
                str3 = "0" + i4;
            } else {
                str3 = "" + i4;
            }
        }
        if (i2 == 0) {
            return str2 + SignatureImpl.INNER_SEP + str3;
        }
        return str + SignatureImpl.INNER_SEP + str2 + SignatureImpl.INNER_SEP + str3;
    }
}
