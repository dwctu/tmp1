package dc;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation.java */
/* loaded from: classes.dex */
public class v8 {
    public final List<p8<pa, Path>> a;
    public final List<p8<Integer, Integer>> b;
    public final List<ka> c;

    public v8(List<ka> list) {
        this.c = list;
        this.a = new ArrayList(list.size());
        this.b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.a.add(list.get(i).b().a());
            this.b.add(list.get(i).c().a());
        }
    }

    public List<p8<pa, Path>> a() {
        return this.a;
    }

    public List<ka> b() {
        return this.c;
    }

    public List<p8<Integer, Integer>> c() {
        return this.b;
    }
}
