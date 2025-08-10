package dc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ProgressUIListener.java */
/* loaded from: classes4.dex */
public abstract class hw3 extends ew3 {
    public Handler e;

    /* compiled from: ProgressUIListener.java */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            int i = message.what;
            if (i == 1) {
                Bundle data = message.getData();
                if (data == null) {
                    return;
                }
                hw3.this.h(data.getLong("totalBytes"));
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                hw3.this.g();
                return;
            }
            Bundle data2 = message.getData();
            if (data2 == null) {
                return;
            }
            hw3.this.f(data2.getLong("numBytes"), data2.getLong("totalBytes"), data2.getFloat("percent"), data2.getFloat("speed"));
        }
    }

    @Override // dc.ew3
    public final void b(long j, long j2, float f, float f2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            f(j, j2, f, f2);
            return;
        }
        e();
        Message messageObtainMessage = this.e.obtainMessage();
        messageObtainMessage.what = 2;
        Bundle bundle = new Bundle();
        bundle.putLong("numBytes", j);
        bundle.putLong("totalBytes", j2);
        bundle.putFloat("percent", f);
        bundle.putFloat("speed", f2);
        messageObtainMessage.setData(bundle);
        this.e.sendMessage(messageObtainMessage);
    }

    @Override // dc.ew3
    public final void c() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            g();
            return;
        }
        e();
        Message messageObtainMessage = this.e.obtainMessage();
        messageObtainMessage.what = 3;
        this.e.sendMessage(messageObtainMessage);
    }

    @Override // dc.ew3
    public final void d(long j) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            h(j);
            return;
        }
        e();
        Message messageObtainMessage = this.e.obtainMessage();
        messageObtainMessage.what = 1;
        Bundle bundle = new Bundle();
        bundle.putLong("totalBytes", j);
        messageObtainMessage.setData(bundle);
        this.e.sendMessage(messageObtainMessage);
    }

    public final void e() {
        if (this.e != null) {
            return;
        }
        synchronized (hw3.class) {
            if (this.e == null) {
                this.e = new a(Looper.getMainLooper());
            }
        }
    }

    public abstract void f(long j, long j2, float f, float f2);

    public void g() {
    }

    public void h(long j) {
    }
}
