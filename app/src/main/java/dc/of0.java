package dc;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;

/* compiled from: HandlerBox.java */
/* loaded from: classes.dex */
public class of0 extends g41 {
    public static final /* synthetic */ JoinPoint.StaticPart A = null;
    public static final /* synthetic */ JoinPoint.StaticPart B = null;
    public static final Map<String, String> v;
    public static final /* synthetic */ JoinPoint.StaticPart w = null;
    public static final /* synthetic */ JoinPoint.StaticPart x = null;
    public static final /* synthetic */ JoinPoint.StaticPart y = null;
    public static final /* synthetic */ JoinPoint.StaticPart z = null;
    public String o;
    public String p;
    public long q;
    public long r;
    public long s;
    public boolean t;
    public long u;

    static {
        n();
        HashMap map = new HashMap();
        map.put("odsm", "ObjectDescriptorStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("crsm", "ClockReferenceStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("sdsm", "SceneDescriptionStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("m7sm", "MPEG7Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("ocsm", "ObjectContentInfoStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("ipsm", "IPMP Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("mjsm", "MPEG-J Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("mdir", "Apple Meta Data iTunes Reader");
        map.put("mp7b", "MPEG-7 binary XML");
        map.put("mp7t", "MPEG-7 XML");
        map.put("vide", "Video Track");
        map.put("soun", "Sound Track");
        map.put("hint", "Hint Track");
        map.put("appl", "Apple specific");
        map.put("meta", "Timed Metadata track - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        v = Collections.unmodifiableMap(map);
    }

    public of0() {
        super("hdlr");
        this.p = null;
        this.t = true;
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("HandlerBox.java", of0.class);
        w = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getHandlerType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 78);
        x = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setName", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "name", "", "void"), 87);
        y = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setHandlerType", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "handlerType", "", "void"), 91);
        z = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getName", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 95);
        A = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getHumanReadableTrackType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 99);
        B = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 149);
    }

    @Override // dc.e41
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        this.u = df0.j(byteBuffer);
        this.o = df0.b(byteBuffer);
        this.q = df0.j(byteBuffer);
        this.r = df0.j(byteBuffer);
        this.s = df0.j(byteBuffer);
        if (byteBuffer.remaining() <= 0) {
            this.t = false;
            return;
        }
        String strG = df0.g(byteBuffer, byteBuffer.remaining());
        this.p = strG;
        if (!strG.endsWith("\u0000")) {
            this.t = false;
            return;
        }
        String str = this.p;
        this.p = str.substring(0, str.length() - 1);
        this.t = true;
    }

    @Override // dc.e41
    public void c(ByteBuffer byteBuffer) {
        t(byteBuffer);
        ef0.g(byteBuffer, this.u);
        byteBuffer.put(cf0.y(this.o));
        ef0.g(byteBuffer, this.q);
        ef0.g(byteBuffer, this.r);
        ef0.g(byteBuffer, this.s);
        String str = this.p;
        if (str != null) {
            byteBuffer.put(ff0.b(str));
        }
        if (this.t) {
            byteBuffer.put((byte) 0);
        }
    }

    @Override // dc.e41
    public long d() {
        return this.t ? ff0.c(this.p) + 25 : ff0.c(this.p) + 24;
    }

    public String toString() {
        j41.b().c(Factory.makeJP(B, this, this));
        return "HandlerBox[handlerType=" + u() + ";name=" + v() + "]";
    }

    public String u() {
        j41.b().c(Factory.makeJP(w, this, this));
        return this.o;
    }

    public String v() {
        j41.b().c(Factory.makeJP(z, this, this));
        return this.p;
    }

    public void w(String str) {
        j41.b().c(Factory.makeJP(y, this, this, str));
        this.o = str;
    }

    public void x(String str) {
        j41.b().c(Factory.makeJP(x, this, this, str));
        this.p = str;
    }
}
