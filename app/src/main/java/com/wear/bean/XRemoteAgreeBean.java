package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: XRemoteAgreeBean.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/wear/bean/XRemoteAgreeBean;", "", "result", "", XHTMLText.CODE, "", "message", "", "data", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Ljava/lang/String;", "getMessage", "setMessage", "(Ljava/lang/String;)V", "getResult", "()Ljava/lang/Boolean;", "setResult", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/wear/bean/XRemoteAgreeBean;", "equals", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class XRemoteAgreeBean {

    @Nullable
    private final Integer code;

    @Nullable
    private final String data;

    @Nullable
    private String message;

    @Nullable
    private Boolean result;

    public XRemoteAgreeBean(@Nullable Boolean bool, @Nullable Integer num, @Nullable String str, @Nullable String str2) {
        this.result = bool;
        this.code = num;
        this.message = str;
        this.data = str2;
    }

    public static /* synthetic */ XRemoteAgreeBean copy$default(XRemoteAgreeBean xRemoteAgreeBean, Boolean bool, Integer num, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = xRemoteAgreeBean.result;
        }
        if ((i & 2) != 0) {
            num = xRemoteAgreeBean.code;
        }
        if ((i & 4) != 0) {
            str = xRemoteAgreeBean.message;
        }
        if ((i & 8) != 0) {
            str2 = xRemoteAgreeBean.data;
        }
        return xRemoteAgreeBean.copy(bool, num, str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getResult() {
        return this.result;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getData() {
        return this.data;
    }

    @NotNull
    public final XRemoteAgreeBean copy(@Nullable Boolean result, @Nullable Integer code, @Nullable String message, @Nullable String data) {
        return new XRemoteAgreeBean(result, code, message, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof XRemoteAgreeBean)) {
            return false;
        }
        XRemoteAgreeBean xRemoteAgreeBean = (XRemoteAgreeBean) other;
        return Intrinsics.areEqual(this.result, xRemoteAgreeBean.result) && Intrinsics.areEqual(this.code, xRemoteAgreeBean.code) && Intrinsics.areEqual(this.message, xRemoteAgreeBean.message) && Intrinsics.areEqual(this.data, xRemoteAgreeBean.data);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final String getData() {
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
        Boolean bool = this.result;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.code;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.message;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.data;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setMessage(@Nullable String str) {
        this.message = str;
    }

    public final void setResult(@Nullable Boolean bool) {
        this.result = bool;
    }

    @NotNull
    public String toString() {
        return "XRemoteAgreeBean(result=" + this.result + ", code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }
}
