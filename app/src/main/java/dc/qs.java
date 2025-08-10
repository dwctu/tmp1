package dc;

import com.component.dxbilog.lib.bean.BILogContentBean;
import com.component.dxdatabase.lib.bean.BILogDbBean;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogManualAdd.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tJ\u0014\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/component/dxbilog/lib/manual/method/BILogManualAdd;", "", "()V", "add", "", "logNo", "", FirebaseAnalytics.Param.CONTENT, "createBean", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "formatBeanData", "bean", "", "interfaceBean", "", "Lcom/component/dxbilog/lib/bean/BILogContentBean;", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class qs {

    @NotNull
    public static final qs a = new qs();

    public final void a(@Nullable String str, @Nullable Object obj) {
        boolean z;
        if (str != null) {
            try {
                z = str.length() == 0;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (!z && obj != null) {
            if (ys.a.a()) {
                ms.a.a("BILogManualAdd____服务器停止");
                return;
            }
            BILogDbBean bILogDbBeanB = b(str, obj);
            if (bILogDbBeanB == null) {
                return;
            }
            List<BILogDbBean> listA = hd0.a(bILogDbBeanB);
            Intrinsics.checkNotNullExpressionValue(listA, "asArrayList(it)");
            us usVar = new us();
            usVar.e(new at());
            usVar.b(listA);
            if (!listA.isEmpty()) {
                bILogDbBeanB.setByteSize(Integer.valueOf(zs.b.a(bILogDbBeanB)));
                a.c(bILogDbBeanB);
                zw.e.a(bILogDbBeanB);
            }
        }
    }

    @Nullable
    public final BILogDbBean b(@NotNull String logNo, @NotNull Object content) {
        String json;
        String strC;
        Intrinsics.checkNotNullParameter(logNo, "logNo");
        Intrinsics.checkNotNullParameter(content, "content");
        BILogDbBean bILogDbBean = new BILogDbBean();
        if (content instanceof BILogContentBean) {
            BILogContentBean bILogContentBean = (BILogContentBean) content;
            if (d(logNo, bILogContentBean)) {
                return null;
            }
            bILogDbBean.setPageName(bILogContentBean.getPage_name());
            bILogDbBean.setProperties(xd0.j(bILogContentBean.getProperties()));
            bILogContentBean.setPage_name(null);
            bILogContentBean.setProperties(null);
            bILogContentBean.setInternals(null);
            json = xd0.h().toJson(content);
        } else {
            if (!(content instanceof cs)) {
                return null;
            }
            json = xd0.h().toJson(content);
        }
        bILogDbBean.setLogNo(logNo);
        bILogDbBean.setContent(json);
        bILogDbBean.setTimeStamp(System.currentTimeMillis());
        bs b = ks.a.a().getB();
        String str = "";
        if (b != null && (strC = b.c()) != null) {
            str = strC;
        }
        bILogDbBean.setAccountCode(str);
        vw.d.a(bILogDbBean);
        bILogDbBean.setId(null);
        return bILogDbBean;
    }

    public final void c(@NotNull BILogDbBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        bean.setFailCount(0);
        bean.setNextUploadTime(0L);
    }

    public final boolean d(String str, BILogContentBean bILogContentBean) {
        if (!Intrinsics.areEqual(str, "S0009")) {
            return false;
        }
        String event_id = bILogContentBean.getEvent_id();
        return event_id == null || event_id.length() == 0;
    }
}
