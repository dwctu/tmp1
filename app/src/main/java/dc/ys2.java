package dc;

import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.messaging.Constants;
import com.wear.bean.chat.Message;
import com.wear.dao.ChatMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.ui.chat.action.im.ChatMessageHandler;
import java.sql.SQLException;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* compiled from: MessageDatabaseIml.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0006\u0010\u0012\u001a\u00020\u00102\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/wear/ui/chat/db/MessageDatabaseIml;", "Lcom/wear/ui/chat/db/MessageDatabase;", "Lcom/wear/ui/chat/action/im/ChatMessageHandler$MessageHandlerListener;", "()V", "chatMessageDao", "Lcom/wear/dao/ChatMessageDao;", "getChatMessageDao", "()Lcom/wear/dao/ChatMessageDao;", "chatMessageDao$delegate", "Lkotlin/Lazy;", "addMessage", "", "message", "Lcom/wear/bean/chat/Message;", "deleteMessage", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "deleteMessagesFromUserAccountCode", "accountCode", "handlerMessage", "queryAll", "", "queryMessageFromAccountCode", DataLayout.ELEMENT, "", "queryMessageFromAccountCodeFilterText", "selectedList", "updateMessage", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ys2 implements xs2, ChatMessageHandler.MessageHandlerListener {

    @NotNull
    public static final a b = new a(null);

    @Nullable
    public static ys2 c;

    @NotNull
    public final Lazy a;

    /* compiled from: MessageDatabaseIml.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/wear/ui/chat/db/MessageDatabaseIml$Companion;", "", "()V", "TAG", "", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/wear/ui/chat/db/MessageDatabaseIml;", "getInstance", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ys2 a() {
            ys2 ys2Var = ys2.c;
            if (ys2Var == null) {
                synchronized (this) {
                    ys2Var = new ys2(null);
                    ChatMessageHandler.INSTANCE.appendListener(ys2Var);
                    a aVar = ys2.b;
                    ys2.c = ys2Var;
                }
            }
            return ys2Var;
        }
    }

    /* compiled from: MessageDatabaseIml.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/wear/dao/ChatMessageDao;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<ChatMessageDao> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ChatMessageDao invoke() {
            return DaoUtils.getChatMessageDao();
        }
    }

    public ys2() {
        this.a = LazyKt__LazyJVMKt.lazy(b.a);
    }

    public /* synthetic */ ys2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // dc.xs2
    public void a(@NotNull Message message) throws SQLException {
        Intrinsics.checkNotNullParameter(message, "message");
        i().add(message);
    }

    @Override // dc.xs2
    public void b(@NotNull Message message) throws SQLException {
        Intrinsics.checkNotNullParameter(message, "message");
        i().updateMessage(message);
    }

    @Override // dc.xs2
    public void c(@NotNull String messageId) throws SQLException {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        i().deleteMessage(messageId);
    }

    @Override // dc.xs2
    @NotNull
    public List<Message> d(@NotNull String accountCode, @Nullable List<String> list) throws SQLException {
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        List<Message> listQueryMessagesFromAccountCodeFilterText = i().queryMessagesFromAccountCodeFilterText(accountCode);
        for (Message message : listQueryMessagesFromAccountCodeFilterText) {
            boolean z = true;
            if (list == null || !list.contains(message.getMessageId())) {
                z = false;
            }
            message.setSelected(z);
        }
        return listQueryMessagesFromAccountCodeFilterText;
    }

    @Override // dc.xs2
    @NotNull
    public List<Message> e(@NotNull String accountCode, int i) {
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        return i().queryMessagesFromAccountCode(accountCode, i, 20);
    }

    @Override // dc.xs2
    public void f(@NotNull String accountCode) throws SQLException {
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        i().deleteMessagesFromUserAccountCode(accountCode);
    }

    @Override // com.wear.ui.chat.action.im.ChatMessageHandler.MessageHandlerListener
    public void handlerMessage(@NotNull Message message) throws SQLException {
        Intrinsics.checkNotNullParameter(message, "message");
        String str = "添加数据库 ->: " + message;
        a(message);
    }

    public final ChatMessageDao i() {
        Object value = this.a.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-chatMessageDao>(...)");
        return (ChatMessageDao) value;
    }
}
