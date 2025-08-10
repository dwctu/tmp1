package org.jivesoftware.smackx.pubsub;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: classes5.dex */
public class SubscribeExtension extends NodeExtension {
    public String jid;

    public SubscribeExtension(String str) {
        super(PubSubElementType.SUBSCRIBE);
        this.jid = str;
    }

    public String getJid() {
        return this.jid;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension, org.jivesoftware.smack.packet.Element
    public String toXML() {
        StringBuilder sb = new StringBuilder(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getElementName());
        if (getNode() != null) {
            sb.append(" node='");
            sb.append(getNode());
            sb.append("'");
        }
        sb.append(" jid='");
        sb.append(getJid());
        sb.append("'/>");
        return sb.toString();
    }

    public SubscribeExtension(String str, String str2) {
        super(PubSubElementType.SUBSCRIBE, str2);
        this.jid = str;
    }
}
