package dc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;

/* compiled from: AbstractDescriptorBox.java */
/* loaded from: classes2.dex */
public class k41 extends g41 {
    public static Logger p;
    public static final /* synthetic */ JoinPoint.StaticPart q = null;
    public static final /* synthetic */ JoinPoint.StaticPart r = null;
    public static final /* synthetic */ JoinPoint.StaticPart s = null;
    public static final /* synthetic */ JoinPoint.StaticPart t = null;
    public static final /* synthetic */ JoinPoint.StaticPart u = null;
    public ByteBuffer o;

    static {
        n();
        p = Logger.getLogger(k41.class.getName());
    }

    public k41(String str) {
        super(str);
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("AbstractDescriptorBox.java", k41.class);
        q = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getData", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "java.nio.ByteBuffer"), 42);
        r = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDescriptor", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor"), 58);
        s = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDescriptorAsString", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "java.lang.String"), 62);
        t = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDescriptor", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor", "descriptor", "", "void"), 66);
        u = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setData", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "java.nio.ByteBuffer", "data", "", "void"), 70);
    }

    @Override // dc.e41
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        this.o = byteBuffer.slice();
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        try {
            this.o.rewind();
            x41.a(-1, this.o);
        } catch (IOException e) {
            p.log(Level.WARNING, "Error parsing ObjectDescriptor", (Throwable) e);
        } catch (IndexOutOfBoundsException e2) {
            p.log(Level.WARNING, "Error parsing ObjectDescriptor", (Throwable) e2);
        }
    }

    @Override // dc.e41
    public void c(ByteBuffer byteBuffer) {
        t(byteBuffer);
        this.o.rewind();
        byteBuffer.put(this.o);
    }

    @Override // dc.e41
    public long d() {
        return this.o.limit() + 4;
    }

    public void u(ByteBuffer byteBuffer) {
        j41.b().c(Factory.makeJP(u, this, this, byteBuffer));
        this.o = byteBuffer;
    }

    public void v(n41 n41Var) {
        j41.b().c(Factory.makeJP(t, this, this, n41Var));
    }
}
