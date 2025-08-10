package org.jivesoftware.smackx.disco.bean.request;

import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "message#read")
/* loaded from: classes5.dex */
public class RequestMessageRead {
    private String msgId;
    private String roomId;

    public RequestMessageRead(String str, String str2) {
        this.roomId = str;
        this.msgId = str2;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }
}
