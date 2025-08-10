package org.jivesoftware.smackx.pubsub;

/* loaded from: classes5.dex */
public class Item extends NodeExtension {
    private String id;

    public Item() {
        super(PubSubElementType.ITEM);
    }

    public String getId() {
        return this.id;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension, org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return null;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension
    public String toString() {
        return getClass().getName() + " | Content [" + toXML() + "]";
    }

    public Item(String str) {
        super(PubSubElementType.ITEM);
        this.id = str;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension, org.jivesoftware.smack.packet.Element
    public String toXML() {
        StringBuilder sb = new StringBuilder("<item");
        if (this.id != null) {
            sb.append(" id='");
            sb.append(this.id);
            sb.append("'");
        }
        if (getNode() != null) {
            sb.append(" node='");
            sb.append(getNode());
            sb.append("'");
        }
        sb.append("/>");
        return sb.toString();
    }

    public Item(String str, String str2) {
        super(PubSubElementType.ITEM_EVENT, str2);
        this.id = str;
    }
}
