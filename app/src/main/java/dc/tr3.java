package dc;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import dc.y02;
import java.util.ArrayList;

/* compiled from: BirthdayDialog.java */
/* loaded from: classes4.dex */
public class tr3 extends Dialog {
    public c a;
    public y02 b;
    public int c;
    public int d;

    /* compiled from: BirthdayDialog.java */
    public class a implements y02.b {
        public a() {
        }

        @Override // dc.y02.b
        public void a(int i, int i2, int i3, int i4, View view) {
            if (i == 2) {
                tr3.this.c = i3 + 1;
            } else if (i == 3) {
                tr3.this.d = i4 + 1;
            }
        }

        @Override // dc.y02.b
        public void b() {
        }
    }

    /* compiled from: BirthdayDialog.java */
    public class b implements bf {
        public b(tr3 tr3Var) {
        }

        @Override // dc.bf
        public void a(View view) {
        }
    }

    /* compiled from: BirthdayDialog.java */
    public interface c {
        void a(int i, int i2);

        void onCancel();
    }

    public tr3(@NonNull Context context, int i) {
        super(context, i);
        this.b = null;
        this.c = 1;
        this.d = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        c cVar = this.a;
        if (cVar != null) {
            cVar.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(y02 y02Var, View view) {
        if (this.a != null) {
            y02Var.B(2);
            y02Var.B(3);
            this.a.a(this.c, this.d);
        }
    }

    public final y02 c(ViewGroup viewGroup, y02.b bVar) {
        y02.a aVar = new y02.a(getContext(), bVar);
        aVar.W(true);
        aVar.R(true, true, false);
        aVar.X(R.layout.birth_day_pickerview_layout, new b(this));
        aVar.R(false, true, true);
        aVar.O(th4.b(getContext(), R.color.bg_round_6));
        aVar.T(getContext().getResources().getColor(R.color.transparent));
        aVar.N(false);
        aVar.S(viewGroup);
        aVar.Y(false);
        aVar.Q(20);
        aVar.Z(th4.b(getContext(), R.color.text_color_85));
        aVar.a0(th4.b(getContext(), R.color.text_color_45));
        this.b = new y02(aVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (int i = 1; i <= 12; i++) {
            arrayList3.add(d(i));
            int i2 = 30;
            if (i == 2) {
                i2 = 29;
            } else if (i == 8 || ((i >= 8 || i % 2 != 0) && (i <= 8 || i % 2 != 1))) {
                i2 = 31;
            }
            ArrayList arrayList6 = new ArrayList();
            for (int i3 = 1; i3 <= i2; i3++) {
                if (i3 < 10) {
                    arrayList6.add("0" + i3);
                } else {
                    arrayList6.add(i3 + "");
                }
            }
            arrayList5.add(arrayList6);
        }
        arrayList2.add(arrayList3);
        arrayList4.add(arrayList5);
        this.b.D(arrayList, arrayList2, arrayList4);
        this.b.v(false);
        return this.b;
    }

    public final String d(int i) {
        return i == 1 ? getContext().getString(R.string.birthday_month_jan) : i == 2 ? getContext().getString(R.string.birthday_month_feb) : i == 3 ? getContext().getString(R.string.birthday_month_mar) : i == 4 ? getContext().getString(R.string.birthday_month_apr) : i == 5 ? getContext().getString(R.string.birthday_month_may) : i == 6 ? getContext().getString(R.string.birthday_month_jun) : i == 7 ? getContext().getString(R.string.birthday_month_jul) : i == 8 ? getContext().getString(R.string.birthday_month_aug) : i == 9 ? getContext().getString(R.string.birthday_month_sept) : i == 10 ? getContext().getString(R.string.birthday_month_oct) : i == 11 ? getContext().getString(R.string.birthday_month_nov) : i == 12 ? getContext().getString(R.string.birthday_month_dec) : "";
    }

    public void i(c cVar) {
        this.a = cVar;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.birthday_picker_dialog, (ViewGroup) null);
        setContentView(viewInflate);
        WearUtils.q2(this);
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
        final y02 y02VarC = c((FrameLayout) viewInflate.findViewById(R.id.layout_for_picker_view), new a());
        viewInflate.findViewById(R.id.iv_cancel).setOnClickListener(new View.OnClickListener() { // from class: dc.tp3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.f(view);
            }
        });
        viewInflate.findViewById(R.id.tv_finish).setOnClickListener(new View.OnClickListener() { // from class: dc.sp3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.h(y02VarC, view);
            }
        });
    }
}
