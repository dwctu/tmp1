package org.jivesoftware.smackx.disco.bean.request;

import java.util.List;
import org.jivesoftware.smackx.disco.bean.ApiAnnotation;

@ApiAnnotation(api = "room#list")
/* loaded from: classes5.dex */
public class RequestRoomList {
    private List<String> roomId;

    public List<String> getRoomId() {
        return this.roomId;
    }

    public void setRoomId(List<String> list) {
        this.roomId = list;
    }
}
