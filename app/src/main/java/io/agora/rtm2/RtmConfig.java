package io.agora.rtm2;

import io.agora.base.internal.CalledByNative;
import io.agora.rtc2.Constants;

/* loaded from: classes4.dex */
public class RtmConfig {
    public String mAppId = "";
    public String mUserId = "";
    public IRtmEventHandler mEventHandler = null;
    public LogConfig mLogConfig = new LogConfig();

    public static class LogConfig {
        public String filePath;
        public int fileSizeInKB;
        public int level = Constants.LogLevel.getValue(Constants.LogLevel.LOG_LEVEL_INFO);

        @CalledByNative("LogConfig")
        public String getFilePath() {
            return this.filePath;
        }

        @CalledByNative("LogConfig")
        public int getFileSize() {
            return this.fileSizeInKB;
        }

        @CalledByNative("LogConfig")
        public int getLevel() {
            return this.level;
        }
    }

    @CalledByNative
    public String getAppId() {
        return this.mAppId;
    }

    @CalledByNative
    public IRtmEventHandler getEventHandler() {
        return this.mEventHandler;
    }

    @CalledByNative
    public LogConfig getLogConfig() {
        return this.mLogConfig;
    }

    @CalledByNative
    public String getUserId() {
        return this.mUserId;
    }
}
