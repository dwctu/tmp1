package com.wear.bean.request;

/* loaded from: classes3.dex */
public class EditPatternBean {
    private boolean isAnony;
    private long lastUpdTime;
    private String name;
    private int orderDis;
    private String patternId;
    private String text;
    private String type;

    public long getLastUpdTime() {
        return this.lastUpdTime;
    }

    public String getName() {
        return this.name;
    }

    public int getOrderDis() {
        return this.orderDis;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public String getText() {
        return this.text;
    }

    public String getType() {
        return this.type;
    }

    public boolean isAnony() {
        return this.isAnony;
    }

    public void setAnony(boolean z) {
        this.isAnony = z;
    }

    public void setLastUpdTime(long j) {
        this.lastUpdTime = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOrderDis(int i) {
        this.orderDis = i;
    }

    public void setPatternId(String str) {
        this.patternId = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
