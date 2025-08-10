package org.jivesoftware.smack.filter;

import java.util.Locale;
import org.jivesoftware.smack.packet.Stanza;

/* loaded from: classes5.dex */
public class ToFilter implements StanzaFilter {
    private final String to;

    public ToFilter(String str) {
        this.to = str.toLowerCase(Locale.US);
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        String to = stanza.getTo();
        if (to == null) {
            return false;
        }
        return to.toLowerCase(Locale.US).equals(this.to);
    }

    public String toString() {
        return getClass().getSimpleName() + ": to=" + this.to;
    }
}
