package com.wear.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class TimestampBean implements Serializable {
    private int code;
    private long data;
    private String message;
    private boolean result;

    public int getCode() {
        return this.code;
    }

    public long getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(long j) {
        this.data = j;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }
}
