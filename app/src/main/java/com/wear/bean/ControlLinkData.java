package com.wear.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class ControlLinkData implements Serializable {
    private int code;
    private ControlLinkBean data;
    private String message;
    private boolean result;

    public int getCode() {
        return this.code;
    }

    public ControlLinkBean getData() {
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

    public void setData(ControlLinkBean controlLinkBean) {
        this.data = controlLinkBean;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }
}
