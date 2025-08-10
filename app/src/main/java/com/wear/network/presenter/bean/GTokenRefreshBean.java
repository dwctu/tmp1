package com.wear.network.presenter.bean;

/* loaded from: classes3.dex */
public class GTokenRefreshBean {
    private String code;
    private DataBean data;
    private String message;
    private boolean result;

    public static class DataBean {
        private String created_time;
        private int expired_in_seconds;
        private String gtoken_new;
        private String rtoken_new;

        public String getCreated_time() {
            return this.created_time;
        }

        public int getExpired_in_seconds() {
            return this.expired_in_seconds;
        }

        public String getGtoken_new() {
            return this.gtoken_new;
        }

        public String getRtoken_new() {
            return this.rtoken_new;
        }

        public void setCreated_time(String str) {
            this.created_time = str;
        }

        public void setExpired_in_seconds(int i) {
            this.expired_in_seconds = i;
        }

        public void setGtoken_new(String str) {
            this.gtoken_new = str;
        }

        public void setRtoken_new(String str) {
            this.rtoken_new = str;
        }
    }

    public String getCode() {
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

    public void setCode(String str) {
        this.code = str;
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
