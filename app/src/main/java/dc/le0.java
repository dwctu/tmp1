package dc;

import android.os.Environment;

/* compiled from: SDCardUtils.java */
/* loaded from: classes.dex */
public final class le0 {
    public static boolean a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
