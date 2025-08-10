package org.jivesoftware.smackx.disco.bean.request;

import java.util.List;
import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "room#create")
/* loaded from: classes5.dex */
public class RequestCreateChatRoom {
    private List<InviteBean> invite;
    private int newAppVersion;
    private String roomName;

    public List<InviteBean> getInvite() {
        return this.invite;
    }

    public int getNewAppVersion() {
        return this.newAppVersion;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setInvite(List<InviteBean> list) {
        this.invite = list;
    }

    public void setNewAppVersion(int i) {
        this.newAppVersion = i;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }
}
