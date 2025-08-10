package org.jivesoftware.smack.filter;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.util.XmppStringUtils;

/* loaded from: classes5.dex */
public class IQReplyFilter implements StanzaFilter {
    private static final Logger LOGGER = Logger.getLogger(IQReplyFilter.class.getName());
    private final OrFilter fromFilter;
    private final StanzaFilter iqAndIdFilter;
    private final String local;
    private final String packetId;
    private final String server;
    private final String to;

    public IQReplyFilter(IQ iq, XMPPConnection xMPPConnection) {
        if (!iq.isRequestIQ()) {
            throw new IllegalArgumentException("IQ must be a request IQ, i.e. of type 'get' or 'set'.");
        }
        if (iq.getTo() != null) {
            this.to = iq.getTo().toLowerCase(Locale.US);
        } else {
            this.to = null;
        }
        String user = xMPPConnection.getUser();
        if (user == null) {
            throw new IllegalArgumentException("Must have a local (user) JID set. Either you didn't configure one or you where not connected chat_notification_at least once");
        }
        Locale locale = Locale.US;
        String lowerCase = user.toLowerCase(locale);
        this.local = lowerCase;
        String lowerCase2 = xMPPConnection.getServiceName().toLowerCase(locale);
        this.server = lowerCase2;
        this.packetId = iq.getStanzaId();
        this.iqAndIdFilter = new AndFilter(new OrFilter(IQTypeFilter.ERROR, IQTypeFilter.RESULT), new StanzaIdFilter(iq));
        OrFilter orFilter = new OrFilter();
        this.fromFilter = orFilter;
        orFilter.addFilter(FromMatchesFilter.createFull(this.to));
        String str = this.to;
        if (str == null) {
            orFilter.addFilter(FromMatchesFilter.createBare(lowerCase));
            orFilter.addFilter(FromMatchesFilter.createFull(lowerCase2));
        } else if (str.equals(XmppStringUtils.parseBareJid(lowerCase))) {
            orFilter.addFilter(FromMatchesFilter.createFull(null));
        }
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        if (!this.iqAndIdFilter.accept(stanza)) {
            return false;
        }
        if (this.fromFilter.accept(stanza)) {
            return true;
        }
        LOGGER.log(Level.WARNING, String.format("Rejected potentially spoofed reply to IQ-packet. Filter settings: packetId=%s, to=%s, local=%s, server=%s. Received packet with from=%s", this.packetId, this.to, this.local, this.server, stanza.getFrom()), stanza);
        return false;
    }

    public String toString() {
        return getClass().getSimpleName() + ": iqAndIdFilter (" + this.iqAndIdFilter.toString() + "), : fromFilter (" + this.fromFilter.toString() + ')';
    }
}
