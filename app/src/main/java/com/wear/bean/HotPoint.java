package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_hot_point")
/* loaded from: classes3.dex */
public class HotPoint extends BaseEntity {

    @DatabaseField
    private int appVersionCode;

    @DatabaseField
    private Boolean isPressed;

    @DatabaseField
    private String owner;

    @DatabaseField
    private String resId;

    public HotPoint() {
        setId(WearUtils.E());
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public String getOldOwner() {
        return this.owner;
    }

    public String getOwner() {
        String strF = nd3.f(this.owner);
        return WearUtils.e1(strF) ? this.owner : strF;
    }

    public Boolean getPressed() {
        return this.isPressed;
    }

    public String getResId() {
        return this.resId;
    }

    public void setAppVersionCode(int i) {
        this.appVersionCode = i;
    }

    public void setOwner(String str) {
        this.owner = nd3.p(str);
    }

    public void setPressed(Boolean bool) {
        this.isPressed = bool;
    }

    public void setResId(String str) {
        this.resId = str;
    }
}
