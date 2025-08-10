package dc;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: Builders.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"runBlocking", ExifInterface.GPS_DIRECTION_TRUE, "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class ty3 {
    public static final <T> T a(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super wz3, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        r04 r04VarA;
        CoroutineContext coroutineContextE;
        Thread threadCurrentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.INSTANCE);
        if (continuationInterceptor == null) {
            r04VarA = g24.a.b();
            coroutineContextE = pz3.e(a14.a, coroutineContext.plus(r04VarA));
        } else {
            r04 r04Var = null;
            r04 r04Var2 = continuationInterceptor instanceof r04 ? (r04) continuationInterceptor : null;
            if (r04Var2 != null && r04Var2.k0()) {
                r04Var = r04Var2;
            }
            r04VarA = r04Var == null ? g24.a.a() : r04Var;
            coroutineContextE = pz3.e(a14.a, coroutineContext);
        }
        qy3 qy3Var = new qy3(coroutineContextE, threadCurrentThread, r04VarA);
        qy3Var.N0(yz3.DEFAULT, qy3Var, function2);
        return (T) qy3Var.O0();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) throws InterruptedException {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return sy3.e(coroutineContext, function2);
    }
}
