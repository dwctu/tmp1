package com.wear.bean.socketio.msg;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class Order {
    private int r = -1;
    private int v = -1;
    private int p = -1;
    private int v1 = -1;
    private int v2 = -1;
    private int v3 = -1;
    private int t = -1;
    private int s = -1;
    private int f = -1;
    private int d = -1;
    private int pos = -1;

    public int getD() {
        return this.d;
    }

    public int getF() {
        return this.f;
    }

    public int getP() {
        return this.p;
    }

    public int getPos() {
        return this.pos;
    }

    public int getR() {
        return this.r;
    }

    public int getS() {
        return this.s;
    }

    public int getT() {
        return this.t;
    }

    public int getV() {
        return this.v;
    }

    public int getV1() {
        return this.v1;
    }

    public int getV2() {
        return this.v2;
    }

    public int getV3() {
        return this.v3;
    }

    public void recycle() {
        this.r = -1;
        this.v = -1;
        this.p = -1;
        this.v1 = -1;
        this.v2 = -1;
        this.v3 = -1;
        this.t = -1;
        this.s = -1;
        this.f = -1;
        this.d = -1;
        this.pos = -1;
    }

    public void resetZero() {
        this.r = 0;
        this.v = 0;
        this.p = 0;
        this.v1 = 0;
        this.v2 = 0;
        this.v3 = 0;
        this.t = 0;
        this.s = 0;
        this.f = 0;
        this.d = 0;
        this.pos = 0;
    }

    public void setD(int i) {
        this.d = i;
    }

    public void setF(int i) {
        this.f = i;
    }

    public void setP(int i) {
        this.p = i;
    }

    public void setPos(int i) {
        this.pos = i;
    }

    public void setR(int i) {
        this.r = i;
    }

    public void setS(int i) {
        this.s = i;
    }

    public void setT(int i) {
        this.t = i;
    }

    public void setV(int i) {
        this.v = i;
    }

    public void setV1(int i) {
        this.v1 = i;
    }

    public void setV2(int i) {
        this.v2 = i;
    }

    public void setV3(int i) {
        this.v3 = i;
    }

    public String toString() {
        return "Order{r=" + this.r + ", v=" + this.v + ", p=" + this.p + ", v1=" + this.v1 + ", v2=" + this.v2 + ", v3=" + this.v3 + ", t=" + this.t + ", s=" + this.s + ", f=" + this.f + ", d=" + this.d + ", pos=" + this.pos + MessageFormatter.DELIM_STOP;
    }
}
