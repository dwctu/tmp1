package org.jivesoftware.smack.filter;

import java.util.Iterator;
import org.jivesoftware.smack.packet.Stanza;

/* loaded from: classes5.dex */
public class OrFilter extends AbstractListFilter implements StanzaFilter {
    public OrFilter() {
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        Iterator<StanzaFilter> it = this.filters.iterator();
        while (it.hasNext()) {
            if (it.next().accept(stanza)) {
                return true;
            }
        }
        return false;
    }

    public OrFilter(StanzaFilter... stanzaFilterArr) {
        super(stanzaFilterArr);
    }
}
