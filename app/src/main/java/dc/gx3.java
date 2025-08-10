package dc;

import com.google.android.vending.expansion.downloader.Constants;
import dc.fx3;
import dc.ix3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: IOParser.java */
/* loaded from: classes4.dex */
public final class gx3 implements ix3 {
    public static final Logger b = Logger.getLogger(gx3.class.getName());

    /* compiled from: IOParser.java */
    public static class a {
        public hx3 a;
        public List<byte[]> b = new ArrayList();

        public a(hx3 hx3Var) {
            this.a = hx3Var;
        }

        public void a() {
            this.a = null;
            this.b = new ArrayList();
        }

        public hx3 b(byte[] bArr) {
            this.b.add(bArr);
            int size = this.b.size();
            hx3 hx3Var = this.a;
            if (size != hx3Var.e) {
                return null;
            }
            List<byte[]> list = this.b;
            fx3.d(hx3Var, (byte[][]) list.toArray(new byte[list.size()][]));
            a();
            return hx3Var;
        }
    }

    /* compiled from: IOParser.java */
    public static final class c implements ix3.b {
        @Override // dc.ix3.b
        public void a(hx3 hx3Var, ix3.b.a aVar) {
            int i = hx3Var.a;
            if ((i == 2 || i == 3) && dx3.b(hx3Var.d)) {
                hx3Var.a = hx3Var.a == 2 ? 5 : 6;
            }
            if (gx3.b.isLoggable(Level.FINE)) {
                gx3.b.fine(String.format("encoding packet %s", hx3Var));
            }
            int i2 = hx3Var.a;
            if (5 == i2 || 6 == i2) {
                b(hx3Var, aVar);
            } else {
                aVar.call(new String[]{c(hx3Var)});
            }
        }

        public final void b(hx3 hx3Var, ix3.b.a aVar) {
            fx3.a aVarC = fx3.c(hx3Var);
            String strC = c(aVarC.a);
            ArrayList arrayList = new ArrayList(Arrays.asList(aVarC.b));
            arrayList.add(0, strC);
            aVar.call(arrayList.toArray());
        }

        public final String c(hx3 hx3Var) {
            StringBuilder sb = new StringBuilder("" + hx3Var.a);
            int i = hx3Var.a;
            if (5 == i || 6 == i) {
                sb.append(hx3Var.e);
                sb.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
            }
            String str = hx3Var.c;
            if (str != null && str.length() != 0 && !"/".equals(hx3Var.c)) {
                sb.append(hx3Var.c);
                sb.append(",");
            }
            int i2 = hx3Var.b;
            if (i2 >= 0) {
                sb.append(i2);
            }
            Object obj = hx3Var.d;
            if (obj != null) {
                sb.append(obj);
            }
            if (gx3.b.isLoggable(Level.FINE)) {
                gx3.b.fine(String.format("encoded %s as %s", hx3Var, sb));
            }
            return sb.toString();
        }
    }

    public static hx3<String> c() {
        return new hx3<>(4, "parser error");
    }

    /* compiled from: IOParser.java */
    public static final class b implements ix3.a {
        public a a = null;
        public ix3.a.InterfaceC0188a b;

        /* JADX WARN: Code restructure failed: missing block: B:44:0x00b3, code lost:
        
            r1.b = java.lang.Integer.parseInt(r3.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00c2, code lost:
        
            return dc.gx3.c();
         */
        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static dc.hx3 b(java.lang.String r8) {
            /*
                Method dump skipped, instructions count: 277
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.gx3.b.b(java.lang.String):dc.hx3");
        }

        @Override // dc.ix3.a
        public void a(ix3.a.InterfaceC0188a interfaceC0188a) {
            this.b = interfaceC0188a;
        }

        @Override // dc.ix3.a
        public void add(String str) {
            ix3.a.InterfaceC0188a interfaceC0188a;
            hx3 hx3VarB = b(str);
            int i = hx3VarB.a;
            if (5 != i && 6 != i) {
                ix3.a.InterfaceC0188a interfaceC0188a2 = this.b;
                if (interfaceC0188a2 != null) {
                    interfaceC0188a2.a(hx3VarB);
                    return;
                }
                return;
            }
            a aVar = new a(hx3VarB);
            this.a = aVar;
            if (aVar.a.e != 0 || (interfaceC0188a = this.b) == null) {
                return;
            }
            interfaceC0188a.a(hx3VarB);
        }

        @Override // dc.ix3.a
        public void destroy() {
            a aVar = this.a;
            if (aVar != null) {
                aVar.a();
            }
            this.b = null;
        }

        @Override // dc.ix3.a
        public void add(byte[] bArr) {
            a aVar = this.a;
            if (aVar != null) {
                hx3 hx3VarB = aVar.b(bArr);
                if (hx3VarB != null) {
                    this.a = null;
                    ix3.a.InterfaceC0188a interfaceC0188a = this.b;
                    if (interfaceC0188a != null) {
                        interfaceC0188a.a(hx3VarB);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new RuntimeException("got binary data when not reconstructing a packet");
        }
    }
}
