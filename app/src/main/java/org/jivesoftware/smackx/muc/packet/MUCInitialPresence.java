package org.jivesoftware.smackx.muc.packet;

import java.util.Date;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.util.XmppDateTime;

/* loaded from: classes5.dex */
public class MUCInitialPresence implements ExtensionElement {
    public static final String ELEMENT = "x";
    public static final String NAMESPACE = "http://jabber.org/protocol/muc";
    private History history;
    private String password;

    public static class History implements NamedElement {
        public static final String ELEMENT = "history";
        private int maxChars = -1;
        private int maxStanzas = -1;
        private int seconds = -1;
        private Date since;

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        public int getMaxChars() {
            return this.maxChars;
        }

        public int getMaxStanzas() {
            return this.maxStanzas;
        }

        public int getSeconds() {
            return this.seconds;
        }

        public Date getSince() {
            return this.since;
        }

        public void setMaxChars(int i) {
            this.maxChars = i;
        }

        public void setMaxStanzas(int i) {
            this.maxStanzas = i;
        }

        public void setSeconds(int i) {
            this.seconds = i;
        }

        public void setSince(Date date) {
            this.since = date;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.optIntAttribute("maxchars", getMaxChars());
            xmlStringBuilder.optIntAttribute("maxstanzas", getMaxStanzas());
            xmlStringBuilder.optIntAttribute("seconds", getSeconds());
            if (getSince() != null) {
                xmlStringBuilder.attribute("since", XmppDateTime.formatXEP0082Date(getSince()));
            }
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static MUCInitialPresence from(Stanza stanza) {
        return (MUCInitialPresence) stanza.getExtension("x", NAMESPACE);
    }

    @Deprecated
    public static MUCInitialPresence getFrom(Stanza stanza) {
        return from(stanza);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "x";
    }

    public History getHistory() {
        return this.history;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public String getPassword() {
        return this.password;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("password", getPassword());
        xmlStringBuilder.optElement(getHistory());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
