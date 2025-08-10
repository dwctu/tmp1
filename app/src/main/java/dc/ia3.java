package dc;

import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;

/* compiled from: VideoUtils.java */
/* loaded from: classes4.dex */
public class ia3 {
    public static void a(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).removeView(view);
        }
    }
}
