package dc;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker.java */
/* loaded from: classes.dex */
public class vn {
    public final Set<mo> a = Collections.newSetFromMap(new WeakHashMap());
    public final List<mo> b = new ArrayList();
    public boolean c;

    public boolean a(@Nullable mo moVar) {
        boolean z = true;
        if (moVar == null) {
            return true;
        }
        boolean zRemove = this.a.remove(moVar);
        if (!this.b.remove(moVar) && !zRemove) {
            z = false;
        }
        if (z) {
            moVar.clear();
        }
        return z;
    }

    public void b() {
        Iterator it = wp.j(this.a).iterator();
        while (it.hasNext()) {
            a((mo) it.next());
        }
        this.b.clear();
    }

    public void c() {
        this.c = true;
        for (mo moVar : wp.j(this.a)) {
            if (moVar.isRunning() || moVar.isComplete()) {
                moVar.clear();
                this.b.add(moVar);
            }
        }
    }

    public void d() {
        this.c = true;
        for (mo moVar : wp.j(this.a)) {
            if (moVar.isRunning()) {
                moVar.pause();
                this.b.add(moVar);
            }
        }
    }

    public void e() {
        for (mo moVar : wp.j(this.a)) {
            if (!moVar.isComplete() && !moVar.e()) {
                moVar.clear();
                if (this.c) {
                    this.b.add(moVar);
                } else {
                    moVar.h();
                }
            }
        }
    }

    public void f() {
        this.c = false;
        for (mo moVar : wp.j(this.a)) {
            if (!moVar.isComplete() && !moVar.isRunning()) {
                moVar.h();
            }
        }
        this.b.clear();
    }

    public void g(@NonNull mo moVar) {
        this.a.add(moVar);
        if (!this.c) {
            moVar.h();
            return;
        }
        moVar.clear();
        Log.isLoggable("RequestTracker", 2);
        this.b.add(moVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.a.size() + ", isPaused=" + this.c + "}";
    }
}
