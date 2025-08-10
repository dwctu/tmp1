package dc;

import com.component.dxtoy.core.commandcore.bean.ToyCommandBean;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandStrategyUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/core/commandcore/strategy/utils/ToyCommandStrategyUtils;", "", "()V", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class fb0 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCommandStrategyUtils.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Lcom/component/dxtoy/core/commandcore/strategy/utils/ToyCommandStrategyUtils$Companion;", "", "()V", "checkLVSCommandStopAndAllSupport", "", "bean", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "checkMultiplyCommandStopAndAllSupport", "checkSingleCommandStop", "checkStopCommand", "initCommandParams", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull ToyCommandBean bean) {
            boolean z;
            Intrinsics.checkNotNullParameter(bean, "bean");
            boolean z2 = false;
            Object obj = bean.getValueList().get(0);
            byte[] bArr = obj instanceof byte[] ? (byte[]) obj : null;
            if (bArr != null) {
                int length = bArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = true;
                        break;
                    }
                    byte b = bArr[i];
                    if (!(b == 0 || b == -1)) {
                        z = false;
                        break;
                    }
                    i++;
                }
                bean.setStopCommand$core_release(z);
                int length2 = bArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        z2 = true;
                        break;
                    } else {
                        if (bArr[i2] == -1) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                bean.setAllMultiSupport$core_release(z2);
            }
        }

        public final void b(@NotNull ToyCommandBean bean) {
            boolean z;
            Intrinsics.checkNotNullParameter(bean, "bean");
            List<Object> valueList = bean.getValueList();
            boolean z2 = valueList instanceof Collection;
            boolean z3 = false;
            if (z2 && valueList.isEmpty()) {
                z = true;
            } else {
                for (Object obj : valueList) {
                    boolean z4 = obj instanceof String;
                    if (!((z4 && Intrinsics.areEqual(obj, "0")) || (z4 && Intrinsics.areEqual(obj, "-1")))) {
                        z = false;
                        break;
                    }
                }
                z = true;
            }
            bean.setStopCommand$core_release(z);
            if (z2 && valueList.isEmpty()) {
                z3 = true;
            } else {
                for (Object obj2 : valueList) {
                    if ((obj2 instanceof String) && Intrinsics.areEqual(obj2, "-1")) {
                        break;
                    }
                }
                z3 = true;
            }
            bean.setAllMultiSupport$core_release(z3);
        }

        public final void c(ToyCommandBean toyCommandBean) {
            List<Object> valueList = toyCommandBean.getValueList();
            boolean z = false;
            if ((valueList instanceof Collection) && valueList.isEmpty()) {
                z = true;
            } else {
                for (Object obj : valueList) {
                    if (!((obj instanceof String) && Intrinsics.areEqual(obj, "0"))) {
                        break;
                    }
                }
                z = true;
            }
            toyCommandBean.setStopCommand$core_release(z);
        }

        public final void d(ToyCommandBean toyCommandBean) {
            la0 commandConstant = toyCommandBean.getCommandConstant();
            ma0 ma0Var = ma0.a;
            if (Intrinsics.areEqual(commandConstant, ma0Var.s()) ? true : Intrinsics.areEqual(commandConstant, ma0Var.t())) {
                b(toyCommandBean);
                return;
            }
            if (Intrinsics.areEqual(commandConstant, ma0Var.r()) ? true : Intrinsics.areEqual(commandConstant, ma0Var.k())) {
                a(toyCommandBean);
                return;
            }
            if (Intrinsics.areEqual(commandConstant, ma0Var.y()) ? true : Intrinsics.areEqual(commandConstant, ma0Var.x())) {
                toyCommandBean.setStopCommand$core_release(true);
            } else if (toyCommandBean.getCommandConstant().getD() == na0.CTRL_SINGLE) {
                c(toyCommandBean);
            }
        }

        public final void e(@NotNull ToyCommandBean bean) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            d(bean);
        }
    }
}
