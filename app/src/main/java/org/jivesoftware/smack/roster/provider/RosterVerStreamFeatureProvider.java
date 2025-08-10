package org.jivesoftware.smack.roster.provider;

import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class RosterVerStreamFeatureProvider extends ExtensionElementProvider<RosterVer> {
    @Override // org.jivesoftware.smack.provider.Provider
    public RosterVer parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
        return RosterVer.INSTANCE;
    }
}
