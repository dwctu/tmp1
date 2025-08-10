package com.wear.bean.socketio.starAndvibrate.response;

/* loaded from: classes3.dex */
public class TipperCtrlCommandRespone {
    private DataBean data;
    private String modelEmail;
    private String pf;

    public static class DataBean {
        private int p;
        private int r;
        private int v;

        public int getP() {
            return this.p;
        }

        public int getR() {
            return this.r;
        }

        public int getV() {
            return this.v;
        }

        public void setP(int i) {
            this.p = i;
        }

        public void setR(int i) {
            this.r = i;
        }

        public void setV(int i) {
            this.v = i;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public String getModelEmail() {
        return this.modelEmail;
    }

    public String getPf() {
        return this.pf;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setModelEmail(String str) {
        this.modelEmail = str;
    }

    public void setPf(String str) {
        this.pf = str;
    }
}
