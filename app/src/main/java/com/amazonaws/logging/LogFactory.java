package com.amazonaws.logging;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class LogFactory {
    public static final String a = "LogFactory";
    public static final Map<String, Log> b = new HashMap();
    public static Level c = null;

    public enum Level {
        ALL(Integer.MIN_VALUE),
        TRACE(0),
        DEBUG(1),
        INFO(2),
        WARN(3),
        ERROR(4),
        OFF(Integer.MAX_VALUE);

        private final int value;

        Level(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static Level a() {
        return c;
    }

    public static synchronized Log b(Class<?> cls) {
        return c(d(cls.getSimpleName()));
    }

    public static synchronized Log c(String str) {
        String strD = d(str);
        Map<String, Log> map = b;
        Log log = map.get(strD);
        if (log != null) {
            return log;
        }
        Log consoleLog = Environment.a() ? new ConsoleLog(strD) : new AndroidLog(strD);
        map.put(strD, consoleLog);
        return consoleLog;
    }

    public static String d(String str) {
        if (str.length() <= 23) {
            return str;
        }
        c(a).g("Truncating log tag length as it exceed 23, the limit imposed by Android on certain API Levels");
        return str.substring(0, 23);
    }
}
