package dc;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* compiled from: SkinFileUtils.java */
/* loaded from: classes5.dex */
public class ni4 {
    public static String a(Context context) {
        File externalCacheDir;
        return (Environment.getExternalStorageState().equals("mounted") && (externalCacheDir = context.getExternalCacheDir()) != null && (externalCacheDir.exists() || externalCacheDir.mkdirs())) ? externalCacheDir.getAbsolutePath() : context.getCacheDir().getAbsolutePath();
    }

    public static String b(Context context) {
        File file = new File(a(context), "skins");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }
}
