package dc;

import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: LottieComposition.java */
/* loaded from: classes.dex */
public class f7 {
    public Map<String, List<ya>> c;
    public Map<String, i7> d;
    public Map<String, j9> e;
    public List<o9> f;
    public SparseArrayCompat<k9> g;
    public LongSparseArray<ya> h;
    public List<ya> i;
    public Rect j;
    public float k;
    public float l;
    public float m;
    public boolean n;
    public final p7 a = new p7();
    public final HashSet<String> b = new HashSet<>();
    public int o = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        dd.c(str);
        this.b.add(str);
    }

    public Rect b() {
        return this.j;
    }

    public SparseArrayCompat<k9> c() {
        return this.g;
    }

    public float d() {
        return (long) ((e() / this.m) * 1000.0f);
    }

    public float e() {
        return this.l - this.k;
    }

    public float f() {
        return this.l;
    }

    public Map<String, j9> g() {
        return this.e;
    }

    public float h() {
        return this.m;
    }

    public Map<String, i7> i() {
        return this.d;
    }

    public List<ya> j() {
        return this.i;
    }

    @Nullable
    public o9 k(String str) {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            o9 o9Var = this.f.get(i);
            if (o9Var.a(str)) {
                return o9Var;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int l() {
        return this.o;
    }

    public p7 m() {
        return this.a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<ya> n(String str) {
        return this.c.get(str);
    }

    public float o() {
        return this.k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean p() {
        return this.n;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void q(int i) {
        this.o += i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void r(Rect rect, float f, float f2, float f3, List<ya> list, LongSparseArray<ya> longSparseArray, Map<String, List<ya>> map, Map<String, i7> map2, SparseArrayCompat<k9> sparseArrayCompat, Map<String, j9> map3, List<o9> list2) {
        this.j = rect;
        this.k = f;
        this.l = f2;
        this.m = f3;
        this.i = list;
        this.h = longSparseArray;
        this.c = map;
        this.d = map2;
        this.g = sparseArrayCompat;
        this.e = map3;
        this.f = list2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ya s(long j) {
        return this.h.get(j);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void t(boolean z) {
        this.n = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<ya> it = this.i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().w("\t"));
        }
        return sb.toString();
    }

    public void u(boolean z) {
        this.a.b(z);
    }
}
