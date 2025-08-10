package org.jivesoftware.smack.sm.predicates;

import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Stanza;

/* loaded from: classes5.dex */
public class AfterXStanzas implements StanzaFilter {
    public final int count;
    public int currentCount = 0;

    public AfterXStanzas(int i) {
        this.count = i;
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public synchronized boolean accept(Stanza stanza) {
        int i = this.currentCount + 1;
        this.currentCount = i;
        if (i != this.count) {
            return false;
        }
        resetCounter();
        return true;
    }

    public synchronized void resetCounter() {
        this.currentCount = 0;
    }
}
