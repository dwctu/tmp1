package com.wear.bean.vb;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class PatternEditVideoInfo extends PatternEditBaseBean {
    public static final int VIDEO_SPEED_NORMAL = 100;
    private int currentTime;
    private int duration;
    private boolean isDetail;
    private boolean isPlaying;
    private boolean isTour;
    private int playbackRate = 100;
    private String url;
    private String videoName;
    private String videoParams;
    private String videoPoster;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PatternEditVideoInfo patternEditVideoInfo = (PatternEditVideoInfo) obj;
        return this.duration == patternEditVideoInfo.duration && this.result == patternEditVideoInfo.result && this.isDetail == patternEditVideoInfo.isDetail && this.isTour == patternEditVideoInfo.isTour && this.isPlaying == patternEditVideoInfo.isPlaying && this.currentTime == patternEditVideoInfo.currentTime && this.playbackRate == patternEditVideoInfo.playbackRate && TextUtils.equals(this.url, patternEditVideoInfo.url) && TextUtils.equals(this.videoName, patternEditVideoInfo.videoName) && TextUtils.equals(this.videoPoster, patternEditVideoInfo.videoPoster) && TextUtils.equals(this.videoParams, patternEditVideoInfo.videoParams);
    }

    public int getCurrentTime() {
        return this.currentTime;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getPlaybackRate() {
        return this.playbackRate;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVideoName() {
        return this.videoName;
    }

    public String getVideoParams() {
        return this.videoParams;
    }

    public String getVideoPoster() {
        return this.videoPoster;
    }

    public boolean isDetail() {
        return this.isDetail;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public Boolean isTour() {
        return Boolean.valueOf(this.isTour);
    }

    public void setCurrentTime(int i) {
        this.currentTime = i;
    }

    public void setDetail(boolean z) {
        this.isDetail = z;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setPlaybackRate(int i) {
        this.playbackRate = i;
    }

    public void setPlaying(boolean z) {
        this.isPlaying = z;
    }

    public void setTour(Boolean bool) {
        this.isTour = bool.booleanValue();
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVideoName(String str) {
        this.videoName = str;
    }

    public void setVideoParams(String str) {
        this.videoParams = str;
    }

    public void setVideoPoster(String str) {
        this.videoPoster = str;
    }
}
