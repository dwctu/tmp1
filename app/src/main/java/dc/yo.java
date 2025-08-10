package dc;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.hp;

/* compiled from: ImageViewTarget.java */
/* loaded from: classes.dex */
public abstract class yo<Z> extends dp<ImageView, Z> implements hp.a {

    @Nullable
    public Animatable h;

    public yo(ImageView imageView) {
        super(imageView);
    }

    @Override // dc.dp, dc.uo, dc.cp
    public void a(@Nullable Drawable drawable) {
        super.a(drawable);
        p(null);
        c(drawable);
    }

    @Override // dc.hp.a
    public void c(Drawable drawable) {
        ((ImageView) this.b).setImageDrawable(drawable);
    }

    @Override // dc.hp.a
    @Nullable
    public Drawable d() {
        return ((ImageView) this.b).getDrawable();
    }

    @Override // dc.dp, dc.uo, dc.cp
    public void e(@Nullable Drawable drawable) {
        super.e(drawable);
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.stop();
        }
        p(null);
        c(drawable);
    }

    @Override // dc.cp
    public void f(@NonNull Z z, @Nullable hp<? super Z> hpVar) {
        if (hpVar == null || !hpVar.a(z, this)) {
            p(z);
        } else {
            n(z);
        }
    }

    @Override // dc.uo, dc.cp
    public void h(@Nullable Drawable drawable) {
        super.h(drawable);
        p(null);
        c(drawable);
    }

    public final void n(@Nullable Z z) {
        if (!(z instanceof Animatable)) {
            this.h = null;
            return;
        }
        Animatable animatable = (Animatable) z;
        this.h = animatable;
        animatable.start();
    }

    public abstract void o(@Nullable Z z);

    @Override // dc.uo, dc.qn
    public void onStart() {
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // dc.uo, dc.qn
    public void onStop() {
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public final void p(@Nullable Z z) {
        o(z);
        n(z);
    }
}
