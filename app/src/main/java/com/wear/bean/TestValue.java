package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_test_values")
/* loaded from: classes3.dex */
public class TestValue extends BaseEntity {

    @DatabaseField
    private String key;

    @DatabaseField
    private String type;

    @DatabaseField
    private String value;

    public String getKey() {
        return this.key;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
