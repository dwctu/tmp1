package io.agora.rtc2.internal.gdp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.opengl.GLES20;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.appcompat.widget.ActivityChooserModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.ContextUtils;
import io.agora.base.internal.Logging;
import io.agora.base.internal.ThreadUtils;
import io.agora.rtc2.internal.CommonUtility;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class GDPAndroid {
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: io.agora.rtc2.internal.gdp.GDPAndroid.2
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };
    private static final List<String> CPU_TEMP_FILE_PATHS = Arrays.asList("/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/cpufreq/FakeShmoo_cpu_temp", "/sys/class/thermal/thermal_zone0/temp", "/sys/class/i2c-adapter/i2c-4/4-004c/temperature", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/temperature", "/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/devices/platform/tegra_tmon/temp1_input", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/devices/platform/s5p-tmu/temperature", "/sys/class/thermal/thermal_zone1/temp", "/sys/class/hwmon/hwmon0/device/temp1_input", "/sys/devices/virtual/thermal/thermal_zone1/temp", "/sys/devices/virtual/thermal/thermal_zone0/temp", "/sys/class/thermal/thermal_zone3/temp", "/sys/class/thermal/thermal_zone4/temp", "/sys/class/hwmon/hwmonX/temp1_input", "/sys/devices/platform/s5p-tmu/curr_temp");
    private static final int DEVICEINFO_UNKNOWN = -1;
    private static final int OP_TIMEOUT_MS = 20;
    private static final String TAG = "GDPAndroid";
    private static boolean mockGDPAndroid = false;
    private String mGpuVendor = "unkown";
    private String mGpuRenderer = "unkown";

    public static class BackGround implements Runnable {
        public static boolean bg = false;
        public final CountDownLatch runDone = new CountDownLatch(1);

        public boolean checkBackgroundSafe() {
            new Thread(this).start();
            if (!ThreadUtils.awaitUninterruptibly(this.runDone, 20L)) {
                Logging.e(GDPAndroid.TAG, "checkBackgroundSafe timeout");
            }
            return bg;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            int i = runningAppProcessInfo.importance;
            bg = (i == 100 || i == 200) ? false : true;
            this.runDone.countDown();
        }
    }

    public static class BatteryLevel implements Runnable {
        public static int batt;
        public final CountDownLatch runDone = new CountDownLatch(1);

        public int getBatteryLevelSafe() {
            new Thread(this).start();
            if (!ThreadUtils.awaitUninterruptibly(this.runDone, 20L)) {
                Logging.e(GDPAndroid.TAG, "getBatteryLevelSafe timeout");
            }
            return batt;
        }

        @Override // java.lang.Runnable
        public void run() {
            batt = GDPAndroid.getBatteryLevel();
            this.runDone.countDown();
        }
    }

    public static class CPUMaxFreqKHz implements Runnable {
        public static int freq = -1;
        public final CountDownLatch runDone = new CountDownLatch(1);

        public int getCPUMaxFreqKHzSafe() {
            new Thread(this).start();
            if (!ThreadUtils.awaitUninterruptibly(this.runDone, 20L)) {
                Logging.e(GDPAndroid.TAG, "getCPUMaxFreqKHzSafe timeout");
            }
            return freq;
        }

        @Override // java.lang.Runnable
        public void run() {
            freq = GDPAndroid.getCPUMaxFreqKHz();
            this.runDone.countDown();
        }
    }

    public static class CPUTemperature implements Runnable {
        public static double currentTemp;
        public final CountDownLatch runDone = new CountDownLatch(1);

        public int getCpuTemperatureSafe() {
            new Thread(this).start();
            if (!ThreadUtils.awaitUninterruptibly(this.runDone, 20L)) {
                Logging.e(GDPAndroid.TAG, "getCpuTemperatureSafe timeout");
            }
            return (int) (currentTemp * 1000.0d);
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            StringBuilder sb;
            for (int i = 0; i < GDPAndroid.CPU_TEMP_FILE_PATHS.size(); i++) {
                String str = (String) GDPAndroid.CPU_TEMP_FILE_PATHS.get(i);
                double oneLine = GDPAndroid.readOneLine(new File(str));
                if (GDPAndroid.isTemperatureValid(oneLine) || GDPAndroid.mockGDPAndroid) {
                    currentTemp = oneLine;
                    sb = new StringBuilder();
                    sb.append("getCpuTemperature valid path:");
                    sb.append(str);
                    Logging.d(GDPAndroid.TAG, sb.toString());
                    break;
                }
                double d = oneLine / 1000.0d;
                if (GDPAndroid.isTemperatureValid(d)) {
                    currentTemp = d;
                    sb = new StringBuilder();
                    sb.append("getCpuTemperature valid path:");
                    sb.append(str);
                    Logging.d(GDPAndroid.TAG, sb.toString());
                    break;
                }
            }
            this.runDone.countDown();
        }
    }

    public static class NumberOfCpuCores implements Runnable {
        public static int cores = -1;
        public final CountDownLatch runDone = new CountDownLatch(1);

        public int getNumberOfCpuCoresSafe() {
            new Thread(this).start();
            if (!ThreadUtils.awaitUninterruptibly(this.runDone, 20L)) {
                Logging.e(GDPAndroid.TAG, "getNumberOfCpuCoresSafe timeout");
            }
            return cores;
        }

        @Override // java.lang.Runnable
        public void run() {
            cores = GDPAndroid.getNumberOfCPUCores();
            this.runDone.countDown();
        }
    }

    public static class TotalMemory implements Runnable {
        public static int mem;
        public final CountDownLatch runDone = new CountDownLatch(1);

        public int getTotalMemorySafe() {
            new Thread(this).start();
            if (!ThreadUtils.awaitUninterruptibly(this.runDone, 20L)) {
                Logging.e(GDPAndroid.TAG, "getTotalMemorySafe timeout");
            }
            return mem;
        }

        @Override // java.lang.Runnable
        public void run() {
            mem = (int) (GDPAndroid.getTotalMemory(ContextUtils.getApplicationContext()) / 1024);
            this.runDone.countDown();
        }
    }

    @CalledByNative
    public GDPAndroid() {
        if (!isEGL14SupportedHere() || CommonUtility.isSimulator()) {
            return;
        }
        gatherGlInfo();
    }

    private static int extractValue(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            if (Character.isDigit(bArr[i])) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    private void gatherGlInfo() {
        try {
            HandlerThread handlerThread = new HandlerThread("Get_GL_info_thread");
            handlerThread.start();
            ThreadUtils.invokeAtFrontUninterruptibly(new Handler(handlerThread.getLooper()), new Runnable() { // from class: io.agora.rtc2.internal.gdp.GDPAndroid.1
                @Override // java.lang.Runnable
                public void run() {
                    EglCore eglCore = new EglCore(null, 2);
                    OffscreenSurface offscreenSurface = new OffscreenSurface(eglCore, 1, 1);
                    offscreenSurface.makeCurrent();
                    GDPAndroid.this.mGpuVendor = GLES20.glGetString(7936);
                    GDPAndroid.this.mGpuRenderer = GLES20.glGetString(7937);
                    offscreenSurface.release();
                    eglCore.release();
                }
            });
            handlerThread.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getBatteryLevel() {
        if (ContextUtils.getApplicationContext() == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < 21 || mockGDPAndroid) {
            Intent intentRegisterReceiver = new ContextWrapper(ContextUtils.getApplicationContext()).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                return (intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) * 100) / intentRegisterReceiver.getIntExtra("scale", -1);
            }
            return 0;
        }
        BatteryManager batteryManager = (BatteryManager) ContextUtils.getApplicationContext().getSystemService("batterymanager");
        if (batteryManager != null) {
            return batteryManager.getIntProperty(4);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getCPUMaxFreqKHz() {
        int unknowCPUMax = -1;
        int maxFreq = -1;
        for (int i = 0; i < getNumberOfCPUCores(); i++) {
            try {
                maxFreq = getMaxFreq(i, maxFreq);
            } catch (IOException unused) {
            }
        }
        unknowCPUMax = (maxFreq == -1 || mockGDPAndroid) ? getUnknowCPUMax(maxFreq) : maxFreq;
        Logging.d(TAG, "max freq:" + unknowCPUMax);
        return unknowCPUMax;
    }

    private static int getCoresFromCPUFileList() {
        return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
    }

    private static int getCoresFromFileInfo(String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        BufferedReader bufferedReader;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            } catch (IOException unused) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            int coresFromFileString = getCoresFromFileString(bufferedReader.readLine());
            try {
                fileInputStream.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return coresFromFileString;
        } catch (IOException unused3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return -1;
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return -1;
        } catch (Throwable th4) {
            th = th4;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    throw th;
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    private static int getCoresFromFileString(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    private static int getMaxFreq(int i, int i2) throws IOException {
        File file = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq");
        if (file.exists() && file.canRead()) {
            byte[] bArr = new byte[128];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    int i3 = fileInputStream.read(bArr);
                    int i4 = 0;
                    while (Character.isDigit(bArr[i4]) && i4 < i3) {
                        i4++;
                    }
                    int i5 = Integer.parseInt(new String(bArr, 0, i4));
                    if (i5 > i2) {
                        i2 = i5;
                    }
                    fileInputStream.close();
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException | NumberFormatException | SecurityException unused) {
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getNumberOfCPUCores() {
        AtomicInteger atomicInteger = new AtomicInteger();
        try {
            atomicInteger.set(getCoresFromFileInfo("/sys/devices/system/cpu/possible"));
            if (atomicInteger.get() == -1 || mockGDPAndroid) {
                atomicInteger.set(getCoresFromFileInfo("/sys/devices/system/cpu/present"));
            }
            if (atomicInteger.get() == -1 || mockGDPAndroid) {
                atomicInteger.set(getCoresFromCPUFileList());
            }
        } catch (NullPointerException | SecurityException unused) {
            atomicInteger.set(-1);
        }
        Logging.d(TAG, "cores:" + atomicInteger);
        return atomicInteger.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getTotalMemory(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 16) {
            return 0L;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
        }
        Logging.d(TAG, "total mem:" + memoryInfo.totalMem);
        return memoryInfo.totalMem;
    }

    public static int getUnknowCPUMax(int i) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/cpuinfo");
            int fileForValue = parseFileForValue("cpu MHz", fileInputStream);
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int i2 = fileForValue * 1000;
            if (i2 > i) {
                return i2;
            }
            return -1;
        } catch (IOException | SecurityException unused) {
            return -1;
        }
    }

    private boolean isEGL14SupportedHere() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTemperatureValid(double d) {
        return d >= -30.0d && d <= 250.0d;
    }

    private static int match(int i, String str, int i2, byte[] bArr) {
        for (int i3 = i; i3 < i2; i3++) {
            int i4 = i3 - i;
            if (bArr[i3] != str.charAt(i4)) {
                return -1;
            }
            if (i4 == str.length() - 1) {
                return extractValue(bArr, i3);
            }
        }
        return -1;
    }

    private static int parseFileForValue(String str, FileInputStream fileInputStream) throws IOException {
        byte[] bArr = new byte[1024];
        try {
            int i = fileInputStream.read(bArr);
            int i2 = 0;
            while (i2 < i) {
                if (bArr[i2] == 10 || i2 == 0) {
                    if (bArr[i2] == 10) {
                        i2++;
                    }
                    int iMatch = match(i2, str, i, bArr);
                    if (iMatch > 0) {
                        return iMatch;
                    }
                }
                i2++;
            }
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0083 A[Catch: IOException -> 0x0036, TRY_ENTER, TryCatch #5 {IOException -> 0x0036, blocks: (B:12:0x002b, B:51:0x0083, B:53:0x0088, B:55:0x008d, B:62:0x009b, B:64:0x00a0, B:66:0x00a5, B:40:0x006b, B:42:0x0070, B:44:0x0075), top: B:82:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0088 A[Catch: IOException -> 0x0036, TryCatch #5 {IOException -> 0x0036, blocks: (B:12:0x002b, B:51:0x0083, B:53:0x0088, B:55:0x008d, B:62:0x009b, B:64:0x00a0, B:66:0x00a5, B:40:0x006b, B:42:0x0070, B:44:0x0075), top: B:82:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008d A[Catch: IOException -> 0x0036, TRY_LEAVE, TryCatch #5 {IOException -> 0x0036, blocks: (B:12:0x002b, B:51:0x0083, B:53:0x0088, B:55:0x008d, B:62:0x009b, B:64:0x00a0, B:66:0x00a5, B:40:0x006b, B:42:0x0070, B:44:0x0075), top: B:82:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x009b A[Catch: IOException -> 0x0036, TRY_ENTER, TryCatch #5 {IOException -> 0x0036, blocks: (B:12:0x002b, B:51:0x0083, B:53:0x0088, B:55:0x008d, B:62:0x009b, B:64:0x00a0, B:66:0x00a5, B:40:0x006b, B:42:0x0070, B:44:0x0075), top: B:82:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a0 A[Catch: IOException -> 0x0036, TryCatch #5 {IOException -> 0x0036, blocks: (B:12:0x002b, B:51:0x0083, B:53:0x0088, B:55:0x008d, B:62:0x009b, B:64:0x00a0, B:66:0x00a5, B:40:0x006b, B:42:0x0070, B:44:0x0075), top: B:82:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a5 A[Catch: IOException -> 0x0036, TRY_LEAVE, TryCatch #5 {IOException -> 0x0036, blocks: (B:12:0x002b, B:51:0x0083, B:53:0x0088, B:55:0x008d, B:62:0x009b, B:64:0x00a0, B:66:0x00a5, B:40:0x006b, B:42:0x0070, B:44:0x0075), top: B:82:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00b4 A[Catch: IOException -> 0x00b0, TryCatch #10 {IOException -> 0x00b0, blocks: (B:70:0x00ac, B:74:0x00b4, B:76:0x00b9), top: B:86:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00b9 A[Catch: IOException -> 0x00b0, TRY_LEAVE, TryCatch #10 {IOException -> 0x00b0, blocks: (B:70:0x00ac, B:74:0x00b4, B:76:0x00b9), top: B:86:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.IOException] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static double readOneLine(java.io.File r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.gdp.GDPAndroid.readOneLine(java.io.File):double");
    }

    public static void setMockGDPAndroid(boolean z) {
        mockGDPAndroid = z;
    }

    @CalledByNative
    public boolean checkBackground() {
        return new BackGround().checkBackgroundSafe();
    }

    @CalledByNative
    public int getBattery() {
        return new BatteryLevel().getBatteryLevelSafe();
    }

    @CalledByNative
    public int getCpuClock() {
        return new CPUMaxFreqKHz().getCPUMaxFreqKHzSafe();
    }

    @CalledByNative
    public int getCpuCores() {
        return new NumberOfCpuCores().getNumberOfCpuCoresSafe();
    }

    public int getCpuTemperature() {
        return new CPUTemperature().getCpuTemperatureSafe();
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0072: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:35:0x0072 */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @io.agora.base.internal.CalledByNative
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getCpuVendor() throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "failed to close proc file"
            java.lang.String r1 = "GDPAndroid"
            java.lang.String r2 = ""
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d java.io.FileNotFoundException -> L4c
            java.lang.String r5 = "/proc/cpuinfo"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d java.io.FileNotFoundException -> L4c
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.io.IOException -> L37 java.io.FileNotFoundException -> L39 java.lang.Throwable -> L71
            r3.<init>(r4)     // Catch: java.io.IOException -> L37 java.io.FileNotFoundException -> L39 java.lang.Throwable -> L71
        L13:
            java.lang.String r5 = r3.readLine()     // Catch: java.io.IOException -> L37 java.io.FileNotFoundException -> L39 java.lang.Throwable -> L71
            if (r5 == 0) goto L2b
            java.lang.String r6 = "Hardware"
            boolean r6 = r5.contains(r6)     // Catch: java.io.IOException -> L37 java.io.FileNotFoundException -> L39 java.lang.Throwable -> L71
            if (r6 == 0) goto L13
            java.lang.String r3 = ":\\s+"
            r6 = 2
            java.lang.String[] r3 = r5.split(r3, r6)     // Catch: java.io.IOException -> L37 java.io.FileNotFoundException -> L39 java.lang.Throwable -> L71
            r5 = 1
            r2 = r3[r5]     // Catch: java.io.IOException -> L37 java.io.FileNotFoundException -> L39 java.lang.Throwable -> L71
        L2b:
            r4.close()     // Catch: java.io.IOException -> L37 java.io.FileNotFoundException -> L39 java.lang.Throwable -> L71
            r4.close()     // Catch: java.io.IOException -> L32
            goto L5a
        L32:
            r3 = move-exception
            io.agora.base.internal.Logging.e(r1, r0, r3)
            goto L5a
        L37:
            r3 = move-exception
            goto L41
        L39:
            r3 = move-exception
            goto L50
        L3b:
            r2 = move-exception
            goto L73
        L3d:
            r4 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
        L41:
            java.lang.String r5 = "getCpuName failed,"
            io.agora.base.internal.Logging.e(r1, r5, r3)     // Catch: java.lang.Throwable -> L71
            if (r4 == 0) goto L5a
            r4.close()     // Catch: java.io.IOException -> L32
            goto L5a
        L4c:
            r4 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
        L50:
            java.lang.String r5 = "getCpuName failed, no /proc/cpuinfo found in system"
            io.agora.base.internal.Logging.e(r1, r5, r3)     // Catch: java.lang.Throwable -> L71
            if (r4 == 0) goto L5a
            r4.close()     // Catch: java.io.IOException -> L32
        L5a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r1 = ", "
            r0.append(r1)
            java.lang.String r1 = android.os.Build.HARDWARE
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L71:
            r2 = move-exception
            r3 = r4
        L73:
            if (r3 == 0) goto L7d
            r3.close()     // Catch: java.io.IOException -> L79
            goto L7d
        L79:
            r3 = move-exception
            io.agora.base.internal.Logging.e(r1, r0, r3)
        L7d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.gdp.GDPAndroid.getCpuVendor():java.lang.String");
    }

    @CalledByNative
    public String getGpuRenderer() {
        return this.mGpuRenderer;
    }

    @CalledByNative
    public String getGpuVendor() {
        return this.mGpuVendor;
    }

    @CalledByNative
    public int getOsVersion() {
        return Build.VERSION.SDK_INT;
    }

    @CalledByNative
    public int getRam() {
        return new TotalMemory().getTotalMemorySafe();
    }
}
