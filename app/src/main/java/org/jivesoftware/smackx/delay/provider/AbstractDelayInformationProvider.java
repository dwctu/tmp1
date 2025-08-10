package org.jivesoftware.smackx.delay.provider;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.delay.packet.DelayInformation;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public abstract class AbstractDelayInformationProvider extends ExtensionElementProvider<DelayInformation> {
    public abstract Date parseDate(String str) throws ParseException;

    @Override // org.jivesoftware.smack.provider.Provider
    public final DelayInformation parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
        String text = "";
        String attributeValue = xmlPullParser.getAttributeValue("", "stamp");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "from");
        if (xmlPullParser.isEmptyElementTag()) {
            xmlPullParser.next();
            text = null;
        } else {
            int next = xmlPullParser.next();
            if (next != 3) {
                if (next != 4) {
                    throw new IllegalStateException("Unexpected event: " + next);
                }
                text = xmlPullParser.getText();
                xmlPullParser.next();
            }
        }
        try {
            return new DelayInformation(parseDate(attributeValue), attributeValue2, text);
        } catch (ParseException e) {
            throw new SmackException(e);
        }
    }
}
