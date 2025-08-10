package dc;

import dc.ax3;
import dc.pw3;
import dc.uw3;
import io.socket.utf8.UTF8Exception;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

/* compiled from: Polling.java */
/* loaded from: classes4.dex */
public abstract class vw3 extends uw3 {
    public static final Logger o = Logger.getLogger(vw3.class.getName());
    public boolean n;

    /* compiled from: Polling.java */
    public class a implements Runnable {
        public final /* synthetic */ Runnable a;

        /* compiled from: Polling.java */
        /* renamed from: dc.vw3$a$a, reason: collision with other inner class name */
        public class RunnableC0225a implements Runnable {
            public final /* synthetic */ vw3 a;

            public RunnableC0225a(vw3 vw3Var) {
                this.a = vw3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                vw3.o.fine("paused");
                this.a.k = uw3.e.PAUSED;
                a.this.a.run();
            }
        }

        /* compiled from: Polling.java */
        public class b implements pw3.a {
            public final /* synthetic */ int[] a;
            public final /* synthetic */ Runnable b;

            public b(a aVar, int[] iArr, Runnable runnable) {
                this.a = iArr;
                this.b = runnable;
            }

            @Override // dc.pw3.a
            public void call(Object... objArr) {
                vw3.o.fine("pre-pause polling complete");
                int[] iArr = this.a;
                int i = iArr[0] - 1;
                iArr[0] = i;
                if (i == 0) {
                    this.b.run();
                }
            }
        }

        /* compiled from: Polling.java */
        public class c implements pw3.a {
            public final /* synthetic */ int[] a;
            public final /* synthetic */ Runnable b;

            public c(a aVar, int[] iArr, Runnable runnable) {
                this.a = iArr;
                this.b = runnable;
            }

            @Override // dc.pw3.a
            public void call(Object... objArr) {
                vw3.o.fine("pre-pause writing complete");
                int[] iArr = this.a;
                int i = iArr[0] - 1;
                iArr[0] = i;
                if (i == 0) {
                    this.b.run();
                }
            }
        }

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            vw3 vw3Var = vw3.this;
            vw3Var.k = uw3.e.PAUSED;
            RunnableC0225a runnableC0225a = new RunnableC0225a(vw3Var);
            if (!vw3.this.n && vw3.this.b) {
                runnableC0225a.run();
                return;
            }
            int[] iArr = {0};
            if (vw3.this.n) {
                vw3.o.fine("we are currently polling - waiting to pause");
                iArr[0] = iArr[0] + 1;
                vw3.this.g("pollComplete", new b(this, iArr, runnableC0225a));
            }
            if (vw3.this.b) {
                return;
            }
            vw3.o.fine("we are currently writing - waiting to pause");
            iArr[0] = iArr[0] + 1;
            vw3.this.g("drain", new c(this, iArr, runnableC0225a));
        }
    }

    /* compiled from: Polling.java */
    public class b implements ax3.e {
        public final /* synthetic */ vw3 a;

        public b(vw3 vw3Var, vw3 vw3Var2) {
            this.a = vw3Var2;
        }

        @Override // dc.ax3.e
        public boolean a(zw3 zw3Var, int i, int i2) {
            ej4.a("_onData == callback == " + this.a.k + "  " + zw3Var.a);
            if (this.a.k == uw3.e.OPENING) {
                this.a.p();
            }
            if (Close.ELEMENT.equals(zw3Var.a)) {
                this.a.l();
                return false;
            }
            ej4.a("_onData callback");
            this.a.q(zw3Var);
            return true;
        }
    }

    /* compiled from: Polling.java */
    public class c implements pw3.a {
        public final /* synthetic */ vw3 a;

        public c(vw3 vw3Var, vw3 vw3Var2) {
            this.a = vw3Var2;
        }

        @Override // dc.pw3.a
        public void call(Object... objArr) {
            vw3.o.fine("writing close packet");
            try {
                this.a.t(new zw3[]{new zw3(Close.ELEMENT)});
            } catch (UTF8Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* compiled from: Polling.java */
    public class d implements Runnable {
        public final /* synthetic */ vw3 a;

        public d(vw3 vw3Var, vw3 vw3Var2) {
            this.a = vw3Var2;
        }

        @Override // java.lang.Runnable
        public void run() {
            vw3 vw3Var = this.a;
            vw3Var.b = true;
            vw3Var.a("drain", new Object[0]);
        }
    }

    /* compiled from: Polling.java */
    public class e implements ax3.f {
        public final /* synthetic */ vw3 a;
        public final /* synthetic */ Runnable b;

        public e(vw3 vw3Var, vw3 vw3Var2, Runnable runnable) {
            this.a = vw3Var2;
            this.b = runnable;
        }

        @Override // dc.ax3.f
        public void call(Object obj) {
            if (obj instanceof byte[]) {
                this.a.G((byte[]) obj, this.b);
                return;
            }
            if (obj instanceof String) {
                this.a.F((String) obj, this.b);
                return;
            }
            vw3.o.warning("Unexpected data: " + obj);
        }
    }

    public vw3(uw3.d dVar) {
        super(dVar);
        this.c = "polling";
    }

    public abstract void E();

    public abstract void F(String str, Runnable runnable);

    public abstract void G(byte[] bArr, Runnable runnable);

    public void H(Runnable runnable) {
        jx3.h(new a(runnable));
    }

    public final void I() {
        o.fine("polling");
        ej4.a("poll() polling");
        this.n = true;
        E();
        a("poll", new Object[0]);
    }

    public String J() {
        String str;
        String str2;
        Map map = this.d;
        if (map == null) {
            map = new HashMap();
        }
        String str3 = this.e ? "https" : "http";
        if (this.f) {
            map.put(this.j, lx3.b());
        }
        String strB = ex3.b(map);
        if (this.g <= 0 || ((!"https".equals(str3) || this.g == 443) && (!"http".equals(str3) || this.g == 80))) {
            str = "";
        } else {
            str = SignatureImpl.INNER_SEP + this.g;
        }
        if (strB.length() > 0) {
            strB = "?" + strB;
        }
        boolean zContains = this.i.contains(SignatureImpl.INNER_SEP);
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append("://");
        if (zContains) {
            str2 = "[" + this.i + "]";
        } else {
            str2 = this.i;
        }
        sb.append(str2);
        sb.append(str);
        sb.append(this.h);
        sb.append(strB);
        return sb.toString();
    }

    @Override // dc.uw3
    public void j() {
        c cVar = new c(this, this);
        if (this.k == uw3.e.OPEN) {
            o.fine("transport open - closing");
            cVar.call(new Object[0]);
        } else {
            o.fine("transport not open - deferring close");
            g("open", cVar);
        }
    }

    @Override // dc.uw3
    public void k() {
        I();
    }

    @Override // dc.uw3
    public void m(String str) throws NumberFormatException {
        u(str);
    }

    @Override // dc.uw3
    public void n(byte[] bArr) throws NumberFormatException {
        u(bArr);
    }

    @Override // dc.uw3
    public void t(zw3[] zw3VarArr) throws UTF8Exception {
        this.b = false;
        ax3.m(zw3VarArr, new e(this, this, new d(this, this)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u(java.lang.Object r8) throws java.lang.NumberFormatException {
        /*
            r7 = this;
            java.util.logging.Logger r0 = dc.vw3.o
            java.util.logging.Level r1 = java.util.logging.Level.FINE
            boolean r2 = r0.isLoggable(r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L19
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r8
            java.lang.String r5 = "polling got data %s"
            java.lang.String r2 = java.lang.String.format(r5, r2)
            r0.fine(r2)
        L19:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "_onData "
            r2.append(r5)
            if (r8 != 0) goto L28
            java.lang.String r5 = " data==null"
            goto L30
        L28:
            java.lang.Class r5 = r8.getClass()
            java.lang.String r5 = r5.getSimpleName()
        L30:
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            dc.ej4.a(r2)
            dc.vw3$b r2 = new dc.vw3$b
            r2.<init>(r7, r7)
            boolean r5 = r8 instanceof java.lang.String
            if (r5 == 0) goto L49
            java.lang.String r8 = (java.lang.String) r8
            dc.ax3.g(r8, r2)
            goto L54
        L49:
            boolean r5 = r8 instanceof byte[]
            if (r5 == 0) goto L54
            byte[] r8 = (byte[]) r8
            dc.ax3.h(r8, r2)
            int r8 = r8.length
            goto L55
        L54:
            r8 = 0
        L55:
            r2 = 47
            java.lang.String r5 = " readyState=="
            if (r8 != r2) goto L7c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "_onData length==>"
            r2.append(r6)
            r2.append(r8)
            r2.append(r5)
            dc.uw3$e r5 = r7.k
            java.lang.String r5 = r5.toString()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            dc.ej4.a(r2)
            goto L9c
        L7c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "_onData length=="
            r2.append(r6)
            r2.append(r8)
            r2.append(r5)
            dc.uw3$e r5 = r7.k
            java.lang.String r5 = r5.toString()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            dc.ej4.a(r2)
        L9c:
            dc.uw3$e r2 = r7.k
            dc.uw3$e r5 = dc.uw3.e.CLOSED
            if (r2 == r5) goto Lcd
            r7.n = r4
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r5 = "pollComplete"
            r7.a(r5, r2)
            dc.uw3$e r2 = r7.k
            dc.uw3$e r5 = dc.uw3.e.OPEN
            if (r2 != r5) goto Lb8
            r2 = 4
            if (r8 == r2) goto Lb8
            r7.I()
            goto Lcd
        Lb8:
            boolean r8 = r0.isLoggable(r1)
            if (r8 == 0) goto Lcd
            java.lang.Object[] r8 = new java.lang.Object[r3]
            dc.uw3$e r1 = r7.k
            r8[r4] = r1
            java.lang.String r1 = "ignoring poll - transport state '%s'"
            java.lang.String r8 = java.lang.String.format(r1, r8)
            r0.fine(r8)
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.vw3.u(java.lang.Object):void");
    }
}
