package dc;

import androidx.annotation.NonNull;

/* compiled from: CompatDecoderFactory.java */
/* loaded from: classes.dex */
public class lg0<T> implements mg0<T> {
    public Class<? extends T> a;

    public lg0(@NonNull Class<? extends T> cls) {
        this.a = cls;
    }

    @Override // dc.mg0
    public T a() throws IllegalAccessException, InstantiationException {
        return this.a.newInstance();
    }
}
