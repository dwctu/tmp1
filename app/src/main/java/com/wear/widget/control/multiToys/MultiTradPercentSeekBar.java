package com.wear.widget.control.multiToys;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.bean.controlmutlitoys.ControlBallBean;
import com.wear.widget.control.multiToys.MultiTradSeekBar;

/* loaded from: classes4.dex */
public class MultiTradPercentSeekBar extends RelativeLayout {
    public TextView a;
    public MultiTradSeekBar b;
    public b c;

    public class a implements MultiTradSeekBar.c {
        public a() {
        }

        @Override // com.wear.widget.control.multiToys.MultiTradSeekBar.c
        public void a(int i) {
            if (MultiTradPercentSeekBar.this.c != null) {
                MultiTradPercentSeekBar.this.c.a(i);
            }
        }

        @Override // com.wear.widget.control.multiToys.MultiTradSeekBar.c
        public void b(int i) {
            MultiTradPercentSeekBar.this.a.setText(i + "%");
            if (MultiTradPercentSeekBar.this.c != null) {
                MultiTradPercentSeekBar.this.c.b(i);
            }
        }
    }

    public interface b {
        void a(int i);

        void b(int i);
    }

    public MultiTradPercentSeekBar(Context context) {
        super(context);
    }

    public void c(ControlBallBean controlBallBean) {
        this.a.setText(controlBallBean.getProgress() + "%");
        this.b.e(controlBallBean);
    }

    public void setListener(b bVar) {
        this.c = bVar;
    }

    public MultiTradPercentSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_multi_trad_percent_seekbar, (ViewGroup) null);
        this.a = (TextView) viewInflate.findViewById(R.id.multi_seekbar_precent_pro);
        this.b = (MultiTradSeekBar) viewInflate.findViewById(R.id.multi_seekbar_precent_seekbar);
        addView(viewInflate);
        this.b.setListener(new a());
    }
}
