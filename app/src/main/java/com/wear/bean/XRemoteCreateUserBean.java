package com.wear.bean;

import com.wear.bean.XRemoteAppUserBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: XRemoteCreateUserBean.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/wear/bean/XRemoteCreateUserBean;", "", XHTMLText.CODE, "", "data", "Lcom/wear/bean/XRemoteAppUserBean$DataBean$ApplicationAccount;", "message", "", "result", "", "(ILcom/wear/bean/XRemoteAppUserBean$DataBean$ApplicationAccount;Ljava/lang/String;Z)V", "getCode", "()I", "getData", "()Lcom/wear/bean/XRemoteAppUserBean$DataBean$ApplicationAccount;", "getMessage", "()Ljava/lang/String;", "getResult", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class XRemoteCreateUserBean {
    private final int code;

    @NotNull
    private final XRemoteAppUserBean.DataBean.ApplicationAccount data;

    @NotNull
    private final String message;
    private final boolean result;

    public XRemoteCreateUserBean(int i, @NotNull XRemoteAppUserBean.DataBean.ApplicationAccount data, @NotNull String message, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = i;
        this.data = data;
        this.message = message;
        this.result = z;
    }

    public static /* synthetic */ XRemoteCreateUserBean copy$default(XRemoteCreateUserBean xRemoteCreateUserBean, int i, XRemoteAppUserBean.DataBean.ApplicationAccount applicationAccount, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = xRemoteCreateUserBean.code;
        }
        if ((i2 & 2) != 0) {
            applicationAccount = xRemoteCreateUserBean.data;
        }
        if ((i2 & 4) != 0) {
            str = xRemoteCreateUserBean.message;
        }
        if ((i2 & 8) != 0) {
            z = xRemoteCreateUserBean.result;
        }
        return xRemoteCreateUserBean.copy(i, applicationAccount, str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final XRemoteAppUserBean.DataBean.ApplicationAccount getData() {
        return this.data;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getResult() {
        return this.result;
    }

    @NotNull
    public final XRemoteCreateUserBean copy(int code, @NotNull XRemoteAppUserBean.DataBean.ApplicationAccount data, @NotNull String message, boolean result) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        return new XRemoteCreateUserBean(code, data, message, result);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof XRemoteCreateUserBean)) {
            return false;
        }
        XRemoteCreateUserBean xRemoteCreateUserBean = (XRemoteCreateUserBean) other;
        return this.code == xRemoteCreateUserBean.code && Intrinsics.areEqual(this.data, xRemoteCreateUserBean.data) && Intrinsics.areEqual(this.message, xRemoteCreateUserBean.message) && this.result == xRemoteCreateUserBean.result;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final XRemoteAppUserBean.DataBean.ApplicationAccount getData() {
        return this.data;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final boolean getResult() {
        return this.result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((this.code * 31) + this.data.hashCode()) * 31) + this.message.hashCode()) * 31;
        boolean z = this.result;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    @NotNull
    public String toString() {
        return "XRemoteCreateUserBean(code=" + this.code + ", data=" + this.data + ", message=" + this.message + ", result=" + this.result + ')';
    }
}
