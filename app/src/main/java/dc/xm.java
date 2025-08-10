package dc;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GifFrameLoader.java */
/* loaded from: classes.dex */
public class xm {
    public final wf a;
    public final Handler b;
    public final List<b> c;
    public final rf d;
    public final cj e;
    public boolean f;
    public boolean g;
    public boolean h;
    public qf<Bitmap> i;
    public a j;
    public boolean k;
    public a l;
    public Bitmap m;
    public eh<Bitmap> n;
    public a o;

    @Nullable
    public d p;
    public int q;
    public int r;
    public int s;

    /* compiled from: GifFrameLoader.java */
    @VisibleForTesting
    public static class a extends wo<Bitmap> {
        public final Handler d;
        public final int e;
        public final long f;
        public Bitmap g;

        public a(Handler handler, int i, long j) {
            this.d = handler;
            this.e = i;
            this.f = j;
        }

        public Bitmap c() {
            return this.g;
        }

        @Override // dc.cp
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void f(@NonNull Bitmap bitmap, @Nullable hp<? super Bitmap> hpVar) {
            this.g = bitmap;
            this.d.sendMessageAtTime(this.d.obtainMessage(1, this), this.f);
        }

        @Override // dc.cp
        public void e(@Nullable Drawable drawable) {
            this.g = null;
        }
    }

    /* compiled from: GifFrameLoader.java */
    public interface b {
        void a();
    }

    /* compiled from: GifFrameLoader.java */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                xm.this.m((a) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            xm.this.d.l((a) message.obj);
            return false;
        }
    }

    /* compiled from: GifFrameLoader.java */
    @VisibleForTesting
    public interface d {
        void a();
    }

    public xm(kf kfVar, wf wfVar, int i, int i2, eh<Bitmap> ehVar, Bitmap bitmap) {
        this(kfVar.f(), kf.w(kfVar.h()), wfVar, null, i(kf.w(kfVar.h()), i, i2), ehVar, bitmap);
    }

    public static xg g() {
        return new mp(Double.valueOf(Math.random()));
    }

    public static qf<Bitmap> i(rf rfVar, int i, int i2) {
        return rfVar.j().a(qo.r0(ii.b).o0(true).h0(true).W(i, i2));
    }

    public void a() {
        this.c.clear();
        n();
        q();
        a aVar = this.j;
        if (aVar != null) {
            this.d.l(aVar);
            this.j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.d.l(aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.d.l(aVar3);
            this.o = null;
        }
        this.a.clear();
        this.k = true;
    }

    public ByteBuffer b() {
        return this.a.getData().asReadOnlyBuffer();
    }

    public Bitmap c() {
        a aVar = this.j;
        return aVar != null ? aVar.c() : this.m;
    }

    public int d() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.e;
        }
        return -1;
    }

    public Bitmap e() {
        return this.m;
    }

    public int f() {
        return this.a.b();
    }

    public int h() {
        return this.s;
    }

    public int j() {
        return this.a.g() + this.q;
    }

    public int k() {
        return this.r;
    }

    public final void l() {
        if (!this.f || this.g) {
            return;
        }
        if (this.h) {
            vp.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.a.e();
            this.h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            m(aVar);
            return;
        }
        this.g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + this.a.d();
        this.a.a();
        this.l = new a(this.b, this.a.f(), jUptimeMillis);
        this.i.a(qo.s0(g())).I0(this.a).x0(this.l);
    }

    @VisibleForTesting
    public void m(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.g = false;
        if (this.k) {
            this.b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f) {
            this.o = aVar;
            return;
        }
        if (aVar.c() != null) {
            n();
            a aVar2 = this.j;
            this.j = aVar;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                this.c.get(size).a();
            }
            if (aVar2 != null) {
                this.b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        l();
    }

    public final void n() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.e.c(bitmap);
            this.m = null;
        }
    }

    public void o(eh<Bitmap> ehVar, Bitmap bitmap) {
        vp.d(ehVar);
        this.n = ehVar;
        vp.d(bitmap);
        this.m = bitmap;
        this.i = this.i.a(new qo().j0(ehVar));
        this.q = wp.h(bitmap);
        this.r = bitmap.getWidth();
        this.s = bitmap.getHeight();
    }

    public final void p() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.k = false;
        l();
    }

    public final void q() {
        this.f = false;
    }

    public void r(b bVar) {
        if (this.k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.c.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.c.isEmpty();
        this.c.add(bVar);
        if (zIsEmpty) {
            p();
        }
    }

    public void s(b bVar) {
        this.c.remove(bVar);
        if (this.c.isEmpty()) {
            q();
        }
    }

    public xm(cj cjVar, rf rfVar, wf wfVar, Handler handler, qf<Bitmap> qfVar, eh<Bitmap> ehVar, Bitmap bitmap) {
        this.c = new ArrayList();
        this.d = rfVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.e = cjVar;
        this.b = handler;
        this.i = qfVar;
        this.a = wfVar;
        o(ehVar, bitmap);
    }
}
