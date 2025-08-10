package dc;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.common.primitives.UnsignedInts;
import com.wear.util.MyApplication;
import java.lang.ref.WeakReference;

/* compiled from: TextureMovieEncoder.java */
/* loaded from: classes4.dex */
public class oi3 implements Runnable {
    public long a;
    public long b;
    public qi3 c;
    public mi3 d;
    public vh3 e;
    public int f;
    public pi3 g;
    public volatile b h;
    public boolean j;
    public boolean k;
    public uh3 l;
    public Object i = new Object();
    public long m = -1;
    public mh3 n = new ph3(MyApplication.N().getResources());
    public int o = -1;
    public int p = -1;
    public int q = -1;
    public int r = -1;
    public int s = 0;

    /* compiled from: TextureMovieEncoder.java */
    public static class a {
        public final String a;
        public final int b;
        public final int c;
        public final int d;
        public final EGLContext e;

        public a(String str, int i, int i2, int i3, EGLContext eGLContext, Camera.CameraInfo cameraInfo) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = eGLContext;
        }

        public String toString() {
            return "EncoderConfig: " + this.b + "x" + this.c + " @" + this.d + " to '" + this.a + "' ctxt=" + this.e;
        }
    }

    /* compiled from: TextureMovieEncoder.java */
    public static class b extends Handler {
        public WeakReference<oi3> a;

        public b(oi3 oi3Var) {
            this.a = new WeakReference<>(oi3Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalStateException, InterruptedException {
            int i = message.what;
            Object obj = message.obj;
            oi3 oi3Var = this.a.get();
            if (oi3Var == null) {
                return;
            }
            switch (i) {
                case 0:
                    oi3Var.m((a) obj);
                    return;
                case 1:
                    oi3Var.n();
                    return;
                case 2:
                    oi3Var.i((float[]) obj, (message.arg1 << 32) | (message.arg2 & UnsignedInts.INT_MASK));
                    return;
                case 3:
                    oi3Var.l(message.arg1);
                    return;
                case 4:
                    oi3Var.o((EGLContext) message.obj);
                    return;
                case 5:
                    Looper.myLooper().quit();
                    return;
                case 6:
                    oi3Var.j();
                    return;
                case 7:
                    oi3Var.k();
                    return;
                default:
                    throw new RuntimeException("Unhandled msg what=" + i);
            }
        }
    }

    public void h(SurfaceTexture surfaceTexture) {
        synchronized (this.i) {
            if (this.j) {
                float[] fArr = new float[16];
                surfaceTexture.getTransformMatrix(fArr);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    return;
                }
                this.h.sendMessage(this.h.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
            }
        }
    }

    public final void i(float[] fArr, long j) {
        this.g.k(false);
        String str = "---setTextureId==" + this.f;
        this.n.v(this.f);
        this.n.d();
        if (this.m == -1) {
            this.m = System.nanoTime();
            this.g.p();
        }
        long jNanoTime = System.nanoTime();
        long j2 = (jNanoTime - this.m) - this.a;
        System.out.println("TimeStampVideo=" + j2 + ";nanoTime=" + jNanoTime + ";baseTimeStamp=" + this.m + ";pauseDelay=" + this.a);
        this.c.d(j2);
        this.c.e();
    }

    public final void j() {
        this.b = System.nanoTime();
        this.g.m();
    }

    public final void k() {
        long jNanoTime = System.nanoTime() - this.b;
        this.b = jNanoTime;
        this.a += jNanoTime;
        this.g.o();
    }

    public final void l(int i) {
        this.f = i;
    }

    public final void m(a aVar) {
        String str = "handleStartRecording " + aVar;
        String str2 = "handleStartRecording " + aVar;
        q(aVar.e, aVar.b, aVar.c, aVar.d, aVar.a);
    }

    public final void n() throws IllegalStateException, InterruptedException {
        this.g.k(true);
        this.g.q();
        r();
    }

    public final void o(EGLContext eGLContext) {
        String str = "handleUpdatedSharedContext " + eGLContext;
        this.c.c();
        this.e.a();
        this.d.e();
        mi3 mi3Var = new mi3(eGLContext, 1);
        this.d = mi3Var;
        this.c.f(mi3Var);
        this.c.b();
        vh3 vh3Var = new vh3();
        this.e = vh3Var;
        vh3Var.c();
        uh3 uh3Var = null;
        this.l = null;
        if (0 != 0) {
            uh3Var.c();
            this.l.l(this.o, this.p);
            this.l.f(this.q, this.r);
        }
    }

    public void p() {
        this.h.sendMessage(this.h.obtainMessage(6));
    }

    public final void q(EGLContext eGLContext, int i, int i2, int i3, String str) {
        this.g = new pi3(i, i2, i3, str);
        this.q = i;
        this.r = i2;
        mi3 mi3Var = new mi3(eGLContext, 1);
        this.d = mi3Var;
        qi3 qi3Var = new qi3(mi3Var, this.g.l(), true);
        this.c = qi3Var;
        qi3Var.b();
        vh3 vh3Var = new vh3();
        this.e = vh3Var;
        vh3Var.c();
        uh3 uh3Var = null;
        this.l = null;
        if (0 != 0) {
            uh3Var.c();
            this.l.l(this.o, this.p);
            this.l.f(this.q, this.r);
        }
        int i4 = this.s;
        if (i4 > 0) {
            float[] fArr = new float[16];
            if (i4 % 180 == 0) {
                ui3.getShowMatrix(fArr, this.o, this.p, i, i2);
                this.n.t(ui3.rotate(fArr, this.s));
            } else {
                ui3.getShowMatrix(fArr, this.p, this.o, i2, i);
                this.n.t(ui3.rotate(fArr, 360 - this.s));
            }
        }
        this.n.a();
        this.m = -1L;
    }

    public final void r() throws IllegalStateException {
        this.g.n();
        qi3 qi3Var = this.c;
        if (qi3Var != null) {
            qi3Var.g();
            this.c = null;
        }
        vh3 vh3Var = this.e;
        if (vh3Var != null) {
            vh3Var.a();
            this.e = null;
        }
        mi3 mi3Var = this.d;
        if (mi3Var != null) {
            mi3Var.e();
            this.d = null;
        }
        uh3 uh3Var = this.l;
        if (uh3Var != null) {
            uh3Var.a();
            this.l = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Looper.prepare();
        synchronized (this.i) {
            this.h = new b(this);
            this.j = true;
            this.i.notify();
        }
        Looper.loop();
        synchronized (this.i) {
            this.k = false;
            this.j = false;
            this.h = null;
        }
    }

    public void s() {
        this.h.sendMessage(this.h.obtainMessage(7));
    }

    public void t(int i, int i2) {
        this.o = i;
        this.p = i2;
    }

    public void u(int i) {
        synchronized (this.i) {
            if (this.j) {
                this.h.sendMessage(this.h.obtainMessage(3, i, 0, null));
            }
        }
    }

    public void v(int i) {
        this.s = i;
        String str = " TextureMovieEncoder:mSensorRotation1: " + i;
        int i2 = this.s;
        if (i2 == 90 || i2 == 270) {
            int i3 = this.o;
            this.o = this.p;
            this.p = i3;
            int i4 = this.q;
            this.q = this.r;
            this.r = i4;
        }
    }

    public void w(a aVar) {
        String str = "config.mWidth: =" + aVar.b;
        String str2 = "config.mHeight: =" + aVar.c;
        synchronized (this.i) {
            if (this.k) {
                return;
            }
            this.k = true;
            new Thread(this, "TextureMovieEncoder").start();
            while (!this.j) {
                try {
                    this.i.wait();
                } catch (InterruptedException unused) {
                }
            }
            this.h.sendMessage(this.h.obtainMessage(0, aVar));
        }
    }

    public void x() {
        this.h.sendMessage(this.h.obtainMessage(1));
        this.h.sendMessage(this.h.obtainMessage(5));
    }

    public void y(EGLContext eGLContext) {
        this.h.sendMessage(this.h.obtainMessage(4, eGLContext));
    }
}
