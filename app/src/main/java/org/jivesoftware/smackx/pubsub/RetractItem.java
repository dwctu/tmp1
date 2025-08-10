package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;

/* loaded from: classes5.dex */
public class RetractItem implements ExtensionElement {
    private String id;

    public RetractItem(String str) {
        if (str == null) {
            throw new IllegalArgumentException("itemId must not be 'null'");
        }
        this.id = str;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "retract";
    }

    public String getId() {
        return this.id;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return PubSubNamespace.EVENT.getXmlns();
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML() {
        return "<retract id='" + this.id + "'/>";
    }
}
