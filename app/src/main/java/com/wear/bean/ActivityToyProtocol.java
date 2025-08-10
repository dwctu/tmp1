package com.wear.bean;

/* loaded from: classes3.dex */
public class ActivityToyProtocol {
    private DataBean data;
    private String from;
    private String type;

    public static class DataBean {
        private int toyNum;

        public DataBean(int i) {
            this.toyNum = i;
        }

        public int getToyNum() {
            return this.toyNum;
        }

        public void setToyNum(int i) {
            this.toyNum = i;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public String getFrom() {
        return this.from;
    }

    public String getType() {
        return this.type;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
