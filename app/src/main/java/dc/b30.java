package dc;

import dc.oa0;
import dc.sa0;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyCmdDeviceType.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J5\u0010\u0013\u001a\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002J$\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¨\u0006 "}, d2 = {"Lcom/component/dxtoy/business/toyinfo/devicetype/ToyCmdDeviceType;", "Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandler;", "", "()V", "checkDeviceTypeChange", "Lkotlin/Pair;", "", "", "mac", "newDeviceType", "checkToySupport", "toy", "Lcom/component/dxtoy/core/toy/ToyInfo;", "decomposeDeviceType", "", "deviceType", "fixDeviceType", "value", "getDeviceType", "handleCommand", "Unit", "bytes", "", "sendCommand", "(Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;)Ljava/lang/Object;", "isDeviceType", "isHandle", "onMessageEvent", "event", "Lcom/component/dxtoy/core/api/event/ToyConnectEvent;", "unknownDeviceHandle", "updateDeviceTypeData", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class b30 implements sa0<Unit> {

    @NotNull
    public static final b30 b;

    static {
        b30 b30Var = new b30();
        b = b30Var;
        wb0.a.b(b30Var);
    }

    public static final void h(String mac) {
        Intrinsics.checkNotNullParameter(mac, "$mac");
        b.g(mac);
    }

    public static final void l(b30 this_run, i90 event) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(event, "$event");
        this_run.g(event.getA());
    }

    @Override // dc.sa0
    public boolean a(@NotNull String mac, @NotNull String value, @NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = value.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return i(lowerCase);
    }

    @Override // dc.sa0
    public boolean b(@NotNull String str, @NotNull String str2, @NotNull byte[] bArr, @NotNull String str3) {
        return sa0.b.b(this, str, str2, bArr, str3);
    }

    @Override // dc.sa0
    @Nullable
    public <Unit> Unit c(@NotNull final String mac, @NotNull String value, @NotNull byte[] bytes, @NotNull String sendCommand) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
        de0.i("handleCommand - DeviceType: \n" + mac + '\n' + value + '\n' + bytes.length + '\n' + sendCommand);
        String strF = f(mac, value);
        boolean zM = m(mac);
        Pair<Boolean, String> pairN = n(mac, strF);
        boolean zBooleanValue = pairN.component1().booleanValue();
        String strComponent2 = pairN.component2();
        if (zM) {
            de0.i("handleCommand - DeviceType - UnknownDevice: " + mac + " - " + strF + " - " + zBooleanValue);
            z90.a.d().b(mac, strF);
            return null;
        }
        if (yb0.e(mac) != null) {
            if (zBooleanValue) {
                wb0.a.a(new c30(mac, strComponent2, strF));
                se0.g(new Runnable() { // from class: dc.z20
                    @Override // java.lang.Runnable
                    public final void run() {
                        b30.h(mac);
                    }
                }, 1000L);
            }
            wb0.a.a(new d30(mac, strF, value, sendCommand));
            de0.i("handleCommand - DeviceType - finish: " + mac + " - " + strF + " - " + zBooleanValue);
        }
        return null;
    }

    public final Pair<Boolean, String> d(String str, String str2) {
        String deviceType;
        nb0 nb0Var = hb0.a.d().get(str);
        if (nb0Var == null || (deviceType = nb0Var.getDeviceType()) == null) {
            return new Pair<>(Boolean.FALSE, "");
        }
        List<String> listE = e(str2);
        List<String> listE2 = e(deviceType);
        if (listE.size() != 3 || listE2.size() != 3) {
            return new Pair<>(Boolean.FALSE, deviceType);
        }
        return new Pair<>(Boolean.valueOf((Intrinsics.areEqual(listE.get(0), listE2.get(0)) && Intrinsics.areEqual(listE.get(2), listE2.get(2))) ? false : true), deviceType);
    }

    public final List<String> e(String str) {
        return new Regex(SignatureImpl.INNER_SEP).split(StringsKt__StringsKt.removeSuffix(str, (CharSequence) ";"), 0);
    }

    public final String f(String str, String str2) {
        List<String> listSplit = new Regex(SignatureImpl.INNER_SEP).split(str2, 0);
        String str3 = listSplit.get(0);
        String str4 = listSplit.get(1);
        if (!(listSplit.get(2).length() > 0)) {
            return str2;
        }
        return str3 + ':' + str4 + ':' + StringsKt__StringsJVMKt.replace$default(str, SignatureImpl.INNER_SEP, "", false, 4, (Object) null) + ';';
    }

    public final void g(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        j50 j50Var = new j50(mac);
        j50Var.addSendType(new oa0.d(true));
        j50Var.addSendType(new oa0.c(0, 1, null));
        j50Var.e();
    }

    @Override // dc.sa0
    @Nullable
    public ta0<Unit> getCallback() {
        return sa0.b.a(this);
    }

    public final boolean i(String str) {
        return ha0.a(str);
    }

    public final boolean m(String str) {
        nb0 nb0Var = hb0.a.d().get(str);
        String deviceType = nb0Var != null ? nb0Var.getDeviceType() : null;
        boolean z = deviceType == null || deviceType.length() == 0;
        if (z) {
            f90.a.d(str);
        }
        return z;
    }

    public final Pair<Boolean, String> n(String str, String str2) {
        Pair<Boolean, String> pairD = d(str, str2);
        boolean zBooleanValue = pairD.component1().booleanValue();
        String strComponent2 = pairD.component2();
        nb0 nb0Var = hb0.a.d().get(str);
        if (nb0Var != null) {
            nb0Var.p(str2);
            nb0Var.q(str);
            yb0.j(str, nb0Var);
        }
        return new Pair<>(Boolean.valueOf(zBooleanValue), strComponent2);
    }

    @Subscribe
    public final void onMessageEvent(@NotNull final i90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getB() == sb0.CONNECT_SUC) {
            g(event.getA());
            nb0 nb0Var = hb0.a.d().get(event.getA());
            if (nb0Var == null || nb0Var.getDeviceType() == null) {
                se0.g(new Runnable() { // from class: dc.a30
                    @Override // java.lang.Runnable
                    public final void run() {
                        b30.l(this.a, event);
                    }
                }, 1000L);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
