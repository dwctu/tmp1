package dc;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: RuntimeCompat.java */
/* loaded from: classes.dex */
public final class xj {

    /* compiled from: RuntimeCompat.java */
    public class a implements FilenameFilter {
        public final /* synthetic */ Pattern a;

        public a(Pattern pattern) {
            this.a = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.a.matcher(str).matches();
        }
    }

    public static int a() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(b(), iAvailableProcessors) : iAvailableProcessors;
    }

    public static int b() {
        File[] fileArrListFiles;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new a(Pattern.compile("cpu[0-9]+")));
            } catch (Throwable unused) {
                Log.isLoggable("GlideRuntimeCompat", 6);
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                fileArrListFiles = null;
            }
            return Math.max(1, fileArrListFiles != null ? fileArrListFiles.length : 0);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }
}
