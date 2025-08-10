package com.wear.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: LastLoginInfoBean.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/wear/bean/LastLoginInfoBean;", "", "()V", XHTMLText.CODE, "", "getCode", "()I", "setCode", "(I)V", "data", "Lcom/wear/bean/LastLoginInfoBean$DataBean;", "getData", "()Lcom/wear/bean/LastLoginInfoBean$DataBean;", "setData", "(Lcom/wear/bean/LastLoginInfoBean$DataBean;)V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "result", "", "getResult", "()Z", "setResult", "(Z)V", "DataBean", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class LastLoginInfoBean {
    private int code;

    @Nullable
    private DataBean data;

    @Nullable
    private String message;
    private boolean result;

    /* compiled from: LastLoginInfoBean.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/wear/bean/LastLoginInfoBean$DataBean;", "", "()V", "deviceName", "", "getDeviceName", "()Ljava/lang/String;", "setDeviceName", "(Ljava/lang/String;)V", "loginTimestamp", "", "getLoginTimestamp", "()Ljava/lang/Long;", "setLoginTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "pf", "getPf", "setPf", "sessionId", "getSessionId", "setSessionId", RosterVer.ELEMENT, "getVer", "setVer", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DataBean {

        @Nullable
        private String sessionId = "";

        @Nullable
        private Long loginTimestamp = 0L;

        @Nullable
        private String deviceName = "";

        @Nullable
        private String ver = "";

        @Nullable
        private String pf = "";

        @Nullable
        public final String getDeviceName() {
            return this.deviceName;
        }

        @Nullable
        public final Long getLoginTimestamp() {
            return this.loginTimestamp;
        }

        @Nullable
        public final String getPf() {
            return this.pf;
        }

        @Nullable
        public final String getSessionId() {
            return this.sessionId;
        }

        @Nullable
        public final String getVer() {
            return this.ver;
        }

        public final void setDeviceName(@Nullable String str) {
            this.deviceName = str;
        }

        public final void setLoginTimestamp(@Nullable Long l) {
            this.loginTimestamp = l;
        }

        public final void setPf(@Nullable String str) {
            this.pf = str;
        }

        public final void setSessionId(@Nullable String str) {
            this.sessionId = str;
        }

        public final void setVer(@Nullable String str) {
            this.ver = str;
        }
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final DataBean getData() {
        return this.data;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    public final boolean getResult() {
        return this.result;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setData(@Nullable DataBean dataBean) {
        this.data = dataBean;
    }

    public final void setMessage(@Nullable String str) {
        this.message = str;
    }

    public final void setResult(boolean z) {
        this.result = z;
    }
}
