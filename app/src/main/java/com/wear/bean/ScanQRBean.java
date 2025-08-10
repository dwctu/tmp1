package com.wear.bean;

/* loaded from: classes3.dex */
public class ScanQRBean {
    private int code;
    private DataBean data;
    private String message;
    private boolean result;

    public static class DataBean {
        private String data;
        private int type;

        public String getData() {
            return this.data;
        }

        public int getType() {
            return this.type;
        }

        public void setData(String str) {
            this.data = str;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    public int getCode() {
        return this.code;
    }

    public DataBean getData() {
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

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }
}
