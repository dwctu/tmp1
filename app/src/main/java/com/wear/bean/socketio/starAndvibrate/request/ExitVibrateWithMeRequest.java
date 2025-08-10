package com.wear.bean.socketio.starAndvibrate.request;

import com.wear.bean.socketio.AckBaseRequest;

/* loaded from: classes3.dex */
public class ExitVibrateWithMeRequest extends AckBaseRequest {
    private String modelId;

    @Override // com.wear.bean.socketio.AckBaseRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "exitVibrateWithMe";
    }

    public String getModelId() {
        return this.modelId;
    }

    public void setModelId(String str) {
        this.modelId = str;
    }
}
