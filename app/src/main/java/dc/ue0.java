package dc;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: TimeUtils.java */
/* loaded from: classes.dex */
public final class ue0 {
    public static final ThreadLocal<Map<String, SimpleDateFormat>> a = new a();
    public static DateFormat b;
    public static DateFormat c;
    public static DateFormat d;

    /* compiled from: TimeUtils.java */
    public class a extends ThreadLocal<Map<String, SimpleDateFormat>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<String, SimpleDateFormat> initialValue() {
            return new HashMap();
        }
    }

    static {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        b = new SimpleDateFormat("yyyy-MM-dd");
        new SimpleDateFormat("HH:mm");
        new SimpleDateFormat("HH:mm:ss");
        new SimpleDateFormat("hh:mm");
        new SimpleDateFormat("hh:mm a");
        new SimpleDateFormat("yyyy/MM/dd HH:mm");
        new SimpleDateFormat("dd MMMM yyyy");
        new SimpleDateFormat("yyyy-MM-dd");
        new SimpleDateFormat("yyyy-MM-dd HH:mm");
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        c = new SimpleDateFormat("yyyyMMdd");
        d = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        new SimpleDateFormat("MMM, dd, yyyy", Locale.ENGLISH);
        new SimpleDateFormat("MM/dd hh:mm");
        new SimpleDateFormat("yyyy/MM/dd hh:mm");
        new SimpleDateFormat("MMddyyyy");
        new SimpleDateFormat("MM月dd日 hh:mm");
    }

    public static long a(Date date) {
        return date.getTime();
    }

    public static String b(Date date, @NonNull DateFormat dateFormat) {
        return dateFormat.format(date);
    }

    public static String c() {
        return TimeZone.getDefault().getDisplayName(false, 0);
    }

    public static Date d(Date date, long j, int i) {
        return l(a(date) + o(j, i));
    }

    public static SimpleDateFormat e() {
        return i("yyyy-MM-dd HH:mm:ss");
    }

    public static Date f() {
        return new Date();
    }

    public static String g() {
        return n(System.currentTimeMillis(), e());
    }

    public static String h(@NonNull DateFormat dateFormat) {
        return n(System.currentTimeMillis(), dateFormat);
    }

    @SuppressLint({"SimpleDateFormat"})
    public static SimpleDateFormat i(String str) {
        Map<String, SimpleDateFormat> map = a.get();
        SimpleDateFormat simpleDateFormat = map.get(str);
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str);
        map.put(str, simpleDateFormat2);
        return simpleDateFormat2;
    }

    public static double j() {
        return TimeZone.getDefault().getRawOffset() / 3600000.0d;
    }

    public static String k() {
        double dJ = j();
        StringBuilder sb = new StringBuilder();
        sb.append(dJ >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? "+" : "");
        sb.append(dJ);
        return sb.toString();
    }

    public static Date l(long j) {
        return new Date(j);
    }

    public static String m(long j) {
        return n(j, e());
    }

    public static String n(long j, @NonNull DateFormat dateFormat) {
        return dateFormat.format(new Date(j));
    }

    public static long o(long j, int i) {
        return j * i;
    }
}
