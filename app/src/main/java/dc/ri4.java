package dc;

import android.os.Build;
import android.view.View;

/* compiled from: ViewCompat.java */
/* loaded from: classes5.dex */
public class ri4 {
    public static boolean a(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }
}
