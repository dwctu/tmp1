package com.wear.bean.socketio;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.wear.util.WearUtils;
import dc.pf2;

/* loaded from: classes3.dex */
public abstract class BaseRequestBean implements pf2 {
    public String requestId;
    public boolean requestReceipt;
    public String requestType;
    public String userName;

    @Override // dc.pf2
    @JSONField(serialize = false)
    public abstract /* synthetic */ String getAction();

    public void needRequestReceipt() {
        this.requestReceipt = true;
        if (TextUtils.isEmpty(this.requestId)) {
            this.requestId = WearUtils.E();
            this.requestType = "server";
        }
    }
}
