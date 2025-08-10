package com.j256.ormlite.android;

import com.j256.ormlite.logger.Log;
import com.j256.ormlite.logger.LoggerFactory;

/* loaded from: classes3.dex */
public class AndroidLog implements Log {
    private static final String ALL_LOGS_NAME = "ORMLite";
    private static final int MAX_TAG_LENGTH = 23;
    private static final int REFRESH_LEVEL_CACHE_EVERY = 200;
    private String className;
    private final boolean[] levelCache;
    private volatile int levelCacheC = 0;

    /* renamed from: com.j256.ormlite.android.AndroidLog$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$logger$Log$Level;

        static {
            int[] iArr = new int[Log.Level.values().length];
            $SwitchMap$com$j256$ormlite$logger$Log$Level = iArr;
            try {
                iArr[Log.Level.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.WARNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.FATAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public AndroidLog(String str) {
        String simpleClassName = LoggerFactory.getSimpleClassName(str);
        this.className = simpleClassName;
        int length = simpleClassName.length();
        if (length > 23) {
            this.className = this.className.substring(length - 23, length);
        }
        int i = 0;
        for (Log.Level level : Log.Level.values()) {
            int iLevelToAndroidLevel = levelToAndroidLevel(level);
            if (iLevelToAndroidLevel > i) {
                i = iLevelToAndroidLevel;
            }
        }
        this.levelCache = new boolean[i + 1];
        refreshLevelCache();
    }

    private boolean isLevelEnabledInternal(int i) {
        return android.util.Log.isLoggable(this.className, i) || android.util.Log.isLoggable(ALL_LOGS_NAME, i);
    }

    private int levelToAndroidLevel(Log.Level level) {
        int i = AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i != 4) {
            return (i == 5 || i == 6) ? 6 : 4;
        }
        return 5;
    }

    private void refreshLevelCache() {
        for (Log.Level level : Log.Level.values()) {
            int iLevelToAndroidLevel = levelToAndroidLevel(level);
            boolean[] zArr = this.levelCache;
            if (iLevelToAndroidLevel < zArr.length) {
                zArr[iLevelToAndroidLevel] = isLevelEnabledInternal(iLevelToAndroidLevel);
            }
        }
    }

    @Override // com.j256.ormlite.logger.Log
    public boolean isLevelEnabled(Log.Level level) {
        int i = this.levelCacheC + 1;
        this.levelCacheC = i;
        if (i >= 200) {
            refreshLevelCache();
            this.levelCacheC = 0;
        }
        int iLevelToAndroidLevel = levelToAndroidLevel(level);
        boolean[] zArr = this.levelCache;
        return iLevelToAndroidLevel < zArr.length ? zArr[iLevelToAndroidLevel] : isLevelEnabledInternal(iLevelToAndroidLevel);
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String str) {
        int i = AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()];
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String str, Throwable th) {
        int i = AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()];
    }
}
