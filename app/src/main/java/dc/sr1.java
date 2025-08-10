package dc;

import com.wear.bean.Toy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyLight.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/light/ToyLight;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class sr1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyLight.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007¨\u0006\u0010"}, d2 = {"Lcom/wear/component/dxtoy/command/light/ToyLight$Companion;", "", "()V", "getLightSwitch", "", "mac", "", "setAlightSwitch", "turnOn", "", "setLightSwitch", "updateToyLed", MultipleAddresses.Address.ELEMENT, "led", "", "message", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                z00.a.c(mac);
            } else {
                pc1.a.e(mac, "GetLight;");
            }
        }

        @JvmStatic
        public final void b(@NotNull String mac, boolean z) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                z00.a.d(mac, z);
                return;
            }
            pc1 pc1Var = pc1.a;
            StringBuilder sb = new StringBuilder();
            sb.append("ALight:");
            sb.append(z ? "On" : "Off");
            sb.append(';');
            pc1Var.e(mac, sb.toString());
        }

        @JvmStatic
        public final void c(@NotNull String mac, boolean z) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                z00.a.e(mac, z);
                return;
            }
            pc1 pc1Var = pc1.a;
            StringBuilder sb = new StringBuilder();
            sb.append("Light:");
            sb.append(z ? "on" : "off");
            sb.append(';');
            pc1Var.e(mac, sb.toString());
        }

        @JvmStatic
        public final void d(@NotNull String address, int i, @NotNull String message) {
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(message, "message");
            pc1 pc1Var = pc1.a;
            Toy toy = pc1Var.g().get(address);
            if (toy != null) {
                toy.setLed(i);
                pc1Var.T(address, message);
            }
        }
    }

    static {
        b10.b.e(new ta0() { // from class: dc.rr1
            @Override // dc.ta0
            public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                sr1.a((Boolean) obj, str, str2, bArr, str3);
            }
        });
    }

    public static final void a(Boolean bool, String mac, String value, byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bArr, "<anonymous parameter 3>");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 4>");
        a.d(mac, Intrinsics.areEqual(bool, Boolean.TRUE) ? 1 : 0, value);
    }

    @JvmStatic
    public static final void b(@NotNull String str) {
        a.a(str);
    }

    @JvmStatic
    public static final void d(@NotNull String str, boolean z) {
        a.b(str, z);
    }

    @JvmStatic
    public static final void e(@NotNull String str, boolean z) {
        a.c(str, z);
    }

    @JvmStatic
    public static final void f(@NotNull String str, int i, @NotNull String str2) {
        a.d(str, i, str2);
    }
}
