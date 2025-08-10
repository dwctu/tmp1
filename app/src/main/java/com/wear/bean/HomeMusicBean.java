package com.wear.bean;

/* loaded from: classes3.dex */
public class HomeMusicBean {
    private boolean isPlaying;
    private int type;

    public HomeMusicBean(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public HomeMusicBean(int i, boolean z) {
        this.type = i;
        this.isPlaying = z;
    }
}
