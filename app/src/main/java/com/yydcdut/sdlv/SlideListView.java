package com.yydcdut.sdlv;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.yydcdut.sdlv.SlideAndDragListView;
import dc.bv3;
import dc.su3;
import dc.tu3;
import dc.uu3;
import dc.xu3;
import dc.yu3;
import java.util.List;

/* loaded from: classes4.dex */
public class SlideListView extends DragListView implements bv3.d, bv3.c, bv3.g, bv3.f, AdapterView.OnItemLongClickListener, bv3.e {
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public SparseArray<yu3> k;
    public bv3 l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public SlideAndDragListView.e q;
    public SlideAndDragListView.d r;
    public tu3 s;
    public su3 t;
    public SlideAndDragListView.b u;
    public SlideAndDragListView.c v;
    public uu3 w;

    public class a implements su3 {
        public final /* synthetic */ AdapterView.OnItemClickListener a;

        public a(AdapterView.OnItemClickListener onItemClickListener) {
            this.a = onItemClickListener;
        }

        @Override // dc.su3
        public void a(View view, int i) {
            AdapterView.OnItemClickListener onItemClickListener = this.a;
            SlideListView slideListView = SlideListView.this;
            onItemClickListener.onItemClick(slideListView, view, i, slideListView.getItemIdAtPosition(i));
        }
    }

    public class b implements tu3 {
        public final /* synthetic */ AdapterView.OnItemLongClickListener a;

        public b(AdapterView.OnItemLongClickListener onItemLongClickListener) {
            this.a = onItemLongClickListener;
        }

        @Override // dc.tu3
        public void a(View view, int i) {
            AdapterView.OnItemLongClickListener onItemLongClickListener = this.a;
            SlideListView slideListView = SlideListView.this;
            onItemLongClickListener.onItemLongClick(slideListView, view, i, slideListView.getItemIdAtPosition(i));
        }
    }

    public class c implements uu3 {
        public final /* synthetic */ AbsListView.OnScrollListener a;

        public c(SlideListView slideListView, AbsListView.OnScrollListener onScrollListener) {
            this.a = onScrollListener;
        }

        @Override // dc.uu3
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            this.a.onScroll(absListView, i, i2, i3);
        }

        @Override // dc.uu3
        public void onScrollStateChanged(AbsListView absListView, int i) {
            this.a.onScrollStateChanged(absListView, i);
        }
    }

    public SlideListView(Context context) {
        this(context, null);
    }

    @Override // dc.bv3.g
    public void a() {
        this.h = true;
    }

    @Override // dc.bv3.c
    public int b(View view, int i, int i2, int i3) {
        SlideAndDragListView.d dVar = this.r;
        if (dVar != null) {
            return dVar.b(view, i, i2, i3);
        }
        return 0;
    }

    @Override // dc.bv3.d
    public void c(View view, int i, int i2) {
        SlideAndDragListView.e eVar = this.q;
        if (eVar == null || !(view instanceof xu3)) {
            return;
        }
        eVar.b(((xu3) view).f(), this, i, i2);
    }

    @Override // dc.bv3.e
    public void d(View view, int i) {
        SlideAndDragListView.c cVar = this.v;
        if (cVar != null) {
            cVar.a(view, i);
        }
    }

    @Override // dc.bv3.f
    public void e(AbsListView absListView, int i) {
        if (i == 0) {
            this.f = true;
            this.g = false;
        } else {
            this.f = false;
            this.g = true;
        }
        uu3 uu3Var = this.w;
        if (uu3Var != null) {
            uu3Var.onScrollStateChanged(absListView, i);
        }
    }

    @Override // dc.bv3.g
    public void f(View view, int i) {
        this.h = false;
        SlideAndDragListView.b bVar = this.u;
        if (bVar == null || !(view instanceof xu3)) {
            return;
        }
        bVar.a(((xu3) view).f(), i);
    }

    @Override // dc.bv3.d
    public void g(View view, int i, int i2) {
        SlideAndDragListView.e eVar = this.q;
        if (eVar == null || !(view instanceof xu3)) {
            return;
        }
        eVar.a(((xu3) view).f(), this, i, i2);
    }

    public bv3 getWrapperAdapter() {
        return this.l;
    }

    @Override // dc.bv3.f
    public void h(AbsListView absListView, int i, int i2, int i3) {
        this.p = i + i2 >= i3;
        uu3 uu3Var = this.w;
        if (uu3Var != null) {
            uu3Var.onScroll(absListView, i, i2, i3);
        }
    }

    public final boolean o(MotionEvent motionEvent) {
        return (motionEvent.getX() - ((float) this.i) > ((float) this.m) || motionEvent.getX() - ((float) this.i) < ((float) (-this.m))) && motionEvent.getY() - ((float) this.j) < ((float) this.m) && motionEvent.getY() - ((float) this.j) > ((float) (-this.m));
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bv3 bv3Var = this.l;
        if (bv3Var != null) {
            bv3Var.n();
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bv3 bv3Var = this.l;
        if (bv3Var != null) {
            bv3Var.z();
        }
    }

    @Override // com.yydcdut.sdlv.DragListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (m()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.i = (int) motionEvent.getX();
            this.j = (int) motionEvent.getY();
            this.e = 0;
            xu3 xu3VarP = p((int) motionEvent.getX(), (int) motionEvent.getY());
            if (xu3VarP != null) {
                this.n = xu3VarP.f().getLeft();
            } else {
                this.n = 0;
            }
        } else if (action == 2 && o(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (this.s != null && (childAt instanceof xu3)) {
            xu3 xu3Var = (xu3) childAt;
            if (xu3Var.f().getLeft() == 0) {
                this.e = 3;
                this.l.B();
                this.s.a(xu3Var.f(), i);
            }
        }
        int i2 = this.e;
        if (i2 != 3 && i2 != 0) {
            return false;
        }
        v(i);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0053  */
    @Override // com.yydcdut.sdlv.DragListView, android.widget.AbsListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yydcdut.sdlv.SlideListView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final xu3 p(int i, int i2) {
        int iPointToPosition = pointToPosition(i, i2);
        if (iPointToPosition == -1) {
            return null;
        }
        View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
        if (childAt instanceof xu3) {
            return (xu3) childAt;
        }
        return null;
    }

    public final boolean q(MotionEvent motionEvent) {
        return motionEvent.getX() - ((float) this.i) < ((float) (-this.m));
    }

    public final boolean r(MotionEvent motionEvent) {
        return motionEvent.getX() - ((float) this.i) > ((float) this.m);
    }

    public final void s() {
        this.e = -1;
        this.n = 0;
        this.o = false;
    }

    public void setMenu(yu3 yu3Var) {
        SparseArray<yu3> sparseArray = this.k;
        if (sparseArray != null) {
            sparseArray.clear();
        } else {
            this.k = new SparseArray<>();
        }
        this.k.put(yu3Var.b(), yu3Var);
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.t = null;
        } else {
            this.t = new a(onItemClickListener);
        }
    }

    public void setOnItemDeleteListener(SlideAndDragListView.b bVar) {
        this.u = bVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            this.s = null;
        } else {
            this.s = new b(onItemLongClickListener);
        }
    }

    public void setOnItemScrollBackListener(SlideAndDragListView.c cVar) {
        this.v = cVar;
    }

    public void setOnMenuItemClickListener(SlideAndDragListView.d dVar) {
        this.r = dVar;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        if (onScrollListener == null) {
            this.w = null;
        } else {
            this.w = new c(this, onScrollListener);
        }
    }

    public void setOnSlideListener(SlideAndDragListView.e eVar) {
        this.q = eVar;
    }

    public void setOnSuperScrollListener(AbsListView.OnScrollListener onScrollListener) {
        super.setOnScrollListener(onScrollListener);
    }

    public final int t(int i, float f) {
        if (this.l.s() != i) {
            if (this.l.s() == -1) {
                return 0;
            }
            this.l.B();
            return 2;
        }
        int iA = this.l.A(f);
        int i2 = 1;
        if (iA != 1) {
            i2 = 3;
            if (iA != 3) {
                return 0;
            }
        }
        return i2;
    }

    public final boolean u(int i) {
        if (this.l.s() == i) {
            return false;
        }
        if (this.l.s() != -1) {
            this.l.B();
        }
        return true;
    }

    public boolean v(int i) {
        boolean zU = u(i);
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (zU && (childAt instanceof xu3)) {
            setDragPosition(i);
        }
        return zU && (childAt instanceof xu3);
    }

    public SlideListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        SparseArray<yu3> sparseArray = this.k;
        if (sparseArray == null || sparseArray.size() == 0) {
            throw new IllegalArgumentException("Set Menu first!");
        }
        bv3 bv3Var = new bv3(getContext(), this, listAdapter, this.k);
        this.l = bv3Var;
        bv3Var.G(this);
        this.l.F(this);
        this.l.H(this);
        this.l.J(this);
        this.l.I(this);
        super.setAdapter((ListAdapter) this.l);
    }

    public SlideListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = -1;
        this.f = true;
        this.g = false;
        this.h = false;
        this.m = 25;
        this.n = 0;
        this.o = false;
        this.p = false;
        this.m = ViewConfiguration.get(context).getScaledTouchSlop();
        super.setOnItemLongClickListener(this);
    }

    public void setMenu(List<yu3> list) {
        SparseArray<yu3> sparseArray = this.k;
        if (sparseArray != null) {
            sparseArray.clear();
        } else {
            this.k = new SparseArray<>();
        }
        for (yu3 yu3Var : list) {
            this.k.put(yu3Var.b(), yu3Var);
        }
    }

    public void setMenu(yu3... yu3VarArr) {
        SparseArray<yu3> sparseArray = this.k;
        if (sparseArray != null) {
            sparseArray.clear();
        } else {
            this.k = new SparseArray<>();
        }
        for (yu3 yu3Var : yu3VarArr) {
            this.k.put(yu3Var.b(), yu3Var);
        }
    }
}
