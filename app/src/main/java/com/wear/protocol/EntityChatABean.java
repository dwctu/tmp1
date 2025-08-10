package com.wear.protocol;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class EntityChatABean implements Serializable {
    public String jid;
    public String nickName;

    public String getJid() {
        return this.jid;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setJid(String str) {
        this.jid = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }
}
