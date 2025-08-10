package com.wear.bean.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatGPTEvent.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/wear/bean/event/ChatGPTEvent;", "", "eventType", "Lcom/wear/bean/event/ChatGPTType;", "sessionTaskId", "", "(Lcom/wear/bean/event/ChatGPTType;Ljava/lang/String;)V", "getEventType", "()Lcom/wear/bean/event/ChatGPTType;", "getSessionTaskId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatGPTEvent {

    @NotNull
    private final ChatGPTType eventType;

    @NotNull
    private final String sessionTaskId;

    public ChatGPTEvent(@NotNull ChatGPTType eventType, @NotNull String sessionTaskId) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(sessionTaskId, "sessionTaskId");
        this.eventType = eventType;
        this.sessionTaskId = sessionTaskId;
    }

    public static /* synthetic */ ChatGPTEvent copy$default(ChatGPTEvent chatGPTEvent, ChatGPTType chatGPTType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            chatGPTType = chatGPTEvent.eventType;
        }
        if ((i & 2) != 0) {
            str = chatGPTEvent.sessionTaskId;
        }
        return chatGPTEvent.copy(chatGPTType, str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final ChatGPTType getEventType() {
        return this.eventType;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getSessionTaskId() {
        return this.sessionTaskId;
    }

    @NotNull
    public final ChatGPTEvent copy(@NotNull ChatGPTType eventType, @NotNull String sessionTaskId) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(sessionTaskId, "sessionTaskId");
        return new ChatGPTEvent(eventType, sessionTaskId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatGPTEvent)) {
            return false;
        }
        ChatGPTEvent chatGPTEvent = (ChatGPTEvent) other;
        return this.eventType == chatGPTEvent.eventType && Intrinsics.areEqual(this.sessionTaskId, chatGPTEvent.sessionTaskId);
    }

    @NotNull
    public final ChatGPTType getEventType() {
        return this.eventType;
    }

    @NotNull
    public final String getSessionTaskId() {
        return this.sessionTaskId;
    }

    public int hashCode() {
        return (this.eventType.hashCode() * 31) + this.sessionTaskId.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChatGPTEvent(eventType=" + this.eventType + ", sessionTaskId=" + this.sessionTaskId + ')';
    }
}
