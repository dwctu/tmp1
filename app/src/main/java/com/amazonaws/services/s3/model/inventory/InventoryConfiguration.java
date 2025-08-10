package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class InventoryConfiguration implements Serializable {
    private InventoryDestination destination;
    private String id;
    private String includedObjectVersions;
    private InventoryFilter inventoryFilter;
    private Boolean isEnabled;
    private List<String> optionalFields;
    private InventorySchedule schedule;

    public void a(InventoryDestination inventoryDestination) {
        this.destination = inventoryDestination;
    }

    public void b(Boolean bool) {
        this.isEnabled = bool;
    }

    public void c(String str) {
        this.id = str;
    }

    public void d(String str) {
        this.includedObjectVersions = str;
    }

    public void e(InventoryFilter inventoryFilter) {
        this.inventoryFilter = inventoryFilter;
    }

    public void f(List<String> list) {
        this.optionalFields = list;
    }

    public void g(InventorySchedule inventorySchedule) {
        this.schedule = inventorySchedule;
    }
}
