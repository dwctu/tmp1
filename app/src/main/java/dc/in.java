package dc;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle.java */
/* loaded from: classes.dex */
public class in implements pn {
    public final Set<qn> a = Collections.newSetFromMap(new WeakHashMap());
    public boolean b;
    public boolean c;

    @Override // dc.pn
    public void a(@NonNull qn qnVar) {
        this.a.remove(qnVar);
    }

    @Override // dc.pn
    public void b(@NonNull qn qnVar) {
        this.a.add(qnVar);
        if (this.c) {
            qnVar.onDestroy();
        } else if (this.b) {
            qnVar.onStart();
        } else {
            qnVar.onStop();
        }
    }

    public void c() {
        this.c = true;
        Iterator it = wp.j(this.a).iterator();
        while (it.hasNext()) {
            ((qn) it.next()).onDestroy();
        }
    }

    public void d() {
        this.b = true;
        Iterator it = wp.j(this.a).iterator();
        while (it.hasNext()) {
            ((qn) it.next()).onStart();
        }
    }

    public void e() {
        this.b = false;
        Iterator it = wp.j(this.a).iterator();
        while (it.hasNext()) {
            ((qn) it.next()).onStop();
        }
    }
}
