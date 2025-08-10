package dc;

import android.content.res.Resources;

/* compiled from: SizeUtils.java */
/* loaded from: classes.dex */
public final class qe0 {
    public static int a(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
