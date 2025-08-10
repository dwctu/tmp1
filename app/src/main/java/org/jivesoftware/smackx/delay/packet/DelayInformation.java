package org.jivesoftware.smackx.delay.packet;

import java.util.Date;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.util.XmppDateTime;

/* loaded from: classes5.dex */
public class DelayInformation implements ExtensionElement {
    public static final String ELEMENT = "delay";
    public static final String NAMESPACE = "urn:xmpp:delay";
    private final String from;
    private final String reason;
    private final Date stamp;

    public DelayInformation(Date date, String str, String str2) {
        this.stamp = date;
        this.from = str;
        this.reason = str2;
    }

    public static DelayInformation from(Stanza stanza) {
        return (DelayInformation) stanza.getExtension(ELEMENT, NAMESPACE);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public String getFrom() {
        return this.from;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public String getReason() {
        return this.reason;
    }

    public Date getStamp() {
        return this.stamp;
    }

    @Deprecated
    public static DelayInformation getFrom(Stanza stanza) {
        return from(stanza);
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("stamp", XmppDateTime.formatXEP0082Date(this.stamp));
        xmlStringBuilder.optAttribute("from", this.from);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optAppend(this.reason);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public DelayInformation(Date date) {
        this(date, null, null);
    }
}
