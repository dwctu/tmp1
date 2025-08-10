package org.jivesoftware.smackx.muc.provider;

import java.io.IOException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.muc.packet.MUCAdmin;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class MUCAdminProvider extends IQProvider<MUCAdmin> {
    @Override // org.jivesoftware.smack.provider.Provider
    public MUCAdmin parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("item")) {
                    mUCAdmin.addItem(MUCParserUtils.parseItem(xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("query")) {
                z = true;
            }
        }
        return mUCAdmin;
    }
}
