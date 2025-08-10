package org.jivesoftware.smackx.pubsub;

import java.util.Arrays;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;

/* loaded from: classes5.dex */
public class EventElement implements EmbeddedPacketExtension {
    private NodeExtension ext;
    private EventElementType type;

    public EventElement(EventElementType eventElementType, NodeExtension nodeExtension) {
        this.type = eventElementType;
        this.ext = nodeExtension;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "event";
    }

    public NodeExtension getEvent() {
        return this.ext;
    }

    public EventElementType getEventType() {
        return this.type;
    }

    @Override // org.jivesoftware.smackx.pubsub.EmbeddedPacketExtension
    public List<ExtensionElement> getExtensions() {
        return Arrays.asList(getEvent());
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return PubSubNamespace.EVENT.getXmlns();
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML() {
        return ("<event xmlns='" + PubSubNamespace.EVENT.getXmlns() + "'>") + this.ext.toXML() + "</event>";
    }
}
