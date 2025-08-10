package org.jivesoftware.smackx.shim.packet;

import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class HeadersExtension implements ExtensionElement {
    public static final String ELEMENT = "headers";
    public static final String NAMESPACE = "http://jabber.org/protocol/shim";
    private final List<Header> headers;

    public HeadersExtension(List<Header> list) {
        if (list != null) {
            this.headers = Collections.unmodifiableList(list);
        } else {
            this.headers = Collections.emptyList();
        }
    }

    public static HeadersExtension from(Stanza stanza) {
        return (HeadersExtension) stanza.getExtension(ELEMENT, NAMESPACE);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.headers);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
