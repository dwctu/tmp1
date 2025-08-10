package com.wear.bean.server.bean;

import com.wear.bean.server.base.BaseResponse;
import com.wear.bean.server.base.MessageType;
import dc.qf2;
import dc.r32;

/* loaded from: classes3.dex */
public class T010ToyBean extends BaseResponse<String> {
    public String type = MessageType.T010;

    @Override // com.wear.bean.server.base.BaseResponse, dc.m32
    public void handler(String str, qf2 qf2Var, Object obj) {
        r32.l().t(str, qf2Var);
    }
}
