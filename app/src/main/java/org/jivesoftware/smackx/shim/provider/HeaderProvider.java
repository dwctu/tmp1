package org.jivesoftware.smackx.shim.provider;

import java.io.IOException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.shim.packet.Header;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class HeaderProvider extends ExtensionElementProvider<Header> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Header parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        xmlPullParser.next();
        String text = xmlPullParser.getEventType() == 4 ? xmlPullParser.getText() : null;
        while (xmlPullParser.getEventType() != 3) {
            xmlPullParser.next();
        }
        return new Header(attributeValue, text);
    }
}
