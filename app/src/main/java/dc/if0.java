package dc;

import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;

/* compiled from: ChunkOffsetBox.java */
/* loaded from: classes.dex */
public abstract class if0 extends g41 {
    public static final /* synthetic */ JoinPoint.StaticPart o = null;

    static {
        n();
    }

    public if0(String str) {
        super(str);
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("ChunkOffsetBox.java", if0.class);
        o = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.ChunkOffsetBox", "", "", "", "java.lang.String"), 18);
    }

    public String toString() {
        j41.b().c(Factory.makeJP(o, this, this));
        return String.valueOf(getClass().getSimpleName()) + "[entryCount=" + u().length + "]";
    }

    public abstract long[] u();
}
