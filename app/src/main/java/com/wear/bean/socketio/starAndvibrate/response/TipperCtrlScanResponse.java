package com.wear.bean.socketio.starAndvibrate.response;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class TipperCtrlScanResponse {
    private String customerName;
    private String modelEmail;
    private String modelName;
    private String pf;

    public String getCustomerName() {
        return this.customerName;
    }

    public String getModelEmail() {
        return this.modelEmail;
    }

    public String getModelName() {
        return TextUtils.isEmpty(this.modelName) ? "" : this.modelName;
    }

    public String getPf() {
        return this.pf;
    }

    public void setCustomerName(String str) {
        this.customerName = str;
    }

    public void setModelEmail(String str) {
        this.modelEmail = str;
    }

    public void setModelName(String str) {
        this.modelName = str;
    }

    public void setPf(String str) {
        this.pf = str;
    }
}
