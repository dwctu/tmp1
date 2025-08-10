package org.jivesoftware.smackx.nick.packet;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import kotlin.text.Typography;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class Nick implements ExtensionElement {
    public static final String ELEMENT_NAME = "nick";
    public static final String NAMESPACE = "http://jabber.org/protocol/nick";
    private String name;

    public static class Provider extends ExtensionElementProvider<Nick> {
        @Override // org.jivesoftware.smack.provider.Provider
        public Nick parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
            xmlPullParser.next();
            String text = xmlPullParser.getText();
            while (xmlPullParser.getEventType() != 3) {
                xmlPullParser.next();
            }
            return new Nick(text);
        }
    }

    public Nick(String str) {
        this.name = null;
        this.name = str;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT_NAME;
    }

    public String getName() {
        return this.name;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML() {
        return SimpleComparison.LESS_THAN_OPERATION + ELEMENT_NAME + " xmlns=\"" + NAMESPACE + "\">" + getName() + "</" + ELEMENT_NAME + Typography.greater;
    }
}
