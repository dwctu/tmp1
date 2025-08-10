package dc;

import androidx.annotation.NonNull;

/* compiled from: StateVerifier.java */
/* loaded from: classes.dex */
public abstract class zp {

    /* compiled from: StateVerifier.java */
    public static class b extends zp {
        public volatile boolean a;

        public b() {
            super();
        }

        @Override // dc.zp
        public void b(boolean z) {
            this.a = z;
        }

        @Override // dc.zp
        public void c() {
            if (this.a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    @NonNull
    public static zp a() {
        return new b();
    }

    public abstract void b(boolean z);

    public abstract void c();

    public zp() {
    }
}
