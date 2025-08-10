package org.jivesoftware.smackx.disco.bean.response;

import com.wear.bean.handlerbean.IGroupMember;
import com.wear.util.WearUtils;
import java.util.List;

/* loaded from: classes5.dex */
public class ResponseRoomInvitationList extends BaseResponse {
    private Object data;
    private List<InvitationListBean> invitationList;

    public static class InvitationListBean implements IGroupMember {
        private String invitedBy;
        private String jid;
        private String nickName;
        private String photo;
        private String time;
        private int type;

        @Override // com.wear.bean.handlerbean.IGroupMember, com.wear.bean.handlerbean.IPeopleInfo, com.wear.bean.handlerbean.IContactInfo
        public String getAvatar() {
            return getPhoto();
        }

        @Override // com.wear.bean.handlerbean.IGroupPeopleInfo
        public long getEnterTime() {
            return 0L;
        }

        @Override // com.wear.bean.handlerbean.IGroupMember, com.wear.bean.handlerbean.IPeopleInfo
        public String getId() {
            return WearUtils.g0(getJid());
        }

        public String getInvitedBy() {
            return this.invitedBy;
        }

        public String getJid() {
            return this.jid;
        }

        @Override // com.wear.bean.handlerbean.IGroupMember
        public String getNickName() {
            return this.nickName;
        }

        public String getPhoto() {
            return this.photo;
        }

        @Override // com.wear.bean.handlerbean.IItemType
        public int getTempViewType() {
            return 1;
        }

        public String getTime() {
            return this.time;
        }

        public int getType() {
            return this.type;
        }

        @Override // com.wear.bean.handlerbean.IGroupPeopleInfo, com.wear.bean.handlerbean.IPeopleInfo
        public String getUserName() {
            return null;
        }

        @Override // com.wear.bean.handlerbean.IGroupMember, com.wear.bean.handlerbean.IGroupPeopleInfo
        public boolean isAdmin() {
            return false;
        }

        @Override // com.wear.bean.handlerbean.IGroupMember, com.wear.bean.handlerbean.IGroupPeopleInfo
        public boolean isOwrn() {
            return false;
        }

        public void setInvitedBy(String str) {
            this.invitedBy = str;
        }

        public void setJid(String str) {
            this.jid = str;
        }

        public void setNickName(String str) {
            this.nickName = str;
        }

        @Override // com.wear.bean.handlerbean.IGroupMember
        public void setPermission(int i) {
        }

        public void setPhoto(String str) {
            this.photo = str;
        }

        public void setTime(String str) {
            this.time = str;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    public Object getData() {
        return this.data;
    }

    public List<InvitationListBean> getInvitationList() {
        return this.invitationList;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setInvitationList(List<InvitationListBean> list) {
        this.invitationList = list;
    }
}
