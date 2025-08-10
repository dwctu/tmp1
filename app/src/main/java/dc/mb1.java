package dc;

import android.content.Context;
import androidx.annotation.NonNull;

/* compiled from: DensityUtil.java */
/* loaded from: classes3.dex */
public class mb1 {
    public static float a(@NonNull Context context, float f) {
        return f * context.getResources().getDisplayMetrics().density;
    }
}
