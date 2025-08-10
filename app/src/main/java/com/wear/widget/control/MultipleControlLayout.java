package com.wear.widget.control;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.ui.home.remote.RemoteControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.control.TouchControlVerticalBarView;
import com.wear.widget.control.TouchControlView;
import dc.ah4;
import dc.ce3;
import dc.rq1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class MultipleControlLayout extends RelativeLayout {
    public LayoutInflater a;
    public TouchControlView b;
    public LinearLayout c;
    public TouchControlView d;
    public LinearLayout e;
    public TouchControlView f;
    public TextView g;
    public TouchControlVerticalBarView h;
    public c i;
    public c j;
    public c k;
    public int l;
    public MyApplication m;
    public e n;
    public boolean o;
    public View p;

    public class a implements TouchControlVerticalBarView.a {
        public a() {
        }

        @Override // com.wear.widget.control.TouchControlVerticalBarView.a
        public void a(int i) {
        }

        @Override // com.wear.widget.control.TouchControlVerticalBarView.a
        public void b(int i) {
            MultipleControlLayout.this.p(i);
        }

        @Override // com.wear.widget.control.TouchControlVerticalBarView.a
        public void c() {
            e eVar = MultipleControlLayout.this.n;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.Base.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.Right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.Bottom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public class c {
        public TouchControlView a;
        public CurveLineTimeView b;
        public boolean c = true;
        public boolean d = false;
        public boolean e = false;

        public class a implements TouchControlView.f {
            public a() {
            }

            @Override // com.wear.widget.control.TouchControlView.f
            public void a(List<Toy> list, String str) {
            }

            @Override // com.wear.widget.control.TouchControlView.f
            public void b(boolean z, String str, String str2, String str3, boolean z2, long j) {
                TouchControlView touchControlView;
                c cVar = c.this;
                cVar.d = z2;
                if (cVar.c) {
                    if (MultipleControlLayout.this.o) {
                        if (!z && (touchControlView = cVar.a) != null) {
                            touchControlView.G(str, str2);
                        } else if (!WearUtils.e1(str2) && str2.indexOf(String.valueOf(TouchControlView.Q)) > 0) {
                            rq1.d.i();
                        }
                    }
                    c cVar2 = c.this;
                    e eVar = MultipleControlLayout.this.n;
                    if (eVar != null) {
                        TouchControlView touchControlView2 = cVar2.a;
                        eVar.a(touchControlView2 == null ? "" : touchControlView2.getControlDeviceId(), z, str, str2, str3, MultipleControlLayout.this.h(), j);
                    }
                }
            }
        }

        public c(TouchControlView touchControlView, CurveLineTimeView curveLineTimeView) {
            this.a = touchControlView;
            this.b = curveLineTimeView;
            a();
            f();
        }

        public final void a() {
            e(this.c);
            this.a.setTapTipVisibility(8);
            this.a.setTapTimeVisibility(8);
            this.a.setTapNameVisibility(8, null);
            this.a.setCurveLineTvTimeVisibility(8);
            MultipleControlLayout.this.h.e(this.a);
        }

        public TouchControlView b() {
            return this.a;
        }

        public void c() {
            if (MultipleControlLayout.this.l == 2) {
                h(60, 60, 30, 60);
            } else {
                h(80, 80, 40, 80);
            }
        }

        public void d(boolean z, Toy toy, boolean z2) {
            if (toy != null) {
                int length = Toy.getToyFunction(toy.getType()).split(",").length;
            }
            if (MultipleControlLayout.this.l == 2) {
                CurveLineTimeView curveLineTimeView = this.b;
                if (curveLineTimeView != null) {
                    if (toy != null) {
                        curveLineTimeView.setToyName(toy.getName());
                    } else {
                        curveLineTimeView.setToyName("");
                    }
                }
                this.a.setTapNameVisibility(0, null);
                if (toy != null) {
                    this.a.setTapNameString(toy.getName());
                } else {
                    this.a.setTapNameString("");
                }
                if (z) {
                    this.a.setFingerLabelImageVisibility(8);
                }
                z2 = true;
            }
            if (!z2) {
                this.a.getFicView().t(ce3.a(MultipleControlLayout.this.m, 80.0f));
                this.a.getTapName().setText(ah4.e(R.string.toy_control_tip_max_level));
                this.a.invalidate();
                return;
            }
            this.a.getFicView().t(ce3.a(MultipleControlLayout.this.m, 60.0f));
            ImageView fingerLabelImage = this.a.getFingerLabelImage();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fingerLabelImage.getLayoutParams();
            if (this.a.getTapName().getVisibility() == 0 && this.a.getTapName().getText().toString().equals(ah4.e(R.string.toy_control_tip_max_level))) {
                layoutParams.setMargins(0, 0, 0, ce3.a(MultipleControlLayout.this.m, 20.0f));
            } else {
                layoutParams.setMargins(0, ce3.a(MultipleControlLayout.this.m, 20.0f), 0, ce3.a(MultipleControlLayout.this.m, 20.0f));
            }
            fingerLabelImage.setLayoutParams(layoutParams);
            this.a.invalidate();
        }

        public void e(boolean z) {
            this.c = z;
            TouchControlView touchControlView = this.a;
            if (touchControlView != null) {
                try {
                    if (z) {
                        touchControlView.setWidget(MultipleControlLayout.this.m, this.b);
                    } else {
                        touchControlView.P();
                    }
                } catch (Exception unused) {
                }
            }
        }

        public final void f() {
            this.a.setListener(new a());
        }

        public void g() {
            TouchControlView touchControlView = this.a;
            if (touchControlView != null) {
                touchControlView.P();
            }
            this.a = null;
        }

        public void h(Integer num, int i, int i2, Integer num2) {
            this.a.Q(num, i, i2, num2);
        }

        public void i(int i) {
            TouchControlView touchControlView = this.a;
            if (touchControlView != null) {
                if (i != 3) {
                    touchControlView.setTapNameGravity(17);
                    if (this.e) {
                        this.a.getTapName().setVisibility(0);
                        this.a.getTop_area_line().setVisibility(0);
                        this.a.getTop_empty_layout().setVisibility(0);
                        return;
                    }
                    return;
                }
                touchControlView.setTapNameGravity(3);
                this.a.getTop_area_line().setVisibility(8);
                this.a.getTop_empty_layout().setVisibility(8);
                if (this.a.getTapName().getVisibility() == 0 && this.a.getTapName().getText().toString().equals(ah4.e(R.string.toy_control_tip_max_level))) {
                    this.e = true;
                    this.a.getTapName().setVisibility(8);
                }
            }
        }

        public void j() {
            TouchControlView touchControlView = this.a;
            if (touchControlView != null) {
                touchControlView.P();
            }
        }
    }

    public enum d {
        Base(1),
        Right(2),
        Bottom(17);

        private int index;

        d(int i) {
            this.index = i;
        }

        public int getIndex() {
            return this.index;
        }
    }

    public interface e {
        void a(String str, boolean z, String str2, String str3, String str4, boolean z2, long j);

        void b();
    }

    public MultipleControlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 0;
        this.o = true;
        e(context, attributeSet);
    }

    public boolean d() {
        ArrayList<Toy> arrayListP = this.m.G().P();
        if (arrayListP == null || arrayListP.size() <= 0) {
            return false;
        }
        Iterator<Toy> it = arrayListP.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next().getAddress();
        }
        if (arrayListP.size() != getBindToySize()) {
            return false;
        }
        if (getBindToySize() == 1) {
            c cVar = this.i;
            return cVar != null && str.equals(cVar.a.getFingerToy().getAddress());
        }
        if (getBindToySize() != 2 || this.i == null || this.j == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.i.a.getFingerToy().getAddress());
        sb.append(this.j.a.getFingerToy().getAddress());
        return str.equals(sb.toString());
    }

    public final void e(Context context, AttributeSet attributeSet) {
        List<String> list;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a = layoutInflater;
        View viewInflate = layoutInflater.inflate(R.layout.layout_multi_toy_control, (ViewGroup) null);
        this.p = viewInflate;
        this.b = (TouchControlView) viewInflate.findViewById(R.id.touchView);
        this.c = (LinearLayout) this.p.findViewById(R.id.touchView_right_layout);
        this.d = (TouchControlView) this.p.findViewById(R.id.touchView_right);
        this.e = (LinearLayout) this.p.findViewById(R.id.touchView_bottom_layout);
        this.f = (TouchControlView) this.p.findViewById(R.id.touchView_bottom);
        this.g = (TextView) this.p.findViewById(R.id.top_timer);
        TouchControlVerticalBarView touchControlVerticalBarView = (TouchControlVerticalBarView) this.p.findViewById(R.id.touchViewControl);
        this.h = touchControlVerticalBarView;
        touchControlVerticalBarView.setListener(new a());
        addView(this.p);
        if (RemoteControl.j().i() != 1 || (list = RemoteControl.l) == null) {
            return;
        }
        this.b.setLoopDatas(list);
    }

    public void f() {
        this.h.setControlType(RemoteControl.j().i());
    }

    public void g(boolean z) {
        this.h.f(z);
        o(0);
        q();
    }

    public int getBindToySize() {
        return this.l;
    }

    public int getControlType() {
        return this.b.getControlType();
    }

    public List<String> getLoopDatas() {
        return this.b.getLoopDatas();
    }

    public TextView getTopTimer() {
        return this.g;
    }

    public final boolean h() {
        c cVar = this.i;
        if (cVar != null && cVar.d) {
            return true;
        }
        c cVar2 = this.j;
        if (cVar2 != null && cVar2.d) {
            return true;
        }
        c cVar3 = this.k;
        return cVar3 != null && cVar3.d;
    }

    public void i() {
        this.h.c();
    }

    public void j() {
        this.b.B();
        this.d.B();
        this.f.B();
    }

    public void k(d dVar, CurveLineTimeView curveLineTimeView, Toy toy, boolean z, boolean z2) throws Resources.NotFoundException {
        int i = b.a[dVar.ordinal()];
        if (i == 1) {
            c cVar = new c(this.b, curveLineTimeView);
            this.i = cVar;
            r(false, cVar, toy, z, z2);
        } else if (i == 2) {
            c cVar2 = new c(this.d, curveLineTimeView);
            this.j = cVar2;
            r(true, cVar2, toy, z, z2);
        } else {
            if (i != 3) {
                return;
            }
            c cVar3 = new c(this.f, curveLineTimeView);
            this.k = cVar3;
            r(true, cVar3, toy, z, z2);
        }
    }

    public void l() {
        if (RemoteControl.j().i() == 3 || RemoteControl.j().i() == 2) {
            return;
        }
        this.b.C();
        this.d.C();
        this.f.C();
    }

    public void m() {
        this.b.C();
        this.d.C();
        this.f.C();
    }

    public void n() {
        c cVar = this.i;
        if (cVar != null) {
            cVar.c();
        }
        c cVar2 = this.j;
        if (cVar2 != null) {
            cVar2.c();
        }
        c cVar3 = this.k;
        if (cVar3 != null) {
            cVar3.c();
        }
    }

    public void o(int i) {
        this.b.D(i);
        this.d.D(i);
        this.f.D(i);
    }

    public void p(int i) {
        TouchControlView touchControlView;
        TouchControlView touchControlView2;
        TouchControlView touchControlView3;
        TouchControlView touchControlView4;
        c cVar = this.j;
        if (cVar != null && (touchControlView4 = cVar.a) != null) {
            touchControlView4.setVisibility(8);
        }
        c cVar2 = this.k;
        if (cVar2 != null && (touchControlView3 = cVar2.a) != null) {
            touchControlView3.setVisibility(8);
        }
        if (this.l == 1) {
            this.c.setVisibility(8);
            this.e.setVisibility(8);
        }
        if (i == 3) {
            if (this.l == 2) {
                this.c.setVisibility(8);
                this.e.setVisibility(0);
                c cVar3 = this.k;
                if (cVar3 != null && (touchControlView2 = cVar3.a) != null) {
                    touchControlView2.setVisibility(0);
                }
                c cVar4 = this.j;
                if (cVar4 != null) {
                    cVar4.e(false);
                }
                c cVar5 = this.k;
                if (cVar5 != null) {
                    cVar5.e(true);
                }
            }
        } else if (this.l == 2) {
            this.c.setVisibility(0);
            c cVar6 = this.j;
            if (cVar6 != null && (touchControlView = cVar6.a) != null) {
                touchControlView.setVisibility(0);
            }
            this.e.setVisibility(8);
            c cVar7 = this.j;
            if (cVar7 != null) {
                cVar7.e(true);
            }
            c cVar8 = this.k;
            if (cVar8 != null) {
                cVar8.e(false);
            }
        }
        c cVar9 = this.i;
        if (cVar9 != null) {
            cVar9.i(i);
        }
        c cVar10 = this.j;
        if (cVar10 != null) {
            cVar10.i(i);
        }
        c cVar11 = this.k;
        if (cVar11 != null) {
            cVar11.i(i);
        }
    }

    public void q() {
        this.b.E();
        this.d.E();
        this.f.E();
    }

    public final void r(boolean z, c cVar, Toy toy, boolean z2, boolean z3) throws Resources.NotFoundException {
        if (toy == null) {
            cVar.e(false);
            return;
        }
        cVar.e(true);
        if (z2) {
            cVar.b().setFingerAndNoStart(true, toy);
        } else {
            cVar.b().O(true, toy);
        }
        cVar.d(z, toy, z3);
    }

    public void s() {
        TouchControlView touchControlView;
        TouchControlView touchControlView2;
        TouchControlView touchControlView3;
        c cVar = this.j;
        if (cVar != null && (touchControlView3 = cVar.a) != null) {
            touchControlView3.setVisibility(8);
        }
        c cVar2 = this.k;
        if (cVar2 != null && (touchControlView2 = cVar2.a) != null) {
            touchControlView2.setVisibility(8);
        }
        c cVar3 = this.i;
        if (cVar3 != null && (touchControlView = cVar3.a) != null && touchControlView.getVisibility() == 0) {
            this.i.a.N();
        }
        c cVar4 = this.j;
        if (cVar4 != null && cVar4.a != null && this.c.getVisibility() == 0 && getBindToySize() == 2) {
            this.j.a.setVisibility(0);
            this.j.a.N();
        }
        c cVar5 = this.k;
        if (cVar5 == null || cVar5.a == null || this.e.getVisibility() != 0 || getBindToySize() != 2) {
            return;
        }
        this.k.a.setVisibility(0);
        this.k.a.N();
    }

    public void setAllProgress(int i) {
        if (RemoteControl.j().i() != 3 && RemoteControl.j().i() != 2) {
            this.h.b();
        }
        this.b.A(i);
        this.d.A(i);
        this.f.A(i);
    }

    public void setApplication(MyApplication myApplication) {
        this.m = myApplication;
    }

    public void setBindToySize(int i) {
        this.h.a();
        this.l = i;
    }

    public void setCallBack(e eVar, boolean z) {
        this.n = eVar;
        this.o = z;
    }

    public void setControlManualType() {
        this.h.d();
    }

    public void setEndControlVisibility(int i) {
        this.h.setEndControlVisibility(i);
    }

    public void setTapNameVisibility(int i, String str) {
        setTapNameVisibility(d.Base, i, str);
        setTapNameVisibility(d.Right, i, str);
        setTapNameVisibility(d.Bottom, i, str);
    }

    public void setTapTimeVisibility(int i) {
        setTapTimeVisibility(d.Base, i);
        setTapTimeVisibility(d.Right, i);
        setTapTimeVisibility(d.Bottom, i);
    }

    public void setTapTipVisibility(int i) {
        setTapTipVisibility(d.Base, i);
        setTapTipVisibility(d.Right, i);
        setTapTipVisibility(d.Bottom, i);
    }

    public void setTopTimerTextView(int i) {
        this.g.setVisibility(i);
    }

    public void t() {
        c cVar = this.i;
        if (cVar != null) {
            cVar.g();
        }
        c cVar2 = this.j;
        if (cVar2 != null) {
            cVar2.g();
        }
        c cVar3 = this.k;
        if (cVar3 != null) {
            cVar3.g();
        }
    }

    public void u() {
        c cVar = this.i;
        if (cVar != null) {
            cVar.j();
        }
        c cVar2 = this.j;
        if (cVar2 != null) {
            cVar2.j();
        }
        c cVar3 = this.k;
        if (cVar3 != null) {
            cVar3.j();
        }
    }

    public void setTapNameVisibility(d dVar, int i, String str) {
        int i2 = b.a[dVar.ordinal()];
        if (i2 == 1) {
            this.b.setTapNameVisibility(i, str);
        } else if (i2 == 2) {
            this.d.setTapNameVisibility(i, str);
        } else {
            if (i2 != 3) {
                return;
            }
            this.f.setTapNameVisibility(i, str);
        }
    }

    public void setTapTimeVisibility(d dVar, int i) {
        int i2 = b.a[dVar.ordinal()];
        if (i2 == 1) {
            this.b.setTapTimeVisibility(i);
        } else if (i2 == 2) {
            this.d.setTapTimeVisibility(i);
        } else {
            if (i2 != 3) {
                return;
            }
            this.f.setTapTimeVisibility(i);
        }
    }

    public void setTapTipVisibility(d dVar, int i) {
        int i2 = b.a[dVar.ordinal()];
        if (i2 == 1) {
            this.b.setTapTipVisibility(i);
        } else if (i2 == 2) {
            this.d.setTapTipVisibility(i);
        } else {
            if (i2 != 3) {
                return;
            }
            this.f.setTapTipVisibility(i);
        }
    }
}
