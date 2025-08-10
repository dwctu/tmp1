package org.jivesoftware.smackx.disco.bean.request;

import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "room#invitationlist")
/* loaded from: classes5.dex */
public class RequestRoomInvitationList {
    private String roomId;

    public String getRoomId() {
        return this.roomId;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }
}
