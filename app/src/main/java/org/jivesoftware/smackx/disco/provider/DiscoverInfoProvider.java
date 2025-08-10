package org.jivesoftware.smackx.disco.provider;

import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class DiscoverInfoProvider extends IQProvider<DiscoverInfo> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    @Override // org.jivesoftware.smack.provider.Provider
    public DiscoverInfo parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
        DiscoverInfo discoverInfo = new DiscoverInfo();
        discoverInfo.setNode(xmlPullParser.getAttributeValue("", "node"));
        boolean z = false;
        String attributeValue = "";
        String attributeValue2 = attributeValue;
        String attributeValue3 = attributeValue2;
        String attributeValue4 = attributeValue3;
        String attributeValue5 = attributeValue4;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("identity")) {
                    attributeValue = xmlPullParser.getAttributeValue("", "category");
                    attributeValue3 = xmlPullParser.getAttributeValue("", "name");
                    attributeValue2 = xmlPullParser.getAttributeValue("", "type");
                    attributeValue4 = xmlPullParser.getAttributeValue(xmlPullParser.getNamespace("xml"), "lang");
                } else if (xmlPullParser.getName().equals("feature")) {
                    attributeValue5 = xmlPullParser.getAttributeValue("", "var");
                } else {
                    PacketParserUtils.addExtensionElement(discoverInfo, xmlPullParser);
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("identity")) {
                    discoverInfo.addIdentity(new DiscoverInfo.Identity(attributeValue, attributeValue2, attributeValue3, attributeValue4));
                }
                if (xmlPullParser.getName().equals("feature")) {
                    discoverInfo.addFeature(attributeValue5);
                }
                if (xmlPullParser.getName().equals("query")) {
                    z = true;
                }
            }
        }
        return discoverInfo;
    }
}
