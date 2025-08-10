package dc;

import com.component.dxtoy.core.commandcore.bean.BaseToyCommandBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Single.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/component/dxtoy/command/code/CmdRotateChange;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "(Ljava/lang/String;)V", "verifyValues", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class h70 extends b90 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h70(@NotNull String mac) {
        super(ma0.a.w(), mac, new int[0]);
        Intrinsics.checkNotNullParameter(mac, "mac");
        BaseToyCommandBean.Companion companion = BaseToyCommandBean.INSTANCE;
        removeSendType(companion.getDefaultDiscard());
        removeSendType(companion.getDefaultLastSendSame());
    }

    @Override // dc.b90
    public boolean g() {
        nb0 nb0VarC = c();
        if (nb0VarC != null ? tb0.w(nb0VarC) : false) {
            return super.g();
        }
        onError(mt.ILLEGAL_ARGUMENT, "Toy not support " + getC() + " command");
        return false;
    }
}
