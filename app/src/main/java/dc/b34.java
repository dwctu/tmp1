package dc;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.UndeliveredElementException;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConflatedChannel.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012 \u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0018\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0014J\u0015\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 H\u0014¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\rH\u0014J\n\u0010$\u001a\u0004\u0018\u00010\u0017H\u0014J\u0016\u0010%\u001a\u0004\u0018\u00010\u00172\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 H\u0014J\u0014\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002R\u0014\u0010\b\u001a\u00020\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0012\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isEmpty", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "value", "", "enqueueReceiveInternal", "receive", "Lkotlinx/coroutines/channels/Receive;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotent", "wasClosed", "pollInternal", "pollSelectInternal", "updateValueLocked", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class b34<E> extends o24<E> {

    @NotNull
    public final ReentrantLock d;

    @Nullable
    public Object e;

    public b34(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
        this.d = new ReentrantLock();
        this.e = p24.a;
    }

    @Override // dc.o24
    public boolean H(@NotNull g34<? super E> g34Var) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            return super.H(g34Var);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // dc.o24
    public final boolean I() {
        return false;
    }

    @Override // dc.o24
    public final boolean J() {
        return this.e == p24.a;
    }

    @Override // dc.o24
    public void L(boolean z) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            UndeliveredElementException undeliveredElementExceptionS = S(p24.a);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.L(z);
            if (undeliveredElementExceptionS != null) {
                throw undeliveredElementExceptionS;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // dc.o24
    @Nullable
    public Object P() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            Object obj = this.e;
            t64 t64Var = p24.a;
            if (obj != t64Var) {
                this.e = t64Var;
                Unit unit = Unit.INSTANCE;
                return obj;
            }
            Object objJ = j();
            if (objJ == null) {
                objJ = p24.d;
            }
            return objJ;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final UndeliveredElementException S(Object obj) {
        Function1<E, Unit> function1;
        Object obj2 = this.e;
        UndeliveredElementException undeliveredElementExceptionD = null;
        if (obj2 != p24.a && (function1 = this.a) != null) {
            undeliveredElementExceptionD = n64.d(function1, obj2, null, 2, null);
        }
        this.e = obj;
        return undeliveredElementExceptionD;
    }

    @Override // dc.q24
    @NotNull
    public String g() {
        return "(value=" + this.e + ')';
    }

    @Override // dc.q24
    public final boolean u() {
        return false;
    }

    @Override // dc.q24
    public final boolean v() {
        return false;
    }

    @Override // dc.q24
    @NotNull
    public Object x(E e) {
        i34<E> i34VarB;
        t64 t64VarP;
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            a34<?> a34VarJ = j();
            if (a34VarJ != null) {
                return a34VarJ;
            }
            if (this.e == p24.a) {
                do {
                    i34VarB = B();
                    if (i34VarB != null) {
                        if (i34VarB instanceof a34) {
                            return i34VarB;
                        }
                        t64VarP = i34VarB.p(e, null);
                    }
                } while (t64VarP == null);
                if (a04.a()) {
                    if (!(t64VarP == az3.a)) {
                        throw new AssertionError();
                    }
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                i34VarB.h(e);
                return i34VarB.b();
            }
            UndeliveredElementException undeliveredElementExceptionS = S(e);
            if (undeliveredElementExceptionS == null) {
                return p24.b;
            }
            throw undeliveredElementExceptionS;
        } finally {
            reentrantLock.unlock();
        }
    }
}
