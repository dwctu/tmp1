package com.wear.bean;

import java.util.Date;

/* loaded from: classes3.dex */
public class ToyLastOrder {
    public long created = new Date().getTime();
    public String order;
    public String toyId;

    public ToyLastOrder(String str, String str2) {
        this.toyId = str;
        this.order = str2;
    }

    public long getCreated() {
        return this.created;
    }

    public String getOrder() {
        return this.order;
    }

    public String getToyId() {
        return this.toyId;
    }
}
