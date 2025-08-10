package dc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* compiled from: AutoLayoutConifg.java */
/* loaded from: classes4.dex */
public class wv3 {
    public static wv3 f = new wv3();
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;

    public static wv3 d() {
        return f;
    }

    public void a() {
        if (this.d <= 0 || this.c <= 0) {
            throw new RuntimeException("you must set design_width and design_height  in your manifest file.");
        }
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.c;
    }

    public final void e(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                this.c = ((Integer) bundle.get("design_width")).intValue();
                this.d = ((Integer) applicationInfo.metaData.get("design_height")).intValue();
            }
            aw3.a(" designWidth =" + this.c + " , designHeight = " + this.d);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("you must set design_width and design_height  in your manifest file.", e);
        }
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.a;
    }

    public void h(Context context) throws IllegalAccessException, PackageManager.NameNotFoundException, IllegalArgumentException, InvocationTargetException {
        e(context);
        int[] iArrA = bw3.a(context, this.e);
        this.a = iArrA[0];
        this.b = iArrA[1];
        aw3.a(" screenWidth =" + this.a + " ,screenHeight = " + this.b);
    }
}
