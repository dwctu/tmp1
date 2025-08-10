package dc;

import android.content.res.Resources;
import android.os.Environment;
import android.util.TypedValue;
import java.io.File;

/* compiled from: SignUtils.java */
/* loaded from: classes3.dex */
public class bk2 {
    static {
        new File(Environment.getRootDirectory(), "build.prop");
    }

    public static int a(int i) {
        return (int) TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics());
    }

    public static int b(int i) {
        return (int) TypedValue.applyDimension(2, i, Resources.getSystem().getDisplayMetrics());
    }
}
