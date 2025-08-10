package dc;

import android.view.View;
import android.widget.ImageView;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: OldToyExt.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0015\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0016\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0017\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0018\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0019\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u001a\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u001b\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u001c\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u001d\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010 \u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\"\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010)\u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010*\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010+\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0016J,\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0004H\u0016J\u0014\u00101\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u00102\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u0004H\u0016J\u0014\u00105\u001a\u0004\u0018\u00010\u00062\b\u00106\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u00107\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u00108\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u00109\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010:\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010;\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010=\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010>\u001a\u00020\u00042\b\u0010?\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010@\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0011H\u0016J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0006H\u0016J\u001a\u0010H\u001a\u00020F2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010D\u001a\u00020\u0011H\u0016J\u001a\u0010K\u001a\u00020F2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010D\u001a\u00020\u0011H\u0016¨\u0006L"}, d2 = {"Lcom/wear/component/dxtoy/toy/impl/OldToyExt;", "Lcom/wear/component/dxtoy/toy/interfaces/IToyExt;", "()V", "canAddAddressToNeedConnect", "", "message", "", "canBind", "deviceType", "changeSinglefuncLineToTayValue", "tags", "groups", "changeSinglefuncLineToToyValue", "tag", "group", "changeToyValueToSinglefuncLine", "existDepthfund", "", "funcs", "view", "Landroid/view/View;", "existPumpVFunc", "existRotationVFunc", "existSecondVibratorVFunc", "existSpeedFuns", "existSuckFunc", "existThirdVibratorVFunc", "existVibratorFunV", "existfingerFunf", "existfingerFunt", "generateType", "type", "getCurveLineColor", "toyFunc", "getCurveLineTransColor", "getFullName", "symblo", "getLableTitle", "toyType", "lableTitle", "getLdrToyFunction", "getNameByFun", "getSeekbarProgress", "getSeekbarThumb", "getToyFuncIcon", "", "total", FirebaseAnalytics.Param.INDEX, "selected", "getToyFunction", "getToyIconLinkedId", "rows", StreamManagement.Enable.ELEMENT, "getToyTypeByFunc", "function", "isAgArrayMessage", "isAiTypeMessage", "isContainFunction", "isDeviceTypeMessage", "isOurToy", "name", "isOurType", "isPin", NotificationCompat.CATEGORY_MESSAGE, "isVelvoFunt", "setBatteryImage", "isToyList", "isTran", "battery", "setToyConfig", "", "data", "updateToyBattery", "toy_battery_img", "Landroid/widget/ImageView;", "updateToyBatteryTrans", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public class zs1 {
    public boolean A3(@Nullable String str) {
        return ws1.K1(str);
    }

    public boolean B3(@Nullable String str) {
        return ws1.L1(str);
    }

    public int C3(@NotNull String funcs, @Nullable View view) {
        Intrinsics.checkNotNullParameter(funcs, "funcs");
        return ws1.c2(funcs, view);
    }

    public int D3(boolean z, boolean z2, int i) {
        return ws1.m2(z, z2, i);
    }

    public void E3(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ws1.Z2(data);
    }

    public void F3(@Nullable ImageView imageView, int i) {
        ws1.q3(imageView, i);
    }

    public void G3(@Nullable ImageView imageView, int i) {
        ws1.r3(imageView, i);
    }

    public boolean T2(@Nullable String str) {
        return ws1.c(str);
    }

    public boolean U2(@Nullable String str) {
        return ws1.e(str);
    }

    @Nullable
    public String V2(@Nullable String str, @Nullable String str2) {
        return ws1.g(str, str2);
    }

    @Nullable
    public String W2(@Nullable String str, @Nullable String str2) {
        return ws1.h(str, str2);
    }

    @Nullable
    public String X2(@Nullable String str, @Nullable String str2) {
        return ws1.i(str, str2);
    }

    public int Y2(@Nullable String str, @Nullable View view) {
        return ws1.m(str, view);
    }

    public int Z2(@Nullable String str, @Nullable View view) {
        return ws1.n(str, view);
    }

    public int a3(@Nullable String str, @Nullable View view) {
        return ws1.o(str, view);
    }

    public int b3(@Nullable String str, @Nullable View view) {
        return ws1.p(str, view);
    }

    public int c3(@Nullable String str, @Nullable View view) {
        return ws1.q(str, view);
    }

    public int d3(@Nullable String str, @Nullable View view) {
        return ws1.r(str, view);
    }

    public int e3(@Nullable String str, @Nullable View view) {
        return ws1.s(str, view);
    }

    public int f3(@Nullable String str, @Nullable View view) {
        return ws1.t(str, view);
    }

    public int g3(@Nullable String str, @Nullable View view) {
        return ws1.u(str, view);
    }

    public int h3(@Nullable String str, @Nullable View view) {
        return ws1.v(str, view);
    }

    @Nullable
    public String i3(@Nullable String str) {
        return ws1.w(str);
    }

    public int j3(@Nullable String str) {
        return ws1.M(str);
    }

    public int k3(@Nullable String str) {
        return ws1.N(str);
    }

    @Nullable
    public String l3(@Nullable String str) {
        return ws1.Z(str);
    }

    @Nullable
    public String m3(@Nullable String str, @Nullable String str2) {
        return ws1.j0(str, str2);
    }

    @Nullable
    public String n3(@Nullable String str) {
        return ws1.l0(str);
    }

    @Nullable
    public String o3(@Nullable String str) {
        return ws1.w0(str);
    }

    public int p3(@Nullable String str) {
        return ws1.K0(str);
    }

    public int q3(@Nullable String str) {
        return ws1.L0(str);
    }

    @Nullable
    public int[] r3(@Nullable String str, int i, int i2, boolean z) {
        return ws1.R0(str, i, i2, z);
    }

    @Nullable
    public String s3(@Nullable String str) {
        return ws1.S0(str);
    }

    public int t3(@Nullable String str, int i, boolean z) {
        return ws1.U0(str, i, z);
    }

    @Nullable
    public String u3(@Nullable String str) {
        return ws1.X0(str);
    }

    public boolean v3(@Nullable String str) {
        return ws1.h1(str);
    }

    public boolean w3(@Nullable String str) {
        return ws1.i1(str);
    }

    public boolean x3(@Nullable String str) {
        return ws1.n1(str);
    }

    public boolean y3(@Nullable String str) {
        return ws1.o1(str);
    }

    public boolean z3(@Nullable String str) {
        return ws1.J1(str);
    }
}
