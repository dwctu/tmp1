package dc;

import com.component.dxhyttoutils.lib.bean.DtxCheckBean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DXDtxCheckUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxhyttoutils/lib/utils/DXDtxCheckUtils;", "", "()V", "Companion", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class qz {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: DXDtxCheckUtils.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007J2\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J(\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0006¨\u0006\u0017"}, d2 = {"Lcom/component/dxhyttoutils/lib/utils/DXDtxCheckUtils$Companion;", "", "()V", "checkStringTime", "Lkotlin/Pair;", "", "Lcom/component/dxhyttoutils/lib/bean/DtxCheckBean;", "value", "", "checkTime", "", "curTime", "createCheckStringTime", "data", "time", "vc", "", "from", "Lcom/component/dxhyttoutils/lib/data/HyttoEum$AppCode;", "createDtxCheckBean", "decryptDtxBean", "bean", "encryptDtxBean", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Pair b(a aVar, String str, long j, long j2, int i, Object obj) {
            if ((i & 2) != 0) {
                j = kz.ONE_MINUTE.getMillisecond();
            }
            long j3 = j;
            if ((i & 4) != 0) {
                j2 = System.currentTimeMillis();
            }
            return aVar.a(str, j3, j2);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final Pair<Boolean, DtxCheckBean> a(@Nullable String str, long j, long j2) {
            DtxCheckBean dtxCheckBeanC;
            boolean z = true;
            if (!(str == null || str.length() == 0) && (dtxCheckBeanC = c(str)) != null) {
                if (j != kz.UNLIMITED.getMillisecond()) {
                    long time = j2 - dtxCheckBeanC.getTime();
                    if (!(0 <= time && time <= j)) {
                        z = false;
                    }
                }
                return new Pair<>(Boolean.valueOf(z), z ? dtxCheckBeanC : null);
            }
            return new Pair<>(Boolean.FALSE, null);
        }

        @Nullable
        public final DtxCheckBean c(@NotNull String bean) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            return (DtxCheckBean) xd0.h().fromJson(qx.a(bean), DtxCheckBean.class);
        }
    }
}
