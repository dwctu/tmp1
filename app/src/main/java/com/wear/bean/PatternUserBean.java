package com.wear.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class PatternUserBean implements Serializable {
    private int code;
    private List<String> data;
    private String message;
    private boolean result;

    public int getCode() {
        return this.code;
    }

    public List<String> getData() {
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

    public void setData(List<String> list) {
        this.data = list;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }
}
