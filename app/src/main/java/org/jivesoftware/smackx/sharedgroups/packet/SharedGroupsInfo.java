package org.jivesoftware.smackx.sharedgroups.packet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class SharedGroupsInfo extends IQ {
    public static final String ELEMENT = "sharedgroup";
    public static final String NAMESPACE = "http://www.jivesoftware.org/protocol/sharedgroup";
    private List<String> groups;

    public static class Provider extends IQProvider<SharedGroupsInfo> {
        @Override // org.jivesoftware.smack.provider.Provider
        public SharedGroupsInfo parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
            SharedGroupsInfo sharedGroupsInfo = new SharedGroupsInfo();
            boolean z = false;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2 && xmlPullParser.getName().equals("group")) {
                    sharedGroupsInfo.getGroups().add(xmlPullParser.nextText());
                } else if (next == 3 && xmlPullParser.getName().equals(SharedGroupsInfo.ELEMENT)) {
                    z = true;
                }
            }
            return sharedGroupsInfo;
        }
    }

    public SharedGroupsInfo() {
        super(ELEMENT, NAMESPACE);
        this.groups = new ArrayList();
    }

    public List<String> getGroups() {
        return this.groups;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        Iterator<String> it = this.groups.iterator();
        while (it.hasNext()) {
            iQChildElementXmlStringBuilder.element("group", it.next());
        }
        return iQChildElementXmlStringBuilder;
    }
}
