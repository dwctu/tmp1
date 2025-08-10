package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: CheckProtocolBean.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/wear/bean/CheckProtocolBean;", "", XHTMLText.CODE, "", "data", "Lcom/wear/bean/CheckProtocolData;", "message", "", "result", "", "(Ljava/lang/Integer;Lcom/wear/bean/CheckProtocolData;Ljava/lang/String;Ljava/lang/Boolean;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Lcom/wear/bean/CheckProtocolData;", "getMessage", "()Ljava/lang/String;", "getResult", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Lcom/wear/bean/CheckProtocolData;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/wear/bean/CheckProtocolBean;", "equals", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CheckProtocolBean {

    @Nullable
    private final Integer code;

    @Nullable
    private final CheckProtocolData data;

    @Nullable
    private final String message;

    @Nullable
    private final Boolean result;

    public CheckProtocolBean() {
        this(null, null, null, null, 15, null);
    }

    public CheckProtocolBean(@Nullable Integer num, @Nullable CheckProtocolData checkProtocolData, @Nullable String str, @Nullable Boolean bool) {
        this.code = num;
        this.data = checkProtocolData;
        this.message = str;
        this.result = bool;
    }

    public static /* synthetic */ CheckProtocolBean copy$default(CheckProtocolBean checkProtocolBean, Integer num, CheckProtocolData checkProtocolData, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = checkProtocolBean.code;
        }
        if ((i & 2) != 0) {
            checkProtocolData = checkProtocolBean.data;
        }
        if ((i & 4) != 0) {
            str = checkProtocolBean.message;
        }
        if ((i & 8) != 0) {
            bool = checkProtocolBean.result;
        }
        return checkProtocolBean.copy(num, checkProtocolData, str, bool);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final CheckProtocolData getData() {
        return this.data;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getResult() {
        return this.result;
    }

    @NotNull
    public final CheckProtocolBean copy(@Nullable Integer code, @Nullable CheckProtocolData data, @Nullable String message, @Nullable Boolean result) {
        return new CheckProtocolBean(code, data, message, result);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckProtocolBean)) {
            return false;
        }
        CheckProtocolBean checkProtocolBean = (CheckProtocolBean) other;
        return Intrinsics.areEqual(this.code, checkProtocolBean.code) && Intrinsics.areEqual(this.data, checkProtocolBean.data) && Intrinsics.areEqual(this.message, checkProtocolBean.message) && Intrinsics.areEqual(this.result, checkProtocolBean.result);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final CheckProtocolData getData() {
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
        CheckProtocolData checkProtocolData = this.data;
        int iHashCode2 = (iHashCode + (checkProtocolData == null ? 0 : checkProtocolData.hashCode())) * 31;
        String str = this.message;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.result;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CheckProtocolBean(code=" + this.code + ", data=" + this.data + ", message=" + this.message + ", result=" + this.result + ')';
    }

    public /* synthetic */ CheckProtocolBean(Integer num, CheckProtocolData checkProtocolData, String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? null : checkProtocolData, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? Boolean.FALSE : bool);
    }
}
