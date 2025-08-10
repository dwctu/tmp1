package dc;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;

/* compiled from: FileTypeBox.java */
/* loaded from: classes.dex */
public class nf0 extends e41 {
    public static final /* synthetic */ JoinPoint.StaticPart n = null;
    public static final /* synthetic */ JoinPoint.StaticPart o = null;
    public static final /* synthetic */ JoinPoint.StaticPart p = null;
    public static final /* synthetic */ JoinPoint.StaticPart q = null;
    public static final /* synthetic */ JoinPoint.StaticPart r = null;
    public static final /* synthetic */ JoinPoint.StaticPart s = null;
    public String k;
    public long l;
    public List<String> m;

    static {
        n();
    }

    public nf0() {
        super("ftyp");
        this.m = Collections.emptyList();
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("FileTypeBox.java", nf0.class);
        n = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getMajorBrand", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "java.lang.String"), 85);
        o = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setMajorBrand", "com.coremedia.iso.boxes.FileTypeBox", "java.lang.String", "majorBrand", "", "void"), 94);
        p = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setMinorVersion", "com.coremedia.iso.boxes.FileTypeBox", "long", "minorVersion", "", "void"), 103);
        q = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getMinorVersion", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "long"), 113);
        r = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getCompatibleBrands", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "java.util.List"), 122);
        s = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setCompatibleBrands", "com.coremedia.iso.boxes.FileTypeBox", "java.util.List", "compatibleBrands", "", "void"), 126);
    }

    @Override // dc.e41
    public void a(ByteBuffer byteBuffer) {
        this.k = df0.b(byteBuffer);
        this.l = df0.j(byteBuffer);
        int iRemaining = byteBuffer.remaining() / 4;
        this.m = new LinkedList();
        for (int i = 0; i < iRemaining; i++) {
            this.m.add(df0.b(byteBuffer));
        }
    }

    @Override // dc.e41
    public void c(ByteBuffer byteBuffer) {
        byteBuffer.put(cf0.y(this.k));
        ef0.g(byteBuffer, this.l);
        Iterator<String> it = this.m.iterator();
        while (it.hasNext()) {
            byteBuffer.put(cf0.y(it.next()));
        }
    }

    @Override // dc.e41
    public long d() {
        return (this.m.size() * 4) + 8;
    }

    public String o() {
        j41.b().c(Factory.makeJP(n, this, this));
        return this.k;
    }

    public long p() {
        j41.b().c(Factory.makeJP(q, this, this));
        return this.l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileTypeBox[");
        sb.append("majorBrand=");
        sb.append(o());
        sb.append(";");
        sb.append("minorVersion=");
        sb.append(p());
        for (String str : this.m) {
            sb.append(";");
            sb.append("compatibleBrand=");
            sb.append(str);
        }
        sb.append("]");
        return sb.toString();
    }

    public nf0(String str, long j, List<String> list) {
        super("ftyp");
        this.m = Collections.emptyList();
        this.k = str;
        this.l = j;
        this.m = list;
    }
}
