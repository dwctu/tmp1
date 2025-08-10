package com.wear.bean.socketio.starAndvibrate.request;

import com.wear.bean.socketio.AckBaseRequest;

/* loaded from: classes3.dex */
public class JoinVibrateWithMeRequest extends AckBaseRequest {
    private String cName;
    private String code;
    private String modelId;
    private String modelName;
    private String pf;

    @Override // com.wear.bean.socketio.AckBaseRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "joinVibrateWithMe";
    }

    public String getCode() {
        return this.code;
    }

    public String getModelId() {
        return this.modelId;
    }

    public String getModelName() {
        return this.modelName;
    }

    public String getPf() {
        return this.pf;
    }

    public String getcName() {
        return this.cName;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setModelId(String str) {
        this.modelId = str;
    }

    public void setModelName(String str) {
        this.modelName = str;
    }

    public void setPf(String str) {
        this.pf = str;
    }

    public void setcName(String str) {
        this.cName = str;
    }
}
