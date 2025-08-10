package org.jivesoftware.smackx.disco.bean.response;

import java.util.List;

/* loaded from: classes5.dex */
public class ResponseRoomList extends BaseResponse {
    private List<Room> rooms;

    public List<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(List<Room> list) {
        this.rooms = list;
    }
}
