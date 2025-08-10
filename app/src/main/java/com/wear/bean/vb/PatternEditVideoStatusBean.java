package com.wear.bean.vb;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class PatternEditVideoStatusBean extends PatternEditBaseBean {
    private int currentTime;
    private int duration;
    private int playbackRate;
    private int videoStatus;

    public int getCurrentTime() {
        return this.currentTime;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getPlaybackRate() {
        return this.playbackRate;
    }

    public int getVideoStatus() {
        return this.videoStatus;
    }

    public void setCurrentTime(int i) {
        this.currentTime = i;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setPlaybackRate(int i) {
        this.playbackRate = i;
    }

    public void setVideoStatus(int i) {
        this.videoStatus = i;
    }

    public String toString() {
        return "PatternEditVideoStatusBean{result=" + this.result + ", webPageId='" + this.webPageId + "', videoStatus=" + this.videoStatus + ", currentTime=" + this.currentTime + ", duration=" + this.duration + ", playbackRate=" + this.playbackRate + MessageFormatter.DELIM_STOP;
    }
}
