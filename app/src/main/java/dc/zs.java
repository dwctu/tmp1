package dc;

import com.component.dxbilog.lib.manual.bean.BILogHttpConfig;
import com.component.dxdatabase.lib.bean.BILogDbBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogUploadSizeStrategy.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/component/dxbilog/lib/manual/strategy/BILogUploadSizeStrategy;", "Lcom/component/dxbilog/lib/manual/strategy/handler/BaseStrategyHandler;", "()V", "isEnable", "", "()Z", "handle", "", "beanList", "", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class zs extends bt {

    @NotNull
    public static final a b = new a(null);

    /* compiled from: BILogUploadSizeStrategy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0014\u0010\u0003\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0014\u0010\u000b\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tJ\u0014\u0010\f\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¨\u0006\u000e"}, d2 = {"Lcom/component/dxbilog/lib/manual/strategy/BILogUploadSizeStrategy$Companion;", "", "()V", "byteSize", "", "bean", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "", "beanList", "", "getDbBeanLength", "handleSingleUploadMaxSizeForBarrel", "isEmptyByHandleSingleLogMaxSize", "", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(@NotNull BILogDbBean bean) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Integer byteSize = bean.getByteSize();
            if (byteSize != null) {
                return byteSize.intValue();
            }
            byte[] bArrJ = qd0.j(xd0.h().toJson(bean));
            bean.setByteSize(Integer.valueOf(bArrJ.length));
            return bArrJ.length;
        }

        public final int b(BILogDbBean bILogDbBean) {
            String content = bILogDbBean.getContent();
            if (content == null) {
                return 0;
            }
            return content.length();
        }

        public final void c(@NotNull List<BILogDbBean> beanList) {
            Intrinsics.checkNotNullParameter(beanList, "beanList");
            BILogHttpConfig bILogHttpConfigB = ks.a.b().b();
            if (bILogHttpConfigB == null) {
                return;
            }
            double d = 1024;
            double singleUploadMaxSize = bILogHttpConfigB.getSingleUploadMaxSize() * d * d;
            ArrayList arrayList = new ArrayList();
            int iIntValue = 0;
            for (BILogDbBean bILogDbBean : beanList) {
                Integer byteSize = bILogDbBean.getByteSize();
                iIntValue += byteSize == null ? 0 : byteSize.intValue();
                if (iIntValue > singleUploadMaxSize) {
                    arrayList.add(bILogDbBean);
                }
            }
            if (!arrayList.isEmpty()) {
                beanList.removeAll(arrayList);
            }
            int size = beanList.size() - bILogHttpConfigB.getUploadSize();
            if (size > 0) {
                beanList.subList(beanList.size() - size, beanList.size()).clear();
            }
            ms.a.a(Intrinsics.stringPlus("handleSingleUploadMaxSize - beanList:", Integer.valueOf(beanList.size())), "uploadSize:" + iIntValue + ", maxByteSize:" + singleUploadMaxSize, "removeList:" + arrayList.size() + ", removeSize:" + size);
        }

        public final boolean d(@NotNull List<BILogDbBean> beanList) {
            Intrinsics.checkNotNullParameter(beanList, "beanList");
            BILogHttpConfig bILogHttpConfigB = ks.a.b().b();
            if (bILogHttpConfigB == null) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (BILogDbBean bILogDbBean : beanList) {
                if (zs.b.b(bILogDbBean) > bILogHttpConfigB.getSingleLogMaxLength()) {
                    arrayList.add(bILogDbBean);
                }
            }
            if (!arrayList.isEmpty()) {
                beanList.removeAll(arrayList);
                zw.e.b(arrayList);
            }
            return beanList.isEmpty();
        }
    }

    @Override // dc.bt, dc.ct
    public void a(@Nullable List<BILogDbBean> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b.c(list);
    }

    @Override // dc.bt
    public boolean d() {
        return true;
    }
}
