package dc;

import java.net.URI;
import java.util.regex.Pattern;

/* compiled from: PingUtil.java */
/* loaded from: classes4.dex */
public class tf3 {
    public static String a(int i, int i2, String str) {
        return "/system/bin/ping -c " + i + " -w " + i2 + " " + str;
    }

    public static String b(String str) {
        String host = null;
        try {
            host = URI.create(str).getHost();
            if (host == null) {
                if (f("((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))", str)) {
                    return str;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return host;
    }

    public static int c(String str) {
        return d(str, 2);
    }

    public static int d(String str, int i) {
        return e(str, i, 1, 100);
    }

    public static int e(String str, int i, int i2, int i3) {
        String strG;
        String strB = b(str);
        if (strB != null && (strG = g(a(i2, i3, strB))) != null) {
            try {
                String[] strArrSplit = strG.substring(strG.indexOf("min/avg/max/mdev") + 19).split("/");
                if (i == 1) {
                    return Math.round(Float.parseFloat(strArrSplit[0]));
                }
                if (i == 2) {
                    return Math.round(Float.parseFloat(strArrSplit[1]));
                }
                if (i == 3) {
                    return Math.round(Float.parseFloat(strArrSplit[2]));
                }
                if (i != 4) {
                    return -1;
                }
                return Math.round(Float.parseFloat(strArrSplit[3]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public static boolean f(String str, String str2) {
        return Pattern.matches(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARN: Type inference failed for: r6v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String g(java.lang.String r6) throws java.lang.Throwable {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L42
            java.lang.Process r6 = r1.exec(r6)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L42
            java.io.InputStream r1 = r6.getInputStream()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4d
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4d
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4d
            r3.<init>(r1)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4d
            r2.<init>(r3)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4d
            r3.<init>()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4d
        L1c:
            java.lang.String r4 = r2.readLine()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4d
            if (r4 == 0) goto L2b
            r3.append(r4)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4d
            java.lang.String r4 = "\n"
            r3.append(r4)     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4d
            goto L1c
        L2b:
            r2.close()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4d
            r1.close()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4d
            java.lang.String r0 = r3.toString()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4d
            if (r6 == 0) goto L3a
            r6.destroy()
        L3a:
            return r0
        L3b:
            r1 = move-exception
            goto L44
        L3d:
            r6 = move-exception
            r5 = r0
            r0 = r6
            r6 = r5
            goto L4e
        L42:
            r1 = move-exception
            r6 = r0
        L44:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            if (r6 == 0) goto L4c
            r6.destroy()
        L4c:
            return r0
        L4d:
            r0 = move-exception
        L4e:
            if (r6 == 0) goto L53
            r6.destroy()
        L53:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.tf3.g(java.lang.String):java.lang.String");
    }
}
