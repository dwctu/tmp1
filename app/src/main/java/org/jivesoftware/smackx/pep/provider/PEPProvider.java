package org.jivesoftware.smackx.pep.provider;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class PEPProvider extends ExtensionElementProvider<ExtensionElement> {
    private static final Map<String, ExtensionElementProvider<?>> nodeParsers = new HashMap();

    public static void registerPEPParserExtension(String str, ExtensionElementProvider<?> extensionElementProvider) {
        nodeParsers.put(str, extensionElementProvider);
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public ExtensionElement parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
        ExtensionElement extensionElement = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (!xmlPullParser.getName().equals("event") && xmlPullParser.getName().equals(FirebaseAnalytics.Param.ITEMS)) {
                    ExtensionElementProvider<?> extensionElementProvider = nodeParsers.get(xmlPullParser.getAttributeValue("", "node"));
                    if (extensionElementProvider != null) {
                        extensionElement = (ExtensionElement) extensionElementProvider.parse(xmlPullParser);
                    }
                }
            } else if (next == 3 && xmlPullParser.getName().equals("event")) {
                z = true;
            }
        }
        return extensionElement;
    }
}
