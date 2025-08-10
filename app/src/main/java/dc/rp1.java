package dc;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wear.bean.Toy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogBluetooth.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/business/LogBluetooth;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class rp1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: LogBluetooth.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u0010*\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0007J\b\u0010+\u001a\u00020&H\u0007J\b\u0010,\u001a\u00020&H\u0007J\b\u0010-\u001a\u00020&H\u0007J\u0012\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u00100\u001a\u00020&H\u0007J\u0010\u00101\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u00102\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\u0004H\u0007J\u0010\u00105\u001a\u00020&2\u0006\u00104\u001a\u00020\u0004H\u0007J\u0010\u00106\u001a\u00020&2\u0006\u00104\u001a\u00020\u0004H\u0007J\u0012\u00107\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u00108\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u00109\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0007J\u0012\u0010:\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010;\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010<\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010=\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010>\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010?\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010@\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010A\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010B\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010C\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0007J\u0012\u0010D\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010E\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010F\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0007J\u0012\u0010G\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010H\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010I\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J3\u0010J\u001a\u00020&2\u0006\u00104\u001a\u00020\u00042\b\u0010K\u001a\u0004\u0018\u00010\u00042\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010OR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/business/LogBluetooth$Companion;", "", "()V", "B0001", "", "B0002", "B0003", "B0004", "B0005", "B0006", "B0007", "B0008", "B0009", "B0010", "B0011", "B0012", "B0013", "B0014", "B0015", "B0016", "B0017", "B0018", "B0019", "B0020", "B0021", "B0022", "B0030", "B0031", "B0032", "B0033", "B0034", "B0035", "B0036", "B0037", "B0038", "B0039", "B0040", "logB0001", "", "toy", "Lcom/wear/bean/Toy;", "logB0002", "logB0003", "logB0004", "logB0005", "logB0006", "logB0007", FirebaseAnalytics.Param.CONTENT, "logB0008", "logB0009", "logB0010", "logB0011", "mac", "logB0012", "logB0013", "logB0014", "logB0015", "logB0016", "logB0018", "logB0019", "logB0020", "logB0021", "logB0022", "logB0030", "logB0031", "logB0032", "logB0033", "logB0034", "logB0035", "logB0036", "logB0037", "logB0038", "logB0039", "logB0040", "logU0068ScanDeviceUnknownToConnect", "deviceName", "rssi", "", "uuid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void A(@NotNull Toy toy) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "page_type", "my toys");
            jSONObject.put((JSONObject) "button_type", toy.getFormApp());
            String address = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            jSONObject.put((JSONObject) "toys", StringsKt__StringsJVMKt.replace$default(address, SignatureImpl.INNER_SEP, "", false, 4, (Object) null));
            ye3.d("B0037", jSONObject.toJSONString());
        }

        @JvmStatic
        public final void B(@NotNull String mac, @Nullable String str, @Nullable Integer num, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            ye3.d("U0068", "搜索到无法识别玩具，需要连接判断 address = " + mac + "  deviceName = " + str + "  rssi = " + num + "  uuid = " + str2);
        }

        @JvmStatic
        public final void a(@NotNull Toy toy) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            ye3.d("B0001", toy.getLogToyType());
            String str = "logConnectToAddScanDevice: " + toy.getDeviceType();
        }

        @JvmStatic
        public final void b(@NotNull Toy toy) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            ye3.d("B0002", toy.getLogToyType());
        }

        @JvmStatic
        public final void c(@NotNull Toy toy) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            ye3.d("B0003", toy.getLogToyType());
            String str = "logB0003: " + toy.getDeviceType();
        }

        @JvmStatic
        public final void d() {
            ye3.d("B0004", "");
        }

        @JvmStatic
        public final void e() {
            ye3.d("B0005", "");
        }

        @JvmStatic
        public final void f() {
            ye3.d("B0006", "");
        }

        @JvmStatic
        public final void g(@Nullable String str) {
            ye3.d("B0007", str);
        }

        @JvmStatic
        public final void h() {
            ye3.d("B0008", "");
        }

        @JvmStatic
        public final void i(@NotNull Toy toy) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            ye3.d("B0009", toy.getLogToyType());
        }

        @JvmStatic
        public final void j(@NotNull Toy toy) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            ye3.d("B0010", toy.getLogToyType());
        }

        @JvmStatic
        public final void k(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            ye3.d("B0011", ye3.v(mac));
        }

        @JvmStatic
        public final void l(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            ye3.d("B0012", ye3.v(mac));
        }

        @JvmStatic
        public final void m(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            ye3.d("B0013", ye3.v(mac));
        }

        @JvmStatic
        public final void n(@NotNull Toy toy) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            ye3.d("B0015", toy.getLogToyType());
        }

        @JvmStatic
        public final void o(@NotNull Toy toy) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            ye3.d("B0016", toy.getLogToyType());
        }

        @JvmStatic
        public final void p(@Nullable String str) {
            ye3.d("B0018", str);
        }

        @JvmStatic
        public final void q(@Nullable String str) {
            ye3.d("B0019", str);
        }

        @JvmStatic
        public final void r(@Nullable String str) {
            ye3.d("B0020", str);
        }

        @JvmStatic
        public final void s(@Nullable String str) {
            ye3.d("B0021", str);
        }

        @JvmStatic
        public final void t(@Nullable String str) {
            ye3.d("B0022", str);
        }

        @JvmStatic
        public final void u(@Nullable String str) {
            ye3.d("B0031", str);
        }

        @JvmStatic
        public final void v(@Nullable String str) {
            ye3.d("B0032", str);
        }

        @JvmStatic
        public final void w(@Nullable String str) {
            ye3.d("B0033", str);
        }

        @JvmStatic
        public final void x(@NotNull Toy toy) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            if (TextUtils.isEmpty(toy.getLogFormApp()) || TextUtils.equals("Lovense Remote", toy.getLogFormApp())) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String address = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            jSONObject.put((JSONObject) "toy_mac", StringsKt__StringsJVMKt.replace$default(address, SignatureImpl.INNER_SEP, "", false, 4, (Object) null));
            jSONObject.put((JSONObject) "connected_app", toy.getLogFormApp());
            toy.setLogFormApp(toy.getFormApp());
            ye3.d("B0034", jSONObject.toJSONString());
        }

        @JvmStatic
        public final void y(@Nullable String str) {
            ye3.d("B0035", str);
        }

        @JvmStatic
        public final void z(@Nullable String str) {
            ye3.d("B0036", str);
        }
    }

    @JvmStatic
    public static final void a(@NotNull Toy toy) {
        a.b(toy);
    }

    @JvmStatic
    public static final void b() {
        a.d();
    }

    @JvmStatic
    public static final void c() {
        a.e();
    }

    @JvmStatic
    public static final void d() {
        a.f();
    }

    @JvmStatic
    public static final void e(@Nullable String str) {
        a.g(str);
    }

    @JvmStatic
    public static final void f() {
        a.h();
    }

    @JvmStatic
    public static final void g(@NotNull Toy toy) {
        a.i(toy);
    }

    @JvmStatic
    public static final void h(@NotNull Toy toy) {
        a.j(toy);
    }

    @JvmStatic
    public static final void i(@NotNull String str) {
        a.k(str);
    }

    @JvmStatic
    public static final void j(@NotNull String str) {
        a.l(str);
    }

    @JvmStatic
    public static final void k(@NotNull String str) {
        a.m(str);
    }

    @JvmStatic
    public static final void l(@NotNull Toy toy) {
        a.n(toy);
    }

    @JvmStatic
    public static final void m(@NotNull Toy toy) {
        a.o(toy);
    }

    @JvmStatic
    public static final void n(@Nullable String str) {
        a.p(str);
    }

    @JvmStatic
    public static final void o(@Nullable String str) {
        a.q(str);
    }

    @JvmStatic
    public static final void p(@Nullable String str) {
        a.r(str);
    }

    @JvmStatic
    public static final void q(@Nullable String str) {
        a.s(str);
    }

    @JvmStatic
    public static final void r(@Nullable String str) {
        a.t(str);
    }

    @JvmStatic
    public static final void s(@Nullable String str) {
        a.u(str);
    }

    @JvmStatic
    public static final void t(@Nullable String str) {
        a.v(str);
    }

    @JvmStatic
    public static final void u(@Nullable String str) {
        a.w(str);
    }

    @JvmStatic
    public static final void v(@Nullable String str) {
        a.y(str);
    }

    @JvmStatic
    public static final void w(@Nullable String str) {
        a.z(str);
    }

    @JvmStatic
    public static final void x(@NotNull String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3) {
        a.B(str, str2, num, str3);
    }
}
