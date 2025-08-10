package dc;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MainCoroutineDispatcher.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0005R\u0012\u0010\u0003\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "limitedParallelism", "parallelism", "", "toString", "", "toStringInternalImpl", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class s14 extends qz3 {
    @Nullable
    public final String I() {
        s14 s14VarY;
        s14 s14VarC = n04.c();
        if (this == s14VarC) {
            return "Dispatchers.Main";
        }
        try {
            s14VarY = s14VarC.y();
        } catch (UnsupportedOperationException unused) {
            s14VarY = null;
        }
        if (this == s14VarY) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // dc.qz3
    @NotNull
    public qz3 limitedParallelism(int i) {
        d64.a(i);
        return this;
    }

    @Override // dc.qz3
    @NotNull
    public String toString() {
        String strI = I();
        if (strI != null) {
            return strI;
        }
        return b04.a(this) + '@' + b04.b(this);
    }

    @NotNull
    public abstract s14 y();
}
