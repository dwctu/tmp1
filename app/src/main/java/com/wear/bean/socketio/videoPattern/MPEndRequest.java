package com.wear.bean.socketio.videoPattern;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;
import com.wear.bean.socketio.msg.ApiClassAnnotation;

@ApiClassAnnotation(cls = String.class)
/* loaded from: classes3.dex */
public class MPEndRequest extends BaseAckRequestBean {
    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "mp_app_end_ts";
    }
}
