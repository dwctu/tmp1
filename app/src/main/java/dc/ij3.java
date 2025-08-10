package dc;

import android.content.Context;
import android.widget.ImageView;

/* compiled from: GlideUtils.java */
/* loaded from: classes4.dex */
public class ij3 {
    public static void a(Context context, ImageView imageView, String str, int i, int i2, int i3) {
        if (context == null || imageView == null) {
            return;
        }
        kf.w(context).v(str).a(new qo().Z(of.NORMAL).X(i).h(i2).f(ii.d).c().j0(new dj3(i3))).N0(new mm().e()).A0(imageView);
    }

    public static void b(Context context, ImageView imageView, int i, int i2, int i3, int i4) {
        if (context == null || imageView == null) {
            return;
        }
        kf.w(context).t(Integer.valueOf(i)).a(new qo().Z(of.NORMAL).X(i2).h(i3).f(ii.d).c().j0(new dj3(i4))).N0(new mm().e()).A0(imageView);
    }

    public static void c(Context context, ImageView imageView, String str) {
        if (context == null || imageView == null) {
            return;
        }
        kf.w(context).v(str).a(new qo().Z(of.NORMAL).f(ii.d).c()).N0(new mm().e()).A0(imageView);
    }
}
