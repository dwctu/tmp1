package dc;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.os.EnvironmentCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.adapter.patterns.PatternFilterToyAdapter;
import com.wear.bean.PatternFilterToyBean;
import com.wear.bean.Toy;
import com.wear.bean.ToyConfigInfoBean;
import com.wear.util.WearUtils;
import com.wear.widget.LineWrapLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: PatternFilterPop.java */
/* loaded from: classes4.dex */
public class js3 {
    public Context a;
    public ImageView b;
    public TextView c;
    public RecyclerView d;
    public LineWrapLayout e;
    public TextView f;
    public List<PatternFilterToyBean> g = new ArrayList();
    public List<PatternFilterToyBean> h = new ArrayList();
    public int i = 0;
    public List<PatternFilterToyBean> j = new ArrayList();
    public List<PatternFilterToyBean> k = new ArrayList();
    public int l = 0;
    public PopupWindow m;
    public View n;
    public PatternFilterToyAdapter o;
    public SeekBar p;
    public TextView q;
    public i r;

    /* compiled from: PatternFilterPop.java */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            js3.this.f.setText(WearUtils.Q(i * 30));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* compiled from: PatternFilterPop.java */
    public class b implements PatternFilterToyAdapter.b {
        public b() {
        }

        @Override // com.wear.adapter.patterns.PatternFilterToyAdapter.b
        public void a(PatternFilterToyBean patternFilterToyBean, int i) {
            patternFilterToyBean.setSelect(!patternFilterToyBean.isSelect());
            js3.this.o.notifyDataSetChanged();
        }
    }

    /* compiled from: PatternFilterPop.java */
    public class c extends GridLayoutManager {
        public c(js3 js3Var, Context context, int i) {
            super(context, i);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* compiled from: PatternFilterPop.java */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            js3.this.k.clear();
            js3 js3Var = js3.this;
            js3Var.k.addAll(js3Var.h);
            js3 js3Var2 = js3.this;
            js3Var2.l = js3Var2.p.getProgress();
            js3.this.j.clear();
            js3.this.j.addAll(js3.this.g);
            boolean z = false;
            for (PatternFilterToyBean patternFilterToyBean : js3.this.g) {
                if (patternFilterToyBean.isSelect() && patternFilterToyBean.getToyName().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                    z = true;
                }
            }
            if (js3.this.r != null) {
                js3.this.r.a(js3.this.q(), js3.this.s(), js3.this.A(), js3.this.r(), z);
                String str = "getTag====" + js3.this.q();
            }
            js3.this.m.dismiss();
        }
    }

    /* compiled from: PatternFilterPop.java */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            js3.this.g.clear();
            js3.this.v(true);
            js3.this.o.notifyDataSetChanged();
            js3.this.h.clear();
            js3.this.y();
            js3.this.i = 0;
            js3.this.p.setProgress(0);
        }
    }

    /* compiled from: PatternFilterPop.java */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            js3.this.m.dismiss();
        }
    }

    /* compiled from: PatternFilterPop.java */
    public class g implements PopupWindow.OnDismissListener {
        public g() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            js3.this.p(1.0f);
        }
    }

    /* compiled from: PatternFilterPop.java */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (PatternFilterToyBean patternFilterToyBean : js3.this.h) {
                if (patternFilterToyBean.getToyTag().equals(view.getTag())) {
                    patternFilterToyBean.setSelect(!patternFilterToyBean.isSelect());
                } else {
                    patternFilterToyBean.setSelect(false);
                }
            }
            js3.this.x();
        }
    }

    /* compiled from: PatternFilterPop.java */
    public interface i {
        void a(String str, String str2, String str3, String str4, boolean z);
    }

    public js3(Context context) {
        this.a = context;
        t();
    }

    public final String A() {
        for (PatternFilterToyBean patternFilterToyBean : this.h) {
            if (patternFilterToyBean.isSelect()) {
                return patternFilterToyBean.getToyTag();
            }
        }
        return null;
    }

    public void p(float f2) {
        try {
            WindowManager.LayoutParams attributes = ((Activity) this.a).getWindow().getAttributes();
            attributes.alpha = f2;
            if (f2 == 1.0f) {
                ((Activity) this.a).getWindow().clearFlags(2);
            } else {
                ((Activity) this.a).getWindow().addFlags(2);
            }
            ((Activity) this.a).getWindow().setAttributes(attributes);
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public final String q() {
        ArrayList<String> arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            PatternFilterToyBean patternFilterToyBean = this.g.get(i2);
            if (patternFilterToyBean.isSelect() && !arrayList.contains(patternFilterToyBean.getToyTag()) && !patternFilterToyBean.getToyName().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                arrayList.add(patternFilterToyBean.getToyTag());
            }
        }
        String str = null;
        if (arrayList.size() <= 0) {
            return null;
        }
        for (String str2 : arrayList) {
            if (!WearUtils.e1(str)) {
                str2 = str + ";" + str2;
            }
            str = str2;
        }
        return str;
    }

    public final String r() {
        return (this.p.getProgress() * 30) + "";
    }

    public final String s() {
        ArrayList<String> arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            PatternFilterToyBean patternFilterToyBean = this.g.get(i2);
            if (patternFilterToyBean.isSelect() && !arrayList.contains(patternFilterToyBean.getToySymbols())) {
                arrayList.add(this.g.get(i2).getToySymbols());
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        String str = "";
        for (String str2 : arrayList) {
            str = WearUtils.e1(str) ? str2 : str + ";" + str2;
        }
        return str;
    }

    public void t() {
        try {
            this.m = new PopupWindow(this.a);
            View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.dialog_pattern_filter, (ViewGroup) null);
            this.n = viewInflate;
            this.b = (ImageView) viewInflate.findViewById(R.id.iv_close);
            this.c = (TextView) this.n.findViewById(R.id.tv_done);
            this.q = (TextView) this.n.findViewById(R.id.tv_reset);
            this.d = (RecyclerView) this.n.findViewById(R.id.toy_recyler_view);
            this.e = (LineWrapLayout) this.n.findViewById(R.id.ll_wrap_time);
            this.f = (TextView) this.n.findViewById(R.id.tv_count);
            SeekBar seekBar = (SeekBar) this.n.findViewById(R.id.pattern_seek);
            this.p = seekBar;
            seekBar.setOnSeekBarChangeListener(new a());
            vd3.b(this.g, new s12());
            PatternFilterToyAdapter patternFilterToyAdapter = new PatternFilterToyAdapter(this.a, this.g);
            this.o = patternFilterToyAdapter;
            patternFilterToyAdapter.o(new b());
            this.d.setLayoutManager(new c(this, this.a, 4));
            this.d.setAdapter(this.o);
            this.c.setOnClickListener(new d());
            this.q.setOnClickListener(new e());
            this.b.setOnClickListener(new f());
            this.m.setContentView(this.n);
            this.m.setFocusable(true);
            this.m.setBackgroundDrawable(new ColorDrawable(0));
            this.m.setOutsideTouchable(false);
            this.m.setWidth(-1);
            this.m.setHeight(-2);
            this.m.setOnDismissListener(new g());
            this.m.setAnimationStyle(R.style.pop_window_show_down);
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public boolean u() {
        try {
            PopupWindow popupWindow = this.m;
            if (popupWindow != null) {
                return popupWindow.isShowing();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void v(boolean z) {
        List<ToyConfigInfoBean> list = Toy.toyConfigBean;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < Toy.toyConfigBean.size(); i2++) {
            if (!Toy.toyConfigBean.get(i2).getShowName().toLowerCase().equals(EnvironmentCompat.MEDIA_UNKNOWN) && Toy.toyConfigBean.get(i2).isSelling() && !uu1.e(Toy.toyConfigBean.get(i2).getSymbol())) {
                ToyConfigInfoBean.FuncBean func = Toy.toyConfigBean.get(i2).getFunc();
                List<String> symbol = Toy.toyConfigBean.get(i2).getSymbol();
                Iterator<String> it = symbol.iterator();
                String str = "";
                String str2 = "";
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    str2 = WearUtils.e1(str2) ? next : str2 + "," + next;
                }
                if (func != null) {
                    if (func.isV() && !func.isV1()) {
                        str = PSOProgramService.VS_Key;
                    }
                    if (func.isV1()) {
                        str = WearUtils.e1(str) ? "v1" : str + ",v1";
                    }
                    if (func.isV2()) {
                        str = WearUtils.e1(str) ? "v2" : str + ",v2";
                    }
                    if (func.isV3()) {
                        str = WearUtils.e1(str) ? "v3" : str + ",v3";
                    }
                    if (func.isF()) {
                        str = WearUtils.e1(str) ? "f" : str + ",f";
                    }
                    if (func.isP()) {
                        str = WearUtils.e1(str) ? "p" : str + ",p";
                    }
                    if (func.isR()) {
                        str = WearUtils.e1(str) ? StreamManagement.AckRequest.ELEMENT : str + ",r";
                    }
                    if (func.isT()) {
                        str = WearUtils.e1(str) ? "t" : str + (uu1.g(symbol) ? ";" : ",") + "t";
                    }
                    if (func.isS()) {
                        str = "s";
                    }
                    if (func.isD()) {
                        str = WearUtils.e1(str) ? GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG : str + ",d";
                    }
                    if (func.isPos()) {
                        str = WearUtils.e1(str) ? "pos" : str + (uu1.g(symbol) ? ";" : ",") + "pos";
                    }
                }
                String str3 = "tag============" + str;
                PatternFilterToyBean patternFilterToyBean = new PatternFilterToyBean(Toy.toyConfigBean.get(i2).getShowName(), str, str2);
                if (!z) {
                    for (int i3 = 0; i3 < WearUtils.x.G().P().size(); i3++) {
                        Toy toy = WearUtils.x.G().P().get(i3);
                        if (Toy.toyConfigBean.get(i2).getType().equals(toy.getType()) || (toy.isMiniXMachine() && Toy.toyConfigBean.get(i2).getType().equalsIgnoreCase("xmachine"))) {
                            patternFilterToyBean.setSelect(true);
                        }
                    }
                }
                this.g.add(patternFilterToyBean);
            }
        }
    }

    public void w(i iVar) {
        this.r = iVar;
    }

    public final void x() {
        this.e.removeAllViews();
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            View viewInflate = View.inflate(this.a, R.layout.item_pattern_filter_pop_time_tag, null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_tag);
            PatternFilterToyBean patternFilterToyBean = this.h.get(i2);
            textView.setText(patternFilterToyBean.getToyName());
            textView.setTag(patternFilterToyBean.getToyTag());
            textView.setOnClickListener(new h());
            if (patternFilterToyBean.isSelect()) {
                textView.setBackground(th4.d(this.a, R.drawable.shape_pattern_filter_select));
                textView.setTextColor(th4.b(this.a, R.color.white));
            } else {
                textView.setBackground(th4.d(this.a, R.drawable.shape_pattern_filter));
                textView.setTextColor(th4.b(this.a, R.color.text_color_b45_wo));
            }
            this.e.addView(viewInflate);
        }
    }

    public final void y() {
        this.h.add(new PatternFilterToyBean(ah4.e(R.string.common_patterns_time_today), "today", ""));
        this.h.add(new PatternFilterToyBean(ah4.e(R.string.common_patterns_time_1week), "oneWeek", ""));
        this.h.add(new PatternFilterToyBean(ah4.e(R.string.common_patterns_time_1month), "oneMonth", ""));
        this.h.add(new PatternFilterToyBean(ah4.e(R.string.common_patterns_time_3months), "threeMonth", ""));
        this.h.add(new PatternFilterToyBean(ah4.e(R.string.common_patterns_time_6months), "sixMonth", ""));
        int i2 = Calendar.getInstance().get(1);
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 2018) {
                this.h.add(new PatternFilterToyBean(ah4.e(R.string.common_patterns_time_before2018), "2017", ""));
                x();
                return;
            } else {
                this.h.add(new PatternFilterToyBean(String.valueOf(i3), String.valueOf(i3), ""));
                i2 = i3;
            }
        }
    }

    public void z() {
        try {
            if (this.m != null) {
                Context context = this.a;
                if (!(context instanceof Activity) || ((Activity) context).isFinishing() || this.m.isShowing()) {
                    return;
                }
                this.g.clear();
                if (this.j.size() > 0) {
                    this.g.addAll(this.j);
                    this.o.notifyDataSetChanged();
                } else {
                    v(false);
                    this.o.notifyDataSetChanged();
                }
                this.h.clear();
                if (this.k.size() > 0) {
                    this.h.addAll(this.k);
                    x();
                } else {
                    y();
                }
                int i2 = this.l;
                this.i = i2;
                this.p.setProgress(i2);
                p(0.7f);
                this.m.showAtLocation(this.n, 80, 0, 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }
}
