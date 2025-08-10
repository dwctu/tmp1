package com.wear.bean.socketio.controlLink.request;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;

/* loaded from: classes3.dex */
public class PageStatusRequest extends BaseAckRequestBean {
    private String appExStr;
    private String appPage;
    private String pepsiId;

    public PageStatusRequest(String str, String str2) {
        this.pepsiId = str;
        this.appPage = str2;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "app_open_this_page_now_ts";
    }

    public String getAppExStr() {
        return this.appExStr;
    }

    public String getAppPage() {
        return this.appPage;
    }

    public String getPepsiId() {
        return this.pepsiId;
    }

    public void setAppExStr(String str) {
        this.appExStr = str;
    }

    public void setAppPage(String str) {
        this.appPage = str;
    }

    public void setPepsiId(String str) {
        this.pepsiId = str;
    }

    public PageStatusRequest(String str, String str2, String str3) {
        this.pepsiId = str;
        this.appPage = str2;
        this.appExStr = str3;
    }
}
