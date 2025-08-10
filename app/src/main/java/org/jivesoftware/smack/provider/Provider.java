package org.jivesoftware.smack.provider;

import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.util.ParserUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public abstract class Provider<E extends Element> {
    public final E parse(XmlPullParser xmlPullParser) throws XmlPullParserException, SmackException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        E e = (E) parse(xmlPullParser, depth);
        ParserUtils.forwardToEndTagOfDepth(xmlPullParser, depth);
        return e;
    }

    public abstract E parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException;
}
