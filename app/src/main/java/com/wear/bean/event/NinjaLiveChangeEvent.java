package com.wear.bean.event;

import com.lovense.wear.R;
import dc.ah4;

/* loaded from: classes3.dex */
public class NinjaLiveChangeEvent {
    private int changeStatus;
    private boolean playOrPause;
    private int sensitivity;
    public String title;

    public NinjaLiveChangeEvent(boolean z, int i) {
        this.changeStatus = 0;
        this.sensitivity = 0;
        this.changeStatus = 1;
        this.sensitivity = i;
        this.playOrPause = z;
        this.title = ah4.e(R.string.ninja_control_running);
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

    public NinjaLiveChangeEvent(String str, boolean z, int i) {
        this.changeStatus = 0;
        this.sensitivity = 0;
        this.changeStatus = 0;
        this.playOrPause = z;
        this.title = str;
        this.sensitivity = i;
    }

    public NinjaLiveChangeEvent(int i) {
        this.changeStatus = 0;
        this.sensitivity = 0;
        this.changeStatus = 7;
        this.sensitivity = i;
        this.title = ah4.e(R.string.ninja_control_running);
    }
}
