package org.jivesoftware.smackx.muc.provider;

import java.io.IOException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.muc.packet.MUCMember;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class MUCMemberProvider extends IQProvider<MUCMember> {
    @Override // org.jivesoftware.smack.provider.Provider
    public MUCMember parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        MUCMember mUCMember = new MUCMember();
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("member")) {
                    mUCMember.addItem(MUCParserUtils.parseNewItem(xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("query")) {
                z = true;
            }
        }
        return mUCMember;
    }
}
