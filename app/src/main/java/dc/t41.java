package dc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: ESDescriptor.java */
@s41(tags = {3})
/* loaded from: classes2.dex */
public class t41 extends n41 {
    public static Logger q = Logger.getLogger(t41.class.getName());
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public String j;
    public int k;
    public int l;
    public int m;
    public q41 n;
    public z41 o;
    public int i = 0;
    public List<n41> p = new ArrayList();

    @Override // dc.n41
    public void e(ByteBuffer byteBuffer) throws IOException {
        this.d = df0.h(byteBuffer);
        int iL = df0.l(byteBuffer);
        int i = iL >>> 7;
        this.e = i;
        this.f = (iL >>> 6) & 1;
        this.g = (iL >>> 5) & 1;
        this.h = iL & 31;
        if (i == 1) {
            this.l = df0.h(byteBuffer);
        }
        if (this.f == 1) {
            int iL2 = df0.l(byteBuffer);
            this.i = iL2;
            this.j = df0.g(byteBuffer, iL2);
        }
        if (this.g == 1) {
            this.m = df0.h(byteBuffer);
        }
        int iB = b() + 1 + 2 + 1 + (this.e == 1 ? 2 : 0) + (this.f == 1 ? this.i + 1 : 0) + (this.g == 1 ? 2 : 0);
        int iPosition = byteBuffer.position();
        if (a() > iB + 2) {
            n41 n41VarA = x41.a(-1, byteBuffer);
            long jPosition = byteBuffer.position() - iPosition;
            Logger logger = q;
            StringBuilder sb = new StringBuilder();
            sb.append(n41VarA);
            sb.append(" - ESDescriptor1 read: ");
            sb.append(jPosition);
            sb.append(", size: ");
            sb.append(n41VarA != null ? Integer.valueOf(n41VarA.a()) : null);
            logger.finer(sb.toString());
            if (n41VarA != null) {
                int iA = n41VarA.a();
                byteBuffer.position(iPosition + iA);
                iB += iA;
            } else {
                iB = (int) (iB + jPosition);
            }
            if (n41VarA instanceof q41) {
                this.n = (q41) n41VarA;
            }
        }
        int iPosition2 = byteBuffer.position();
        if (a() > iB + 2) {
            n41 n41VarA2 = x41.a(-1, byteBuffer);
            long jPosition2 = byteBuffer.position() - iPosition2;
            Logger logger2 = q;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(n41VarA2);
            sb2.append(" - ESDescriptor2 read: ");
            sb2.append(jPosition2);
            sb2.append(", size: ");
            sb2.append(n41VarA2 != null ? Integer.valueOf(n41VarA2.a()) : null);
            logger2.finer(sb2.toString());
            if (n41VarA2 != null) {
                int iA2 = n41VarA2.a();
                byteBuffer.position(iPosition2 + iA2);
                iB += iA2;
            } else {
                iB = (int) (iB + jPosition2);
            }
            if (n41VarA2 instanceof z41) {
                this.o = (z41) n41VarA2;
            }
        } else {
            q.warning("SLConfigDescriptor is missing!");
        }
        while (a() - iB > 2) {
            int iPosition3 = byteBuffer.position();
            n41 n41VarA3 = x41.a(-1, byteBuffer);
            long jPosition3 = byteBuffer.position() - iPosition3;
            Logger logger3 = q;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(n41VarA3);
            sb3.append(" - ESDescriptor3 read: ");
            sb3.append(jPosition3);
            sb3.append(", size: ");
            sb3.append(n41VarA3 != null ? Integer.valueOf(n41VarA3.a()) : null);
            logger3.finer(sb3.toString());
            if (n41VarA3 != null) {
                int iA3 = n41VarA3.a();
                byteBuffer.position(iPosition3 + iA3);
                iB += iA3;
            } else {
                iB = (int) (iB + jPosition3);
            }
            this.p.add(n41VarA3);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t41.class != obj.getClass()) {
            return false;
        }
        t41 t41Var = (t41) obj;
        if (this.f != t41Var.f || this.i != t41Var.i || this.l != t41Var.l || this.d != t41Var.d || this.m != t41Var.m || this.g != t41Var.g || this.k != t41Var.k || this.e != t41Var.e || this.h != t41Var.h) {
            return false;
        }
        String str = this.j;
        if (str == null ? t41Var.j != null : !str.equals(t41Var.j)) {
            return false;
        }
        q41 q41Var = this.n;
        if (q41Var == null ? t41Var.n != null : !q41Var.equals(t41Var.n)) {
            return false;
        }
        List<n41> list = this.p;
        if (list == null ? t41Var.p != null : !list.equals(t41Var.p)) {
            return false;
        }
        z41 z41Var = this.o;
        z41 z41Var2 = t41Var.o;
        return z41Var == null ? z41Var2 == null : z41Var.equals(z41Var2);
    }

    public ByteBuffer f() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(g());
        ef0.i(byteBufferAllocate, 3);
        ef0.i(byteBufferAllocate, g() - 2);
        ef0.e(byteBufferAllocate, this.d);
        ef0.i(byteBufferAllocate, (this.e << 7) | (this.f << 6) | (this.g << 5) | (this.h & 31));
        if (this.e > 0) {
            ef0.e(byteBufferAllocate, this.l);
        }
        if (this.f > 0) {
            ef0.i(byteBufferAllocate, this.i);
            ef0.j(byteBufferAllocate, this.j);
        }
        if (this.g > 0) {
            ef0.e(byteBufferAllocate, this.m);
        }
        ByteBuffer byteBufferF = this.n.f();
        ByteBuffer byteBufferF2 = this.o.f();
        byteBufferAllocate.put(byteBufferF.array());
        byteBufferAllocate.put(byteBufferF2.array());
        return byteBufferAllocate;
    }

    public int g() {
        int i = this.e > 0 ? 7 : 5;
        if (this.f > 0) {
            i += this.i + 1;
        }
        if (this.g > 0) {
            i += 2;
        }
        return i + this.n.g() + this.o.g();
    }

    public void h(q41 q41Var) {
        this.n = q41Var;
    }

    public int hashCode() {
        int i = ((((((((((this.d * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31;
        String str = this.j;
        int iHashCode = (((((((i + (str != null ? str.hashCode() : 0)) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31;
        q41 q41Var = this.n;
        int iHashCode2 = (iHashCode + (q41Var != null ? q41Var.hashCode() : 0)) * 31;
        z41 z41Var = this.o;
        int iHashCode3 = (iHashCode2 + (z41Var != null ? z41Var.hashCode() : 0)) * 31;
        List<n41> list = this.p;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public void i(int i) {
        this.d = i;
    }

    public void j(z41 z41Var) {
        this.o = z41Var;
    }

    @Override // dc.n41
    public String toString() {
        return "ESDescriptor{esId=" + this.d + ", streamDependenceFlag=" + this.e + ", URLFlag=" + this.f + ", oCRstreamFlag=" + this.g + ", streamPriority=" + this.h + ", URLLength=" + this.i + ", URLString='" + this.j + "', remoteODFlag=" + this.k + ", dependsOnEsId=" + this.l + ", oCREsId=" + this.m + ", decoderConfigDescriptor=" + this.n + ", slConfigDescriptor=" + this.o + MessageFormatter.DELIM_STOP;
    }
}
