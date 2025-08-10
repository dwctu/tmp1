package com.wear.bean.socketio.controlLink.response;

import com.wear.bean.socketio.chatBase.BaseChatResponseBean;

/* loaded from: classes3.dex */
public class ControlLinkPermissionResponse extends BaseChatResponseBean {
    private String linkId;
    private String linkPermissionType;
    private String operationType;

    public String getLinkId() {
        return this.linkId;
    }

    public String getLinkPermissionType() {
        return this.linkPermissionType;
    }

    public String getOperationType() {
        return this.operationType;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setLinkPermissionType(String str) {
        this.linkPermissionType = str;
    }

    public void setOperationType(String str) {
        this.operationType = str;
    }
}
