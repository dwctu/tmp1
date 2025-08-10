package dc;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;

/* compiled from: AbstractFullBox.java */
/* loaded from: classes2.dex */
public abstract class g41 extends e41 implements hf0 {
    public static final /* synthetic */ JoinPoint.StaticPart m = null;
    public static final /* synthetic */ JoinPoint.StaticPart n = null;
    public int k;
    public int l;

    static {
        n();
    }

    public g41(String str) {
        super(str);
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("AbstractFullBox.java", g41.class);
        m = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setVersion", "com.googlecode.mp4parser.AbstractFullBox", "int", "version", "", "void"), 51);
        n = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setFlags", "com.googlecode.mp4parser.AbstractFullBox", "int", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "void"), 64);
    }

    public int o() {
        if (!this.c) {
            l();
        }
        return this.l;
    }

    public int p() {
        if (!this.c) {
            l();
        }
        return this.k;
    }

    public final long q(ByteBuffer byteBuffer) {
        this.k = df0.l(byteBuffer);
        this.l = df0.i(byteBuffer);
        return 4L;
    }

    public void r(int i) {
        j41.b().c(Factory.makeJP(n, this, this, Conversions.intObject(i)));
        this.l = i;
    }

    public void s(int i) {
        j41.b().c(Factory.makeJP(m, this, this, Conversions.intObject(i)));
        this.k = i;
    }

    public final void t(ByteBuffer byteBuffer) {
        ef0.i(byteBuffer, this.k);
        ef0.f(byteBuffer, this.l);
    }
}
