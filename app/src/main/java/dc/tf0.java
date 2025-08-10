package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import io.agora.rtc2.Constants;
import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
import org.bouncycastle.apache.bzip2.BZip2Constants;
import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: MovieHeaderBox.java */
/* loaded from: classes.dex */
public class tf0 extends g41 {
    public static final /* synthetic */ JoinPoint.StaticPart C = null;
    public static final /* synthetic */ JoinPoint.StaticPart D = null;
    public static final /* synthetic */ JoinPoint.StaticPart E = null;
    public static final /* synthetic */ JoinPoint.StaticPart F = null;
    public static final /* synthetic */ JoinPoint.StaticPart G = null;
    public static final /* synthetic */ JoinPoint.StaticPart K = null;
    public static final /* synthetic */ JoinPoint.StaticPart L = null;
    public static final /* synthetic */ JoinPoint.StaticPart M = null;
    public static final /* synthetic */ JoinPoint.StaticPart N = null;
    public static final /* synthetic */ JoinPoint.StaticPart O = null;
    public static final /* synthetic */ JoinPoint.StaticPart P = null;
    public static final /* synthetic */ JoinPoint.StaticPart Q = null;
    public static final /* synthetic */ JoinPoint.StaticPart R = null;
    public static final /* synthetic */ JoinPoint.StaticPart S = null;
    public static final /* synthetic */ JoinPoint.StaticPart T = null;
    public static final /* synthetic */ JoinPoint.StaticPart U = null;
    public static final /* synthetic */ JoinPoint.StaticPart V = null;
    public static final /* synthetic */ JoinPoint.StaticPart W = null;
    public static final /* synthetic */ JoinPoint.StaticPart X = null;
    public static final /* synthetic */ JoinPoint.StaticPart Y = null;
    public static final /* synthetic */ JoinPoint.StaticPart Z = null;
    public static final /* synthetic */ JoinPoint.StaticPart a0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart b0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart c0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart d0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart e0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart f0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart g0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart h0 = null;
    public int A;
    public int B;
    public Date o;
    public Date p;
    public long q;
    public long r;
    public double s;
    public float t;
    public h51 u;
    public long v;
    public int w;
    public int x;
    public int y;
    public int z;

    static {
        n();
    }

    public tf0() {
        super("mvhd");
        this.s = 1.0d;
        this.t = 1.0f;
        this.u = h51.j;
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("MovieHeaderBox.java", tf0.class);
        C = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 63);
        D = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 67);
        P = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "modificationTime", "", "void"), 203);
        Q = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "timescale", "", "void"), 211);
        R = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "long", TypedValues.TransitionType.S_DURATION, "", "void"), 215);
        S = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setRate", "com.coremedia.iso.boxes.MovieHeaderBox", "double", "rate", "", "void"), 222);
        T = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setVolume", "com.coremedia.iso.boxes.MovieHeaderBox", TypedValues.Custom.S_FLOAT, "volume", "", "void"), 226);
        U = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 230);
        V = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "nextTrackId", "", "void"), 234);
        W = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 238);
        X = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewTime", "", "void"), 242);
        Y = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 246);
        E = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 71);
        Z = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewDuration", "", "void"), 250);
        a0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 254);
        b0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "posterTime", "", "void"), BZip2Constants.MAX_ALPHA_SIZE);
        c0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 262);
        d0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionTime", "", "void"), 266);
        e0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), Constants.VIDEO_ORIENTATION_270);
        f0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionDuration", "", "void"), 274);
        g0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 278);
        h0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "currentTime", "", "void"), 282);
        F = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 75);
        G = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getRate", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "double"), 79);
        K = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", TypedValues.Custom.S_FLOAT), 83);
        L = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 87);
        M = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 91);
        N = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.lang.String"), CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA);
        O = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "creationTime", "", "void"), DownloaderService.STATUS_WAITING_FOR_NETWORK);
    }

    public float A() {
        j41.b().c(Factory.makeJP(K, this, this));
        return this.t;
    }

    public void B(Date date) {
        j41.b().c(Factory.makeJP(O, this, this, date));
        this.o = date;
        if (d51.a(date) >= 4294967296L) {
            s(1);
        }
    }

    public void C(long j) {
        j41.b().c(Factory.makeJP(R, this, this, Conversions.longObject(j)));
        this.r = j;
        if (j >= 4294967296L) {
            s(1);
        }
    }

    public void D(h51 h51Var) {
        j41.b().c(Factory.makeJP(U, this, this, h51Var));
        this.u = h51Var;
    }

    public void E(Date date) {
        j41.b().c(Factory.makeJP(P, this, this, date));
        this.p = date;
        if (d51.a(date) >= 4294967296L) {
            s(1);
        }
    }

    public void F(long j) {
        j41.b().c(Factory.makeJP(V, this, this, Conversions.longObject(j)));
        this.v = j;
    }

    public void G(long j) {
        j41.b().c(Factory.makeJP(Q, this, this, Conversions.longObject(j)));
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
        this.s = df0.d(byteBuffer);
        this.t = df0.e(byteBuffer);
        df0.h(byteBuffer);
        df0.j(byteBuffer);
        df0.j(byteBuffer);
        this.u = h51.a(byteBuffer);
        this.w = byteBuffer.getInt();
        this.x = byteBuffer.getInt();
        this.y = byteBuffer.getInt();
        this.z = byteBuffer.getInt();
        this.A = byteBuffer.getInt();
        this.B = byteBuffer.getInt();
        this.v = df0.j(byteBuffer);
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
        ef0.b(byteBuffer, this.s);
        ef0.c(byteBuffer, this.t);
        ef0.e(byteBuffer, 0);
        ef0.g(byteBuffer, 0L);
        ef0.g(byteBuffer, 0L);
        this.u.c(byteBuffer);
        byteBuffer.putInt(this.w);
        byteBuffer.putInt(this.x);
        byteBuffer.putInt(this.y);
        byteBuffer.putInt(this.z);
        byteBuffer.putInt(this.A);
        byteBuffer.putInt(this.B);
        ef0.g(byteBuffer, this.v);
    }

    @Override // dc.e41
    public long d() {
        return (p() == 1 ? 32L : 20L) + 80;
    }

    public String toString() {
        j41.b().c(Factory.makeJP(N, this, this));
        return "MovieHeaderBox[creationTime=" + u() + ";modificationTime=" + w() + ";timescale=" + z() + ";duration=" + v() + ";rate=" + y() + ";volume=" + A() + ";matrix=" + this.u + ";nextTrackId=" + x() + "]";
    }

    public Date u() {
        j41.b().c(Factory.makeJP(C, this, this));
        return this.o;
    }

    public long v() {
        j41.b().c(Factory.makeJP(F, this, this));
        return this.r;
    }

    public Date w() {
        j41.b().c(Factory.makeJP(D, this, this));
        return this.p;
    }

    public long x() {
        j41.b().c(Factory.makeJP(M, this, this));
        return this.v;
    }

    public double y() {
        j41.b().c(Factory.makeJP(G, this, this));
        return this.s;
    }

    public long z() {
        j41.b().c(Factory.makeJP(E, this, this));
        return this.q;
    }
}
