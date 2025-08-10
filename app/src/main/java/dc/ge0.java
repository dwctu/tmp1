package dc;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* compiled from: PathUtils.java */
/* loaded from: classes.dex */
public final class ge0 {
    static {
        char c = File.separatorChar;
    }

    public static String a(File file) {
        return file == null ? "" : file.getAbsolutePath();
    }

    public static String b() {
        String strC = c();
        return TextUtils.isEmpty(strC) ? g() : strC;
    }

    public static String c() {
        return !xe0.J() ? "" : a(ve0.a().getExternalCacheDir());
    }

    public static String d() {
        return !xe0.J() ? "" : a(ve0.a().getExternalFilesDir(null));
    }

    public static String e() {
        return !xe0.J() ? "" : a(Environment.getExternalStorageDirectory());
    }

    public static String f() {
        String strD = d();
        return TextUtils.isEmpty(strD) ? j() : strD;
    }

    public static String g() {
        return a(ve0.a().getCacheDir());
    }

    public static String h() {
        return Build.VERSION.SDK_INT < 24 ? ve0.a().getApplicationInfo().dataDir : a(ve0.a().getDataDir());
    }

    public static String i() {
        return ve0.a().getApplicationInfo().dataDir + "/databases";
    }

    public static String j() {
        return a(ve0.a().getFilesDir());
    }

    public static String k() {
        return a(Environment.getRootDirectory());
    }

    public static String l() {
        String strE = e();
        return TextUtils.isEmpty(strE) ? k() : strE;
    }
}
