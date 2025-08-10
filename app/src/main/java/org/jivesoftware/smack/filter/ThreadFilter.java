package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.StringUtils;

/* loaded from: classes5.dex */
public class ThreadFilter extends FlexibleStanzaTypeFilter<Message> implements StanzaFilter {
    private final String thread;

    public ThreadFilter(String str) {
        StringUtils.requireNotNullOrEmpty(str, "Thread must not be null or empty.");
        this.thread = str;
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public String toString() {
        return getClass().getSimpleName() + ": thread=" + this.thread;
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public boolean acceptSpecific(Message message) {
        return this.thread.equals(message.getThread());
    }
}
