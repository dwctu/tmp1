package dc;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StateFlow.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0013B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f0\u000b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0002J\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "<init>", "()V", "Lkotlinx/coroutines/flow/StateFlowImpl;", "flow", "", "allocateLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", "", "awaitPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlin/coroutines/Continuation;", "freeLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class r44 extends w44<p44<?>> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(r44.class, Object.class, "_state");

    @NotNull
    public volatile /* synthetic */ Object _state = null;

    @Override // dc.w44
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull p44<?> p44Var) {
        if (this._state != null) {
            return false;
        }
        this._state = q44.a;
        return true;
    }

    @Nullable
    public final Object d(@NotNull Continuation<? super Unit> continuation) {
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        if (a04.a() && !(!(this._state instanceof zy3))) {
            throw new AssertionError();
        }
        if (!a.compareAndSet(this, q44.a, zy3Var)) {
            if (a04.a()) {
                if (!(this._state == q44.b)) {
                    throw new AssertionError();
                }
            }
            Result.Companion companion = Result.INSTANCE;
            zy3Var.resumeWith(Result.m86constructorimpl(Unit.INSTANCE));
        }
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objX : Unit.INSTANCE;
    }

    @Override // dc.w44
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Continuation<Unit>[] b(@NotNull p44<?> p44Var) {
        this._state = null;
        return v44.a;
    }

    public final void f() {
        while (true) {
            Object obj = this._state;
            if (obj == null || obj == q44.b) {
                return;
            }
            if (obj == q44.a) {
                if (a.compareAndSet(this, obj, q44.b)) {
                    return;
                }
            } else if (a.compareAndSet(this, obj, q44.a)) {
                Result.Companion companion = Result.INSTANCE;
                ((zy3) obj).resumeWith(Result.m86constructorimpl(Unit.INSTANCE));
                return;
            }
        }
    }

    public final boolean g() {
        Object andSet = a.getAndSet(this, q44.a);
        Intrinsics.checkNotNull(andSet);
        if (!a04.a() || (!(andSet instanceof zy3))) {
            return andSet == q44.b;
        }
        throw new AssertionError();
    }
}
