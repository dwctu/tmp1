package com.wear.bean;

import java.util.Map;

/* loaded from: classes3.dex */
public class StrengthItemBean {
    private int code;
    private Map<String, StrengthBean> data;
    private String message;
    private boolean result;

    public int getCode() {
        return this.code;
    }

    public Map<String, StrengthBean> getData() {
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

    public void setData(Map<String, StrengthBean> map) {
        this.data = map;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }
}
