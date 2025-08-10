package org.jivesoftware.smackx.disco.bean.request;

import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "room#controller#sub")
/* loaded from: classes5.dex */
public class RequestRoomControllerSub {
    private String roomId;
    private int subType;

    public String getRoomId() {
        return this.roomId;
    }

    public int getSubType() {
        return this.subType;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setSubType(int i) {
        this.subType = i;
    }
}
