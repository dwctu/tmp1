package com.wear.bean.server.bean;

import com.wear.bean.server.base.BaseResponse;
import com.wear.bean.server.base.MessageType;
import dc.qf2;

/* loaded from: classes3.dex */
public class E010Bean extends BaseResponse<E010Data> {
    public String type = MessageType.E010;

    public static class E010Data {
        private String code;
        private String message;

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setMessage(String str) {
            this.message = str;
        }
    }

    @Override // com.wear.bean.server.base.BaseResponse, dc.m32
    public void handler(String str, qf2 qf2Var, Object obj) {
    }
}
