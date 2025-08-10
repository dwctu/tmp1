package dc;

import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.messaging.Constants;
import com.wear.bean.chat.Message;
import com.wear.ui.chat.action.im.ChatMessageHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* compiled from: MessageOlderDatabaseIml.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0016J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\f\u001a\u00020\n2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0017"}, d2 = {"Lcom/wear/ui/chat/db/MessageOlderDatabaseIml;", "Lcom/wear/ui/chat/db/MessageDatabase;", "Lcom/wear/ui/chat/action/im/ChatMessageHandler$MessageHandlerListener;", "()V", "addMessage", "", "message", "Lcom/wear/bean/chat/Message;", "deleteMessage", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "deleteMessagesFromUserAccountCode", "accountCode", "handlerMessage", "queryAll", "", "queryMessageFromAccountCode", DataLayout.ELEMENT, "", "queryMessageFromAccountCodeFilterText", "selectedList", "updateMessage", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class zs2 implements xs2, ChatMessageHandler.MessageHandlerListener {

    @NotNull
    public static final a a = new a(null);

    @Nullable
    public static zs2 b;

    /* compiled from: MessageOlderDatabaseIml.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/wear/ui/chat/db/MessageOlderDatabaseIml$Companion;", "", "()V", "TAG", "", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/wear/ui/chat/db/MessageOlderDatabaseIml;", "getInstance", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final zs2 a() {
            zs2 zs2Var = zs2.b;
            if (zs2Var == null) {
                synchronized (this) {
                    zs2Var = new zs2(null);
                    ChatMessageHandler.INSTANCE.appendListener(zs2Var);
                    a aVar = zs2.a;
                    zs2.b = zs2Var;
                }
            }
            return zs2Var;
        }
    }

    public zs2() {
    }

    public /* synthetic */ zs2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // dc.xs2
    public void a(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // dc.xs2
    public void b(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // dc.xs2
    public void c(@NotNull String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
    }

    @Override // dc.xs2
    @NotNull
    public List<Message> d(@NotNull String accountCode, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // dc.xs2
    @NotNull
    public List<Message> e(@NotNull String accountCode, int i) {
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // dc.xs2
    public void f(@NotNull String accountCode) {
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
    }

    @Override // com.wear.ui.chat.action.im.ChatMessageHandler.MessageHandlerListener
    public void handlerMessage(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
