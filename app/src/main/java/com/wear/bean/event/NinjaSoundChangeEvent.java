package com.wear.bean.event;

/* loaded from: classes3.dex */
public class NinjaSoundChangeEvent {
    private int changeStatus;
    private boolean playOrPause;
    private int sensitivity;
    public String title;

    public NinjaSoundChangeEvent(boolean z, int i) {
        this.changeStatus = 0;
        this.sensitivity = 0;
        this.changeStatus = 1;
        this.sensitivity = i;
        this.playOrPause = z;
    }

    public int getChangeStatus() {
        return this.changeStatus;
    }

    public int getSensitivity() {
        return this.sensitivity;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isPlayOrPause() {
        return this.playOrPause;
    }

    public void setChangeStatus(int i) {
        this.changeStatus = i;
    }

    public void setPlayOrPause(boolean z) {
        this.playOrPause = z;
    }

    public void setSensitivity(int i) {
        this.sensitivity = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public NinjaSoundChangeEvent(String str, boolean z, int i) {
        this.changeStatus = 0;
        this.sensitivity = 0;
        this.changeStatus = 0;
        this.playOrPause = z;
        this.title = str;
        this.sensitivity = i;
    }

    public NinjaSoundChangeEvent(int i, boolean z) {
        this.changeStatus = 0;
        this.sensitivity = 0;
        this.changeStatus = i;
        this.playOrPause = z;
    }

    public NinjaSoundChangeEvent(int i) {
        this.changeStatus = 0;
        this.sensitivity = 0;
        this.changeStatus = 5;
        this.sensitivity = i;
    }

    public NinjaSoundChangeEvent(int i, boolean z, String str) {
        this.changeStatus = 0;
        this.sensitivity = 0;
        this.changeStatus = i;
        this.playOrPause = z;
        this.title = str;
    }
}
