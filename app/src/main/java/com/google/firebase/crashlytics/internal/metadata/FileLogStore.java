package com.google.firebase.crashlytics.internal.metadata;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public interface FileLogStore {
    void closeLogFile();

    void deleteLogFile();

    @Nullable
    byte[] getLogAsBytes();

    @Nullable
    String getLogAsString();

    void writeToLog(long j, String str);
}
