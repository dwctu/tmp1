package dc;

import com.wear.bean.chat.Message;
import com.wear.bean.chat.MessageResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatMessageDatabaseStrategy.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/wear/ui/chat/action/ChatMessageDatabaseStrategy;", "Lcom/wear/ui/chat/action/IChatMessageStrategy;", "messageDatabase", "Lcom/wear/ui/chat/db/MessageDatabase;", "(Lcom/wear/ui/chat/db/MessageDatabase;)V", "processMessage", "Lcom/wear/bean/chat/MessageResult;", "message", "Lcom/wear/bean/chat/Message;", "type", "", "(Lcom/wear/bean/chat/Message;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class lr2 extends nr2 {

    @NotNull
    public final xs2 b;

    public lr2(@NotNull xs2 messageDatabase) {
        Intrinsics.checkNotNullParameter(messageDatabase, "messageDatabase");
        this.b = messageDatabase;
    }

    @Override // dc.nr2
    @Nullable
    public Object c(@NotNull Message message, int i, @NotNull Continuation<? super MessageResult> continuation) {
        String messageId;
        if (i == 0) {
            this.b.a(message);
        } else if (i == 2 && (messageId = message.getMessageId()) != null) {
            this.b.c(messageId);
        }
        return new MessageResult.Success(message);
    }
}
