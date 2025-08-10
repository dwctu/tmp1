package dc;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SystemPatternWidget.java */
/* loaded from: classes4.dex */
public class eo3 implements View.OnClickListener {
    public Activity a;
    public Pattern b = null;
    public List<Pattern> c;
    public ImageView d;
    public TextView e;
    public ImageView f;
    public TextView g;
    public ImageView h;
    public TextView i;
    public ImageView j;
    public TextView k;
    public a l;

    /* compiled from: SystemPatternWidget.java */
    public interface a {
        void a();
    }

    public eo3(Activity activity, a aVar) {
        this.a = null;
        this.c = new ArrayList();
        this.l = null;
        this.a = activity;
        this.c = rf3.j();
        d();
        this.l = aVar;
    }

    public final void a(ImageView imageView, TextView textView) {
        imageView.setImageDrawable(th4.d(this.a, R.drawable.chat_pattern_defaultitem_select));
        a aVar = this.l;
        if (aVar != null) {
            aVar.a();
        }
    }

    public Pattern b() {
        return this.b;
    }

    public void c() {
        this.d.setImageDrawable(th4.d(this.a, R.drawable.chat_pattern_defaultitem_unselect));
        this.f.setImageDrawable(th4.d(this.a, R.drawable.chat_pattern_defaultitem_unselect));
        this.h.setImageDrawable(th4.d(this.a, R.drawable.chat_pattern_defaultitem_unselect));
        this.j.setImageDrawable(th4.d(this.a, R.drawable.chat_pattern_defaultitem_unselect));
        this.b = null;
    }

    public final void d() {
        this.a.findViewById(R.id.system_pattern_layout).setVisibility(0);
        this.a.findViewById(R.id.ll_pulse_layout).setOnClickListener(this);
        this.a.findViewById(R.id.ll_wave_layout).setOnClickListener(this);
        this.a.findViewById(R.id.ll_fireworks_layout).setOnClickListener(this);
        this.a.findViewById(R.id.ll_earthquake_layout).setOnClickListener(this);
        this.d = (ImageView) this.a.findViewById(R.id.iv_preset_pulse_selected);
        this.e = (TextView) this.a.findViewById(R.id.patterns_preset_pulse);
        this.f = (ImageView) this.a.findViewById(R.id.iv_preset_wave_selected);
        this.g = (TextView) this.a.findViewById(R.id.patterns_preset_wave);
        this.h = (ImageView) this.a.findViewById(R.id.iv_preset_fireworks_selected);
        this.i = (TextView) this.a.findViewById(R.id.patterns_preset_fireworks);
        this.j = (ImageView) this.a.findViewById(R.id.iv_preset_earthquake_selected);
        this.k = (TextView) this.a.findViewById(R.id.patterns_preset_earthquake);
        c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c();
        switch (view.getId()) {
            case R.id.ll_earthquake_layout /* 2131363503 */:
                this.b = rf3.h("Earthquake", this.c);
                a(this.j, this.k);
                break;
            case R.id.ll_fireworks_layout /* 2131363512 */:
                this.b = rf3.h("Fireworks", this.c);
                a(this.h, this.i);
                break;
            case R.id.ll_pulse_layout /* 2131363562 */:
                this.b = rf3.h("Pulse", this.c);
                a(this.d, this.e);
                break;
            case R.id.ll_wave_layout /* 2131363636 */:
                this.b = rf3.h("Wave", this.c);
                a(this.f, this.g);
                break;
        }
    }
}
