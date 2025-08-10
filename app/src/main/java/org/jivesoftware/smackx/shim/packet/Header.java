package org.jivesoftware.smackx.shim.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class Header implements ExtensionElement {
    public static final String ELEMENT = "header";
    private final String name;
    private final String value;

    public Header(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public String getName() {
        return this.name;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return HeadersExtension.NAMESPACE;
    }

    public String getValue() {
        return this.value;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((NamedElement) this);
        xmlStringBuilder.attribute("name", this.name);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.escape(this.value);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
