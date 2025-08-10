package com.wear.bean.socketio.starAndvibrate.response;

/* loaded from: classes3.dex */
public class JoinTipperCtrlResponse {
    private int code;
    private TipperCtrlUpdateInfoRespone data;
    private String message;

    public int getCode() {
        return this.code;
    }

    public TipperCtrlUpdateInfoRespone getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(TipperCtrlUpdateInfoRespone tipperCtrlUpdateInfoRespone) {
        this.data = tipperCtrlUpdateInfoRespone;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
