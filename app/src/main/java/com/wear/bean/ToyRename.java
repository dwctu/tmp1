package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_toy_rename")
/* loaded from: classes3.dex */
public class ToyRename extends BaseEntity {

    @DatabaseField
    private String address;

    @DatabaseField
    private String email;

    @DatabaseField
    private String formApp;

    @DatabaseField
    private String name;

    @DatabaseField
    private long updateTime;

    public ToyRename() {
        setId(WearUtils.E());
    }

    public String getAddress() {
        return this.address;
    }

    public String getEmail() {
        String strF = nd3.f(this.email);
        return WearUtils.e1(strF) ? this.email : strF;
    }

    public String getFormApp() {
        return this.formApp;
    }

    public String getName() {
        return this.name;
    }

    public String getOldEmail() {
        return this.email;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setEmail(String str) {
        this.email = nd3.p(str);
    }

    public void setFormApp(String str) {
        this.formApp = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }
}
