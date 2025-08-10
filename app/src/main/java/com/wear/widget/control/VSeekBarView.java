package com.wear.widget.control;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.bean.AnalyticsBean;
import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.th4;
import dc.vi1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes4.dex */
public class VSeekBarView extends LinearLayout {
    public LayoutInflater a;
    public List<VSeekBarView> b;
    public VSeekBarView c;
    public VerticalSeekBar d;
    public TextView e;
    public ImageView f;
    public String g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public Timer l;
    public d m;
    public int n;
    public Handler o;
    public int p;
    public Context q;

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 153) {
                return;
            }
            int i = message.arg1;
            if (VSeekBarView.this.j) {
                return;
            }
            VSeekBarView vSeekBarView = VSeekBarView.this;
            if (vSeekBarView.m != null) {
                vSeekBarView.k();
            }
        }
    }

    public class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            int i2 = i > 0 ? 1 : 0;
            if (i >= 25) {
                i2 = 25;
            }
            if (i >= 50) {
                i2 = 50;
            }
            if (i >= 75) {
                i2 = 75;
            }
            if (i >= 90) {
                i2 = 90;
            }
            if (i >= 100) {
                i2 = 100;
            }
            VSeekBarView vSeekBarView = VSeekBarView.this;
            if (i2 != vSeekBarView.n) {
                vSeekBarView.n = i2;
                Message message = new Message();
                message.what = 153;
                VSeekBarView vSeekBarView2 = VSeekBarView.this;
                message.arg1 = vSeekBarView2.n;
                vSeekBarView2.o.sendMessage(message);
                MyApplication myApplication = WearUtils.x;
                AnalyticsBean analyticsBean = myApplication.r;
                if (analyticsBean == null || !analyticsBean.usedSliderPannel) {
                    return;
                }
                analyticsBean.usedSliderPannel = false;
                myApplication.q(analyticsBean.getEvenString(), null);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public class c extends TimerTask {
        public c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (VSeekBarView.this.i) {
                return;
            }
            VSeekBarView.this.k();
        }
    }

    public interface d {
        void a(String str, String str2, String str3, boolean z);
    }

    public VSeekBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new ArrayList();
        this.d = null;
        this.g = "";
        this.h = "";
        this.i = true;
        this.j = false;
        this.k = 0;
        this.m = null;
        this.n = 0;
        this.p = 0;
        f(context, attributeSet);
    }

    public void e(VSeekBarView vSeekBarView) {
        List<VSeekBarView> list = this.b;
        if (list == null || list.contains(vSeekBarView)) {
            return;
        }
        this.b.add(vSeekBarView);
    }

    public final void f(Context context, AttributeSet attributeSet) {
        this.q = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a = layoutInflater;
        View viewInflate = layoutInflater.inflate(R.layout.layout_v_seekbar, (ViewGroup) null);
        this.d = (VerticalSeekBar) viewInflate.findViewById(R.id.vseekBar);
        this.e = (TextView) viewInflate.findViewById(R.id.label_title);
        this.f = (ImageView) viewInflate.findViewById(R.id.label_image);
        addView(viewInflate);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.VSeekBarViewStyle);
        this.p = typedArrayObtainStyledAttributes.getInt(0, 0);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(1, false);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            this.e.setText(ah4.e(resourceId));
        } else {
            this.e.setText(typedArrayObtainStyledAttributes.getString(2));
        }
        if (z) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
        if (this.p == 0) {
            this.d.setProgressDrawable(context.getResources().getDrawable(R.drawable.v_seekbar_progress_left));
            this.d.setThumb(context.getResources().getDrawable(R.drawable.v_seekbar_thumb_left));
        } else {
            this.d.setProgressDrawable(context.getResources().getDrawable(R.drawable.v_seekbar_progress_right));
            this.d.setThumb(context.getResources().getDrawable(R.drawable.v_seekbar_thumb_right));
        }
        this.o = new a();
        this.d.setOnSeekBarChangeListener(new b());
        this.b.clear();
        this.b.add(this);
    }

    public void g(int i) {
        List<VSeekBarView> list = this.b;
        if (list == null || list.size() <= 0 || this.b.get(0) == null || this.b.get(0).d == null) {
            return;
        }
        this.b.get(0).d.e(i);
    }

    public ImageView getLableImage() {
        return this.f;
    }

    public String getSeekBarsTags() {
        List<VSeekBarView> list = this.b;
        String str = "";
        if (list != null && list.size() > 0) {
            for (VSeekBarView vSeekBarView : this.b) {
                if (vSeekBarView.d.getTag() != null && !WearUtils.e1(vSeekBarView.d.getTag().toString())) {
                    str = str + vSeekBarView.d.getTag().toString() + TouchControlView.O;
                }
            }
        }
        return str.endsWith(TouchControlView.O) ? str.substring(0, str.length() - 1) : str;
    }

    public boolean h() {
        boolean z;
        Iterator<VSeekBarView> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().d.b) {
                z = true;
                break;
            }
        }
        if (z || !this.c.d.b) {
            return z;
        }
        return true;
    }

    public void i() {
        Timer timer = this.l;
        if (timer != null) {
            timer.cancel();
        }
        this.l = null;
    }

    public void j() {
        VerticalSeekBar verticalSeekBar = this.d;
        if (verticalSeekBar != null) {
            verticalSeekBar.setTag(null);
        }
    }

    public final synchronized void k() {
        VerticalSeekBar verticalSeekBar;
        List<VSeekBarView> list = this.b;
        if (list != null) {
            this.g = "";
            this.h = "";
            for (VSeekBarView vSeekBarView : list) {
                if (vSeekBarView != null && (verticalSeekBar = vSeekBarView.d) != null && verticalSeekBar.getTag() != null && !WearUtils.e1(vSeekBarView.d.getTag().toString())) {
                    int progress = vSeekBarView.d.getProgress();
                    this.k = progress;
                    if (progress > 100) {
                        this.k = 100;
                    }
                    this.g += this.k + TouchControlView.O;
                }
            }
            if (this.m != null) {
                if (this.g.endsWith(TouchControlView.O)) {
                    this.g = this.g.substring(0, r0.length() - 1);
                }
                if (this.c.d.getTag() != null && !WearUtils.e1(this.c.d.getTag().toString())) {
                    int progress2 = this.c.d.getProgress();
                    this.k = progress2;
                    if (progress2 > 100) {
                        this.k = 100;
                    }
                    this.h = this.c.d.getTag().toString() + TouchControlView.N + this.k;
                }
                this.m.a(getSeekBarsTags(), this.g, this.h, h());
            }
        }
    }

    public void setChangeListener(boolean z, d dVar) {
        this.j = z;
        this.m = dVar;
        if (z) {
            Timer timer = new Timer();
            this.l = timer;
            timer.scheduleAtFixedRate(new c(), 1000L, 100L);
        }
    }

    public void setExpansionVseekBar(VSeekBarView vSeekBarView) {
        this.c = vSeekBarView;
    }

    public void setPause(boolean z) {
        if (this.d.getTag() == null || WearUtils.e1(this.d.getTag().toString())) {
            return;
        }
        this.i = z;
    }

    public void setProgress(int i) {
        List<VSeekBarView> list = this.b;
        if (list == null || list.size() <= 0 || this.b.get(0) == null || this.b.get(0).d == null) {
            return;
        }
        this.b.get(0).d.setProgress(i);
    }

    public void setVSeekBar(String str, String str2, int i) {
        Toy.getCurveLineColor(str);
        VerticalSeekBar verticalSeekBar = this.d;
        if (verticalSeekBar != null) {
            verticalSeekBar.setTag(str);
            this.d.setThumb(this.q.getResources().getDrawable(Toy.getSeekbarThumb(str)));
            this.d.setProgressDrawable(th4.d(this.q, Toy.getSeekbarProgress(str)));
            this.d.e(0);
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(str2);
        }
    }
}
