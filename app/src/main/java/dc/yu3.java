package dc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Menu.java */
/* loaded from: classes4.dex */
public final class yu3 {
    public List<zu3> a = new ArrayList();
    public List<zu3> b = new ArrayList();
    public boolean c;
    public int d;

    public yu3(boolean z, int i) {
        this.c = true;
        this.d = 0;
        this.c = z;
        this.d = i;
    }

    public List<zu3> a(int i) {
        return i == 1 ? this.a : this.b;
    }

    public int b() {
        return this.d;
    }

    public int c(int i) {
        int i2 = 0;
        if (i == 1) {
            Iterator<zu3> it = this.a.iterator();
            while (it.hasNext()) {
                i2 += it.next().a;
            }
            return i2;
        }
        Iterator<zu3> it2 = this.b.iterator();
        while (it2.hasNext()) {
            i2 += it2.next().a;
        }
        return i2;
    }

    public boolean d() {
        return this.c;
    }
}
