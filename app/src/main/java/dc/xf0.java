package dc;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: SampleToChunkBox.java */
/* loaded from: classes.dex */
public class xf0 extends g41 {
    public static final /* synthetic */ JoinPoint.StaticPart p = null;
    public static final /* synthetic */ JoinPoint.StaticPart q = null;
    public static final /* synthetic */ JoinPoint.StaticPart r = null;
    public static final /* synthetic */ JoinPoint.StaticPart s = null;
    public List<a> o;

    /* compiled from: SampleToChunkBox.java */
    public static class a {
        public long a;
        public long b;
        public long c;

        public a(long j, long j2, long j3) {
            this.a = j;
            this.b = j2;
            this.c = j3;
        }

        public long a() {
            return this.a;
        }

        public long b() {
            return this.c;
        }

        public long c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.c == aVar.c && this.b == aVar.b;
        }

        public int hashCode() {
            long j = this.a;
            long j2 = this.b;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.c;
            return i + ((int) (j3 ^ (j3 >>> 32)));
        }

        public String toString() {
            return "Entry{firstChunk=" + this.a + ", samplesPerChunk=" + this.b + ", sampleDescriptionIndex=" + this.c + MessageFormatter.DELIM_STOP;
        }
    }

    static {
        n();
    }

    public xf0() {
        super("stsc");
        this.o = Collections.emptyList();
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("SampleToChunkBox.java", xf0.class);
        p = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.util.List"), 47);
        q = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "java.util.List", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "void"), 51);
        r = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.lang.String"), 84);
        s = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "blowup", "com.coremedia.iso.boxes.SampleToChunkBox", "int", "chunkCount", "", "[J"), 95);
    }

    @Override // dc.e41
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        int iA = c51.a(df0.j(byteBuffer));
        this.o = new ArrayList(iA);
        for (int i = 0; i < iA; i++) {
            this.o.add(new a(df0.j(byteBuffer), df0.j(byteBuffer), df0.j(byteBuffer)));
        }
    }

    @Override // dc.e41
    public void c(ByteBuffer byteBuffer) {
        t(byteBuffer);
        ef0.g(byteBuffer, this.o.size());
        for (a aVar : this.o) {
            ef0.g(byteBuffer, aVar.a());
            ef0.g(byteBuffer, aVar.c());
            ef0.g(byteBuffer, aVar.b());
        }
    }

    @Override // dc.e41
    public long d() {
        return (this.o.size() * 12) + 8;
    }

    public String toString() {
        j41.b().c(Factory.makeJP(r, this, this));
        return "SampleToChunkBox[entryCount=" + this.o.size() + "]";
    }

    public List<a> u() {
        j41.b().c(Factory.makeJP(p, this, this));
        return this.o;
    }

    public void v(List<a> list) {
        j41.b().c(Factory.makeJP(q, this, this, list));
        this.o = list;
    }
}
