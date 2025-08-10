package com.wear.bean.socketio.controlLink.request;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;

/* loaded from: classes3.dex */
public class ControlPermissionRequest extends BaseAckRequestBean {
    private String ackId;
    private String linkId;
    private String linkPermissionType;
    private String operationType;

    public ControlPermissionRequest(String str, String str2, String str3, String str4) {
        this.ackId = str;
        this.linkId = str2;
        this.linkPermissionType = str3;
        this.operationType = str4;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean
    public String getAckId() {
        return this.ackId;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "cl_control_permission_request_ts";
    }

    public String getLinkId() {
        return this.linkId;
    }

    public String getLinkPermissionType() {
        return this.linkPermissionType;
    }

    public String getOperationType() {
        return this.operationType;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean
    public void setAckId(String str) {
        this.ackId = str;
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

    public ControlPermissionRequest() {
    }
}
