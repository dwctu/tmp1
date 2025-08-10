package dc;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.yydcdut.sdlv.ItemBackGroundLayout;
import com.yydcdut.sdlv.SlideAndDragListView;
import com.yydcdut.sdlv.SlideListView;
import dc.xu3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* compiled from: WrapperAdapter.java */
/* loaded from: classes4.dex */
public class bv3 implements WrapperListAdapter, xu3.e, View.OnClickListener, AbsListView.OnScrollListener, xu3.c, ru3, xu3.d, ItemBackGroundLayout.a {
    public Context a;
    public ListAdapter b;
    public SparseArray<yu3> c;
    public SlideListView d;
    public boolean f;
    public Object g;
    public HashMap<Integer, Integer> i;
    public boolean m;
    public d n;
    public c o;
    public g p;
    public f q;
    public e r;
    public int e = -1;
    public int h = -1;
    public int j = -1;
    public int k = Integer.MAX_VALUE;
    public int l = 300;
    public DataSetObserver s = new a();

    /* compiled from: WrapperAdapter.java */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            bv3.this.B();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
        }
    }

    /* compiled from: WrapperAdapter.java */
    public class b implements ViewTreeObserver.OnPreDrawListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            bv3.this.d.getViewTreeObserver().removeOnPreDrawListener(this);
            int firstVisiblePosition = bv3.this.d.getFirstVisiblePosition();
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < bv3.this.d.getChildCount(); i++) {
                View childAt = bv3.this.d.getChildAt(i);
                int i2 = firstVisiblePosition + i;
                if (i2 >= bv3.this.d.getHeaderViewsCount()) {
                    bv3 bv3Var = bv3.this;
                    if (bv3Var.v(i2 - bv3Var.d.getHeaderViewsCount())) {
                        bv3 bv3Var2 = bv3.this;
                        Integer num = (Integer) bv3.this.i.get(Integer.valueOf(bv3Var2.getItem(i2 - bv3Var2.d.getHeaderViewsCount()).hashCode()));
                        int top = childAt.getTop();
                        if (num != null && num.intValue() != top) {
                            arrayList.add(ObjectAnimator.ofFloat(childAt, "translationY", num.intValue() - top, 0.0f));
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                animatorSet.setDuration(bv3.this.l).playTogether(arrayList);
                animatorSet.start();
            }
            bv3.this.i.clear();
            return true;
        }
    }

    /* compiled from: WrapperAdapter.java */
    public interface c {
        int b(View view, int i, int i2, int i3);
    }

    /* compiled from: WrapperAdapter.java */
    public interface d {
        void c(View view, int i, int i2);

        void g(View view, int i, int i2);
    }

    /* compiled from: WrapperAdapter.java */
    public interface e {
        void d(View view, int i);
    }

    /* compiled from: WrapperAdapter.java */
    public interface f {
        void e(AbsListView absListView, int i);

        void h(AbsListView absListView, int i, int i2, int i3);
    }

    /* compiled from: WrapperAdapter.java */
    public interface g {
        void a();

        void f(View view, int i);
    }

    public bv3(Context context, SlideListView slideListView, ListAdapter listAdapter, SparseArray<yu3> sparseArray) {
        this.a = context;
        this.d = slideListView;
        slideListView.setOnSuperScrollListener(this);
        this.b = listAdapter;
        this.c = sparseArray;
        this.d.n(this);
        this.i = new HashMap<>();
    }

    public int A(float f2) {
        int i = this.e;
        if (i != -1) {
            SlideListView slideListView = this.d;
            xu3 xu3Var = (xu3) slideListView.getChildAt(i - slideListView.getFirstVisiblePosition());
            if (xu3Var != null) {
                int iL = xu3Var.l(f2);
                if (iL == 1 || iL == 2) {
                    this.e = -1;
                }
                return iL;
            }
            this.e = -1;
        }
        return 0;
    }

    public void B() {
        int i = this.e;
        if (i != -1) {
            SlideListView slideListView = this.d;
            xu3 xu3Var = (xu3) slideListView.getChildAt(i - slideListView.getFirstVisiblePosition());
            if (xu3Var != null) {
                xu3Var.m();
            }
            this.e = -1;
        }
    }

    public final void C(xu3.d dVar) {
        int i = this.e;
        if (i != -1) {
            SlideListView slideListView = this.d;
            xu3 xu3Var = (xu3) slideListView.getChildAt(i - slideListView.getFirstVisiblePosition());
            if (xu3Var != null) {
                xu3Var.n(dVar);
            }
            this.e = -1;
        }
    }

    public void D(int i) {
        this.k = i;
    }

    public final void E(boolean z) {
        this.f = z;
    }

    public void F(c cVar) {
        this.o = cVar;
    }

    public void G(d dVar) {
        this.n = dVar;
    }

    public void H(g gVar) {
        this.p = gVar;
    }

    public void I(e eVar) {
        this.r = eVar;
    }

    public void J(f fVar) {
        this.q = fVar;
    }

    public void K(int i) {
        int i2 = this.e;
        if (i2 != -1 && i2 != i) {
            B();
        }
        if (this.e == i) {
            return;
        }
        this.e = i;
    }

    public void L(int i) {
        this.j = i;
    }

    @Override // dc.xu3.c
    public void a() {
        g gVar = this.p;
        if (gVar != null) {
            gVar.a();
        }
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.b.areAllItemsEnabled();
    }

    @Override // dc.ru3
    public void b(int i, int i2, View view, SlideAndDragListView.a aVar) {
        if (view == null) {
            return;
        }
        int positionForView = this.d.getPositionForView(view) - this.d.getHeaderViewsCount();
        if (!this.f || this.h == positionForView || !v(positionForView) || positionForView <= this.j || positionForView >= this.k) {
            return;
        }
        w(positionForView, aVar);
    }

    @Override // dc.xu3.e
    public void c(View view, int i) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.g(view, this.e, i);
        }
    }

    @Override // dc.ru3
    public boolean d(int i, int i2, View view) {
        int positionForView = this.d.getPositionForView(view) - this.d.getHeaderViewsCount();
        if (positionForView <= this.j || positionForView >= this.k) {
            E(false);
        } else {
            E(true);
            y(positionForView);
        }
        return this.f;
    }

    @Override // dc.xu3.d
    public void e(View view) {
        e eVar = this.r;
        if (eVar != null) {
            eVar.d(view, this.d.getPositionForView(view));
        }
    }

    @Override // dc.xu3.c
    public void f(View view) {
        int i = this.e;
        if (i != -1) {
            g gVar = this.p;
            if (gVar != null) {
                gVar.f(view, i);
            }
            this.e = -1;
            if (i == getCount() - 1) {
                this.d.requestLayout();
            }
        }
    }

    @Override // dc.ru3
    public void g(int i, int i2, SlideAndDragListView.a aVar) {
        E(false);
        t(aVar);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.b.getItemId(i);
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        return this.b.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        xu3 xu3Var;
        if (view == null) {
            xu3Var = new xu3(this.a, this.b.getView(i, view, viewGroup));
            yu3 yu3Var = this.c.get(this.b.getItemViewType(i));
            if (yu3Var == null) {
                throw new IllegalArgumentException("No menu matches any view types in ListView");
            }
            xu3Var.q(yu3Var.c(1), yu3Var.c(-1), yu3Var.d());
            p(yu3Var, xu3Var);
            xu3Var.p(this);
            xu3Var.r(this.d.getSelector());
        } else {
            xu3 xu3Var2 = (xu3) view;
            this.b.getView(i, xu3Var2.f(), viewGroup);
            xu3Var = xu3Var2;
        }
        u(xu3Var, i);
        return xu3Var;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        return this.b.getViewTypeCount();
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.b;
    }

    @Override // dc.xu3.e
    public void h(View view, int i) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.c(view, this.e, i);
        }
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        return this.b.hasStableIds();
    }

    @Override // com.yydcdut.sdlv.ItemBackGroundLayout.a
    public void i(int i, int i2, View view) {
        c cVar = this.o;
        if (cVar != null) {
            int iB = cVar.b(view, this.e, i, i2);
            if (iB == 1) {
                C(this);
            } else {
                if (iB != 2) {
                    return;
                }
                q();
            }
        }
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return this.b.isEnabled(i);
    }

    public void n() {
        ListAdapter listAdapter = this.b;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.s);
            this.m = true;
        }
    }

    public final void o() {
        int firstVisiblePosition = this.d.getFirstVisiblePosition();
        for (int i = 0; i < this.d.getChildCount(); i++) {
            View childAt = this.d.getChildAt(i);
            int i2 = firstVisiblePosition + i;
            if (i2 >= this.d.getHeaderViewsCount() && v(i2 - this.d.getHeaderViewsCount())) {
                Objects.requireNonNull(getItem(i2 - this.d.getHeaderViewsCount()), "The value of getItem(position) is NULL!");
                this.i.put(Integer.valueOf(getItem(i2 - this.d.getHeaderViewsCount()).hashCode()), Integer.valueOf(childAt.getTop()));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        f fVar = this.q;
        if (fVar != null) {
            fVar.h(absListView, i, i2, i3);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0) {
            B();
        }
        f fVar = this.q;
        if (fVar != null) {
            fVar.e(absListView, i);
        }
    }

    public final void p(yu3 yu3Var, xu3 xu3Var) {
        if (yu3Var.c(1) > 0) {
            for (int i = 0; i < yu3Var.a(1).size(); i++) {
                ItemBackGroundLayout itemBackGroundLayoutG = xu3Var.g();
                itemBackGroundLayoutG.a(yu3Var.a(1).get(i), i);
                itemBackGroundLayoutG.c(1);
                itemBackGroundLayoutG.d(this);
            }
        } else {
            xu3Var.g().setVisibility(8);
        }
        if (yu3Var.c(-1) <= 0) {
            xu3Var.h().setVisibility(8);
            return;
        }
        for (int i2 = 0; i2 < yu3Var.a(-1).size(); i2++) {
            ItemBackGroundLayout itemBackGroundLayoutH = xu3Var.h();
            itemBackGroundLayoutH.a(yu3Var.a(-1).get(i2), i2);
            itemBackGroundLayoutH.c(-1);
            itemBackGroundLayoutH.d(this);
        }
    }

    public void q() {
        int i = this.e;
        if (i != -1) {
            SlideListView slideListView = this.d;
            xu3 xu3Var = (xu3) slideListView.getChildAt(i - slideListView.getFirstVisiblePosition());
            if (xu3Var != null) {
                xu3Var.a(this);
            }
        }
    }

    public final void r() {
        if (this.i.isEmpty()) {
            return;
        }
        this.d.getViewTreeObserver().addOnPreDrawListener(new b());
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.b.registerDataSetObserver(dataSetObserver);
    }

    public int s() {
        return this.e;
    }

    public final void t(SlideAndDragListView.a aVar) {
        if (this.g != null) {
            if (v(this.h)) {
                if (aVar != null) {
                    aVar.b(this.h);
                }
                o();
                x();
            }
            this.g = null;
        }
    }

    public final void u(View view, int i) {
        if (this.g == null) {
            if (view == null || view.getVisibility() == 0) {
                return;
            }
            view.setVisibility(0);
            return;
        }
        if ((getItem(i) == this.g) && (view != null)) {
            view.setVisibility(4);
        } else if (view.getVisibility() != 0) {
            view.setVisibility(0);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.b.unregisterDataSetObserver(dataSetObserver);
    }

    public final boolean v(int i) {
        return i >= 0 && i < getCount();
    }

    public final void w(int i, SlideAndDragListView.a aVar) {
        if (this.g != null && v(this.h) && v(i)) {
            o();
            if (aVar != null) {
                aVar.a(this.h, i);
            }
            this.h = i;
            r();
            x();
        }
    }

    public final void x() {
        ListAdapter listAdapter = this.b;
        if (listAdapter == null || !(listAdapter instanceof BaseAdapter)) {
            return;
        }
        ((BaseAdapter) listAdapter).notifyDataSetChanged();
    }

    public final void y(int i) {
        if (v(i)) {
            this.g = getItem(i);
            this.h = i;
            w(i, null);
        }
    }

    public void z() {
        ListAdapter listAdapter = this.b;
        if (listAdapter == null || !this.m) {
            return;
        }
        listAdapter.unregisterDataSetObserver(this.s);
        this.m = false;
    }
}
