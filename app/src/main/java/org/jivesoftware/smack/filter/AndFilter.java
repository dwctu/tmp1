package org.jivesoftware.smack.filter;

import java.util.Iterator;
import org.jivesoftware.smack.packet.Stanza;

/* loaded from: classes5.dex */
public class AndFilter extends AbstractListFilter implements StanzaFilter {
    public AndFilter() {
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        Iterator<StanzaFilter> it = this.filters.iterator();
        while (it.hasNext()) {
            if (!it.next().accept(stanza)) {
                return false;
            }
        }
        return true;
    }

    public AndFilter(StanzaFilter... stanzaFilterArr) {
        super(stanzaFilterArr);
    }
}
