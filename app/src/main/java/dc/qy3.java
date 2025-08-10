package dc;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Builders.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u000b\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/BlockingCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "isScopedCoroutine", "", "()Z", "afterCompletion", "", "state", "", "joinBlocking", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class qy3<T> extends ly3<T> {

    @NotNull
    public final Thread c;

    @Nullable
    public final r04 d;

    public qy3(@NotNull CoroutineContext coroutineContext, @NotNull Thread thread, @Nullable r04 r04Var) {
        super(coroutineContext, true, true);
        this.c = thread;
        this.d = r04Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T O0() throws Throwable {
        Unit unit;
        my3 my3VarA = ny3.a();
        if (my3VarA != null) {
            my3VarA.c();
        }
        try {
            r04 r04Var = this.d;
            if (r04Var != null) {
                r04.f0(r04Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    r04 r04Var2 = this.d;
                    long jI0 = r04Var2 == null ? Long.MAX_VALUE : r04Var2.i0();
                    if (g0()) {
                        T t = (T) p14.h(Z());
                        jz3Var = t instanceof jz3 ? (jz3) t : null;
                        if (jz3Var == null) {
                            return t;
                        }
                        throw jz3Var.a;
                    }
                    my3 my3VarA2 = ny3.a();
                    if (my3VarA2 == null) {
                        unit = null;
                    } else {
                        my3VarA2.b(this, jI0);
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        LockSupport.parkNanos(this, jI0);
                    }
                } finally {
                    r04 r04Var3 = this.d;
                    if (r04Var3 != null) {
                        r04.I(r04Var3, false, 1, null);
                    }
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            E(interruptedException);
            throw interruptedException;
        } finally {
            my3 my3VarA3 = ny3.a();
            if (my3VarA3 != null) {
                my3VarA3.g();
            }
        }
    }

    @Override // dc.o14
    public boolean h0() {
        return true;
    }

    @Override // dc.o14
    public void z(@Nullable Object obj) {
        Unit unit;
        if (Intrinsics.areEqual(Thread.currentThread(), this.c)) {
            return;
        }
        Thread thread = this.c;
        my3 my3VarA = ny3.a();
        if (my3VarA == null) {
            unit = null;
        } else {
            my3VarA.f(thread);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            LockSupport.unpark(thread);
        }
    }
}
