package dc;

import android.app.Activity;

/* compiled from: ActivityToast.java */
/* loaded from: classes2.dex */
public class t61 extends u61 {
    public final b71 l;

    public t61(Activity activity) {
        this.l = new b71(activity, (u61) this);
    }

    @Override // dc.i71
    public void cancel() {
        this.l.g();
    }

    @Override // dc.i71
    public void show() {
        this.l.k();
    }
}
