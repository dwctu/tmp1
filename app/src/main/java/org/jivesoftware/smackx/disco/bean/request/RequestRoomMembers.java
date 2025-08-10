package org.jivesoftware.smackx.disco.bean.request;

import java.util.List;
import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "room#members")
/* loaded from: classes5.dex */
public class RequestRoomMembers {
    private List<String> roomIds;

    public List<String> getRoomIds() {
        return this.roomIds;
    }

    public void setRoomIds(List<String> list) {
        this.roomIds = list;
    }
}
