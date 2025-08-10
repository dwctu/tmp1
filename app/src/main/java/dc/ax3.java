package dc;

import dc.kx3;
import io.socket.utf8.UTF8Exception;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.jivesoftware.smackx.ping.packet.Ping;

/* compiled from: Parser.java */
/* loaded from: classes4.dex */
public class ax3 {
    public static final int a = String.valueOf(Integer.MAX_VALUE).length();
    public static final Map<String, Integer> b;
    public static final Map<Integer, String> c;
    public static zw3<String> d;
    public static kx3.a e;

    /* compiled from: Parser.java */
    public class a extends HashMap<String, Integer> {
        public a() {
            put("open", 0);
            put(Close.ELEMENT, 1);
            put(Ping.ELEMENT, 2);
            put("pong", 3);
            put("message", 4);
            put("upgrade", 5);
            put("noop", 6);
        }
    }

    /* compiled from: Parser.java */
    public class b implements f {
        public final /* synthetic */ StringBuilder a;

        public b(StringBuilder sb) {
            this.a = sb;
        }

        @Override // dc.ax3.f
        public void call(Object obj) {
            this.a.append(ax3.o((String) obj));
        }
    }

    /* compiled from: Parser.java */
    public class c implements f<byte[]> {
        public final /* synthetic */ ArrayList a;

        public c(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // dc.ax3.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(byte[] bArr) {
            this.a.add(bArr);
        }
    }

    /* compiled from: Parser.java */
    public class d implements f {
        public final /* synthetic */ f a;

        public d(f fVar) {
            this.a = fVar;
        }

        @Override // dc.ax3.f
        public void call(Object obj) {
            if (obj instanceof String) {
                String str = (String) obj;
                String strValueOf = String.valueOf(str.length());
                int length = strValueOf.length() + 2;
                byte[] bArr = new byte[length];
                bArr[0] = 0;
                int i = 0;
                while (i < strValueOf.length()) {
                    int i2 = i + 1;
                    bArr[i2] = (byte) Character.getNumericValue(strValueOf.charAt(i));
                    i = i2;
                }
                bArr[length - 1] = -1;
                this.a.call(yw3.a(new byte[][]{bArr, ax3.p(str)}));
                return;
            }
            byte[] bArr2 = (byte[]) obj;
            String strValueOf2 = String.valueOf(bArr2.length);
            int length2 = strValueOf2.length() + 2;
            byte[] bArr3 = new byte[length2];
            bArr3[0] = 1;
            int i3 = 0;
            while (i3 < strValueOf2.length()) {
                int i4 = i3 + 1;
                bArr3[i4] = (byte) Character.getNumericValue(strValueOf2.charAt(i3));
                i3 = i4;
            }
            bArr3[length2 - 1] = -1;
            this.a.call(yw3.a(new byte[][]{bArr3, bArr2}));
        }
    }

    /* compiled from: Parser.java */
    public interface e<T> {
        boolean a(zw3<T> zw3Var, int i, int i2);
    }

    /* compiled from: Parser.java */
    public interface f<T> {
        void call(T t);
    }

    static {
        a aVar = new a();
        b = aVar;
        c = new HashMap();
        for (Map.Entry<String, Integer> entry : aVar.entrySet()) {
            c.put(entry.getValue(), entry.getKey());
        }
        d = new zw3<>("error", "parser error");
        kx3.a aVar2 = new kx3.a();
        e = aVar2;
        aVar2.a = false;
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.appendCodePoint(b2 & 255);
        }
        return sb.toString();
    }

    public static zw3<String> d(String str) {
        return e(str, false);
    }

    public static zw3<String> e(String str, boolean z) {
        int numericValue;
        if (str == null) {
            return d;
        }
        try {
            numericValue = Character.getNumericValue(str.charAt(0));
        } catch (IndexOutOfBoundsException unused) {
            numericValue = -1;
        }
        if (z) {
            try {
                str = kx3.c(str, e);
            } catch (UTF8Exception unused2) {
                return d;
            }
        }
        if (numericValue >= 0) {
            Map<Integer, String> map = c;
            if (numericValue < map.size()) {
                return str.length() > 1 ? new zw3<>(map.get(Integer.valueOf(numericValue)), str.substring(1)) : new zw3<>(map.get(Integer.valueOf(numericValue)));
            }
        }
        return d;
    }

    public static zw3<byte[]> f(byte[] bArr) {
        byte b2 = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        return new zw3<>(c.get(Integer.valueOf(b2)), bArr2);
    }

    public static void g(String str, e<String> eVar) throws NumberFormatException {
        if (str == null || str.length() == 0) {
            eVar.a(d, 0, 1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (':' != cCharAt) {
                sb.append(cCharAt);
            } else {
                try {
                    int i2 = Integer.parseInt(sb.toString());
                    int i3 = i + 1;
                    try {
                        String strSubstring = str.substring(i3, i3 + i2);
                        if (strSubstring.length() != 0) {
                            zw3<String> zw3VarE = e(strSubstring, false);
                            if (d.a.equals(zw3VarE.a) && d.b.equals(zw3VarE.b)) {
                                eVar.a(d, 0, 1);
                                return;
                            } else if (!eVar.a(zw3VarE, i + i2, length)) {
                                return;
                            }
                        }
                        i += i2;
                        sb = new StringBuilder();
                    } catch (IndexOutOfBoundsException unused) {
                        eVar.a(d, 0, 1);
                        return;
                    }
                } catch (NumberFormatException unused2) {
                    eVar.a(d, 0, 1);
                    return;
                }
            }
            i++;
        }
        if (sb.length() > 0) {
            eVar.a(d, 0, 1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        r10.position(r1.length() + 1);
        r10 = r10.slice();
        r1 = java.lang.Integer.parseInt(r1.toString());
        r10.position(1);
        r1 = r1 + 1;
        r10.limit(r1);
        r2 = new byte[r10.remaining()];
        r10.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004e, code lost:
    
        if (r4 == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:
    
        r0.add(c(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        r0.add(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void h(byte[] r10, dc.ax3.e r11) throws java.lang.NumberFormatException {
        /*
            java.nio.ByteBuffer r10 = java.nio.ByteBuffer.wrap(r10)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L9:
            int r1 = r10.capacity()
            r2 = 0
            r3 = 1
            if (r1 <= 0) goto L7a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            byte r4 = r10.get(r2)
            r5 = 255(0xff, float:3.57E-43)
            r4 = r4 & r5
            if (r4 != 0) goto L21
            r4 = 1
            goto L22
        L21:
            r4 = 0
        L22:
            r6 = 1
        L23:
            byte r7 = r10.get(r6)
            r7 = r7 & r5
            if (r7 != r5) goto L66
            int r2 = r1.length()
            int r2 = r2 + r3
            r10.position(r2)
            java.nio.ByteBuffer r10 = r10.slice()
            java.lang.String r1 = r1.toString()
            int r1 = java.lang.Integer.parseInt(r1)
            r10.position(r3)
            int r1 = r1 + r3
            r10.limit(r1)
            int r2 = r10.remaining()
            byte[] r2 = new byte[r2]
            r10.get(r2)
            if (r4 == 0) goto L58
            java.lang.String r2 = c(r2)
            r0.add(r2)
            goto L5b
        L58:
            r0.add(r2)
        L5b:
            r10.clear()
            r10.position(r1)
            java.nio.ByteBuffer r10 = r10.slice()
            goto L9
        L66:
            int r8 = r1.length()
            int r9 = dc.ax3.a
            if (r8 <= r9) goto L74
            dc.zw3<java.lang.String> r10 = dc.ax3.d
            r11.a(r10, r2, r3)
            return
        L74:
            r1.append(r7)
            int r6 = r6 + 1
            goto L23
        L7a:
            int r10 = r0.size()
        L7e:
            if (r2 >= r10) goto La2
            java.lang.Object r1 = r0.get(r2)
            boolean r4 = r1 instanceof java.lang.String
            if (r4 == 0) goto L92
            java.lang.String r1 = (java.lang.String) r1
            dc.zw3 r1 = e(r1, r3)
            r11.a(r1, r2, r10)
            goto L9f
        L92:
            boolean r4 = r1 instanceof byte[]
            if (r4 == 0) goto L9f
            byte[] r1 = (byte[]) r1
            dc.zw3 r1 = f(r1)
            r11.a(r1, r2, r10)
        L9f:
            int r2 = r2 + 1
            goto L7e
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.ax3.h(byte[], dc.ax3$e):void");
    }

    public static void i(zw3<byte[]> zw3Var, f<byte[]> fVar) {
        byte[] bArr = zw3Var.b;
        byte[] bArr2 = new byte[bArr.length + 1];
        bArr2[0] = b.get(zw3Var.a).byteValue();
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        fVar.call(bArr2);
    }

    public static void j(zw3 zw3Var, f<byte[]> fVar) throws UTF8Exception {
        l(zw3Var, true, new d(fVar));
    }

    public static void k(zw3 zw3Var, f fVar) throws UTF8Exception {
        l(zw3Var, false, fVar);
    }

    public static void l(zw3 zw3Var, boolean z, f fVar) throws UTF8Exception {
        if (zw3Var.b instanceof byte[]) {
            i(zw3Var, fVar);
            return;
        }
        String strValueOf = String.valueOf(b.get(zw3Var.a));
        if (zw3Var.b != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(strValueOf);
            String strValueOf2 = String.valueOf(zw3Var.b);
            if (z) {
                strValueOf2 = kx3.e(strValueOf2, e);
            }
            sb.append(strValueOf2);
            strValueOf = sb.toString();
        }
        fVar.call(strValueOf);
    }

    public static void m(zw3[] zw3VarArr, f fVar) throws UTF8Exception {
        for (zw3 zw3Var : zw3VarArr) {
            if (zw3Var.b instanceof byte[]) {
                n(zw3VarArr, fVar);
                return;
            }
        }
        if (zw3VarArr.length == 0) {
            fVar.call("0:");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (zw3 zw3Var2 : zw3VarArr) {
            l(zw3Var2, false, new b(sb));
        }
        fVar.call(sb.toString());
    }

    public static void n(zw3[] zw3VarArr, f<byte[]> fVar) throws UTF8Exception {
        if (zw3VarArr.length == 0) {
            fVar.call(new byte[0]);
            return;
        }
        ArrayList arrayList = new ArrayList(zw3VarArr.length);
        for (zw3 zw3Var : zw3VarArr) {
            j(zw3Var, new c(arrayList));
        }
        fVar.call(yw3.a((byte[][]) arrayList.toArray(new byte[arrayList.size()][])));
    }

    public static String o(String str) {
        return str.length() + SignatureImpl.INNER_SEP + str;
    }

    public static byte[] p(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) Character.codePointAt(str, i);
        }
        return bArr;
    }
}
