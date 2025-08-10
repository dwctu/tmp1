package dc;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: EmulatorCollector.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/component/dxutilcode/lib/collector/EmulatorCollector;", "Lcom/component/dxutilcode/lib/collector/EmulatorInterface;", "()V", "QEMU_FILES", "", "", "checkBuildInfo", "", "checkDevice", "checkFiles", "checkFingerprint", "checkHardware", "checkModel", "checkOtherBuildInfo", "checkProduct", "checkSensors", "context", "Landroid/content/Context;", "checkTelephony", "detectEmulator", "hytto-apps.android.components.base.dxutilcode"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class bd0 {

    @NotNull
    public final List<String> a = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"/dev/socket/genyd", "/dev/socket/baseband_genyd", "/dev/socket/qemud", "/dev/qemu_pipe", "/system/bin/nox-prop", "/system/bin/ttVM-prop", "/system/bin/droid4x-prop", "/data/.bluestacks.prop", "/system/bin/androVM-prop", "/system/bin/microvirt-prop", "/system/lib/libdroid4x.so", "/system/bin/windroyed", "system/lib/libnoxspeedup.so", "/system/bin/duosconfig", "/system/etc/xxzs_prop.sh", "/system/etc/mumu-configs/device-prop-configs/mumu.config", "/system/priv-app/ldAppStore", "system/bin/ldinit", "/system/app/AntStore", "vmos.prop", "fstab.titan", "x8.prop", "/system/lib/libc_malloc_debug_qemu.so"});

    public final boolean a() {
        return b() || f() || d() || h() || e() || g();
    }

    public final boolean b() {
        String DEVICE = Build.DEVICE;
        if (!Intrinsics.areEqual("nox", DEVICE) && !Intrinsics.areEqual("vbox86p", DEVICE) && !Intrinsics.areEqual("vbox86tp", DEVICE) && !Intrinsics.areEqual("appplayer", DEVICE) && !Intrinsics.areEqual("droid4x", DEVICE) && !Intrinsics.areEqual("vbox", DEVICE) && !Intrinsics.areEqual("virtual", DEVICE) && !Intrinsics.areEqual("andywin", DEVICE) && !Intrinsics.areEqual("andyosx", DEVICE) && !Intrinsics.areEqual("generic", DEVICE) && !Intrinsics.areEqual("generic_x86", DEVICE)) {
            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = DEVICE.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "mumu", false, 2, (Object) null)) {
                Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
                String lowerCase2 = DEVICE.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                if (!StringsKt__StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "zerofltezc", false, 2, (Object) null)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean c() {
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            if (new File(it.next()).exists()) {
                return true;
            }
        }
        return false;
    }

    public final boolean d() {
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        if (!StringsKt__StringsJVMKt.startsWith$default(FINGERPRINT, "generic", false, 2, null)) {
            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
            if (!StringsKt__StringsKt.contains$default((CharSequence) FINGERPRINT, (CharSequence) "vbox", false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    public final boolean e() {
        String str = Build.HARDWARE;
        return Intrinsics.areEqual("goldfish", str) || Intrinsics.areEqual("vbox86", str);
    }

    public final boolean f() {
        String MODEL = Build.MODEL;
        if (!Intrinsics.areEqual("vmos", MODEL) && !Intrinsics.areEqual("duos", MODEL) && !Intrinsics.areEqual("amiduos", MODEL) && !Intrinsics.areEqual("noxw", MODEL) && !Intrinsics.areEqual("genymotion", MODEL) && !Intrinsics.areEqual("bluestacks", MODEL) && !Intrinsics.areEqual("tiantian", MODEL) && !Intrinsics.areEqual("windroy", MODEL)) {
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            if (!StringsKt__StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                String lowerCase = MODEL.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (!StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "droid4x", false, 2, (Object) null)) {
                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                    if (!StringsKt__StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "Emulator", false, 2, (Object) null)) {
                        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                        if (!StringsKt__StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                            if (!StringsKt__StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "Subsystem for Android(TM)", false, 2, (Object) null)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public final boolean g() {
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        if (!StringsKt__StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
            String BOARD = Build.BOARD;
            Intrinsics.checkNotNullExpressionValue(BOARD, "BOARD");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = BOARD.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "nox", false, 2, (Object) null)) {
                String BOOTLOADER = Build.BOOTLOADER;
                Intrinsics.checkNotNullExpressionValue(BOOTLOADER, "BOOTLOADER");
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
                String lowerCase2 = BOOTLOADER.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                if (!StringsKt__StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "nox", false, 2, (Object) null)) {
                    String HARDWARE = Build.HARDWARE;
                    Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
                    Locale locale3 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale3, "getDefault()");
                    String lowerCase3 = HARDWARE.toLowerCase(locale3);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                    if (!StringsKt__StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "nox", false, 2, (Object) null)) {
                        String SERIAL = Build.SERIAL;
                        Intrinsics.checkNotNullExpressionValue(SERIAL, "SERIAL");
                        Locale locale4 = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale4, "getDefault()");
                        String lowerCase4 = SERIAL.toLowerCase(locale4);
                        Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                        if (!StringsKt__StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) "nox", false, 2, (Object) null)) {
                            String HOST = Build.HOST;
                            Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                            Locale locale5 = Locale.getDefault();
                            Intrinsics.checkNotNullExpressionValue(locale5, "getDefault()");
                            String lowerCase5 = HOST.toLowerCase(locale5);
                            Intrinsics.checkNotNullExpressionValue(lowerCase5, "this as java.lang.String).toLowerCase(locale)");
                            if (!StringsKt__StringsJVMKt.startsWith$default(lowerCase5, "bliss-os", false, 2, null)) {
                                String BRAND = Build.BRAND;
                                Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                if (!StringsKt__StringsJVMKt.startsWith$default(BRAND, "generic", false, 2, null)) {
                                    return false;
                                }
                                String DEVICE = Build.DEVICE;
                                Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                if (!StringsKt__StringsJVMKt.startsWith$default(DEVICE, "generic", false, 2, null)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public final boolean h() {
        String PRODUCT = Build.PRODUCT;
        if (!Intrinsics.areEqual("sdk", PRODUCT) && !Intrinsics.areEqual("google_sdk", PRODUCT) && !Intrinsics.areEqual("sdk_x86", PRODUCT) && !Intrinsics.areEqual("vbox86p", PRODUCT) && !Intrinsics.areEqual("vbox86tp", PRODUCT) && !Intrinsics.areEqual("genymotion", PRODUCT) && !Intrinsics.areEqual("bluestacks", PRODUCT) && !Intrinsics.areEqual("droid4x", PRODUCT) && !Intrinsics.areEqual("ttvm_hdragon", PRODUCT) && !Intrinsics.areEqual("duos_native", PRODUCT) && !Intrinsics.areEqual("duos", PRODUCT) && !Intrinsics.areEqual("vbox", PRODUCT) && !Intrinsics.areEqual("android_x86", PRODUCT)) {
            Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = PRODUCT.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "nox", false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    public final boolean i(Context context) {
        Object systemService = context.getSystemService("sensor");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        return ((SensorManager) systemService).getSensorList(-1).size() < 7;
    }

    public final boolean j(Context context) {
        Object systemService = context.getSystemService("phone");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
        Intrinsics.checkNotNullExpressionValue(networkOperatorName, "telephonyManager.networkOperatorName");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = networkOperatorName.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE, false, 2, (Object) null);
    }

    public boolean k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a() || c() || j(context) || i(context);
    }
}
