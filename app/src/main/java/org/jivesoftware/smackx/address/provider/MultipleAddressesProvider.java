package org.jivesoftware.smackx.address.provider;

import androidx.core.app.NotificationCompat;
import com.epicgames.unreal.psoservices.PSOProgramService;
import java.io.IOException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class MultipleAddressesProvider extends ExtensionElementProvider<MultipleAddresses> {
    @Override // org.jivesoftware.smack.provider.Provider
    public MultipleAddresses parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        MultipleAddresses multipleAddresses = new MultipleAddresses();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(MultipleAddresses.Address.ELEMENT)) {
                    multipleAddresses.addAddress(MultipleAddresses.Type.valueOf(xmlPullParser.getAttributeValue("", "type")), xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key), xmlPullParser.getAttributeValue("", "node"), xmlPullParser.getAttributeValue("", "desc"), "true".equals(xmlPullParser.getAttributeValue("", "delivered")), xmlPullParser.getAttributeValue("", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI));
                }
            } else if (next == 3 && xmlPullParser.getDepth() == i) {
                return multipleAddresses;
            }
        }
    }
}
