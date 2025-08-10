package dc;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.wear.util.WearUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: OSUtils.java */
/* loaded from: classes4.dex */
public class if3 {
    public static String a;
    public static String b;

    public static boolean a(String str) throws Throwable {
        String str2 = a;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strC = c("ro.miui.ui.version.name");
        b = strC;
        if (TextUtils.isEmpty(strC)) {
            String strC2 = c("ro.build.version.emui");
            b = strC2;
            if (TextUtils.isEmpty(strC2)) {
                String strC3 = c("ro.build.version.opporom");
                b = strC3;
                if (TextUtils.isEmpty(strC3)) {
                    String strC4 = c("ro.vivo.os.version");
                    b = strC4;
                    if (TextUtils.isEmpty(strC4)) {
                        String strC5 = c("ro.smartisan.version");
                        b = strC5;
                        if (TextUtils.isEmpty(strC5)) {
                            String str3 = Build.DISPLAY;
                            b = str3;
                            if (str3.toUpperCase().contains("FLYME")) {
                                a = "FLYME";
                            } else {
                                b = EnvironmentCompat.MEDIA_UNKNOWN;
                                a = Build.MANUFACTURER.toUpperCase();
                            }
                        } else {
                            a = "SMARTISAN";
                        }
                    } else {
                        a = "VIVO";
                    }
                } else {
                    a = "OPPO";
                }
            } else {
                a = "EMUI";
            }
        } else {
            a = "MIUI";
        }
        return a.equals(str);
    }

    public static String b() {
        float f = WearUtils.x.getResources().getDisplayMetrics().density;
        int i = (int) f;
        if (f - i == 0.0f) {
            return iRound + "," + i;
        }
        return iRound + "," + f;
    }

    public static String c(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (IOException unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String line = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        } catch (IOException unused2) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
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
    }

    public static String d() {
        return Build.VERSION.RELEASE;
    }

    public static boolean e() {
        return a("FLYME");
    }

    public static boolean f() {
        return a("MIUI");
    }

    public static boolean g() {
        return a("OPPO");
    }

    public static boolean h() {
        return a("VIVO");
    }
}
