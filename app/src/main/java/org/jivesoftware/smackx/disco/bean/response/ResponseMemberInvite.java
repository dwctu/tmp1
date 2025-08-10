package org.jivesoftware.smackx.disco.bean.response;

import java.util.List;

/* loaded from: classes5.dex */
public class ResponseMemberInvite extends BaseResponse {
    private Object data;
    private String roomId;
    private List<UserBean> user;

    public static class UserBean {
        private String jid;
        private String resultType;

        public String getJid() {
            return this.jid;
        }

        public String getResultType() {
            return this.resultType;
        }

        public void setJid(String str) {
            this.jid = str;
        }

        public void setResultType(String str) {
            this.resultType = str;
        }
    }

    public Object getData() {
        return this.data;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public List<UserBean> getUser() {
        return this.user;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setUser(List<UserBean> list) {
        this.user = list;
    }
}
