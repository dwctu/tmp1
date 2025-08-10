package com.wear.network.presenter.bean;

/* loaded from: classes3.dex */
public class PrivacyPolicyStatusBean {
    private String code;
    private DataBean data;
    private String message;
    private boolean result;

    public static class DataBean {
        private int accept;

        public int getAccept() {
            return this.accept;
        }

        public void setAccept(int i) {
            this.accept = i;
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
