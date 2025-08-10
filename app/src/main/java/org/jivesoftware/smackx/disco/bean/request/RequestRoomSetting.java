package org.jivesoftware.smackx.disco.bean.request;

import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "room#setting")
/* loaded from: classes5.dex */
public class RequestRoomSetting {
    private String nickName;
    private String roomId;
    private String roomName;
    private String url;

    public String getNickName() {
        return this.nickName;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getUrl() {
        return this.url;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
