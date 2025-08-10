package com.wear.bean.response;

import com.wear.bean.event.ReportSuccEvent;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ReportResponse implements Serializable {
    private String code;
    private ReportSuccEvent data;
    private String message;
    private boolean result;

    public ReportResponse() {
    }

    public String getCode() {
        return this.code;
    }

    public ReportSuccEvent getData() {
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

    public void setData(ReportSuccEvent reportSuccEvent) {
        this.data = reportSuccEvent;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }

    public ReportResponse(boolean z, String str, String str2, ReportSuccEvent reportSuccEvent) {
        this.result = z;
        this.message = str;
        this.code = str2;
        this.data = reportSuccEvent;
    }
}
