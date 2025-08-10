package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_account")
/* loaded from: classes3.dex */
public class NewAccountBean extends BaseEntity {

    @DatabaseField
    private String email;

    @DatabaseField
    private String remoteAccountId;

    public String getEmail() {
        return this.email;
    }

    public String getRemoteAccountId() {
        return this.remoteAccountId;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setRemoteAccountId(String str) {
        this.remoteAccountId = str;
    }
}
