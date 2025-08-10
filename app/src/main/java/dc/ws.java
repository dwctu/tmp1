package dc;

import com.component.dxbilog.lib.manual.bean.BILogHttpConfig;
import com.component.dxdatabase.lib.bean.BILogDbBean;
import dc.ms;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: BILogMaxFailureNumStrategy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbilog/lib/manual/strategy/BILogMaxFailureNumStrategy;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ws {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: BILogMaxFailureNumStrategy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t¨\u0006\r"}, d2 = {"Lcom/component/dxbilog/lib/manual/strategy/BILogMaxFailureNumStrategy$Companion;", "", "()V", "findAllowUploadCount", "", "handleFail", "", "beanList", "", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "isExceedMaxFailCount", "", "bean", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return zw.e.g();
        }

        public final void b(@NotNull List<BILogDbBean> beanList) {
            Intrinsics.checkNotNullParameter(beanList, "beanList");
            if (beanList.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (BILogDbBean bILogDbBean : beanList) {
                Integer failCount = bILogDbBean.getFailCount();
                bILogDbBean.setFailCount(Integer.valueOf((failCount == null ? 0 : failCount.intValue()) + 1));
                if (ws.a.c(bILogDbBean)) {
                    arrayList.add(bILogDbBean);
                } else {
                    bILogDbBean.setNextUploadTime(Long.valueOf(System.currentTimeMillis() + ((bILogDbBean.getFailCount() == null ? 0 : r8.intValue()) * 5 * 60 * 1000)));
                    ms.a aVar = ms.a;
                    Long nextUploadTime = bILogDbBean.getNextUploadTime();
                    Intrinsics.checkNotNull(nextUploadTime);
                    aVar.a(Intrinsics.stringPlus("handleFail nextUploadTime = ", ue0.m(nextUploadTime.longValue())), bILogDbBean.getFailCount(), bILogDbBean);
                }
            }
            if (!arrayList.isEmpty()) {
                beanList.removeAll(arrayList);
                zw.e.b(arrayList);
            }
            ms.a.a(Intrinsics.stringPlus("handleFail beanList = ", Integer.valueOf(beanList.size())), Intrinsics.stringPlus("removeList = ", arrayList));
            if (!beanList.isEmpty()) {
                zw.e.l(beanList);
            }
        }

        public final boolean c(@NotNull BILogDbBean bean) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            BILogHttpConfig bILogHttpConfigB = ks.a.b().b();
            if (bILogHttpConfigB == null) {
                return false;
            }
            Integer failCount = bean.getFailCount();
            return (failCount == null ? 0 : failCount.intValue()) >= bILogHttpConfigB.getFailExpiredMaxNum();
        }
    }
}
