package org.jivesoftware.smackx.rsm.provider;

import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.rsm.packet.RSMSet;

/* loaded from: classes5.dex */
public class RSMSetProvider extends ExtensionElementProvider<RSMSet> {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    @Override // org.jivesoftware.smack.provider.Provider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.jivesoftware.smackx.rsm.packet.RSMSet parse(org.xmlpull.v1.XmlPullParser r16, int r17) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r15 = this;
            r0 = 0
            r1 = -1
            r3 = r0
            r4 = r3
            r7 = r4
            r9 = r7
            r5 = -1
            r6 = -1
            r8 = -1
            r10 = -1
        La:
            int r0 = r16.next()
            r2 = 3
            r11 = 2
            if (r0 == r11) goto L27
            if (r0 == r2) goto L18
            r12 = r17
            goto L86
        L18:
            int r0 = r16.getDepth()
            r12 = r17
            if (r0 != r12) goto L86
            org.jivesoftware.smackx.rsm.packet.RSMSet r0 = new org.jivesoftware.smackx.rsm.packet.RSMSet
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L27:
            r12 = r17
            java.lang.String r0 = r16.getName()
            r0.hashCode()
            int r13 = r0.hashCode()
            java.lang.String r14 = "index"
            switch(r13) {
                case -1392885889: goto L79;
                case 107876: goto L6e;
                case 3314326: goto L63;
                case 92734940: goto L5a;
                case 94851343: goto L4f;
                case 97440432: goto L44;
                case 100346066: goto L3b;
                default: goto L39;
            }
        L39:
            r2 = -1
            goto L83
        L3b:
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L42
            goto L39
        L42:
            r2 = 6
            goto L83
        L44:
            java.lang.String r2 = "first"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L4d
            goto L39
        L4d:
            r2 = 5
            goto L83
        L4f:
            java.lang.String r2 = "count"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L58
            goto L39
        L58:
            r2 = 4
            goto L83
        L5a:
            java.lang.String r11 = "after"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L83
            goto L39
        L63:
            java.lang.String r2 = "last"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L6c
            goto L39
        L6c:
            r2 = 2
            goto L83
        L6e:
            java.lang.String r2 = "max"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L77
            goto L39
        L77:
            r2 = 1
            goto L83
        L79:
            java.lang.String r2 = "before"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L82
            goto L39
        L82:
            r2 = 0
        L83:
            switch(r2) {
                case 0: goto Lba;
                case 1: goto Lb2;
                case 2: goto Laa;
                case 3: goto La2;
                case 4: goto L9a;
                case 5: goto L8e;
                case 6: goto L89;
                default: goto L86;
            }
        L86:
            r0 = r16
            goto La
        L89:
            int r6 = org.jivesoftware.smack.util.ParserUtils.getIntegerFromNextText(r16)
            goto L86
        L8e:
            r0 = r16
            int r10 = org.jivesoftware.smack.util.ParserUtils.getIntegerAttribute(r0, r14, r1)
            java.lang.String r9 = r16.nextText()
            goto La
        L9a:
            r0 = r16
            int r5 = org.jivesoftware.smack.util.ParserUtils.getIntegerFromNextText(r16)
            goto La
        La2:
            r0 = r16
            java.lang.String r3 = r16.nextText()
            goto La
        Laa:
            r0 = r16
            java.lang.String r7 = r16.nextText()
            goto La
        Lb2:
            r0 = r16
            int r8 = org.jivesoftware.smack.util.ParserUtils.getIntegerFromNextText(r16)
            goto La
        Lba:
            r0 = r16
            java.lang.String r4 = r16.nextText()
            goto La
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.rsm.provider.RSMSetProvider.parse(org.xmlpull.v1.XmlPullParser, int):org.jivesoftware.smackx.rsm.packet.RSMSet");
    }
}
