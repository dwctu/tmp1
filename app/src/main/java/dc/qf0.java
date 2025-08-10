package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;

/* compiled from: MediaHeaderBox.java */
/* loaded from: classes.dex */
public class qf0 extends g41 {
    public static final /* synthetic */ JoinPoint.StaticPart A = null;
    public static final /* synthetic */ JoinPoint.StaticPart B = null;
    public static final /* synthetic */ JoinPoint.StaticPart C = null;
    public static final /* synthetic */ JoinPoint.StaticPart D = null;
    public static final /* synthetic */ JoinPoint.StaticPart t = null;
    public static final /* synthetic */ JoinPoint.StaticPart u = null;
    public static final /* synthetic */ JoinPoint.StaticPart v = null;
    public static final /* synthetic */ JoinPoint.StaticPart w = null;
    public static final /* synthetic */ JoinPoint.StaticPart x = null;
    public static final /* synthetic */ JoinPoint.StaticPart y = null;
    public static final /* synthetic */ JoinPoint.StaticPart z = null;
    public Date o;
    public Date p;
    public long q;
    public long r;
    public String s;

    static {
        n();
    }

    public qf0() {
        super("mdhd");
        this.o = new Date();
        this.p = new Date();
        this.s = "eng";
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("MediaHeaderBox.java", qf0.class);
        t = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 46);
        u = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 50);
        D = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 118);
        v = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 54);
        w = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 58);
        x = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 62);
        y = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "creationTime", "", "void"), 79);
        z = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "modificationTime", "", "void"), 83);
        A = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "long", "timescale", "", "void"), 87);
        B = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "long", TypedValues.TransitionType.S_DURATION, "", "void"), 91);
        C = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "java.lang.String", "language", "", "void"), 95);
    }

    public void A(long j) {
        j41.b().c(Factory.makeJP(B, this, this, Conversions.longObject(j)));
        this.r = j;
    }

    public void B(String str) {
        j41.b().c(Factory.makeJP(C, this, this, str));
        this.s = str;
    }

    public void C(long j) {
        j41.b().c(Factory.makeJP(A, this, this, Conversions.longObject(j)));
        this.q = j;
    }

    @Override // dc.e41
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        if (p() == 1) {
            this.o = d51.b(df0.k(byteBuffer));
            this.p = d51.b(df0.k(byteBuffer));
            this.q = df0.j(byteBuffer);
            this.r = df0.k(byteBuffer);
        } else {
            this.o = d51.b(df0.j(byteBuffer));
            this.p = d51.b(df0.j(byteBuffer));
            this.q = df0.j(byteBuffer);
            this.r = df0.j(byteBuffer);
        }
        this.s = df0.f(byteBuffer);
        df0.h(byteBuffer);
    }

    @Override // dc.e41
    public void c(ByteBuffer byteBuffer) {
        t(byteBuffer);
        if (p() == 1) {
            ef0.h(byteBuffer, d51.a(this.o));
            ef0.h(byteBuffer, d51.a(this.p));
            ef0.g(byteBuffer, this.q);
            ef0.h(byteBuffer, this.r);
        } else {
            ef0.g(byteBuffer, d51.a(this.o));
            ef0.g(byteBuffer, d51.a(this.p));
            ef0.g(byteBuffer, this.q);
            ef0.g(byteBuffer, this.r);
        }
        ef0.d(byteBuffer, this.s);
        ef0.e(byteBuffer, 0);
    }

    @Override // dc.e41
    public long d() {
        return (p() == 1 ? 32L : 20L) + 2 + 2;
    }

    public String toString() {
        j41.b().c(Factory.makeJP(D, this, this));
        return "MediaHeaderBox[creationTime=" + u() + ";modificationTime=" + x() + ";timescale=" + y() + ";duration=" + v() + ";language=" + w() + "]";
    }

    public Date u() {
        j41.b().c(Factory.makeJP(t, this, this));
        return this.o;
    }

    public long v() {
        j41.b().c(Factory.makeJP(w, this, this));
        return this.r;
    }

    public String w() {
        j41.b().c(Factory.makeJP(x, this, this));
        return this.s;
    }

    public Date x() {
        j41.b().c(Factory.makeJP(u, this, this));
        return this.p;
    }

    public long y() {
        j41.b().c(Factory.makeJP(v, this, this));
        return this.q;
    }

    public void z(Date date) {
        j41.b().c(Factory.makeJP(y, this, this, date));
        this.o = date;
    }
}
