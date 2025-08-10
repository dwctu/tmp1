package dc;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.UndeliveredElementException;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ArrayChannel.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000BB9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00172\u0006\u0010\r\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00172\u0006\u0010\r\u001a\u00028\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0012H\u0014¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u0004\u0018\u00010\u00172\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0014¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010+R\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u00020/8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00103R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0014\u00105\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b7\u00106R\u0014\u00108\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b8\u00106R\u0014\u00109\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b9\u00106R\u0014\u0010:\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u00106R\u0014\u0010;\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u00106R\u0018\u0010>\u001a\u00060<j\u0002`=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010@¨\u0006A"}, d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", ExifInterface.LONGITUDE_EAST, "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "currentSize", "element", "enqueueElement", "(ILjava/lang/Object;)V", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "ensureCapacity", "(I)V", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "wasClosed", "onCancelIdempotent", "(Z)V", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "updateBufferSize", "(I)Lkotlinx/coroutines/internal/Symbol;", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "I", TtmlNode.TAG_HEAD, "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isClosedForReceive", "isEmpty", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class r24<E> extends o24<E> {
    public final int d;

    @NotNull
    public final s24 e;

    @NotNull
    public final ReentrantLock f;

    @NotNull
    public Object[] g;
    public int h;

    @NotNull
    private volatile /* synthetic */ int size;

    /* compiled from: ArrayChannel.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[s24.values().length];
            iArr[s24.SUSPEND.ordinal()] = 1;
            iArr[s24.DROP_LATEST.ordinal()] = 2;
            iArr[s24.DROP_OLDEST.ordinal()] = 3;
            a = iArr;
        }
    }

    public r24(int i, @NotNull s24 s24Var, @Nullable Function1<? super E, Unit> function1) {
        super(function1);
        this.d = i;
        this.e = s24Var;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
        }
        this.f = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i, 8)];
        ArraysKt___ArraysJvmKt.fill$default(objArr, p24.a, 0, 0, 6, (Object) null);
        this.g = objArr;
        this.size = 0;
    }

    @Override // dc.o24
    public boolean H(@NotNull g34<? super E> g34Var) {
        ReentrantLock reentrantLock = this.f;
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
        return this.size == 0;
    }

    @Override // dc.o24
    public boolean K() {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            return super.K();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // dc.o24
    public void L(boolean z) {
        Function1<E, Unit> function1 = this.a;
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            int i = this.size;
            UndeliveredElementException undeliveredElementExceptionC = null;
            int i2 = 0;
            while (i2 < i) {
                i2++;
                Object obj = this.g[this.h];
                if (function1 != null && obj != p24.a) {
                    undeliveredElementExceptionC = n64.c(function1, obj, undeliveredElementExceptionC);
                }
                Object[] objArr = this.g;
                int i3 = this.h;
                objArr[i3] = p24.a;
                this.h = (i3 + 1) % objArr.length;
            }
            this.size = 0;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.L(z);
            if (undeliveredElementExceptionC != null) {
                throw undeliveredElementExceptionC;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // dc.o24
    @Nullable
    public Object P() {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object objJ = j();
                if (objJ == null) {
                    objJ = p24.d;
                }
                return objJ;
            }
            Object[] objArr = this.g;
            int i2 = this.h;
            Object obj = objArr[i2];
            k34 k34Var = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object d = p24.d;
            if (i == this.d) {
                k34 k34Var2 = null;
                while (true) {
                    k34 k34VarC = C();
                    if (k34VarC == null) {
                        k34Var = k34Var2;
                        break;
                    }
                    t64 t64VarN = k34VarC.N(null);
                    if (t64VarN != null) {
                        if (a04.a()) {
                            if (!(t64VarN == az3.a)) {
                                throw new AssertionError();
                            }
                        }
                        d = k34VarC.getD();
                        k34Var = k34VarC;
                        z = true;
                    } else {
                        k34VarC.O();
                        k34Var2 = k34VarC;
                    }
                }
            }
            if (d != p24.d && !(d instanceof a34)) {
                this.size = i;
                Object[] objArr2 = this.g;
                objArr2[(this.h + i) % objArr2.length] = d;
            }
            this.h = (this.h + 1) % this.g.length;
            Unit unit = Unit.INSTANCE;
            if (z) {
                Intrinsics.checkNotNull(k34Var);
                k34Var.K();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void S(int i, E e) {
        if (i < this.d) {
            T(i);
            Object[] objArr = this.g;
            objArr[(this.h + i) % objArr.length] = e;
            return;
        }
        if (a04.a()) {
            if (!(this.e == s24.DROP_OLDEST)) {
                throw new AssertionError();
            }
        }
        Object[] objArr2 = this.g;
        int i2 = this.h;
        objArr2[i2 % objArr2.length] = null;
        objArr2[(i + i2) % objArr2.length] = e;
        this.h = (i2 + 1) % objArr2.length;
    }

    public final void T(int i) {
        Object[] objArr = this.g;
        if (i >= objArr.length) {
            int iMin = Math.min(objArr.length * 2, this.d);
            Object[] objArr2 = new Object[iMin];
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr3 = this.g;
                objArr2[i2] = objArr3[(this.h + i2) % objArr3.length];
            }
            ArraysKt___ArraysJvmKt.fill((t64[]) objArr2, p24.a, i, iMin);
            this.g = objArr2;
            this.h = 0;
        }
    }

    public final t64 U(int i) {
        if (i < this.d) {
            this.size = i + 1;
            return null;
        }
        int i2 = a.a[this.e.ordinal()];
        if (i2 == 1) {
            return p24.c;
        }
        if (i2 == 2) {
            return p24.b;
        }
        if (i2 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // dc.q24
    @Nullable
    public Object f(@NotNull k34 k34Var) {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            return super.f(k34Var);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // dc.q24
    @NotNull
    public String g() {
        return "(buffer:capacity=" + this.d + ",size=" + this.size + ')';
    }

    @Override // dc.q24
    public final boolean u() {
        return false;
    }

    @Override // dc.q24
    public final boolean v() {
        return this.size == this.d && this.e == s24.SUSPEND;
    }

    @Override // dc.q24
    @NotNull
    public Object x(E e) {
        i34<E> i34VarB;
        t64 t64VarP;
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            int i = this.size;
            a34<?> a34VarJ = j();
            if (a34VarJ != null) {
                return a34VarJ;
            }
            t64 t64VarU = U(i);
            if (t64VarU != null) {
                return t64VarU;
            }
            if (i == 0) {
                do {
                    i34VarB = B();
                    if (i34VarB != null) {
                        if (i34VarB instanceof a34) {
                            this.size = i;
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
                this.size = i;
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                i34VarB.h(e);
                return i34VarB.b();
            }
            S(i, e);
            return p24.b;
        } finally {
            reentrantLock.unlock();
        }
    }
}
