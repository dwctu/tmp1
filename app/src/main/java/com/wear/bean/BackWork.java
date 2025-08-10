package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_back_work")
/* loaded from: classes3.dex */
public class BackWork extends BaseEntity {

    @DatabaseField
    private String owner;

    @DatabaseField
    private String staticParams;

    @DatabaseField
    private String status;

    @DatabaseField
    private String targetEmail;

    @DatabaseField
    private String workId;

    public BackWork() {
        setId(WearUtils.E());
    }

    public String getOldOwner() {
        return this.owner;
    }

    public String getOldTargetEmail() {
        return this.targetEmail;
    }

    public String getOwner() {
        String strF = nd3.f(this.owner);
        return WearUtils.e1(strF) ? this.owner : strF;
    }

    public String getStaticParams() {
        return this.staticParams;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTargetEmail() {
        String strF = nd3.f(this.targetEmail);
        return WearUtils.e1(strF) ? this.targetEmail : strF;
    }

    public String getWorkId() {
        return this.workId;
    }

    public void setOwner(String str) {
        this.owner = nd3.p(str);
    }

    public void setStaticParams(String str) {
        this.staticParams = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTargetEmail(String str) {
        this.targetEmail = nd3.p(str);
    }

    public void setWorkId(String str) {
        this.workId = str;
    }
}
