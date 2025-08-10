package dc;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* compiled from: Compat.java */
/* loaded from: classes4.dex */
public class vu3 {
    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
