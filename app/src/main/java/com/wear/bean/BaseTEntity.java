package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import java.io.Serializable;
import java.util.Date;

/* loaded from: classes3.dex */
public abstract class BaseTEntity implements Serializable {

    @DatabaseField
    private Date created;

    @DatabaseField(id = true)
    private String id;

    @DatabaseField
    private boolean isEncrypt;

    public Date getCreated() {
        if (this.created == null) {
            setCreated(new Date());
        }
        return this.created;
    }

    public String getId() {
        return this.id;
    }

    public boolean isEncrypt() {
        return this.isEncrypt;
    }

    public void setCreated(Date date) {
        this.created = date;
    }

    public void setEncrypt(boolean z) {
        this.isEncrypt = z;
    }

    public void setId(String str) {
        this.id = str;
        if (this.created == null) {
            setCreated(new Date());
        }
    }
}
