package net.sqlcipher.database;

import android.util.Log;

/* loaded from: classes5.dex */
public final class SQLiteDebug {
    public static final boolean a = Log.isLoggable("SQLiteStatements", 2);
    public static final boolean b = Log.isLoggable("SQLiteTime", 2);
    public static final boolean c = Log.isLoggable("SQLiteCompiledSql", 2);
    public static final boolean d = Log.isLoggable("SQLiteCursorClosing", 2);
    public static final boolean e = Log.isLoggable("SQLiteLockTime", 2);
    public static final boolean f = Log.isLoggable("SQLiteLockStackTrace", 2);
    public static int g = 0;

    public static class PagerStats {
    }

    public static synchronized void a() {
        g++;
    }

    public static native long getHeapAllocatedSize();

    public static native void getHeapDirtyPages(int[] iArr);

    public static native long getHeapFreeSize();

    public static native long getHeapSize();

    public static native void getPagerStats(PagerStats pagerStats);
}
