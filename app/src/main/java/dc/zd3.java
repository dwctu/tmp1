package dc;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: DataTool.java */
/* loaded from: classes4.dex */
public class zd3 {
    public static final String a = "zd3";

    public static <T> T a(String str) {
        return (T) pe3.f(str);
    }

    public static String b(Context context, String str) {
        String strH = eg3.h(context, str, null);
        String str2 = a;
        xe3.a(str2, str + "解密前：" + strH);
        String strI = nd3.i(strH);
        xe3.a(str2, str + "解密后：" + strI);
        return !TextUtils.isEmpty(strI) ? strI : strH;
    }

    public static String c(String str) {
        return nd3.i(pe3.g(str));
    }

    public static void d(Context context, String str, String str2) {
        eg3.i(context, str, nd3.u(str2));
    }

    public static void e(String str, Object obj) {
        try {
            pe3.k(str, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void f(String str, String str2) {
        try {
            pe3.l(str, nd3.u(str2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
