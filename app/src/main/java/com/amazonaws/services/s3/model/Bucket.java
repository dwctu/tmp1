package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class Bucket implements Serializable {
    private static final long serialVersionUID = -8646831898339939580L;
    private String name = null;
    private Owner owner = null;
    private Date creationDate = null;

    public Date a() {
        return this.creationDate;
    }

    public Owner b() {
        return this.owner;
    }

    public void c(Date date) {
        this.creationDate = date;
    }

    public void d(String str) {
        this.name = str;
    }

    public void e(Owner owner) {
        this.owner = owner;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "S3Bucket [name=" + getName() + ", creationDate=" + a() + ", owner=" + b() + "]";
    }
}
