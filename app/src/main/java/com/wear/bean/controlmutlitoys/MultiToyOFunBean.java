package com.wear.bean.controlmutlitoys;

import androidx.annotation.NonNull;
import dc.uu1;
import java.util.List;

/* loaded from: classes3.dex */
public class MultiToyOFunBean {
    private String allFun;
    private int battery;
    private String fun;
    private boolean isConnected;
    private boolean isFunction;
    private boolean isXMachine;
    private String name;
    private List<String> symbol;
    private String tag;
    private String toyAddress;
    private boolean isFysModel = false;
    private boolean isClockWise = true;
    private String toyName = "";

    public MultiToyOFunBean(boolean z, String str, String str2, String str3, int i, boolean z2, boolean z3, List<String> list) {
        this.isFunction = z;
        this.name = str;
        this.isXMachine = z3;
        this.symbol = list;
        if (z) {
            this.allFun = "";
            this.fun = str2;
            this.tag = str2;
            this.toyAddress = "";
            this.battery = 0;
            this.isConnected = true;
            return;
        }
        this.allFun = str2;
        if (uu1.c(list)) {
            this.allFun = "t";
        } else if (uu1.f(list)) {
            this.allFun = "s";
        }
        this.fun = "";
        this.tag = str3;
        this.toyAddress = str3;
        this.battery = i;
        this.isConnected = z2;
    }

    public String getAllFun() {
        return this.allFun;
    }

    public int getBattery() {
        return this.battery;
    }

    public String getFun() {
        return this.fun;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getSymbol() {
        return this.symbol;
    }

    public String getTag() {
        return this.tag;
    }

    public String getToyAddress() {
        return this.toyAddress;
    }

    public String getToyName() {
        return this.toyName;
    }

    public boolean isClockWise() {
        return this.isClockWise;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public boolean isEqual(@NonNull String str, @NonNull String str2) {
        String str3;
        String str4;
        if (this.isFunction || (str4 = this.toyAddress) == null || !str4.equals(str)) {
            return this.isFunction && (str3 = this.fun) != null && str3.equals(str2);
        }
        return true;
    }

    public boolean isFunction() {
        return this.isFunction;
    }

    public boolean isFysModel() {
        return this.isFysModel;
    }

    public boolean isXMachine() {
        return this.isXMachine;
    }

    public void setBattery(int i) {
        this.battery = i;
    }

    public void setClockWise(boolean z) {
        this.isClockWise = z;
    }

    public void setConnected(boolean z) {
        this.isConnected = z;
    }

    public void setFysModel(boolean z) {
        this.isFysModel = z;
    }

    public void setSymbol(List<String> list) {
        this.symbol = list;
    }

    public void setToyName(String str) {
        this.toyName = str;
    }
}
