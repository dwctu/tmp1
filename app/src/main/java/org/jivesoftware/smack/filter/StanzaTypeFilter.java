package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;

/* loaded from: classes5.dex */
public final class StanzaTypeFilter implements StanzaFilter {
    private final Class<? extends Stanza> packetType;
    public static final StanzaTypeFilter PRESENCE = new StanzaTypeFilter(Presence.class);
    public static final StanzaTypeFilter MESSAGE = new StanzaTypeFilter(Message.class);
    public static final StanzaTypeFilter IQ = new StanzaTypeFilter(IQ.class);

    public StanzaTypeFilter(Class<? extends Stanza> cls) {
        this.packetType = cls;
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        return this.packetType.isInstance(stanza);
    }

    public String toString() {
        return StanzaTypeFilter.class.getSimpleName() + ": " + this.packetType.getName();
    }
}
