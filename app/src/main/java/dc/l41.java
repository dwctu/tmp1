package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;

/* compiled from: ESDescriptorBox.java */
/* loaded from: classes2.dex */
public class l41 extends k41 {
    public static final /* synthetic */ JoinPoint.StaticPart v = null;
    public static final /* synthetic */ JoinPoint.StaticPart w = null;
    public static final /* synthetic */ JoinPoint.StaticPart x = null;
    public static final /* synthetic */ JoinPoint.StaticPart y = null;

    static {
        n();
    }

    public l41() {
        super("esds");
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("ESDescriptorBox.java", l41.class);
        v = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor"), 33);
        w = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor", "esDescriptor", "", "void"), 37);
        x = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "equals", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "java.lang.Object", "o", "", TypedValues.Custom.S_BOOLEAN), 42);
        y = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "int"), 53);
    }

    public boolean equals(Object obj) {
        j41.b().c(Factory.makeJP(x, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || l41.class != obj.getClass()) {
            return false;
        }
        ByteBuffer byteBuffer = this.o;
        ByteBuffer byteBuffer2 = ((l41) obj).o;
        return byteBuffer == null ? byteBuffer2 == null : byteBuffer.equals(byteBuffer2);
    }

    public int hashCode() {
        j41.b().c(Factory.makeJP(y, this, this));
        ByteBuffer byteBuffer = this.o;
        if (byteBuffer != null) {
            return byteBuffer.hashCode();
        }
        return 0;
    }

    public void w(t41 t41Var) {
        j41.b().c(Factory.makeJP(w, this, this, t41Var));
        super.v(t41Var);
    }
}
