package com.wear.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class StrengthBean {
    private Data data;
    private String toyId;

    public static class Data implements Serializable {
        private Integer d;
        private Integer f;
        private Integer p;
        private Integer pos;
        private Integer r;
        private Integer s;
        private Integer strokeMax;
        private Integer strokeMin;
        private Integer t;
        private Integer v;
        private Integer v1;
        private Integer v2;
        private Integer v3;

        public Data() {
        }

        public Integer getD() {
            return this.d;
        }

        public Integer getF() {
            return this.f;
        }

        public Integer getP() {
            return this.p;
        }

        public Integer getPos() {
            return this.pos;
        }

        public Integer getR() {
            return this.r;
        }

        public Integer getS() {
            return this.s;
        }

        public Integer getStrokeMax() {
            return this.strokeMax;
        }

        public Integer getStrokeMin() {
            return this.strokeMin;
        }

        public Integer getT() {
            return this.t;
        }

        public Integer getV() {
            return this.v;
        }

        public Integer getV1() {
            return this.v1;
        }

        public Integer getV2() {
            return this.v2;
        }

        public Integer getV3() {
            return this.v3;
        }

        public void setD(Integer num) {
            this.d = num;
        }

        public void setF(Integer num) {
            this.f = num;
        }

        public void setP(Integer num) {
            this.p = num;
        }

        public void setPos(Integer num) {
            this.pos = num;
        }

        public void setR(Integer num) {
            this.r = num;
        }

        public void setS(Integer num) {
            this.s = num;
        }

        public void setStrokeMax(Integer num) {
            this.strokeMax = num;
        }

        public void setStrokeMin(Integer num) {
            this.strokeMin = num;
        }

        public void setT(Integer num) {
            this.t = num;
        }

        public void setV(Integer num) {
            this.v = num;
        }

        public void setV1(Integer num) {
            this.v1 = num;
        }

        public void setV2(Integer num) {
            this.v2 = num;
        }

        public void setV3(Integer num) {
            this.v3 = num;
        }

        public Data(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11) {
            this(num, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, 0, 100);
        }

        public Data(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13) {
            this.p = num;
            this.r = num2;
            this.v2 = num3;
            this.v3 = num4;
            this.v1 = num5;
            this.v = num6;
            this.t = num7;
            this.s = num8;
            this.f = num9;
            this.d = num10;
            this.pos = num11;
            this.strokeMin = num12;
            this.strokeMax = num13;
        }
    }

    public StrengthBean() {
    }

    public Data getData() {
        return this.data;
    }

    public String getToyId() {
        return this.toyId;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setToyId(String str) {
        this.toyId = str;
    }

    public StrengthBean(String str) {
        this.toyId = str;
        this.data = new Data();
    }
}
