package org.jivesoftware.smackx.disco.provider;

import com.epicgames.unreal.psoservices.PSOProgramService;
import java.io.IOException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class DiscoverItemsProvider extends IQProvider<DiscoverItems> {
    @Override // org.jivesoftware.smack.provider.Provider
    public DiscoverItems parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        DiscoverItems discoverItems = new DiscoverItems();
        discoverItems.setNode(xmlPullParser.getAttributeValue("", "node"));
        boolean z = false;
        String attributeValue = "";
        String attributeValue2 = attributeValue;
        String attributeValue3 = attributeValue2;
        String attributeValue4 = attributeValue3;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2 && "item".equals(xmlPullParser.getName())) {
                attributeValue = xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key);
                attributeValue2 = xmlPullParser.getAttributeValue("", "name");
                attributeValue3 = xmlPullParser.getAttributeValue("", "node");
                attributeValue4 = xmlPullParser.getAttributeValue("", AMPExtension.Action.ATTRIBUTE_NAME);
            } else if (next == 3 && "item".equals(xmlPullParser.getName())) {
                DiscoverItems.Item item = new DiscoverItems.Item(attributeValue);
                item.setName(attributeValue2);
                item.setNode(attributeValue3);
                item.setAction(attributeValue4);
                discoverItems.addItem(item);
            } else if (next == 3 && "query".equals(xmlPullParser.getName())) {
                z = true;
            }
        }
        return discoverItems;
    }
}
