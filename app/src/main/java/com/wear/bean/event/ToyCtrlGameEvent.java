package com.wear.bean.event;

/* loaded from: classes3.dex */
public class ToyCtrlGameEvent {
    public static final int TYPE_BT_COMMAND = 21;
    public static final int TYPE_LIST_CHANGE = 20;
    public String address;
    public int type;
    public String value;

    public ToyCtrlGameEvent(int i) {
        this(i, null, null);
    }

    public ToyCtrlGameEvent(int i, String str, String str2) {
        this.type = i;
        this.value = str2;
        this.address = str;
    }
}
