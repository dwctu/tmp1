package com.component.dxdlog.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: LogServerResponseBean.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/component/dxdlog/bean/LogServerResponse;", "", XHTMLText.CODE, "", "result", "", "message", "", "data", "Lcom/component/dxdlog/bean/SessionToken;", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Lcom/component/dxdlog/bean/SessionToken;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Lcom/component/dxdlog/bean/SessionToken;", "getMessage", "()Ljava/lang/String;", "getResult", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Lcom/component/dxdlog/bean/SessionToken;)Lcom/component/dxdlog/bean/LogServerResponse;", "equals", "other", "hashCode", "toString", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LogServerResponse {

    @Nullable
    private final Integer code;

    @Nullable
    private final SessionToken data;

    @Nullable
    private final String message;

    @Nullable
    private final Boolean result;

    public LogServerResponse() {
        this(null, null, null, null, 15, null);
    }

    public LogServerResponse(@Nullable Integer num, @Nullable Boolean bool, @Nullable String str, @Nullable SessionToken sessionToken) {
        this.code = num;
        this.result = bool;
        this.message = str;
        this.data = sessionToken;
    }

    public static /* synthetic */ LogServerResponse copy$default(LogServerResponse logServerResponse, Integer num, Boolean bool, String str, SessionToken sessionToken, int i, Object obj) {
        if ((i & 1) != 0) {
            num = logServerResponse.code;
        }
        if ((i & 2) != 0) {
            bool = logServerResponse.result;
        }
        if ((i & 4) != 0) {
            str = logServerResponse.message;
        }
        if ((i & 8) != 0) {
            sessionToken = logServerResponse.data;
        }
        return logServerResponse.copy(num, bool, str, sessionToken);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Boolean getResult() {
        return this.result;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final SessionToken getData() {
        return this.data;
    }

    @NotNull
    public final LogServerResponse copy(@Nullable Integer code, @Nullable Boolean result, @Nullable String message, @Nullable SessionToken data) {
        return new LogServerResponse(code, result, message, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogServerResponse)) {
            return false;
        }
        LogServerResponse logServerResponse = (LogServerResponse) other;
        return Intrinsics.areEqual(this.code, logServerResponse.code) && Intrinsics.areEqual(this.result, logServerResponse.result) && Intrinsics.areEqual(this.message, logServerResponse.message) && Intrinsics.areEqual(this.data, logServerResponse.data);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final SessionToken getData() {
        return this.data;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Boolean getResult() {
        return this.result;
    }

    public int hashCode() {
        Integer num = this.code;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.result;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.message;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        SessionToken sessionToken = this.data;
        return iHashCode3 + (sessionToken != null ? sessionToken.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LogServerResponse(code=" + this.code + ", result=" + this.result + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public /* synthetic */ LogServerResponse(Integer num, Boolean bool, String str, SessionToken sessionToken, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 400 : num, (i & 2) != 0 ? Boolean.FALSE : bool, (i & 4) != 0 ? "Frequent requests, try again later" : str, (i & 8) != 0 ? null : sessionToken);
    }
}
