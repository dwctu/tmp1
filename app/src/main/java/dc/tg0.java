package dc;

import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.ethanhua.skeleton.SkeletonAdapter;

/* compiled from: RecyclerViewSkeletonScreen.java */
/* loaded from: classes.dex */
public class tg0 implements vg0 {
    public final RecyclerView a;
    public final RecyclerView.Adapter b;
    public final SkeletonAdapter c;
    public final boolean d;

    /* compiled from: RecyclerViewSkeletonScreen.java */
    public static class b {
        public RecyclerView.Adapter a;
        public final RecyclerView b;
        public int f;
        public boolean c = true;
        public int d = 10;
        public int e = sg0.layout_default_item_skeleton;
        public int g = 1000;
        public int h = 20;
        public boolean i = true;

        public b(RecyclerView recyclerView) {
            this.b = recyclerView;
            this.f = ContextCompat.getColor(recyclerView.getContext(), rg0.shimmer_color);
        }

        public b j(RecyclerView.Adapter adapter) {
            this.a = adapter;
            return this;
        }

        public b k(@IntRange(from = 0, to = 30) int i) {
            this.h = i;
            return this;
        }

        public b l(int i) {
            this.d = i;
            return this;
        }

        public b m(int i) {
            this.g = i;
            return this;
        }

        public b n(boolean z) {
            this.i = z;
            return this;
        }

        public b o(@LayoutRes int i) {
            this.e = i;
            return this;
        }

        public b p(boolean z) {
            this.c = z;
            return this;
        }

        public tg0 q() {
            tg0 tg0Var = new tg0(this);
            tg0Var.b();
            return tg0Var;
        }
    }

    @Override // dc.vg0
    public void a() {
        this.a.setAdapter(this.b);
    }

    public void b() {
        this.a.setAdapter(this.c);
        if (this.a.isComputingLayout() || !this.d) {
            return;
        }
        this.a.setLayoutFrozen(true);
    }

    public tg0(b bVar) {
        this.a = bVar.b;
        this.b = bVar.a;
        SkeletonAdapter skeletonAdapter = new SkeletonAdapter();
        this.c = skeletonAdapter;
        skeletonAdapter.l(bVar.d);
        skeletonAdapter.m(bVar.e);
        skeletonAdapter.q(bVar.c);
        skeletonAdapter.o(bVar.f);
        skeletonAdapter.n(bVar.h);
        skeletonAdapter.p(bVar.g);
        this.d = bVar.i;
    }
}
