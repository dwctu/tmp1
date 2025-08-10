package org.jivesoftware.smackx.xdatavalidation.provider;

import java.util.logging.Logger;

/* loaded from: classes5.dex */
public class DataValidationProvider {
    private static final Logger LOGGER = Logger.getLogger(DataValidationProvider.class.getName());

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement parse(org.xmlpull.v1.XmlPullParser r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r10.getDepth()
            java.lang.String r1 = ""
            java.lang.String r2 = "datatype"
            java.lang.String r2 = r10.getAttributeValue(r1, r2)
            r3 = 0
            r4 = r3
        Le:
            int r5 = r10.next()
            r6 = 3
            r7 = 2
            if (r5 == r7) goto L2a
            if (r5 == r6) goto L19
            goto Le
        L19:
            int r5 = r10.getDepth()
            if (r5 != r0) goto Le
            if (r3 != 0) goto L26
            org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$BasicValidateElement r3 = new org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$BasicValidateElement
            r3.<init>(r2)
        L26:
            r3.setListRange(r4)
            return r3
        L2a:
            java.lang.String r5 = r10.getName()
            r5.hashCode()
            r8 = -1
            int r9 = r5.hashCode()
            switch(r9) {
                case -725250226: goto L65;
                case 3417674: goto L5a;
                case 93508654: goto L4f;
                case 108280125: goto L46;
                case 108392519: goto L3b;
                default: goto L39;
            }
        L39:
            r6 = -1
            goto L6f
        L3b:
            java.lang.String r6 = "regex"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L44
            goto L39
        L44:
            r6 = 4
            goto L6f
        L46:
            java.lang.String r7 = "range"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L6f
            goto L39
        L4f:
            java.lang.String r6 = "basic"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L58
            goto L39
        L58:
            r6 = 2
            goto L6f
        L5a:
            java.lang.String r6 = "open"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L63
            goto L39
        L63:
            r6 = 1
            goto L6f
        L65:
            java.lang.String r6 = "list-range"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L6e
            goto L39
        L6e:
            r6 = 0
        L6f:
            java.lang.String r5 = "max"
            java.lang.String r7 = "min"
            switch(r6) {
                case 0: goto L9e;
                case 1: goto L97;
                case 2: goto L90;
                case 3: goto L81;
                case 4: goto L77;
                default: goto L76;
            }
        L76:
            goto Le
        L77:
            org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$RegexValidateElement r3 = new org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$RegexValidateElement
            java.lang.String r5 = r10.nextText()
            r3.<init>(r2, r5)
            goto Le
        L81:
            org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$RangeValidateElement r3 = new org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$RangeValidateElement
            java.lang.String r6 = r10.getAttributeValue(r1, r7)
            java.lang.String r5 = r10.getAttributeValue(r1, r5)
            r3.<init>(r2, r6, r5)
            goto Le
        L90:
            org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$BasicValidateElement r3 = new org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$BasicValidateElement
            r3.<init>(r2)
            goto Le
        L97:
            org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$OpenValidateElement r3 = new org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$OpenValidateElement
            r3.<init>(r2)
            goto Le
        L9e:
            java.lang.Long r6 = org.jivesoftware.smack.util.ParserUtils.getLongAttribute(r10, r7)
            java.lang.Long r5 = org.jivesoftware.smack.util.ParserUtils.getLongAttribute(r10, r5)
            if (r6 != 0) goto Lb4
            if (r5 == 0) goto Lab
            goto Lb4
        Lab:
            java.util.logging.Logger r5 = org.jivesoftware.smackx.xdatavalidation.provider.DataValidationProvider.LOGGER
            java.lang.String r6 = "Ignoring list-range element without min or max attribute"
            r5.fine(r6)
            goto Le
        Lb4:
            org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$ListRange r4 = new org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$ListRange
            r4.<init>(r6, r5)
            goto Le
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.xdatavalidation.provider.DataValidationProvider.parse(org.xmlpull.v1.XmlPullParser):org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement");
    }
}
