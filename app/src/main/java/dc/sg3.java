package dc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.lovense.wear.R;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;

/* compiled from: T.java */
/* loaded from: classes4.dex */
public class sg3 {
    static {
        new Handler(Looper.getMainLooper());
    }

    public static void a(Context context, CharSequence charSequence, int i) {
        g(charSequence);
    }

    public static void b(Context context, CharSequence charSequence, int i) {
        f71.g(80, 0, 520);
        f71.l(charSequence);
    }

    public static void c(CharSequence charSequence) {
        d71 d71Var = new d71();
        d71Var.a = charSequence;
        d71Var.e = new o71(R.layout.popwin_middle_toast_view);
        f71.k(d71Var);
    }

    public static void d(int i) {
        FragmentActivity fragmentActivityH = WearUtils.x == null ? null : MyApplication.H();
        if (fragmentActivityH != null) {
            a(fragmentActivityH, ah4.e(i), 1);
        }
    }

    public static void e(Context context, int i) {
        a(context, ah4.e(i), 1);
    }

    public static void f(Context context, CharSequence charSequence) {
        a(context, charSequence, 1);
    }

    public static void g(CharSequence charSequence) {
        d71 d71Var = new d71();
        d71Var.a = charSequence;
        d71Var.e = new o71(R.layout.toast_command);
        f71.g(17, 0, 0);
        f71.k(d71Var);
    }

    public static void h(int i) {
        FragmentActivity fragmentActivityH = WearUtils.x == null ? null : MyApplication.H();
        if (fragmentActivityH != null) {
            a(fragmentActivityH, ah4.e(i), 0);
        }
    }

    public static void i(Context context, int i) {
        a(context, ah4.e(i), 0);
    }

    public static void j(Context context, int i, String str) {
        a(context, ah4.e(i), 0);
    }

    public static void k(Context context, CharSequence charSequence) {
        a(context, charSequence, 0);
    }

    public static void l(String str) {
        FragmentActivity fragmentActivityH = WearUtils.x == null ? null : MyApplication.H();
        if (fragmentActivityH != null) {
            a(fragmentActivityH, str, 0);
        }
    }

    public static void m(int i) {
        FragmentActivity fragmentActivityH = WearUtils.x == null ? null : MyApplication.H();
        if (fragmentActivityH != null) {
            b(fragmentActivityH, ah4.e(i), 0);
        }
    }

    public static void n(int i) {
        if ((WearUtils.x == null ? null : MyApplication.H()) != null) {
            c(ah4.e(i));
        }
    }

    public static void o(CharSequence charSequence) {
        d71 d71Var = new d71();
        d71Var.a = charSequence;
        d71Var.b = 2000;
        d71Var.e = new o71(R.layout.toast_waring);
        f71.g(17, 0, 0);
        f71.k(d71Var);
    }
}
