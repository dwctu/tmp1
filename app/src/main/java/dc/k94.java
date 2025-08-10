package dc;

import java.util.Objects;

/* compiled from: FileHeader.java */
/* loaded from: classes5.dex */
public class k94 extends e94 {
    public int q;
    public byte[] r;
    public long s;

    public k94() {
        a(o84.CENTRAL_DIRECTORY);
    }

    public final long J(k94 k94Var) {
        return k94Var.m() != null ? k94Var.m().d() : k94Var.M();
    }

    public int K() {
        return this.q;
    }

    public byte[] L() {
        return this.r;
    }

    public long M() {
        return this.s;
    }

    public void N(int i) {
        this.q = i;
    }

    public void O(byte[] bArr) {
        this.r = bArr;
    }

    public void P(String str) {
    }

    public void Q(int i) {
    }

    public void R(byte[] bArr) {
    }

    public void S(long j) {
        this.s = j;
    }

    public void T(int i) {
    }

    @Override // dc.e94
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && k94.class == obj.getClass() && super.equals(obj) && J(this) == J((k94) obj);
    }

    public int hashCode() {
        return Objects.hash(i(), Long.valueOf(J(this)));
    }

    public String toString() {
        return i();
    }
}
