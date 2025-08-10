package com.wear.bean.socketio.date.request;

import dc.pf2;
import java.util.List;

/* loaded from: classes3.dex */
public class AppToyTsBean implements pf2 {
    public List<AppToyBean> list;

    @Override // dc.pf2
    public String getAction() {
        return "app_toy_ts";
    }

    public void setList(List<AppToyBean> list) {
        this.list = list;
    }
}
