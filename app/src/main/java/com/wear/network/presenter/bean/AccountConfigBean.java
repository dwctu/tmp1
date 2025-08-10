package com.wear.network.presenter.bean;

/* loaded from: classes3.dex */
public class AccountConfigBean {
    private int code;
    private DataBean data;
    private Object message;
    private boolean result;

    public static class DataBean {
        private boolean enableAgoraIO;
        private boolean enableColdRestart = false;

        public boolean isEnableAgoraIO() {
            return this.enableAgoraIO;
        }

        public boolean isEnableColdRestart() {
            return this.enableColdRestart;
        }

        public void setEnableAgoraIO(boolean z) {
            this.enableAgoraIO = z;
        }

        public void setEnableColdRestart(boolean z) {
            this.enableColdRestart = z;
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
