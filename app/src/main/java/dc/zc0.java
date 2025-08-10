package dc;

import android.content.Context;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.sun.jna.Callback;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EmulatorCollector2.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006 "}, d2 = {"Lcom/component/dxutilcode/lib/collector/EmulatorCollector2;", "", "()V", "userAppNumber", "", "getUserAppNumber", "()I", "checkFeaturesByBaseBand", "Lcom/component/dxutilcode/lib/collector/CheckResult;", "checkFeaturesByBoard", "checkFeaturesByCgroup", "checkFeaturesByFlavor", "checkFeaturesByHardware", "checkFeaturesByManufacturer", "checkFeaturesByModel", "checkFeaturesByPlatform", "detectEmulator", "", "context", "Landroid/content/Context;", Callback.METHOD_NAME, "Lcom/component/dxutilcode/lib/collector/EmulatorCollector2Callback;", "getProperty", "", "propName", "getSensorNumber", "getUserAppNum", "userApps", "hasLightSensor", "supportBluetooth", "supportCamera", "supportCameraFlash", "hytto-apps.android.components.base.dxutilcode"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class zc0 {

    @NotNull
    public static final zc0 a = new zc0();

    @JvmStatic
    public static final boolean i(@Nullable Context context, @Nullable ad0 ad0Var) throws Throwable {
        int i;
        if (context == null) {
            throw new IllegalArgumentException("context must not be null".toString());
        }
        String str = "";
        zc0 zc0Var = a;
        yc0 yc0VarE = zc0Var.e();
        int a2 = yc0VarE.getA();
        if (a2 == 0) {
            str = "hardware = " + ((Object) yc0VarE.getB()) + '\n';
            i = 1;
        } else {
            if (a2 == 1) {
                if (ad0Var != null) {
                    ad0Var.a(Intrinsics.stringPlus("hardware = ", yc0VarE.getB()));
                }
                return true;
            }
            i = 0;
        }
        yc0 yc0VarD = zc0Var.d();
        int a3 = yc0VarD.getA();
        if (a3 == 0) {
            i++;
            str = str + "flavor = " + ((Object) yc0VarD.getB()) + '\n';
        } else if (a3 == 1) {
            if (ad0Var != null) {
                ad0Var.a(Intrinsics.stringPlus("flavor = ", yc0VarD.getB()));
            }
            return true;
        }
        yc0 yc0VarG = zc0Var.g();
        int a4 = yc0VarG.getA();
        if (a4 == 0) {
            i++;
            str = str + "model = " + ((Object) yc0VarG.getB()) + '\n';
        } else if (a4 == 1) {
            if (ad0Var != null) {
                ad0Var.a(Intrinsics.stringPlus("model = ", yc0VarG.getB()));
            }
            return true;
        }
        yc0 yc0VarF = zc0Var.f();
        int a5 = yc0VarF.getA();
        if (a5 == 0) {
            i++;
            str = str + "manufacturer = " + ((Object) yc0VarF.getB()) + '\n';
        } else if (a5 == 1) {
            if (ad0Var != null) {
                ad0Var.a(Intrinsics.stringPlus("manufacturer = ", yc0VarF.getB()));
            }
            return true;
        }
        yc0 yc0VarB = zc0Var.b();
        int a6 = yc0VarB.getA();
        if (a6 == 0) {
            i++;
            str = str + "board = " + ((Object) yc0VarB.getB()) + '\n';
        } else if (a6 == 1) {
            if (ad0Var != null) {
                ad0Var.a(Intrinsics.stringPlus("board = ", yc0VarB.getB()));
            }
            return true;
        }
        yc0 yc0VarH = zc0Var.h();
        int a7 = yc0VarH.getA();
        if (a7 == 0) {
            i++;
            str = str + "platform = " + ((Object) yc0VarH.getB()) + '\n';
        } else if (a7 == 1) {
            if (ad0Var != null) {
                ad0Var.a(Intrinsics.stringPlus("platform = ", yc0VarH.getB()));
            }
            return true;
        }
        yc0 yc0VarA = zc0Var.a();
        int a8 = yc0VarA.getA();
        if (a8 == 0) {
            i += 2;
            str = str + "baseBand = " + ((Object) yc0VarA.getB()) + '\n';
        } else if (a8 == 1) {
            if (ad0Var != null) {
                ad0Var.a(Intrinsics.stringPlus("baseBand = ", yc0VarA.getB()));
            }
            return true;
        }
        int iK = zc0Var.k(context);
        if (iK <= 7) {
            i++;
            str = str + "sensorNumber = " + iK + '\n';
        }
        int iM = zc0Var.m();
        if (iM <= 5) {
            i++;
            str = str + "userAppNumber = " + iM + '\n';
        }
        boolean zQ = zc0Var.q(context);
        if (!zQ) {
            i++;
            str = str + "supportCameraFlash = " + zQ + '\n';
        }
        boolean zP = zc0Var.p(context);
        if (!zP) {
            i++;
            str = str + "supportCamera = " + zP + '\n';
        }
        boolean zO = zc0Var.o(context);
        if (!zO) {
            i++;
            str = str + "supportBluetooth = " + zO + '\n';
        }
        boolean zN = zc0Var.n(context);
        if (!zN) {
            i++;
            str = str + "hasLightSensor = " + zN + '\n';
        }
        yc0 yc0VarC = zc0Var.c();
        if (yc0VarC.getA() == 0) {
            i++;
            str = str + "cgroup = " + ((Object) yc0VarC.getB());
        }
        if (ad0Var != null) {
            StringBuffer stringBuffer = new StringBuffer("Check Result:");
            stringBuffer.append("\r\n");
            stringBuffer.append("suspectCount = ");
            stringBuffer.append(i);
            stringBuffer.append("\r\n");
            stringBuffer.append("countStr = ");
            stringBuffer.append(str);
            ad0Var.a(stringBuffer.toString());
        }
        return i > 3;
    }

    public final yc0 a() throws Throwable {
        String strJ = j("gsm.version.baseband");
        if (strJ == null) {
            return new yc0(0, null);
        }
        return new yc0(StringsKt__StringsKt.contains$default((CharSequence) strJ, (CharSequence) "1.0.0.0", false, 2, (Object) null) ? 1 : 2, strJ);
    }

    public final yc0 b() throws Throwable {
        String strJ = j("ro.product.board");
        if (strJ == null) {
            return new yc0(0, null);
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = strJ.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return new yc0((StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE, false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "goldfish", false, 2, (Object) null)) ? 1 : 2, strJ);
    }

    public final yc0 c() {
        String str = pe0.a("cat /proc/self/cgroup", false).b;
        return new yc0(TextUtils.isEmpty(str) ? 0 : 2, str);
    }

    public final yc0 d() throws Throwable {
        String strJ = j("ro.build.flavor");
        if (strJ == null) {
            return new yc0(0, null);
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = strJ.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return new yc0((StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "vbox", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "sdk_gphone", false, 2, (Object) null)) ? 1 : 2, strJ);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final dc.yc0 e() throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.String r0 = "ro.hardware"
            java.lang.String r0 = r3.j(r0)
            if (r0 != 0) goto L10
            dc.yc0 r0 = new dc.yc0
            r1 = 0
            r2 = 0
            r0.<init>(r1, r2)
            return r0
        L10:
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r2 = "getDefault()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r1 = r0.toLowerCase(r1)
            java.lang.String r2 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            int r2 = r1.hashCode()
            switch(r2) {
                case -1367724016: goto L64;
                case -822798509: goto L5a;
                case 109271: goto L51;
                case 3570999: goto L47;
                case 3613077: goto L3d;
                case 100361430: goto L34;
                case 937844646: goto L2b;
                default: goto L2a;
            }
        L2a:
            goto L6f
        L2b:
            java.lang.String r2 = "android_x86"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L6d
            goto L6f
        L34:
            java.lang.String r2 = "intel"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L6d
            goto L6f
        L3d:
            java.lang.String r2 = "vbox"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L6d
            goto L6f
        L47:
            java.lang.String r2 = "ttvm"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L6d
            goto L6f
        L51:
            java.lang.String r2 = "nox"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L6d
            goto L6f
        L5a:
            java.lang.String r2 = "vbox86"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L6d
            goto L6f
        L64:
            java.lang.String r2 = "cancro"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L6d
            goto L6f
        L6d:
            r1 = 1
            goto L70
        L6f:
            r1 = 2
        L70:
            dc.yc0 r2 = new dc.yc0
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.zc0.e():dc.yc0");
    }

    public final yc0 f() throws Throwable {
        String strJ = j("ro.product.manufacturer");
        if (strJ == null) {
            return new yc0(0, null);
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = strJ.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return new yc0((StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "genymotion", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "netease", false, 2, (Object) null)) ? 1 : 2, strJ);
    }

    public final yc0 g() throws Throwable {
        String strJ = j("ro.product.model");
        if (strJ == null) {
            return new yc0(0, null);
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = strJ.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return new yc0((StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "google_sdk", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "emulator", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "android sdk built for x86", false, 2, (Object) null)) ? 1 : 2, strJ);
    }

    public final yc0 h() throws Throwable {
        String strJ = j("ro.board.platform");
        if (strJ == null) {
            return new yc0(0, null);
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = strJ.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return new yc0(StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE, false, 2, (Object) null) ? 1 : 2, strJ);
    }

    public final String j(String str) throws Throwable {
        String strE = ke0.e(str);
        if (TextUtils.isEmpty(strE)) {
            return null;
        }
        return strE;
    }

    public final int k(Context context) {
        Object systemService = context.getSystemService("sensor");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        return ((SensorManager) systemService).getSensorList(-1).size();
    }

    public final int l(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Object[] array = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"package:"}, false, 0, 6, (Object) null).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return ((String[]) array).length;
    }

    public final int m() {
        String userApps = pe0.a("pm list package -3", false).b;
        Intrinsics.checkNotNullExpressionValue(userApps, "userApps");
        return l(userApps);
    }

    public final boolean n(Context context) {
        Object systemService = context.getSystemService("sensor");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        return ((SensorManager) systemService).getDefaultSensor(5) != null;
    }

    public final boolean o(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
    }

    public final boolean p(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    public final boolean q(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }
}
