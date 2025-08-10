package com.wear.bean.socketio.display;

import dc.pf2;
import java.util.List;

/* loaded from: classes3.dex */
public class ControlModelToyStatusBean implements pf2 {
    public List<ToyInfoBean> toyInfoList;

    @Override // dc.pf2
    public String getAction() {
        return "control_model_toy_status";
    }
}
