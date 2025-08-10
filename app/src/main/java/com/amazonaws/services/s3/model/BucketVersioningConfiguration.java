package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class BucketVersioningConfiguration implements Serializable {
    private Boolean isMfaDeleteEnabled = null;
    private String status;

    public BucketVersioningConfiguration() {
        b("Off");
    }

    public void a(Boolean bool) {
        this.isMfaDeleteEnabled = bool;
    }

    public void b(String str) {
        this.status = str;
    }
}
