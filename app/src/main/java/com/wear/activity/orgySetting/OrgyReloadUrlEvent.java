package com.wear.activity.orgySetting;

/* loaded from: classes3.dex */
public class OrgyReloadUrlEvent {
    private int showLoading;
    private String url;

    public OrgyReloadUrlEvent(int i, String str) {
        this.showLoading = i;
        this.url = str;
    }

    public int getShowLoading() {
        return this.showLoading;
    }

    public String getUrl() {
        return this.url;
    }

    public void setShowLoading(int i) {
        this.showLoading = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
