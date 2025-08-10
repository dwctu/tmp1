package org.jivesoftware.smackx.iqregister.packet;

import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;

/* loaded from: classes5.dex */
public class Registration extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:register";
    private final Map<String, String> attributes;
    private final String instructions;

    public static class Feature implements ExtensionElement {
        public static final String ELEMENT = "register";
        public static final Feature INSTANCE = new Feature();
        public static final String NAMESPACE = "http://jabber.org/features/iq-register";

        private Feature() {
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.ExtensionElement
        public String getNamespace() {
            return NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML() {
            return "<register xmlns='http://jabber.org/features/iq-register'/>";
        }
    }

    public Registration() {
        this(null);
    }

    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("instructions", this.instructions);
        Map<String, String> map = this.attributes;
        if (map != null && map.size() > 0) {
            for (String str : this.attributes.keySet()) {
                iQChildElementXmlStringBuilder.element(str, this.attributes.get(str));
            }
        }
        return iQChildElementXmlStringBuilder;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public Registration(Map<String, String> map) {
        this(null, map);
    }

    public Registration(String str, Map<String, String> map) {
        super("query", NAMESPACE);
        this.instructions = str;
        this.attributes = map;
    }
}
