package dc;

import com.wear.bean.Toy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyPowerOff.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\u0007¨\u0006\f"}, d2 = {"Lcom/wear/component/dxtoy/command/power/ToyPowerOff;", "", "()V", "onEvent", "", "event", "Lcom/component/dxtoy/business/power/event/ToyPowerOffEvent;", "setPowerOff", "mac", "", "updateToyPowerOff", MultipleAddresses.Address.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class as1 {

    @NotNull
    public static final as1 a;

    static {
        as1 as1Var = new as1();
        a = as1Var;
        wb0.a.b(as1Var);
    }

    @JvmStatic
    public static final void a(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        if (mp1.a.b()) {
            g20.b.d(mac);
        } else {
            pc1.a.e(mac, "PowerOff;");
        }
    }

    @JvmStatic
    public static final void b(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Toy toy = pc1.a.g().get(address);
        if (toy != null) {
            toy.setIsPowerOff(1);
            toy.setPowerOffTime(System.currentTimeMillis());
        }
    }

    @Subscribe
    public final void onEvent(@NotNull i20 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        b(event.getA());
    }
}
