package com.wear.widget.control;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.bean.AnalyticsBean;
import com.wear.main.closeRange.RemoteControlActivity;
import com.wear.ui.home.remote.RemoteControl;
import com.wear.util.WearUtils;
import dc.th4;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class TouchControlVerticalBarView extends RelativeLayout implements View.OnClickListener {
    public LayoutInflater a;
    public RelativeLayout b;
    public View c;
    public TextView d;
    public LinearLayout e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public LinearLayout l;
    public TextView m;
    public int n;
    public a o;
    public List<TouchControlView> p;

    public interface a {
        void a(int i);

        void b(int i);

        void c();
    }

    public TouchControlVerticalBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = new ArrayList();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a = layoutInflater;
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.touch_control_vertical_layout, (ViewGroup) null);
        this.b = relativeLayout;
        this.c = relativeLayout.findViewById(R.id.vertical_end_control);
        TextView textView = (TextView) this.b.findViewById(R.id.tv_end_control);
        this.d = textView;
        textView.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.c.setVisibility(8);
        this.e = (LinearLayout) this.b.findViewById(R.id.vertical_works_3);
        this.f = (ImageView) this.b.findViewById(R.id.vertical_btn_loop);
        this.g = (ImageView) this.b.findViewById(R.id.vertical_btn_float);
        this.h = (ImageView) this.b.findViewById(R.id.vertical_btn_manual);
        this.i = (TextView) this.b.findViewById(R.id.vertical_tv_loop);
        this.j = (TextView) this.b.findViewById(R.id.vertical_tv_float);
        this.k = (TextView) this.b.findViewById(R.id.vertical_tv_manual);
        this.m = (TextView) this.b.findViewById(R.id.vertical_tv_live);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.l = (LinearLayout) this.b.findViewById(R.id.vertical_works_2);
        this.b.findViewById(R.id.vertical_btn_live).setOnClickListener(this);
        addView(this.b);
        this.p.clear();
    }

    public void a() {
        this.p.clear();
    }

    public void b() {
        if (this.n == 2) {
            return;
        }
        this.g.performClick();
    }

    public void c() {
        this.f.performClick();
    }

    public void d() {
        this.h.performClick();
    }

    public void e(TouchControlView touchControlView) {
        this.p.add(touchControlView);
    }

    public void f(boolean z) {
        this.l.setVisibility(8);
        this.e.setVisibility(0);
        this.n = 0;
        g(0);
        if (z) {
            for (TouchControlView touchControlView : this.p) {
                if (touchControlView.getVisibility() == 0) {
                    touchControlView.getFicView().setPause(false);
                }
            }
        }
    }

    public final void g(int i) {
        if (i != R.id.vertical_btn_loop || this.n == 0) {
            this.f.setImageDrawable(th4.d(getContext(), R.drawable.chat_toolbar_loop));
            if (getContext() instanceof RemoteControlActivity) {
                this.i.setTextColor(th4.b(getContext(), R.color.remote_control_text_color));
            } else {
                this.i.setTextColor(th4.b(getContext(), R.color.chat_control_text_color));
            }
        } else {
            this.f.setImageDrawable(th4.d(getContext(), R.drawable.chat_toolbar_loop_click));
            if (getContext() instanceof RemoteControlActivity) {
                this.i.setTextColor(th4.b(getContext(), R.color.remote_control_text_select_color));
            } else {
                this.i.setTextColor(th4.b(getContext(), R.color.chat_control_text_select_color));
            }
        }
        if (i != R.id.vertical_btn_float || this.n == 0) {
            this.g.setImageDrawable(th4.d(getContext(), R.drawable.chat_toolbar_float));
            if (getContext() instanceof RemoteControlActivity) {
                this.j.setTextColor(th4.b(getContext(), R.color.remote_control_text_color));
            } else {
                this.j.setTextColor(th4.b(getContext(), R.color.chat_control_text_color));
            }
        } else {
            this.g.setImageDrawable(th4.d(getContext(), R.drawable.chat_toolbar_float_click));
            if (getContext() instanceof RemoteControlActivity) {
                this.j.setTextColor(th4.b(getContext(), R.color.remote_control_text_select_color));
            } else {
                this.j.setTextColor(th4.b(getContext(), R.color.chat_control_text_select_color));
            }
        }
        if (getContext() instanceof RemoteControlActivity) {
            this.k.setTextColor(th4.b(getContext(), R.color.remote_control_text_color));
        } else {
            this.k.setTextColor(th4.b(getContext(), R.color.chat_control_text_color));
        }
        if (this.m != null) {
            if (getContext() instanceof RemoteControlActivity) {
                this.m.setTextColor(th4.b(getContext(), R.color.remote_control_text_color));
            } else {
                this.m.setTextColor(th4.b(getContext(), R.color.chat_control_text_color));
            }
        }
        a aVar = this.o;
        if (aVar != null) {
            aVar.b(this.n);
        }
        for (TouchControlView touchControlView : this.p) {
            if (touchControlView.getVisibility() == 0) {
                if (i == 0) {
                    touchControlView.setControlLiveType();
                } else if (i != R.id.vertical_btn_float) {
                    switch (i) {
                        case R.id.vertical_btn_loop /* 2131365562 */:
                            touchControlView.setControlLoopType();
                            break;
                        case R.id.vertical_btn_manual /* 2131365563 */:
                            touchControlView.setControlManualType();
                            break;
                    }
                } else {
                    touchControlView.setControlFloatType();
                }
            }
        }
        a aVar2 = this.o;
        if (aVar2 != null) {
            aVar2.a(this.n);
        }
    }

    public int getControlType() {
        return this.n;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.tv_end_control) {
            if (id != R.id.vertical_tv_live) {
                switch (id) {
                    case R.id.vertical_btn_float /* 2131365560 */:
                        this.l.setVisibility(8);
                        this.e.setVisibility(0);
                        this.n = this.n != 2 ? 2 : 0;
                        g(view.getId());
                        RemoteControl.j().u(this.n);
                        break;
                    case R.id.vertical_btn_loop /* 2131365562 */:
                        this.l.setVisibility(8);
                        this.e.setVisibility(0);
                        this.n = this.n == 1 ? 0 : 1;
                        g(view.getId());
                        RemoteControl.j().u(this.n);
                        break;
                    case R.id.vertical_btn_manual /* 2131365563 */:
                        this.l.setVisibility(0);
                        this.e.setVisibility(8);
                        this.n = 3;
                        g(view.getId());
                        AnalyticsBean analyticsBean = WearUtils.x.r;
                        if (analyticsBean != null) {
                            analyticsBean.isSlider = true;
                        }
                        RemoteControl.j().u(this.n);
                        break;
                }
            }
            f(true);
            AnalyticsBean analyticsBean2 = WearUtils.x.r;
            if (analyticsBean2 != null) {
                analyticsBean2.isSlider = false;
                return;
            }
            return;
        }
        a aVar = this.o;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void setControlType(int i) {
        this.n = i;
        if (i == 1) {
            g(R.id.vertical_btn_loop);
        } else if (i == 2) {
            g(R.id.vertical_btn_float);
        } else {
            if (i != 3) {
                return;
            }
            g(R.id.vertical_btn_manual);
        }
    }

    public void setEndControlVisibility(int i) {
        this.c.setVisibility(i);
    }

    public void setListener(a aVar) {
        this.o = aVar;
    }

    public void setManualVisibility(int i) {
        this.b.findViewById(R.id.vertical_manual_layout).setVisibility(i);
    }
}
