package org.vosk;

/* loaded from: classes5.dex */
public enum LogLevel {
    WARNINGS(-1),
    INFO(0),
    DEBUG(1);

    private final int value;

    LogLevel(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
