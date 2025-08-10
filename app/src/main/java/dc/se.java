package dc;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.lib.WheelView;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/* compiled from: TimePickerView.java */
/* loaded from: classes.dex */
public class se extends gf implements View.OnClickListener {
    public Button A;
    public TextView B;
    public b C;
    public int D;
    public boolean[] E;
    public String F;
    public String G;
    public String K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public Calendar T;
    public Calendar U;
    public Calendar V;
    public int W;
    public int X;
    public boolean Y;
    public boolean Z;
    public boolean a0;
    public int b0;
    public int c0;
    public int d0;
    public int e0;
    public float f0;
    public boolean g0;
    public String h0;
    public String i0;
    public String j0;
    public String k0;
    public String l0;
    public String m0;
    public WheelView.b n0;
    public int w;
    public bf x;
    public hf y;
    public Button z;

    /* compiled from: TimePickerView.java */
    public static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public WheelView.b E;
        public boolean G;
        public String H;
        public String I;
        public String J;
        public String K;
        public String L;
        public String M;
        public bf b;
        public Context c;
        public b d;
        public String g;
        public String h;
        public String i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public Calendar r;
        public Calendar s;
        public Calendar t;
        public int u;
        public int v;
        public ViewGroup z;
        public int a = oe.pickerview_time;
        public boolean[] e = {true, true, true, true, true, true};
        public int f = 17;
        public int o = 17;
        public int p = 18;
        public int q = 18;
        public boolean w = false;
        public boolean x = true;
        public boolean y = true;
        public float F = 1.6f;

        public a(Context context, b bVar) {
            this.c = context;
            this.d = bVar;
        }

        public se M() {
            return new se(this);
        }

        public a N(boolean z) {
            this.w = z;
            return this;
        }

        public a O(Calendar calendar) {
            this.r = calendar;
            return this;
        }

        public a P(int i) {
            this.C = i;
            return this;
        }

        public a Q(int i, bf bfVar) {
            this.a = i;
            this.b = bfVar;
            return this;
        }

        public a R(Calendar calendar, Calendar calendar2) {
            this.s = calendar;
            this.t = calendar2;
            return this;
        }

        public a S(String str) {
            this.i = str;
            return this;
        }

        public a T(boolean[] zArr) {
            this.e = zArr;
            return this;
        }
    }

    /* compiled from: TimePickerView.java */
    public interface b {
        void a(Date date, View view);
    }

    public se(a aVar) {
        super(aVar.c);
        this.D = 17;
        this.f0 = 1.6f;
        this.C = aVar.d;
        this.D = aVar.f;
        this.E = aVar.e;
        this.F = aVar.g;
        this.G = aVar.h;
        this.K = aVar.i;
        this.L = aVar.j;
        this.M = aVar.k;
        this.N = aVar.l;
        this.O = aVar.m;
        this.P = aVar.n;
        this.Q = aVar.o;
        this.R = aVar.p;
        this.S = aVar.q;
        this.W = aVar.u;
        this.X = aVar.v;
        this.U = aVar.s;
        this.V = aVar.t;
        this.T = aVar.r;
        this.Y = aVar.w;
        this.a0 = aVar.y;
        this.Z = aVar.x;
        this.h0 = aVar.H;
        this.i0 = aVar.I;
        this.j0 = aVar.J;
        this.k0 = aVar.K;
        this.l0 = aVar.L;
        this.m0 = aVar.M;
        this.c0 = aVar.B;
        this.b0 = aVar.A;
        this.d0 = aVar.C;
        this.x = aVar.b;
        this.w = aVar.a;
        this.f0 = aVar.F;
        this.g0 = aVar.G;
        this.n0 = aVar.E;
        this.e0 = aVar.D;
        this.d = aVar.z;
        x(aVar.c);
    }

    public final void A() {
        this.y.z(this.W);
        this.y.s(this.X);
    }

    public final void B() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.T;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = calendar2.get(1);
            i2 = this.T.get(2);
            i3 = this.T.get(5);
            i4 = this.T.get(11);
            i5 = this.T.get(12);
            i6 = this.T.get(13);
        }
        int i7 = i4;
        int i8 = i3;
        int i9 = i2;
        hf hfVar = this.y;
        hfVar.w(i, i9, i8, i7, i5, i6);
    }

    @Override // dc.gf
    public boolean o() {
        return this.g0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            y();
        }
        f();
    }

    public final void x(Context context) {
        int i;
        r(this.Z);
        n(this.e0);
        l();
        m();
        bf bfVar = this.x;
        if (bfVar == null) {
            LayoutInflater.from(context).inflate(oe.pickerview_time, this.c);
            this.B = (TextView) i(ne.tvTitle);
            this.z = (Button) i(ne.btnSubmit);
            this.A = (Button) i(ne.btnCancel);
            this.z.setTag("submit");
            this.A.setTag("cancel");
            this.z.setOnClickListener(this);
            this.A.setOnClickListener(this);
            this.z.setText(TextUtils.isEmpty(this.F) ? context.getResources().getString(pe.pickerview_submit) : this.F);
            this.A.setText(TextUtils.isEmpty(this.G) ? context.getResources().getString(pe.pickerview_cancel) : this.G);
            this.B.setText(TextUtils.isEmpty(this.K) ? "" : this.K);
            Button button = this.z;
            int i2 = this.L;
            if (i2 == 0) {
                i2 = this.g;
            }
            button.setTextColor(i2);
            Button button2 = this.A;
            int i3 = this.M;
            if (i3 == 0) {
                i3 = this.g;
            }
            button2.setTextColor(i3);
            TextView textView = this.B;
            int i4 = this.N;
            if (i4 == 0) {
                i4 = this.i;
            }
            textView.setTextColor(i4);
            this.z.setTextSize(this.Q);
            this.A.setTextSize(this.Q);
            this.B.setTextSize(this.R);
            RelativeLayout relativeLayout = (RelativeLayout) i(ne.rv_topbar);
            int i5 = this.P;
            if (i5 == 0) {
                i5 = this.h;
            }
            relativeLayout.setBackgroundColor(i5);
        } else {
            bfVar.a(LayoutInflater.from(context).inflate(this.w, this.c));
        }
        LinearLayout linearLayout = (LinearLayout) i(ne.timepicker);
        int i6 = this.O;
        if (i6 == 0) {
            i6 = this.j;
        }
        linearLayout.setBackgroundColor(i6);
        this.y = new hf(linearLayout, this.E, this.D, this.S);
        int i7 = this.W;
        if (i7 != 0 && (i = this.X) != 0 && i7 <= i) {
            A();
        }
        Calendar calendar = this.U;
        if (calendar == null || this.V == null) {
            if (calendar != null && this.V == null) {
                z();
            } else if (calendar == null && this.V != null) {
                z();
            }
        } else if (calendar.getTimeInMillis() <= this.V.getTimeInMillis()) {
            z();
        }
        B();
        this.y.t(this.h0, this.i0, this.j0, this.k0, this.l0, this.m0);
        t(this.Z);
        this.y.n(this.Y);
        this.y.p(this.d0);
        this.y.r(this.n0);
        this.y.v(this.f0);
        this.y.D(this.b0);
        this.y.B(this.c0);
        this.y.l(Boolean.valueOf(this.a0));
    }

    public void y() {
        if (this.C != null) {
            try {
                this.C.a(hf.w.parse(this.y.k()), this.s);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public final void z() {
        this.y.x(this.U, this.V);
        Calendar calendar = this.U;
        if (calendar != null && this.V != null) {
            Calendar calendar2 = this.T;
            if (calendar2 == null || calendar2.getTimeInMillis() < this.U.getTimeInMillis() || this.T.getTimeInMillis() > this.V.getTimeInMillis()) {
                this.T = this.U;
                return;
            }
            return;
        }
        if (calendar != null) {
            this.T = calendar;
            return;
        }
        Calendar calendar3 = this.V;
        if (calendar3 != null) {
            this.T = calendar3;
        }
    }
}
