package org.jivesoftware.smackx.caps.provider;

import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smackx.caps.packet.CapsExtension;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class CapsExtensionProvider extends ExtensionElementProvider<CapsExtension> {
    @Override // org.jivesoftware.smack.provider.Provider
    public CapsExtension parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
        if (xmlPullParser.getEventType() != 2 || !xmlPullParser.getName().equalsIgnoreCase("c")) {
            throw new SmackException("Malformed Caps element");
        }
        String attributeValue = xmlPullParser.getAttributeValue(null, "hash");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, RosterVer.ELEMENT);
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "node");
        xmlPullParser.next();
        if (xmlPullParser.getEventType() != 3 || !xmlPullParser.getName().equalsIgnoreCase("c")) {
            throw new SmackException("Malformed nested Caps element");
        }
        if (attributeValue != null && attributeValue2 != null && attributeValue3 != null) {
            return new CapsExtension(attributeValue3, attributeValue2, attributeValue);
        }
        throw new SmackException("Caps elment with missing attributes. Attributes: hash=" + attributeValue + " version=" + attributeValue2 + " node=" + attributeValue3);
    }
}
