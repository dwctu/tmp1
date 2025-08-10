package org.apache.cordova;

/* loaded from: classes5.dex */
public class LOG {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static int LOGLEVEL = 6;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    public static void d(String str, String str2) {
        int i = LOGLEVEL;
    }

    public static void e(String str, String str2) {
        int i = LOGLEVEL;
    }

    public static void i(String str, String str2) {
        int i = LOGLEVEL;
    }

    public static boolean isLoggable(int i) {
        return i >= LOGLEVEL;
    }

    public static void setLogLevel(int i) {
        LOGLEVEL = i;
        String str = "Changing log level to " + i;
    }

    public static void v(String str, String str2) {
        int i = LOGLEVEL;
    }

    public static void w(String str, String str2) {
        int i = LOGLEVEL;
    }

    public static void d(String str, String str2, Throwable th) {
        int i = LOGLEVEL;
    }

    public static void e(String str, String str2, Throwable th) {
        int i = LOGLEVEL;
    }

    public static void i(String str, String str2, Throwable th) {
        int i = LOGLEVEL;
    }

    public static void v(String str, String str2, Throwable th) {
        int i = LOGLEVEL;
    }

    public static void w(String str, Throwable th) {
        int i = LOGLEVEL;
    }

    public static void d(String str, String str2, Object... objArr) {
        if (3 >= LOGLEVEL) {
            String.format(str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (6 >= LOGLEVEL) {
            String.format(str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (4 >= LOGLEVEL) {
            String.format(str2, objArr);
        }
    }

    public static void setLogLevel(String str) {
        if ("VERBOSE".equals(str)) {
            LOGLEVEL = 2;
        } else if ("DEBUG".equals(str)) {
            LOGLEVEL = 3;
        } else if ("INFO".equals(str)) {
            LOGLEVEL = 4;
        } else if ("WARN".equals(str)) {
            LOGLEVEL = 5;
        } else if ("ERROR".equals(str)) {
            LOGLEVEL = 6;
        }
        String str2 = "Changing log level to " + str + "(" + LOGLEVEL + ")";
    }

    public static void v(String str, String str2, Object... objArr) {
        if (2 >= LOGLEVEL) {
            String.format(str2, objArr);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        int i = LOGLEVEL;
    }

    public static void w(String str, String str2, Object... objArr) {
        if (5 >= LOGLEVEL) {
            String.format(str2, objArr);
        }
    }
}
