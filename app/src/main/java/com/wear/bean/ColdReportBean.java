package com.wear.bean;

/* loaded from: classes3.dex */
public class ColdReportBean {
    private int code;
    private DataBean data;
    private Object message;
    private boolean result;

    public static class DataBean {
        private boolean overLimit;

        public boolean isOverLimit() {
            return this.overLimit;
        }

        public void setOverLimit(boolean z) {
            this.overLimit = z;
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
