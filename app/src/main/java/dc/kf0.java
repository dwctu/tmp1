package dc;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;

/* compiled from: DataEntryUrlBox.java */
/* loaded from: classes.dex */
public class kf0 extends g41 {
    public static final /* synthetic */ JoinPoint.StaticPart o = null;

    static {
        n();
    }

    public kf0() {
        super("url ");
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("DataEntryUrlBox.java", kf0.class);
        o = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.DataEntryUrlBox", "", "", "", "java.lang.String"), 51);
    }

    @Override // dc.e41
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
    }

    @Override // dc.e41
    public void c(ByteBuffer byteBuffer) {
        t(byteBuffer);
    }

    @Override // dc.e41
    public long d() {
        return 4L;
    }

    public String toString() {
        j41.b().c(Factory.makeJP(o, this, this));
        return "DataEntryUrlBox[]";
    }
}
