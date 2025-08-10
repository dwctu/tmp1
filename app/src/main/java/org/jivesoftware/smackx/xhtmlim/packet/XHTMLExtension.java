package org.jivesoftware.smackx.xhtmlim.packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class XHTMLExtension implements ExtensionElement {
    public static final String ELEMENT = "html";
    public static final String NAMESPACE = "http://jabber.org/protocol/xhtml-im";
    private List<CharSequence> bodies = new ArrayList();

    public static XHTMLExtension from(Message message) {
        return (XHTMLExtension) message.getExtension(ELEMENT, NAMESPACE);
    }

    public void addBody(CharSequence charSequence) {
        synchronized (this.bodies) {
            this.bodies.add(charSequence);
        }
    }

    public List<CharSequence> getBodies() {
        List<CharSequence> listUnmodifiableList;
        synchronized (this.bodies) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(this.bodies));
        }
        return listUnmodifiableList;
    }

    public int getBodiesCount() {
        int size;
        synchronized (this.bodies) {
            size = this.bodies.size();
        }
        return size;
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
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        Iterator<CharSequence> it = getBodies().iterator();
        while (it.hasNext()) {
            xmlStringBuilder.append(it.next());
        }
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
