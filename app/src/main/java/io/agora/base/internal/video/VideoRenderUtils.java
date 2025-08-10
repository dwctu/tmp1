package io.agora.base.internal.video;

import android.content.Context;
import android.graphics.ColorSpace;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.ContextUtils;
import io.agora.base.internal.Logging;

/* loaded from: classes4.dex */
public class VideoRenderUtils {
    private static final String TAG = "VideoRenderUtils";

    public static class ColorSpaceNamed {
        public static final int BT2020 = 5;
        public static final int BT709 = 4;
        public static final int DCI_P3 = 6;
        public static final int DISPLAY_P3 = 7;
        public static final int SRGB = 0;
    }

    public static class HDRType {
        public static final int HDR_TYPE_DOLBY_VISION = 1;
        public static final int HDR_TYPE_HDR10 = 2;
        public static final int HDR_TYPE_HDR10_PLUS = 4;
        public static final int HDR_TYPE_HLG = 3;
    }

    public static float getDesiredMaxAverageLuminance() {
        WindowManager windowManager;
        Display defaultDisplay;
        Display.HdrCapabilities hdrCapabilities;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (Build.VERSION.SDK_INT < 24 || applicationContext == null || (windowManager = (WindowManager) applicationContext.getSystemService("window")) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null || (hdrCapabilities = defaultDisplay.getHdrCapabilities()) == null) {
            return -1.0f;
        }
        float desiredMaxAverageLuminance = hdrCapabilities.getDesiredMaxAverageLuminance();
        Logging.d(TAG, "hdrcap:average luma:" + desiredMaxAverageLuminance);
        return desiredMaxAverageLuminance;
    }

    public static float getDesiredMaxLuminance() {
        WindowManager windowManager;
        Display defaultDisplay;
        Display.HdrCapabilities hdrCapabilities;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (Build.VERSION.SDK_INT < 24 || applicationContext == null || (windowManager = (WindowManager) applicationContext.getSystemService("window")) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null || (hdrCapabilities = defaultDisplay.getHdrCapabilities()) == null) {
            return -1.0f;
        }
        float desiredMaxLuminance = hdrCapabilities.getDesiredMaxLuminance();
        Logging.d(TAG, "hdrcap:max luma:" + desiredMaxLuminance);
        return desiredMaxLuminance;
    }

    public static float getDesiredMinLuminance() {
        WindowManager windowManager;
        Display defaultDisplay;
        Display.HdrCapabilities hdrCapabilities;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (Build.VERSION.SDK_INT < 24 || applicationContext == null || (windowManager = (WindowManager) applicationContext.getSystemService("window")) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null || (hdrCapabilities = defaultDisplay.getHdrCapabilities()) == null) {
            return -1.0f;
        }
        float desiredMinLuminance = hdrCapabilities.getDesiredMinLuminance();
        Logging.d(TAG, "hdrcap:min luma:" + desiredMinLuminance);
        return desiredMinLuminance;
    }

    @CalledByNative
    public static int getPreferredWideGamutColorSpaceId() {
        WindowManager windowManager;
        Display defaultDisplay;
        ColorSpace preferredWideGamutColorSpace;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (Build.VERSION.SDK_INT < 29 || applicationContext == null || (windowManager = (WindowManager) applicationContext.getSystemService("window")) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null || (preferredWideGamutColorSpace = defaultDisplay.getPreferredWideGamutColorSpace()) == null) {
            return -1;
        }
        int id = preferredWideGamutColorSpace.getId();
        Logging.d(TAG, "hdrcap:color space id:" + id);
        return id;
    }

    @CalledByNative
    public static boolean isSupportedHDRByType(int i) {
        WindowManager windowManager;
        Display defaultDisplay;
        Display.HdrCapabilities hdrCapabilities;
        WindowManager windowManager2;
        Display defaultDisplay2;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26 && (windowManager2 = (WindowManager) applicationContext.getSystemService("window")) != null && (defaultDisplay2 = windowManager2.getDefaultDisplay()) != null && !defaultDisplay2.isHdr()) {
            Logging.d(TAG, "hdrcap:ishdr:false");
            return false;
        }
        if (i2 >= 24 && (windowManager = (WindowManager) applicationContext.getSystemService("window")) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null && (hdrCapabilities = defaultDisplay.getHdrCapabilities()) != null) {
            for (int i3 = 0; i3 < hdrCapabilities.getSupportedHdrTypes().length; i3++) {
                Logging.d(TAG, "hdrcap:" + hdrCapabilities.getSupportedHdrTypes()[i3]);
                if (hdrCapabilities.getSupportedHdrTypes()[i3] == i) {
                    Logging.d(TAG, "hdrcap: got:" + hdrCapabilities.getSupportedHdrTypes()[i3]);
                    return true;
                }
            }
        }
        return false;
    }

    @CalledByNative
    public static boolean isWideColorGamut() {
        WindowManager windowManager;
        Display defaultDisplay;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (Build.VERSION.SDK_INT < 26 || applicationContext == null || (windowManager = (WindowManager) applicationContext.getSystemService("window")) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return false;
        }
        boolean zIsWideColorGamut = defaultDisplay.isWideColorGamut();
        Logging.d(TAG, "hdrcap:is wide:" + zIsWideColorGamut);
        return zIsWideColorGamut;
    }
}
