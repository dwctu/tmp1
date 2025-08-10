package org.jivesoftware.smackx.xdata.provider;

import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.ArrayList;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class DataFormProvider extends ExtensionElementProvider<DataForm> {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.jivesoftware.smackx.xdata.FormField parseField(org.xmlpull.v1.XmlPullParser r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r9 = this;
            int r0 = r10.getDepth()
            java.lang.String r1 = ""
            java.lang.String r2 = "var"
            java.lang.String r2 = r10.getAttributeValue(r1, r2)
            java.lang.String r3 = "type"
            java.lang.String r3 = r10.getAttributeValue(r1, r3)
            org.jivesoftware.smackx.xdata.FormField$Type r3 = org.jivesoftware.smackx.xdata.FormField.Type.fromString(r3)
            org.jivesoftware.smackx.xdata.FormField$Type r4 = org.jivesoftware.smackx.xdata.FormField.Type.fixed
            if (r3 != r4) goto L20
            org.jivesoftware.smackx.xdata.FormField r2 = new org.jivesoftware.smackx.xdata.FormField
            r2.<init>()
            goto L29
        L20:
            org.jivesoftware.smackx.xdata.FormField r4 = new org.jivesoftware.smackx.xdata.FormField
            r4.<init>(r2)
            r4.setType(r3)
            r2 = r4
        L29:
            java.lang.String r3 = "label"
            java.lang.String r1 = r10.getAttributeValue(r1, r3)
            r2.setLabel(r1)
        L32:
            int r1 = r10.next()
            r3 = 3
            r4 = 2
            if (r1 == r4) goto L44
            if (r1 == r3) goto L3d
            goto L32
        L3d:
            int r1 = r10.getDepth()
            if (r1 != r0) goto L32
            return r2
        L44:
            java.lang.String r1 = r10.getName()
            java.lang.String r5 = r10.getNamespace()
            r1.hashCode()
            r6 = -1
            int r7 = r1.hashCode()
            r8 = 1
            switch(r7) {
                case -1421272810: goto L84;
                case -1010136971: goto L79;
                case -393139297: goto L6e;
                case 3079825: goto L65;
                case 111972721: goto L5a;
                default: goto L58;
            }
        L58:
            r3 = -1
            goto L8e
        L5a:
            java.lang.String r3 = "value"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L63
            goto L58
        L63:
            r3 = 4
            goto L8e
        L65:
            java.lang.String r4 = "desc"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L8e
            goto L58
        L6e:
            java.lang.String r3 = "required"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L77
            goto L58
        L77:
            r3 = 2
            goto L8e
        L79:
            java.lang.String r3 = "option"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L82
            goto L58
        L82:
            r3 = 1
            goto L8e
        L84:
            java.lang.String r3 = "validate"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L8d
            goto L58
        L8d:
            r3 = 0
        L8e:
            switch(r3) {
                case 0: goto Lae;
                case 1: goto La6;
                case 2: goto La2;
                case 3: goto L9a;
                case 4: goto L92;
                default: goto L91;
            }
        L91:
            goto L32
        L92:
            java.lang.String r1 = r10.nextText()
            r2.addValue(r1)
            goto L32
        L9a:
            java.lang.String r1 = r10.nextText()
            r2.setDescription(r1)
            goto L32
        La2:
            r2.setRequired(r8)
            goto L32
        La6:
            org.jivesoftware.smackx.xdata.FormField$Option r1 = r9.parseOption(r10)
            r2.addOption(r1)
            goto L32
        Lae:
            java.lang.String r1 = "http://jabber.org/protocol/xdata-validate"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L32
            org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement r1 = org.jivesoftware.smackx.xdatavalidation.provider.DataValidationProvider.parse(r10)
            r2.setValidateElement(r1)
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.xdata.provider.DataFormProvider.parseField(org.xmlpull.v1.XmlPullParser):org.jivesoftware.smackx.xdata.FormField");
    }

    private DataForm.Item parseItem(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = new ArrayList();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(FormField.ELEMENT)) {
                    arrayList.add(parseField(xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                return new DataForm.Item(arrayList);
            }
        }
    }

    private FormField.Option parseOption(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        String attributeValue = xmlPullParser.getAttributeValue("", Constants.ScionAnalytics.PARAM_LABEL);
        FormField.Option option = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("value")) {
                    option = new FormField.Option(attributeValue, xmlPullParser.nextText());
                }
            } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                return option;
            }
        }
    }

    private DataForm.ReportedData parseReported(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = new ArrayList();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(FormField.ELEMENT)) {
                    arrayList.add(parseField(xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                return new DataForm.ReportedData(arrayList);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    @Override // org.jivesoftware.smack.provider.Provider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.jivesoftware.smackx.xdata.packet.DataForm parse(org.xmlpull.v1.XmlPullParser r8, int r9) throws org.xmlpull.v1.XmlPullParserException, org.jivesoftware.smack.SmackException, java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "type"
            java.lang.String r0 = r8.getAttributeValue(r0, r1)
            org.jivesoftware.smackx.xdata.packet.DataForm$Type r0 = org.jivesoftware.smackx.xdata.packet.DataForm.Type.fromString(r0)
            org.jivesoftware.smackx.xdata.packet.DataForm r1 = new org.jivesoftware.smackx.xdata.packet.DataForm
            r1.<init>(r0)
        L11:
            int r0 = r8.next()
            r2 = 3
            r3 = 2
            if (r0 == r3) goto L23
            if (r0 == r2) goto L1c
            goto L11
        L1c:
            int r0 = r8.getDepth()
            if (r0 != r9) goto L11
            return r1
        L23:
            java.lang.String r0 = r8.getName()
            java.lang.String r4 = r8.getNamespace()
            r0.hashCode()
            r5 = -1
            int r6 = r0.hashCode()
            switch(r6) {
                case -427039533: goto L78;
                case 3242771: goto L6d;
                case 3433103: goto L62;
                case 97427706: goto L59;
                case 107944136: goto L4e;
                case 110371416: goto L43;
                case 757376421: goto L38;
                default: goto L36;
            }
        L36:
            r2 = -1
            goto L82
        L38:
            java.lang.String r2 = "instructions"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L41
            goto L36
        L41:
            r2 = 6
            goto L82
        L43:
            java.lang.String r2 = "title"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L4c
            goto L36
        L4c:
            r2 = 5
            goto L82
        L4e:
            java.lang.String r2 = "query"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L57
            goto L36
        L57:
            r2 = 4
            goto L82
        L59:
            java.lang.String r3 = "field"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L82
            goto L36
        L62:
            java.lang.String r2 = "page"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L6b
            goto L36
        L6b:
            r2 = 2
            goto L82
        L6d:
            java.lang.String r2 = "item"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L76
            goto L36
        L76:
            r2 = 1
            goto L82
        L78:
            java.lang.String r2 = "reported"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L81
            goto L36
        L81:
            r2 = 0
        L82:
            switch(r2) {
                case 0: goto Lcd;
                case 1: goto Lc4;
                case 2: goto Lb3;
                case 3: goto Laa;
                case 4: goto L97;
                case 5: goto L8e;
                case 6: goto L86;
                default: goto L85;
            }
        L85:
            goto L11
        L86:
            java.lang.String r0 = r8.nextText()
            r1.addInstruction(r0)
            goto L11
        L8e:
            java.lang.String r0 = r8.nextText()
            r1.setTitle(r0)
            goto L11
        L97:
            java.lang.String r0 = "jabber:iq:roster"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L11
            org.jivesoftware.smack.roster.provider.RosterPacketProvider r0 = org.jivesoftware.smack.roster.provider.RosterPacketProvider.INSTANCE
            org.jivesoftware.smack.packet.Element r0 = r0.parse(r8)
            r1.addExtensionElement(r0)
            goto L11
        Laa:
            org.jivesoftware.smackx.xdata.FormField r0 = r7.parseField(r8)
            r1.addField(r0)
            goto L11
        Lb3:
            java.lang.String r0 = "http://jabber.org/protocol/xdata-layout"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L11
            org.jivesoftware.smackx.xdatalayout.packet.DataLayout r0 = org.jivesoftware.smackx.xdatalayout.provider.DataLayoutProvider.parse(r8)
            r1.addExtensionElement(r0)
            goto L11
        Lc4:
            org.jivesoftware.smackx.xdata.packet.DataForm$Item r0 = r7.parseItem(r8)
            r1.addItem(r0)
            goto L11
        Lcd:
            org.jivesoftware.smackx.xdata.packet.DataForm$ReportedData r0 = r7.parseReported(r8)
            r1.setReportedData(r0)
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.xdata.provider.DataFormProvider.parse(org.xmlpull.v1.XmlPullParser, int):org.jivesoftware.smackx.xdata.packet.DataForm");
    }
}
