package org.jivesoftware.smackx.disco.bean.response;

import com.wear.bean.GroupMember;
import java.util.List;

/* loaded from: classes5.dex */
public class ResponseRoomMembers extends BaseResponse {
    private Object data;
    private List<RoomsBean> rooms;

    public static class RoomsBean {
        private String roomId;
        private List<GroupMember> users;

        public String getRoomId() {
            return this.roomId;
        }

        public List<GroupMember> getUsers() {
            return this.users;
        }

        public void setRoomId(String str) {
            this.roomId = str;
        }

        public void setUsers(List<GroupMember> list) {
            this.users = list;
        }
    }

    public Object getData() {
        return this.data;
    }

    public List<RoomsBean> getRooms() {
        return this.rooms;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setRooms(List<RoomsBean> list) {
        this.rooms = list;
    }
}
