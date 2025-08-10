package com.wear.bean.socketio.date.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.wear.bean.socketio.BaseRequestBean;

/* loaded from: classes3.dex */
public abstract class DateBean extends BaseRequestBean {
    @Override // com.wear.bean.socketio.BaseRequestBean, dc.pf2
    @JSONField(serialize = false)
    public abstract /* synthetic */ String getAction();
}
