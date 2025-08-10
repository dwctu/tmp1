package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

/* loaded from: classes.dex */
public class InventoryS3BucketDestination implements Serializable {
    private String accountId;
    private String bucketArn;
    private String format;
    private String prefix;

    public void a(String str) {
        this.accountId = str;
    }

    public void b(String str) {
        this.bucketArn = str;
    }

    public void c(String str) {
        this.format = str;
    }

    public void d(String str) {
        this.prefix = str;
    }
}
