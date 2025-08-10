package com.wear.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class SpotifySwapTokenBean implements Serializable {
    private String access_token;
    private int code;
    private int expires_in;
    private String refresh_token;
    private String scope;
    private String token_type;

    public String getAccess_token() {
        return this.access_token;
    }

    public int getCode() {
        return this.code;
    }

    public int getExpires_in() {
        return this.expires_in;
    }

    public String getRefresh_token() {
        return this.refresh_token;
    }

    public String getScope() {
        return this.scope;
    }

    public String getToken_type() {
        return this.token_type;
    }

    public void setAccess_token(String str) {
        this.access_token = str;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setExpires_in(int i) {
        this.expires_in = i;
    }

    public void setRefresh_token(String str) {
        this.refresh_token = str;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public void setToken_type(String str) {
        this.token_type = str;
    }
}
