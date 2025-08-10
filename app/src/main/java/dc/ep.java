package dc;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCrossFadeFactory.java */
/* loaded from: classes.dex */
public class ep implements ip<Drawable> {
    public final int a;
    public final boolean b;
    public fp c;

    /* compiled from: DrawableCrossFadeFactory.java */
    public static class a {
        public final int a;
        public boolean b;

        public a() {
            this(300);
        }

        public ep a() {
            return new ep(this.a, this.b);
        }

        public a(int i) {
            this.a = i;
        }
    }

    public ep(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    @Override // dc.ip
    public hp<Drawable> a(sg sgVar, boolean z) {
        return sgVar == sg.MEMORY_CACHE ? gp.b() : b();
    }

    public final hp<Drawable> b() {
        if (this.c == null) {
            this.c = new fp(this.a, this.b);
        }
        return this.c;
    }
}
