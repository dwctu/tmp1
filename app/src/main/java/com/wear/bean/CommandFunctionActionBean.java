package com.wear.bean;

/* loaded from: classes3.dex */
public class CommandFunctionActionBean {
    private String opertion;
    private int value;

    public CommandFunctionActionBean(String str, int i) {
        this.opertion = str;
        this.value = i;
    }

    public String getOpertion() {
        return this.opertion;
    }

    public int getValue() {
        return this.value;
    }

    public void setOpertion(String str) {
        this.opertion = str;
    }

    public void setValue(int i) {
        this.value = i;
    }
}
