package com.wear.bean.socketio.videoPattern;

/* loaded from: classes3.dex */
public class StartPreviewModeDTOResponse {
    private boolean isDownload;
    private String pattern;
    private String patternId;
    private boolean status;
    private String videoId;

    public String getPattern() {
        return this.pattern;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public boolean isDownload() {
        return this.isDownload;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setDownload(boolean z) {
        this.isDownload = z;
    }

    public void setPattern(String str) {
        this.pattern = str;
    }

    public void setPatternId(String str) {
        this.patternId = str;
    }

    public void setStatus(boolean z) {
        this.status = z;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }
}
