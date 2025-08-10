package dc;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Decoder.kt */
/* loaded from: classes3.dex */
public final class ug1 {

    @Nullable
    public HandlerThread a;

    @Nullable
    public Handler b;

    public ug1(@Nullable HandlerThread handlerThread, @Nullable Handler handler) {
        this.a = handlerThread;
        this.b = handler;
    }

    @Nullable
    public final Handler a() {
        return this.b;
    }

    @Nullable
    public final HandlerThread b() {
        return this.a;
    }

    public final void c(@Nullable Handler handler) {
        this.b = handler;
    }

    public final void d(@Nullable HandlerThread handlerThread) {
        this.a = handlerThread;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ug1)) {
            return false;
        }
        ug1 ug1Var = (ug1) obj;
        return Intrinsics.areEqual(this.a, ug1Var.a) && Intrinsics.areEqual(this.b, ug1Var.b);
    }

    public int hashCode() {
        HandlerThread handlerThread = this.a;
        int iHashCode = (handlerThread != null ? handlerThread.hashCode() : 0) * 31;
        Handler handler = this.b;
        return iHashCode + (handler != null ? handler.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "HandlerHolder(thread=" + this.a + ", handler=" + this.b + ")";
    }
}
