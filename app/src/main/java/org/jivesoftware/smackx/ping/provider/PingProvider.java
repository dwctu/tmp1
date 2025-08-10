package org.jivesoftware.smackx.ping.provider;

import java.io.IOException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.ping.packet.Ping;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class PingProvider extends IQProvider<Ping> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Ping parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        return new Ping();
    }
}
