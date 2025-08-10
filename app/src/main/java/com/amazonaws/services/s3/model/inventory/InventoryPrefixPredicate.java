package com.amazonaws.services.s3.model.inventory;

/* loaded from: classes.dex */
public final class InventoryPrefixPredicate extends InventoryFilterPredicate {
    private final String prefix;

    public InventoryPrefixPredicate(String str) {
        this.prefix = str;
    }
}
