package dc;

/* compiled from: JsonUtils.java */
/* loaded from: classes.dex */
public class wr {
    public static void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                sb.append('\t');
            } catch (Exception unused) {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048 A[Catch: Exception -> 0x0074, TryCatch #0 {Exception -> 0x0074, blocks: (B:4:0x0004, B:7:0x000c, B:8:0x0015, B:10:0x001b, B:18:0x0033, B:19:0x0036, B:33:0x006b, B:21:0x003c, B:22:0x0044, B:23:0x0048, B:25:0x004d, B:26:0x0056, B:29:0x005d, B:31:0x0066, B:32:0x0068, B:34:0x006f), top: B:38:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(java.lang.String r10) {
        /*
            java.lang.String r0 = ""
            if (r10 == 0) goto L74
            boolean r1 = r0.equals(r10)     // Catch: java.lang.Exception -> L74
            if (r1 == 0) goto Lc
            goto L74
        Lc:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L74
            r1.<init>()     // Catch: java.lang.Exception -> L74
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        L15:
            int r6 = r10.length()     // Catch: java.lang.Exception -> L74
            if (r2 >= r6) goto L6f
            char r6 = r10.charAt(r2)     // Catch: java.lang.Exception -> L74
            r7 = 34
            r8 = 92
            if (r6 == r7) goto L64
            r7 = 44
            r9 = 10
            if (r6 == r7) goto L56
            r3 = 123(0x7b, float:1.72E-43)
            if (r6 == r3) goto L48
            r3 = 125(0x7d, float:1.75E-43)
            if (r6 == r3) goto L3a
            switch(r6) {
                case 91: goto L48;
                case 92: goto L6b;
                case 93: goto L3a;
                default: goto L36;
            }     // Catch: java.lang.Exception -> L74
        L36:
            r1.append(r6)     // Catch: java.lang.Exception -> L74
            goto L6b
        L3a:
            if (r4 != 0) goto L44
            r1.append(r9)     // Catch: java.lang.Exception -> L74
            int r5 = r5 + (-1)
            a(r1, r5)     // Catch: java.lang.Exception -> L74
        L44:
            r1.append(r6)     // Catch: java.lang.Exception -> L74
            goto L6b
        L48:
            r1.append(r6)     // Catch: java.lang.Exception -> L74
            if (r4 != 0) goto L6b
            r1.append(r9)     // Catch: java.lang.Exception -> L74
            int r5 = r5 + 1
            a(r1, r5)     // Catch: java.lang.Exception -> L74
            goto L6b
        L56:
            r1.append(r6)     // Catch: java.lang.Exception -> L74
            if (r3 == r8) goto L6b
            if (r4 != 0) goto L6b
            r1.append(r9)     // Catch: java.lang.Exception -> L74
            a(r1, r5)     // Catch: java.lang.Exception -> L74
            goto L6b
        L64:
            if (r3 == r8) goto L68
            r4 = r4 ^ 1
        L68:
            r1.append(r6)     // Catch: java.lang.Exception -> L74
        L6b:
            int r2 = r2 + 1
            r3 = r6
            goto L15
        L6f:
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Exception -> L74
            return r10
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.wr.b(java.lang.String):java.lang.String");
    }
}
