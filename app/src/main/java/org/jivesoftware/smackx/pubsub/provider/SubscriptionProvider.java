package org.jivesoftware.smackx.pubsub.provider;

import com.epicgames.unreal.psoservices.PSOProgramService;
import java.io.IOException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.pubsub.Subscription;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class SubscriptionProvider extends ExtensionElementProvider<Subscription> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Subscription parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        boolean z;
        String attributeValue = xmlPullParser.getAttributeValue(null, PSOProgramService.JobID_Key);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "node");
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "subid");
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "subscription");
        boolean z2 = false;
        if (xmlPullParser.next() == 2 && xmlPullParser.getName().equals("subscribe-options")) {
            int next = xmlPullParser.next();
            if (next == 2 && xmlPullParser.getName().equals("required")) {
                z2 = true;
            }
            while (next != 3 && !xmlPullParser.getName().equals("subscribe-options")) {
                next = xmlPullParser.next();
            }
            z = z2;
        } else {
            z = false;
        }
        while (xmlPullParser.getEventType() != 3) {
            xmlPullParser.next();
        }
        return new Subscription(attributeValue, attributeValue2, attributeValue3, attributeValue4 != null ? Subscription.State.valueOf(attributeValue4) : null, z);
    }
}
