package com.wear.protocol;

/* loaded from: classes3.dex */
public abstract class EntityControl extends DataEntityAbstract implements HandleListener {
    public String id;

    public String getId() {
        return this.id;
    }

    public abstract String getOPTType();

    public void setId(String str) {
        this.id = str;
    }
}
