package dc;

import android.app.Application;

/* compiled from: GlobalToast.java */
/* loaded from: classes2.dex */
public class v61 extends u61 {
    public final b71 l;

    public v61(Application application) {
        this.l = new b71(application, (u61) this);
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
