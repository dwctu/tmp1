package dc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ResourceRecycler.java */
/* loaded from: classes.dex */
public class wi {
    public boolean a;
    public final Handler b = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: ResourceRecycler.java */
    public static final class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((ti) message.obj).recycle();
            return true;
        }
    }

    public synchronized void a(ti<?> tiVar, boolean z) {
        if (this.a || z) {
            this.b.obtainMessage(1, tiVar).sendToTarget();
        } else {
            this.a = true;
            tiVar.recycle();
            this.a = false;
        }
    }
}
