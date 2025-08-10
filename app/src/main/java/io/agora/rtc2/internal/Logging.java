package io.agora.rtc2.internal;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes4.dex */
public class Logging {
    private static final int AGORA_LOG_DEBUG = 2048;
    private static final int AGORA_LOG_ERROR = 4;
    private static final int AGORA_LOG_INFO = 1;
    private static final int AGORA_LOG_WARN = 2;

    public static void d(String str) {
        RtcEngineImpl.nativeLog(2048, str);
    }

    public static void d(String str, String str2) {
        log(2048, str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        log(2048, str, str2);
        log(2048, str, th.toString());
        log(2048, str, getStackTraceString(th));
    }

    public static void e(String str) {
        RtcEngineImpl.nativeLog(4, str);
    }

    public static void e(String str, String str2) {
        log(4, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        log(4, str, str2);
        log(4, str, th.toString());
        log(4, str, getStackTraceString(th));
    }

    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        try {
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        } catch (Throwable unused) {
            String message = th.getMessage();
            return message == null ? "" : message;
        }
    }

    public static void i(String str) {
        RtcEngineImpl.nativeLog(1, str);
    }

    public static void i(String str, String str2) {
        log(1, str, str2);
    }

    public static void log(int i, String str, String str2) {
        RtcEngineImpl.nativeLog(i, "[" + str + "] " + str2);
    }

    public static void w(String str) {
        RtcEngineImpl.nativeLog(2, str);
    }

    public static void w(String str, String str2) {
        log(2, str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        log(2, str, str2);
        log(2, str, th.toString());
        log(2, str, getStackTraceString(th));
    }
}
