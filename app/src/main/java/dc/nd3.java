package dc;

import android.util.Base64;

/* compiled from: AESUtil.java */
/* loaded from: classes4.dex */
public class nd3 {
    public static String a(String str) {
        return vz.G(str);
    }

    public static String b(String str, String str2, String str3) {
        return uz.d(str, str2, str3);
    }

    public static byte[] c(String str) {
        try {
            if (!str.contains("/") && !str.contains("=") && !str.contains("+")) {
                return Base64.decode(str, 8);
            }
            return Base64.decode(str, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String d(String str) {
        return vz.B(str);
    }

    public static String e(String str) {
        return vz.C(str);
    }

    public static String f(String str) {
        return vz.D(str);
    }

    public static String g(String str) {
        return vz.C(str);
    }

    public static String h(String str) {
        return vz.E(str);
    }

    public static String i(String str) {
        return vz.F(str);
    }

    public static String j(String str) {
        return vz.H(str);
    }

    public static String k(String str, String str2, String str3) {
        return vz.I(str, str2, str3);
    }

    public static String l(String str) {
        return vz.S(str);
    }

    public static String m(String str, String str2, String str3) {
        return uz.e(str, str2, str3);
    }

    public static String n(String str) {
        return vz.J(str);
    }

    public static String o(String str) {
        return vz.K(str);
    }

    public static String p(String str) {
        return vz.L(str);
    }

    public static String q(String str) {
        return vz.K(str);
    }

    public static String r(String str) {
        return vz.M(str);
    }

    public static String s(String str) {
        return vz.N(str);
    }

    public static String t(String str) {
        return vz.O(str);
    }

    public static String u(String str) {
        return vz.P(str);
    }

    public static String v(String str) {
        return vz.Q(str);
    }

    public static String w(String str) {
        return vz.R(str);
    }

    public static String x(String str, String str2, String str3) {
        return vz.T(str, str2, str3);
    }
}
