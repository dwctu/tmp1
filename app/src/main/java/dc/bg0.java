package dc;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: TimeToSampleBox.java */
/* loaded from: classes.dex */
public class bg0 extends g41 {
    public static final /* synthetic */ JoinPoint.StaticPart p = null;
    public static final /* synthetic */ JoinPoint.StaticPart q = null;
    public static final /* synthetic */ JoinPoint.StaticPart r = null;
    public List<a> o;

    /* compiled from: TimeToSampleBox.java */
    public static class a {
        public long a;
        public long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public long a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }

        public void c(long j) {
            this.a = j;
        }

        public String toString() {
            return "Entry{count=" + this.a + ", delta=" + this.b + MessageFormatter.DELIM_STOP;
        }
    }

    static {
        n();
        new WeakHashMap();
    }

    public bg0() {
        super("stts");
        this.o = Collections.emptyList();
    }

    public static /* synthetic */ void n() {
        Factory factory = new Factory("TimeToSampleBox.java", bg0.class);
        p = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.util.List"), 79);
        q = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "java.util.List", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "void"), 83);
        r = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.lang.String"), 87);
    }

    @Override // dc.e41
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        int iA = c51.a(df0.j(byteBuffer));
        this.o = new ArrayList(iA);
        for (int i = 0; i < iA; i++) {
            this.o.add(new a(df0.j(byteBuffer), df0.j(byteBuffer)));
        }
    }

    @Override // dc.e41
    public void c(ByteBuffer byteBuffer) {
        t(byteBuffer);
        ef0.g(byteBuffer, this.o.size());
        for (a aVar : this.o) {
            ef0.g(byteBuffer, aVar.a());
            ef0.g(byteBuffer, aVar.b());
        }
    }

    @Override // dc.e41
    public long d() {
        return (this.o.size() * 8) + 8;
    }

    public String toString() {
        j41.b().c(Factory.makeJP(r, this, this));
        return "TimeToSampleBox[entryCount=" + this.o.size() + "]";
    }

    public void u(List<a> list) {
        j41.b().c(Factory.makeJP(q, this, this, list));
        this.o = list;
    }
}
