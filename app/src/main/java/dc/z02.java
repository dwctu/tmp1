package dc;

import android.graphics.Typeface;
import android.view.View;
import com.bigkoo.pickerview.lib.WheelView;
import com.lovense.wear.R;
import com.wear.main.closeRange.alarm.DxWheelView;
import java.util.List;

/* compiled from: DxWheelOptions.java */
/* loaded from: classes3.dex */
public class z02<T> {
    public DxWheelView a;
    public DxWheelView b;
    public DxWheelView c;
    public List<T> d;
    public List<List<T>> e;
    public List<T> f;
    public List<List<List<T>>> g;
    public List<T> h;
    public boolean i;
    public df j;
    public df k;
    public df l;
    public int m;
    public int n;
    public int o;
    public WheelView.b p;
    public float q = 1.6f;
    public y02 r = null;

    /* compiled from: DxWheelOptions.java */
    public class a implements df {
        public a() {
        }

        @Override // dc.df
        public void a(int i) {
            int currentItem;
            if (z02.this.e != null) {
                currentItem = z02.this.b.getCurrentItem();
                if (currentItem >= ((List) z02.this.e.get(i)).size() - 1) {
                    currentItem = ((List) z02.this.e.get(i)).size() - 1;
                }
                z02.this.b.setAdapter(new te((List) z02.this.e.get(i)));
                z02.this.b.setCurrentItem(currentItem);
            } else {
                currentItem = 0;
            }
            if (z02.this.g != null) {
                z02.this.k.a(currentItem);
            }
            if (z02.this.r != null) {
                z02.this.r.B(1);
            }
        }
    }

    /* compiled from: DxWheelOptions.java */
    public class b implements df {
        public b() {
        }

        @Override // dc.df
        public void a(int i) {
            if (z02.this.g != null) {
                int currentItem = z02.this.a.getCurrentItem();
                if (currentItem >= z02.this.g.size() - 1) {
                    currentItem = z02.this.g.size() - 1;
                }
                if (i >= ((List) z02.this.e.get(currentItem)).size() - 1) {
                    i = ((List) z02.this.e.get(currentItem)).size() - 1;
                }
                int currentItem2 = z02.this.c.getCurrentItem();
                if (currentItem2 >= ((List) ((List) z02.this.g.get(currentItem)).get(i)).size() - 1) {
                    currentItem2 = ((List) ((List) z02.this.g.get(currentItem)).get(i)).size() - 1;
                }
                z02.this.c.setAdapter(new te((List) ((List) z02.this.g.get(z02.this.a.getCurrentItem())).get(i)));
                z02.this.c.setCurrentItem(currentItem2);
            }
            if (z02.this.r != null) {
                z02.this.r.B(2);
            }
        }
    }

    /* compiled from: DxWheelOptions.java */
    public class c implements df {
        public c() {
        }

        @Override // dc.df
        public void a(int i) {
            if (z02.this.r != null) {
                z02.this.r.B(3);
            }
        }
    }

    /* compiled from: DxWheelOptions.java */
    public class d implements df {
        public d() {
        }

        @Override // dc.df
        public void a(int i) {
            int currentItem;
            if (z02.this.e != null) {
                currentItem = z02.this.b.getCurrentItem();
                if (currentItem >= ((List) z02.this.e.get(i)).size() - 1) {
                    currentItem = ((List) z02.this.e.get(i)).size() - 1;
                }
                z02.this.b.setAdapter(new te((List) z02.this.e.get(i)));
                z02.this.b.setCurrentItem(currentItem);
            } else {
                currentItem = 0;
            }
            if (z02.this.g != null) {
                z02.this.k.a(currentItem);
            }
            if (z02.this.r != null) {
                z02.this.r.B(1);
            }
        }
    }

    /* compiled from: DxWheelOptions.java */
    public class e implements df {
        public e() {
        }

        @Override // dc.df
        public void a(int i) {
            if (z02.this.g != null) {
                int currentItem = z02.this.a.getCurrentItem();
                if (currentItem >= z02.this.g.size() - 1) {
                    currentItem = z02.this.g.size() - 1;
                }
                if (i >= ((List) z02.this.e.get(currentItem)).size() - 1) {
                    i = ((List) z02.this.e.get(currentItem)).size() - 1;
                }
                int currentItem2 = z02.this.c.getCurrentItem();
                if (currentItem2 >= ((List) ((List) z02.this.g.get(currentItem)).get(i)).size() - 1) {
                    currentItem2 = ((List) ((List) z02.this.g.get(currentItem)).get(i)).size() - 1;
                }
                z02.this.c.setAdapter(new te((List) ((List) z02.this.g.get(z02.this.a.getCurrentItem())).get(i)));
                z02.this.c.setCurrentItem(currentItem2);
            }
            if (z02.this.r != null) {
                z02.this.r.B(2);
            }
        }
    }

    /* compiled from: DxWheelOptions.java */
    public class f implements df {
        public f() {
        }

        @Override // dc.df
        public void a(int i) {
            if (z02.this.r != null) {
                z02.this.r.B(3);
            }
        }
    }

    public z02(View view, Boolean bool) {
        this.i = bool.booleanValue();
        this.a = (DxWheelView) view.findViewById(R.id.options1);
        this.b = (DxWheelView) view.findViewById(R.id.options2);
        this.c = (DxWheelView) view.findViewById(R.id.options3);
    }

    public void A(int i) {
        float f2 = i;
        this.a.setTextSize(f2);
        this.b.setTextSize(f2);
        this.c.setTextSize(f2);
    }

    public void B(Typeface typeface) {
        this.a.setTypeface(typeface);
        this.b.setTypeface(typeface);
        this.c.setTypeface(typeface);
    }

    public int[] h() {
        int[] iArr = new int[3];
        iArr[0] = this.a.getCurrentItem();
        List<List<T>> list = this.e;
        if (list == null || list.size() <= 0) {
            iArr[1] = this.b.getCurrentItem();
        } else {
            iArr[1] = this.b.getCurrentItem() > this.e.get(iArr[0]).size() - 1 ? 0 : this.b.getCurrentItem();
        }
        List<List<List<T>>> list2 = this.g;
        if (list2 == null || list2.size() <= 0) {
            iArr[2] = this.c.getCurrentItem();
        } else {
            iArr[2] = this.c.getCurrentItem() <= this.g.get(iArr[0]).get(iArr[1]).size() - 1 ? this.c.getCurrentItem() : 0;
        }
        return iArr;
    }

    public void i(Boolean bool) {
        this.a.g(bool);
        this.b.g(bool);
        this.c.g(bool);
    }

    public final void j(int i, int i2, int i3) {
        List<List<T>> list = this.e;
        if (list != null) {
            this.b.setAdapter(new te(list.get(i)));
            this.b.setCurrentItem(i2);
        }
        List<List<List<T>>> list2 = this.g;
        if (list2 != null) {
            this.c.setAdapter(new te(list2.get(i).get(i2)));
            this.c.setCurrentItem(i3);
        }
    }

    public void k(int i, int i2, int i3) {
        if (this.i) {
            j(i, i2, i3);
        }
        this.a.setCurrentItem(i);
        this.b.setCurrentItem(i2);
        this.c.setCurrentItem(i3);
    }

    public void l(boolean z, boolean z2, boolean z3) {
        this.a.setCyclic(z);
        this.b.setCyclic(z2);
        this.c.setCyclic(z3);
    }

    public final void m() {
        this.a.setDividerColor(this.o);
        this.b.setDividerColor(this.o);
        this.c.setDividerColor(this.o);
    }

    public void n(int i) {
        this.o = i;
        m();
    }

    public final void o() {
        this.a.setDividerType(this.p);
        this.b.setDividerType(this.p);
        this.c.setDividerType(this.p);
    }

    public void p(WheelView.b bVar) {
        this.p = bVar;
        o();
    }

    public void q(String str, String str2, String str3) {
        if (str != null) {
            this.a.setLabel(str);
        }
        if (str2 != null) {
            this.b.setLabel(str2);
        }
        if (str3 != null) {
            this.c.setLabel(str3);
        }
    }

    public final void r() {
        this.a.setLineSpacingMultiplier(this.q);
        this.b.setLineSpacingMultiplier(this.q);
        this.c.setLineSpacingMultiplier(this.q);
    }

    public void s(float f2) {
        this.q = f2;
        r();
    }

    public void t(List<T> list, List<T> list2, List<T> list3) {
        this.d = list;
        this.f = list2;
        this.h = list3;
        int i = list3 == null ? 8 : 4;
        if (list2 == null) {
            i = 12;
        }
        this.a.setAdapter(new te(list, i));
        this.a.setCurrentItem(0);
        List<T> list4 = this.f;
        if (list4 != null) {
            this.b.setAdapter(new te(list4));
        }
        this.b.setCurrentItem(this.a.getCurrentItem());
        List<T> list5 = this.h;
        if (list5 != null) {
            this.c.setAdapter(new te(list5));
        }
        DxWheelView dxWheelView = this.c;
        dxWheelView.setCurrentItem(dxWheelView.getCurrentItem());
        this.a.setIsOptions(true);
        this.b.setIsOptions(true);
        this.c.setIsOptions(true);
        if (this.f == null) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
        }
        this.c.setVisibility(8);
        y02 y02Var = this.r;
        if (y02Var != null) {
            if (y02Var.n0) {
                this.c.setVisibility(8);
            } else {
                this.c.setVisibility(0);
            }
        }
        d dVar = new d();
        this.j = dVar;
        this.k = new e();
        this.l = new f();
        if (list2 != null && this.i) {
            this.a.setOnItemSelectedListener(dVar);
        }
        if (list3 != null && this.i) {
            this.b.setOnItemSelectedListener(this.k);
        }
        y02 y02Var2 = this.r;
        if (y02Var2 == null || y02Var2.n0) {
            return;
        }
        this.c.setOnItemSelectedListener(this.l);
    }

    public void u(y02 y02Var) {
        this.r = y02Var;
        this.a.setOptionsPickerView(y02Var);
        this.b.setOptionsPickerView(this.r);
        this.c.setOptionsPickerView(this.r);
        if (y02Var == null || y02Var.o0) {
            return;
        }
        this.a.setCanEnable(false);
        this.b.setCanEnable(false);
        this.c.setCanEnable(false);
    }

    public void v(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.d = list;
        this.e = list2;
        this.g = list3;
        int i = list3 == null ? 8 : 4;
        if (list2 == null) {
            i = 12;
        }
        this.a.setAdapter(new te(list, i));
        this.a.setCurrentItem(0);
        List<List<T>> list4 = this.e;
        if (list4 != null) {
            this.b.setAdapter(new te(list4.get(0)));
        }
        this.b.setCurrentItem(this.a.getCurrentItem());
        List<List<List<T>>> list5 = this.g;
        if (list5 != null) {
            this.c.setAdapter(new te(list5.get(0).get(0)));
        }
        DxWheelView dxWheelView = this.c;
        dxWheelView.setCurrentItem(dxWheelView.getCurrentItem());
        this.a.setIsOptions(true);
        this.b.setIsOptions(true);
        this.c.setIsOptions(true);
        if (this.e == null) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
        }
        this.c.setVisibility(8);
        y02 y02Var = this.r;
        if (y02Var != null) {
            if (y02Var.n0) {
                this.c.setVisibility(8);
            } else {
                this.c.setVisibility(0);
            }
        }
        a aVar = new a();
        this.j = aVar;
        this.k = new b();
        this.l = new c();
        if (list2 != null && this.i) {
            this.a.setOnItemSelectedListener(aVar);
        }
        if (list3 != null && this.i) {
            this.b.setOnItemSelectedListener(this.k);
        }
        y02 y02Var2 = this.r;
        if (y02Var2 == null || y02Var2.n0) {
            return;
        }
        this.c.setOnItemSelectedListener(this.l);
    }

    public final void w() {
        this.a.setTextColorCenter(this.n);
        this.b.setTextColorCenter(this.n);
        this.c.setTextColorCenter(this.n);
    }

    public void x(int i) {
        this.n = i;
        w();
    }

    public final void y() {
        this.a.setTextColorOut(this.m);
        this.b.setTextColorOut(this.m);
        this.c.setTextColorOut(this.m);
    }

    public void z(int i) {
        this.m = i;
        y();
    }
}
