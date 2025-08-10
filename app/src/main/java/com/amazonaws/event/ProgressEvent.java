package com.amazonaws.event;

/* loaded from: classes.dex */
public class ProgressEvent {
    public long a;
    public int b;

    public ProgressEvent(long j) {
        this.a = j;
    }

    public long a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }
}
