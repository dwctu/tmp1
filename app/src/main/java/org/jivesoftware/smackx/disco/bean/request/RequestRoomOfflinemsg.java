package org.jivesoftware.smackx.disco.bean.request;

import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "room#offlinemsg")
/* loaded from: classes5.dex */
public class RequestRoomOfflinemsg {
    private String msgId;
    private String roomId;
    private Integer size;
    private Long time;

    public String getMsgId() {
        return this.msgId;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public Integer getSize() {
        return this.size;
    }

    public Long getTime() {
        return this.time;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setSize(Integer num) {
        this.size = num;
    }

    public void setTime(Long l) {
        this.time = l;
    }
}
