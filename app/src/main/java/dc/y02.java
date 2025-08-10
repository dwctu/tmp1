package dc;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.lib.WheelView;
import com.lovense.wear.R;
import java.util.List;

/* compiled from: DxOptionsPickerView.java */
/* loaded from: classes3.dex */
public class y02<T> extends gf implements View.OnClickListener {
    public Button A;
    public TextView B;
    public RelativeLayout C;
    public b D;
    public String E;
    public String F;
    public String G;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public float W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public boolean a0;
    public String b0;
    public String c0;
    public String d0;
    public boolean e0;
    public boolean f0;
    public boolean g0;
    public Typeface h0;
    public int i0;
    public int j0;
    public int k0;
    public WheelView.b l0;
    public boolean m0;
    public boolean n0;
    public boolean o0;
    public z02<T> w;
    public int x;
    public bf y;
    public Button z;

    /* compiled from: DxOptionsPickerView.java */
    public static class a {
        public String A;
        public String B;
        public Typeface F;
        public int G;
        public int H;
        public int I;
        public WheelView.b M;
        public bf b;
        public Context c;
        public b d;
        public String e;
        public String f;
        public String g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int s;
        public int t;
        public int u;
        public int v;
        public ViewGroup w;
        public boolean y;
        public String z;
        public int a = R.layout.pickerview_options;
        public int m = 17;
        public int n = 18;
        public int o = 18;
        public boolean p = true;
        public boolean q = true;
        public boolean r = true;
        public float x = 1.6f;
        public boolean C = false;
        public boolean D = false;
        public boolean E = false;
        public boolean J = false;
        public boolean K = false;
        public boolean L = true;

        public a(Context context, b bVar) {
            this.c = context;
            this.d = bVar;
        }

        public a M(boolean z) {
            this.r = z;
            return this;
        }

        public a N(boolean z) {
            this.y = z;
            return this;
        }

        public a O(int i) {
            this.v = i;
            return this;
        }

        public a P(int i) {
            this.k = i;
            return this;
        }

        public a Q(int i) {
            this.o = i;
            return this;
        }

        public a R(boolean z, boolean z2, boolean z3) {
            this.C = z;
            this.D = z2;
            this.E = z3;
            return this;
        }

        public a S(ViewGroup viewGroup) {
            this.w = viewGroup;
            return this;
        }

        public a T(int i) {
            this.u = i;
            return this;
        }

        public a U(boolean z) {
            this.K = z;
            return this;
        }

        public a V(boolean z) {
            this.L = z;
            return this;
        }

        public a W(boolean z) {
            this.J = z;
            return this;
        }

        public a X(int i, bf bfVar) {
            this.a = i;
            this.b = bfVar;
            return this;
        }

        public a Y(boolean z) {
            this.p = z;
            return this;
        }

        public a Z(int i) {
            this.t = i;
            return this;
        }

        public a a0(int i) {
            this.s = i;
            return this;
        }
    }

    /* compiled from: DxOptionsPickerView.java */
    public interface b {
        void a(int i, int i2, int i3, int i4, View view);

        void b();
    }

    public y02(a aVar) {
        super(aVar.c);
        this.W = 1.6f;
        this.Y = false;
        this.m0 = false;
        this.n0 = false;
        this.o0 = true;
        this.D = aVar.d;
        this.E = aVar.e;
        this.F = aVar.f;
        this.G = aVar.g;
        this.K = aVar.h;
        this.L = aVar.i;
        this.M = aVar.j;
        this.N = aVar.k;
        this.O = aVar.l;
        this.P = aVar.m;
        this.Q = aVar.n;
        this.R = aVar.o;
        this.e0 = aVar.C;
        this.f0 = aVar.D;
        this.g0 = aVar.E;
        this.Y = aVar.p;
        this.Z = aVar.q;
        this.a0 = aVar.r;
        this.b0 = aVar.z;
        this.c0 = aVar.A;
        this.d0 = aVar.B;
        this.h0 = aVar.F;
        this.i0 = aVar.G;
        this.j0 = aVar.H;
        this.k0 = aVar.I;
        this.T = aVar.t;
        this.S = aVar.s;
        this.U = aVar.u;
        this.W = aVar.x;
        this.y = aVar.b;
        this.x = aVar.a;
        this.X = aVar.y;
        this.l0 = aVar.M;
        this.V = aVar.v;
        this.d = aVar.w;
        this.m0 = aVar.J;
        this.n0 = aVar.K;
        this.o0 = aVar.L;
        y(aVar.c);
    }

    public void A() {
        if (this.D != null) {
            int[] iArrH = this.w.h();
            this.D.a(-1, iArrH[0], iArrH[1], iArrH[2], this.s);
        }
    }

    public void B(int i) {
        if (this.D != null) {
            int[] iArrH = this.w.h();
            this.D.a(i, iArrH[0], iArrH[1], iArrH[2], this.s);
        }
    }

    public void C(List<T> list, List<T> list2, List<T> list3) {
        this.w.t(list, list2, list3);
        x();
    }

    public void D(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.w.v(list, list2, list3);
        x();
    }

    public void E(int i, int i2, int i3) {
        this.i0 = i;
        this.j0 = i2;
        this.k0 = i3;
        x();
    }

    @Override // dc.gf
    public boolean o() {
        return this.X;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            A();
        }
        f();
    }

    public final void x() {
        z02<T> z02Var = this.w;
        if (z02Var != null) {
            z02Var.k(this.i0, this.j0, this.k0);
        }
    }

    public final void y(Context context) {
        r(this.Y);
        n(this.V);
        s(false);
        l();
        m();
        bf bfVar = this.y;
        if (bfVar == null) {
            LayoutInflater.from(context).inflate(this.x, this.c);
            this.B = (TextView) i(R.id.tvTitle);
            this.C = (RelativeLayout) i(R.id.rv_topbar);
            this.z = (Button) i(R.id.btnSubmit);
            this.A = (Button) i(R.id.btnCancel);
            this.z.setTag("submit");
            this.A.setTag("cancel");
            this.z.setOnClickListener(this);
            this.A.setOnClickListener(this);
            this.z.setText(TextUtils.isEmpty(this.E) ? context.getResources().getString(R.string.pickerview_submit) : this.E);
            this.A.setText(TextUtils.isEmpty(this.F) ? context.getResources().getString(R.string.pickerview_cancel) : this.F);
            this.B.setText(TextUtils.isEmpty(this.G) ? "" : this.G);
            Button button = this.z;
            int i = this.K;
            if (i == 0) {
                i = this.g;
            }
            button.setTextColor(i);
            Button button2 = this.A;
            int i2 = this.L;
            if (i2 == 0) {
                i2 = this.g;
            }
            button2.setTextColor(i2);
            TextView textView = this.B;
            int i3 = this.M;
            if (i3 == 0) {
                i3 = this.i;
            }
            textView.setTextColor(i3);
            RelativeLayout relativeLayout = this.C;
            int i4 = this.O;
            if (i4 == 0) {
                i4 = this.h;
            }
            relativeLayout.setBackgroundColor(i4);
            this.z.setTextSize(this.P);
            this.A.setTextSize(this.P);
            this.B.setTextSize(this.Q);
            this.B.setText(this.G);
        } else {
            bfVar.a(LayoutInflater.from(context).inflate(this.x, this.c));
        }
        LinearLayout linearLayout = (LinearLayout) i(R.id.optionspicker);
        int i5 = this.N;
        if (i5 != 0) {
            linearLayout.setBackgroundColor(i5);
        }
        z02<T> z02Var = new z02<>(linearLayout, Boolean.valueOf(this.Z));
        this.w = z02Var;
        z02Var.A(this.R);
        this.w.q(this.b0, this.c0, this.d0);
        this.w.l(this.e0, this.f0, this.g0);
        this.w.B(this.h0);
        this.w.i(Boolean.valueOf(this.m0));
        if (this.m0) {
            this.w.u(this);
        }
        t(this.Y);
        TextView textView2 = this.B;
        if (textView2 != null) {
            textView2.setText(this.G);
        }
        this.w.n(this.U);
        this.w.p(this.l0);
        this.w.s(this.W);
        this.w.z(this.S);
        this.w.x(this.T);
        this.w.i(Boolean.valueOf(this.a0));
    }

    public void z() {
        b bVar = this.D;
        if (bVar != null) {
            bVar.b();
        }
    }
}
