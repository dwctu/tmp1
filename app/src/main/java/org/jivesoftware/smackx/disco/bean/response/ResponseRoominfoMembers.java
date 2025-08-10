package org.jivesoftware.smackx.disco.bean.response;

import com.wear.bean.GroupMember;
import java.util.List;

/* loaded from: classes5.dex */
public class ResponseRoominfoMembers extends BaseResponse {
    private DataBean data;

    public static class DataBean {
        private Room room;
        private List<GroupMember> users;

        public Room getRoom() {
            return this.room;
        }

        public List<GroupMember> getUsers() {
            return this.users;
        }

        public void setRoom(Room room) {
            this.room = room;
        }

        public void setUsers(List<GroupMember> list) {
            this.users = list;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }
}
