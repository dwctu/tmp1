package com.wear.bean;

/* loaded from: classes3.dex */
public class ThirdLoginBean {
    private int code;
    private DataBean data;
    private String message;
    private boolean result;

    public static class DataBean {
        private String appAccountCode;
        private String gtoken;
        private boolean isNewUser;
        private boolean isVerify;
        private int loginType;
        private boolean newRegist;
        private int popupVer;
        private String rtoken;
        private String x;
        private String y;

        public String getAppAccountCode() {
            return this.appAccountCode;
        }

        public String getGtoken() {
            return this.gtoken;
        }

        public int getLoginType() {
            return this.loginType;
        }

        public int getPopupVer() {
            return this.popupVer;
        }

        public String getRtoken() {
            return this.rtoken;
        }

        public String getX() {
            return this.x;
        }

        public String getY() {
            return this.y;
        }

        public boolean isIsNewUser() {
            return this.isNewUser;
        }

        public boolean isIsVerify() {
            return this.isVerify;
        }

        public boolean isNewRegist() {
            return this.newRegist;
        }

        public void setAppAccountCode(String str) {
            this.appAccountCode = str;
        }

        public void setGtoken(String str) {
            this.gtoken = str;
        }

        public void setIsNewUser(boolean z) {
            this.isNewUser = z;
        }

        public void setIsVerify(boolean z) {
            this.isVerify = z;
        }

        public void setLoginType(int i) {
            this.loginType = i;
        }

        public void setNewRegist(boolean z) {
            this.newRegist = z;
        }

        public void setPopupVer(int i) {
            this.popupVer = i;
        }

        public void setRtoken(String str) {
            this.rtoken = str;
        }

        public void setX(String str) {
            this.x = str;
        }

        public void setY(String str) {
            this.y = str;
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
