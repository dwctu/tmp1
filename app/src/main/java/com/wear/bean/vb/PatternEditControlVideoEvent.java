package com.wear.bean.vb;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class PatternEditControlVideoEvent {
    private int currentTime;
    private int flag;
    private int optType;
    private String url;
    private String webPageId;

    public PatternEditControlVideoEvent(int i, String str) {
        this.flag = i;
        this.url = str;
    }

    public int getCurrentTime() {
        return this.currentTime;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getOptType() {
        return this.optType;
    }

    public String getUrl() {
        return this.url;
    }

    public String getWebPageId() {
        return this.webPageId;
    }

    public void setCurrentTime(int i) {
        this.currentTime = i;
    }

    public void setOptType(int i) {
        this.optType = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setWebPageId(String str) {
        this.webPageId = str;
    }

    public String toString() {
        return "PatternEditControlVideoEvent{flag=" + this.flag + ", url='" + this.url + "', currentTime=" + this.currentTime + ", optType=" + this.optType + ", webPageId='" + this.webPageId + '\'' + MessageFormatter.DELIM_STOP;
    }
}
