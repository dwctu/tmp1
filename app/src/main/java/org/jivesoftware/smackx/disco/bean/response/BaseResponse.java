package org.jivesoftware.smackx.disco.bean.response;

/* loaded from: classes5.dex */
public class BaseResponse {
    public int code;
    public String msg;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public boolean suc() {
        return this.code == 1;
    }
}
