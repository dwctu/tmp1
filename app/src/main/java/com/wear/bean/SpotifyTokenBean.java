package com.wear.bean;

import dc.be3;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class SpotifyTokenBean implements Serializable {
    private String access_token;
    private int expires_in;
    private long overdueTime;
    private String refresh_token;

    public SpotifyTokenBean(String str, String str2, int i) {
        this.access_token = str;
        this.refresh_token = str2;
        this.expires_in = i;
        this.overdueTime = be3.I().getTime() + (i * 1000);
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public int getExpires_in() {
        return this.expires_in;
    }

    public long getOverdueTime() {
        return this.overdueTime;
    }

    public String getRefresh_token() {
        return this.refresh_token;
    }

    public void refreshAccessToken(String str, int i) {
        this.access_token = str;
        this.expires_in = i;
        this.overdueTime = be3.I().getTime() + (i * 1000);
    }

    public void setAccess_token(String str) {
        this.access_token = str;
    }

    public void setExpires_in(int i) {
        this.expires_in = i;
    }

    public void setOverdueTime(long j) {
        this.overdueTime = j;
    }

    public void setRefresh_token(String str) {
        this.refresh_token = str;
    }
}
