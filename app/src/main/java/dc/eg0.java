package dc;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;

/* compiled from: VideoMediaHeaderBox.java */
/* loaded from: classes.dex */
public class eg0 extends gf0 {
    public static final /* synthetic */ JoinPoint.StaticPart q = null;
    public static final /* synthetic */ JoinPoint.StaticPart r = null;
    public static final /* synthetic */ JoinPoint.StaticPart s = null;
    public static final /* synthetic */ JoinPoint.StaticPart t = null;
    public static final /* synthetic */ JoinPoint.StaticPart u = null;
    public int o;
    public int[] p;

    static {
        n();
    }

    public eg0() {
        super("vmhd");
        this.o = 0;
        this.p = new int[3];
        r(1);
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("VideoMediaHeaderBox.java", eg0.class);
        q = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "int"), 39);
        r = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "[I"), 43);
        s = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "java.lang.String"), 71);
        t = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "[I", "opcolor", "", "void"), 75);
        u = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "int", "graphicsmode", "", "void"), 79);
    }

    @Override // dc.e41
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        this.o = df0.h(byteBuffer);
        this.p = new int[3];
        for (int i = 0; i < 3; i++) {
            this.p[i] = df0.h(byteBuffer);
        }
    }

    @Override // dc.e41
    public void c(ByteBuffer byteBuffer) {
        t(byteBuffer);
        ef0.e(byteBuffer, this.o);
        for (int i : this.p) {
            ef0.e(byteBuffer, i);
        }
    }

    @Override // dc.e41
    public long d() {
        return 12L;
    }

    public String toString() {
        j41.b().c(Factory.makeJP(s, this, this));
        return "VideoMediaHeaderBox[graphicsmode=" + u() + ";opcolor0=" + v()[0] + ";opcolor1=" + v()[1] + ";opcolor2=" + v()[2] + "]";
    }

    public int u() {
        j41.b().c(Factory.makeJP(q, this, this));
        return this.o;
    }

    public int[] v() {
        j41.b().c(Factory.makeJP(r, this, this));
        return this.p;
    }
}
