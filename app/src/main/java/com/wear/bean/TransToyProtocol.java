package com.wear.bean;

/* loaded from: classes3.dex */
public class TransToyProtocol {
    public static final String LOCAL_SERVICE_SYNC_TOY_TYPE_KEY = "toySync";
    public String data;
    public String type = LOCAL_SERVICE_SYNC_TOY_TYPE_KEY;

    public TransToyProtocol(String str) {
        this.data = str;
    }

    public String getData() {
        return this.data;
    }

    public String getType() {
        return this.type;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
