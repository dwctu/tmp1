package org.jivesoftware.smackx.offline;

import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* loaded from: classes5.dex */
public class OfflineMessageHeader {
    private String jid;
    private String stamp;
    private String user;

    public OfflineMessageHeader(DiscoverItems.Item item) {
        this.user = item.getEntityID();
        this.jid = item.getName();
        this.stamp = item.getNode();
    }

    public String getJid() {
        return this.jid;
    }

    public String getStamp() {
        return this.stamp;
    }

    public String getUser() {
        return this.user;
    }
}
