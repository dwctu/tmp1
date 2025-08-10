package com.wear.bean;

/* loaded from: classes3.dex */
public class FFBasicMsgBean {
    public boolean isSelect;
    public String key;
    public int value;

    public FFBasicMsgBean(String str, int i) {
        this.key = str;
        this.value = i;
    }

    public String getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public void setValue(int i) {
        this.value = i;
    }
}
