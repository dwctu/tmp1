package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

/* loaded from: classes.dex */
public class InventoryDestination implements Serializable {
    private InventoryS3BucketDestination s3BucketDestination;

    public void a(InventoryS3BucketDestination inventoryS3BucketDestination) {
        this.s3BucketDestination = inventoryS3BucketDestination;
    }
}
