package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;

/* loaded from: classes5.dex */
public class IQResultReplyFilter extends IQReplyFilter {
    public IQResultReplyFilter(IQ iq, XMPPConnection xMPPConnection) {
        super(iq, xMPPConnection);
    }

    @Override // org.jivesoftware.smack.filter.IQReplyFilter, org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        if (super.accept(stanza)) {
            return IQTypeFilter.RESULT.accept(stanza);
        }
        return false;
    }

    @Override // org.jivesoftware.smack.filter.IQReplyFilter
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" (" + super.toString() + ')');
        return sb.toString();
    }
}
