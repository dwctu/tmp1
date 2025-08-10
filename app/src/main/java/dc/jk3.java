package dc;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: SimulateClickUtil.java */
/* loaded from: classes4.dex */
public class jk3 {
    public static void a(View view, int i, int i2) {
        if (view == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        float f = i;
        float f2 = i2;
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, f, f2, 0);
        long j = 100 + jUptimeMillis;
        MotionEvent motionEventObtain2 = MotionEvent.obtain(j, j, 1, f, f2, 0);
        view.onTouchEvent(motionEventObtain);
        view.onTouchEvent(motionEventObtain2);
        motionEventObtain.recycle();
        motionEventObtain2.recycle();
    }
}
