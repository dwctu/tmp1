package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_msg_unread")
/* loaded from: classes3.dex */
public class MessageUnRead extends BaseEntity {

    @DatabaseField
    private String friendJid;

    @DatabaseField
    private String ownerJid;

    public String getFriendJid() {
        String strF = nd3.f(this.friendJid);
        return WearUtils.e1(strF) ? this.friendJid : strF;
    }

    public String getOldFriendJid() {
        return this.friendJid;
    }

    public String getOldOwnerJid() {
        return this.ownerJid;
    }

    public String getOwnerJid() {
        String strF = nd3.f(this.ownerJid);
        return WearUtils.e1(strF) ? this.ownerJid : strF;
    }

    public void setFriendJid(String str) {
        this.friendJid = nd3.p(str);
    }

    public void setOwnerJid(String str) {
        this.ownerJid = nd3.p(str);
    }
}
