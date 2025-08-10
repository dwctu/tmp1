package org.jivesoftware.smackx.forward.provider;

import java.io.IOException;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.delay.packet.DelayInformation;
import org.jivesoftware.smackx.delay.provider.DelayInformationProvider;
import org.jivesoftware.smackx.forward.packet.Forwarded;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class ForwardedProvider extends ExtensionElementProvider<Forwarded> {
    private static final Logger LOGGER = Logger.getLogger(ForwardedProvider.class.getName());

    @Override // org.jivesoftware.smack.provider.Provider
    public Forwarded parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
        Message message = null;
        DelayInformation delayInformation = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                name.hashCode();
                if (name.equals(DelayInformation.ELEMENT)) {
                    if (DelayInformation.NAMESPACE.equals(namespace)) {
                        delayInformation = DelayInformationProvider.INSTANCE.parse(xmlPullParser, xmlPullParser.getDepth());
                    } else {
                        LOGGER.warning("Namespace '" + namespace + "' does not match expected namespace '" + DelayInformation.NAMESPACE + "'");
                    }
                } else if (name.equals("message")) {
                    message = PacketParserUtils.parseMessage(xmlPullParser);
                } else {
                    LOGGER.warning("Unsupported forwarded packet type: " + name);
                }
            } else if (next == 3 && xmlPullParser.getDepth() == i) {
                break;
            }
        }
        if (message != null) {
            return new Forwarded(delayInformation, message);
        }
        throw new SmackException("forwarded extension must contain a packet");
    }
}
