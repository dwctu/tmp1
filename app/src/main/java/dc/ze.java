package dc;

import com.bigkoo.pickerview.lib.WheelView;

/* compiled from: OnItemSelectedRunnable.java */
/* loaded from: classes.dex */
public final class ze implements Runnable {
    public final WheelView a;

    public ze(WheelView wheelView) {
        this.a = wheelView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WheelView wheelView = this.a;
        wheelView.e.a(wheelView.getCurrentItem());
    }
}
