package org.jivesoftware.smackx.disco.bean.response;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class ResponseRoomSettingInfo extends BaseResponse implements Serializable {
    private Object data;
    private RoomBean room;

    public static class RoomBean {
        private int memberCanInvite;
        private int needApproval;
        private String nickName;
        private String roomId;
        private String roomName;
        private int status;
        private String url;

        public int getMemberCanInvite() {
            return this.memberCanInvite;
        }

        public int getNeedApproval() {
            return this.needApproval;
        }

        public String getNickName() {
            return this.nickName;
        }

        public String getRoomId() {
            return this.roomId;
        }

        public String getRoomName() {
            return this.roomName;
        }

        public int getStatus() {
            return this.status;
        }

        public String getUrl() {
            return this.url;
        }

        public void setMemberCanInvite(int i) {
            this.memberCanInvite = i;
        }

        public void setNeedApproval(int i) {
            this.needApproval = i;
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

        public void setStatus(int i) {
            this.status = i;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public Object getData() {
        return this.data;
    }

    public RoomBean getRoom() {
        return this.room;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setRoom(RoomBean roomBean) {
        this.room = roomBean;
    }
}
