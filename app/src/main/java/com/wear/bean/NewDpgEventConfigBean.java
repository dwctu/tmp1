package com.wear.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class NewDpgEventConfigBean implements Serializable {
    private int code;
    private DataBean data;
    private String message;
    private boolean result;

    public static class DataBean implements Serializable {
        private String abtestType;
        private String androidClickUrl;
        private String appEventImgUrl;
        private String browserEventImgUrl;
        private String eventType;
        private String iosClickUrl;
        private String language;
        private String mobileBrowserClickUrl;
        private String pcBrowserClickUrl;

        public String getAbtestType() {
            return this.abtestType;
        }

        public String getAndroidClickUrl() {
            return this.androidClickUrl;
        }

        public String getAppEventImgUrl() {
            return this.appEventImgUrl;
        }

        public String getBrowserEventImgUrl() {
            return this.browserEventImgUrl;
        }

        public String getEventType() {
            return this.eventType;
        }

        public String getIosClickUrl() {
            return this.iosClickUrl;
        }

        public String getLanguage() {
            return this.language;
        }

        public String getMobileBrowserClickUrl() {
            return this.mobileBrowserClickUrl;
        }

        public String getPcBrowserClickUrl() {
            return this.pcBrowserClickUrl;
        }

        public void setAbtestType(String str) {
            this.abtestType = str;
        }

        public void setAndroidClickUrl(String str) {
            this.androidClickUrl = str;
        }

        public void setAppEventImgUrl(String str) {
            this.appEventImgUrl = str;
        }

        public void setBrowserEventImgUrl(String str) {
            this.browserEventImgUrl = str;
        }

        public void setEventType(String str) {
            this.eventType = str;
        }

        public void setIosClickUrl(String str) {
            this.iosClickUrl = str;
        }

        public void setLanguage(String str) {
            this.language = str;
        }

        public void setMobileBrowserClickUrl(String str) {
            this.mobileBrowserClickUrl = str;
        }

        public void setPcBrowserClickUrl(String str) {
            this.pcBrowserClickUrl = str;
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
