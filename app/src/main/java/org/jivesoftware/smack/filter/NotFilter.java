package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.Objects;

/* loaded from: classes5.dex */
public class NotFilter implements StanzaFilter {
    private final StanzaFilter filter;

    public NotFilter(StanzaFilter stanzaFilter) {
        this.filter = (StanzaFilter) Objects.requireNonNull(stanzaFilter, "Parameter must not be null.");
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        return !this.filter.accept(stanza);
    }
}
