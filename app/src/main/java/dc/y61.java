package dc;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

/* compiled from: SafeHandler.java */
/* loaded from: classes2.dex */
public final class y61 extends Handler {
    public final Handler a;

    public y61(Handler handler) {
        this.a = handler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            this.a.handleMessage(message);
        } catch (WindowManager.BadTokenException | IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
