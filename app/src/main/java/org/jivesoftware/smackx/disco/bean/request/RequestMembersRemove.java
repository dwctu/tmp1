package org.jivesoftware.smackx.disco.bean.request;

import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "members#remove")
/* loaded from: classes5.dex */
public class RequestMembersRemove {
    private String jid;
    private String roomId;
    private int type;

    public String getJid() {
        return this.jid;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public int getType() {
        return this.type;
    }

    public void setJid(String str) {
        this.jid = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
