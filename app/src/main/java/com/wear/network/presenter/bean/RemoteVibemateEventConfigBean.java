package com.wear.network.presenter.bean;

/* loaded from: classes3.dex */
public class RemoteVibemateEventConfigBean {
    private int code;
    private DataBean data;
    private String message;
    private boolean result;

    public static class DataBean {
        private String androidButtonUrl;
        private String button1BackgroundUrl;
        private String button1Name;
        private String button1Url;
        private String button2BackgroundUrl;
        private String button2Name;
        private String button2Url;
        private String buttonText;
        private String contentText;
        private String contentTextKey;
        private String eventImg;
        private String eventRefImg;
        private String eventType;
        private String iosButtonUrl;
        private int suspendForDay;
        private String titleText;

        public String getAndroidButtonUrl() {
            return this.androidButtonUrl;
        }

        public String getButton1BackgroundUrl() {
            return this.button1BackgroundUrl;
        }

        public String getButton1Name() {
            return this.button1Name;
        }

        public String getButton1Url() {
            return this.button1Url;
        }

        public String getButton2BackgroundUrl() {
            return this.button2BackgroundUrl;
        }

        public String getButton2Name() {
            return this.button2Name;
        }

        public String getButton2Url() {
            return this.button2Url;
        }

        public String getButtonText() {
            return this.buttonText;
        }

        public String getContentText() {
            return this.contentText;
        }

        public String getContentTextKey() {
            return this.contentTextKey;
        }

        public String getEventRefImg() {
            return this.eventRefImg;
        }

        public String getEventType() {
            return this.eventType;
        }

        public String getIosButtonUrl() {
            return this.iosButtonUrl;
        }

        public int getSuspendForDay() {
            return this.suspendForDay;
        }

        public String getTitleText() {
            return this.titleText;
        }

        public String isEventImg() {
            return this.eventImg;
        }

        public void setAndroidButtonUrl(String str) {
            this.androidButtonUrl = str;
        }

        public void setButton1BackgroundUrl(String str) {
            this.button1BackgroundUrl = str;
        }

        public void setButton1Name(String str) {
            this.button1Name = str;
        }

        public void setButton1Url(String str) {
            this.button1Url = str;
        }

        public void setButton2BackgroundUrl(String str) {
            this.button2BackgroundUrl = str;
        }

        public void setButton2Name(String str) {
            this.button2Name = str;
        }

        public void setButton2Url(String str) {
            this.button2Url = str;
        }

        public void setButtonText(String str) {
            this.buttonText = str;
        }

        public void setContentText(String str) {
            this.contentText = str;
        }

        public void setContentTextKey(String str) {
            this.contentTextKey = str;
        }

        public void setEventImg(String str) {
            this.eventImg = str;
        }

        public void setEventRefImg(String str) {
            this.eventRefImg = str;
        }

        public void setEventType(String str) {
            this.eventType = str;
        }

        public void setIosButtonUrl(String str) {
            this.iosButtonUrl = str;
        }

        public void setSuspendForDay(int i) {
            this.suspendForDay = i;
        }

        public void setTitleText(String str) {
            this.titleText = str;
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
