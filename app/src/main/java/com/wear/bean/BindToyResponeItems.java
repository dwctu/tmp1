package com.wear.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class BindToyResponeItems implements Serializable {
    private String code;
    private List<DataBean> data;
    private String message;
    private boolean result;

    public static class DataBean {
        private String code;
        private String id;

        public String getCode() {
            return this.code;
        }

        public String getId() {
            return this.id;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setId(String str) {
            this.id = str;
        }
    }

    public String getCode() {
        return this.code;
    }

    public List<DataBean> getData() {
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

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }
}
