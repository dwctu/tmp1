package org.jivesoftware.smackx.muc;

import org.jivesoftware.smackx.muc.packet.MUCItem;

/* loaded from: classes5.dex */
public class Affiliate {
    private final MUCAffiliation affiliation;
    private final String binval;
    private final String jid;
    private final String nick;
    private final MUCRole role;

    public Affiliate(MUCItem mUCItem) {
        this.jid = mUCItem.getJid();
        this.affiliation = mUCItem.getAffiliation();
        this.role = mUCItem.getRole();
        this.nick = mUCItem.getNick();
        this.binval = mUCItem.getBinval();
    }

    public MUCAffiliation getAffiliation() {
        return this.affiliation;
    }

    public String getBinval() {
        return this.binval;
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
}
