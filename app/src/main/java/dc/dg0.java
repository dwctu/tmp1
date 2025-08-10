package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import io.agora.rtc2.video.VideoCaptureFormat;
import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: TrackHeaderBox.java */
/* loaded from: classes.dex */
public class dg0 extends g41 {
    public static final /* synthetic */ JoinPoint.StaticPart A = null;
    public static final /* synthetic */ JoinPoint.StaticPart B = null;
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
    public static final /* synthetic */ JoinPoint.StaticPart y = null;
    public static final /* synthetic */ JoinPoint.StaticPart z = null;
    public Date o;
    public Date p;
    public long q;
    public long r;
    public int s;
    public int t;
    public float u;
    public h51 v;
    public double w;
    public double x;

    static {
        n();
    }

    public dg0() {
        super("tkhd");
        this.v = h51.j;
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("TrackHeaderBox.java", dg0.class);
        y = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 60);
        z = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 64);
        L = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getContent", "com.coremedia.iso.boxes.TrackHeaderBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 142);
        M = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.lang.String"), 170);
        N = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "creationTime", "", "void"), DownloaderService.STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION);
        O = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "modificationTime", "", "void"), 203);
        P = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "trackId", "", "void"), 211);
        Q = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "long", TypedValues.TransitionType.S_DURATION, "", "void"), 215);
        R = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "layer", "", "void"), 222);
        S = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "alternateGroup", "", "void"), 226);
        T = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setVolume", "com.coremedia.iso.boxes.TrackHeaderBox", TypedValues.Custom.S_FLOAT, "volume", "", "void"), 230);
        U = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 234);
        A = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 68);
        V = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "double", VideoCaptureFormat.keyWidth, "", "void"), 238);
        W = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "double", VideoCaptureFormat.keyHeight, "", "void"), 242);
        X = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 247);
        Y = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 251);
        Z = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 255);
        a0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "isInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 259);
        b0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", TypedValues.Custom.S_BOOLEAN, StreamManagement.Enabled.ELEMENT, "", "void"), 263);
        c0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", TypedValues.Custom.S_BOOLEAN, "inMovie", "", "void"), 271);
        d0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", TypedValues.Custom.S_BOOLEAN, "inPreview", "", "void"), 279);
        e0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", TypedValues.Custom.S_BOOLEAN, "inPoster", "", "void"), 287);
        B = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 72);
        C = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 76);
        D = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 80);
        E = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", TypedValues.Custom.S_FLOAT), 84);
        F = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 88);
        G = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 92);
        K = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 96);
    }

    public long A() {
        j41.b().c(Factory.makeJP(A, this, this));
        return this.q;
    }

    public float B() {
        j41.b().c(Factory.makeJP(E, this, this));
        return this.u;
    }

    public double C() {
        j41.b().c(Factory.makeJP(G, this, this));
        return this.w;
    }

    public void D(int i) {
        j41.b().c(Factory.makeJP(S, this, this, Conversions.intObject(i)));
        this.t = i;
    }

    public void E(Date date) {
        j41.b().c(Factory.makeJP(N, this, this, date));
        this.o = date;
        if (d51.a(date) >= 4294967296L) {
            s(1);
        }
    }

    public void F(long j) {
        j41.b().c(Factory.makeJP(Q, this, this, Conversions.longObject(j)));
        this.r = j;
        if (j >= 4294967296L) {
            r(1);
        }
    }

    public void G(boolean z2) {
        j41.b().c(Factory.makeJP(b0, this, this, Conversions.booleanObject(z2)));
        if (z2) {
            r(o() | 1);
        } else {
            r(o() & (-2));
        }
    }

    public void H(double d) {
        j41.b().c(Factory.makeJP(W, this, this, Conversions.doubleObject(d)));
        this.x = d;
    }

    public void I(boolean z2) {
        j41.b().c(Factory.makeJP(c0, this, this, Conversions.booleanObject(z2)));
        if (z2) {
            r(o() | 2);
        } else {
            r(o() & (-3));
        }
    }

    public void J(boolean z2) {
        j41.b().c(Factory.makeJP(d0, this, this, Conversions.booleanObject(z2)));
        if (z2) {
            r(o() | 4);
        } else {
            r(o() & (-5));
        }
    }

    public void K(int i) {
        j41.b().c(Factory.makeJP(R, this, this, Conversions.intObject(i)));
        this.s = i;
    }

    public void L(h51 h51Var) {
        j41.b().c(Factory.makeJP(U, this, this, h51Var));
        this.v = h51Var;
    }

    public void M(Date date) {
        j41.b().c(Factory.makeJP(O, this, this, date));
        this.p = date;
        if (d51.a(date) >= 4294967296L) {
            s(1);
        }
    }

    public void N(long j) {
        j41.b().c(Factory.makeJP(P, this, this, Conversions.longObject(j)));
        this.q = j;
    }

    public void O(float f) {
        j41.b().c(Factory.makeJP(T, this, this, Conversions.floatObject(f)));
        this.u = f;
    }

    public void P(double d) {
        j41.b().c(Factory.makeJP(V, this, this, Conversions.doubleObject(d)));
        this.w = d;
    }

    @Override // dc.e41
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        if (p() == 1) {
            this.o = d51.b(df0.k(byteBuffer));
            this.p = d51.b(df0.k(byteBuffer));
            this.q = df0.j(byteBuffer);
            df0.j(byteBuffer);
            long j = byteBuffer.getLong();
            this.r = j;
            if (j < -1) {
                throw new RuntimeException("The tracks duration is bigger than Long.MAX_VALUE");
            }
        } else {
            this.o = d51.b(df0.j(byteBuffer));
            this.p = d51.b(df0.j(byteBuffer));
            this.q = df0.j(byteBuffer);
            df0.j(byteBuffer);
            this.r = df0.j(byteBuffer);
        }
        df0.j(byteBuffer);
        df0.j(byteBuffer);
        this.s = df0.h(byteBuffer);
        this.t = df0.h(byteBuffer);
        this.u = df0.e(byteBuffer);
        df0.h(byteBuffer);
        this.v = h51.a(byteBuffer);
        this.w = df0.d(byteBuffer);
        this.x = df0.d(byteBuffer);
    }

    @Override // dc.e41
    public void c(ByteBuffer byteBuffer) {
        j41.b().c(Factory.makeJP(L, this, this, byteBuffer));
        t(byteBuffer);
        if (p() == 1) {
            ef0.h(byteBuffer, d51.a(this.o));
            ef0.h(byteBuffer, d51.a(this.p));
            ef0.g(byteBuffer, this.q);
            ef0.g(byteBuffer, 0L);
            ef0.h(byteBuffer, this.r);
        } else {
            ef0.g(byteBuffer, d51.a(this.o));
            ef0.g(byteBuffer, d51.a(this.p));
            ef0.g(byteBuffer, this.q);
            ef0.g(byteBuffer, 0L);
            ef0.g(byteBuffer, this.r);
        }
        ef0.g(byteBuffer, 0L);
        ef0.g(byteBuffer, 0L);
        ef0.e(byteBuffer, this.s);
        ef0.e(byteBuffer, this.t);
        ef0.c(byteBuffer, this.u);
        ef0.e(byteBuffer, 0);
        this.v.c(byteBuffer);
        ef0.b(byteBuffer, this.w);
        ef0.b(byteBuffer, this.x);
    }

    @Override // dc.e41
    public long d() {
        return (p() == 1 ? 36L : 24L) + 60;
    }

    public String toString() {
        j41.b().c(Factory.makeJP(M, this, this));
        return "TrackHeaderBox[creationTime=" + v() + ";modificationTime=" + z() + ";trackId=" + A() + ";duration=" + w() + ";layer=" + y() + ";alternateGroup=" + u() + ";volume=" + B() + ";matrix=" + this.v + ";width=" + C() + ";height=" + x() + "]";
    }

    public int u() {
        j41.b().c(Factory.makeJP(D, this, this));
        return this.t;
    }

    public Date v() {
        j41.b().c(Factory.makeJP(y, this, this));
        return this.o;
    }

    public long w() {
        j41.b().c(Factory.makeJP(B, this, this));
        return this.r;
    }

    public double x() {
        j41.b().c(Factory.makeJP(K, this, this));
        return this.x;
    }

    public int y() {
        j41.b().c(Factory.makeJP(C, this, this));
        return this.s;
    }

    public Date z() {
        j41.b().c(Factory.makeJP(z, this, this));
        return this.p;
    }
}
