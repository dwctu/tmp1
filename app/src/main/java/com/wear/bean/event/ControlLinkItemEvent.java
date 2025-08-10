package com.wear.bean.event;

import com.wear.bean.socketio.controlLink.response.ControlLinkListResponse;

/* loaded from: classes3.dex */
public class ControlLinkItemEvent {
    public static String tag = "controlLink";
    public ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO item;

    public ControlLinkItemEvent(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
        this.item = longTimeControlLinkListDTO;
    }
}
