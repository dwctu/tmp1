package com.wear.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class Test {
    private List<InfoBean> info;

    public static class InfoBean implements Serializable {
        private FuncBean func;
        private List<ProgramBean> program;
        private String showName;
        private List<String> symbol;
        private List<TvBean> tv;
        private String type;

        public static class FuncBean implements Serializable {
            private boolean p;
            private boolean r;
            private boolean v;
            private boolean v1;
            private boolean v2;

            public boolean isP() {
                return this.p;
            }

            public boolean isR() {
                return this.r;
            }

            public boolean isV() {
                return this.v;
            }

            public boolean isV1() {
                return this.v1;
            }

            public boolean isV2() {
                return this.v2;
            }

            public void setP(boolean z) {
                this.p = z;
            }

            public void setR(boolean z) {
                this.r = z;
            }

            public void setV(boolean z) {
                this.v = z;
            }

            public void setV1(boolean z) {
                this.v1 = z;
            }

            public void setV2(boolean z) {
                this.v2 = z;
            }
        }

        public static class ProgramBean {
            private boolean fast;
            private String l;
            private int maxv;
            private int minv;
            private String p;

            public String getL() {
                return this.l;
            }

            public int getMaxv() {
                return this.maxv;
            }

            public int getMinv() {
                return this.minv;
            }

            public String getP() {
                return this.p;
            }

            public boolean isFast() {
                return this.fast;
            }

            public void setFast(boolean z) {
                this.fast = z;
            }

            public void setL(String str) {
                this.l = str;
            }

            public void setMaxv(int i) {
                this.maxv = i;
            }

            public void setMinv(int i) {
                this.minv = i;
            }

            public void setP(String str) {
                this.p = str;
            }
        }

        public static class TvBean implements Serializable {
            private int maxv;
            private int minv;
            private String v;

            public int getMaxv() {
                return this.maxv;
            }

            public int getMinv() {
                return this.minv;
            }

            public String getV() {
                return this.v;
            }

            public void setMaxv(int i) {
                this.maxv = i;
            }

            public void setMinv(int i) {
                this.minv = i;
            }

            public void setV(String str) {
                this.v = str;
            }
        }

        public FuncBean getFunc() {
            return this.func;
        }

        public List<ProgramBean> getProgram() {
            return this.program;
        }

        public String getRealType() {
            return this.type;
        }

        public String getShowName() {
            return this.showName;
        }

        public List<String> getSymbol() {
            return this.symbol;
        }

        public List<TvBean> getTv() {
            return this.tv;
        }

        public String getType() {
            return this.type.toLowerCase();
        }

        public void setFunc(FuncBean funcBean) {
            this.func = funcBean;
        }

        public void setProgram(List<ProgramBean> list) {
            this.program = list;
        }

        public void setShowName(String str) {
            this.showName = str;
        }

        public void setSymbol(List<String> list) {
            this.symbol = list;
        }

        public void setTv(List<TvBean> list) {
            this.tv = list;
        }

        public void setType(String str) {
            this.type = str;
        }
    }

    public List<InfoBean> getInfo() {
        return this.info;
    }

    public void setInfo(List<InfoBean> list) {
        this.info = list;
    }
}
