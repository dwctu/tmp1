package org.jivesoftware.smackx.muc.provider;

import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.muc.packet.Destroy;
import org.jivesoftware.smackx.muc.packet.MUCOwner;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class MUCOwnerProvider extends IQProvider<MUCOwner> {
    @Override // org.jivesoftware.smack.provider.Provider
    public MUCOwner parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
        MUCOwner mUCOwner = new MUCOwner();
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("item")) {
                    mUCOwner.addItem(MUCParserUtils.parseItem(xmlPullParser));
                } else if (xmlPullParser.getName().equals(Destroy.ELEMENT)) {
                    mUCOwner.setDestroy(MUCParserUtils.parseDestroy(xmlPullParser));
                } else {
                    PacketParserUtils.addExtensionElement(mUCOwner, xmlPullParser);
                }
            } else if (next == 3 && xmlPullParser.getName().equals("query")) {
                z = true;
            }
        }
        return mUCOwner;
    }
}
