package com.wear.bean.server.bean;

/* loaded from: classes3.dex */
public class P013Bean {
    private DataBean data;
    private String type;

    public static class DataBean {
        private String toyId;
        private String toyType;

        public String getToyId() {
            return this.toyId;
        }

        public String getToyType() {
            return this.toyType;
        }

        public void setToyId(String str) {
            this.toyId = str;
        }

        public void setToyType(String str) {
            this.toyType = str;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public String getType() {
        return this.type;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setType(String str) {
        this.type = str;
    }
}
