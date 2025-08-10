package com.wear.bean;

import com.wear.util.WearUtils;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class ToyConfigInfoBean implements Serializable {
    private List<RangeBean> changeName;
    private List<FeedbackModeSupport> feedbackModeSupport;
    private String fullName;
    private FuncBean func;
    private List<FunctionDescription> functionDescription;
    private List<List<String>> motors;
    private List<NotSupport> notSupport;
    private List<RangeBean> pinCodeSupport;
    private List<ProgramBean> program;
    private boolean selling;
    private String showName;
    private List<RangeBean> supportLEDColor;
    private List<SupportLanPattern> supportLanPattern;
    private List<RangeBean> supportMotherboradLEDColor;
    private List<SupportMultiply> supportMultiply;
    private List<String> symbol;
    private List<TvBean> tv;
    private String type;

    public static class FeedbackModeSupport implements Serializable {
        private int maxv;
        private int minv;

        public int getMaxv() {
            return this.maxv;
        }

        public int getMinv() {
            return this.minv;
        }

        public void setMaxv(int i) {
            this.maxv = i;
        }

        public void setMinv(int i) {
            this.minv = i;
        }
    }

    public static class FuncBean implements Serializable {
        private boolean d;
        private boolean f;
        private boolean p;
        private boolean pos;
        private boolean r;
        private boolean s;
        private boolean t;
        private boolean v;
        private boolean v1;
        private boolean v2;
        private boolean v3;

        public boolean isD() {
            return this.d;
        }

        public boolean isF() {
            return this.f;
        }

        public boolean isP() {
            return this.p;
        }

        public boolean isPos() {
            return this.pos;
        }

        public boolean isR() {
            return this.r;
        }

        public boolean isS() {
            return this.s;
        }

        public boolean isT() {
            return this.t;
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

        public boolean isV3() {
            return this.v3;
        }

        public void setD(boolean z) {
            this.d = z;
        }

        public void setF(boolean z) {
            this.f = z;
        }

        public void setP(boolean z) {
            this.p = z;
        }

        public void setPos(boolean z) {
            this.pos = z;
        }

        public void setR(boolean z) {
            this.r = z;
        }

        public void setS(boolean z) {
            this.s = z;
        }

        public void setT(boolean z) {
            this.t = z;
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

        public void setV3(boolean z) {
            this.v3 = z;
        }
    }

    public static class FunctionDescription extends RangeBean implements Serializable {
        private String[] fullNames;
        private String[] shortNames;
        private String v;

        public String[] getFullNames() {
            return this.fullNames;
        }

        public String[] getShortNames() {
            return this.shortNames;
        }

        public String getV() {
            return this.v;
        }

        public void setFullNames(String[] strArr) {
            this.fullNames = strArr;
        }

        public void setShortNames(String[] strArr) {
            this.shortNames = strArr;
        }

        public void setV(String str) {
            this.v = str;
        }
    }

    public static class NotSupport implements Serializable {
        private String at;
        private String maxv;
        private String minv;
        private String pf;

        public String getAt() {
            return this.at;
        }

        public String getMaxv() {
            return this.maxv;
        }

        public String getMinv() {
            return this.minv;
        }

        public String getPf() {
            return this.pf;
        }

        public void setAt(String str) {
            this.at = str;
        }

        public void setMaxv(String str) {
            this.maxv = str;
        }

        public void setMinv(String str) {
            this.minv = str;
        }

        public void setPf(String str) {
            this.pf = str;
        }
    }

    public static class PinCodeSupport implements Serializable {
        private int maxv;
        private int minv;

        public int getMaxv() {
            return this.maxv;
        }

        public int getMinv() {
            return this.minv;
        }

        public void setMaxv(int i) {
            this.maxv = i;
        }

        public void setMinv(int i) {
            this.minv = i;
        }
    }

    public static class ProgramBean extends RangeBean implements Serializable {
        private boolean fast;
        private String l;
        private String p;

        public String getL() {
            return this.l;
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

        public void setP(String str) {
            this.p = str;
        }
    }

    public static class SupportLanPattern extends RangeBean implements Serializable {
        private String v;

        public String getV() {
            return this.v;
        }

        public void setV(String str) {
            this.v = str;
        }
    }

    public static class SupportMultiply extends RangeBean implements Serializable {
        private String order;

        public String getOrder() {
            return this.order;
        }

        public void setOrder(String str) {
            this.order = str;
        }
    }

    public static class TvBean extends RangeBean implements Serializable {
        private String v;

        public String getV() {
            return this.v;
        }

        public void setV(String str) {
            this.v = str;
        }
    }

    public List<RangeBean> getChangeName() {
        return this.changeName;
    }

    public List<FeedbackModeSupport> getFeedbackModeSupport() {
        return this.feedbackModeSupport;
    }

    public String getFullName() {
        return this.fullName;
    }

    public FuncBean getFunc() {
        if (this.func == null) {
            FuncBean funcBean = new FuncBean();
            this.func = funcBean;
            funcBean.v = true;
        }
        return this.func;
    }

    public List<FunctionDescription> getFunctionDescription() {
        return this.functionDescription;
    }

    public List<List<String>> getMotors() {
        return this.motors;
    }

    public List<NotSupport> getNotSupport() {
        return this.notSupport;
    }

    public List<RangeBean> getPinCodeSupport() {
        return this.pinCodeSupport;
    }

    public List<ProgramBean> getProgram() {
        return this.program;
    }

    public String getRealType() {
        return this.type;
    }

    public String getShowName() {
        return WearUtils.e1(this.showName) ? "Unknown" : this.showName;
    }

    public List<RangeBean> getSupportLEDColor() {
        return this.supportLEDColor;
    }

    public List<SupportLanPattern> getSupportLanPattern() {
        return this.supportLanPattern;
    }

    public List<RangeBean> getSupportMotherboradLEDColor() {
        return this.supportMotherboradLEDColor;
    }

    public List<SupportMultiply> getSupportMultiply() {
        return this.supportMultiply;
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

    public boolean isSelling() {
        return this.selling;
    }

    public void setChangeName(List<RangeBean> list) {
        this.changeName = list;
    }

    public void setFeedbackModeSupport(List<FeedbackModeSupport> list) {
        this.feedbackModeSupport = list;
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public void setFunc(FuncBean funcBean) {
        this.func = funcBean;
    }

    public void setFunctionDescription(List<FunctionDescription> list) {
        this.functionDescription = list;
    }

    public void setMotors(List<List<String>> list) {
        this.motors = list;
    }

    public void setNotSupport(List<NotSupport> list) {
        this.notSupport = list;
    }

    public void setPinCodeSupport(List<RangeBean> list) {
        this.pinCodeSupport = list;
    }

    public void setProgram(List<ProgramBean> list) {
        this.program = list;
    }

    public void setSelling(boolean z) {
        this.selling = z;
    }

    public void setShowName(String str) {
        this.showName = str;
    }

    public void setSupportLEDColor(List<RangeBean> list) {
        this.supportLEDColor = list;
    }

    public void setSupportLanPattern(List<SupportLanPattern> list) {
        this.supportLanPattern = list;
    }

    public void setSupportMotherboradLEDColor(List<RangeBean> list) {
        this.supportMotherboradLEDColor = list;
    }

    public void setSupportMultiply(List<SupportMultiply> list) {
        this.supportMultiply = list;
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
