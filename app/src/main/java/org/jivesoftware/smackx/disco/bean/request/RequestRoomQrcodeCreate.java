package org.jivesoftware.smackx.disco.bean.request;

import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "room#qrcode#create")
/* loaded from: classes5.dex */
public class RequestRoomQrcodeCreate {
    private int fromType;
    private String photoUrl;
    private String roomId;
    private String roomName;
    private int type;
    private String url;

    public int getFromType() {
        return this.fromType;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setFromType(int i) {
        this.fromType = i;
    }

    public void setPhotoUrl(String str) {
        this.photoUrl = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
