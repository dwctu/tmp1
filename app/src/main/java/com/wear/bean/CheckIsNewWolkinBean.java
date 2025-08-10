package com.wear.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class CheckIsNewWolkinBean {
    private int code;
    private List<String> data;
    private String message;
    private boolean result;

    public Integer getCode() {
        return Integer.valueOf(this.code);
    }

    public List<String> getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public Boolean isResult() {
        return Boolean.valueOf(this.result);
    }

    public void setCode(Integer num) {
        this.code = num.intValue();
    }

    public void setData(List<String> list) {
        this.data = list;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(Boolean bool) {
        this.result = bool.booleanValue();
    }
}
