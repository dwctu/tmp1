package com.wear.bean;

import android.text.TextUtils;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dc.ye3;
import java.util.Date;

@DatabaseTable(tableName = "tb_log_type")
/* loaded from: classes3.dex */
public class LogType extends BaseEntity {

    @DatabaseField
    private String content;

    @DatabaseField
    private boolean isEnforced;

    @DatabaseField
    private String logNo;

    @DatabaseField
    private String spid;

    @DatabaseField
    private String timestamp;

    @DatabaseField
    private String userId;

    public LogType() {
    }

    public String getContent() {
        return this.content;
    }

    public String getLogNo() {
        return this.logNo;
    }

    public String getSpid() {
        return this.spid;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isEnforced() {
        return this.isEnforced;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEnforced(boolean z) {
        this.isEnforced = z;
    }

    public void setLogNo(String str) {
        this.logNo = str;
    }

    public void setSpid(String str) {
        this.spid = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public LogType(String str, String str2) {
        this.logNo = str;
        this.content = str2;
        this.timestamp = System.currentTimeMillis() + "";
        this.spid = ye3.c;
        if (TextUtils.equals("A0030", str)) {
            this.isEnforced = true;
        }
        setCreated(new Date());
    }
}
