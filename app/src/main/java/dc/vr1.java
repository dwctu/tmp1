package dc;

import com.wear.bean.Toy;
import com.wear.bean.ToyType;
import com.wear.dao.DaoUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyLightColor.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/lightcolor/ToyLightColor;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class vr1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyLightColor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007¨\u0006\u0010"}, d2 = {"Lcom/wear/component/dxtoy/command/lightcolor/ToyLightColor$Companion;", "", "()V", "getAColor", "", "mac", "", "getColor", "setAColor", "color", "", "setColor", "updateToyAColor", MultipleAddresses.Address.ELEMENT, "led", "message", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
                c10.a.a(mac);
            } else {
                pc1.a.e(mac, "GetAColor;");
            }
        }

        @JvmStatic
        public final void b(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                c10.a.b(mac);
            } else {
                pc1.a.e(mac, "GetColor;");
            }
        }

        @JvmStatic
        public final void c(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                c10.a.c(mac, i);
                return;
            }
            pc1.a.e(mac, "SetAColor:" + i + ';');
        }

        @JvmStatic
        public final void d(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                c10.a.d(mac, i);
                return;
            }
            pc1.a.e(mac, "SetColor:" + i + ';');
        }

        @JvmStatic
        public final void e(@NotNull String address, int i, @NotNull String message) {
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(message, "message");
            pc1 pc1Var = pc1.a;
            Toy toy = pc1Var.g().get(address);
            if (toy != null) {
                toy.setaColor(i);
                ToyType toyTypeFindToyType = DaoUtils.getToyTypeDao().findToyType(address);
                if (toyTypeFindToyType == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(toyTypeFindToyType, "DaoUtils.getToyTypeDao()…oyType(address) ?: return");
                toyTypeFindToyType.setaColor(i);
                DaoUtils.getToyTypeDao().update(toyTypeFindToyType);
                pc1Var.T(address, message);
            }
        }
    }

    static {
        e10.b.e(new ta0() { // from class: dc.ur1
            @Override // dc.ta0
            public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                vr1.a((Integer) obj, str, str2, bArr, str3);
            }
        });
        d10.b.e(new ta0() { // from class: dc.tr1
            @Override // dc.ta0
            public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                vr1.b((Integer) obj, str, str2, bArr, str3);
            }
        });
    }

    public static final void a(Integer num, String mac, String value, byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bArr, "<anonymous parameter 3>");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 4>");
        pc1.a.T(mac, value);
    }

    public static final void b(Integer num, String mac, String value, byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bArr, "<anonymous parameter 3>");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 4>");
        a.e(mac, num != null ? num.intValue() : 0, value);
    }

    @JvmStatic
    public static final void c(@NotNull String str) {
        a.a(str);
    }

    @JvmStatic
    public static final void d(@NotNull String str) {
        a.b(str);
    }

    @JvmStatic
    public static final void g(@NotNull String str, int i) {
        a.c(str, i);
    }

    @JvmStatic
    public static final void h(@NotNull String str, int i) {
        a.d(str, i);
    }

    @JvmStatic
    public static final void i(@NotNull String str, int i, @NotNull String str2) {
        a.e(str, i, str2);
    }
}
