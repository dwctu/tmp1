package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;

@Deprecated
/* loaded from: classes5.dex */
public class PacketTypeFilter implements StanzaFilter {
    private final Class<? extends Stanza> packetType;
    public static final PacketTypeFilter PRESENCE = new PacketTypeFilter(Presence.class);
    public static final PacketTypeFilter MESSAGE = new PacketTypeFilter(Message.class);

    public PacketTypeFilter(Class<? extends Stanza> cls) {
        this.packetType = cls;
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        return this.packetType.isInstance(stanza);
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + this.packetType.getName();
    }
}
