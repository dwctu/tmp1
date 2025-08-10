package com.wear.bean.server.bean;

import com.wear.bean.server.base.BaseResponse;
import com.wear.bean.server.base.MessageType;
import dc.pf2;
import dc.qf2;

/* loaded from: classes3.dex */
public class G030Bean extends BaseResponse<G030Data> implements pf2 {
    public String type = MessageType.G030;

    public static class G030Data {
        private String motion;

        public String getMotion() {
            return this.motion;
        }

        public void setMotion(String str) {
            this.motion = str;
        }
    }

    @Override // dc.pf2
    public String getAction() {
        return "ShakeVR";
    }

    @Override // com.wear.bean.server.base.BaseResponse, dc.m32
    public void handler(String str, qf2 qf2Var, Object obj) {
    }
}
