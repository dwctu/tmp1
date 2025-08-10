package dc;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: IAnimPlugin.kt */
/* loaded from: classes3.dex */
public interface wh1 {

    /* compiled from: IAnimPlugin.kt */
    public static final class a {
        public static void a(wh1 wh1Var, int i) {
        }

        public static boolean b(wh1 wh1Var, @NotNull MotionEvent ev) {
            Intrinsics.checkParameterIsNotNull(ev, "ev");
            return false;
        }
    }

    void a(int i);

    boolean b(@NotNull MotionEvent motionEvent);

    void c();

    void d(int i);

    void e();

    int f(@NotNull ng1 ng1Var);

    void onDestroy();
}
