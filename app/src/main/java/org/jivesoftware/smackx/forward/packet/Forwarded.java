package org.jivesoftware.smackx.forward.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.delay.packet.DelayInformation;

/* loaded from: classes5.dex */
public class Forwarded implements ExtensionElement {
    public static final String ELEMENT = "forwarded";
    public static final String NAMESPACE = "urn:xmpp:forward:0";
    private final DelayInformation delay;
    private final Stanza forwardedPacket;

    public Forwarded(DelayInformation delayInformation, Stanza stanza) {
        this.delay = delayInformation;
        this.forwardedPacket = stanza;
    }

    public static Forwarded from(Stanza stanza) {
        return (Forwarded) stanza.getExtension(ELEMENT, NAMESPACE);
    }

    public DelayInformation getDelayInformation() {
        return this.delay;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public Stanza getForwardedPacket() {
        return this.forwardedPacket;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement(getDelayInformation());
        xmlStringBuilder.append(this.forwardedPacket.toXML());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public Forwarded(Stanza stanza) {
        this(null, stanza);
    }
}
