package dc;

import androidx.exifinterface.media.ExifInterface;
import dc.g64;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0014\u0010\f\u001a\u00020\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/SendElement;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Send;", "pollResult", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "getPollResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "completeResumeSend", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class m34<E> extends k34 {
    public final E d;

    @JvmField
    @NotNull
    public final yy3<Unit> e;

    /* JADX WARN: Multi-variable type inference failed */
    public m34(E e, @NotNull yy3<? super Unit> yy3Var) {
        this.d = e;
        this.e = yy3Var;
    }

    @Override // dc.k34
    public void K() {
        this.e.t(az3.a);
    }

    @Override // dc.k34
    /* renamed from: L */
    public E getD() {
        return this.d;
    }

    @Override // dc.k34
    public void M(@NotNull a34<?> a34Var) {
        yy3<Unit> yy3Var = this.e;
        Result.Companion companion = Result.INSTANCE;
        yy3Var.resumeWith(Result.m86constructorimpl(ResultKt.createFailure(a34Var.S())));
    }

    @Override // dc.k34
    @Nullable
    public t64 N(@Nullable g64.c cVar) {
        Object objA = this.e.a(Unit.INSTANCE, cVar == null ? null : cVar.a);
        if (objA == null) {
            return null;
        }
        if (a04.a()) {
            if (!(objA == az3.a)) {
                throw new AssertionError();
            }
        }
        if (cVar == null) {
            return az3.a;
        }
        cVar.d();
        throw null;
    }

    @Override // dc.g64
    @NotNull
    public String toString() {
        return b04.a(this) + '@' + b04.b(this) + '(' + getD() + ')';
    }
}
