package com.wear.bean.server.bean;

import com.wear.bean.server.base.BaseResponse;
import com.wear.bean.server.base.MessageType;
import dc.pf2;
import dc.qf2;

/* loaded from: classes3.dex */
public class G040Bean extends BaseResponse<NullBean> implements pf2 {
    public String type = MessageType.G040;

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.wear.bean.server.bean.NullBean] */
    public G040Bean() {
        this.data = new NullBean();
    }

    @Override // dc.pf2
    public String getAction() {
        return "ShakeVR";
    }

    @Override // com.wear.bean.server.base.BaseResponse, dc.m32
    public void handler(String str, qf2 qf2Var, Object obj) {
    }
}
