package com.wear.bean;

/* loaded from: classes3.dex */
public class TipModelData {
    private String modelId;
    private String platform;
    private String showId;
    private TipDataBean tipData;

    public static class TipDataBean {
        private String orderType;
        private int time;
        private long timestamp;
        private int tip;
        private String userName;

        public String getOrderType() {
            return this.orderType;
        }

        public int getTime() {
            return this.time;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public int getTip() {
            return this.tip;
        }

        public String getUserName() {
            return this.userName;
        }

        public void setOrderType(String str) {
            this.orderType = str;
        }

        public void setTime(int i) {
            this.time = i;
        }

        public void setTimestamp(long j) {
            this.timestamp = j;
        }

        public void setTip(int i) {
            this.tip = i;
        }

        public void setUserName(String str) {
            this.userName = str;
        }
    }

    public String getModelId() {
        return this.modelId;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getShowId() {
        return this.showId;
    }

    public TipDataBean getTipData() {
        return this.tipData;
    }

    public void setModelId(String str) {
        this.modelId = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setShowId(String str) {
        this.showId = str;
    }

    public void setTipData(TipDataBean tipDataBean) {
        this.tipData = tipDataBean;
    }
}
