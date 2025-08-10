package com.wear.bean.server.bean;

import com.wear.bean.server.base.BaseResponse;
import com.wear.bean.server.base.MessageType;
import dc.pf2;
import dc.qf2;
import dc.r32;

/* loaded from: classes3.dex */
public class G020Bean extends BaseResponse<G020Data> implements pf2 {
    public String type = MessageType.G020;

    public static class G020Data {
        private String t;

        public String getT() {
            return this.t;
        }

        public void setT(String str) {
            this.t = str;
        }
    }

    @Override // dc.pf2
    public String getAction() {
        return "EndVRGame";
    }

    @Override // com.wear.bean.server.base.BaseResponse, dc.m32
    public void handler(String str, qf2 qf2Var, Object obj) {
        r32.l().k(false);
    }
}
