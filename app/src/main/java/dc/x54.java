package dc;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DispatchedContinuation.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0006\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082\b\u001aU\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00152%\b\u0002\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0012\u0010\u001d\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00100\bH\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "getREUSABLE_CLAIMED$annotations", "()V", "UNDEFINED", "getUNDEFINED$annotations", "executeUnconfined", "", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeCancellableWith", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "yieldUndispatched", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class x54 {

    @NotNull
    public static final t64 a = new t64("UNDEFINED");

    @JvmField
    @NotNull
    public static final t64 b = new t64("REUSABLE_CLAIMED");

    /* JADX WARN: Finally extract failed */
    public static final <T> void b(@NotNull Continuation<? super T> continuation, @NotNull Object obj, @Nullable Function1<? super Throwable, Unit> function1) {
        boolean z;
        if (!(continuation instanceof w54)) {
            continuation.resumeWith(obj);
            return;
        }
        w54 w54Var = (w54) continuation;
        Object objB = mz3.b(obj, function1);
        if (w54Var.d.isDispatchNeeded(w54Var.get$context())) {
            w54Var.f = objB;
            w54Var.c = 1;
            w54Var.d.dispatch(w54Var.get$context(), w54Var);
            return;
        }
        a04.a();
        r04 r04VarB = g24.a.b();
        if (r04VarB.g0()) {
            w54Var.f = objB;
            w54Var.c = 1;
            r04VarB.V(w54Var);
            return;
        }
        r04VarB.e0(true);
        try {
            h14 h14Var = (h14) w54Var.get$context().get(h14.I);
            if (h14Var == null || h14Var.isActive()) {
                z = false;
            } else {
                CancellationException cancellationExceptionM = h14Var.m();
                w54Var.b(objB, cancellationExceptionM);
                Result.Companion companion = Result.INSTANCE;
                w54Var.resumeWith(Result.m86constructorimpl(ResultKt.createFailure(cancellationExceptionM)));
                z = true;
            }
            if (!z) {
                Continuation<T> continuation2 = w54Var.e;
                Object obj2 = w54Var.g;
                CoroutineContext context = continuation2.get$context();
                Object objC = x64.c(context, obj2);
                i24<?> i24VarG = objC != x64.a ? pz3.g(continuation2, context, objC) : null;
                try {
                    w54Var.e.resumeWith(obj);
                    Unit unit = Unit.INSTANCE;
                    if (i24VarG == null || i24VarG.P0()) {
                        x64.a(context, objC);
                    }
                } catch (Throwable th) {
                    if (i24VarG == null || i24VarG.P0()) {
                        x64.a(context, objC);
                    }
                    throw th;
                }
            }
            while (r04VarB.j0()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void c(Continuation continuation, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        b(continuation, obj, function1);
    }
}
