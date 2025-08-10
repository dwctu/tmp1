package com.wear.bean.server.bean;

import com.wear.bean.server.base.BaseResponse;
import com.wear.bean.server.base.MessageType;
import dc.qf2;
import dc.r32;

/* loaded from: classes3.dex */
public class H010Bean extends BaseResponse<String> {
    public String type = MessageType.H010;

    /* JADX WARN: Type inference failed for: r3v1, types: [T, com.wear.bean.server.bean.NullBean] */
    @Override // com.wear.bean.server.base.BaseResponse, dc.m32
    public void handler(String str, qf2 qf2Var, Object obj) {
        H011Bean h011Bean = new H011Bean();
        h011Bean.data = new NullBean();
        r32.l().v(str, h011Bean);
    }
}
