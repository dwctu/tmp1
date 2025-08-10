package com.wear.bean.socketio.msg.reuqest;

/* loaded from: classes3.dex */
public class SetLdrToyTypeRequest extends BaseGroupControlRequest {
    private String toyType;

    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "setLdrToyType";
    }

    public String getToyType() {
        return this.toyType;
    }

    public void setToyType(String str) {
        this.toyType = str;
    }
}
