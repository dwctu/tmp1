package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_switch_values")
/* loaded from: classes3.dex */
public class SwitchBean extends BaseEntity {

    @DatabaseField
    private int key;

    @DatabaseField
    private String owner;

    @DatabaseField
    private String values;

    public interface ToEntity {
        void decode(boolean z);

        Object getEntity();

        void setValues(String str);

        void update2Db();
    }

    public int getKey() {
        return this.key;
    }

    public String getOldOwner() {
        return this.owner;
    }

    public String getOwner() {
        String strF = nd3.f(this.owner);
        return WearUtils.e1(strF) ? this.owner : strF;
    }

    public String getValues() {
        return this.values;
    }

    public void setKey(int i) {
        this.key = i;
    }

    public void setOwner(String str) {
        this.owner = nd3.p(str);
    }

    public void setValues(String str) {
        this.values = str;
    }
}
