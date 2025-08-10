package com.wear.protocol;

import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class EntityBurnPicture extends EntityPicture {
    public boolean isBurn;

    public EntityBurnPicture() {
        setMsgId(WearUtils.E());
    }

    @Override // com.wear.protocol.EntityPicture, com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.burnpicture;
    }

    public boolean isBurn() {
        return this.isBurn;
    }

    public void setBurn(boolean z) {
        this.isBurn = z;
    }

    public EntityBurnPicture(String str) {
        EntityBurnPicture entityBurnPicture = (EntityBurnPicture) fromJsonToDecrypt(str, EntityBurnPicture.class);
        this.url = entityBurnPicture.getUrl();
        this.w = entityBurnPicture.getW();
        this.h = entityBurnPicture.getH();
        this.type = entityBurnPicture.getType();
        this.fileMd5 = entityBurnPicture.getFileMd5();
        this.msgId = entityBurnPicture.getMsgId();
        this.localUrl = entityBurnPicture.getLocalUrl();
        this.isBurn = entityBurnPicture.isBurn();
    }
}
