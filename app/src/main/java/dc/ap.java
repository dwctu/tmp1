package dc;

import androidx.annotation.NonNull;

/* compiled from: SimpleTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class ap<Z> extends uo<Z> {
    public final int b;
    public final int c;

    public ap() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // dc.cp
    public void b(@NonNull bp bpVar) {
    }

    @Override // dc.cp
    public final void i(@NonNull bp bpVar) {
        if (wp.t(this.b, this.c)) {
            bpVar.d(this.b, this.c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.b + " and height: " + this.c + ", either provide dimensions in the constructor or call override()");
    }

    public ap(int i, int i2) {
        this.b = i;
        this.c = i2;
    }
}
