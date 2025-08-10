package org.jivesoftware.smack.filter;

import java.util.Locale;
import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.util.XmppStringUtils;

/* loaded from: classes5.dex */
public class FromMatchesFilter implements StanzaFilter {
    private final String address;
    private final boolean matchBareJID;

    public FromMatchesFilter(String str, boolean z) {
        this.address = str == null ? null : str.toLowerCase(Locale.US);
        this.matchBareJID = z;
    }

    public static FromMatchesFilter create(String str) {
        return new FromMatchesFilter(str, "".equals(XmppStringUtils.parseResource(str)));
    }

    public static FromMatchesFilter createBare(String str) {
        return new FromMatchesFilter(str == null ? null : XmppStringUtils.parseBareJid(str), true);
    }

    public static FromMatchesFilter createFull(String str) {
        return new FromMatchesFilter(str, false);
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        String from = stanza.getFrom();
        if (from == null) {
            return this.address == null;
        }
        String lowerCase = from.toLowerCase(Locale.US);
        if (this.matchBareJID) {
            lowerCase = XmppStringUtils.parseBareJid(lowerCase);
        }
        return lowerCase.equals(this.address);
    }

    public String toString() {
        return getClass().getSimpleName() + " (" + (this.matchBareJID ? "bare" : "full") + "): " + this.address;
    }
}
