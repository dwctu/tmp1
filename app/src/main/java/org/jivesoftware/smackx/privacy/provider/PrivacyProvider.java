package org.jivesoftware.smackx.privacy.provider;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.wear.bean.SyncWsProtocol;
import java.io.IOException;
import java.util.ArrayList;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.jivesoftware.smackx.privacy.packet.Privacy;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class PrivacyProvider extends IQProvider<Privacy> {
    private static PrivacyItem parseItem(XmlPullParser xmlPullParser) throws SmackException, XmlPullParserException, IOException {
        boolean z;
        PrivacyItem privacyItem;
        String attributeValue = xmlPullParser.getAttributeValue("", AMPExtension.Action.ATTRIBUTE_NAME);
        long jLongValue = ParserUtils.getLongAttribute(xmlPullParser, SyncWsProtocol.CONTROL_ORDER_TOY_TYPE_KEY).longValue();
        String attributeValue2 = xmlPullParser.getAttributeValue("", "type");
        attributeValue.hashCode();
        if (attributeValue.equals("deny")) {
            z = false;
        } else {
            if (!attributeValue.equals("allow")) {
                throw new SmackException("Unkown action value '" + attributeValue + "'");
            }
            z = true;
        }
        if (attributeValue2 != null) {
            privacyItem = new PrivacyItem(PrivacyItem.Type.valueOf(attributeValue2), xmlPullParser.getAttributeValue("", "value"), z, jLongValue);
        } else {
            privacyItem = new PrivacyItem(z, jLongValue);
        }
        parseItemChildElements(xmlPullParser, privacyItem);
        return privacyItem;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void parseItemChildElements(org.xmlpull.v1.XmlPullParser r7, org.jivesoftware.smackx.privacy.packet.PrivacyItem r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
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
            r6 = 1
            switch(r5) {
                case -1240091849: goto L47;
                case 3368: goto L3c;
                case 211864444: goto L31;
                case 954925063: goto L28;
                default: goto L26;
            }
        L26:
            r2 = -1
            goto L51
        L28:
            java.lang.String r3 = "message"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L51
            goto L26
        L31:
            java.lang.String r2 = "presence-out"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L3a
            goto L26
        L3a:
            r2 = 2
            goto L51
        L3c:
            java.lang.String r2 = "iq"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L45
            goto L26
        L45:
            r2 = 1
            goto L51
        L47:
            java.lang.String r2 = "presence-in"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L50
            goto L26
        L50:
            r2 = 0
        L51:
            switch(r2) {
                case 0: goto L61;
                case 1: goto L5d;
                case 2: goto L59;
                case 3: goto L55;
                default: goto L54;
            }
        L54:
            goto L4
        L55:
            r8.setFilterMessage(r6)
            goto L4
        L59:
            r8.setFilterPresenceOut(r6)
            goto L4
        L5d:
            r8.setFilterIQ(r6)
            goto L4
        L61:
            r8.setFilterPresenceIn(r6)
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.privacy.provider.PrivacyProvider.parseItemChildElements(org.xmlpull.v1.XmlPullParser, org.jivesoftware.smackx.privacy.packet.PrivacyItem):void");
    }

    private static void parseList(XmlPullParser xmlPullParser, Privacy privacy) throws XmlPullParserException, SmackException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", "name");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("item")) {
                    arrayList.add(parseItem(xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("list")) {
                z = true;
            }
        }
        privacy.setPrivacyList(attributeValue, arrayList);
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public Privacy parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
        Privacy privacy = new Privacy();
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE)) {
                    String attributeValue = xmlPullParser.getAttributeValue("", "name");
                    if (attributeValue == null) {
                        privacy.setDeclineActiveList(true);
                    } else {
                        privacy.setActiveName(attributeValue);
                    }
                } else if (xmlPullParser.getName().equals("default")) {
                    String attributeValue2 = xmlPullParser.getAttributeValue("", "name");
                    if (attributeValue2 == null) {
                        privacy.setDeclineDefaultList(true);
                    } else {
                        privacy.setDefaultName(attributeValue2);
                    }
                } else if (xmlPullParser.getName().equals("list")) {
                    parseList(xmlPullParser, privacy);
                }
            } else if (next == 3 && xmlPullParser.getName().equals("query")) {
                z = true;
            }
        }
        return privacy;
    }
}
