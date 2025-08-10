package dc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.main.patterns.DialogPatternsActivity;
import com.wear.main.patterns.SharePatternActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.kn3;
import dc.zn3;
import java.text.DateFormat;
import java.util.Locale;

/* compiled from: PatternDialogAdapter.java */
/* loaded from: classes3.dex */
public class zj1 extends BaseAdapter {
    public LayoutInflater a;
    public DialogPatternsActivity b;

    /* compiled from: PatternDialogAdapter.java */
    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zj1 zj1Var = zj1.this;
            zj1Var.c(view, zj1Var.getItem(this.a));
        }
    }

    /* compiled from: PatternDialogAdapter.java */
    public class b implements zn3.a {
        public b(zj1 zj1Var) {
        }

        @Override // dc.zn3.a
        public void a(zn3 zn3Var) {
            zn3Var.findViewById(R.id.root_layout).setBackgroundResource(R.drawable.menu_small_top_bg);
        }

        @Override // dc.zn3.a
        public void b(zn3 zn3Var) {
            zn3Var.findViewById(R.id.root_layout).setBackgroundResource(R.drawable.menu_small_buttom_bg);
        }
    }

    /* compiled from: PatternDialogAdapter.java */
    public class c implements View.OnClickListener {
        public final /* synthetic */ zn3 a;
        public final /* synthetic */ Pattern b;

        public c(zn3 zn3Var, Pattern pattern) {
            this.a = zn3Var;
            this.b = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            if (this.b.getData() == null) {
                Pattern pattern = this.b;
                pattern.setData(WearUtils.N1(pattern.getFile().getPath()));
            }
            if (this.b.isCheckMd5()) {
                Bundle bundle = new Bundle();
                bundle.putString("patternId", this.b.getId());
                bundle.putBoolean("isUpdate", this.b.isShared());
                if (!WearUtils.e1(this.b.getToyFeature())) {
                    bundle.putString("toyFeature", this.b.getToyFeature());
                }
                pj3.g(zj1.this.b, SharePatternActivity.class, bundle);
            }
        }
    }

    /* compiled from: PatternDialogAdapter.java */
    public class d implements View.OnClickListener {
        public final /* synthetic */ zn3 a;
        public final /* synthetic */ Pattern b;

        public d(zn3 zn3Var, Pattern pattern) {
            this.a = zn3Var;
            this.b = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            DialogPatternsActivity dialogPatternsActivity = zj1.this.b;
            String strE = ah4.e(R.string.pattern_name);
            String strE2 = ah4.e(R.string.pattern_name);
            Pattern pattern = this.b;
            dialogPatternsActivity.A4(strE, strE2, pattern == null ? "" : pattern.getName(), this.b);
        }
    }

    /* compiled from: PatternDialogAdapter.java */
    public class e implements View.OnClickListener {
        public final /* synthetic */ zn3 a;
        public final /* synthetic */ Pattern b;

        /* compiled from: PatternDialogAdapter.java */
        public class a implements kn3.d {
            public a() {
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                zj1.this.b.y4(e.this.b);
            }
        }

        public e(zn3 zn3Var, Pattern pattern) {
            this.a = zn3Var;
            this.b = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            String strE = ah4.e(R.string.toy_program_delete_pattern);
            if (this.b.isShared()) {
                strE = strE + ah4.e(R.string.pattern_shareddelete_warning);
            }
            kn3 kn3Var = new kn3((Context) zj1.this.b, strE, ah4.e(R.string.common_yes), ah4.e(R.string.common_no), false, (kn3.d) new a());
            kn3Var.show();
            kn3Var.p();
        }
    }

    /* compiled from: PatternDialogAdapter.java */
    public class f {
        public String a;
        public View b;
        public ImageView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public TextView h;
        public TextView i;
        public TextView j;
        public TextView k;
        public TextView l;
        public TextView m;
        public TextView n;
        public TextView o;
        public View p;

        public f(zj1 zj1Var) {
        }
    }

    public zj1(DialogPatternsActivity dialogPatternsActivity, MyApplication myApplication) {
        this.a = null;
        this.a = LayoutInflater.from(dialogPatternsActivity);
        this.b = dialogPatternsActivity;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Pattern getItem(int i) {
        return this.b.g.get(i);
    }

    public void c(View view, Pattern pattern) {
        zn3 zn3Var = new zn3(this.b, R.style.MenuDialog, R.layout.select_pattern_dialog);
        zn3Var.b(view, 120, 180, 5160, -30, new b(this));
        zn3Var.findViewById(R.id.action_row_1_icon).setVisibility(8);
        zn3Var.findViewById(R.id.action_row_2_icon).setVisibility(8);
        zn3Var.findViewById(R.id.action_row_3_icon).setVisibility(8);
        TextView textView = (TextView) zn3Var.findViewById(R.id.action_row_1_text);
        if (pattern.isShared()) {
            textView.setText(ah4.e(R.string.common_reshared));
        } else {
            textView.setText(ah4.e(R.string.common_share));
        }
        zn3Var.findViewById(R.id.action_row_1).setOnClickListener(new c(zn3Var, pattern));
        ((TextView) zn3Var.findViewById(R.id.action_row_2_text)).setText(ah4.e(R.string.common_rename));
        zn3Var.findViewById(R.id.action_row_2).setOnClickListener(new d(zn3Var, pattern));
        ((TextView) zn3Var.findViewById(R.id.action_row_3_text)).setText(ah4.e(R.string.common_delete));
        zn3Var.findViewById(R.id.action_row_3).setOnClickListener(new e(zn3Var, pattern));
        zn3Var.show();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        f fVar;
        Pattern pattern = this.b.g.get(i);
        if (view == null) {
            fVar = new f(this);
            viewInflate = this.a.inflate(R.layout.dialog_pattern_item, (ViewGroup) null);
            fVar.b = viewInflate.findViewById(R.id.pattern_choose_layout);
            fVar.c = (ImageView) viewInflate.findViewById(R.id.pattern_select_icon);
            fVar.d = (TextView) viewInflate.findViewById(R.id.pattern_name);
            fVar.e = (TextView) viewInflate.findViewById(R.id.pattern_author);
            fVar.f = (TextView) viewInflate.findViewById(R.id.pattern_timer);
            fVar.g = (TextView) viewInflate.findViewById(R.id.pattern_func_v1);
            fVar.m = (TextView) viewInflate.findViewById(R.id.pattern_func_f);
            fVar.h = (TextView) viewInflate.findViewById(R.id.pattern_func_v2);
            fVar.i = (TextView) viewInflate.findViewById(R.id.pattern_func_v3);
            fVar.j = (TextView) viewInflate.findViewById(R.id.pattern_func_r);
            fVar.k = (TextView) viewInflate.findViewById(R.id.pattern_func_p);
            fVar.l = (TextView) viewInflate.findViewById(R.id.pattern_func_s);
            fVar.n = (TextView) viewInflate.findViewById(R.id.pattern_func_t);
            fVar.o = (TextView) viewInflate.findViewById(R.id.dialog_pattern_func_pos);
            fVar.p = viewInflate.findViewById(R.id.pattern_operation_layout);
            viewInflate.setTag(fVar);
        } else {
            viewInflate = view;
            fVar = (f) view.getTag();
        }
        fVar.a = pattern.getId();
        fVar.d.setText(pattern.getName());
        String strE = ah4.e(R.string.common_anonymous);
        if (!WearUtils.e1(pattern.getAuthor())) {
            strE = pattern.getAuthor();
        }
        fVar.e.setText(strE);
        if (pattern.getCreated() != null) {
            WearUtils.e1(be3.i(be3.g, pattern.getCreated()));
        }
        Locale localeE = lg3.e(this.b);
        fVar.f.setText(pattern.getTimer() + "    " + DateFormat.getDateTimeInstance(2, 3, localeE).format(pattern.getCreated()));
        if (this.b.f) {
            fVar.b.setVisibility(0);
            fVar.p.setVisibility(8);
            if (this.b.c.containsKey(Integer.valueOf(i))) {
                fVar.c.setImageResource(R.drawable.content_icon_selectpattern_selected);
            } else {
                fVar.c.setImageResource(R.drawable.content_icon_selectpattern_normal);
            }
        } else {
            fVar.b.setVisibility(8);
            fVar.p.setVisibility(0);
            fVar.p.setOnClickListener(new a(i));
        }
        if (WearUtils.e1(pattern.getToyFunc())) {
            fVar.g.setVisibility(8);
        } else {
            Toy.existSecondVibratorVFunc(pattern.getToyFunc(), fVar.h);
            Toy.existThirdVibratorVFunc(pattern.getToyFunc(), fVar.i);
            Toy.existRotationVFunc(pattern.getToyFunc(), fVar.j);
            Toy.existfingerFunf(pattern.getToyFunc(), fVar.m);
            Toy.existPumpVFunc(pattern.getToyFunc(), fVar.k);
            Toy.existfingerFunt(pattern.getToyFunc(), fVar.n);
            Toy.isVelvoFunt(pattern.getToyFunc(), fVar.o);
        }
        if (TextUtils.equals("s", pattern.getToyFunc())) {
            fVar.g.setVisibility(8);
            fVar.l.setVisibility(0);
        } else if (TextUtils.equals("pos", pattern.getToyFunc())) {
            fVar.g.setVisibility(8);
            fVar.l.setVisibility(8);
        } else {
            fVar.g.setVisibility(0);
            fVar.l.setVisibility(8);
        }
        if (WearUtils.e1(pattern.getToyFeature()) || !pattern.getToyFeature().toLowerCase().equals(Toy.TOY_FEATURE_XMACHINE.toLowerCase())) {
            fVar.g.setBackgroundResource(R.drawable.chat_label_toy_function_vibration);
        } else {
            fVar.g.setBackgroundResource(R.drawable.home_label_toy_function_speed);
        }
        return viewInflate;
    }
}
