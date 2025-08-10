package dc;

import com.bigkoo.pickerview.lib.WheelView;
import java.util.TimerTask;

/* compiled from: InertiaTimerTask.java */
/* loaded from: classes.dex */
public final class we extends TimerTask {
    public float a = 2.1474836E9f;
    public final float b;
    public final WheelView c;

    public we(WheelView wheelView, float f) {
        this.c = wheelView;
        this.b = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.a == 2.1474836E9f) {
            if (Math.abs(this.b) <= 2000.0f) {
                this.a = this.b;
            } else if (this.b > 0.0f) {
                this.a = 2000.0f;
            } else {
                this.a = -2000.0f;
            }
        }
        if (Math.abs(this.a) >= 0.0f && Math.abs(this.a) <= 20.0f) {
            this.c.a();
            this.c.c.sendEmptyMessage(2000);
            return;
        }
        int i = (int) ((this.a * 10.0f) / 1000.0f);
        WheelView wheelView = this.c;
        float f = i;
        wheelView.B -= f;
        if (!wheelView.x) {
            float f2 = wheelView.r;
            float f3 = (-wheelView.C) * f2;
            int itemsCount = wheelView.getItemsCount() - 1;
            WheelView wheelView2 = this.c;
            float f4 = (itemsCount - wheelView2.C) * f2;
            float f5 = wheelView2.B;
            double d = f2 * 0.25d;
            if (f5 - d < f3) {
                f3 = f5 + f;
            } else if (f5 + d > f4) {
                f4 = f5 + f;
            }
            if (f5 <= f3) {
                this.a = 40.0f;
                wheelView2.B = (int) f3;
            } else if (f5 >= f4) {
                wheelView2.B = (int) f4;
                this.a = -40.0f;
            }
        }
        float f6 = this.a;
        if (f6 < 0.0f) {
            this.a = f6 + 20.0f;
        } else {
            this.a = f6 - 20.0f;
        }
        this.c.c.sendEmptyMessage(1000);
    }
}
