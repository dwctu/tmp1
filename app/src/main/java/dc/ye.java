package dc;

import android.os.Handler;
import android.os.Message;
import com.bigkoo.pickerview.lib.WheelView;

/* compiled from: MessageHandler.java */
/* loaded from: classes.dex */
public final class ye extends Handler {
    public final WheelView a;

    public ye(WheelView wheelView) {
        this.a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.a.invalidate();
        } else if (i == 2000) {
            this.a.p(WheelView.a.FLING);
        } else {
            if (i != 3000) {
                return;
            }
            this.a.l();
        }
    }
}
