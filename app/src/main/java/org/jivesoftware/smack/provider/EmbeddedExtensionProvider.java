package org.jivesoftware.smack.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public abstract class EmbeddedExtensionProvider<PE extends ExtensionElement> extends ExtensionElementProvider<PE> {
    public abstract PE createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list);

    @Override // org.jivesoftware.smack.provider.Provider
    public final PE parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
        String namespace = xmlPullParser.getNamespace();
        String name = xmlPullParser.getName();
        int attributeCount = xmlPullParser.getAttributeCount();
        HashMap map = new HashMap(attributeCount);
        for (int i2 = 0; i2 < attributeCount; i2++) {
            map.put(xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeValue(i2));
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                PacketParserUtils.addExtensionElement(arrayList, xmlPullParser);
            }
            if (next == 3 && xmlPullParser.getDepth() == i) {
                return (PE) createReturnExtension(name, namespace, map, arrayList);
            }
        }
    }
}
