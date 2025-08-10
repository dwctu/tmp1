package com.wear.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class LanApiDfuUpdateBean {
    private int code;
    private List<DataBean> data;
    private String message;
    private boolean result;

    public static class DataBean {
        private boolean enable3dx;
        private boolean hasUpdate;
        private String macId;
        private String md5;
        private boolean publishPercentMark;
        private String toyDfuName;
        private Object toyDfuUrl;
        private String url;
        private int version;

        public String getMacId() {
            return this.macId;
        }

        public String getMd5() {
            return this.md5;
        }

        public String getToyDfuName() {
            return this.toyDfuName;
        }

        public Object getToyDfuUrl() {
            return this.toyDfuUrl;
        }

        public String getUrl() {
            return this.url;
        }

        public int getVersion() {
            return this.version;
        }

        public boolean isEnable3dx() {
            return this.enable3dx;
        }

        public boolean isHasUpdate() {
            return this.hasUpdate;
        }

        public boolean isPublishPercentMark() {
            return this.publishPercentMark;
        }

        public void setEnable3dx(boolean z) {
            this.enable3dx = z;
        }

        public void setHasUpdate(boolean z) {
            this.hasUpdate = z;
        }

        public void setMacId(String str) {
            this.macId = str;
        }

        public void setMd5(String str) {
            this.md5 = str;
        }

        public void setPublishPercentMark(boolean z) {
            this.publishPercentMark = z;
        }

        public void setToyDfuName(String str) {
            this.toyDfuName = str;
        }

        public void setToyDfuUrl(Object obj) {
            this.toyDfuUrl = obj;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setVersion(int i) {
            this.version = i;
        }
    }

    public int getCode() {
        return this.code;
    }

    public List<DataBean> getData() {
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

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }
}
