package dc;

import androidx.exifinterface.media.ExifInterface;
import dc.h14;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletionHandlerException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: CancellableContinuationImpl.kt */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\t\u0012\u0004\u0012\u00028\u00000\u008a\u00012\t\u0012\u0004\u0012\u00028\u00000\u008b\u00012\u00060tj\u0002`uB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013JB\u0010\u0012\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0018J\u001e\u0010\u001b\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019H\u0082\b¢\u0006\u0004\b\u001b\u0010\u001cJ8\u0010\u001e\u001a\u00020\u00112!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u0018J\u0019\u0010 \u001a\u00020\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b \u0010!J!\u0010%\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0010¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b&\u0010!J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010,\u001a\u00020\u0011H\u0000¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020\u0011H\u0002¢\u0006\u0004\b-\u0010+J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u000f2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u001b\u00108\u001a\u0004\u0018\u00010\u000f2\b\u00105\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b6\u00107J\u0011\u00109\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\n\u0018\u00010;j\u0004\u0018\u0001`<H\u0016¢\u0006\u0004\b=\u0010>J\u001f\u0010A\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u00105\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020\u0011H\u0016¢\u0006\u0004\bB\u0010+J\u0011\u0010D\u001a\u0004\u0018\u00010CH\u0002¢\u0006\u0004\bD\u0010EJ8\u0010F\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u0017H\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u001fH\u0002¢\u0006\u0004\bH\u0010IJ8\u0010J\u001a\u00020\r2'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u0017H\u0002¢\u0006\u0004\bJ\u0010KJB\u0010L\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u00172\b\u00105\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\bL\u0010MJ\u000f\u0010O\u001a\u00020NH\u0014¢\u0006\u0004\bO\u0010PJ\u0017\u0010S\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\bQ\u0010RJ\u000f\u0010T\u001a\u00020\u0011H\u0002¢\u0006\u0004\bT\u0010+J\u000f\u0010U\u001a\u00020\u001fH\u0001¢\u0006\u0004\bU\u0010IJ<\u0010W\u001a\u00020\u00112\u0006\u0010V\u001a\u00028\u00002#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0016¢\u0006\u0004\bW\u0010XJH\u0010Y\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0002¢\u0006\u0004\bY\u0010ZJ \u0010]\u001a\u00020\u00112\f\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000[H\u0016ø\u0001\u0000¢\u0006\u0004\b]\u0010)JZ\u0010`\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u00020^2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\b\u0010_\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b`\u0010aJ\u0011\u0010c\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\bb\u0010:J\u000f\u0010d\u001a\u00020NH\u0016¢\u0006\u0004\bd\u0010PJ\u000f\u0010e\u001a\u00020\u001fH\u0002¢\u0006\u0004\be\u0010IJ#\u0010e\u001a\u0004\u0018\u00010\b2\u0006\u0010V\u001a\u00028\u00002\b\u0010_\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\be\u0010fJH\u0010e\u001a\u0004\u0018\u00010\b2\u0006\u0010V\u001a\u00028\u00002\b\u0010_\u001a\u0004\u0018\u00010\b2#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0016¢\u0006\u0004\be\u0010gJJ\u0010i\u001a\u0004\u0018\u00010h2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010_\u001a\u0004\u0018\u00010\b2#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0002¢\u0006\u0004\bi\u0010jJ\u0019\u0010l\u001a\u0004\u0018\u00010\b2\u0006\u0010k\u001a\u00020\u000fH\u0016¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020\u001fH\u0002¢\u0006\u0004\bn\u0010IJ\u001b\u0010p\u001a\u00020\u0011*\u00020o2\u0006\u0010V\u001a\u00028\u0000H\u0016¢\u0006\u0004\bp\u0010qJ\u001b\u0010r\u001a\u00020\u0011*\u00020o2\u0006\u0010k\u001a\u00020\u000fH\u0016¢\u0006\u0004\br\u0010sR\u001c\u0010x\u001a\n\u0018\u00010tj\u0004\u0018\u0001`u8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR\u001a\u0010z\u001a\u00020y8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0080\u0004¢\u0006\r\n\u0004\b\u0003\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0016\u0010\u0081\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010IR\u0016\u0010\u0082\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010IR\u0016\u0010\u0083\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010IR\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0017\u00105\u001a\u0004\u0018\u00010\b8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010:R\u0016\u0010\u0088\u0001\u001a\u00020N8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010P\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0089\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)Ljava/lang/Void;", "Lkotlinx/coroutines/CancelHandler;", "handler", "", "cause", "", "callCancelHandler", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "Lkotlin/Function0;", "block", "callCancelHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "onCancellation", "callOnCancellation", "", "cancel", "(Ljava/lang/Throwable;)Z", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "cancelLater", "token", "completeResume", "(Ljava/lang/Object;)V", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "state", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlinx/coroutines/DisposableHandle;", "installParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "()Z", "makeCancelHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "releaseClaimedReusableContinuation", "resetStateReusable", "value", StreamManagement.Resume.ELEMENT, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeImpl", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlin/Result;", "result", "resumeWith", "Lkotlinx/coroutines/NotCompleted;", "idempotent", "resumedState", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/Symbol;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "getState$kotlinx_coroutines_core", "getStateDebugRepresentation", "stateDebugRepresentation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PublishedApi
/* loaded from: classes4.dex */
public class zy3<T> extends k04<T> implements yy3<T>, CoroutineStackFrame {
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(zy3.class, "_decision");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(zy3.class, Object.class, "_state");

    @NotNull
    private volatile /* synthetic */ int _decision;

    @NotNull
    private volatile /* synthetic */ Object _state;

    @NotNull
    public final Continuation<T> d;

    @NotNull
    public final CoroutineContext e;

    @Nullable
    public o04 f;

    /* JADX WARN: Multi-variable type inference failed */
    public zy3(@NotNull Continuation<? super T> continuation, int i) {
        super(i);
        this.d = continuation;
        if (a04.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        this.e = continuation.getB();
        this._decision = 0;
        this._state = oy3.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void L(zy3 zy3Var, Object obj, int i, Function1 function1, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        zy3Var.K(obj, i, function1);
    }

    public void A() {
        o04 o04VarB = B();
        if (o04VarB != null && C()) {
            o04VarB.dispose();
            this.f = u14.a;
        }
    }

    public final o04 B() {
        h14 h14Var = (h14) getB().get(h14.I);
        if (h14Var == null) {
            return null;
        }
        o04 o04VarD = h14.a.d(h14Var, true, false, new dz3(this), 2, null);
        this.f = o04VarD;
        return o04VarD;
    }

    public boolean C() {
        return !(get_state() instanceof v14);
    }

    public final boolean D() {
        return l04.c(this.c) && ((w54) this.d).p();
    }

    public final wy3 E(Function1<? super Throwable, Unit> function1) {
        return function1 instanceof wy3 ? (wy3) function1 : new e14(function1);
    }

    public final void F(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    @NotNull
    public String G() {
        return "CancellableContinuation";
    }

    public final void H(@NotNull Throwable th) {
        if (r(th)) {
            return;
        }
        q(th);
        u();
    }

    public final void I() {
        Continuation<T> continuation = this.d;
        w54 w54Var = continuation instanceof w54 ? (w54) continuation : null;
        Throwable thS = w54Var != null ? w54Var.s(this) : null;
        if (thS == null) {
            return;
        }
        s();
        q(thS);
    }

    @JvmName(name = "resetStateReusable")
    public final boolean J() {
        if (a04.a()) {
            if (!(this.c == 2)) {
                throw new AssertionError();
            }
        }
        if (a04.a()) {
            if (!(this.f != u14.a)) {
                throw new AssertionError();
            }
        }
        Object obj = this._state;
        if (a04.a() && !(!(obj instanceof v14))) {
            throw new AssertionError();
        }
        if ((obj instanceof CompletedContinuation) && ((CompletedContinuation) obj).idempotentResume != null) {
            s();
            return false;
        }
        this._decision = 0;
        this._state = oy3.a;
        return true;
    }

    public final void K(Object obj, int i, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof v14)) {
                if (obj2 instanceof cz3) {
                    cz3 cz3Var = (cz3) obj2;
                    if (cz3Var.c()) {
                        if (function1 == null) {
                            return;
                        }
                        p(function1, cz3Var.a);
                        return;
                    }
                }
                k(obj);
                throw null;
            }
        } while (!h.compareAndSet(this, obj2, M((v14) obj2, obj, i, function1, null)));
        u();
        v(i);
    }

    public final Object M(v14 v14Var, Object obj, int i, Function1<? super Throwable, Unit> function1, Object obj2) {
        if (obj instanceof jz3) {
            if (a04.a()) {
                if (!(obj2 == null)) {
                    throw new AssertionError();
                }
            }
            if (!a04.a()) {
                return obj;
            }
            if (function1 == null) {
                return obj;
            }
            throw new AssertionError();
        }
        if (!l04.b(i) && obj2 == null) {
            return obj;
        }
        if (function1 != null || (((v14Var instanceof wy3) && !(v14Var instanceof py3)) || obj2 != null)) {
            return new CompletedContinuation(obj, v14Var instanceof wy3 ? (wy3) v14Var : null, function1, obj2, null, 16, null);
        }
        return obj;
    }

    public final boolean N() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!g.compareAndSet(this, 0, 2));
        return true;
    }

    public final t64 O(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof v14)) {
                if (!(obj3 instanceof CompletedContinuation) || obj2 == null) {
                    return null;
                }
                CompletedContinuation completedContinuation = (CompletedContinuation) obj3;
                if (completedContinuation.idempotentResume != obj2) {
                    return null;
                }
                if (!a04.a() || Intrinsics.areEqual(completedContinuation.result, obj)) {
                    return az3.a;
                }
                throw new AssertionError();
            }
        } while (!h.compareAndSet(this, obj3, M((v14) obj3, obj, this.c, function1, obj2)));
        u();
        return az3.a;
    }

    public final boolean P() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!g.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // dc.yy3
    @Nullable
    public Object a(T t, @Nullable Object obj) {
        return O(t, obj, null);
    }

    @Override // dc.k04
    public void b(@Nullable Object obj, @NotNull Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof v14) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof jz3) {
                return;
            }
            if (obj2 instanceof CompletedContinuation) {
                CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                if (!(!completedContinuation.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (h.compareAndSet(this, obj2, CompletedContinuation.b(completedContinuation, null, null, null, null, th, 15, null))) {
                    completedContinuation.d(this, th);
                    return;
                }
            } else if (h.compareAndSet(this, obj2, new CompletedContinuation(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // dc.k04
    @NotNull
    public final Continuation<T> c() {
        return this.d;
    }

    @Override // dc.k04
    @Nullable
    public Throwable d(@Nullable Object obj) {
        Throwable thD = super.d(obj);
        if (thD == null) {
            return null;
        }
        Continuation<T> continuationC = c();
        return (a04.d() && (continuationC instanceof CoroutineStackFrame)) ? s64.j(thD, (CoroutineStackFrame) continuationC) : thD;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.k04
    public <T> T e(@Nullable Object obj) {
        return obj instanceof CompletedContinuation ? (T) ((CompletedContinuation) obj).result : obj;
    }

    @Override // dc.yy3
    public void f(@NotNull Function1<? super Throwable, Unit> function1) {
        wy3 wy3VarE = E(function1);
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof oy3)) {
                if (obj instanceof wy3) {
                    F(function1, obj);
                    throw null;
                }
                boolean z = obj instanceof jz3;
                if (z) {
                    jz3 jz3Var = (jz3) obj;
                    if (!jz3Var.b()) {
                        F(function1, obj);
                        throw null;
                    }
                    if (obj instanceof cz3) {
                        if (!z) {
                            jz3Var = null;
                        }
                        m(function1, jz3Var != null ? jz3Var.a : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                    if (completedContinuation.cancelHandler != null) {
                        F(function1, obj);
                        throw null;
                    }
                    if (wy3VarE instanceof py3) {
                        return;
                    }
                    if (completedContinuation.c()) {
                        m(function1, completedContinuation.cancelCause);
                        return;
                    } else {
                        if (h.compareAndSet(this, obj, CompletedContinuation.b(completedContinuation, null, wy3VarE, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (wy3VarE instanceof py3) {
                        return;
                    }
                    if (h.compareAndSet(this, obj, new CompletedContinuation(obj, wy3VarE, null, null, null, 28, null))) {
                        return;
                    }
                }
            } else if (h.compareAndSet(this, obj, wy3VarE)) {
                return;
            }
        }
    }

    @Override // dc.yy3
    @Nullable
    public Object g(@NotNull Throwable th) {
        return O(new jz3(th, false, 2, null), null, null);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    /* renamed from: getContext, reason: from getter */
    public CoroutineContext getB() {
        return this.e;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // dc.yy3
    public void i(T t, @Nullable Function1<? super Throwable, Unit> function1) {
        K(t, this.c, function1);
    }

    @Override // dc.yy3
    public boolean isActive() {
        return get_state() instanceof v14;
    }

    @Override // dc.k04
    @Nullable
    public Object j() {
        return get_state();
    }

    public final Void k(Object obj) {
        throw new IllegalStateException(Intrinsics.stringPlus("Already resumed, but proposed with update ", obj).toString());
    }

    @Override // dc.yy3
    @Nullable
    public Object l(T t, @Nullable Object obj, @Nullable Function1<? super Throwable, Unit> function1) {
        return O(t, obj, function1);
    }

    public final void m(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            tz3.a(getB(), new CompletionHandlerException(Intrinsics.stringPlus("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    @Override // dc.yy3
    public void n(@NotNull qz3 qz3Var, T t) {
        Continuation<T> continuation = this.d;
        w54 w54Var = continuation instanceof w54 ? (w54) continuation : null;
        L(this, t, (w54Var != null ? w54Var.d : null) == qz3Var ? 4 : this.c, null, 4, null);
    }

    public final void o(@NotNull wy3 wy3Var, @Nullable Throwable th) {
        try {
            wy3Var.a(th);
        } catch (Throwable th2) {
            tz3.a(getB(), new CompletionHandlerException(Intrinsics.stringPlus("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    public final void p(@NotNull Function1<? super Throwable, Unit> function1, @NotNull Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            tz3.a(getB(), new CompletionHandlerException(Intrinsics.stringPlus("Exception in resume onCancellation handler for ", this), th2));
        }
    }

    public boolean q(@Nullable Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof v14)) {
                return false;
            }
            z = obj instanceof wy3;
        } while (!h.compareAndSet(this, obj, new cz3(this, th, z)));
        wy3 wy3Var = z ? (wy3) obj : null;
        if (wy3Var != null) {
            o(wy3Var, th);
        }
        u();
        v(this.c);
        return true;
    }

    public final boolean r(Throwable th) {
        if (D()) {
            return ((w54) this.d).q(th);
        }
        return false;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object result) {
        L(this, mz3.c(result, this), this.c, null, 4, null);
    }

    public final void s() {
        o04 o04Var = this.f;
        if (o04Var == null) {
            return;
        }
        o04Var.dispose();
        this.f = u14.a;
    }

    @Override // dc.yy3
    public void t(@NotNull Object obj) {
        if (a04.a()) {
            if (!(obj == az3.a)) {
                throw new AssertionError();
            }
        }
        v(this.c);
    }

    @NotNull
    public String toString() {
        return G() + '(' + b04.c(this.d) + "){" + z() + "}@" + b04.b(this);
    }

    public final void u() {
        if (D()) {
            return;
        }
        s();
    }

    public final void v(int i) {
        if (N()) {
            return;
        }
        l04.a(this, i);
    }

    @NotNull
    public Throwable w(@NotNull h14 h14Var) {
        return h14Var.m();
    }

    @PublishedApi
    @Nullable
    public final Object x() {
        h14 h14Var;
        boolean zD = D();
        if (P()) {
            if (this.f == null) {
                B();
            }
            if (zD) {
                I();
            }
            return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (zD) {
            I();
        }
        Object obj = get_state();
        if (obj instanceof jz3) {
            Throwable th = ((jz3) obj).a;
            if (a04.d()) {
                throw s64.j(th, this);
            }
            throw th;
        }
        if (!l04.b(this.c) || (h14Var = (h14) getB().get(h14.I)) == null || h14Var.isActive()) {
            return e(obj);
        }
        CancellationException cancellationExceptionM = h14Var.m();
        b(obj, cancellationExceptionM);
        if (a04.d()) {
            throw s64.j(cancellationExceptionM, this);
        }
        throw cancellationExceptionM;
    }

    @Nullable
    /* renamed from: y, reason: from getter */
    public final Object get_state() {
        return this._state;
    }

    public final String z() {
        Object obj = get_state();
        return obj instanceof v14 ? "Active" : obj instanceof cz3 ? "Cancelled" : "Completed";
    }
}
