package dc;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;

/* compiled from: SyncSampleBox.java */
/* loaded from: classes.dex */
public class ag0 extends g41 {
    public static final /* synthetic */ JoinPoint.StaticPart p = null;
    public static final /* synthetic */ JoinPoint.StaticPart q = null;
    public static final /* synthetic */ JoinPoint.StaticPart r = null;
    public long[] o;

    static {
        n();
    }

    public ag0() {
        super("stss");
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("SyncSampleBox.java", ag0.class);
        p = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "[J"), 46);
        q = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "java.lang.String"), 77);
        r = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "[J", "sampleNumber", "", "void"), 81);
    }

    @Override // dc.e41
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        int iA = c51.a(df0.j(byteBuffer));
        this.o = new long[iA];
        for (int i = 0; i < iA; i++) {
            this.o[i] = df0.j(byteBuffer);
        }
    }

    @Override // dc.e41
    public void c(ByteBuffer byteBuffer) {
        t(byteBuffer);
        ef0.g(byteBuffer, this.o.length);
        for (long j : this.o) {
            ef0.g(byteBuffer, j);
        }
    }

    @Override // dc.e41
    public long d() {
        return (this.o.length * 4) + 8;
    }

    public String toString() {
        j41.b().c(Factory.makeJP(q, this, this));
        return "SyncSampleBox[entryCount=" + this.o.length + "]";
    }

    public void u(long[] jArr) {
        j41.b().c(Factory.makeJP(r, this, this, jArr));
        this.o = jArr;
    }
}
