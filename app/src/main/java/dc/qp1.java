package dc;

import com.component.dxbluetooth.lib.bean.BleResultBean;
import com.wear.bean.Toy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BtBluetoothLogNewAction.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/business/BtBluetoothLogNewAction;", "", "()V", "onEvent", "", "event", "Lcom/component/dxtoy/core/api/event/ToyCheckConnectHasToyEvent;", "Lcom/component/dxtoy/core/api/event/ToyScanConnectActionEvent;", "Lcom/component/dxtoy/core/api/event/ToyScanDFUDeviceEvent;", "Lcom/component/dxtoy/core/api/event/ToyScanEvent;", "Lcom/component/dxtoy/core/api/event/ToyScanFailedEvent;", "onEventToyConnect", "Lcom/component/dxtoy/core/api/event/ToyConnectEvent;", "toy", "Lcom/wear/bean/Toy;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class qp1 {

    @NotNull
    public static final qp1 a;

    /* compiled from: BtBluetoothLogNewAction.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[sb0.values().length];
            iArr[sb0.CONNECT_SUC.ordinal()] = 1;
            iArr[sb0.NOT_CONNECT.ordinal()] = 2;
            a = iArr;
        }
    }

    static {
        qp1 qp1Var = new qp1();
        a = qp1Var;
        wb0.a.b(qp1Var);
    }

    public final void a(@NotNull i90 event, @Nullable Toy toy) {
        Intrinsics.checkNotNullParameter(event, "event");
        int i = a.a[event.getB().ordinal()];
        if (i == 1) {
            if (toy != null) {
                if (toy.getStatus() != 1) {
                    rp1.a.c(toy);
                }
                rp1.a.x(toy);
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        BleResultBean c = event.getC();
        if (Intrinsics.areEqual(c != null ? c.getMsg() : null, mt.CONNECT_CANCEL.getMsg())) {
            rp1.a.m(event.getA());
        }
        if (toy != null && toy.isSelect() && toy.getStatus() == 1) {
            ze3.c(toy, event.getC());
        }
    }

    @Subscribe
    public final void onEvent(@NotNull h90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Subscribe
    public final void onEvent(@NotNull m90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Subscribe
    public final void onEvent(@NotNull n90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Toy toyN = pc1.a.n(event.getA());
        if (toyN != null) {
            rp1.a.a(toyN);
        }
    }

    @Subscribe
    public final void onEvent(@NotNull o90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String a2 = event.getA();
        if (Intrinsics.areEqual(a2, mt.BLE_NOT_SUPPORT.getMsg())) {
            rp1.a.d();
        } else if (Intrinsics.areEqual(a2, mt.BLE_NOT_ADAPTER.getMsg())) {
            rp1.a.e();
        } else {
            Intrinsics.areEqual(a2, mt.SEARCH_CANCEL.getMsg());
        }
    }

    @Subscribe
    public final void onEvent(@NotNull l90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int b = event.getB();
        if (b == 1) {
            rp1.a.l(event.getA());
        } else if (b == 2) {
            rp1.a.B(event.getA(), event.getC(), event.getD(), event.getE());
        } else {
            if (b != 3) {
                return;
            }
            rp1.a.k(event.getA());
        }
    }
}
