package com.wear.bean.socketio.controlLink.response;

import com.wear.bean.socketio.chatBase.BaseChatResponseBean;

/* loaded from: classes3.dex */
public class AddTimeResponse extends BaseChatResponseBean {
    private String linkId;
    private boolean result;

    public String getLinkId() {
        return this.linkId;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }
}
