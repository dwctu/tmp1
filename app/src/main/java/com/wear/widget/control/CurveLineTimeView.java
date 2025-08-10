package com.wear.widget.control;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes4.dex */
public class CurveLineTimeView extends RelativeLayout {
    public LayoutInflater a;
    public CurveLineView b;
    public TextView c;
    public TextView d;
    public Handler e;
    public Timer f;
    public int g;
    public boolean h;
    public c i;
    public String j;

    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (CurveLineTimeView.this.h) {
                return;
            }
            CurveLineTimeView.d(CurveLineTimeView.this);
            if (CurveLineTimeView.this.g >= 2147483646) {
                CurveLineTimeView.this.g = 0;
            }
            CurveLineTimeView.this.e.sendEmptyMessage(18);
        }
    }

    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 18) {
                return;
            }
            CurveLineTimeView.this.c.setText(WearUtils.Q(r4.g));
            if (CurveLineTimeView.this.i != null) {
                CurveLineTimeView.this.i.a(CurveLineTimeView.this.c.getText().toString());
            }
        }
    }

    public interface c {
        void a(String str);
    }

    public CurveLineTimeView(Context context) {
        super(context);
        this.h = true;
        g(context);
    }

    public static /* synthetic */ int d(CurveLineTimeView curveLineTimeView) {
        int i = curveLineTimeView.g;
        curveLineTimeView.g = i + 1;
        return i;
    }

    public final void g(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a = layoutInflater;
        View viewInflate = layoutInflater.inflate(R.layout.layout_curveline_time, (ViewGroup) null);
        addView(viewInflate);
        this.b = (CurveLineView) viewInflate.findViewById(R.id.curveline);
        this.c = (TextView) viewInflate.findViewById(R.id.timer);
        this.d = (TextView) viewInflate.findViewById(R.id.toy_name);
        Timer timer = new Timer();
        this.f = timer;
        timer.scheduleAtFixedRate(new a(), 1000L, 1000L);
        this.e = new b();
        this.d.setText("");
    }

    public CurveLineView getCurveLine() {
        return this.b;
    }

    public String getDeviceId() {
        return this.j;
    }

    public int getTime() {
        return this.g;
    }

    public void h() {
        Timer timer = this.f;
        if (timer != null) {
            timer.cancel();
        }
        this.f = null;
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void i() {
        this.g = 0;
        this.b.a();
    }

    public void setDeviceId(String str) {
        this.j = str;
    }

    public void setPause(boolean z) {
        this.h = z;
    }

    public void setTimeCallBack(c cVar) {
        this.i = cVar;
    }

    public void setTimeColor(Integer num) {
        this.c.setTextColor(num == null ? getResources().getColor(R.color.buttom_select_background) : getResources().getColor(num.intValue()));
    }

    public void setToyName(String str) {
        this.d.setText(str);
    }

    public void setToyNameColor(Integer num) {
        this.d.setTextColor(num == null ? getResources().getColor(R.color.buttom_select_background) : getResources().getColor(num.intValue()));
    }

    public void setTvTimeVisibility(int i) {
        this.c.setVisibility(i);
    }

    public CurveLineTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = true;
        g(context);
    }

    public CurveLineTimeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = true;
        g(context);
    }
}
