package dc;

import com.wear.bean.Toy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyGetCap.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/lvs/ToyGetCap;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class xr1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyGetCap.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\n"}, d2 = {"Lcom/wear/component/dxtoy/command/lvs/ToyGetCap$Companion;", "", "()V", "getCap", "", "mac", "", "updateToyLvsMotorConfig", MultipleAddresses.Address.ELEMENT, "mode", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@Nullable String str) {
            if (str != null) {
                if (mp1.a.b()) {
                    n10.b.d(str);
                } else {
                    pc1.a.e(str, "GetCap;");
                }
            }
        }

        @JvmStatic
        public final void b(@NotNull String address, @Nullable String str) {
            Intrinsics.checkNotNullParameter(address, "address");
            Toy toy = pc1.a.g().get(address);
            if (toy != null) {
                toy.setLvsMotorConfig(str);
            }
        }
    }

    @JvmStatic
    public static final void a(@Nullable String str) {
        a.a(str);
    }

    @JvmStatic
    public static final void b(@NotNull String str, @Nullable String str2) {
        a.b(str, str2);
    }
}
