package dc;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: Utils.java */
/* loaded from: classes4.dex */
public class o93 {
    public static int[] a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static String b(long j) {
        if (j < 1000) {
            return "00:01";
        }
        return new SimpleDateFormat("mm:ss").format(new Date(j));
    }
}
