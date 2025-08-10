package dc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ScreenUtils.java */
/* loaded from: classes4.dex */
public class bw3 {
    public static int[] a(Context context, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int[] iArr = new int[2];
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int iIntValue = displayMetrics.widthPixels;
        int iIntValue2 = displayMetrics.heightPixels;
        if (!z) {
            iArr[0] = iIntValue;
            iArr[1] = iIntValue2 - b(context);
            return iArr;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 14 && i < 17) {
            try {
                iIntValue = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                iIntValue2 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                Point point = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                iIntValue = point.x;
                iIntValue2 = point.y;
            } catch (Exception unused2) {
            }
        }
        iArr[0] = iIntValue;
        iArr[1] = iIntValue2;
        return iArr;
    }

    public static int b(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
