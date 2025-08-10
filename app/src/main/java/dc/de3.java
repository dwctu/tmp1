package dc;

import android.content.Context;

/* compiled from: DisplayUtil.java */
/* loaded from: classes4.dex */
public class de3 {
    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
