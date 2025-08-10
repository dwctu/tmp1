package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_account_setting")
/* loaded from: classes3.dex */
public class AccountSetting extends BaseEntity {

    @DatabaseField
    private boolean isTip;

    @DatabaseField
    private String userId;

    @DatabaseField
    private String version;

    public String getOldUserId() {
        return this.userId;
    }

    public String getUserId() {
        String strF = nd3.f(this.userId);
        return WearUtils.e1(strF) ? this.userId : strF;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isTip() {
        return this.isTip;
    }

    public void setTip(boolean z) {
        this.isTip = z;
    }

    public void setUserId(String str) {
        this.userId = nd3.p(str);
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
