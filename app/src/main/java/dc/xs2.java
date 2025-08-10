package dc;

import com.google.firebase.messaging.Constants;
import com.wear.bean.chat.Message;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* compiled from: MessageDatabase.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH&J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH&J(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\n\u001a\u00020\b2\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\fH&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/chat/db/MessageDatabase;", "", "addMessage", "", "message", "Lcom/wear/bean/chat/Message;", "deleteMessage", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "deleteMessagesFromUserAccountCode", "accountCode", "queryAll", "", "queryMessageFromAccountCode", DataLayout.ELEMENT, "", "queryMessageFromAccountCodeFilterText", "selectedList", "updateMessage", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface xs2 {
    void a(@NotNull Message message);

    void b(@NotNull Message message);

    void c(@NotNull String str);

    @NotNull
    List<Message> d(@NotNull String str, @Nullable List<String> list);

    @NotNull
    List<Message> e(@NotNull String str, int i);

    void f(@NotNull String str);
}
