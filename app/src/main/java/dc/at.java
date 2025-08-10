package dc;

import com.component.dxbilog.lib.bean.BILogUserConfig;
import com.component.dxdatabase.lib.bean.BILogDbBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogUserInterceptStrategy.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/component/dxbilog/lib/manual/strategy/BILogUserInterceptStrategy;", "Lcom/component/dxbilog/lib/manual/strategy/handler/BaseStrategyHandler;", "()V", "isEnable", "", "()Z", "handle", "", "beanList", "", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "isUserDisable", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class at extends bt {
    @Override // dc.bt, dc.ct
    public void a(@Nullable List<BILogDbBean> list) {
        if (!(list == null || list.isEmpty())) {
            f(list);
        }
        ct a = getA();
        if (a == null) {
            return;
        }
        a.b(list);
    }

    @Override // dc.bt
    public boolean d() {
        return true;
    }

    public final boolean f(List<BILogDbBean> list) {
        ArrayList arrayList = new ArrayList();
        for (BILogDbBean bILogDbBean : list) {
            BILogUserConfig bILogUserConfigD = ks.a.b().d(bILogDbBean.getAccountCode());
            if (bILogUserConfigD != null && bILogUserConfigD.getDisableUser()) {
                arrayList.add(bILogDbBean);
            }
        }
        if (!arrayList.isEmpty()) {
            list.removeAll(arrayList);
            zw.e.c(arrayList);
            ms.a.a(Intrinsics.stringPlus("isUserDisable beanList = ", list), Intrinsics.stringPlus("removeList = ", arrayList));
        }
        return list.isEmpty();
    }
}
