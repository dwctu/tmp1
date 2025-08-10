package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

/* loaded from: classes.dex */
public class InventorySchedule implements Serializable {
    private String frequency;

    public void a(String str) {
        this.frequency = str;
    }
}
