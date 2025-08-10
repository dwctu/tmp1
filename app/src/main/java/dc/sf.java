package dc;

import androidx.annotation.NonNull;
import dc.sf;

/* compiled from: TransitionOptions.java */
/* loaded from: classes.dex */
public abstract class sf<CHILD extends sf<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    public ip<? super TranscodeType> a = gp.c();

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final ip<? super TranscodeType> b() {
        return this.a;
    }

    public final CHILD c() {
        return this;
    }

    @NonNull
    public final CHILD d(@NonNull ip<? super TranscodeType> ipVar) {
        vp.d(ipVar);
        this.a = ipVar;
        c();
        return this;
    }
}
