package dc;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: CustomTarget.java */
/* loaded from: classes.dex */
public abstract class wo<T> implements cp<T> {
    public final int a;
    public final int b;

    @Nullable
    public mo c;

    public wo() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // dc.cp
    public void a(@Nullable Drawable drawable) {
    }

    @Override // dc.cp
    public final void b(@NonNull bp bpVar) {
    }

    @Override // dc.cp
    public final void g(@Nullable mo moVar) {
        this.c = moVar;
    }

    @Override // dc.cp
    @Nullable
    public final mo getRequest() {
        return this.c;
    }

    @Override // dc.cp
    public void h(@Nullable Drawable drawable) {
    }

    @Override // dc.cp
    public final void i(@NonNull bp bpVar) {
        bpVar.d(this.a, this.b);
    }

    @Override // dc.qn
    public void onDestroy() {
    }

    @Override // dc.qn
    public void onStart() {
    }

    @Override // dc.qn
    public void onStop() {
    }

    public wo(int i, int i2) {
        if (wp.t(i, i2)) {
            this.a = i;
            this.b = i2;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
    }
}
