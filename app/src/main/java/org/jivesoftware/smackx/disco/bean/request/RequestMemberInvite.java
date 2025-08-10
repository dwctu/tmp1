package org.jivesoftware.smackx.disco.bean.request;

import java.util.List;
import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "member#invite")
/* loaded from: classes5.dex */
public class RequestMemberInvite {
    private List<InviteBean> invite;
    private String roomId;
    private int setAffiliation;

    public List<InviteBean> getInvite() {
        return this.invite;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public int getSetAffiliation() {
        return this.setAffiliation;
    }

    public void setInvite(List<InviteBean> list) {
        this.invite = list;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setSetAffiliation(int i) {
        this.setAffiliation = i;
    }
}
