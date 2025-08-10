package org.jivesoftware.smackx.disco.bean.request;

import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "message#record")
/* loaded from: classes5.dex */
public class RequestMessageRecord {
    private String msgId;
    private String roomId;
    private int type;

    public RequestMessageRecord(String str, String str2, int i) {
        this.roomId = str;
        this.msgId = str2;
        this.type = i;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public int getType() {
        return this.type;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
