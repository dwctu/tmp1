package com.wear.bean;

/* loaded from: classes3.dex */
public class ToyLedBean {
    private int color;
    private int colorNumber;
    private String name;
    private boolean select;

    public ToyLedBean(String str, int i, int i2) {
        this.name = str;
        this.color = i;
        this.colorNumber = i2;
    }

    public int getColor() {
        return this.color;
    }

    public int getColorNumber() {
        return this.colorNumber;
    }

    public String getName() {
        return this.name;
    }

    public boolean isSelect() {
        return this.select;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setColorNumber(int i) {
        this.colorNumber = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSelect(boolean z) {
        this.select = z;
    }
}
