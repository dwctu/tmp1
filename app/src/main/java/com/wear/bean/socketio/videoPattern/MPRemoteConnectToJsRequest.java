package com.wear.bean.socketio.videoPattern;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;
import com.wear.bean.socketio.msg.ApiClassAnnotation;

@ApiClassAnnotation(cls = String.class)
/* loaded from: classes3.dex */
public class MPRemoteConnectToJsRequest extends BaseAckRequestBean {
    private String jsSessionCode;

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "mp_remote_connect_to_js_ts";
    }

    public String getJsSessionCode() {
        return this.jsSessionCode;
    }

    public void setJsSessionCode(String str) {
        this.jsSessionCode = str;
    }
}
