package org.jivesoftware.smackx.muc;

import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* loaded from: classes5.dex */
public class HostedRoom {
    private final String jid;
    private final String name;

    public HostedRoom(DiscoverItems.Item item) {
        this.jid = item.getEntityID();
        this.name = item.getName();
    }

    public String getJid() {
        return this.jid;
    }

    public String getName() {
        return this.name;
    }
}
