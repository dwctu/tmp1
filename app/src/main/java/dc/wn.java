package dc;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: TargetTracker.java */
/* loaded from: classes.dex */
public final class wn implements qn {
    public final Set<cp<?>> a = Collections.newSetFromMap(new WeakHashMap());

    public void c() {
        this.a.clear();
    }

    @NonNull
    public List<cp<?>> d() {
        return wp.j(this.a);
    }

    public void j(@NonNull cp<?> cpVar) {
        this.a.add(cpVar);
    }

    public void k(@NonNull cp<?> cpVar) {
        this.a.remove(cpVar);
    }

    @Override // dc.qn
    public void onDestroy() {
        Iterator it = wp.j(this.a).iterator();
        while (it.hasNext()) {
            ((cp) it.next()).onDestroy();
        }
    }

    @Override // dc.qn
    public void onStart() {
        Iterator it = wp.j(this.a).iterator();
        while (it.hasNext()) {
            ((cp) it.next()).onStart();
        }
    }

    @Override // dc.qn
    public void onStop() {
        Iterator it = wp.j(this.a).iterator();
        while (it.hasNext()) {
            ((cp) it.next()).onStop();
        }
    }
}
