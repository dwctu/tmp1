package dc;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.spotify.sdk.android.player.Config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/* compiled from: PhoneRomUtils.java */
/* loaded from: classes2.dex */
public final class n61 {
    public static final String[] a = {"huawei"};
    public static final String[] b = {"vivo"};
    public static final String[] c = {"xiaomi"};
    public static final String[] d = {"oppo"};
    public static final String[] e = {"leeco", "letv"};
    public static final String[] f = {"360", "qiku"};
    public static final String[] g = {"zte"};
    public static final String[] h = {"oneplus"};
    public static final String[] i = {"nubia"};
    public static final String[] j = {"samsung"};
    public static final String[] k = {"honor"};
    public static final String[] l = {"ro.build.version.opporom", "ro.build.version.oplusrom.display"};
    public static final String[] m = {"msc.config.magic.version", "ro.build.version.magic"};

    public static String a() {
        return Build.BRAND.toLowerCase();
    }

    public static String b() {
        return Build.MANUFACTURER.toLowerCase();
    }

    public static String c(String str) {
        return !TextUtils.isEmpty(str) ? e(str) : "";
    }

    @Nullable
    public static String d() {
        String strA = a();
        String strB = b();
        if (q(strA, strB, a)) {
            String strC = c("ro.build.version.emui");
            String[] strArrSplit = strC.split(Config.IN_FIELD_SEPARATOR);
            return strArrSplit.length > 1 ? strArrSplit[1] : strC.contains("EmotionUI") ? strC.replaceFirst("EmotionUI\\s*", "") : strC;
        }
        if (q(strA, strB, b)) {
            return c("ro.vivo.os.build.display.id");
        }
        if (q(strA, strB, c)) {
            return c("ro.build.version.incremental");
        }
        int i2 = 0;
        if (q(strA, strB, d)) {
            String[] strArr = l;
            int length = strArr.length;
            while (i2 < length) {
                String str = strArr[i2];
                String strC2 = c(str);
                if (!TextUtils.isEmpty(str)) {
                    return strC2;
                }
                i2++;
            }
            return "";
        }
        if (q(strA, strB, e)) {
            return c("ro.letv.release.version");
        }
        if (q(strA, strB, f)) {
            return c("ro.build.uiversion");
        }
        if (q(strA, strB, g)) {
            return c("ro.build.MiFavor_version");
        }
        if (q(strA, strB, h)) {
            return c("ro.rom.version");
        }
        if (q(strA, strB, i)) {
            return c("ro.build.rom.id");
        }
        if (!q(strA, strB, k)) {
            return c("");
        }
        String[] strArr2 = m;
        int length2 = strArr2.length;
        while (i2 < length2) {
            String str2 = strArr2[i2];
            String strC3 = c(str2);
            if (!TextUtils.isEmpty(str2)) {
                return strC3;
            }
            i2++;
        }
        return "";
    }

    public static String e(String str) throws Throwable {
        String strG = g(str);
        if (!TextUtils.isEmpty(strG)) {
            return strG;
        }
        String strH = h(str);
        return (TextUtils.isEmpty(strH) && Build.VERSION.SDK_INT < 28) ? f(str) : strH;
    }

    @SuppressLint({"PrivateApi"})
    public static String f(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return "";
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return "";
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return "";
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    public static String g(String str) throws Throwable {
        BufferedReader bufferedReader;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                    try {
                        line = bufferedReader.readLine();
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader2 = bufferedReader;
                        e.printStackTrace();
                        if (bufferedReader2 == null) {
                            return "";
                        }
                        bufferedReader2.close();
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                }
                if (line == null) {
                    bufferedReader.close();
                    return "";
                }
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return line;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
            return "";
        }
    }

    public static String h(String str) throws IOException {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return "";
        } catch (IOException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static boolean i() {
        for (String str : l) {
            if (!TextUtils.isEmpty(c(str))) {
                return true;
            }
        }
        return false;
    }

    public static boolean j() {
        return !TextUtils.isEmpty(c("ro.build.version.emui"));
    }

    public static boolean k() {
        if (!n51.c()) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "Harmony".equalsIgnoreCase(String.valueOf(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean l() {
        return q(a(), b(), k);
    }

    public static boolean m() {
        return !TextUtils.isEmpty(c("ro.miui.ui.version.name"));
    }

    @SuppressLint({"PrivateApi"})
    public static boolean n() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String strValueOf = String.valueOf(cls.getMethod("get", String.class, String.class).invoke(cls, "ro.miui.cts", ""));
            Method method = cls.getMethod("getBoolean", String.class, Boolean.TYPE);
            Object[] objArr = new Object[2];
            objArr[0] = "persist.sys.miui_optimization";
            objArr[1] = Boolean.valueOf("1".equals(strValueOf) ? false : true);
            return Boolean.parseBoolean(String.valueOf(method.invoke(cls, objArr)));
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return true;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return true;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return true;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return true;
        }
    }

    @SuppressLint({"PrivateApi"})
    public static boolean o() {
        return q(a(), b(), j);
    }

    public static boolean p() {
        return !TextUtils.isEmpty(c("ro.vivo.os.build.display.id"));
    }

    public static boolean q(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }
}
