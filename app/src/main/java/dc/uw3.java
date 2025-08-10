package dc;

import dc.ac4;
import dc.ed4;
import io.socket.engineio.client.EngineIOException;
import io.socket.utf8.UTF8Exception;
import java.util.Map;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

/* compiled from: Transport.java */
/* loaded from: classes4.dex */
public abstract class uw3 extends pw3 {
    public boolean b;
    public String c;
    public Map<String, String> d;
    public boolean e;
    public boolean f;
    public int g;
    public String h;
    public String i;
    public String j;
    public e k;
    public ed4.a l;
    public ac4.a m;

    /* compiled from: Transport.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            uw3 uw3Var = uw3.this;
            e eVar = uw3Var.k;
            if (eVar == e.CLOSED || eVar == null) {
                uw3Var.k = e.OPENING;
                uw3Var.k();
            }
        }
    }

    /* compiled from: Transport.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            uw3 uw3Var = uw3.this;
            e eVar = uw3Var.k;
            if (eVar == e.OPENING || eVar == e.OPEN) {
                uw3Var.j();
                uw3.this.l();
            }
        }
    }

    /* compiled from: Transport.java */
    public class c implements Runnable {
        public final /* synthetic */ zw3[] a;

        public c(zw3[] zw3VarArr) {
            this.a = zw3VarArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            uw3 uw3Var = uw3.this;
            if (uw3Var.k != e.OPEN) {
                throw new RuntimeException("Transport not open");
            }
            try {
                uw3Var.t(this.a);
            } catch (UTF8Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* compiled from: Transport.java */
    public static class d {
        public String a;
        public String b;
        public String c;
        public boolean d;
        public boolean e;
        public int f = -1;
        public int g = -1;
        public Map<String, String> h;
        public tw3 i;
        public ed4.a j;
        public ac4.a k;
    }

    /* compiled from: Transport.java */
    public enum e {
        OPENING,
        OPEN,
        CLOSED,
        PAUSED;

        @Override // java.lang.Enum
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public uw3(d dVar) {
        this.h = dVar.b;
        this.i = dVar.a;
        this.g = dVar.f;
        this.e = dVar.d;
        this.d = dVar.h;
        this.j = dVar.c;
        this.f = dVar.e;
        tw3 tw3Var = dVar.i;
        this.l = dVar.j;
        this.m = dVar.k;
    }

    public uw3 i() {
        jx3.h(new b());
        return this;
    }

    public abstract void j();

    public abstract void k();

    public void l() {
        this.k = e.CLOSED;
        a(Close.ELEMENT, new Object[0]);
    }

    public void m(String str) {
        q(ax3.d(str));
    }

    public void n(byte[] bArr) {
        q(ax3.f(bArr));
    }

    public uw3 o(String str, Exception exc) {
        a("error", new EngineIOException(str, exc));
        return this;
    }

    public void p() {
        this.k = e.OPEN;
        this.b = true;
        a("open", new Object[0]);
    }

    public void q(zw3 zw3Var) {
        a("packet", zw3Var);
    }

    public uw3 r() {
        jx3.h(new a());
        return this;
    }

    public void s(zw3[] zw3VarArr) {
        jx3.h(new c(zw3VarArr));
    }

    public abstract void t(zw3[] zw3VarArr) throws UTF8Exception;
}
