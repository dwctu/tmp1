package com.wear.network.protocol.exception;

/* loaded from: classes3.dex */
public class FormatException extends RuntimeException {
    public int code = -200;
    public String message = "服务端返回数据格式异常";

    public int getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
