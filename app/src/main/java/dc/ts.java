package dc;

import com.component.dxbilog.lib.manual.bean.BILogHttpConfig;
import com.component.dxdatabase.lib.bean.BILogDbBean;
import com.component.dxutilcode.lib.utils.NetworkUtils;
import dc.ms;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogAllowUploadStrategy.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/component/dxbilog/lib/manual/strategy/BILogAllowUploadStrategy;", "Lcom/component/dxbilog/lib/manual/strategy/handler/BaseStrategyHandler;", "()V", "isEnable", "", "()Z", "getUploadTimeInterval", "", "biLogHttpConfig", "Lcom/component/dxbilog/lib/manual/bean/BILogHttpConfig;", "handle", "", "beanList", "", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "isEnableUploadMaxCount", "isEnableUploadMinTimeInterval", "isEnableUploadTimeInterval", "isNetworkAvailable", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ts extends bt {
    @Override // dc.bt, dc.ct
    public void a(@Nullable List<BILogDbBean> list) {
        BILogHttpConfig bILogHttpConfigB;
        boolean z = !ys.a.a() && j() && h() && (i() || g());
        if (!z || (bILogHttpConfigB = ks.a.b().b()) == null) {
            return;
        }
        List<BILogDbBean> listH = zw.e.h((int) (bILogHttpConfigB.getUploadSize() * 1.5d));
        ms.a aVar = ms.a;
        Object[] objArr = new Object[2];
        objArr[0] = Intrinsics.stringPlus("isAllowUpload = ", Boolean.valueOf(z));
        objArr[1] = Intrinsics.stringPlus("findList = ", listH == null ? null : Integer.valueOf(listH.size()));
        aVar.a(objArr);
        ct a = getA();
        if (a == null) {
            return;
        }
        a.b(listH);
    }

    @Override // dc.bt
    public boolean d() {
        return true;
    }

    public final long f(BILogHttpConfig bILogHttpConfig) {
        return (long) (1000 * (NetworkUtils.j() ? bILogHttpConfig.getUploadTimeIntervalWifi() : bILogHttpConfig.getUploadTimeIntervalData()));
    }

    public final boolean g() {
        BILogHttpConfig bILogHttpConfigB = ks.a.b().b();
        return bILogHttpConfigB != null && ws.a.a() >= bILogHttpConfigB.getUploadSize();
    }

    public final boolean h() {
        BILogHttpConfig bILogHttpConfigB = ks.a.b().b();
        return bILogHttpConfigB != null && ((double) (System.currentTimeMillis() - rs.c.e())) > bILogHttpConfigB.getUploadMinTimeInterval() * ((double) 1000);
    }

    public final boolean i() {
        BILogHttpConfig bILogHttpConfigB = ks.a.b().b();
        return bILogHttpConfigB != null && System.currentTimeMillis() - rs.c.e() > f(bILogHttpConfigB);
    }

    public final boolean j() {
        return NetworkUtils.h();
    }
}
