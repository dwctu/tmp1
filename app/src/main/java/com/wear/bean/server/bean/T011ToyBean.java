package com.wear.bean.server.bean;

import com.wear.bean.server.base.BaseResponse;
import com.wear.bean.server.base.MessageType;
import dc.pf2;
import dc.qf2;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class T011ToyBean extends BaseResponse<HashMap<String, ToyBean>> implements pf2 {
    public String type = MessageType.T011;

    @Override // dc.pf2
    public String getAction() {
        return "ToysInfoVR";
    }

    @Override // com.wear.bean.server.base.BaseResponse, dc.m32
    public void handler(String str, qf2 qf2Var, Object obj) {
    }
}
