package org.jivesoftware.smackx.xdatalayout.provider;

import com.google.firebase.messaging.Constants;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class DataLayoutProvider {
    public static DataLayout parse(XmlPullParser xmlPullParser) throws XmlPullParserException, SmackException, IOException {
        DataLayout dataLayout = new DataLayout(xmlPullParser.getAttributeValue("", Constants.ScionAnalytics.PARAM_LABEL));
        parseLayout(dataLayout.getPageLayout(), xmlPullParser);
        return dataLayout;
    }

    private static DataLayout.Fieldref parseFieldref(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        DataLayout.Fieldref fieldref = new DataLayout.Fieldref(xmlPullParser.getAttributeValue("", "var"));
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return fieldref;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void parseLayout(java.util.List<org.jivesoftware.smackx.xdatalayout.packet.DataLayout.DataFormLayoutElement> r6, org.xmlpull.v1.XmlPullParser r7) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r7.getDepth()
        L4:
            int r1 = r7.next()
            r2 = 3
            r3 = 2
            if (r1 == r3) goto L16
            if (r1 == r2) goto Lf
            goto L4
        Lf:
            int r1 = r7.getDepth()
            if (r1 != r0) goto L4
            return
        L16:
            java.lang.String r1 = r7.getName()
            r1.hashCode()
            r4 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -928989863: goto L46;
                case -241484064: goto L3b;
                case 3556653: goto L30;
                case 1970241253: goto L27;
                default: goto L25;
            }
        L25:
            r2 = -1
            goto L50
        L27:
            java.lang.String r3 = "section"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L50
            goto L25
        L30:
            java.lang.String r2 = "text"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L39
            goto L25
        L39:
            r2 = 2
            goto L50
        L3b:
            java.lang.String r2 = "reportedref"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L44
            goto L25
        L44:
            r2 = 1
            goto L50
        L46:
            java.lang.String r2 = "fieldref"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L4f
            goto L25
        L4f:
            r2 = 0
        L50:
            switch(r2) {
                case 0: goto L72;
                case 1: goto L69;
                case 2: goto L5c;
                case 3: goto L54;
                default: goto L53;
            }
        L53:
            goto L4
        L54:
            org.jivesoftware.smackx.xdatalayout.packet.DataLayout$Section r1 = parseSection(r7)
            r6.add(r1)
            goto L4
        L5c:
            org.jivesoftware.smackx.xdatalayout.packet.DataLayout$Text r1 = new org.jivesoftware.smackx.xdatalayout.packet.DataLayout$Text
            java.lang.String r2 = r7.nextText()
            r1.<init>(r2)
            r6.add(r1)
            goto L4
        L69:
            org.jivesoftware.smackx.xdatalayout.packet.DataLayout$Reportedref r1 = new org.jivesoftware.smackx.xdatalayout.packet.DataLayout$Reportedref
            r1.<init>()
            r6.add(r1)
            goto L4
        L72:
            org.jivesoftware.smackx.xdatalayout.packet.DataLayout$Fieldref r1 = parseFieldref(r7)
            r6.add(r1)
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.xdatalayout.provider.DataLayoutProvider.parseLayout(java.util.List, org.xmlpull.v1.XmlPullParser):void");
    }

    private static DataLayout.Section parseSection(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        DataLayout.Section section = new DataLayout.Section(xmlPullParser.getAttributeValue("", Constants.ScionAnalytics.PARAM_LABEL));
        parseLayout(section.getSectionLayout(), xmlPullParser);
        return section;
    }
}
