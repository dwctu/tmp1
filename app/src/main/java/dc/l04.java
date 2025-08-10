package dc;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: DispatchedTask.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a.\u0010\u0011\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0015\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000fH\u0002\u001a\u0019\u0010\u0016\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a'\u0010\u0019\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n\"\u0018\u0010\u000b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u001e"}, d2 = {"MODE_ATOMIC", "", "MODE_CANCELLABLE", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE_REUSABLE", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "isCancellableMode", "", "(I)Z", "isReusableMode", "dispatch", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/DispatchedTask;", "mode", StreamManagement.Resume.ELEMENT, "delegate", "Lkotlin/coroutines/Continuation;", "undispatched", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class l04 {
    public static final <T> void a(@NotNull k04<? super T> k04Var, int i) {
        if (a04.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        Continuation<? super T> continuationC = k04Var.c();
        boolean z = i == 4;
        if (z || !(continuationC instanceof w54) || b(i) != b(k04Var.c)) {
            d(k04Var, continuationC, z);
            return;
        }
        qz3 qz3Var = ((w54) continuationC).d;
        CoroutineContext b = continuationC.get$context();
        if (qz3Var.isDispatchNeeded(b)) {
            qz3Var.dispatch(b, k04Var);
        } else {
            e(k04Var);
        }
    }

    public static final boolean b(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean c(int i) {
        return i == 2;
    }

    public static final <T> void d(@NotNull k04<? super T> k04Var, @NotNull Continuation<? super T> continuation, boolean z) {
        Object objE;
        Object objJ = k04Var.j();
        Throwable thD = k04Var.d(objJ);
        if (thD != null) {
            Result.Companion companion = Result.INSTANCE;
            objE = ResultKt.createFailure(thD);
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            objE = k04Var.e(objJ);
        }
        Object objM86constructorimpl = Result.m86constructorimpl(objE);
        if (!z) {
            continuation.resumeWith(objM86constructorimpl);
            return;
        }
        w54 w54Var = (w54) continuation;
        Continuation<T> continuation2 = w54Var.e;
        Object obj = w54Var.g;
        CoroutineContext b = continuation2.get$context();
        Object objC = x64.c(b, obj);
        i24<?> i24VarG = objC != x64.a ? pz3.g(continuation2, b, objC) : null;
        try {
            w54Var.e.resumeWith(objM86constructorimpl);
            Unit unit = Unit.INSTANCE;
        } finally {
            if (i24VarG == null || i24VarG.P0()) {
                x64.a(b, objC);
            }
        }
    }

    public static final void e(k04<?> k04Var) {
        r04 r04VarB = g24.a.b();
        if (r04VarB.g0()) {
            r04VarB.V(k04Var);
            return;
        }
        r04VarB.e0(true);
        try {
            d(k04Var, k04Var.c(), true);
            do {
            } while (r04VarB.j0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
