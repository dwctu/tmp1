package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class ListBucketInventoryConfigurationsResult implements Serializable {
    private String continuationToken;
    private List<InventoryConfiguration> inventoryConfigurationList;
    private boolean isTruncated;
    private String nextContinuationToken;

    public List<InventoryConfiguration> a() {
        return this.inventoryConfigurationList;
    }

    public void b(String str) {
        this.continuationToken = str;
    }

    public void c(List<InventoryConfiguration> list) {
        this.inventoryConfigurationList = list;
    }

    public void d(String str) {
        this.nextContinuationToken = str;
    }

    public void e(boolean z) {
        this.isTruncated = z;
    }
}
