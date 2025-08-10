package com.wear.network.presenter.bean;

/* loaded from: classes3.dex */
public class AgoraTokenBean {
    private int code;
    private DataBean data;
    private Object message;
    private boolean result;

    public static class DataBean {
        private String appId;
        private String token;
        private int uid;

        public String getAppId() {
            return this.appId;
        }

        public String getToken() {
            return this.token;
        }

        public int getUid() {
            return this.uid;
        }

        public void setAppId(String str) {
            this.appId = str;
        }

        public void setToken(String str) {
            this.token = str;
        }

        public void setUid(int i) {
            this.uid = i;
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
