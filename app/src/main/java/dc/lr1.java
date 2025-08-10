package dc;

import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.bean.ToyType;
import com.wear.dao.DaoUtils;
import com.wear.util.WearUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyDeviceType.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t¨\u0006\u0012"}, d2 = {"Lcom/wear/component/dxtoy/command/devicetype/ToyDeviceType;", "", "()V", "checkToySupport", "", "newToy", "Lcom/wear/bean/Toy;", "getDeviceType", "mac", "", "onEvent", "event", "Lcom/component/dxtoy/business/toyinfo/devicetype/event/ToyDeviceTypeChangeEvent;", "Lcom/component/dxtoy/business/toyinfo/devicetype/event/ToyDeviceTypeEvent;", "saveDeviceType", MultipleAddresses.Address.ELEMENT, "deviceType", "updateDeviceTypeDb", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class lr1 {

    @NotNull
    public static final lr1 a;

    static {
        lr1 lr1Var = new lr1();
        a = lr1Var;
        wb0.a.b(lr1Var);
    }

    public static final void b(Toy newToy) {
        Intrinsics.checkNotNullParameter(newToy, "$newToy");
        pc1 pc1Var = pc1.a;
        String address = newToy.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "newToy.address");
        pc1Var.a0(address, true);
        EventBus.getDefault().post(new xc1(newToy.getAddress(), 0));
    }

    @JvmStatic
    public static final void c(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        if (mp1.a.b()) {
            b30.b.g(mac);
        } else {
            pc1.a.e(mac, "DeviceType;");
        }
    }

    public final void a(final Toy toy) {
        if (toy.toyIsSupport()) {
            return;
        }
        se0.g(new Runnable() { // from class: dc.kr1
            @Override // java.lang.Runnable
            public final void run() {
                lr1.b(toy);
            }
        }, 1000L);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strE = ah4.e(R.string.connect_incompatible_toy);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.connect_incompatible_toy)");
        String str = String.format(strE, Arrays.copyOf(new Object[]{toy.getName()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        re3.n(str, 1, null);
    }

    public final void e(String str, String str2) {
        if (!DaoUtils.getToyTypeDao().isExistToyType(str)) {
            ToyType toyType = new ToyType();
            toyType.setAddress(str);
            toyType.setType(str2);
            DaoUtils.getToyTypeDao().add(toyType);
            return;
        }
        ToyType toyTypeFindToyType = DaoUtils.getToyTypeDao().findToyType(str);
        if (toyTypeFindToyType != null) {
            toyTypeFindToyType.setType(str2);
            DaoUtils.getToyTypeDao().update(toyTypeFindToyType);
        }
    }

    public final void f(@NotNull String address, @NotNull String deviceType) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        e(address, deviceType);
        Toy toyQ = pc1.a.Q(address);
        if (toyQ != null) {
            toyQ.setVersion(Integer.valueOf(Integer.parseInt(((String[]) StringsKt__StringsKt.split$default((CharSequence) ((String[]) StringsKt__StringsKt.split$default((CharSequence) deviceType, new String[]{";"}, false, 0, 6, (Object) null).toArray(new String[0]))[0], new String[]{SignatureImpl.INNER_SEP}, false, 0, 6, (Object) null).toArray(new String[0]))[1])));
            if (!Intrinsics.areEqual(toyQ.getDeviceTypeMac(toyQ.getDeviceType()), toyQ.getDeviceTypeMac(deviceType))) {
                rp1.a.p(toyQ.getLogToyType() + '#' + deviceType);
                re3.h(toyQ, deviceType);
            }
            a.a(toyQ);
            re3.q(toyQ, deviceType);
            if (!Intrinsics.areEqual(toyQ.getDeviceType(), deviceType)) {
                toyQ.setUpdateDfu(null);
                toyQ.setGetDfuErrorTime(0L);
            }
            toyQ.setDeviceType(deviceType);
            toyQ.setRealDeviceType(true);
            DaoUtils.getToyDao().update(toyQ);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull d30 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Toy toyQ = pc1.a.Q(event.getA());
        if (toyQ != null) {
            toyQ.setRealDeviceType(true);
            a.a(toyQ);
            re3.q(toyQ, event.getB());
            ve3.d().i(event.getA());
            af3.c().b(event.getA(), event.getC(), WearUtils.x);
            lp1.a.a(toyQ);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull c30 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Toy toyQ = pc1.a.Q(event.getA());
        if (toyQ != null) {
            rp1.a.p(toyQ.getLogToyType() + '#' + event.getB());
            re3.h(toyQ, event.getB());
        }
    }
}
