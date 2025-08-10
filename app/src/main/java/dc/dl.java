package dc;

import androidx.annotation.NonNull;

/* compiled from: SimpleResource.java */
/* loaded from: classes.dex */
public class dl<T> implements ti<T> {
    public final T a;

    public dl(@NonNull T t) {
        vp.d(t);
        this.a = t;
    }

    @Override // dc.ti
    public final int b() {
        return 1;
    }

    @Override // dc.ti
    @NonNull
    public Class<T> c() {
        return (Class<T>) this.a.getClass();
    }

    @Override // dc.ti
    @NonNull
    public final T get() {
        return this.a;
    }

    @Override // dc.ti
    public void recycle() {
    }
}
