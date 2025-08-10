package dc;

import android.content.Context;
import androidx.window.layout.WindowInfoTracker;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: WindowInfoTracker.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class y6 {
    @JvmStatic
    @JvmName(name = "getOrCreate")
    @NotNull
    public static WindowInfoTracker a(@NotNull Context context) {
        return WindowInfoTracker.INSTANCE.getOrCreate(context);
    }
}
