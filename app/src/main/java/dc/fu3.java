package dc;

import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManagerListener;

/* compiled from: SmackChatManagerListener.java */
/* loaded from: classes4.dex */
public class fu3 implements ChatManagerListener {
    @Override // org.jivesoftware.smack.chat.ChatManagerListener
    public void chatCreated(Chat chat, boolean z) {
        String str = "--->chatCreated:" + z;
        if (z) {
            return;
        }
        chat.addMessageListener(hu3.p);
    }
}
