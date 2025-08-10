package org.jivesoftware.smackx.pubsub.provider;

import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.pubsub.packet.PubSub;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class PubSubProvider extends IQProvider<PubSub> {
    @Override // org.jivesoftware.smack.provider.Provider
    public PubSub parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
        PubSub pubSub = new PubSub(PubSubNamespace.valueOfFromXmlns(xmlPullParser.getNamespace()));
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                PacketParserUtils.addExtensionElement(pubSub, xmlPullParser);
            } else if (next == 3 && xmlPullParser.getDepth() == i) {
                return pubSub;
            }
        }
    }
}
