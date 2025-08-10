package com.wear.bean.event;

/* loaded from: classes3.dex */
public class NinjaMusicChangeEvent {
    private int changeStatus;
    private String imagePath;
    private int musicDuration;
    private boolean musicLoading;
    private int musicType;
    private int nowMode;
    private String patternAuthor;
    private String patternName;
    private boolean playOrPause;

    public NinjaMusicChangeEvent(String str, String str2, int i, String str3, boolean z, int i2, int i3) {
        this.changeStatus = 0;
        this.changeStatus = 0;
        this.patternName = str;
        this.patternAuthor = str2;
        this.nowMode = i;
        this.playOrPause = z;
        this.imagePath = str3;
        this.musicType = i3;
        this.musicDuration = i2;
    }

    public int getChangeStatus() {
        return this.changeStatus;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public int getMusicDuration() {
        return this.musicDuration;
    }

    public int getMusicType() {
        return this.musicType;
    }

    public int getNowMode() {
        return this.nowMode;
    }

    public String getPatternAuthor() {
        return this.patternAuthor;
    }

    public String getPatternName() {
        return this.patternName;
    }

    public boolean isMusicLoading() {
        return this.musicLoading;
    }

    public boolean isPlayOrPause() {
        return this.playOrPause;
    }

    public void setChangeStatus(int i) {
        this.changeStatus = i;
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public void setMusicDuration(int i) {
        this.musicDuration = i;
    }

    public void setMusicLoading(boolean z) {
        this.musicLoading = z;
    }

    public void setMusicType(int i) {
        this.musicType = i;
    }

    public void setNowMode(int i) {
        this.nowMode = i;
    }

    public void setPatternAuthor(String str) {
        this.patternAuthor = str;
    }

    public void setPatternName(String str) {
        this.patternName = str;
    }

    public void setPlayOrPause(boolean z) {
        this.playOrPause = z;
    }

    public NinjaMusicChangeEvent(boolean z) {
        this.changeStatus = 0;
        this.changeStatus = 1;
        this.playOrPause = z;
    }

    public NinjaMusicChangeEvent(boolean z, int i) {
        this.changeStatus = 0;
        this.changeStatus = i;
    }

    public NinjaMusicChangeEvent(int i) {
        this.changeStatus = 0;
        this.changeStatus = 2;
        this.nowMode = i;
    }
}
