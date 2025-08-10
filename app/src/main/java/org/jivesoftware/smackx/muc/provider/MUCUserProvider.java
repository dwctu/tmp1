package org.jivesoftware.smackx.muc.provider;

import java.io.IOException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class MUCUserProvider extends ExtensionElementProvider<MUCUser> {
    private static MUCUser.Decline parseDecline(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        MUCUser.Decline decline = new MUCUser.Decline();
        decline.setFrom(xmlPullParser.getAttributeValue("", "from"));
        decline.setTo(xmlPullParser.getAttributeValue("", "to"));
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("reason")) {
                    decline.setReason(xmlPullParser.nextText());
                }
            } else if (next == 3 && xmlPullParser.getName().equals("decline")) {
                z = true;
            }
        }
        return decline;
    }

    private static MUCUser.Invite parseInvite(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        MUCUser.Invite invite = new MUCUser.Invite();
        invite.setFrom(xmlPullParser.getAttributeValue("", "from"));
        invite.setTo(xmlPullParser.getAttributeValue("", "to"));
        invite.setRoom(xmlPullParser.getAttributeValue("", "room"));
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("reason")) {
                    invite.setReason(xmlPullParser.nextText());
                }
            } else if (next == 3 && xmlPullParser.getName().equals(MUCUser.Invite.ELEMENT)) {
                z = true;
            }
        }
        return invite;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    @Override // org.jivesoftware.smack.provider.Provider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.jivesoftware.smackx.muc.packet.MUCUser parse(org.xmlpull.v1.XmlPullParser r7, int r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r6 = this;
            org.jivesoftware.smackx.muc.packet.MUCUser r0 = new org.jivesoftware.smackx.muc.packet.MUCUser
            r0.<init>()
        L5:
            int r1 = r7.next()
            r2 = 3
            r3 = 2
            if (r1 == r3) goto L17
            if (r1 == r2) goto L10
            goto L5
        L10:
            int r1 = r7.getDepth()
            if (r1 != r8) goto L5
            return r0
        L17:
            java.lang.String r1 = r7.getName()
            r1.hashCode()
            r4 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -1183699191: goto L5d;
                case -892481550: goto L52;
                case 3242771: goto L47;
                case 1216985755: goto L3e;
                case 1542349558: goto L33;
                case 1557372922: goto L28;
                default: goto L26;
            }
        L26:
            r2 = -1
            goto L67
        L28:
            java.lang.String r2 = "destroy"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L31
            goto L26
        L31:
            r2 = 5
            goto L67
        L33:
            java.lang.String r2 = "decline"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L3c
            goto L26
        L3c:
            r2 = 4
            goto L67
        L3e:
            java.lang.String r3 = "password"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L67
            goto L26
        L47:
            java.lang.String r2 = "item"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L50
            goto L26
        L50:
            r2 = 2
            goto L67
        L52:
            java.lang.String r2 = "status"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L5b
            goto L26
        L5b:
            r2 = 1
            goto L67
        L5d:
            java.lang.String r2 = "invite"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L66
            goto L26
        L66:
            r2 = 0
        L67:
            switch(r2) {
                case 0: goto L9d;
                case 1: goto L8c;
                case 2: goto L83;
                case 3: goto L7b;
                case 4: goto L73;
                case 5: goto L6b;
                default: goto L6a;
            }
        L6a:
            goto L5
        L6b:
            org.jivesoftware.smackx.muc.packet.Destroy r1 = org.jivesoftware.smackx.muc.provider.MUCParserUtils.parseDestroy(r7)
            r0.setDestroy(r1)
            goto L5
        L73:
            org.jivesoftware.smackx.muc.packet.MUCUser$Decline r1 = parseDecline(r7)
            r0.setDecline(r1)
            goto L5
        L7b:
            java.lang.String r1 = r7.nextText()
            r0.setPassword(r1)
            goto L5
        L83:
            org.jivesoftware.smackx.muc.packet.MUCItem r1 = org.jivesoftware.smackx.muc.provider.MUCParserUtils.parseItem(r7)
            r0.setItem(r1)
            goto L5
        L8c:
            java.lang.String r1 = ""
            java.lang.String r2 = "code"
            java.lang.String r1 = r7.getAttributeValue(r1, r2)
            org.jivesoftware.smackx.muc.packet.MUCUser$Status r1 = org.jivesoftware.smackx.muc.packet.MUCUser.Status.create(r1)
            r0.addStatusCode(r1)
            goto L5
        L9d:
            org.jivesoftware.smackx.muc.packet.MUCUser$Invite r1 = parseInvite(r7)
            r0.setInvite(r1)
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.muc.provider.MUCUserProvider.parse(org.xmlpull.v1.XmlPullParser, int):org.jivesoftware.smackx.muc.packet.MUCUser");
    }
}
