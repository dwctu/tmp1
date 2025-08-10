package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_re_call")
/* loaded from: classes3.dex */
public class ReCall extends BaseEntity {

    @DatabaseField
    private int canBe = 0;

    @DatabaseField
    private int flag = 0;

    @DatabaseField
    private String msgId;

    public int getCanBe() {
        return this.canBe;
    }

    public int getFlag() {
        return this.flag;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public void setCanBe(int i) {
        this.canBe = i;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }
}
