package dc;

import android.content.Context;
import android.text.TextUtils;
import com.wear.util.MyApplication;
import java.lang.reflect.InvocationTargetException;

/* compiled from: FeatureUtil.java */
/* loaded from: classes4.dex */
public class ke3 {
    public static boolean a(String str, String str2) {
        return b(str, str2, true);
    }

    public static boolean b(String str, String str2, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean zD;
        Context applicationContext = MyApplication.N().getApplicationContext();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.equals(str, "new_user")) {
            if (!pf3.d(applicationContext)) {
                eg3.i(applicationContext, str2, Boolean.FALSE);
            }
            zD = eg3.d(applicationContext, str2, true);
        } else {
            zD = false;
        }
        if (TextUtils.equals(str, "new_feature")) {
            if (pf3.d(applicationContext)) {
                eg3.i(applicationContext, str2, Boolean.FALSE);
            }
            zD = eg3.d(applicationContext, str2, true);
        }
        if (zD && z) {
            eg3.j(applicationContext, str2, false);
        }
        return zD;
    }

    public static void c(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        eg3.j(MyApplication.N().getApplicationContext(), str, false);
    }
}
