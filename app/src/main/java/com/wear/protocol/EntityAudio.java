package com.wear.protocol;

import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class EntityAudio extends DataEntityAbstract {
    public boolean isExpired;
    public String localUrl;
    public String msgId;
    public long time;
    public String url;

    public EntityAudio() {
        setMsgId(WearUtils.E());
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.audio;
    }

    public String getLocalUrl() {
        return this.localUrl;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public long getTime() {
        return this.time;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isExpired() {
        return this.isExpired;
    }

    public void setExpired(boolean z) {
        this.isExpired = z;
    }

    public void setLocalUrl(String str) {
        this.localUrl = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public EntityAudio(String str) {
        EntityAudio entityAudio = (EntityAudio) fromJsonToDecrypt(str, EntityAudio.class);
        this.url = entityAudio.getUrl();
        this.time = entityAudio.getTime();
        this.msgId = entityAudio.getMsgId();
        this.localUrl = entityAudio.getLocalUrl();
        this.isExpired = entityAudio.isExpired();
    }
}
