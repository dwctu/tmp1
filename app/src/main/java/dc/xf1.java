package dc;

import com.squareup.moshi.JsonDataException;
import dc.nf1;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

/* compiled from: MapJsonAdapter.java */
/* loaded from: classes3.dex */
public final class xf1<K, V> extends nf1<Map<K, V>> {
    public static final nf1.d c = new a();
    public final nf1<K> a;
    public final nf1<V> b;

    /* compiled from: MapJsonAdapter.java */
    public class a implements nf1.d {
        @Override // dc.nf1.d
        public nf1<?> a(Type type, Set<? extends Annotation> set, yf1 yf1Var) {
            Class<?> clsG;
            if (!set.isEmpty() || (clsG = ag1.g(type)) != Map.class) {
                return null;
            }
            Type[] typeArrI = ag1.i(type, clsG);
            return new xf1(yf1Var, typeArrI[0], typeArrI[1]).f();
        }
    }

    public xf1(yf1 yf1Var, Type type, Type type2) {
        this.a = yf1Var.d(type);
        this.b = yf1Var.d(type2);
    }

    @Override // dc.nf1
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Map<K, V> b(qf1 qf1Var) throws IOException {
        wf1 wf1Var = new wf1();
        qf1Var.e();
        while (qf1Var.p()) {
            qf1Var.V();
            K kB = this.a.b(qf1Var);
            V vB = this.b.b(qf1Var);
            V vPut = wf1Var.put(kB, vB);
            if (vPut != null) {
                throw new JsonDataException("Map key '" + kB + "' has multiple values at path " + qf1Var.getPath() + ": " + vPut + " and " + vB);
            }
        }
        qf1Var.j();
        return wf1Var;
    }

    @Override // dc.nf1
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void h(vf1 vf1Var, Map<K, V> map) throws IOException {
        vf1Var.e();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey() == null) {
                throw new JsonDataException("Map key is null at " + vf1Var.getPath());
            }
            vf1Var.I();
            this.a.h(vf1Var, entry.getKey());
            this.b.h(vf1Var, entry.getValue());
        }
        vf1Var.m();
    }

    public String toString() {
        return "JsonAdapter(" + this.a + "=" + this.b + ")";
    }
}
