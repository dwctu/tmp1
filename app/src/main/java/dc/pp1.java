package dc;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.component.dxbluetooth.lib.bean.BleResultBean;
import com.wear.bean.Toy;
import com.wear.main.toy.pin.ToyPinRemoveFailTipActivity;
import com.wear.util.MyApplication;
import dc.ms1;
import dc.wb0;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BtAppBusinessUtils.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0016H\u0007J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/business/BtAppBusinessUtils;", "", "()V", "mBackgroundLocationNotificationIsCreate", "", "connectSuccessF01ToyAndJ01Toy", "", "toy", "Lcom/wear/bean/Toy;", "converterConnectEvent", "event", "Lcom/component/dxtoy/core/api/event/ToyConnectEvent;", "countConnectState", "", "connect", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ToyConnectState;", "isPinCodeIntercept", "mac", "", "uuid", "notifyToyInfoUpdate", "onEvent", "Lcom/component/dxtoy/core/api/event/ToyCheckConnectHasToyEvent;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class pp1 {

    @NotNull
    public static final pp1 a;

    @JvmField
    public static boolean b;

    /* compiled from: BtAppBusinessUtils.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[sb0.values().length];
            iArr[sb0.CONNECT_SUC.ordinal()] = 1;
            iArr[sb0.NOT_CONNECT.ordinal()] = 2;
            iArr[sb0.CONNECTING.ordinal()] = 3;
            a = iArr;
        }
    }

    static {
        pp1 pp1Var = new pp1();
        a = pp1Var;
        wb0.a.b(pp1Var);
    }

    public static final void b(Toy toy) {
        Intrinsics.checkNotNullParameter(toy, "$toy");
        if (!toy.isF01Toy()) {
            if (toy.isJ01Toy()) {
                wf3.b().a();
                return;
            }
            return;
        }
        ms1.a aVar = ms1.a;
        String address = toy.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "toy.address");
        aVar.N(address);
        String address2 = toy.getAddress();
        Intrinsics.checkNotNullExpressionValue(address2, "toy.address");
        aVar.O(address2);
    }

    @JvmStatic
    public static final boolean e(@NotNull String mac, @Nullable String str) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        if (!xb1.b(str, mac) || !ud3.a(mac) || ud3.c(str, mac) || !og3.a(9) || !ud3.a(mac) || ud3.c(null, mac) || MyApplication.H() == null || (MyApplication.H() instanceof ToyPinRemoveFailTipActivity)) {
            return false;
        }
        Intent intent = new Intent(MyApplication.H(), (Class<?>) ToyPinRemoveFailTipActivity.class);
        intent.putExtra("toyId", mac);
        intent.putExtra("type", 1);
        MyApplication.H().startActivity(intent);
        return true;
    }

    public final void a(@NotNull final Toy toy) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        se0.g(new Runnable() { // from class: dc.op1
            @Override // java.lang.Runnable
            public final void run() {
                pp1.b(toy);
            }
        }, 500L);
    }

    public final void c(i90 i90Var) {
        int iD = d(i90Var.getB());
        wb0.a aVar = wb0.a;
        String a2 = i90Var.getA();
        BleResultBean c = i90Var.getC();
        aVar.a(new xc1(a2, iD, c != null ? c.getMsg() : null));
        LocalBroadcastManager.getInstance(ve0.a()).sendBroadcast(new Intent("ACTION_TOY_UPDATE"));
    }

    public final int d(sb0 sb0Var) {
        int i = a.a[sb0Var.ordinal()];
        if (i != 1) {
            return (i == 2 || i != 3) ? -1 : 0;
        }
        return 1;
    }

    public final void g(@NotNull Toy toy) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        wb0.a.a(new xc1(toy.getAddress(), toy.getStatus()));
        LocalBroadcastManager.getInstance(ve0.a()).sendBroadcast(new Intent("ACTION_TOY_UPDATE"));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull h90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b8  */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onEvent(@org.jetbrains.annotations.NotNull dc.i90 r7) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.pp1.onEvent(dc.i90):void");
    }
}
