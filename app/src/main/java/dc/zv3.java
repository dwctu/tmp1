package dc;

import android.util.TypedValue;

/* compiled from: DimenUtils.java */
/* loaded from: classes4.dex */
public class zv3 {
    public static int a(int i) {
        return (i >> 0) & 15;
    }

    public static boolean b(TypedValue typedValue) {
        return typedValue != null && typedValue.type == 5 && a(typedValue.data) == 0;
    }
}
