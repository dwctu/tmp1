package com.wear.bean.event;

/* loaded from: classes3.dex */
public class NinjaSpeedModeChangeEvent {
    private int changeStatus;
    private boolean playOrPause;
    private int sensitivity;

    public NinjaSpeedModeChangeEvent(int i, boolean z, int i2) {
        this.changeStatus = 0;
        this.changeStatus = i;
        this.playOrPause = z;
        this.sensitivity = i2;
    }

    public int getChangeStatus() {
        return this.changeStatus;
    }

    public int getSensitivity() {
        return this.sensitivity;
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
}
