package dc;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;

/* compiled from: SampleSizeBox.java */
/* loaded from: classes.dex */
public class vf0 extends g41 {
    public static final /* synthetic */ JoinPoint.StaticPart r = null;
    public static final /* synthetic */ JoinPoint.StaticPart s = null;
    public static final /* synthetic */ JoinPoint.StaticPart t = null;
    public static final /* synthetic */ JoinPoint.StaticPart u = null;
    public static final /* synthetic */ JoinPoint.StaticPart v = null;
    public static final /* synthetic */ JoinPoint.StaticPart w = null;
    public static final /* synthetic */ JoinPoint.StaticPart x = null;
    public long o;
    public long[] p;
    public int q;

    static {
        n();
    }

    public vf0() {
        super("stsz");
        this.p = new long[0];
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("SampleSizeBox.java", vf0.class);
        r = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 50);
        s = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "long", "sampleSize", "", "void"), 54);
        t = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSampleSizeAtIndex", "com.coremedia.iso.boxes.SampleSizeBox", "int", FirebaseAnalytics.Param.INDEX, "", "long"), 59);
        u = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSampleCount", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 67);
        v = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "[J"), 76);
        w = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "[J", "sampleSizes", "", "void"), 80);
        x = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "java.lang.String"), 119);
    }

    @Override // dc.e41
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        this.o = df0.j(byteBuffer);
        int iA = c51.a(df0.j(byteBuffer));
        this.q = iA;
        if (this.o == 0) {
            this.p = new long[iA];
            for (int i = 0; i < this.q; i++) {
                this.p[i] = df0.j(byteBuffer);
            }
        }
    }

    @Override // dc.e41
    public void c(ByteBuffer byteBuffer) {
        t(byteBuffer);
        ef0.g(byteBuffer, this.o);
        if (this.o != 0) {
            ef0.g(byteBuffer, this.q);
            return;
        }
        ef0.g(byteBuffer, this.p.length);
        for (long j : this.p) {
            ef0.g(byteBuffer, j);
        }
    }

    @Override // dc.e41
    public long d() {
        return (this.o == 0 ? this.p.length * 4 : 0) + 12;
    }

    public String toString() {
        j41.b().c(Factory.makeJP(x, this, this));
        return "SampleSizeBox[sampleSize=" + v() + ";sampleCount=" + u() + "]";
    }

    public long u() {
        j41.b().c(Factory.makeJP(u, this, this));
        return this.o > 0 ? this.q : this.p.length;
    }

    public long v() {
        j41.b().c(Factory.makeJP(r, this, this));
        return this.o;
    }

    public void w(long[] jArr) {
        j41.b().c(Factory.makeJP(w, this, this, jArr));
        this.p = jArr;
    }
}
