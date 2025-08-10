package dc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.bean.ProgramPattern;
import com.wear.main.toy.ToyProgramActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.kn3;

/* compiled from: ProgramPatternAdapter.java */
/* loaded from: classes3.dex */
public class yo1 extends BaseAdapter {
    public LayoutInflater a;
    public ToyProgramActivity b;

    /* compiled from: ProgramPatternAdapter.java */
    public class a implements View.OnClickListener {
        public final /* synthetic */ ProgramPattern a;

        /* compiled from: ProgramPatternAdapter.java */
        /* renamed from: dc.yo1$a$a, reason: collision with other inner class name */
        public class C0232a implements kn3.d {
            public C0232a() {
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                a aVar = a.this;
                ToyProgramActivity toyProgramActivity = yo1.this.b;
                toyProgramActivity.d = aVar.a;
                toyProgramActivity.f5();
            }
        }

        public a(ProgramPattern programPattern) {
            this.a = programPattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyProgramActivity toyProgramActivity = yo1.this.b;
            if (!toyProgramActivity.i) {
                toyProgramActivity.c5();
                return;
            }
            toyProgramActivity.d = this.a;
            kn3 kn3Var = new kn3((Context) yo1.this.b, String.format(ah4.e(R.string.toy_program_delete_pattern_by_name), this.a.getName()), ah4.e(R.string.common_accept), ah4.e(R.string.common_cancel), false, (kn3.d) new C0232a());
            kn3Var.show();
            kn3Var.l();
            kn3Var.p();
        }
    }

    /* compiled from: ProgramPatternAdapter.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            yo1.this.b.c5();
        }
    }

    /* compiled from: ProgramPatternAdapter.java */
    public class c {
        public String a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public LinearLayout f;
        public ImageView g;
        public ImageView h;
        public TextView i;

        public c(yo1 yo1Var) {
        }
    }

    public yo1(ToyProgramActivity toyProgramActivity, MyApplication myApplication) {
        this.a = null;
        this.a = LayoutInflater.from(toyProgramActivity);
        this.b = toyProgramActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        c cVar;
        ProgramPattern programPattern = this.b.e.get(i);
        if (view == null) {
            cVar = new c(this);
            viewInflate = this.a.inflate(R.layout.remote_pattern_program_item, (ViewGroup) null);
            cVar.b = (TextView) viewInflate.findViewById(R.id.pattern_name);
            cVar.c = (TextView) viewInflate.findViewById(R.id.pattern_author);
            cVar.d = (TextView) viewInflate.findViewById(R.id.pattern_timer);
            cVar.e = (TextView) viewInflate.findViewById(R.id.pattern_func_v1);
            cVar.f = (LinearLayout) viewInflate.findViewById(R.id.pattern_operation);
            cVar.g = (ImageView) viewInflate.findViewById(R.id.pattern_operation_image);
            cVar.h = (ImageView) viewInflate.findViewById(R.id.pattern_select_icon);
            cVar.i = (TextView) viewInflate.findViewById(R.id.pattern_number);
            viewInflate.setTag(cVar);
        } else {
            viewInflate = view;
            cVar = (c) view.getTag();
        }
        cVar.i.setText("" + (Integer.valueOf(programPattern.getIndex()).intValue() + 1));
        cVar.i.setVisibility(0);
        cVar.a = programPattern.getId();
        cVar.b.setText(programPattern.getName());
        cVar.c.setText(WearUtils.e1(programPattern.getAuthor()) ? ah4.e(R.string.common_anonymous) : programPattern.getAuthor());
        cVar.d.setText(programPattern.getTimer());
        cVar.g.setBackgroundResource(R.drawable.alarm_list_delete);
        cVar.f.setOnClickListener(new a(programPattern));
        cVar.e.setVisibility(8);
        if ((this.b.d == programPattern) && (!r0.i)) {
            cVar.h.setVisibility(0);
        } else {
            cVar.h.setVisibility(8);
        }
        cVar.h.setOnClickListener(new b());
        return viewInflate;
    }
}
