package dc;

import android.content.Context;
import android.view.OrientationEventListener;

/* compiled from: OrientationHelper.java */
/* loaded from: classes5.dex */
public class rj4 extends OrientationEventListener {
    public long a;
    public a b;

    /* compiled from: OrientationHelper.java */
    public interface a {
        void c(int i);
    }

    public rj4(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.a < 300) {
            return;
        }
        a aVar = this.b;
        if (aVar != null) {
            aVar.c(i);
        }
        this.a = jCurrentTimeMillis;
    }
}
