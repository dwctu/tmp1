package com.wear.network.presenter.bean;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class GenTokenBean {
    private String code;
    private DataBean data;
    private String message;
    private boolean result;

    public static class DataBean {
        private String appRecoverAccountCode;
        private boolean frozen;
        private long frozenTimestamp;
        private String gtoken;
        private boolean isNewUser;
        private boolean isVerify;
        private String popupVer;
        private String rtoken;
        private String userEmail;
        private String x;
        private String y;

        public String getAppRecoverAccountCode() {
            return this.appRecoverAccountCode;
        }

        public long getFrozenTimestamp() {
            return this.frozenTimestamp;
        }

        public String getGtoken() {
            return this.gtoken;
        }

        public String getPopupVer() {
            return this.popupVer;
        }

        public String getRtoken() {
            return this.rtoken;
        }

        public String getUserEmail() {
            return this.userEmail;
        }

        public String getX() {
            return this.x;
        }

        public String getY() {
            return this.y;
        }

        public boolean isFrozen() {
            return this.frozen;
        }

        public boolean isNewUser() {
            return this.isNewUser;
        }

        public boolean isVerify() {
            return this.isVerify;
        }

        public void setAppRecoverAccountCode(String str) {
            this.appRecoverAccountCode = str;
        }

        public void setFrozen(boolean z) {
            this.frozen = z;
        }

        public void setFrozenTimestamp(long j) {
            this.frozenTimestamp = j;
        }

        public void setGtoken(String str) {
            this.gtoken = str;
        }

        public void setNewUser(boolean z) {
            this.isNewUser = z;
        }

        public void setPopupVer(String str) {
            this.popupVer = str;
        }

        public void setRtoken(String str) {
            this.rtoken = str;
        }

        public void setUserEmail(String str) {
            this.userEmail = str;
        }

        public void setVerify(boolean z) {
            this.isVerify = z;
        }

        public void setX(String str) {
            this.x = str;
        }

        public void setY(String str) {
            this.y = str;
        }

        public String toString() {
            return "DataBean{rtoken='" + this.rtoken + "', gtoken='" + this.gtoken + '\'' + MessageFormatter.DELIM_STOP;
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

    public String toString() {
        return "GenTokenBean{result=" + this.result + ", message='" + this.message + "', code=" + this.code + ", data=" + this.data + MessageFormatter.DELIM_STOP;
    }
}
