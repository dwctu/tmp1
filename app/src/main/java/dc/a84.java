package dc;

import com.wear.bean.SyncWsProtocol;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<java.lang.Object, dc.z74>] */
/* compiled from: Mutex.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00112\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 :\u0006$%&'()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000bJT\u0010\u0014\u001a\u00020\t\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u0019\u0010\u001a\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\"\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "", "locked", "<init>", "(Z)V", "", "owner", "holdsLock", "(Ljava/lang/Object;)Z", "", JoinPoint.SYNCHRONIZATION_LOCK, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "toString", "()Ljava/lang/String;", "tryLock", JoinPoint.SYNCHRONIZATION_UNLOCK, "(Ljava/lang/Object;)V", "isLocked", "()Z", "isLockedEmptyQueueState$kotlinx_coroutines_core", "isLockedEmptyQueueState", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a84 implements z74 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(a84.class, Object.class, "_state");

    @NotNull
    public volatile /* synthetic */ Object _state;

    /* compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeLockWaiter", "toString", "", "tryResumeLockWaiter", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class a extends b {

        @NotNull
        public final yy3<Unit> f;

        /* compiled from: Mutex.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: dc.a84$a$a, reason: collision with other inner class name */
        public static final class C0161a extends Lambda implements Function1<Throwable, Unit> {
            public final /* synthetic */ a84 this$0;
            public final /* synthetic */ a this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0161a(a84 a84Var, a aVar) {
                super(1);
                this.this$0 = a84Var;
                this.this$1 = aVar;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable th) {
                this.this$0.b(this.this$1.d);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(@Nullable Object obj, @NotNull yy3<? super Unit> yy3Var) {
            super(a84.this, obj);
            this.f = yy3Var;
        }

        @Override // dc.a84.b
        public void K() {
            this.f.t(az3.a);
        }

        @Override // dc.a84.b
        public boolean M() {
            return L() && this.f.l(Unit.INSTANCE, null, new C0161a(a84.this, this)) != null;
        }

        @Override // dc.g64
        @NotNull
        public String toString() {
            return "LockCont[" + this.d + ", " + this.f + "] for " + a84.this;
        }
    }

    /* compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b¢\u0004\u0018\u00002\u00020\u000f2\u00020\u0010B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "", "completeResumeLockWaiter", "()V", "dispose", "", "take", "()Z", "tryResumeLockWaiter", "Ljava/lang/Object;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public abstract class b extends g64 implements o04 {
        public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(b.class, "isTaken");

        @JvmField
        @Nullable
        public final Object d;

        @NotNull
        private volatile /* synthetic */ int isTaken = 0;

        public b(@Nullable a84 a84Var, Object obj) {
            this.d = obj;
        }

        public abstract void K();

        public final boolean L() {
            return e.compareAndSet(this, 0, 1);
        }

        public abstract boolean M();

        @Override // dc.o04
        public final void dispose() {
            F();
        }
    }

    /* compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "owner", "", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends e64 {

        @JvmField
        @NotNull
        public Object d;

        public c(@NotNull Object obj) {
            this.d = obj;
        }

        @Override // dc.g64
        @NotNull
        public String toString() {
            return "LockedQueue[" + this.d + ']';
        }
    }

    /* compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/sync/MutexImpl;", SyncWsProtocol.DataBean.CONTROL_STATUS_QUEUE_TYPE_KEY, "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V", "complete", "", "affected", SaslStreamElements.SASLFailure.ELEMENT, "", "prepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends r54<a84> {

        @JvmField
        @NotNull
        public final c b;

        public d(@NotNull c cVar) {
            this.b = cVar;
        }

        @Override // dc.r54
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(@NotNull a84 a84Var, @Nullable Object obj) {
            a84.a.compareAndSet(a84Var, this, obj == null ? b84.e : this.b);
        }

        @Override // dc.r54
        @Nullable
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(@NotNull a84 a84Var) {
            if (this.b.K()) {
                return null;
            }
            return b84.a;
        }
    }

    /* compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class e extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ Object $owner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Object obj) {
            super(1);
            this.$owner = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Throwable th) {
            a84.this.b(this.$owner);
        }
    }

    public a84(boolean z) {
        this._state = z ? b84.d : b84.e;
    }

    @Override // dc.z74
    @Nullable
    public Object a(@Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
        Object objC;
        return (!d(obj) && (objC = c(obj, continuation)) == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objC : Unit.INSTANCE;
    }

    @Override // dc.z74
    public void b(@Nullable Object obj) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof y74) {
                if (obj == null) {
                    if (!(((y74) obj2).a != b84.c)) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    y74 y74Var = (y74) obj2;
                    if (!(y74Var.a == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + y74Var.a + " but expected " + obj).toString());
                    }
                }
                if (a.compareAndSet(this, obj2, b84.e)) {
                    return;
                }
            } else if (obj2 instanceof o64) {
                ((o64) obj2).c(this);
            } else {
                if (!(obj2 instanceof c)) {
                    throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", obj2).toString());
                }
                if (obj != null) {
                    c cVar = (c) obj2;
                    if (!(cVar.d == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + cVar.d + " but expected " + obj).toString());
                    }
                }
                c cVar2 = (c) obj2;
                g64 g64VarG = cVar2.G();
                if (g64VarG == null) {
                    d dVar = new d(cVar2);
                    if (a.compareAndSet(this, obj2, dVar) && dVar.c(this) == null) {
                        return;
                    }
                } else {
                    b bVar = (b) g64VarG;
                    if (bVar.M()) {
                        Object obj3 = bVar.d;
                        if (obj3 == null) {
                            obj3 = b84.b;
                        }
                        cVar2.d = obj3;
                        bVar.K();
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
    
        dc.bz3.c(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        r7 = r0.x();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0079, code lost:
    
        if (r7 != kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
    
        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
    
        if (r7 != kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0087, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(java.lang.Object r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r8)
            dc.zy3 r0 = dc.bz3.b(r0)
            dc.a84$a r1 = new dc.a84$a
            r1.<init>(r7, r0)
        Ld:
            java.lang.Object r2 = r6._state
            boolean r3 = r2 instanceof dc.y74
            if (r3 == 0) goto L4a
            r3 = r2
            dc.y74 r3 = (dc.y74) r3
            java.lang.Object r4 = r3.a
            dc.t64 r5 = dc.b84.f()
            if (r4 == r5) goto L2b
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = dc.a84.a
            dc.a84$c r5 = new dc.a84$c
            java.lang.Object r3 = r3.a
            r5.<init>(r3)
            r4.compareAndSet(r6, r2, r5)
            goto Ld
        L2b:
            if (r7 != 0) goto L32
            dc.y74 r3 = dc.b84.c()
            goto L37
        L32:
            dc.y74 r3 = new dc.y74
            r3.<init>(r7)
        L37:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = dc.a84.a
            boolean r2 = r4.compareAndSet(r6, r2, r3)
            if (r2 == 0) goto Ld
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            dc.a84$e r2 = new dc.a84$e
            r2.<init>(r7)
            r0.i(r1, r2)
            goto L71
        L4a:
            boolean r3 = r2 instanceof dc.a84.c
            if (r3 == 0) goto L98
            r3 = r2
            dc.a84$c r3 = (dc.a84.c) r3
            java.lang.Object r4 = r3.d
            if (r4 == r7) goto L57
            r4 = 1
            goto L58
        L57:
            r4 = 0
        L58:
            if (r4 == 0) goto L88
            r3.s(r1)
            java.lang.Object r3 = r6._state
            if (r3 == r2) goto L6e
            boolean r2 = r1.L()
            if (r2 != 0) goto L68
            goto L6e
        L68:
            dc.a84$a r1 = new dc.a84$a
            r1.<init>(r7, r0)
            goto Ld
        L6e:
            dc.bz3.c(r0, r1)
        L71:
            java.lang.Object r7 = r0.x()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r0) goto L7e
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r8)
        L7e:
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r8) goto L85
            return r7
        L85:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L88:
            java.lang.String r8 = "Already locked by "
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r7)
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        L98:
            boolean r3 = r2 instanceof dc.o64
            if (r3 == 0) goto La3
            dc.o64 r2 = (dc.o64) r2
            r2.c(r6)
            goto Ld
        La3:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Illegal state "
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r2)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.a84.c(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean d(@Nullable Object obj) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof y74) {
                if (((y74) obj2).a != b84.c) {
                    return false;
                }
                if (a.compareAndSet(this, obj2, obj == null ? b84.d : new y74(obj))) {
                    return true;
                }
            } else {
                if (obj2 instanceof c) {
                    if (((c) obj2).d != obj) {
                        return false;
                    }
                    throw new IllegalStateException(Intrinsics.stringPlus("Already locked by ", obj).toString());
                }
                if (!(obj2 instanceof o64)) {
                    throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", obj2).toString());
                }
                ((o64) obj2).c(this);
            }
        }
    }

    @NotNull
    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof y74) {
                return "Mutex[" + ((y74) obj).a + ']';
            }
            if (!(obj instanceof o64)) {
                if (!(obj instanceof c)) {
                    throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", obj).toString());
                }
                return "Mutex[" + ((c) obj).d + ']';
            }
            ((o64) obj).c(this);
        }
    }
}
