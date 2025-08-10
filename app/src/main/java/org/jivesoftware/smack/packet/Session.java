package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class Session extends SimpleIQ {
    public static final String ELEMENT = "session";
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-session";

    public static class Feature implements ExtensionElement {
        public static final String OPTIONAL_ELEMENT = "optional";
        private final boolean optional;

        public Feature(boolean z) {
            this.optional = z;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "session";
        }

        @Override // org.jivesoftware.smack.packet.ExtensionElement
        public String getNamespace() {
            return Session.NAMESPACE;
        }

        public boolean isOptional() {
            return this.optional;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            if (this.optional) {
                xmlStringBuilder.rightAngleBracket();
                xmlStringBuilder.emptyElement(OPTIONAL_ELEMENT);
                xmlStringBuilder.closeElement(this);
            } else {
                xmlStringBuilder.closeEmptyElement();
            }
            return xmlStringBuilder;
        }
    }

    public Session() {
        super("session", NAMESPACE);
        setType(IQ.Type.set);
    }
}
