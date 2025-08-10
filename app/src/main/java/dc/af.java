package dc;

import com.bigkoo.pickerview.lib.WheelView;
import java.util.TimerTask;

/* compiled from: SmoothScrollTimerTask.java */
/* loaded from: classes.dex */
public final class af extends TimerTask {
    public int a = Integer.MAX_VALUE;
    public int b = 0;
    public int c;
    public final WheelView d;

    public af(WheelView wheelView, int i) {
        this.d = wheelView;
        this.c = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.a == Integer.MAX_VALUE) {
            this.a = this.c;
        }
        int i = this.a;
        int i2 = (int) (i * 0.1f);
        this.b = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.b = -1;
            } else {
                this.b = 1;
            }
        }
        if (Math.abs(i) <= 1) {
            this.d.a();
            this.d.c.sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.d;
        wheelView.B += this.b;
        if (!wheelView.x) {
            float f = wheelView.r;
            float f2 = (-wheelView.C) * f;
            int itemsCount = wheelView.getItemsCount() - 1;
            WheelView wheelView2 = this.d;
            float f3 = (itemsCount - wheelView2.C) * f;
            float f4 = wheelView2.B;
            if (f4 <= f2 || f4 >= f3) {
                wheelView2.B = f4 - this.b;
                wheelView2.a();
                this.d.c.sendEmptyMessage(3000);
                return;
            }
        }
        this.d.c.sendEmptyMessage(1000);
        this.a -= this.b;
    }
}
