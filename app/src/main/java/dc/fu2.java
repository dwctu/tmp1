package dc;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.spotify.sdk.android.player.Config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: RomUtils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020\u0005H\u0002J\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0010\u00100\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202J\u0006\u00104\u001a\u000202J\u0006\u00105\u001a\u000202J\u0006\u00106\u001a\u000202J\u0006\u00107\u001a\u000202J\u0006\u00108\u001a\u000202J\u0006\u00109\u001a\u000202J\u0006\u0010:\u001a\u000202J\u0006\u0010;\u001a\u000202J\u0006\u0010<\u001a\u000202J\u0006\u0010=\u001a\u000202J\u0006\u0010>\u001a\u000202J\u0006\u0010?\u001a\u000202J\u0006\u0010@\u001a\u000202J+\u0010A\u001a\u0002022\u0006\u0010%\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0002\u0010DJ\u0006\u0010E\u001a\u000202J\u0006\u0010F\u001a\u000202J\u0006\u0010G\u001a\u000202J\u0006\u0010H\u001a\u000202J\u0006\u0010I\u001a\u000202J\u0006\u0010J\u001a\u000202J\b\u0010B\u001a\u00020\u0005H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/utils/RomUtils;", "", "()V", "ROM_360", "", "", "[Ljava/lang/String;", "ROM_BLACKBERRY", "ROM_COOLPAD", "ROM_GIONEE", "ROM_GOOGLE", "ROM_HTC", "ROM_HUAWEI", "ROM_LEECO", "ROM_LENOVO", "ROM_LG", "ROM_MEIZU", "ROM_MOTOROLA", "ROM_NUBIA", "ROM_ONEPLUS", "ROM_OPPO", "ROM_SAMSUNG", "ROM_SMARTISAN", "ROM_SONY", "ROM_VIVO", "ROM_XIAOMI", "ROM_ZTE", GrsBaseInfo.CountryCodeSource.UNKNOWN, "VERSION_PROPERTY_360", "VERSION_PROPERTY_HUAWEI", "VERSION_PROPERTY_LEECO", "VERSION_PROPERTY_NUBIA", "VERSION_PROPERTY_ONEPLUS", "VERSION_PROPERTY_OPPO", "VERSION_PROPERTY_VIVO", "VERSION_PROPERTY_XIAOMI", "VERSION_PROPERTY_ZTE", "brand", "getRomInfo", "Lcom/wear/ui/chat/pancel/helper/utils/RomInfo;", "getRomVersion", "propertyName", "getSystemProperty", "name", "getSystemPropertyByReflect", "key", "getSystemPropertyByShell", "propName", "getSystemPropertyByStream", "is360", "", "isBlackberry", "isCoolpad", "isGionee", "isGoogle", "isHtc", "isHuawei", "isLeeco", "isLenovo", "isLg", "isMeizu", "isMotorola", "isNubia", "isOneplus", "isOppo", "isRightRom", "manufacturer", "names", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "isSamsung", "isSmartisan", "isSony", "isVivo", "isXiaomi", "isZte", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class fu2 {

    @NotNull
    public static final fu2 a = new fu2();

    @NotNull
    public static final String[] b = {"huawei"};

    @NotNull
    public static final String[] c = {"vivo"};

    @NotNull
    public static final String[] d = {"xiaomi"};

    @NotNull
    public static final String[] e = {"oppo"};

    @NotNull
    public static final String[] f = {"leeco", "letv"};

    @NotNull
    public static final String[] g = {"360", "qiku"};

    @NotNull
    public static final String[] h = {"zte"};

    @NotNull
    public static final String[] i = {"oneplus"};

    @NotNull
    public static final String[] j = {"nubia"};

    @NotNull
    public static final String[] k = {"coolpad", "yulong"};

    @NotNull
    public static final String[] l = {"lg", "lge"};

    @NotNull
    public static final String[] m = {"google"};

    @NotNull
    public static final String[] n = {"samsung"};

    @NotNull
    public static final String[] o = {"meizu"};

    @NotNull
    public static final String[] p = {"lenovo"};

    @NotNull
    public static final String[] q = {"smartisan"};

    @NotNull
    public static final String[] r = {"htc"};

    @NotNull
    public static final String[] s = {"sony"};

    @NotNull
    public static final String[] t = {"gionee", "amigo"};

    @NotNull
    public static final String[] u = {"motorola"};

    @NotNull
    public static final String[] v = {"blackberry"};

    public final String a() {
        try {
            String brand = Build.BRAND;
            if (TextUtils.isEmpty(brand)) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            Intrinsics.checkNotNullExpressionValue(brand, "brand");
            String lowerCase = brand.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            return lowerCase;
        } catch (Throwable unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    @NotNull
    public final eu2 b() {
        eu2 eu2Var = new eu2();
        String strA = a();
        String strI = i();
        eu2Var.c(Build.VERSION.SDK_INT);
        eu2Var.d(Build.VERSION.RELEASE);
        eu2Var.e(Build.MODEL);
        String[] strArr = b;
        if (h(strA, strI, strArr)) {
            eu2Var.f(strArr[0]);
            String strC = c("ro.build.version.emui");
            String[] strArr2 = (String[]) StringsKt__StringsKt.split$default((CharSequence) strC, new String[]{Config.IN_FIELD_SEPARATOR}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (strArr2.length > 1) {
                eu2Var.g(strArr2[1]);
            } else {
                eu2Var.g(strC);
            }
            return eu2Var;
        }
        String[] strArr3 = c;
        if (h(strA, strI, strArr3)) {
            eu2Var.f(strArr3[0]);
            eu2Var.g(c("ro.vivo.os.build.display.id"));
            return eu2Var;
        }
        String[] strArr4 = d;
        if (h(strA, strI, strArr4)) {
            eu2Var.f(strArr4[0]);
            eu2Var.g(c("ro.build.version.incremental"));
            return eu2Var;
        }
        String[] strArr5 = e;
        if (h(strA, strI, strArr5)) {
            eu2Var.f(strArr5[0]);
            eu2Var.g(c("ro.build.version.opporom"));
            return eu2Var;
        }
        String[] strArr6 = f;
        if (h(strA, strI, strArr6)) {
            eu2Var.f(strArr6[0]);
            eu2Var.g(c("ro.letv.release.version"));
            return eu2Var;
        }
        String[] strArr7 = g;
        if (h(strA, strI, strArr7)) {
            eu2Var.f(strArr7[0]);
            eu2Var.g(c("ro.build.uiversion"));
            return eu2Var;
        }
        String[] strArr8 = h;
        if (h(strA, strI, strArr8)) {
            eu2Var.f(strArr8[0]);
            eu2Var.g(c("ro.build.MiFavor_version"));
            return eu2Var;
        }
        String[] strArr9 = i;
        if (h(strA, strI, strArr9)) {
            eu2Var.f(strArr9[0]);
            eu2Var.g(c("ro.rom.version"));
            return eu2Var;
        }
        String[] strArr10 = j;
        if (h(strA, strI, strArr10)) {
            eu2Var.f(strArr10[0]);
            eu2Var.g(c("ro.build.rom.id"));
            return eu2Var;
        }
        String[] strArr11 = k;
        if (h(strA, strI, strArr11)) {
            eu2Var.f(strArr11[0]);
        } else {
            String[] strArr12 = l;
            if (h(strA, strI, strArr12)) {
                eu2Var.f(strArr12[0]);
            } else {
                String[] strArr13 = m;
                if (h(strA, strI, strArr13)) {
                    eu2Var.f(strArr13[0]);
                } else {
                    String[] strArr14 = n;
                    if (h(strA, strI, strArr14)) {
                        eu2Var.f(strArr14[0]);
                    } else {
                        String[] strArr15 = o;
                        if (h(strA, strI, strArr15)) {
                            eu2Var.f(strArr15[0]);
                        } else {
                            String[] strArr16 = p;
                            if (h(strA, strI, strArr16)) {
                                eu2Var.f(strArr16[0]);
                            } else {
                                String[] strArr17 = q;
                                if (h(strA, strI, strArr17)) {
                                    eu2Var.f(strArr17[0]);
                                } else {
                                    String[] strArr18 = r;
                                    if (h(strA, strI, strArr18)) {
                                        eu2Var.f(strArr18[0]);
                                    } else {
                                        String[] strArr19 = s;
                                        if (h(strA, strI, strArr19)) {
                                            eu2Var.f(strArr19[0]);
                                        } else {
                                            String[] strArr20 = t;
                                            if (h(strA, strI, strArr20)) {
                                                eu2Var.f(strArr20[0]);
                                            } else {
                                                String[] strArr21 = u;
                                                if (h(strA, strI, strArr21)) {
                                                    eu2Var.f(strArr21[0]);
                                                } else {
                                                    String[] strArr22 = v;
                                                    if (h(strA, strI, strArr22)) {
                                                        eu2Var.f(strArr22[0]);
                                                    } else {
                                                        eu2Var.f(strI);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        eu2Var.g(c(""));
        return eu2Var;
    }

    public final String c(String str) {
        String strD = !TextUtils.isEmpty(str) ? d(str) : "";
        if (TextUtils.isEmpty(strD) || Intrinsics.areEqual(strD, EnvironmentCompat.MEDIA_UNKNOWN)) {
            try {
                String display = Build.DISPLAY;
                if (!TextUtils.isEmpty(display)) {
                    Intrinsics.checkNotNullExpressionValue(display, "display");
                    String lowerCase = display.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                    strD = lowerCase;
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(strD) ? EnvironmentCompat.MEDIA_UNKNOWN : strD;
    }

    public final String d(String str) throws Throwable {
        String strF = f(str);
        if (!TextUtils.isEmpty(strF)) {
            return strF;
        }
        String strG = g(str);
        return (TextUtils.isEmpty(strG) && Build.VERSION.SDK_INT < 28) ? e(str) : strG;
    }

    public final String e(String str) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
            return (String) objInvoke;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String f(String str) throws Throwable {
        BufferedReader bufferedReader;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    line = bufferedReader.readLine();
                } catch (IOException unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 == null) {
                        return "";
                    }
                    bufferedReader2.close();
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
            if (line != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
                return line;
            }
            bufferedReader.close();
            return "";
        } catch (IOException unused5) {
            return "";
        }
    }

    public final String g(String str) throws IOException {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            String property = properties.getProperty(str, "");
            Intrinsics.checkNotNullExpressionValue(property, "prop.getProperty(key, \"\")");
            return property;
        } catch (Exception unused) {
            return "";
        }
    }

    public final boolean h(String str, String str2, String[] strArr) {
        for (String str3 : strArr) {
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) str3, false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) str3, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public final String i() {
        try {
            String manufacturer = Build.MANUFACTURER;
            if (TextUtils.isEmpty(manufacturer)) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            Intrinsics.checkNotNullExpressionValue(manufacturer, "manufacturer");
            String lowerCase = manufacturer.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            return lowerCase;
        } catch (Throwable unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }
}
