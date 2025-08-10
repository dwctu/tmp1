package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_toy_pin")
/* loaded from: classes3.dex */
public class ToyPinStatusBean extends BaseEntity {

    @DatabaseField
    private String address;

    @DatabaseField
    private int type;

    @DatabaseField
    private long updateTime;

    public ToyPinStatusBean(String str, int i) {
        this.address = str;
        this.type = i;
    }

    public String getAddress() {
        return this.address;
    }

    public int getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public ToyPinStatusBean() {
    }
}
