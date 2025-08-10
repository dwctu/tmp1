package org.jivesoftware.smackx.disco.bean.response;

import com.wear.util.WearUtils;

/* loaded from: classes5.dex */
public class SubMessageBean extends BaseResponse {
    public static final String ROOM_DS_CHANGE = "room_ds_change";
    public static final String ROOM_DS_CREATE_WAIT_PLAYER = "room_ds_create_wait_player";
    public static final String ROOM_DS_CREATE_WAIT_TARGETER = "room_ds_create_wait_targeter";
    public static final String ROOM_DS_END = "room_ds_end";
    public static final String ROOM_DS_START = "room_ds_start";
    public static final String ROOM_PLAYER_STATUS_CHANGED = "RoomPlayerStatusChanged";
    public static final String ROOM_SYNC_CONTROL_ENDED = "RoomSyncControlEnded";
    public static final String ROOM_SYNC_CONTROL_START = "RoomSyncControlStart";
    public static final String user_enter_room_many2one = "user_enter_room_many2one";
    public static final String user_enter_room_one2many = "user_enter_room_one2many";
    private String action;
    private int controlType = 0;
    private Object data;

    public String getAction() {
        return this.action;
    }

    public int getControlType() {
        if (WearUtils.e1(this.action)) {
            this.controlType = 0;
            return 0;
        }
        String str = this.action;
        str.hashCode();
        switch (str) {
            case "RoomPlayerStatusChanged":
            case "user_enter_room_one2many":
            case "RoomSyncControlEnded":
            case "RoomSyncControlStart":
                this.controlType = 0;
                break;
            case "room_ds_create_wait_player":
            case "room_ds_create_wait_targeter":
            case "room_ds_end":
            case "room_ds_start":
            case "room_ds_change":
            case "user_enter_room_many2one":
                this.controlType = 1;
                break;
        }
        return this.controlType;
    }

    public Object getData() {
        return this.data;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setData(Object obj) {
        this.data = obj;
    }
}
