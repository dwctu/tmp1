package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.StringUtils;

@Deprecated
/* loaded from: classes5.dex */
public class PacketIDFilter implements StanzaFilter {
    private final String packetID;

    @Deprecated
    public PacketIDFilter(Stanza stanza) {
        this(stanza.getStanzaId());
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        return this.packetID.equals(stanza.getStanzaId());
    }

    public String toString() {
        return getClass().getSimpleName() + ": id=" + this.packetID;
    }

    @Deprecated
    public PacketIDFilter(String str) {
        StringUtils.requireNotNullOrEmpty(str, "Packet ID must not be null or empty.");
        this.packetID = str;
    }
}
