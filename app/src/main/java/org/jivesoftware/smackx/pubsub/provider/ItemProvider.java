package org.jivesoftware.smackx.pubsub.provider;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class ItemProvider extends ExtensionElementProvider<Item> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Item parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, TtmlNode.ATTR_ID);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "node");
        if (xmlPullParser.next() == 3) {
            return new Item(attributeValue, attributeValue2);
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        ExtensionElementProvider<ExtensionElement> extensionProvider = ProviderManager.getExtensionProvider(name, namespace);
        return extensionProvider == null ? new PayloadItem(attributeValue, attributeValue2, new SimplePayload(name, namespace, PacketParserUtils.parseElement(xmlPullParser, true))) : new PayloadItem(attributeValue, attributeValue2, extensionProvider.parse(xmlPullParser));
    }
}
