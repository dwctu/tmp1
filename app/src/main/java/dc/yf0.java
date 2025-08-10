package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;

/* compiled from: SoundMediaHeaderBox.java */
/* loaded from: classes.dex */
public class yf0 extends gf0 {
    public static final /* synthetic */ JoinPoint.StaticPart p = null;
    public static final /* synthetic */ JoinPoint.StaticPart q = null;
    public float o;

    static {
        n();
    }

    public yf0() {
        super("smhd");
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("SoundMediaHeaderBox.java", yf0.class);
        p = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getBalance", "com.coremedia.iso.boxes.SoundMediaHeaderBox", "", "", "", TypedValues.Custom.S_FLOAT), 36);
        q = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.SoundMediaHeaderBox", "", "", "", "java.lang.String"), 58);
    }

    @Override // dc.e41
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        this.o = df0.e(byteBuffer);
        df0.h(byteBuffer);
    }

    @Override // dc.e41
    public void c(ByteBuffer byteBuffer) {
        t(byteBuffer);
        ef0.c(byteBuffer, this.o);
        ef0.e(byteBuffer, 0);
    }

    @Override // dc.e41
    public long d() {
        return 8L;
    }

    public String toString() {
        j41.b().c(Factory.makeJP(q, this, this));
        return "SoundMediaHeaderBox[balance=" + u() + "]";
    }

    public float u() {
        j41.b().c(Factory.makeJP(p, this, this));
        return this.o;
    }
}
