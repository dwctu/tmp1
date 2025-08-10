package com.wear.bean.event;

import org.jivesoftware.smackx.disco.bean.response.ResponseRoomSettingInfo;

/* loaded from: classes3.dex */
public class GroupInvitationSettingEvent {
    public ResponseRoomSettingInfo responseRoomSettingInfo;
    public String roomId;
    public boolean suc;

    public GroupInvitationSettingEvent(String str, boolean z) {
        this.roomId = str;
        this.suc = z;
    }
}
