package com.wear.bean.event;

import com.wear.bean.socketio.controlLink.response.ControlLinkListResponse;

/* loaded from: classes3.dex */
public class RefreshControlLinkList {
    private boolean isRefreshControl = false;
    private ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO;

    public ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO getLongTimeControlLinkListDTO() {
        return this.longTimeControlLinkListDTO;
    }

    public boolean isRefreshControl() {
        return this.isRefreshControl;
    }

    public void setLongTimeControlLinkListDTO(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
        this.longTimeControlLinkListDTO = longTimeControlLinkListDTO;
    }

    public void setRefreshControl(boolean z) {
        this.isRefreshControl = z;
    }
}
