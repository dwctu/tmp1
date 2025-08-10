package org.jivesoftware.smackx.attention.packet;

import com.j256.ormlite.stmt.query.SimpleComparison;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class AttentionExtension implements ExtensionElement {
    public static final String ELEMENT_NAME = "attention";
    public static final String NAMESPACE = "urn:xmpp:attention:0";

    public static class Provider extends ExtensionElementProvider<AttentionExtension> {
        @Override // org.jivesoftware.smack.provider.Provider
        public AttentionExtension parse(XmlPullParser xmlPullParser, int i) {
            return new AttentionExtension();
        }
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT_NAME;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML() {
        return SimpleComparison.LESS_THAN_OPERATION + getElementName() + " xmlns=\"" + getNamespace() + "\"/>";
    }
}
