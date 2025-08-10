package com.wear.bean.socketio.starAndvibrate.request;

import com.wear.bean.socketio.AckBaseRequest;
import java.util.List;

/* loaded from: classes3.dex */
public class JoinTipperCtrlRequest extends AckBaseRequest {
    private String customerName;
    private String modelEmail;
    private String modelName;
    private String pf;
    private int toyNum;
    private List<String> toyTypes;

    @Override // com.wear.bean.socketio.AckBaseRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "takcon_scan_join_game_ts";
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getModelEmail() {
        return this.modelEmail;
    }

    public String getModelName() {
        return this.modelName;
    }

    public String getPf() {
        return this.pf;
    }

    public int getToyNum() {
        return this.toyNum;
    }

    public List<String> getToyTypes() {
        return this.toyTypes;
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

    public void setToyNum(int i) {
        this.toyNum = i;
    }

    public void setToyTypes(List<String> list) {
        this.toyTypes = list;
    }
}
