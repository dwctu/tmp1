package dc;

import com.component.dxbilog.lib.manual.bean.BILogHttpConfig;
import com.component.dxdatabase.lib.bean.BILogDbBean;
import com.wear.activity.orgySetting.OrgySetting;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogExpiredStrategy.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J\u0016\u0010\u000b\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0016\u0010\f\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/component/dxbilog/lib/manual/strategy/BILogExpiredStrategy;", "Lcom/component/dxbilog/lib/manual/strategy/handler/BaseStrategyHandler;", "()V", "isEnable", "", "()Z", "handle", "", "beanList", "", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "handleFailExpiredMaxDays", "handleNormalExpiredMaxDays", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class vs extends bt {
    @Override // dc.bt, dc.ct
    public void a(@Nullable List<BILogDbBean> list) {
        f(list);
        g(list);
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

    public final void f(@Nullable List<BILogDbBean> list) {
        BILogHttpConfig bILogHttpConfigB;
        Date updated;
        if ((list == null || list.isEmpty()) || (bILogHttpConfigB = ks.a.b().b()) == null) {
            return;
        }
        long failExpiredMaxDays = (long) (OrgySetting.ONE_HOURE_MSEC * bILogHttpConfigB.getFailExpiredMaxDays());
        ArrayList arrayList = new ArrayList();
        for (BILogDbBean bILogDbBean : list) {
            if (bILogDbBean.getFailCount() != null) {
                Integer failCount = bILogDbBean.getFailCount();
                Intrinsics.checkNotNull(failCount);
                if (failCount.intValue() > 0 && (updated = bILogDbBean.getUpdated()) != null && System.currentTimeMillis() - updated.getTime() > failExpiredMaxDays) {
                    arrayList.add(bILogDbBean);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            ms.a.a(Intrinsics.stringPlus("handleFailExpiredMaxDays removeList = ", xd0.j(arrayList)));
            list.removeAll(arrayList);
            zw.e.b(arrayList);
        }
    }

    public final void g(@Nullable List<BILogDbBean> list) {
        BILogHttpConfig bILogHttpConfigB;
        Date updated;
        if ((list == null || list.isEmpty()) || (bILogHttpConfigB = ks.a.b().b()) == null) {
            return;
        }
        long normalExpiredMaxDays = (long) (OrgySetting.ONE_HOURE_MSEC * bILogHttpConfigB.getNormalExpiredMaxDays());
        ArrayList arrayList = new ArrayList();
        for (BILogDbBean bILogDbBean : list) {
            if (bILogDbBean.getFailCount() != null) {
                Integer failCount = bILogDbBean.getFailCount();
                Intrinsics.checkNotNull(failCount);
                if (failCount.intValue() == 0 && (updated = bILogDbBean.getUpdated()) != null && System.currentTimeMillis() - updated.getTime() > normalExpiredMaxDays) {
                    arrayList.add(bILogDbBean);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            ms.a.a(Intrinsics.stringPlus("handleNormalExpiredMaxDays removeList = ", xd0.j(arrayList)));
            list.removeAll(arrayList);
            zw.e.b(arrayList);
        }
    }
}
