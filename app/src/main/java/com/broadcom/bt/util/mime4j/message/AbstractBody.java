package com.broadcom.bt.util.mime4j.message;

/* loaded from: classes.dex */
public abstract class AbstractBody implements Body {
    private Entity parent = null;

    @Override // com.broadcom.bt.util.mime4j.message.Body
    public Entity getParent() {
        return this.parent;
    }

    @Override // com.broadcom.bt.util.mime4j.message.Body
    public void setParent(Entity entity) {
        this.parent = entity;
    }
}
