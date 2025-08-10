package com.huawei.hms.framework.common;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;

/* loaded from: classes2.dex */
public class PowerUtils {
    private static final String TAG = "PowerUtils";

    public static final class PowerMode {
        public static int POWER_MODE_DEFAULT_RETURN_VALUE = 0;
        public static int POWER_SAVER_MODE = 4;
        public static String SMART_MODE_STATUS = "SmartModeStatus";
    }

    public static boolean isDozeIdleMode(Context context) {
        if (context == null) {
            Logger.i(TAG, "isDozeIdleMode Context is null!");
            return false;
        }
        Object systemService = ContextCompat.getSystemService(context, "power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager == null) {
            Logger.i(TAG, "isDozeIdleMode powerManager is null!");
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            Logger.i(TAG, "isDozeIdleMode is version control state!");
            return false;
        }
        try {
            return powerManager.isDeviceIdleMode();
        } catch (RuntimeException e) {
            Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
            return false;
        }
    }

    public static boolean isInteractive(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            if (systemService instanceof PowerManager) {
                PowerManager powerManager = (PowerManager) systemService;
                if (Build.VERSION.SDK_INT >= 20) {
                    try {
                        return powerManager.isInteractive();
                    } catch (RuntimeException e) {
                        Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e.getClass().getSimpleName() + e.getMessage());
                    }
                }
            }
        }
        return false;
    }

    public static boolean isWhilteList(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            String packageName = context.getPackageName();
            if (powerManager != null && Build.VERSION.SDK_INT >= 23) {
                try {
                    return powerManager.isIgnoringBatteryOptimizations(packageName);
                } catch (RuntimeException e) {
                    Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
                }
            }
        }
        return false;
    }

    public static int readPowerSaverMode(Context context) {
        if (context == null) {
            Logger.i(TAG, "readPowerSaverMode Context is null!");
            return 0;
        }
        int systemInt = SettingUtil.getSystemInt(context.getContentResolver(), PowerMode.SMART_MODE_STATUS, PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE);
        if (systemInt != PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE) {
            return systemInt;
        }
        Object systemService = ContextCompat.getSystemService(context, "power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager == null) {
            return systemInt;
        }
        if (Build.VERSION.SDK_INT < 21) {
            Logger.i(TAG, "readPowerSaverMode is control by version!");
            return systemInt;
        }
        try {
            return powerManager.isPowerSaveMode() ? PowerMode.POWER_SAVER_MODE : PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE;
        } catch (RuntimeException e) {
            Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
            return systemInt;
        }
    }
}
