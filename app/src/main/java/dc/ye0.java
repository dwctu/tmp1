package dc;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;

/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class ye0 {
    public static boolean a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(i >= 24 ? ve0.a().getResources().getConfiguration().getLocales().get(0) : ve0.a().getResources().getConfiguration().locale) == 1;
        }
        return false;
    }

    public static View b(@LayoutRes int i) {
        return ((LayoutInflater) ve0.a().getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
    }
}
