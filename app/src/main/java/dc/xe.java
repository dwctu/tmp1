package dc;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bigkoo.pickerview.lib.WheelView;

/* compiled from: LoopViewGestureListener.java */
/* loaded from: classes.dex */
public final class xe extends GestureDetector.SimpleOnGestureListener {
    public final WheelView a;

    public xe(WheelView wheelView) {
        this.a = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.a.o(f2);
        return true;
    }
}
