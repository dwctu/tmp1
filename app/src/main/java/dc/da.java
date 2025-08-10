package dc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue.java */
/* loaded from: classes.dex */
public abstract class da<V, O> implements ca<V, O> {
    public final List<id<V>> a;

    public da(V v) {
        this(Collections.singletonList(new id(v)));
    }

    @Override // dc.ca
    public List<id<V>> b() {
        return this.a;
    }

    @Override // dc.ca
    public boolean isStatic() {
        return this.a.isEmpty() || (this.a.size() == 1 && this.a.get(0).h());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }

    public da(List<id<V>> list) {
        this.a = list;
    }
}
