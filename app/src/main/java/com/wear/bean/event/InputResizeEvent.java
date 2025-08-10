package com.wear.bean.event;

/* loaded from: classes3.dex */
public class InputResizeEvent {
    private int flag;
    private int resizeHeight;

    public InputResizeEvent(int i, int i2) {
        this.flag = i;
        this.resizeHeight = i2;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getResizeHeight() {
        return this.resizeHeight;
    }
}
