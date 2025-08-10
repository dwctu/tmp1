package com.wear.bean;

import com.wear.bean.chat.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatStatus.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/wear/bean/RecyclerViewStatus;", "", "()V", "DeleteMessage", "Idle", "NewMessage", "NewMessages", "PreMessages", "UpdateMessage", "Lcom/wear/bean/RecyclerViewStatus$DeleteMessage;", "Lcom/wear/bean/RecyclerViewStatus$Idle;", "Lcom/wear/bean/RecyclerViewStatus$NewMessage;", "Lcom/wear/bean/RecyclerViewStatus$NewMessages;", "Lcom/wear/bean/RecyclerViewStatus$PreMessages;", "Lcom/wear/bean/RecyclerViewStatus$UpdateMessage;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class RecyclerViewStatus {

    /* compiled from: ChatStatus.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/bean/RecyclerViewStatus$DeleteMessage;", "Lcom/wear/bean/RecyclerViewStatus;", "message", "Lcom/wear/bean/chat/Message;", "(Lcom/wear/bean/chat/Message;)V", "getMessage", "()Lcom/wear/bean/chat/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DeleteMessage extends RecyclerViewStatus {

        @NotNull
        private final Message message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeleteMessage(@NotNull Message message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        @NotNull
        public final Message getMessage() {
            return this.message;
        }
    }

    /* compiled from: ChatStatus.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/RecyclerViewStatus$Idle;", "Lcom/wear/bean/RecyclerViewStatus;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Idle extends RecyclerViewStatus {

        @NotNull
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }
    }

    /* compiled from: ChatStatus.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/bean/RecyclerViewStatus$NewMessage;", "Lcom/wear/bean/RecyclerViewStatus;", "message", "Lcom/wear/bean/chat/Message;", "(Lcom/wear/bean/chat/Message;)V", "getMessage", "()Lcom/wear/bean/chat/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class NewMessage extends RecyclerViewStatus {

        @NotNull
        private final Message message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewMessage(@NotNull Message message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        @NotNull
        public final Message getMessage() {
            return this.message;
        }
    }

    /* compiled from: ChatStatus.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/wear/bean/RecyclerViewStatus$NewMessages;", "Lcom/wear/bean/RecyclerViewStatus;", "messages", "", "Lcom/wear/bean/chat/Message;", "(Ljava/util/List;)V", "getMessages", "()Ljava/util/List;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class NewMessages extends RecyclerViewStatus {

        @NotNull
        private final List<Message> messages;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewMessages(@NotNull List<Message> messages) {
            super(null);
            Intrinsics.checkNotNullParameter(messages, "messages");
            this.messages = messages;
        }

        @NotNull
        public final List<Message> getMessages() {
            return this.messages;
        }
    }

    /* compiled from: ChatStatus.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/wear/bean/RecyclerViewStatus$PreMessages;", "Lcom/wear/bean/RecyclerViewStatus;", "messages", "", "Lcom/wear/bean/chat/Message;", "(Ljava/util/List;)V", "getMessages", "()Ljava/util/List;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PreMessages extends RecyclerViewStatus {

        @Nullable
        private final List<Message> messages;

        public PreMessages(@Nullable List<Message> list) {
            super(null);
            this.messages = list;
        }

        @Nullable
        public final List<Message> getMessages() {
            return this.messages;
        }
    }

    /* compiled from: ChatStatus.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/bean/RecyclerViewStatus$UpdateMessage;", "Lcom/wear/bean/RecyclerViewStatus;", "message", "Lcom/wear/bean/chat/Message;", "(Lcom/wear/bean/chat/Message;)V", "getMessage", "()Lcom/wear/bean/chat/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class UpdateMessage extends RecyclerViewStatus {

        @NotNull
        private final Message message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateMessage(@NotNull Message message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        @NotNull
        public final Message getMessage() {
            return this.message;
        }
    }

    private RecyclerViewStatus() {
    }

    public /* synthetic */ RecyclerViewStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
