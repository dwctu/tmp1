package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;

@DatabaseTable(tableName = "tb_toy_type")
/* loaded from: classes3.dex */
public class ToyType extends BaseEntity {

    @DatabaseField
    private String address;

    @DatabaseField
    private String type;

    @DatabaseField
    private Boolean autoLightOn = Boolean.TRUE;

    @DatabaseField
    private int aColor = 7;

    public ToyType() {
        setId(WearUtils.E());
    }

    public String getAddress() {
        return this.address;
    }

    public Boolean getAutoLightOn() {
        return this.autoLightOn;
    }

    public String getType() {
        return this.type;
    }

    public int getaColor() {
        return this.aColor;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAutoLightOn(Boolean bool) {
        this.autoLightOn = bool;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setaColor(int i) {
        this.aColor = i;
    }
}
