package io.agora.rtc2.internal;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.broadcom.bt.util.io.IOUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.agora.base.internal.video.VideoEncoderUtils;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class DeviceUtils {
    private static final List<String> CPU_TEMP_FILE_PATHS = Arrays.asList("/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/cpufreq/FakeShmoo_cpu_temp", "/sys/class/thermal/thermal_zone0/temp", "/sys/class/i2c-adapter/i2c-4/4-004c/temperature", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/temperature", "/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/devices/platform/tegra_tmon/temp1_input", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/devices/platform/s5p-tmu/temperature", "/sys/class/thermal/thermal_zone1/temp", "/sys/class/hwmon/hwmon0/device/temp1_input", "/sys/devices/virtual/thermal/thermal_zone1/temp", "/sys/devices/virtual/thermal/thermal_zone0/temp", "/sys/class/thermal/thermal_zone3/temp", "/sys/class/thermal/thermal_zone4/temp", "/sys/class/hwmon/hwmonX/temp1_input", "/sys/devices/platform/s5p-tmu/curr_temp");
    private static double INVALIED_TMPERATURE = -100000.0d;
    private static final String TAG = "DeviceUtils";
    private static double TMPERATURE_HIGH_THR = 250.0d;
    private static double TMPERATURE_LOW_THR = -30.0d;

    public static int getCpuTemperature() {
        return getCpuTemperature(CPU_TEMP_FILE_PATHS);
    }

    public static int getCpuTemperature(@NonNull List<String> list) {
        double validateTemperature = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (String str : list) {
            try {
                validateTemperature = getValidateTemperature(readDoubleValueFromFileFirstLine(str, INVALIED_TMPERATURE));
                Logging.i(TAG, "getCpuTemperature from file: " + str);
                break;
            } catch (IllegalArgumentException unused) {
                Logging.d(TAG, "can't getCpuTemperature from file: " + str);
            }
        }
        return (int) (validateTemperature * 1000.0d);
    }

    public static String getDeviceId() {
        String strReplace = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(strReplace)) {
            strReplace = strReplace.replace(IOUtils.DIR_SEPARATOR_UNIX, '_');
        }
        String strReplace2 = Build.MODEL;
        if (!TextUtils.isEmpty(strReplace2)) {
            strReplace2 = strReplace2.replace(IOUtils.DIR_SEPARATOR_UNIX, '_');
        }
        String strReplace3 = Build.PRODUCT;
        if (!TextUtils.isEmpty(strReplace3)) {
            strReplace3 = strReplace3.replace(IOUtils.DIR_SEPARATOR_UNIX, '_');
        }
        String str = Build.DEVICE;
        String strReplace4 = !TextUtils.isEmpty(str) ? str.replace(IOUtils.DIR_SEPARATOR_UNIX, '_') : str;
        StringBuilder sb = new StringBuilder();
        sb.append(strReplace);
        sb.append("/");
        sb.append(strReplace2);
        sb.append("/");
        sb.append(strReplace3);
        sb.append("/");
        sb.append(strReplace4);
        sb.append("/");
        int i = Build.VERSION.SDK_INT;
        sb.append(i);
        sb.append("/");
        sb.append(System.getProperty("os.version"));
        String lowerCase = sb.toString().toLowerCase();
        Matcher matcher = Pattern.compile(".*[A-Z][A-M][0-9]$").matcher(Build.ID);
        if (!Build.BRAND.toLowerCase().equals("samsung") || !str.toLowerCase().startsWith("cs02") || matcher.find() || i != 19) {
            return lowerCase;
        }
        return "yeshen_simulator/" + strReplace2 + "/" + strReplace3 + "/" + strReplace4 + "/" + i + "/" + System.getProperty("os.version");
    }

    public static String getDeviceInfo() {
        String strReplace = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(strReplace)) {
            strReplace = strReplace.replace(IOUtils.DIR_SEPARATOR_UNIX, '_');
        }
        String strReplace2 = Build.MODEL;
        if (!TextUtils.isEmpty(strReplace2)) {
            strReplace2 = strReplace2.replace(IOUtils.DIR_SEPARATOR_UNIX, '_');
        }
        return (strReplace + "/" + strReplace2).toLowerCase();
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER.toLowerCase();
    }

    public static int getRecommendedEncoderType() {
        return getRecommendedEncoderTypeImpl(Build.MODEL, Build.VERSION.SDK_INT);
    }

    public static int getRecommendedEncoderTypeImpl(String str, int i) {
        if (!VideoEncoderUtils.H264_HW_EXCEPTION_MODELS.contains(str)) {
            return i <= 18 ? 1 : 0;
        }
        Logging.w(TAG, "Model: " + Build.MODEL + " has black listed H.264 encoder.");
        return 1;
    }

    public static String getSystemInfo() {
        return "Android/" + Build.VERSION.RELEASE;
    }

    public static double getValidateTemperature(double d) throws IllegalArgumentException {
        if (Math.abs(d) > 1000.0d) {
            double d2 = d / 1000.0d;
            if (isTemperatureValid(d2)) {
                return d2;
            }
        } else if (isTemperatureValid(d)) {
            return d;
        }
        throw new IllegalArgumentException("not a validate temperature value");
    }

    public static boolean isTemperatureValid(double d) {
        return d >= TMPERATURE_LOW_THR && d <= TMPERATURE_HIGH_THR;
    }

    public static double parseDouble(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            Logging.d(TAG, "failed to conver string to double ", e);
            return d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static double readDoubleValueFromFileFirstLine(java.lang.String r5, double r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "failed to read from file"
            java.lang.String r1 = "DeviceUtils"
            java.io.File r2 = new java.io.File
            r2.<init>(r5)
            boolean r5 = r2.exists()
            if (r5 != 0) goto L10
            return r6
        L10:
            r5 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34 java.io.FileNotFoundException -> L45
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34 java.io.FileNotFoundException -> L45
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34 java.io.FileNotFoundException -> L45
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34 java.io.FileNotFoundException -> L45
            java.lang.String r5 = r3.readLine()     // Catch: java.io.IOException -> L2c java.io.FileNotFoundException -> L2e java.lang.Throwable -> L56
            double r5 = parseDouble(r5, r6)     // Catch: java.io.IOException -> L2c java.io.FileNotFoundException -> L2e java.lang.Throwable -> L56
            r3.close()     // Catch: java.io.IOException -> L27
            goto L2b
        L27:
            r7 = move-exception
            r7.printStackTrace()
        L2b:
            return r5
        L2c:
            r5 = move-exception
            goto L37
        L2e:
            r5 = move-exception
            goto L48
        L30:
            r6 = move-exception
            r3 = r5
            r5 = r6
            goto L57
        L34:
            r2 = move-exception
            r3 = r5
            r5 = r2
        L37:
            io.agora.rtc2.internal.Logging.d(r1, r0, r5)     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L44
            r3.close()     // Catch: java.io.IOException -> L40
            goto L44
        L40:
            r5 = move-exception
            r5.printStackTrace()
        L44:
            return r6
        L45:
            r2 = move-exception
            r3 = r5
            r5 = r2
        L48:
            io.agora.rtc2.internal.Logging.d(r1, r0, r5)     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L55
            r3.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r5 = move-exception
            r5.printStackTrace()
        L55:
            return r6
        L56:
            r5 = move-exception
        L57:
            if (r3 == 0) goto L61
            r3.close()     // Catch: java.io.IOException -> L5d
            goto L61
        L5d:
            r6 = move-exception
            r6.printStackTrace()
        L61:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.DeviceUtils.readDoubleValueFromFileFirstLine(java.lang.String, double):double");
    }
}
