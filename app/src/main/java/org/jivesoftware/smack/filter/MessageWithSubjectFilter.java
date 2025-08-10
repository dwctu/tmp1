package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Message;

/* loaded from: classes5.dex */
public class MessageWithSubjectFilter extends FlexibleStanzaTypeFilter<Message> {
    public static final StanzaFilter INSTANCE = new MessageWithSubjectFilter();

    private MessageWithSubjectFilter() {
        super(Message.class);
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public boolean acceptSpecific(Message message) {
        return message.getSubject() != null;
    }
}
