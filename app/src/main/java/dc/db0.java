package dc;

import com.component.dxtoy.core.commandcore.bean.ToyCommandBean;
import dc.oa0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandSendPreOrPostStrategy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/core/commandcore/strategy/ToyCommandSendPreOrPostStrategy;", "", "()V", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class db0 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCommandSendPreOrPostStrategy.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¨\u0006\f"}, d2 = {"Lcom/component/dxtoy/core/commandcore/strategy/ToyCommandSendPreOrPostStrategy$Companion;", "", "()V", "checkPostSend", "", "command", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "inStrategy", "", "bean", "beanList", "", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(ToyCommandBean toyCommandBean) {
            for (oa0 oa0Var : toyCommandBean.getSendTypeList$core_release()) {
                if (oa0Var instanceof oa0.d) {
                    return ((oa0.d) oa0Var).getA();
                }
            }
            return true;
        }

        public final void b(@NotNull ToyCommandBean bean, @NotNull List<ToyCommandBean> beanList) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(beanList, "beanList");
            if (a(bean)) {
                beanList.add(0, bean);
            } else {
                beanList.add(bean);
            }
        }
    }
}
