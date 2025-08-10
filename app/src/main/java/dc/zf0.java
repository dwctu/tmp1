package dc;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;

/* compiled from: StaticChunkOffsetBox.java */
/* loaded from: classes.dex */
public class zf0 extends if0 {
    public static final /* synthetic */ JoinPoint.StaticPart q = null;
    public static final /* synthetic */ JoinPoint.StaticPart r = null;
    public long[] p;

    static {
        n();
    }

    public zf0() {
        super("stco");
        this.p = new long[0];
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("StaticChunkOffsetBox.java", zf0.class);
        q = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "", "", "", "[J"), 39);
        r = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "[J", "chunkOffsets", "", "void"), 48);
    }

    @Override // dc.e41
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        int iA = c51.a(df0.j(byteBuffer));
        this.p = new long[iA];
        for (int i = 0; i < iA; i++) {
            this.p[i] = df0.j(byteBuffer);
        }
    }

    @Override // dc.e41
    public void c(ByteBuffer byteBuffer) {
        t(byteBuffer);
        ef0.g(byteBuffer, this.p.length);
        for (long j : this.p) {
            ef0.g(byteBuffer, j);
        }
    }

    @Override // dc.e41
    public long d() {
        return (this.p.length * 4) + 8;
    }

    @Override // dc.if0
    public long[] u() {
        j41.b().c(Factory.makeJP(q, this, this));
        return this.p;
    }

    public void v(long[] jArr) {
        j41.b().c(Factory.makeJP(r, this, this, jArr));
        this.p = jArr;
    }
}
