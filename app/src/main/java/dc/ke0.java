package dc;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.spotify.sdk.android.player.Config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* compiled from: RomUtils.java */
/* loaded from: classes.dex */
public final class ke0 {
    public static final String[] a = {"huawei"};
    public static final String[] b = {"vivo"};
    public static final String[] c = {"xiaomi"};
    public static final String[] d = {"oppo"};
    public static final String[] e = {"leeco", "letv"};
    public static final String[] f = {"360", "qiku"};
    public static final String[] g = {"zte"};
    public static final String[] h = {"oneplus"};
    public static final String[] i = {"nubia"};
    public static final String[] j = {"coolpad", "yulong"};
    public static final String[] k = {"lg", "lge"};
    public static final String[] l = {"google"};
    public static final String[] m = {"samsung"};
    public static final String[] n = {"meizu"};
    public static final String[] o = {"lenovo"};
    public static final String[] p = {"smartisan", "deltainno"};
    public static final String[] q = {"htc"};
    public static final String[] r = {"sony"};
    public static final String[] s = {"gionee", "amigo"};
    public static final String[] t = {"motorola"};
    public static a u;

    /* compiled from: RomUtils.java */
    public static class a {
        public String a;
        public String b;

        public String d() {
            return this.a;
        }

        public String toString() {
            return "RomInfo{name=" + this.a + ", version=" + this.b + "}";
        }
    }

    public static String a() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : EnvironmentCompat.MEDIA_UNKNOWN;
        } catch (Throwable unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static String b() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : EnvironmentCompat.MEDIA_UNKNOWN;
        } catch (Throwable unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static a c() {
        a aVar = u;
        if (aVar != null) {
            return aVar;
        }
        u = new a();
        String strA = a();
        String strB = b();
        String[] strArr = a;
        if (j(strA, strB, strArr)) {
            u.a = strArr[0];
            String strD = d("ro.build.version.emui");
            String[] strArrSplit = strD.split(Config.IN_FIELD_SEPARATOR);
            if (strArrSplit.length > 1) {
                u.b = strArrSplit[1];
            } else {
                u.b = strD;
            }
            return u;
        }
        String[] strArr2 = b;
        if (j(strA, strB, strArr2)) {
            u.a = strArr2[0];
            u.b = d("ro.vivo.os.build.display.id");
            return u;
        }
        String[] strArr3 = c;
        if (j(strA, strB, strArr3)) {
            u.a = strArr3[0];
            u.b = d("ro.build.version.incremental");
            return u;
        }
        String[] strArr4 = d;
        if (j(strA, strB, strArr4)) {
            u.a = strArr4[0];
            u.b = d("ro.build.version.opporom");
            return u;
        }
        String[] strArr5 = e;
        if (j(strA, strB, strArr5)) {
            u.a = strArr5[0];
            u.b = d("ro.letv.release.version");
            return u;
        }
        String[] strArr6 = f;
        if (j(strA, strB, strArr6)) {
            u.a = strArr6[0];
            u.b = d("ro.build.uiversion");
            return u;
        }
        String[] strArr7 = g;
        if (j(strA, strB, strArr7)) {
            u.a = strArr7[0];
            u.b = d("ro.build.MiFavor_version");
            return u;
        }
        String[] strArr8 = h;
        if (j(strA, strB, strArr8)) {
            u.a = strArr8[0];
            u.b = d("ro.rom.version");
            return u;
        }
        String[] strArr9 = i;
        if (j(strA, strB, strArr9)) {
            u.a = strArr9[0];
            u.b = d("ro.build.rom.id");
            return u;
        }
        String[] strArr10 = j;
        if (j(strA, strB, strArr10)) {
            u.a = strArr10[0];
        } else {
            String[] strArr11 = k;
            if (j(strA, strB, strArr11)) {
                u.a = strArr11[0];
            } else {
                String[] strArr12 = l;
                if (j(strA, strB, strArr12)) {
                    u.a = strArr12[0];
                } else {
                    String[] strArr13 = m;
                    if (j(strA, strB, strArr13)) {
                        u.a = strArr13[0];
                    } else {
                        String[] strArr14 = n;
                        if (j(strA, strB, strArr14)) {
                            u.a = strArr14[0];
                        } else {
                            String[] strArr15 = o;
                            if (j(strA, strB, strArr15)) {
                                u.a = strArr15[0];
                            } else {
                                String[] strArr16 = p;
                                if (j(strA, strB, strArr16)) {
                                    u.a = strArr16[0];
                                } else {
                                    String[] strArr17 = q;
                                    if (j(strA, strB, strArr17)) {
                                        u.a = strArr17[0];
                                    } else {
                                        String[] strArr18 = r;
                                        if (j(strA, strB, strArr18)) {
                                            u.a = strArr18[0];
                                        } else {
                                            String[] strArr19 = s;
                                            if (j(strA, strB, strArr19)) {
                                                u.a = strArr19[0];
                                            } else {
                                                String[] strArr20 = t;
                                                if (j(strA, strB, strArr20)) {
                                                    u.a = strArr20[0];
                                                } else {
                                                    u.a = strB;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        u.b = d("");
        return u;
    }

    public static String d(String str) {
        String strE = !TextUtils.isEmpty(str) ? e(str) : "";
        if (TextUtils.isEmpty(strE) || strE.equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    strE = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(strE) ? EnvironmentCompat.MEDIA_UNKNOWN : strE;
    }

    public static String e(String str) throws Throwable {
        String strG = g(str);
        if (!TextUtils.isEmpty(strG)) {
            return strG;
        }
        String strH = h(str);
        return (TextUtils.isEmpty(strH) && Build.VERSION.SDK_INT < 28) ? f(str) : strH;
    }

    public static String f(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g(String str) throws Throwable {
        BufferedReader bufferedReader;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    line = bufferedReader.readLine();
                } catch (IOException unused) {
                    bufferedReader2 = bufferedReader;
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
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
            if (line != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
                return line;
            }
            bufferedReader.close();
            return "";
        } catch (IOException unused5) {
            return "";
        }
    }

    public static String h(String str) throws IOException {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean i() {
        return h[0].equals(c().a);
    }

    public static boolean j(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }
}
