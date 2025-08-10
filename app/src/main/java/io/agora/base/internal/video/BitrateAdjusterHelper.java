package io.agora.base.internal.video;

import android.os.Build;
import io.agora.base.internal.Logging;
import io.agora.base.internal.video.VideoEncoder;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class BitrateAdjusterHelper {
    private static final String[] H264_HW_QCOM_EXCEPTION_MODELS = {"mi note lte", "redmi note 4x", "1605-a01", "aosp on hammerhead", "lm-x210", "oppo r9s"};
    private static final String[] MTK_NO_ADJUSTMENT_MODELS = {"vivo y83a", "vivo x21i", "vivo X21i A"};
    private static final String TAG = "BitrateAdjusterHelper";

    public static VideoEncoder.EncoderStyle getEncoderStyle(String str) {
        VideoEncoder.EncoderStyle encoderStyle = new VideoEncoder.EncoderStyle();
        if (str.startsWith("OMX.qcom.")) {
            List listAsList = Arrays.asList(H264_HW_QCOM_EXCEPTION_MODELS);
            String str2 = Build.MODEL;
            if (listAsList.contains(str2.toLowerCase())) {
                Logging.w(TAG, "Qcom Exception Model: " + str2);
                encoderStyle.isNeedResetWhenDownBps = true;
            }
            encoderStyle.highProfileSupported = Build.VERSION.SDK_INT >= 21;
        } else if (str.startsWith(MediaCodecUtils.MTK_PREFIX)) {
            StringBuilder sb = new StringBuilder();
            sb.append("MTK hardware: ");
            String str3 = Build.HARDWARE;
            sb.append(str3);
            Logging.v(TAG, sb.toString());
            if (str3.equalsIgnoreCase("mt6763") || str3.equalsIgnoreCase("mt6763t")) {
                encoderStyle.highProfileSupported = Build.VERSION.SDK_INT >= 21;
            } else if (Arrays.asList(MTK_NO_ADJUSTMENT_MODELS).contains(Build.MODEL)) {
                encoderStyle.highProfileSupported = Build.VERSION.SDK_INT >= 21;
            } else if (str3.equalsIgnoreCase("mt6735")) {
                encoderStyle.bitrateAdjustment = 2;
                encoderStyle.highProfileSupported = false;
            } else {
                encoderStyle.bitrateAdjustment = 2;
                encoderStyle.highProfileSupported = Build.VERSION.SDK_INT >= 21;
            }
        } else if (str.startsWith("OMX.Exynos.")) {
            String str4 = Build.MODEL;
            if (str4.equalsIgnoreCase("MX4 Pro")) {
                encoderStyle.bitrateAdjustment = 2;
                encoderStyle.highProfileSupported = false;
            } else if (Build.MANUFACTURER.equalsIgnoreCase("vivo") && str4.equalsIgnoreCase("V1938CT")) {
                encoderStyle.bitrateAdjustment = 2;
                encoderStyle.highProfileSupported = Build.VERSION.SDK_INT >= 21;
            } else {
                int i = Build.VERSION.SDK_INT;
                if (i > 28) {
                    encoderStyle.bitrateAdjustment = 2;
                    encoderStyle.highProfileSupported = true;
                } else {
                    encoderStyle.bitrateAdjustment = 1;
                    encoderStyle.highProfileSupported = i >= 21;
                }
            }
        } else if (str.startsWith(MediaCodecUtils.HISI_IMGT_PREFIX)) {
            if (Build.HARDWARE.equalsIgnoreCase("hi6250")) {
                encoderStyle.bitrateAdjustment = 2;
            } else {
                encoderStyle.highProfileSupported = false;
                encoderStyle.bitrateAdjustment = 1;
            }
        } else if (str.startsWith(MediaCodecUtils.HISI_PREFIX)) {
            encoderStyle.highProfileSupported = false;
            encoderStyle.bitrateAdjustment = 2;
        } else if (str.startsWith(MediaCodecUtils.HISI_K3_PREFIX)) {
            encoderStyle.bitrateAdjustment = 1;
            encoderStyle.highProfileSupported = Build.VERSION.SDK_INT >= 21;
        } else if (str.startsWith(MediaCodecUtils.AMLOGIC_PREFIX)) {
            Logging.v(TAG, "getChipProperties for amlogic");
            encoderStyle.bitrateAdjustment = 1;
            encoderStyle.highProfileSupported = false;
        } else if (str.startsWith(MediaCodecUtils.RK_PREFIX)) {
            encoderStyle.bitrateAdjustment = 1;
            encoderStyle.highProfileSupported = false;
        } else {
            Logging.v(TAG, "getChipProperties from unsupported chip list");
            encoderStyle.highProfileSupported = Build.VERSION.SDK_INT >= 23;
        }
        return encoderStyle;
    }
}
