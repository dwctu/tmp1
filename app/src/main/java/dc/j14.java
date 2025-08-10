package dc;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0003R\u0014\u0010\u0006\u001a\u00020\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "handlesException", "", "getHandlesException$kotlinx_coroutines_core", "()Z", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "complete", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class j14 extends o14 implements hz3 {
    public final boolean b;

    public j14(@Nullable h14 h14Var) {
        super(true);
        d0(h14Var);
        this.b = K0();
    }

    public final boolean K0() {
        ez3 ez3VarY = Y();
        fz3 fz3Var = ez3VarY instanceof fz3 ? (fz3) ez3VarY : null;
        o14 o14VarL = fz3Var == null ? null : fz3Var.L();
        if (o14VarL == null) {
            return false;
        }
        while (!o14VarL.getB()) {
            ez3 ez3VarY2 = o14VarL.Y();
            fz3 fz3Var2 = ez3VarY2 instanceof fz3 ? (fz3) ez3VarY2 : null;
            o14VarL = fz3Var2 == null ? null : fz3Var2.L();
            if (o14VarL == null) {
                return false;
            }
        }
        return true;
    }

    @Override // dc.o14
    /* renamed from: U, reason: from getter */
    public boolean getB() {
        return this.b;
    }

    @Override // dc.o14
    public boolean V() {
        return true;
    }
}
