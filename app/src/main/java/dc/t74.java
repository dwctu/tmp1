package dc;

import dc.g64;
import dc.h14;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Select.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020Y2\b\u0012\u0004\u0012\u00028\u00000Z2\b\u0012\u0004\u0012\u00028\u00000[2\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060Bj\u0002`C:\u0004TUVWB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ.\u0010\u0011\u001a\u00020\b2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\fJ8\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0 H\u0016ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u0004\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0019H\u0016¢\u0006\u0004\b(\u0010\u001cJ \u0010+\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000)H\u0016ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u001b\u00105\u001a\u0004\u0018\u00010\u000e2\b\u00104\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0004\b5\u00106J5\u00108\u001a\u00020\b*\u0002072\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0 H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b8\u00109JG\u00108\u001a\u00020\b\"\u0004\b\u0001\u0010:*\b\u0012\u0004\u0012\u00028\u00010;2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0<H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b8\u0010=J[\u00108\u001a\u00020\b\"\u0004\b\u0001\u0010>\"\u0004\b\u0002\u0010:*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020?2\u0006\u0010@\u001a\u00028\u00012\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0<H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b8\u0010AR\u001c\u0010F\u001a\n\u0018\u00010Bj\u0004\u0018\u0001`C8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010N\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u00102R(\u0010R\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010\nR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010S\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006X"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl;", "R", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "handle", "", "disposeOnSelect", "(Lkotlinx/coroutines/DisposableHandle;)V", "doAfterSelect", "()V", "Lkotlin/Function0;", "", "value", "block", "doResume", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "e", "handleBuilderException", "(Ljava/lang/Throwable;)V", "initCancellability", "", "timeMillis", "Lkotlin/Function1;", "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "performAtomicTrySelect", "(Lkotlinx/coroutines/internal/AtomicDesc;)Ljava/lang/Object;", "exception", "resumeSelectWithException", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "trySelect", "()Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "trySelectOther", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectClause0;", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getCompletion", "()Lkotlin/coroutines/Continuation;", "completion", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "isSelected", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "parentHandle", "Lkotlin/coroutines/Continuation;", "AtomicSelectOp", "DisposeNode", "PairSelectOp", "SelectOnCancelling", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstance;"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PublishedApi
/* renamed from: dc.t74, reason: from toString */
/* loaded from: classes5.dex */
public final class SelectInstance<R> extends e64 implements s74<R>, v74<R>, Continuation<R>, CoroutineStackFrame {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(SelectInstance.class, Object.class, "_state");
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(SelectInstance.class, Object.class, "_result");

    @NotNull
    public final Continuation<R> d;

    /* renamed from: _state, reason: from toString */
    @NotNull
    public volatile /* synthetic */ Object state = w74.c();

    /* renamed from: _result, reason: from toString */
    @NotNull
    private volatile /* synthetic */ Object result = w74.c;

    @NotNull
    private volatile /* synthetic */ Object _parentHandle = null;

    /* compiled from: Select.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$DisposeNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: dc.t74$a */
    public static final class a extends g64 {

        @JvmField
        @NotNull
        public final o04 d;

        public a(@NotNull o04 o04Var) {
            this.d = o04Var;
        }
    }

    /* compiled from: Select.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$PairSelectOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: dc.t74$b */
    public static final class b extends o64 {

        @JvmField
        @NotNull
        public final g64.c a;

        public b(@NotNull g64.c cVar) {
        }

        @Override // dc.o64
        @NotNull
        public r54<?> a() {
            this.a.a();
            throw null;
        }

        @Override // dc.o64
        @Nullable
        public Object c(@Nullable Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
            this.a.d();
            throw null;
        }
    }

    /* compiled from: Select.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$SelectOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: dc.t74$c */
    public final class c extends i14 {
        public c() {
        }

        @Override // dc.lz3
        public void K(@Nullable Throwable th) {
            if (SelectInstance.this.k()) {
                SelectInstance.this.o(L().m());
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            K(th);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectInstance(@NotNull Continuation<? super R> continuation) {
        this.d = continuation;
    }

    public final void M() {
        o04 o04VarN = N();
        if (o04VarN != null) {
            o04VarN.dispose();
        }
        for (g64 g64VarA = (g64) z(); !Intrinsics.areEqual(g64VarA, this); g64VarA = g64VarA.A()) {
            if (g64VarA instanceof a) {
                ((a) g64VarA).d.dispose();
            }
        }
    }

    public final o04 N() {
        return (o04) this._parentHandle;
    }

    @PublishedApi
    @Nullable
    public final Object O() {
        if (!e()) {
            Q();
        }
        Object obj = this.result;
        if (obj == w74.c) {
            if (f.compareAndSet(this, w74.c, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            obj = this.result;
        }
        if (obj == w74.d) {
            throw new IllegalStateException("Already resumed");
        }
        if (obj instanceof jz3) {
            throw ((jz3) obj).a;
        }
        return obj;
    }

    @PublishedApi
    public final void P(@NotNull Throwable th) {
        if (k()) {
            Result.Companion companion = Result.INSTANCE;
            resumeWith(Result.m86constructorimpl(ResultKt.createFailure(th)));
        } else {
            if (th instanceof CancellationException) {
                return;
            }
            Object objO = O();
            if (objO instanceof jz3) {
                Throwable thN = ((jz3) objO).a;
                if (a04.d()) {
                    thN = s64.n(thN);
                }
                if (thN == (!a04.d() ? th : s64.n(th))) {
                    return;
                }
            }
            tz3.a(get$context(), th);
        }
    }

    public final void Q() {
        h14 h14Var = (h14) get$context().get(h14.I);
        if (h14Var == null) {
            return;
        }
        o04 o04VarD = h14.a.d(h14Var, true, false, new c(), 2, null);
        R(o04VarD);
        if (e()) {
            o04VarD.dispose();
        }
    }

    public final void R(o04 o04Var) {
        this._parentHandle = o04Var;
    }

    @Nullable
    public Object S(@Nullable g64.c cVar) {
        while (true) {
            Object obj = this.state;
            if (obj == w74.c()) {
                if (cVar != null) {
                    b bVar = new b(cVar);
                    if (e.compareAndSet(this, w74.c(), bVar)) {
                        bVar.c(this);
                        throw null;
                    }
                } else if (e.compareAndSet(this, w74.c(), null)) {
                    M();
                    return az3.a;
                }
            } else {
                if (!(obj instanceof o64)) {
                    if (cVar != null && obj == cVar.a) {
                        return az3.a;
                    }
                    return null;
                }
                if (cVar != null) {
                    cVar.a();
                    throw null;
                }
                ((o64) obj).c(this);
            }
        }
    }

    @Override // dc.v74
    public boolean e() {
        while (true) {
            Object obj = this.state;
            if (obj == w74.c()) {
                return false;
            }
            if (!(obj instanceof o64)) {
                return true;
            }
            ((o64) obj).c(this);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<R> continuation = this.d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    /* renamed from: getContext */
    public CoroutineContext get$context() {
        return this.d.get$context();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // dc.v74
    public void j(@NotNull o04 o04Var) {
        a aVar = new a(o04Var);
        if (!e()) {
            s(aVar);
            if (!e()) {
                return;
            }
        }
        o04Var.dispose();
    }

    @Override // dc.v74
    public boolean k() {
        Object objS = S(null);
        if (objS == az3.a) {
            return true;
        }
        if (objS == null) {
            return false;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Unexpected trySelectIdempotent result ", objS).toString());
    }

    @Override // dc.v74
    @NotNull
    public Continuation<R> m() {
        return this;
    }

    @Override // dc.v74
    public void o(@NotNull Throwable th) {
        if (a04.a() && !e()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this.result;
            if (obj == w74.c) {
                Continuation<R> continuation = this.d;
                if (f.compareAndSet(this, w74.c, new jz3((a04.d() && (continuation instanceof CoroutineStackFrame)) ? s64.j(th, (CoroutineStackFrame) continuation) : th, false, 2, null))) {
                    return;
                }
            } else {
                if (obj != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (f.compareAndSet(this, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED(), w74.d)) {
                    Continuation continuationIntercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.d);
                    Result.Companion companion = Result.INSTANCE;
                    continuationIntercepted.resumeWith(Result.m86constructorimpl(ResultKt.createFailure(th)));
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.s74
    public <Q> void q(@NotNull u74<? extends Q> u74Var, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        u74Var.c(this, function2);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object result) {
        if (a04.a() && !e()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this.result;
            if (obj == w74.c) {
                if (f.compareAndSet(this, w74.c, mz3.d(result, null, 1, null))) {
                    return;
                }
            } else {
                if (obj != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (f.compareAndSet(this, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED(), w74.d)) {
                    if (!Result.m92isFailureimpl(result)) {
                        this.d.resumeWith(result);
                        return;
                    }
                    Continuation<R> continuation = this.d;
                    Throwable thM89exceptionOrNullimpl = Result.m89exceptionOrNullimpl(result);
                    Intrinsics.checkNotNull(thM89exceptionOrNullimpl);
                    Result.Companion companion = Result.INSTANCE;
                    if (a04.d() && (continuation instanceof CoroutineStackFrame)) {
                        thM89exceptionOrNullimpl = s64.j(thM89exceptionOrNullimpl, (CoroutineStackFrame) continuation);
                    }
                    continuation.resumeWith(Result.m86constructorimpl(ResultKt.createFailure(thM89exceptionOrNullimpl)));
                    return;
                }
            }
        }
    }

    @Override // dc.g64
    @NotNull
    public String toString() {
        return "SelectInstance(state=" + this.state + ", result=" + this.result + ')';
    }
}
