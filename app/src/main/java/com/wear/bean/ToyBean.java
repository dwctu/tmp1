package com.wear.bean;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.util.WearUtils;
import com.wear.widget.control.TouchControlView;
import java.lang.reflect.Field;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class ToyBean {
    private int d;
    private int f;
    private int p;
    private int pos;
    private int r;
    private int s;
    private int t;
    private int time;
    private int v;
    private int v1;
    private int v2;
    private int v3;

    public ToyBean() {
        this.v = -1;
        this.v1 = -1;
        this.v2 = -1;
        this.v3 = -1;
        this.r = -1;
        this.p = -1;
        this.t = -1;
        this.s = -1;
        this.f = -1;
        this.d = -1;
        this.pos = -1;
    }

    public void fillAll(int i) {
        if (this.v == -1) {
            this.v = i;
        }
        if (this.v1 == -1) {
            this.v1 = i;
        }
        if (this.v2 == -1) {
            this.v2 = i;
        }
        if (this.v3 == -1) {
            this.v3 = i;
        }
        if (this.r == -1) {
            this.r = i;
        }
        if (this.p == -1) {
            if (i <= 0) {
                this.p = 0;
            } else if (i < 7) {
                this.p = 1;
            } else if (i < 14) {
                this.p = 2;
            } else {
                this.p = 3;
            }
        }
        if (this.t == -1) {
            this.t = i;
        }
        if (this.s == -1) {
            this.s = i;
        }
        if (this.f == -1) {
            this.f = i;
        }
        if (this.d == -1) {
            this.d = i;
        }
        if (this.pos == -1) {
            this.pos = i;
        }
    }

    public int getD() {
        return this.d;
    }

    public int getF() {
        return this.f;
    }

    public int getMaxFunValidValue() {
        int i;
        int i2 = -1;
        for (Field field : getClass().getDeclaredFields()) {
            try {
                if (!field.getName().equals("time") && (i = field.getInt(this)) > i2) {
                    i2 = i;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return i2;
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

    public int getTime() {
        return this.time;
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

    public boolean isNotUsed(int i) {
        return i == 0 || i == -1;
    }

    public boolean isStopAll() {
        boolean z = (this.v == 0) & (this.v1 == 0) & (this.v2 == 0) & (this.v3 == 0) & (this.r == 0);
        int i = this.p;
        return ((((((z & (i == 0)) & (this.t == 0)) & (this.s == 0)) & (this.f == 0)) & (this.d == 0)) && (this.pos == 0)) || ((((((((((isNotUsed(i) & isNotUsed(this.r)) & isNotUsed(this.v)) & isNotUsed(this.v1)) & isNotUsed(this.v2)) & isNotUsed(this.v3)) & isNotUsed(this.t)) & isNotUsed(this.s)) & isNotUsed(this.f)) & isNotUsed(this.d)) && isNotUsed(this.pos));
    }

    public void setAll(int i) {
        this.v = i;
        this.v1 = i;
        this.v2 = i;
        this.v3 = i;
        this.r = i;
        this.p = i;
        this.t = i;
        this.s = i;
        this.f = i;
        this.d = i;
        this.pos = i;
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

    public void setTime(int i) {
        this.time = i;
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

    @NotNull
    public String toString() {
        return "ToyBean{v=" + this.v + ", v1=" + this.v1 + ", v2=" + this.v2 + ", v3=" + this.v3 + ", r=" + this.r + ", p=" + this.p + ", t=" + this.t + ", s=" + this.s + ", f=" + this.f + ", d=" + this.d + ", pos=" + this.pos + ", time=" + this.time + MessageFormatter.DELIM_STOP;
    }

    public ToyBean(Ball2CurveEventBean ball2CurveEventBean) {
        this.v = -1;
        this.v1 = -1;
        this.v2 = -1;
        this.v3 = -1;
        this.r = -1;
        this.p = -1;
        this.t = -1;
        this.s = -1;
        this.f = -1;
        this.d = -1;
        this.pos = -1;
        if (ball2CurveEventBean.isRotateChange()) {
            this.r = TouchControlView.Q;
            return;
        }
        if (WearUtils.e1(ball2CurveEventBean.getFunction()) || WearUtils.e1(ball2CurveEventBean.getGroups())) {
            return;
        }
        if (PSOProgramService.VS_Key.equals(ball2CurveEventBean.getFunction())) {
            this.v = Integer.parseInt(ball2CurveEventBean.getGroups());
            return;
        }
        if ("v1".equals(ball2CurveEventBean.getFunction())) {
            this.v1 = Integer.parseInt(ball2CurveEventBean.getGroups());
            return;
        }
        if ("v2".equals(ball2CurveEventBean.getFunction())) {
            this.v2 = Integer.parseInt(ball2CurveEventBean.getGroups());
            return;
        }
        if ("v3".equals(ball2CurveEventBean.getFunction())) {
            this.v3 = Integer.parseInt(ball2CurveEventBean.getGroups());
            return;
        }
        if (StreamManagement.AckRequest.ELEMENT.equals(ball2CurveEventBean.getFunction())) {
            this.r = Integer.parseInt(ball2CurveEventBean.getGroups());
            return;
        }
        if ("p".equals(ball2CurveEventBean.getFunction())) {
            this.p = Integer.parseInt(ball2CurveEventBean.getGroups()) / 5;
            return;
        }
        if ("t".equals(ball2CurveEventBean.getFunction())) {
            this.t = Integer.parseInt(ball2CurveEventBean.getGroups());
            return;
        }
        if ("s".equals(ball2CurveEventBean.getFunction())) {
            this.s = Integer.parseInt(ball2CurveEventBean.getGroups());
            return;
        }
        if ("f".equals(ball2CurveEventBean.getFunction())) {
            this.f = Integer.parseInt(ball2CurveEventBean.getGroups());
        } else if (GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG.equals(ball2CurveEventBean.getFunction())) {
            this.d = Integer.parseInt(ball2CurveEventBean.getGroups());
        } else if ("pos".equals(ball2CurveEventBean.getFunction())) {
            this.pos = Integer.parseInt(ball2CurveEventBean.getGroups());
        }
    }

    public ToyBean(String str, int i) {
        String[] strArrSplit;
        this.v = -1;
        this.v1 = -1;
        this.v2 = -1;
        this.v3 = -1;
        this.r = -1;
        this.p = -1;
        this.t = -1;
        this.s = -1;
        this.f = -1;
        this.d = -1;
        this.pos = -1;
        if (WearUtils.e1(str) || WearUtils.c1(Integer.valueOf(i)) || (strArrSplit = str.split(",")) == null) {
            return;
        }
        for (String str2 : strArrSplit) {
            if (!WearUtils.e1(str2)) {
                if (PSOProgramService.VS_Key.equals(str2)) {
                    this.v = i;
                } else if ("v1".equals(str2)) {
                    this.v1 = i;
                } else if ("v2".equals(str2)) {
                    this.v2 = i;
                } else if ("v3".equals(str2)) {
                    this.v3 = i;
                } else if (StreamManagement.AckRequest.ELEMENT.equals(str2)) {
                    this.r = i;
                } else if ("p".equals(str2)) {
                    this.p = i / 5;
                } else if ("t".equals(str2)) {
                    this.t = i;
                } else if ("s".equals(str2)) {
                    this.s = i;
                } else if ("f".equals(str2)) {
                    this.f = i;
                } else if (GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG.equals(str2)) {
                    this.d = i;
                } else if ("pos".equals(str2)) {
                    this.pos = i;
                }
            }
        }
    }

    public ToyBean(String str, String str2, boolean z) {
        this.v = -1;
        this.v1 = -1;
        this.v2 = -1;
        this.v3 = -1;
        this.r = -1;
        this.p = -1;
        this.t = -1;
        this.s = -1;
        this.f = -1;
        this.d = -1;
        this.pos = -1;
        if (z) {
            this.r = TouchControlView.Q;
        }
        if (WearUtils.e1(str) || WearUtils.e1(str2)) {
            return;
        }
        String[] strArrSplit = str.split(",");
        String[] strArrSplit2 = str2.split(",");
        if (strArrSplit == null || strArrSplit2 == null || strArrSplit.length != strArrSplit2.length) {
            return;
        }
        for (int i = 0; i < strArrSplit.length; i++) {
            if (!WearUtils.e1(strArrSplit[i])) {
                if (PSOProgramService.VS_Key.equals(strArrSplit[i])) {
                    this.v = WearUtils.e1(strArrSplit2[i]) ? -1 : Integer.parseInt(strArrSplit2[i]);
                } else if ("v1".equals(strArrSplit[i])) {
                    this.v1 = WearUtils.e1(strArrSplit2[i]) ? -1 : Integer.parseInt(strArrSplit2[i]);
                } else if ("v2".equals(strArrSplit[i])) {
                    this.v2 = WearUtils.e1(strArrSplit2[i]) ? -1 : Integer.parseInt(strArrSplit2[i]);
                } else if ("v3".equals(strArrSplit[i])) {
                    this.v3 = WearUtils.e1(strArrSplit2[i]) ? -1 : Integer.parseInt(strArrSplit2[i]);
                } else if (StreamManagement.AckRequest.ELEMENT.equals(strArrSplit[i])) {
                    this.r = WearUtils.e1(strArrSplit2[i]) ? -1 : Integer.parseInt(strArrSplit2[i]);
                } else if ("p".equals(strArrSplit[i])) {
                    this.p = WearUtils.e1(strArrSplit2[i]) ? -1 : Integer.parseInt(strArrSplit2[i]);
                } else if ("t".equals(strArrSplit[i])) {
                    this.t = WearUtils.e1(strArrSplit2[i]) ? -1 : Integer.parseInt(strArrSplit2[i]);
                } else if ("s".equals(strArrSplit[i])) {
                    this.s = WearUtils.e1(strArrSplit2[i]) ? -1 : Integer.parseInt(strArrSplit2[i]);
                } else if ("f".equals(strArrSplit[i])) {
                    this.f = WearUtils.e1(strArrSplit2[i]) ? -1 : Integer.parseInt(strArrSplit2[i]);
                } else if (GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG.equals(strArrSplit[i])) {
                    this.d = WearUtils.e1(strArrSplit2[i]) ? -1 : Integer.parseInt(strArrSplit2[i]);
                } else if ("pos".equals(strArrSplit[i])) {
                    this.pos = WearUtils.e1(strArrSplit2[i]) ? -1 : Integer.parseInt(strArrSplit2[i]);
                }
            }
        }
    }
}
