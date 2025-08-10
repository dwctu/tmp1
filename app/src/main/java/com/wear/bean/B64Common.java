package com.wear.bean;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.mp1;
import dc.uq1;
import java.util.HashMap;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes3.dex */
public class B64Common {
    private AllBean all;
    private String cate;
    private HashMap<String, IdBean> id;

    public static class AllBean {
        private int time;
        private int v = -1;
        private int v1 = -1;
        private int v2 = -1;
        private int v3 = -1;
        private int r = -1;
        private int p = -1;
        private int s = -1;
        private int t = -1;
        private int f = -1;

        public int getF() {
            return this.f;
        }

        public int getP() {
            return this.p;
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
            boolean z = (this.v == 0) & (this.v1 == 0) & (this.v2 == 0) & (this.v3 == 0) & (this.r == 0) & (this.p == 0);
            int i = this.s;
            return (((z & (i == 0)) & (this.t == 0)) && (this.f == 0)) || ((((((((isNotUsed(i) & isNotUsed(this.t)) & isNotUsed(this.f)) & isNotUsed(this.p)) & isNotUsed(this.r)) & isNotUsed(this.v)) & isNotUsed(this.v1)) & isNotUsed(this.v2)) && isNotUsed(this.v3));
        }

        public void sendCommand(MyApplication myApplication, int i) {
            if (mp1.h()) {
                uq1.a(this);
                return;
            }
            if (isStopAll()) {
                myApplication.G().u0();
                return;
            }
            if (getV() != -1) {
                myApplication.G().f0(null, PSOProgramService.VS_Key, getV());
            }
            if (getV1() != -1) {
                myApplication.G().f0(null, "v1", getV1());
            }
            if (getV2() != -1) {
                myApplication.G().f0(null, "v2", getV2());
            }
            if (getV3() != -1) {
                myApplication.G().f0(null, "v3", getV3());
            }
            if (getR() != -1) {
                myApplication.G().f0(null, StreamManagement.AckRequest.ELEMENT, getR());
            }
            if (getP() != -1) {
                for (Toy toy : WearUtils.x.G().P()) {
                    if (toy.isMaxToy()) {
                        myApplication.G().f0(toy, "p", getP());
                    }
                }
            }
            if (getS() != -1) {
                myApplication.G().f0(null, "s", getS());
            }
            if (getT() != -1) {
                myApplication.G().f0(null, "t", getT());
            }
            if (getF() != -1) {
                myApplication.G().f0(null, "f", getF());
            }
        }

        public void setF(int i) {
            this.f = i;
        }

        public void setP(int i) {
            this.p = i;
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
    }

    public static class IdBean {
        private int time;
        private int v = -1;
        private int v1 = -1;
        private int v2 = -1;
        private int v3 = -1;
        private int r = -1;
        private int p = -1;
        private int s = -1;
        private int t = -1;
        private int f = -1;

        public int getF() {
            return this.f;
        }

        public int getP() {
            return this.p;
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
            boolean z = (this.v == 0) & (this.v1 == 0) & (this.v2 == 0) & (this.v3 == 0) & (this.r == 0) & (this.p == 0);
            int i = this.s;
            return (((z & (i == 0)) & (this.t == 0)) && (this.f == 0)) || ((((((((isNotUsed(i) & isNotUsed(this.t)) & isNotUsed(this.f)) & isNotUsed(this.p)) & isNotUsed(this.r)) & isNotUsed(this.v)) & isNotUsed(this.v1)) & isNotUsed(this.v2)) && isNotUsed(this.v3));
        }

        public void sendCommand(MyApplication myApplication, Toy toy, int i) {
            if (mp1.h()) {
                uq1.b(toy, this);
                return;
            }
            if (isStopAll()) {
                if (toy != null) {
                    myApplication.G().v0(toy.getAddress());
                    return;
                } else {
                    myApplication.G().u0();
                    return;
                }
            }
            if (getV() != -1) {
                myApplication.G().e0(toy, PSOProgramService.VS_Key, getV());
            }
            if (getV1() != -1) {
                myApplication.G().e0(toy, "v1", getV1());
            }
            if (getV2() != -1) {
                myApplication.G().e0(toy, "v2", getV2());
            }
            if (getV3() != -1) {
                myApplication.G().e0(toy, "v3", getV3());
            }
            if (getR() != -1 && toy.isNoraToy()) {
                myApplication.G().e0(toy, StreamManagement.AckRequest.ELEMENT, getR());
            }
            if (getP() != -1 && toy.isMaxToy()) {
                myApplication.G().e0(toy, "p", getP());
            }
            if (getS() != -1) {
                myApplication.G().e0(toy, "s", getS());
            }
            if (getT() != -1) {
                myApplication.G().e0(toy, "t", getT());
            }
            if (getF() != -1) {
                myApplication.G().e0(toy, "f", getF());
            }
        }

        public void setF(int i) {
            this.f = i;
        }

        public void setP(int i) {
            this.p = i;
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
    }

    public AllBean getAll() {
        return this.all;
    }

    public String getCate() {
        return this.cate;
    }

    public HashMap<String, IdBean> getId() {
        return this.id;
    }

    public void setCate(String str) {
        this.cate = str;
    }

    public void setId(HashMap<String, IdBean> map) {
        this.id = map;
    }
}
