package org.jivesoftware.smackx.disco.provider;

import java.io.IOException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.disco.bean.BaseResIQ;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class DafultProvider extends IQProvider<BaseResIQ> {
    @Override // org.jivesoftware.smack.provider.Provider
    public BaseResIQ parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        BaseResIQ baseResIQ = new BaseResIQ();
        xmlPullParser.getAttributeValue("", "api");
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2 && "body".equals(xmlPullParser.getName())) {
                baseResIQ.setBody(xmlPullParser.nextText());
            } else if (next == 3 && "query".equals(xmlPullParser.getName())) {
                z = true;
            }
        }
        return baseResIQ;
    }
}
