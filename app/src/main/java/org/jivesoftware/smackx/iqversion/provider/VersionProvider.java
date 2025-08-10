package org.jivesoftware.smackx.iqversion.provider;

import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.iqversion.packet.Version;

/* loaded from: classes5.dex */
public class VersionProvider extends IQProvider<Version> {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    @Override // org.jivesoftware.smack.provider.Provider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.jivesoftware.smackx.iqversion.packet.Version parse(org.xmlpull.v1.XmlPullParser r8, int r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
            r2 = r1
        L3:
            int r3 = r8.next()
            r4 = 2
            if (r3 == r4) goto L32
            r4 = 3
            if (r3 == r4) goto Le
            goto L3
        Le:
            int r3 = r8.getDepth()
            if (r3 != r9) goto L3
            java.lang.String r3 = r8.getName()
            java.lang.String r4 = "query"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L3
            if (r0 != 0) goto L2c
            if (r1 != 0) goto L2c
            if (r2 != 0) goto L2c
            org.jivesoftware.smackx.iqversion.packet.Version r8 = new org.jivesoftware.smackx.iqversion.packet.Version
            r8.<init>()
            return r8
        L2c:
            org.jivesoftware.smackx.iqversion.packet.Version r8 = new org.jivesoftware.smackx.iqversion.packet.Version
            r8.<init>(r0, r1, r2)
            return r8
        L32:
            java.lang.String r3 = r8.getName()
            r3.hashCode()
            r5 = -1
            int r6 = r3.hashCode()
            switch(r6) {
                case 3556: goto L57;
                case 3373707: goto L4c;
                case 351608024: goto L43;
                default: goto L41;
            }
        L41:
            r4 = -1
            goto L61
        L43:
            java.lang.String r6 = "version"
            boolean r3 = r3.equals(r6)
            if (r3 != 0) goto L61
            goto L41
        L4c:
            java.lang.String r4 = "name"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L55
            goto L41
        L55:
            r4 = 1
            goto L61
        L57:
            java.lang.String r4 = "os"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L60
            goto L41
        L60:
            r4 = 0
        L61:
            switch(r4) {
                case 0: goto L6f;
                case 1: goto L6a;
                case 2: goto L65;
                default: goto L64;
            }
        L64:
            goto L3
        L65:
            java.lang.String r1 = r8.nextText()
            goto L3
        L6a:
            java.lang.String r0 = r8.nextText()
            goto L3
        L6f:
            java.lang.String r2 = r8.nextText()
            goto L3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.iqversion.provider.VersionProvider.parse(org.xmlpull.v1.XmlPullParser, int):org.jivesoftware.smackx.iqversion.packet.Version");
    }
}
