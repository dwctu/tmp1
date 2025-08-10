package org.jivesoftware.smackx.disco.bean.request;

import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "room#settinginfo")
/* loaded from: classes5.dex */
public class RequestRoomSettingInfo {
    private String roomId;

    public String getRoomId() {
        return this.roomId;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }
}
