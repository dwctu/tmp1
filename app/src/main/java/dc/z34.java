package dc;

import androidx.exifinterface.media.ExifInterface;
import dc.d54;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Context.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\u0004\u001a(\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a0\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006\u001a\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006\u001a$\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u000f"}, d2 = {"checkFlowContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "checkFlowContext$FlowKt__ContextKt", "buffer", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "cancellable", "conflate", "flowOn", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class z34 {
    @NotNull
    public static final <T> t34<T> a(@NotNull t34<? extends T> t34Var, int i, @NotNull s24 s24Var) {
        int i2;
        s24 s24Var2;
        boolean z = true;
        if (!(i >= 0 || i == -2 || i == -1)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ", Integer.valueOf(i)).toString());
        }
        if (i == -1 && s24Var != s24.SUSPEND) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i == -1) {
            s24Var2 = s24.DROP_OLDEST;
            i2 = 0;
        } else {
            i2 = i;
            s24Var2 = s24Var;
        }
        return t34Var instanceof d54 ? d54.a.a((d54) t34Var, null, i2, s24Var2, 1, null) : new a54(t34Var, null, i2, s24Var2, 2, null);
    }

    public static /* synthetic */ t34 b(t34 t34Var, int i, s24 s24Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        if ((i2 & 2) != 0) {
            s24Var = s24.SUSPEND;
        }
        return v34.c(t34Var, i, s24Var);
    }

    public static final void c(CoroutineContext coroutineContext) {
        if (!(coroutineContext.get(h14.I) == null)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Flow context cannot contain job in it. Had ", coroutineContext).toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> t34<T> d(@NotNull t34<? extends T> t34Var, @NotNull CoroutineContext coroutineContext) {
        c(coroutineContext);
        return Intrinsics.areEqual(coroutineContext, EmptyCoroutineContext.INSTANCE) ? t34Var : t34Var instanceof d54 ? d54.a.a((d54) t34Var, coroutineContext, 0, null, 6, null) : new a54(t34Var, coroutineContext, 0, null, 12, null);
    }
}
