package com.wear.net.model;

import androidx.exifinterface.media.ExifInterface;
import dc.of1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: RemoteResult.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000eJB\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u0004J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/wear/net/model/RemoteResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "result", "", XHTMLText.CODE, "", "message", "", "data", "(Ljava/lang/Boolean;ILjava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMessage", "()Ljava/lang/String;", "getResult", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;ILjava/lang/String;Ljava/lang/Object;)Lcom/wear/net/model/RemoteResult;", "equals", "other", "hashCode", "isSuccess", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@of1(generateAdapter = true)
/* loaded from: classes3.dex */
public final /* data */ class RemoteResult<T> {
    private final int code;

    @Nullable
    private final T data;

    @Nullable
    private final String message;

    @Nullable
    private final Boolean result;

    public RemoteResult(@Nullable Boolean bool, int i, @Nullable String str, @Nullable T t) {
        this.result = bool;
        this.code = i;
        this.message = str;
        this.data = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RemoteResult copy$default(RemoteResult remoteResult, Boolean bool, int i, String str, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            bool = remoteResult.result;
        }
        if ((i2 & 2) != 0) {
            i = remoteResult.code;
        }
        if ((i2 & 4) != 0) {
            str = remoteResult.message;
        }
        if ((i2 & 8) != 0) {
            obj = remoteResult.data;
        }
        return remoteResult.copy(bool, i, str, obj);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getResult() {
        return this.result;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final T component4() {
        return this.data;
    }

    @NotNull
    public final RemoteResult<T> copy(@Nullable Boolean result, int code, @Nullable String message, @Nullable T data) {
        return new RemoteResult<>(result, code, message, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteResult)) {
            return false;
        }
        RemoteResult remoteResult = (RemoteResult) other;
        return Intrinsics.areEqual(this.result, remoteResult.result) && this.code == remoteResult.code && Intrinsics.areEqual(this.message, remoteResult.message) && Intrinsics.areEqual(this.data, remoteResult.data);
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final T getData() {
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
        int iHashCode = (((bool == null ? 0 : bool.hashCode()) * 31) + this.code) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t = this.data;
        return iHashCode2 + (t != null ? t.hashCode() : 0);
    }

    public final boolean isSuccess() {
        return Intrinsics.areEqual(this.result, Boolean.TRUE);
    }

    @NotNull
    public String toString() {
        return "RemoteResult(result=" + this.result + ", code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public /* synthetic */ RemoteResult(Boolean bool, int i, String str, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, i, (i2 & 4) != 0 ? null : str, obj);
    }
}
