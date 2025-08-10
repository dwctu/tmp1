package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.AttributeSet;

/* compiled from: AndroidTool.java */
/* loaded from: classes4.dex */
public class od3 {
    public static int a(AttributeSet attributeSet, String str) throws Exception {
        return b(attributeSet, "http://schemas.android.com/apk/res-auto", str);
    }

    public static int b(AttributeSet attributeSet, String str, String str2) throws Exception {
        String attributeValue = attributeSet.getAttributeValue(str, str2);
        if (attributeValue != null && attributeValue.length() >= 2) {
            return Integer.parseInt(attributeValue.substring(1));
        }
        throw new NoSuchFieldException("xml Field NoFound:" + str2);
    }

    public static boolean c(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return Settings.canDrawOverlays(context);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void d(Activity activity) {
        activity.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activity.getPackageName())), 0);
    }
}
