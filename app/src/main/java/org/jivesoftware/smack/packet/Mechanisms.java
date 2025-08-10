package org.jivesoftware.smack.packet;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class Mechanisms implements ExtensionElement {
    public static final String ELEMENT = "mechanisms";
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-sasl";
    public final List<String> mechanisms;

    public Mechanisms(String str) {
        LinkedList linkedList = new LinkedList();
        this.mechanisms = linkedList;
        linkedList.add(str);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public List<String> getMechanisms() {
        return Collections.unmodifiableList(this.mechanisms);
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return "urn:ietf:params:xml:ns:xmpp-sasl";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        Iterator<String> it = this.mechanisms.iterator();
        while (it.hasNext()) {
            xmlStringBuilder.element("mechanism", it.next());
        }
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public Mechanisms(Collection<String> collection) {
        LinkedList linkedList = new LinkedList();
        this.mechanisms = linkedList;
        linkedList.addAll(collection);
    }
}
