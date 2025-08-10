package com.wear.util;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class NormalResponse implements Serializable {
    private static final long serialVersionUID = 80222119562864885L;
    private String code;
    private Object data;
    private String message;
    private boolean result;

    public NormalResponse() {
    }

    public String getCode() {
        return this.code;
    }

    public Object getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }

    public NormalResponse(boolean z, String str, String str2, Object obj) {
        this.result = z;
        this.message = str;
        this.code = str2;
        this.data = obj;
    }
}
