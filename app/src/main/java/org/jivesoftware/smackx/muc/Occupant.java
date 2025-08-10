package org.jivesoftware.smackx.muc;

import com.wear.util.WearUtils;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.muc.packet.MUCItem;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jxmpp.util.XmppStringUtils;

/* loaded from: classes5.dex */
public class Occupant {
    private final MUCAffiliation affiliation;
    private final String jid;
    private final String nick;
    private final MUCRole role;

    public Occupant(MUCItem mUCItem) {
        this.jid = mUCItem.getJid();
        this.affiliation = mUCItem.getAffiliation();
        this.role = mUCItem.getRole();
        this.nick = mUCItem.getNick();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Occupant) {
            return this.jid.equals(((Occupant) obj).jid);
        }
        return false;
    }

    public MUCAffiliation getAffiliation() {
        return this.affiliation;
    }

    public String getJid() {
        return this.jid;
    }

    public String getNick() {
        return this.nick;
    }

    public MUCRole getRole() {
        return this.role;
    }

    public int hashCode() {
        int iHashCode = ((((this.affiliation.hashCode() * 17) + this.role.hashCode()) * 17) + this.jid.hashCode()) * 17;
        String str = this.nick;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public Occupant(Presence presence) {
        MUCItem item = ((MUCUser) presence.getExtension("x", "http://jabber.org/protocol/muc#user")).getItem();
        this.jid = item.getJid();
        this.affiliation = item.getAffiliation();
        this.role = item.getRole();
        this.nick = WearUtils.e1(presence.getFrom()) ? "" : XmppStringUtils.parseResource(presence.getFrom());
    }
}
