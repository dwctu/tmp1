package com.wear.bean.socketio.videoPattern;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;
import com.wear.bean.socketio.msg.ApiClassAnnotation;

@ApiClassAnnotation(cls = String.class)
/* loaded from: classes3.dex */
public class MPRemoteReceivedFileRequest extends BaseAckRequestBean {
    private String colaId;
    private String fileName;

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "mp_app_was_received_from_js_api_pattern_file_ts";
    }

    public String getColaId() {
        return this.colaId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setColaId(String str) {
        this.colaId = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }
}
