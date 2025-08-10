package com.wear.bean.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyCollectResponse.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/wear/bean/data/ToyCollectResponse;", "", "result", "", XHTMLText.CODE, "", "message", "", "data", "Lcom/wear/bean/data/ToyCollectData;", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Lcom/wear/bean/data/ToyCollectData;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Lcom/wear/bean/data/ToyCollectData;", "getMessage", "()Ljava/lang/String;", "getResult", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Lcom/wear/bean/data/ToyCollectData;)Lcom/wear/bean/data/ToyCollectResponse;", "equals", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToyCollectResponse {

    @Nullable
    private final Integer code;

    @Nullable
    private final ToyCollectData data;

    @Nullable
    private final String message;

    @Nullable
    private final Boolean result;

    public ToyCollectResponse(@Nullable Boolean bool, @Nullable Integer num, @Nullable String str, @Nullable ToyCollectData toyCollectData) {
        this.result = bool;
        this.code = num;
        this.message = str;
        this.data = toyCollectData;
    }

    public static /* synthetic */ ToyCollectResponse copy$default(ToyCollectResponse toyCollectResponse, Boolean bool, Integer num, String str, ToyCollectData toyCollectData, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = toyCollectResponse.result;
        }
        if ((i & 2) != 0) {
            num = toyCollectResponse.code;
        }
        if ((i & 4) != 0) {
            str = toyCollectResponse.message;
        }
        if ((i & 8) != 0) {
            toyCollectData = toyCollectResponse.data;
        }
        return toyCollectResponse.copy(bool, num, str, toyCollectData);
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
    public final ToyCollectData getData() {
        return this.data;
    }

    @NotNull
    public final ToyCollectResponse copy(@Nullable Boolean result, @Nullable Integer code, @Nullable String message, @Nullable ToyCollectData data) {
        return new ToyCollectResponse(result, code, message, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToyCollectResponse)) {
            return false;
        }
        ToyCollectResponse toyCollectResponse = (ToyCollectResponse) other;
        return Intrinsics.areEqual(this.result, toyCollectResponse.result) && Intrinsics.areEqual(this.code, toyCollectResponse.code) && Intrinsics.areEqual(this.message, toyCollectResponse.message) && Intrinsics.areEqual(this.data, toyCollectResponse.data);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final ToyCollectData getData() {
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
        ToyCollectData toyCollectData = this.data;
        return iHashCode3 + (toyCollectData != null ? toyCollectData.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ToyCollectResponse(result=" + this.result + ", code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }
}
