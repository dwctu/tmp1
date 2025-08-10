package dc;

import com.component.dxtoy.core.commandcore.bean.ToyCommandBean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandInterceptor.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Lcom/component/dxtoy/core/commandcore/interceptor/ToyCommandInterceptor;", "", "()V", "commandIntercept", "", "commandBean", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "receiveIntercept", "", "sendIntercept", "statusIntercept", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ua0 {
    public final boolean a(ToyCommandBean toyCommandBean) {
        if (!toyCommandBean.isIllegal()) {
            return false;
        }
        toyCommandBean.onError(mt.ILLEGAL_ARGUMENT, "commandIntercept command not isLegal");
        return true;
    }

    public final boolean b(@NotNull ToyCommandBean commandBean) {
        Intrinsics.checkNotNullParameter(commandBean, "commandBean");
        return c(commandBean) || a(commandBean);
    }

    public final boolean c(@NotNull ToyCommandBean commandBean) {
        Intrinsics.checkNotNullParameter(commandBean, "commandBean");
        if (commandBean.getB().length() == 0) {
            commandBean.onError(mt.ILLEGAL_ARGUMENT, "statusIntercept mac not empty");
            return true;
        }
        hb0 hb0Var = hb0.a;
        nb0 nb0Var = hb0Var.e().get(commandBean.getB());
        if (nb0Var == null || nb0Var.getF() != sb0.CONNECT_SUC) {
            commandBean.onError(mt.BLE_NOT_CONNECTED, "statusIntercept toy not connect");
            return true;
        }
        Pair<Boolean, mt> pairA = pt.a.a();
        boolean zBooleanValue = pairA.component1().booleanValue();
        mt mtVarComponent2 = pairA.component2();
        if (!zBooleanValue) {
            commandBean.onError(mtVarComponent2, "statusIntercept = bluetooth is not enable");
            return true;
        }
        if (!hb0Var.h()) {
            return false;
        }
        commandBean.onError(mt.ILLEGAL_ARGUMENT, "toy is updating");
        return true;
    }
}
