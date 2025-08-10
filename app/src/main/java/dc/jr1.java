package dc;

import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyDepthDetection.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/depthdetection/ToyDepthDetection;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class jr1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyDepthDetection.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¨\u0006\u001a"}, d2 = {"Lcom/wear/component/dxtoy/command/depthdetection/ToyDepthDetection$Companion;", "", "()V", "getCtrlPan", "", "mac", "", "getSoloSwitch", "getTchLevel", "onGetSoloSwitch", "value", "onGetTchLevel", "setCtrlPan", "turnOn", "", "setSoloSwitch", "setTchLevel", "value1", "", "value2", "updateMissionSolo", MultipleAddresses.Address.ELEMENT, "led", "message", "updateMissionTchLvl", "missionTchLvl", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
                n00.a.b(mac);
            } else {
                pc1.a.e(mac, "RdSolo;");
            }
        }

        @JvmStatic
        public final void b(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                n00.a.c(mac);
            } else {
                pc1.a.e(mac, "RdTchLvl;");
            }
        }

        @JvmStatic
        public final void c(@NotNull String mac, @NotNull String value) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            String strSubstringBefore$default = StringsKt__StringsKt.substringBefore$default(StringsKt__StringsKt.substringAfter(value, ':', ""), ';', (String) null, 2, (Object) null);
            if (WearUtils.q1(strSubstringBefore$default)) {
                h(mac, Integer.parseInt(strSubstringBefore$default), value);
            }
        }

        @JvmStatic
        public final void d(@NotNull String mac, @NotNull String value) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            i(mac, StringsKt__StringsKt.substringBefore$default(StringsKt__StringsKt.substringAfter(value, ':', ""), ';', (String) null, 2, (Object) null), value);
        }

        @JvmStatic
        public final void e(@NotNull String mac, boolean z) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                n00.a.d(mac, z);
                return;
            }
            pc1.a.e(mac, "SetCtlPan:" + (z ? 1 : 0) + ';');
        }

        @JvmStatic
        public final void f(@NotNull String mac, boolean z) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                n00.a.e(mac, z);
                return;
            }
            pc1.a.e(mac, "SetSolo:" + (z ? 1 : 0) + ';');
        }

        @JvmStatic
        public final void g(@NotNull String mac, int i, int i2) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                n00.a.f(mac, i, i2);
                return;
            }
            pc1.a.e(mac, "SetTchLvl:" + i + ':' + i2 + ';');
        }

        public final void h(String str, int i, String str2) {
            pc1 pc1Var = pc1.a;
            Toy toy = pc1Var.g().get(str);
            if (toy != null) {
                toy.setMissionSolo(i);
                pc1Var.T(str, str2);
            }
        }

        public final void i(String str, String str2, String str3) {
            Toy toy = pc1.a.g().get(str);
            if (toy != null) {
                String[] strArr = (String[]) StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (strArr.length != 4) {
                    return;
                }
                int[] iArr = {1, 2, 3, 4};
                try {
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = Integer.parseInt(strArr[i]);
                    }
                    toy.setMissionTchLvl(iArr);
                    pc1.a.T(str, str3);
                } catch (NumberFormatException unused) {
                }
            }
        }
    }

    static {
        q00.b.e(new ta0() { // from class: dc.ir1
            @Override // dc.ta0
            public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                jr1.a((List) obj, str, str2, bArr, str3);
            }
        });
        p00.b.e(new ta0() { // from class: dc.hr1
            @Override // dc.ta0
            public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                jr1.b((Boolean) obj, str, str2, bArr, str3);
            }
        });
    }

    public static final void a(List list, String mac, String value, byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bArr, "<anonymous parameter 3>");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 4>");
        a.d(mac, d90.b(value, null, "rtl", 1, null));
    }

    public static final void b(Boolean bool, String mac, String value, byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bArr, "<anonymous parameter 3>");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 4>");
        a.c(mac, value);
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
    public static final void g(@NotNull String str, @NotNull String str2) {
        a.c(str, str2);
    }

    @JvmStatic
    public static final void h(@NotNull String str, @NotNull String str2) {
        a.d(str, str2);
    }

    @JvmStatic
    public static final void i(@NotNull String str, boolean z) {
        a.e(str, z);
    }

    @JvmStatic
    public static final void j(@NotNull String str, boolean z) {
        a.f(str, z);
    }

    @JvmStatic
    public static final void k(@NotNull String str, int i, int i2) {
        a.g(str, i, i2);
    }
}
