package com.wear.network.presenter.bean;

/* loaded from: classes3.dex */
public class VibemateBetrayOneselfBean {
    private int code;
    private DataBean data;
    private String message;
    private boolean result;

    public static class DataBean {
        private boolean vibemateBetrayOneself;

        public boolean isVibemateBetrayOneself() {
            return this.vibemateBetrayOneself;
        }

        public void setVibemateBetrayOneself(boolean z) {
            this.vibemateBetrayOneself = z;
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
