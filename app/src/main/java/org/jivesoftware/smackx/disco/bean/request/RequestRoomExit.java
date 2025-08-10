package org.jivesoftware.smackx.disco.bean.request;

import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "room#exit")
/* loaded from: classes5.dex */
public class RequestRoomExit {
    private String roomId;
    private int status;

    public String getRoomId() {
        return this.roomId;
    }

    public int getStatus() {
        return this.status;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
