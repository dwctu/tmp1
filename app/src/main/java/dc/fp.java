package dc;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import dc.hp;

/* compiled from: DrawableCrossFadeTransition.java */
/* loaded from: classes.dex */
public class fp implements hp<Drawable> {
    public final int a;
    public final boolean b;

    public fp(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    @Override // dc.hp
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(Drawable drawable, hp.a aVar) {
        Drawable drawableD = aVar.d();
        if (drawableD == null) {
            drawableD = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawableD, drawable});
        transitionDrawable.setCrossFadeEnabled(this.b);
        transitionDrawable.startTransition(this.a);
        aVar.c(transitionDrawable);
        return true;
    }
}
