package org.jivesoftware.smackx.disco.bean.request;

import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "room#setpermission")
/* loaded from: classes5.dex */
public class RequestRoomSetpermission {
    private Integer memberCanInvite;
    private Integer needApproval;
    private String roomId;

    public Integer getMemberCanInvite() {
        return this.memberCanInvite;
    }

    public Integer getNeedApproval() {
        return this.needApproval;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setMemberCanInvite(Integer num) {
        this.memberCanInvite = num;
    }

    public void setNeedApproval(Integer num) {
        this.needApproval = num;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }
}
