package com.wear.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class ExpressionBean implements Serializable {
    private int code;
    private DataBean data;
    private Object message;
    private boolean result;

    public static class DataBean implements Serializable {
        private String url;
        private int v;

        public String getUrl() {
            return this.url;
        }

        public int getV() {
            return this.v;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setV(int i) {
            this.v = i;
        }
    }

    public int getCode() {
        return this.code;
    }

    public DataBean getData() {
        return this.data;
    }

    public Object getMessage() {
        return this.message;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMessage(Object obj) {
        this.message = obj;
    }

    public void setResult(boolean z) {
        this.result = z;
    }
}
