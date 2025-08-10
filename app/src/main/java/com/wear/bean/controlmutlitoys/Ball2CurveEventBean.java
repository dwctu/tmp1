package com.wear.bean.controlmutlitoys;

import com.wear.util.WearUtils;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class Ball2CurveEventBean {
    private String function;
    private String groups;
    private boolean isRotateChange;
    private List<String> symbol;
    private String toyAddress;

    public Ball2CurveEventBean(String str) {
        this.isRotateChange = false;
        this.toyAddress = str;
    }

    public String getFunction() {
        return this.function;
    }

    public String getGroups() {
        return this.groups;
    }

    public List<String> getSymbol() {
        return this.symbol;
    }

    public String getToyAddress() {
        return this.toyAddress;
    }

    public boolean isFunction() {
        return WearUtils.e1(this.toyAddress);
    }

    public boolean isRotateChange() {
        return this.isRotateChange;
    }

    public void setFunction(String str) {
        this.function = str;
    }

    public void setGroups(String str) {
        this.groups = str;
    }

    public void setRotateChange(boolean z) {
        this.isRotateChange = z;
    }

    public void setSymbol(List<String> list) {
        this.symbol = list;
    }

    public String toString() {
        return "Ball2CurveEventBean{toyAddress='" + this.toyAddress + "', function='" + this.function + "', groups='" + this.groups + "', isRotateChange='" + this.isRotateChange + '\'' + MessageFormatter.DELIM_STOP;
    }

    public Ball2CurveEventBean(String str, String str2, String str3) {
        this.isRotateChange = false;
        this.toyAddress = str;
        this.function = str2;
        this.groups = str3;
        this.isRotateChange = false;
    }

    public Ball2CurveEventBean(String str, String str2, String str3, boolean z) {
        this.isRotateChange = false;
        this.toyAddress = str;
        this.function = str2;
        this.groups = str3;
        this.isRotateChange = z;
    }
}
