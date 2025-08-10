package com.wear.bean.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CreatePatternRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JN\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/wear/bean/request/CreatePatternRequest;", "", "localMsgId", "", "msgText", "sessionId", "topicId", "useTplMsg", "", "tplMsgId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getLocalMsgId", "()Ljava/lang/String;", "getMsgText", "getSessionId", "getTopicId", "getTplMsgId", "getUseTplMsg", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/wear/bean/request/CreatePatternRequest;", "equals", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CreatePatternRequest {

    @NotNull
    private final String localMsgId;

    @NotNull
    private final String msgText;

    @NotNull
    private final String sessionId;

    @NotNull
    private final String topicId;

    @Nullable
    private final String tplMsgId;

    @Nullable
    private final Boolean useTplMsg;

    public CreatePatternRequest(@NotNull String localMsgId, @NotNull String msgText, @NotNull String sessionId, @NotNull String topicId, @Nullable Boolean bool, @Nullable String str) {
        Intrinsics.checkNotNullParameter(localMsgId, "localMsgId");
        Intrinsics.checkNotNullParameter(msgText, "msgText");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(topicId, "topicId");
        this.localMsgId = localMsgId;
        this.msgText = msgText;
        this.sessionId = sessionId;
        this.topicId = topicId;
        this.useTplMsg = bool;
        this.tplMsgId = str;
    }

    public static /* synthetic */ CreatePatternRequest copy$default(CreatePatternRequest createPatternRequest, String str, String str2, String str3, String str4, Boolean bool, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createPatternRequest.localMsgId;
        }
        if ((i & 2) != 0) {
            str2 = createPatternRequest.msgText;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = createPatternRequest.sessionId;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = createPatternRequest.topicId;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            bool = createPatternRequest.useTplMsg;
        }
        Boolean bool2 = bool;
        if ((i & 32) != 0) {
            str5 = createPatternRequest.tplMsgId;
        }
        return createPatternRequest.copy(str, str6, str7, str8, bool2, str5);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getLocalMsgId() {
        return this.localMsgId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getMsgText() {
        return this.msgText;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getTopicId() {
        return this.topicId;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Boolean getUseTplMsg() {
        return this.useTplMsg;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getTplMsgId() {
        return this.tplMsgId;
    }

    @NotNull
    public final CreatePatternRequest copy(@NotNull String localMsgId, @NotNull String msgText, @NotNull String sessionId, @NotNull String topicId, @Nullable Boolean useTplMsg, @Nullable String tplMsgId) {
        Intrinsics.checkNotNullParameter(localMsgId, "localMsgId");
        Intrinsics.checkNotNullParameter(msgText, "msgText");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(topicId, "topicId");
        return new CreatePatternRequest(localMsgId, msgText, sessionId, topicId, useTplMsg, tplMsgId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreatePatternRequest)) {
            return false;
        }
        CreatePatternRequest createPatternRequest = (CreatePatternRequest) other;
        return Intrinsics.areEqual(this.localMsgId, createPatternRequest.localMsgId) && Intrinsics.areEqual(this.msgText, createPatternRequest.msgText) && Intrinsics.areEqual(this.sessionId, createPatternRequest.sessionId) && Intrinsics.areEqual(this.topicId, createPatternRequest.topicId) && Intrinsics.areEqual(this.useTplMsg, createPatternRequest.useTplMsg) && Intrinsics.areEqual(this.tplMsgId, createPatternRequest.tplMsgId);
    }

    @NotNull
    public final String getLocalMsgId() {
        return this.localMsgId;
    }

    @NotNull
    public final String getMsgText() {
        return this.msgText;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    public final String getTopicId() {
        return this.topicId;
    }

    @Nullable
    public final String getTplMsgId() {
        return this.tplMsgId;
    }

    @Nullable
    public final Boolean getUseTplMsg() {
        return this.useTplMsg;
    }

    public int hashCode() {
        int iHashCode = ((((((this.localMsgId.hashCode() * 31) + this.msgText.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + this.topicId.hashCode()) * 31;
        Boolean bool = this.useTplMsg;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.tplMsgId;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CreatePatternRequest(localMsgId=" + this.localMsgId + ", msgText=" + this.msgText + ", sessionId=" + this.sessionId + ", topicId=" + this.topicId + ", useTplMsg=" + this.useTplMsg + ", tplMsgId=" + this.tplMsgId + ')';
    }

    public /* synthetic */ CreatePatternRequest(String str, String str2, String str3, String str4, Boolean bool, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? Boolean.FALSE : bool, (i & 32) != 0 ? null : str5);
    }
}
