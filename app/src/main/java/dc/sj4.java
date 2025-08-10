package dc;

import android.content.res.AssetFileDescriptor;
import android.view.Surface;
import java.util.Map;

/* compiled from: AbstractPlayer.java */
/* loaded from: classes5.dex */
public abstract class sj4 {
    public a a;

    /* compiled from: AbstractPlayer.java */
    public interface a {
        void a();

        void b(int i, int i2);

        void e(int i, int i2);

        void g();

        void onPrepared();
    }

    public abstract int a();

    public abstract long b();

    public abstract long c();

    public abstract float d();

    public abstract long e();

    public abstract void f();

    public abstract boolean g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public abstract void l(long j);

    public abstract void m(AssetFileDescriptor assetFileDescriptor);

    public abstract void n(String str, Map<String, String> map);

    public abstract void o(boolean z);

    public void p(a aVar) {
        this.a = aVar;
    }

    public abstract void q(float f);

    public abstract void r(Surface surface);

    public abstract void s(float f, float f2);

    public abstract void t();
}
