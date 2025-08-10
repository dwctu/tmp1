package org.jivesoftware.smack.packet;

import com.epicgames.unreal.psoservices.PSOProgramService;
import org.jivesoftware.smack.packet.IQ;

/* loaded from: classes5.dex */
public class Bind extends IQ {
    public static final String ELEMENT = "bind";
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-bind";
    private final String jid;
    private final String resource;

    public static class Feature implements ExtensionElement {
        public static final Feature INSTANCE = new Feature();

        private Feature() {
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return Bind.ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.ExtensionElement
        public String getNamespace() {
            return Bind.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public String toXML() {
            return "<bind xmlns='urn:ietf:params:xml:ns:xmpp-bind'/>";
        }
    }

    public Bind(String str, String str2) {
        super(ELEMENT, NAMESPACE);
        this.resource = str;
        this.jid = str2;
    }

    public static Bind newResult(String str) {
        return new Bind(null, str);
    }

    public static Bind newSet(String str) {
        Bind bind = new Bind(str, null);
        bind.setType(IQ.Type.set);
        return bind;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("resource", this.resource);
        iQChildElementXmlStringBuilder.optElement(PSOProgramService.JobID_Key, this.jid);
        return iQChildElementXmlStringBuilder;
    }

    public String getJid() {
        return this.jid;
    }

    public String getResource() {
        return this.resource;
    }
}
