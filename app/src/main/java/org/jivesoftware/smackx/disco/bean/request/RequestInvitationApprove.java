package org.jivesoftware.smackx.disco.bean.request;

import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "invitation#approve")
/* loaded from: classes5.dex */
public class RequestInvitationApprove {
    private int approval;
    private String jid;
    private String roomId;

    public int getApproval() {
        return this.approval;
    }

    public String getJid() {
        return this.jid;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setApproval(int i) {
        this.approval = i;
    }

    public void setJid(String str) {
        this.jid = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }
}
