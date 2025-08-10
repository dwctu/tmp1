package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.ByteBuffer;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: AvcConfigurationBox.java */
/* loaded from: classes3.dex */
public final class fd1 extends e41 {
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
    public static final /* synthetic */ JoinPoint.StaticPart l = null;
    public static final /* synthetic */ JoinPoint.StaticPart m = null;
    public static final /* synthetic */ JoinPoint.StaticPart n = null;
    public static final /* synthetic */ JoinPoint.StaticPart o = null;
    public static final /* synthetic */ JoinPoint.StaticPart p = null;
    public static final /* synthetic */ JoinPoint.StaticPart q = null;
    public static final /* synthetic */ JoinPoint.StaticPart r = null;
    public static final /* synthetic */ JoinPoint.StaticPart s = null;
    public static final /* synthetic */ JoinPoint.StaticPart t = null;
    public static final /* synthetic */ JoinPoint.StaticPart u = null;
    public static final /* synthetic */ JoinPoint.StaticPart v = null;
    public static final /* synthetic */ JoinPoint.StaticPart w = null;
    public static final /* synthetic */ JoinPoint.StaticPart x = null;
    public static final /* synthetic */ JoinPoint.StaticPart y = null;
    public static final /* synthetic */ JoinPoint.StaticPart z = null;
    public gd1 k;

    static {
        n();
    }

    public fd1() {
        super("avcC");
        this.k = new gd1();
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("AvcConfigurationBox.java", fd1.class);
        l = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 44);
        m = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 48);
        v = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcLevelIndication", "", "void"), 84);
        w = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "lengthSizeMinusOne", "", "void"), 88);
        x = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSets", "", "void"), 92);
        y = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "pictureParameterSets", "", "void"), 96);
        z = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 100);
        A = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "chromaFormat", "", "void"), 104);
        B = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 108);
        C = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthLumaMinus8", "", "void"), 112);
        D = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 116);
        E = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthChromaMinus8", "", "void"), 120);
        n = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 52);
        F = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 124);
        G = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSetExts", "", "void"), 128);
        K = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "hasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 132);
        L = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setHasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", TypedValues.Custom.S_BOOLEAN, "hasExts", "", "void"), CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA);
        M = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getContentSize", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "long"), CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA);
        N = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getContent", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 153);
        O = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 158);
        P = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getPPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 162);
        Q = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getavcDecoderConfigurationRecord", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord"), 167);
        R = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.lang.String"), 172);
        o = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 56);
        p = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 60);
        q = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 64);
        r = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 68);
        s = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "configurationVersion", "", "void"), 72);
        t = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcProfileIndication", "", "void"), 76);
        u = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "profileCompatibility", "", "void"), 80);
    }

    @Override // dc.e41
    public void a(ByteBuffer byteBuffer) {
        this.k = new gd1(byteBuffer);
    }

    @Override // dc.e41
    public void c(ByteBuffer byteBuffer) {
        j41.b().c(Factory.makeJP(N, this, this, byteBuffer));
        this.k.a(byteBuffer);
    }

    @Override // dc.e41
    public long d() {
        j41.b().c(Factory.makeJP(M, this, this));
        return this.k.b();
    }

    public void o(int i) {
        j41.b().c(Factory.makeJP(v, this, this, Conversions.intObject(i)));
        this.k.d = i;
    }

    public void p(int i) {
        j41.b().c(Factory.makeJP(t, this, this, Conversions.intObject(i)));
        this.k.b = i;
    }

    public void q(int i) {
        j41.b().c(Factory.makeJP(E, this, this, Conversions.intObject(i)));
        this.k.k = i;
    }

    public void r(int i) {
        j41.b().c(Factory.makeJP(C, this, this, Conversions.intObject(i)));
        this.k.j = i;
    }

    public void s(int i) {
        j41.b().c(Factory.makeJP(A, this, this, Conversions.intObject(i)));
        this.k.i = i;
    }

    public void t(int i) {
        j41.b().c(Factory.makeJP(s, this, this, Conversions.intObject(i)));
        this.k.a = i;
    }

    public String toString() {
        j41.b().c(Factory.makeJP(R, this, this));
        return "AvcConfigurationBox{avcDecoderConfigurationRecord=" + this.k + MessageFormatter.DELIM_STOP;
    }

    public void u(int i) {
        j41.b().c(Factory.makeJP(w, this, this, Conversions.intObject(i)));
        this.k.e = i;
    }

    public void v(List<byte[]> list) {
        j41.b().c(Factory.makeJP(y, this, this, list));
        this.k.g = list;
    }

    public void w(int i) {
        j41.b().c(Factory.makeJP(u, this, this, Conversions.intObject(i)));
        this.k.c = i;
    }

    public void x(List<byte[]> list) {
        j41.b().c(Factory.makeJP(x, this, this, list));
        this.k.f = list;
    }
}
