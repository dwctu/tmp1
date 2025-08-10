package dc;

import com.component.dxbilog.lib.manual.bean.BILogHttpConfig;
import com.component.dxdatabase.lib.bean.BILogDbBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogConfigInterceptStrategy.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J\u0006\u0010\u000b\u001a\u00020\u0004J\u0014\u0010\f\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0014\u0010\r\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/component/dxbilog/lib/manual/strategy/BILogConfigInterceptStrategy;", "Lcom/component/dxbilog/lib/manual/strategy/handler/BaseStrategyHandler;", "()V", "isEnable", "", "()Z", "handle", "", "beanList", "", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "isAppVersionNameBlack", "isEmptyByExceedMaxFailCountList", "isEmptyByHandleLogNoBlack", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class us extends bt {
    @Override // dc.bt, dc.ct
    public void a(@Nullable List<BILogDbBean> list) {
        boolean z = true;
        if (!(list == null || list.isEmpty())) {
            z = f() || h(list) || g(list) || zs.b.d(list);
        }
        if (z && list != null) {
            list.clear();
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

    public final boolean f() {
        boolean zContains;
        List<String> appVersionBlackList;
        String strA;
        ks ksVar = ks.a;
        BILogHttpConfig bILogHttpConfigB = ksVar.b().b();
        if (bILogHttpConfigB == null || (appVersionBlackList = bILogHttpConfigB.getAppVersionBlackList()) == null) {
            zContains = false;
        } else {
            bs b = ksVar.a().getB();
            String str = "";
            if (b != null && (strA = b.a()) != null) {
                str = strA;
            }
            zContains = appVersionBlackList.contains(str);
        }
        if (zContains) {
            zw.e.d();
            ms.a.a(Intrinsics.stringPlus("isAppVersionNameBlack isBlack = ", Boolean.valueOf(zContains)));
        }
        return zContains;
    }

    public final boolean g(@NotNull List<BILogDbBean> beanList) {
        Intrinsics.checkNotNullParameter(beanList, "beanList");
        ArrayList arrayList = new ArrayList();
        for (BILogDbBean bILogDbBean : beanList) {
            if (ws.a.c(bILogDbBean)) {
                arrayList.add(bILogDbBean);
            }
        }
        if (!arrayList.isEmpty()) {
            beanList.removeAll(arrayList);
            zw.e.b(arrayList);
            ms.a.a(Intrinsics.stringPlus("isEmptyByExceedMaxFailCountList beanList = ", beanList), Intrinsics.stringPlus("removeList = ", arrayList));
        }
        return beanList.isEmpty();
    }

    public final boolean h(@NotNull List<BILogDbBean> beanList) {
        List<String> logNoBlackList;
        Intrinsics.checkNotNullParameter(beanList, "beanList");
        BILogHttpConfig bILogHttpConfigB = ks.a.b().b();
        if (bILogHttpConfigB == null || (logNoBlackList = bILogHttpConfigB.getLogNoBlackList()) == null || !(!logNoBlackList.isEmpty())) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (BILogDbBean bILogDbBean : beanList) {
            String logNo = bILogDbBean.getLogNo();
            if (logNo != null && logNoBlackList.contains(logNo)) {
                arrayList.add(bILogDbBean);
            }
        }
        if (!arrayList.isEmpty()) {
            beanList.removeAll(arrayList);
            ms.a.a(Intrinsics.stringPlus("isEmptyByHandleLogNoBlack beanList = ", beanList), Intrinsics.stringPlus("removeList = ", arrayList));
        }
        zw.e.e(logNoBlackList);
        return beanList.isEmpty();
    }
}
