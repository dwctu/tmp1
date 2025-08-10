package dc;

import com.component.dxtoy.core.toy.bean.FuncBean;
import com.component.dxtoy.core.toy.bean.ToyConfigInfoBean;
import com.epicgames.unreal.psoservices.PSOProgramService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: ToyBusinessExt.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a\u001f\u0010\f\u001a\u00020\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0010\u001a\n\u0010\u0011\u001a\u00020\u0002*\u00020\u000e\u001a\n\u0010\u0012\u001a\u00020\u0002*\u00020\u000e\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u000e\u001a\n\u0010\u0014\u001a\u00020\u0002*\u00020\u000e\u001a\n\u0010\u0015\u001a\u00020\r*\u00020\u000e\u001a\n\u0010\u0016\u001a\u00020\u0003*\u00020\u000e\u001a\n\u0010\u0017\u001a\u00020\r*\u00020\u000e\u001a\u0012\u0010\u0018\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0002\u001a\n\u0010\u001a\u001a\u00020\r*\u00020\u000e\u001a\n\u0010\u001b\u001a\u00020\r*\u00020\u000e\u001a\n\u0010\u001c\u001a\u00020\r*\u00020\u000e\u001a\n\u0010\u001d\u001a\u00020\r*\u00020\u000e\u001a\n\u0010\u001e\u001a\u00020\r*\u00020\u000e\u001a\n\u0010\u001f\u001a\u00020\r*\u00020\u000e\u001a\n\u0010 \u001a\u00020\r*\u00020\u000e\u001a\n\u0010!\u001a\u00020\r*\u00020\u000e\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\""}, d2 = {"commandMap", "", "", "", "supportControlPanelToy", "", "[Ljava/lang/String;", "supportDepthModeToy", "supportLdrToy", "supportSetLedToy", "supportWearToy", "thirdPartToy", "checkToyConfigSymbolInArray", "", "Lcom/component/dxtoy/core/toy/ToyInfo;", "array", "(Lcom/component/dxtoy/core/toy/ToyInfo;[Ljava/lang/String;)Z", "getGenerationVersion", "getSimpleFullName", "getSimpleName", "getSimpleType", "isCanSetLed", "isFeedbackModeEnableAndUpdateEnable", "isSupportBt", "isSupportCommand", "command", "isSupportControlPanel", "isSupportDepthMode", "isSupportGame", "isSupportLdr", "isSupportV1V2", "isSupportV1V2V3", "isSupportWear", "isThirdToy", "toy_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class t10 {

    @NotNull
    public static final String[] a = {"a", "b", PSOProgramService.VS_Key, "t", "f", "fs"};

    @NotNull
    public static final String[] b = {"a", "b"};

    @NotNull
    public static final String[] c = {"a", "b", "t"};

    @NotNull
    public static final String[] d = {PSOProgramService.VS_Key, "t"};

    @NotNull
    public static final String[] e = {"s", "z", "p", StreamManagement.AckRequest.ELEMENT, "x"};

    @NotNull
    public static final String[] f = {"s", "z", "p", StreamManagement.AckRequest.ELEMENT, "x"};

    @NotNull
    public static final Map<String, Integer> g = MapsKt__MapsKt.mapOf(TuplesKt.to("Vibrate:", 1), TuplesKt.to("vibrate:", 1), TuplesKt.to("Vibrate1:", 2), TuplesKt.to("vibrate1:", 2), TuplesKt.to("Vibrate2:", 2), TuplesKt.to("vibrate2:", 2), TuplesKt.to("Rotate:", 3), TuplesKt.to("rotate:", 3), TuplesKt.to("Air:Level:", 4), TuplesKt.to("air:level:", 4), TuplesKt.to("Suction:", 5), TuplesKt.to("suction:", 5), TuplesKt.to("Thrusting:", 6), TuplesKt.to("thrusting:", 6), TuplesKt.to("Fingering:", 7), TuplesKt.to("fingering:", 7), TuplesKt.to("vibrate3:", 7), TuplesKt.to("Depth:", 8), TuplesKt.to("depth:", 8));

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean a(dc.nb0 r7, java.lang.String[] r8) {
        /*
            int r0 = r8.length
            r1 = 0
            r2 = 0
        L3:
            r3 = 1
            if (r2 >= r0) goto L43
            r4 = r8[r2]
            com.component.dxtoy.core.toy.bean.ToyConfigInfoBean r5 = r7.g()
            if (r5 == 0) goto L3b
            java.util.List r5 = r5.getSymbol()
            if (r5 == 0) goto L3b
            boolean r6 = r5 instanceof java.util.Collection
            if (r6 == 0) goto L20
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L20
        L1e:
            r4 = 0
            goto L37
        L20:
            java.util.Iterator r5 = r5.iterator()
        L24:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L1e
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r6, r3)
            if (r6 == 0) goto L24
            r4 = 1
        L37:
            if (r4 != r3) goto L3b
            r4 = 1
            goto L3c
        L3b:
            r4 = 0
        L3c:
            if (r4 == 0) goto L40
            r1 = 1
            goto L43
        L40:
            int r2 = r2 + 1
            goto L3
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.t10.a(dc.nb0, java.lang.String[]):boolean");
    }

    @NotNull
    public static final String b(@NotNull nb0 nb0Var) {
        String strE;
        String string;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        int iF = tb0.f(nb0Var);
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (strE = toyConfigInfoBeanG.getFullName()) == null) {
            strE = nb0Var.e();
        }
        boolean z = true;
        if (iF > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(' ');
            sb.append(iF);
            string = sb.toString();
        } else {
            string = "";
        }
        if (strE != null && strE.length() != 0) {
            z = false;
        }
        if (z) {
            return "Unknown";
        }
        return strE + string;
    }

    @NotNull
    public static final String c(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        int iF = tb0.f(nb0Var);
        String strE = nb0Var.e();
        if (strE != null) {
            if (iF > 1) {
                strE = strE + ' ' + iF;
            }
            if (strE != null) {
                return strE;
            }
        }
        return "Unknown";
    }

    @NotNull
    public static final String d(@NotNull nb0 nb0Var) {
        String realType;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        int iF = tb0.f(nb0Var);
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG != null && (realType = toyConfigInfoBeanG.getRealType()) != null) {
            if (iF > 1) {
                realType = realType + ' ' + iF;
            }
            if (realType != null) {
                return realType;
            }
        }
        return "Unknown";
    }

    public static final boolean e(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        return a(nb0Var, e);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0064 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int f(@org.jetbrains.annotations.NotNull dc.nb0 r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.component.dxtoy.core.toy.bean.ToyConfigInfoBean r0 = r6.g()
            r1 = -1
            if (r0 == 0) goto Lcf
            java.util.List r2 = r0.getSymbol()
            if (r2 != 0) goto L13
            return r1
        L13:
            java.lang.String r2 = r6.h()
            java.lang.String r0 = r0.getType()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L26
            goto Lcf
        L26:
            boolean r0 = dc.ub0.g(r6)
            if (r0 == 0) goto L67
            boolean r0 = dc.tb0.i(r6)
            if (r0 == 0) goto L35
        L32:
            r1 = 0
            goto Lcf
        L35:
            int r0 = r6.getVersion()
            r1 = 130(0x82, float:1.82E-43)
            r5 = 160(0xa0, float:2.24E-43)
            if (r1 > r0) goto L43
            if (r0 >= r5) goto L43
            r0 = 1
            goto L44
        L43:
            r0 = 0
        L44:
            if (r0 != 0) goto L64
            int r0 = r6.getVersion()
            if (r5 > r0) goto L52
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 >= r1) goto L52
            r0 = 1
            goto L53
        L52:
            r0 = 0
        L53:
            if (r0 != 0) goto L64
            int r6 = r6.getVersion()
            r0 = 240(0xf0, float:3.36E-43)
            if (r0 > r6) goto L62
            r0 = 280(0x118, float:3.92E-43)
            if (r6 >= r0) goto L62
            r4 = 1
        L62:
            if (r4 == 0) goto L81
        L64:
            r1 = 1
            goto Lcf
        L67:
            boolean r0 = dc.ub0.k(r6)
            if (r0 == 0) goto L83
            boolean r0 = dc.tb0.i(r6)
            if (r0 == 0) goto L74
            goto L32
        L74:
            int r6 = r6.getVersion()
            if (r3 > r6) goto L7e
            r0 = 3
            if (r6 >= r0) goto L7e
            r4 = 1
        L7e:
            if (r4 == 0) goto L81
        L80:
            goto L64
        L81:
            r1 = 2
            goto Lcf
        L83:
            boolean r0 = dc.ub0.e(r6)
            if (r0 == 0) goto Lb1
            boolean r0 = dc.tb0.i(r6)
            if (r0 == 0) goto L90
            goto L32
        L90:
            int r0 = r6.getVersion()
            r1 = 210(0xd2, float:2.94E-43)
            if (r1 > r0) goto L9e
            r1 = 300(0x12c, float:4.2E-43)
            if (r0 >= r1) goto L9e
            r0 = 1
            goto L9f
        L9e:
            r0 = 0
        L9f:
            if (r0 != 0) goto L64
            int r6 = r6.getVersion()
            r0 = 330(0x14a, float:4.62E-43)
            if (r0 > r6) goto Lae
            r0 = 370(0x172, float:5.18E-43)
            if (r6 >= r0) goto Lae
            r4 = 1
        Lae:
            if (r4 == 0) goto L81
            goto L64
        Lb1:
            boolean r0 = dc.ub0.j(r6)
            if (r0 == 0) goto Lcf
            boolean r0 = dc.tb0.i(r6)
            if (r0 == 0) goto Lbf
            goto L32
        Lbf:
            int r6 = r6.getVersion()
            r0 = 63
            if (r0 > r6) goto Lcc
            r0 = 110(0x6e, float:1.54E-43)
            if (r6 >= r0) goto Lcc
            r4 = 1
        Lcc:
            if (r4 == 0) goto L81
            goto L80
        Lcf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.t10.f(dc.nb0):int");
    }

    public static final boolean g(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        if (!Intrinsics.areEqual(nb0Var.h(), "max") || nb0Var.getVersion() < 104) {
            return Intrinsics.areEqual(nb0Var.h(), "nora") && nb0Var.getVersion() >= 105;
        }
        return true;
    }

    public static final boolean h(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        return a(nb0Var, c);
    }

    public static final boolean i(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        return a(nb0Var, d);
    }

    public static final boolean j(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        if (Intrinsics.areEqual(nb0Var.h(), "max")) {
            if (nb0Var.getVersion() < 212) {
                int version = nb0Var.getVersion();
                if (205 <= version && version < 210) {
                }
            }
            return true;
        }
        return false;
    }

    public static final boolean k(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        return a(nb0Var, a);
    }

    public static final boolean l(@NotNull nb0 nb0Var) {
        FuncBean func;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        return toyConfigInfoBeanG != null && (func = toyConfigInfoBeanG.getFunc()) != null && func.getV1() && func.getV2();
    }

    public static final boolean m(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        return a(nb0Var, f);
    }

    public static final boolean n(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        return a(nb0Var, b) && nb0Var.getVersion() < 100;
    }
}
