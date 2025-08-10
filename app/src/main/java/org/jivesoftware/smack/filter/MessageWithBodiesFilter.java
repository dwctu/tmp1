package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Message;

/* loaded from: classes5.dex */
public class MessageWithBodiesFilter extends FlexibleStanzaTypeFilter<Message> {
    public static final StanzaFilter INSTANCE = new MessageWithBodiesFilter();

    private MessageWithBodiesFilter() {
        super(Message.class);
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public boolean acceptSpecific(Message message) {
        return !message.getBodies().isEmpty();
    }
}
