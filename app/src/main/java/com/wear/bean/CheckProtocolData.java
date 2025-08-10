package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CheckProtocolBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/wear/bean/CheckProtocolData;", "", "protocolStatus", "", "protocolUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getProtocolStatus", "()Ljava/lang/String;", "getProtocolUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CheckProtocolData {

    @Nullable
    private final String protocolStatus;

    @Nullable
    private final String protocolUrl;

    public CheckProtocolData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public CheckProtocolData(@Nullable String str, @Nullable String str2) {
        this.protocolStatus = str;
        this.protocolUrl = str2;
    }

    public static /* synthetic */ CheckProtocolData copy$default(CheckProtocolData checkProtocolData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkProtocolData.protocolStatus;
        }
        if ((i & 2) != 0) {
            str2 = checkProtocolData.protocolUrl;
        }
        return checkProtocolData.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getProtocolStatus() {
        return this.protocolStatus;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getProtocolUrl() {
        return this.protocolUrl;
    }

    @NotNull
    public final CheckProtocolData copy(@Nullable String protocolStatus, @Nullable String protocolUrl) {
        return new CheckProtocolData(protocolStatus, protocolUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckProtocolData)) {
            return false;
        }
        CheckProtocolData checkProtocolData = (CheckProtocolData) other;
        return Intrinsics.areEqual(this.protocolStatus, checkProtocolData.protocolStatus) && Intrinsics.areEqual(this.protocolUrl, checkProtocolData.protocolUrl);
    }

    @Nullable
    public final String getProtocolStatus() {
        return this.protocolStatus;
    }

    @Nullable
    public final String getProtocolUrl() {
        return this.protocolUrl;
    }

    public int hashCode() {
        String str = this.protocolStatus;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.protocolUrl;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CheckProtocolData(protocolStatus=" + this.protocolStatus + ", protocolUrl=" + this.protocolUrl + ')';
    }

    public /* synthetic */ CheckProtocolData(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
