package dc;

import android.content.Context;
import android.content.pm.FeatureInfo;

/* compiled from: CameraUtils.java */
/* loaded from: classes4.dex */
public class li3 {
    public static boolean a(Context context) {
        for (FeatureInfo featureInfo : context.getPackageManager().getSystemAvailableFeatures()) {
            if ("android.hardware.camera.flash".equals(featureInfo.name)) {
                return true;
            }
        }
        return false;
    }
}
