package com.wear.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class DpgEventConfigBean implements Serializable {
    private int code;
    private DataBean data;
    private Object message;
    private boolean result;

    public static class DataBean implements Serializable {
        private String abtestType;
        private String androidButtonUrl;
        private String dpgImageFilePath;
        private String eventImg;
        private String iosButtonUrl;

        public String getAbtestType() {
            return this.abtestType;
        }

        public String getAndroidButtonUrl() {
            return this.androidButtonUrl;
        }

        public String getDpgImageFilePath() {
            return this.dpgImageFilePath;
        }

        public String getEventImg() {
            return this.eventImg;
        }

        public String getIosButtonUrl() {
            return this.iosButtonUrl;
        }

        public void setAbtestType(String str) {
            this.abtestType = str;
        }

        public void setAndroidButtonUrl(String str) {
            this.androidButtonUrl = str;
        }

        public void setDpgImageFilePath(String str) {
            this.dpgImageFilePath = str;
        }

        public void setEventImg(String str) {
            this.eventImg = str;
        }

        public void setIosButtonUrl(String str) {
            this.iosButtonUrl = str;
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
