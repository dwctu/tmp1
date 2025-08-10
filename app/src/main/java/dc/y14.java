package dc;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class y14<T> extends n14 {

    @NotNull
    public final zy3<T> e;

    /* JADX WARN: Multi-variable type inference failed */
    public y14(@NotNull zy3<? super T> zy3Var) {
        this.e = zy3Var;
    }

    @Override // dc.lz3
    public void K(@Nullable Throwable th) {
        Object objZ = L().Z();
        if (a04.a() && !(!(objZ instanceof c14))) {
            throw new AssertionError();
        }
        if (objZ instanceof jz3) {
            zy3<T> zy3Var = this.e;
            Result.Companion companion = Result.INSTANCE;
            zy3Var.resumeWith(Result.m86constructorimpl(ResultKt.createFailure(((jz3) objZ).a)));
        } else {
            zy3<T> zy3Var2 = this.e;
            Result.Companion companion2 = Result.INSTANCE;
            zy3Var2.resumeWith(Result.m86constructorimpl(p14.h(objZ)));
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        K(th);
        return Unit.INSTANCE;
    }
}
