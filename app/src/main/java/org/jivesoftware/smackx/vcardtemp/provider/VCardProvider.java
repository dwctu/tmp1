package org.jivesoftware.smackx.vcardtemp.provider;

import java.io.IOException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class VCardProvider extends IQProvider<VCard> {
    private static final String[] ADR = {"POSTAL", "PARCEL", "DOM", "INTL", "PREF", "POBOX", "EXTADR", "STREET", "LOCALITY", "REGION", "PCODE", "CTRY", "FF"};
    private static final String[] TEL = {"VOICE", "FAX", "PAGER", "MSG", "CELL", "VIDEO", "BBS", "MODEM", "ISDN", "PCS", "PREF"};

    private static void parseAddress(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        boolean z = true;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("HOME".equals(name)) {
                    z = false;
                } else {
                    for (String str : ADR) {
                        if (str.equals(name)) {
                            if (z) {
                                vCard.setAddressFieldWork(name, xmlPullParser.nextText());
                            } else {
                                vCard.setAddressFieldHome(name, xmlPullParser.nextText());
                            }
                        }
                    }
                }
            } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    private static void parseEmail(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                xmlPullParser.getName().hashCode();
            } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void parseName(org.xmlpull.v1.XmlPullParser r5, org.jivesoftware.smackx.vcardtemp.packet.VCard r6) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r5.getDepth()
        L4:
            int r1 = r5.next()
            r2 = 2
            if (r1 == r2) goto L16
            r2 = 3
            if (r1 == r2) goto Lf
            goto L4
        Lf:
            int r1 = r5.getDepth()
            if (r1 != r0) goto L4
            return
        L16:
            java.lang.String r1 = r5.getName()
            r1.hashCode()
            r3 = -1
            int r4 = r1.hashCode()
            switch(r4) {
                case -2021012075: goto L3b;
                case 67829597: goto L30;
                case 2066435940: goto L27;
                default: goto L25;
            }
        L25:
            r2 = -1
            goto L45
        L27:
            java.lang.String r4 = "FAMILY"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L45
            goto L25
        L30:
            java.lang.String r2 = "GIVEN"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L39
            goto L25
        L39:
            r2 = 1
            goto L45
        L3b:
            java.lang.String r2 = "MIDDLE"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L44
            goto L25
        L44:
            r2 = 0
        L45:
            switch(r2) {
                case 0: goto L59;
                case 1: goto L51;
                case 2: goto L49;
                default: goto L48;
            }
        L48:
            goto L4
        L49:
            java.lang.String r1 = r5.nextText()
            r6.setLastName(r1)
            goto L4
        L51:
            java.lang.String r1 = r5.nextText()
            r6.setFirstName(r1)
            goto L4
        L59:
            java.lang.String r1 = r5.nextText()
            r6.setMiddleName(r1)
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.vcardtemp.provider.VCardProvider.parseName(org.xmlpull.v1.XmlPullParser, org.jivesoftware.smackx.vcardtemp.packet.VCard):void");
    }

    private static void parseOrg(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("ORGNAME")) {
                    vCard.setOrganization(xmlPullParser.nextText());
                } else if (name.equals("ORGUNIT")) {
                    vCard.setOrganizationUnit(xmlPullParser.nextText());
                }
            } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    private static void parsePhoto(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        String strNextText = null;
        String strNextText2 = null;
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    char c = 65535;
                    int iHashCode = name.hashCode();
                    if (iHashCode != -401054448) {
                        if (iHashCode != 2590522) {
                            if (iHashCode == 1959349434 && name.equals("BINVAL")) {
                                c = 0;
                            }
                        } else if (name.equals("TYPE")) {
                            c = 1;
                        }
                    } else if (name.equals("MOODMESSAGE")) {
                        c = 2;
                    }
                    if (c == 0) {
                        strNextText = xmlPullParser.nextText();
                    } else if (c == 1) {
                        strNextText2 = xmlPullParser.nextText();
                    } else if (c == 2) {
                        xmlPullParser.nextText();
                    }
                } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                    break;
                }
            } catch (Exception unused) {
            }
        }
        if (strNextText == null || strNextText2 == null) {
            return;
        }
        vCard.setAvatar(strNextText, strNextText2);
    }

    private static void parseTel(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        boolean z = true;
        String str = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("HOME".equals(name)) {
                    z = false;
                } else if (str == null || !"NUMBER".equals(name)) {
                    for (String str2 : TEL) {
                        if (str2.equals(name)) {
                            str = name;
                        }
                    }
                } else if (z) {
                    vCard.setPhoneWork(str, xmlPullParser.nextText());
                } else {
                    vCard.setPhoneHome(str, xmlPullParser.nextText());
                }
            } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    @Override // org.jivesoftware.smack.provider.Provider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.jivesoftware.smackx.vcardtemp.packet.VCard parse(org.xmlpull.v1.XmlPullParser r8, int r9) throws org.xmlpull.v1.XmlPullParserException, org.jivesoftware.smack.SmackException, java.io.IOException {
        /*
            r7 = this;
            org.jivesoftware.smackx.vcardtemp.packet.VCard r0 = new org.jivesoftware.smackx.vcardtemp.packet.VCard
            r0.<init>()
            r1 = 0
        L6:
            int r2 = r8.next()
            r3 = 4
            r4 = 3
            r5 = 2
            if (r2 == r5) goto L2b
            if (r2 == r4) goto L24
            if (r2 == r3) goto L14
            goto L6
        L14:
            int r2 = r9 + 1
            int r3 = r8.getDepth()
            if (r2 != r3) goto L6
            java.lang.String r2 = r8.getText()
            r0.setField(r1, r2)
            goto L6
        L24:
            int r2 = r8.getDepth()
            if (r2 != r9) goto L6
            return r0
        L2b:
            java.lang.String r1 = r8.getName()
            r1.hashCode()
            r2 = -1
            int r6 = r1.hashCode()
            switch(r6) {
                case -370243905: goto L87;
                case 78: goto L7c;
                case 64655: goto L71;
                case 78532: goto L66;
                case 82939: goto L5d;
                case 66081660: goto L52;
                case 76105234: goto L47;
                case 853317742: goto L3c;
                default: goto L3a;
            }
        L3a:
            r3 = -1
            goto L91
        L3c:
            java.lang.String r3 = "NICKNAME"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L45
            goto L3a
        L45:
            r3 = 7
            goto L91
        L47:
            java.lang.String r3 = "PHOTO"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L50
            goto L3a
        L50:
            r3 = 6
            goto L91
        L52:
            java.lang.String r3 = "EMAIL"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L5b
            goto L3a
        L5b:
            r3 = 5
            goto L91
        L5d:
            java.lang.String r4 = "TEL"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L91
            goto L3a
        L66:
            java.lang.String r3 = "ORG"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L6f
            goto L3a
        L6f:
            r3 = 3
            goto L91
        L71:
            java.lang.String r3 = "ADR"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L7a
            goto L3a
        L7a:
            r3 = 2
            goto L91
        L7c:
            java.lang.String r3 = "N"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L85
            goto L3a
        L85:
            r3 = 1
            goto L91
        L87:
            java.lang.String r3 = "JABBERID"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L90
            goto L3a
        L90:
            r3 = 0
        L91:
            switch(r3) {
                case 0: goto Lbd;
                case 1: goto Lb8;
                case 2: goto Lb3;
                case 3: goto Lae;
                case 4: goto La9;
                case 5: goto La4;
                case 6: goto L9f;
                case 7: goto L96;
                default: goto L94;
            }
        L94:
            goto L6
        L96:
            java.lang.String r2 = r8.nextText()
            r0.setNickName(r2)
            goto L6
        L9f:
            parsePhoto(r8, r0)
            goto L6
        La4:
            parseEmail(r8, r0)
            goto L6
        La9:
            parseTel(r8, r0)
            goto L6
        Lae:
            parseOrg(r8, r0)
            goto L6
        Lb3:
            parseAddress(r8, r0)
            goto L6
        Lb8:
            parseName(r8, r0)
            goto L6
        Lbd:
            java.lang.String r2 = r8.nextText()
            r0.setJabberId(r2)
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.vcardtemp.provider.VCardProvider.parse(org.xmlpull.v1.XmlPullParser, int):org.jivesoftware.smackx.vcardtemp.packet.VCard");
    }
}
