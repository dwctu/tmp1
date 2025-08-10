package com.wear.bean.chat;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SignalingRequest.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/wear/bean/chat/SignalingRequest;", "", "syn", "", "userAccountCode", "", "type", "timeout", "extra", "Lcom/wear/bean/chat/SignalingMessageExtra;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/wear/bean/chat/SignalingMessageExtra;)V", "getExtra", "()Lcom/wear/bean/chat/SignalingMessageExtra;", "getSyn", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTimeout", "getType", "()Ljava/lang/String;", "getUserAccountCode", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SignalingRequest {

    @Nullable
    private final SignalingMessageExtra extra;

    @Nullable
    private final Long syn;

    @Nullable
    private final Long timeout;

    @NotNull
    private final String type;

    @NotNull
    private final String userAccountCode;

    public SignalingRequest(@Nullable Long l, @NotNull String userAccountCode, @NotNull String type, @Nullable Long l2, @Nullable SignalingMessageExtra signalingMessageExtra) {
        Intrinsics.checkNotNullParameter(userAccountCode, "userAccountCode");
        Intrinsics.checkNotNullParameter(type, "type");
        this.syn = l;
        this.userAccountCode = userAccountCode;
        this.type = type;
        this.timeout = l2;
        this.extra = signalingMessageExtra;
    }

    @Nullable
    public final SignalingMessageExtra getExtra() {
        return this.extra;
    }

    @Nullable
    public final Long getSyn() {
        return this.syn;
    }

    @Nullable
    public final Long getTimeout() {
        return this.timeout;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getUserAccountCode() {
        return this.userAccountCode;
    }

    public /* synthetic */ SignalingRequest(Long l, String str, String str2, Long l2, SignalingMessageExtra signalingMessageExtra, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, str, str2, (i & 8) != 0 ? 5000L : l2, (i & 16) != 0 ? null : signalingMessageExtra);
    }
}
