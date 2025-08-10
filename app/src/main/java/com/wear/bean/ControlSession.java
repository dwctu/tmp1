package com.wear.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class ControlSession {
    private String code;
    private DataBean data;
    private String message;
    private boolean result;

    public static class DataBean {
        private boolean allow2way;
        private boolean controlling;
        private boolean countTimeImmediately;
        private long createTime;
        private List<?> cuids;
        private int expire;
        private Object expireDate;
        private String id;
        private int leftControlTime;
        private boolean loaded;
        private String mode;
        private Object muid;
        private String shortUrl;
        private boolean startTimer;
        private boolean sync;
        private String tid;
        private String uid;

        public long getCreateTime() {
            return this.createTime;
        }

        public List<?> getCuids() {
            return this.cuids;
        }

        public int getExpire() {
            return this.expire;
        }

        public Object getExpireDate() {
            return this.expireDate;
        }

        public String getId() {
            return this.id;
        }

        public int getLeftControlTime() {
            return this.leftControlTime;
        }

        public String getMode() {
            return this.mode;
        }

        public Object getMuid() {
            return this.muid;
        }

        public String getShortUrl() {
            return this.shortUrl;
        }

        public String getTid() {
            return this.tid;
        }

        public String getUid() {
            return this.uid;
        }

        public boolean isAllow2way() {
            return this.allow2way;
        }

        public boolean isControlling() {
            return this.controlling;
        }

        public boolean isCountTimeImmediately() {
            return this.countTimeImmediately;
        }

        public boolean isLoaded() {
            return this.loaded;
        }

        public boolean isStartTimer() {
            return this.startTimer;
        }

        public boolean isSync() {
            return this.sync;
        }

        public void setAllow2way(boolean z) {
            this.allow2way = z;
        }

        public void setControlling(boolean z) {
            this.controlling = z;
        }

        public void setCountTimeImmediately(boolean z) {
            this.countTimeImmediately = z;
        }

        public void setCreateTime(long j) {
            this.createTime = j;
        }

        public void setCuids(List<?> list) {
            this.cuids = list;
        }

        public void setExpire(int i) {
            this.expire = i;
        }

        public void setExpireDate(Object obj) {
            this.expireDate = obj;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setLeftControlTime(int i) {
            this.leftControlTime = i;
        }

        public void setLoaded(boolean z) {
            this.loaded = z;
        }

        public void setMode(String str) {
            this.mode = str;
        }

        public void setMuid(Object obj) {
            this.muid = obj;
        }

        public void setShortUrl(String str) {
            this.shortUrl = str;
        }

        public void setStartTimer(boolean z) {
            this.startTimer = z;
        }

        public void setSync(boolean z) {
            this.sync = z;
        }

        public void setTid(String str) {
            this.tid = str;
        }

        public void setUid(String str) {
            this.uid = str;
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
