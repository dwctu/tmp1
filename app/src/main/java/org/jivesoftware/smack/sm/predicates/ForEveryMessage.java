package org.jivesoftware.smack.sm.predicates;

import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;

/* loaded from: classes5.dex */
public class ForEveryMessage implements StanzaFilter {
    public static final ForEveryMessage INSTANCE = new ForEveryMessage();

    private ForEveryMessage() {
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        return stanza instanceof Message;
    }
}
