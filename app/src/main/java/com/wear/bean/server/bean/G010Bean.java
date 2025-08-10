package com.wear.bean.server.bean;

import com.wear.bean.server.base.BaseResponse;
import com.wear.bean.server.base.MessageType;
import dc.qf2;
import dc.r32;

/* loaded from: classes3.dex */
public class G010Bean extends BaseResponse<G010Data> {
    public String type = MessageType.G010;

    public static class G010Data {
        private String t;

        public String getT() {
            return this.t;
        }

        public void setT(String str) {
            this.t = str;
        }
    }

    @Override // com.wear.bean.server.base.BaseResponse, dc.m32
    public void handler(String str, qf2 qf2Var, Object obj) {
        r32.l().i(this);
    }
}
