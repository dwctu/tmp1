package com.wear.widget.control.multiToys;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class MultiBallControlPanel_ViewBinding implements Unbinder {
    public MultiBallControlPanel a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ MultiBallControlPanel a;

        public a(MultiBallControlPanel_ViewBinding multiBallControlPanel_ViewBinding, MultiBallControlPanel multiBallControlPanel) {
            this.a = multiBallControlPanel;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ MultiBallControlPanel a;

        public b(MultiBallControlPanel_ViewBinding multiBallControlPanel_ViewBinding, MultiBallControlPanel multiBallControlPanel) {
            this.a = multiBallControlPanel;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ MultiBallControlPanel a;

        public c(MultiBallControlPanel_ViewBinding multiBallControlPanel_ViewBinding, MultiBallControlPanel multiBallControlPanel) {
            this.a = multiBallControlPanel;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ MultiBallControlPanel a;

        public d(MultiBallControlPanel_ViewBinding multiBallControlPanel_ViewBinding, MultiBallControlPanel multiBallControlPanel) {
            this.a = multiBallControlPanel;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ MultiBallControlPanel a;

        public e(MultiBallControlPanel_ViewBinding multiBallControlPanel_ViewBinding, MultiBallControlPanel multiBallControlPanel) {
            this.a = multiBallControlPanel;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ MultiBallControlPanel a;

        public f(MultiBallControlPanel_ViewBinding multiBallControlPanel_ViewBinding, MultiBallControlPanel multiBallControlPanel) {
            this.a = multiBallControlPanel;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ MultiBallControlPanel a;

        public g(MultiBallControlPanel_ViewBinding multiBallControlPanel_ViewBinding, MultiBallControlPanel multiBallControlPanel) {
            this.a = multiBallControlPanel;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ MultiBallControlPanel a;

        public h(MultiBallControlPanel_ViewBinding multiBallControlPanel_ViewBinding, MultiBallControlPanel multiBallControlPanel) {
            this.a = multiBallControlPanel;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class i extends DebouncingOnClickListener {
        public final /* synthetic */ MultiBallControlPanel a;

        public i(MultiBallControlPanel_ViewBinding multiBallControlPanel_ViewBinding, MultiBallControlPanel multiBallControlPanel) {
            this.a = multiBallControlPanel;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public MultiBallControlPanel_ViewBinding(MultiBallControlPanel multiBallControlPanel, View view) {
        this.a = multiBallControlPanel;
        multiBallControlPanel.parentLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.control_panel_parent, "field 'parentLayout'", ConstraintLayout.class);
        multiBallControlPanel.ivMarker = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_marker, "field 'ivMarker'", ImageView.class);
        multiBallControlPanel.tvMarker100 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_marker_100, "field 'tvMarker100'", TextView.class);
        multiBallControlPanel.tvMarker0 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_marker_0, "field 'tvMarker0'", TextView.class);
        multiBallControlPanel.flControlPanel = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_control_panel, "field 'flControlPanel'", FrameLayout.class);
        multiBallControlPanel.guideLinePanel = (MultiBallGuideLinePanel) Utils.findRequiredViewAsType(view, R.id.guide_line_panel, "field 'guideLinePanel'", MultiBallGuideLinePanel.class);
        multiBallControlPanel.flExpandPanel = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_expand_panel, "field 'flExpandPanel'", FrameLayout.class);
        multiBallControlPanel.llControlModeChoosePanel = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_control_mode_layout_choose, "field 'llControlModeChoosePanel'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_control_mode_loop, "field 'llControlModeLoop' and method 'onClick'");
        multiBallControlPanel.llControlModeLoop = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.ll_control_mode_loop, "field 'llControlModeLoop'", LinearLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, multiBallControlPanel));
        multiBallControlPanel.ivControlModeLoop = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_control_mode_loop, "field 'ivControlModeLoop'", ImageView.class);
        multiBallControlPanel.tvControlModeLoop = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_mode_loop, "field 'tvControlModeLoop'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_control_mode_float, "field 'llControlModeFloat' and method 'onClick'");
        multiBallControlPanel.llControlModeFloat = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.ll_control_mode_float, "field 'llControlModeFloat'", LinearLayout.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, multiBallControlPanel));
        multiBallControlPanel.ivControlModeFloat = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_control_mode_float, "field 'ivControlModeFloat'", ImageView.class);
        multiBallControlPanel.tvControlModeFloat = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_mode_float, "field 'tvControlModeFloat'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_control_mode_traditional_panel, "field 'llControlModeTraditionalPanel' and method 'onClick'");
        multiBallControlPanel.llControlModeTraditionalPanel = (LinearLayout) Utils.castView(viewFindRequiredView3, R.id.ll_control_mode_traditional_panel, "field 'llControlModeTraditionalPanel'", LinearLayout.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, multiBallControlPanel));
        multiBallControlPanel.ivControlModeTrad = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_control_mode_traditional_panel, "field 'ivControlModeTrad'", ImageView.class);
        multiBallControlPanel.tvControlModeTrad = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_mode_traditional_panel, "field 'tvControlModeTrad'", TextView.class);
        multiBallControlPanel.tvControlModeFysPanel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_mode_fys_panel, "field 'tvControlModeFysPanel'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_control_mode_fys_panel, "field 'llControlModeFysPanel' and method 'onClick'");
        multiBallControlPanel.llControlModeFysPanel = (LinearLayout) Utils.castView(viewFindRequiredView4, R.id.ll_control_mode_fys_panel, "field 'llControlModeFysPanel'", LinearLayout.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, multiBallControlPanel));
        multiBallControlPanel.traditionalPanelLayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_control_trad_panel, "field 'traditionalPanelLayout'", FrameLayout.class);
        multiBallControlPanel.traditionalPanel = (MultiBallTraditionalPanel) Utils.findRequiredViewAsType(view, R.id.multi_ball_control_trad_panel, "field 'traditionalPanel'", MultiBallTraditionalPanel.class);
        multiBallControlPanel.flControlFysPanel = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_control_fys_panel, "field 'flControlFysPanel'", FrameLayout.class);
        multiBallControlPanel.multiControlFysPanel = (MultiFysControlPanel) Utils.findRequiredViewAsType(view, R.id.multi_control_fys_panel, "field 'multiControlFysPanel'", MultiFysControlPanel.class);
        multiBallControlPanel.ivControlModeFysPanel = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_control_mode_fys_panel, "field 'ivControlModeFysPanel'", ImageView.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.ll_control_mode_slide, "field 'llSlide' and method 'onClick'");
        multiBallControlPanel.llSlide = (LinearLayout) Utils.castView(viewFindRequiredView5, R.id.ll_control_mode_slide, "field 'llSlide'", LinearLayout.class);
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, multiBallControlPanel));
        multiBallControlPanel.ivControlModeSlide = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_control_mode_slide, "field 'ivControlModeSlide'", ImageView.class);
        multiBallControlPanel.tvControlModeSlide = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_mode_slide, "field 'tvControlModeSlide'", TextView.class);
        multiBallControlPanel.llTraditionalChoose = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_control_mode_traditional_choose_panel, "field 'llTraditionalChoose'", LinearLayout.class);
        multiBallControlPanel.ivTraditionalChoose = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_control_mode_traditional_choose_panel, "field 'ivTraditionalChoose'", ImageView.class);
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.ll_control_mode_controlling_panel, "field 'llControlling' and method 'onClick'");
        multiBallControlPanel.llControlling = (LinearLayout) Utils.castView(viewFindRequiredView6, R.id.ll_control_mode_controlling_panel, "field 'llControlling'", LinearLayout.class);
        this.g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, multiBallControlPanel));
        multiBallControlPanel.tvControlling = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_mode_controlling_panel, "field 'tvControlling'", TextView.class);
        multiBallControlPanel.ivControlling = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_control_mode_controlling_panel, "field 'ivControlling'", ImageView.class);
        multiBallControlPanel.llControlEnd = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_control_mode_end_panel, "field 'llControlEnd'", LinearLayout.class);
        multiBallControlPanel.tvControlTimer = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_mode_chat_end_timer, "field 'tvControlTimer'", TextView.class);
        multiBallControlPanel.llControlEndShow = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_control_mode_endvis_panel, "field 'llControlEndShow'", LinearLayout.class);
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.iv_control_mode_chat_end, "field 'ivControlEnd' and method 'onClick'");
        multiBallControlPanel.ivControlEnd = (ImageView) Utils.castView(viewFindRequiredView7, R.id.iv_control_mode_chat_end, "field 'ivControlEnd'", ImageView.class);
        this.h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(this, multiBallControlPanel));
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.iv_control_mode_chat_endvis, "field 'ivControlTimer' and method 'onClick'");
        multiBallControlPanel.ivControlTimer = (ImageView) Utils.castView(viewFindRequiredView8, R.id.iv_control_mode_chat_endvis, "field 'ivControlTimer'", ImageView.class);
        this.i = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new h(this, multiBallControlPanel));
        multiBallControlPanel.tvControlVisTimer = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_mode_chat_endvis_timer, "field 'tvControlVisTimer'", TextView.class);
        multiBallControlPanel.bottomLine = Utils.findRequiredView(view, R.id.bottom_line, "field 'bottomLine'");
        multiBallControlPanel.rightLine = Utils.findRequiredView(view, R.id.right_line, "field 'rightLine'");
        multiBallControlPanel.ivControlModeFysChoosePanel = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_control_mode_fys_choose_panel, "field 'ivControlModeFysChoosePanel'", ImageView.class);
        multiBallControlPanel.tvControlModeFysChoosePanel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_mode_fys_choose_panel, "field 'tvControlModeFysChoosePanel'", TextView.class);
        multiBallControlPanel.llControlModeFysChoosePanel = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_control_mode_fys_choose_panel, "field 'llControlModeFysChoosePanel'", LinearLayout.class);
        multiBallControlPanel.llTimer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_timer, "field 'llTimer'", LinearLayout.class);
        multiBallControlPanel.tvTimer = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_timer, "field 'tvTimer'", TextView.class);
        multiBallControlPanel.multiVelvoPanel = (MultiVelvoPanel) Utils.findRequiredViewAsType(view, R.id.multi_solace_panel, "field 'multiVelvoPanel'", MultiVelvoPanel.class);
        View viewFindRequiredView9 = Utils.findRequiredView(view, R.id.iv_control_mode_chat_endvis_show, "method 'onClick'");
        this.j = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new i(this, multiBallControlPanel));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MultiBallControlPanel multiBallControlPanel = this.a;
        if (multiBallControlPanel == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        multiBallControlPanel.parentLayout = null;
        multiBallControlPanel.ivMarker = null;
        multiBallControlPanel.tvMarker100 = null;
        multiBallControlPanel.tvMarker0 = null;
        multiBallControlPanel.flControlPanel = null;
        multiBallControlPanel.guideLinePanel = null;
        multiBallControlPanel.flExpandPanel = null;
        multiBallControlPanel.llControlModeChoosePanel = null;
        multiBallControlPanel.llControlModeLoop = null;
        multiBallControlPanel.ivControlModeLoop = null;
        multiBallControlPanel.tvControlModeLoop = null;
        multiBallControlPanel.llControlModeFloat = null;
        multiBallControlPanel.ivControlModeFloat = null;
        multiBallControlPanel.tvControlModeFloat = null;
        multiBallControlPanel.llControlModeTraditionalPanel = null;
        multiBallControlPanel.ivControlModeTrad = null;
        multiBallControlPanel.tvControlModeTrad = null;
        multiBallControlPanel.tvControlModeFysPanel = null;
        multiBallControlPanel.llControlModeFysPanel = null;
        multiBallControlPanel.traditionalPanelLayout = null;
        multiBallControlPanel.traditionalPanel = null;
        multiBallControlPanel.flControlFysPanel = null;
        multiBallControlPanel.multiControlFysPanel = null;
        multiBallControlPanel.ivControlModeFysPanel = null;
        multiBallControlPanel.llSlide = null;
        multiBallControlPanel.ivControlModeSlide = null;
        multiBallControlPanel.tvControlModeSlide = null;
        multiBallControlPanel.llTraditionalChoose = null;
        multiBallControlPanel.ivTraditionalChoose = null;
        multiBallControlPanel.llControlling = null;
        multiBallControlPanel.tvControlling = null;
        multiBallControlPanel.ivControlling = null;
        multiBallControlPanel.llControlEnd = null;
        multiBallControlPanel.tvControlTimer = null;
        multiBallControlPanel.llControlEndShow = null;
        multiBallControlPanel.ivControlEnd = null;
        multiBallControlPanel.ivControlTimer = null;
        multiBallControlPanel.tvControlVisTimer = null;
        multiBallControlPanel.bottomLine = null;
        multiBallControlPanel.rightLine = null;
        multiBallControlPanel.ivControlModeFysChoosePanel = null;
        multiBallControlPanel.tvControlModeFysChoosePanel = null;
        multiBallControlPanel.llControlModeFysChoosePanel = null;
        multiBallControlPanel.llTimer = null;
        multiBallControlPanel.tvTimer = null;
        multiBallControlPanel.multiVelvoPanel = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
        this.g.setOnClickListener(null);
        this.g = null;
        this.h.setOnClickListener(null);
        this.h = null;
        this.i.setOnClickListener(null);
        this.i = null;
        this.j.setOnClickListener(null);
        this.j = null;
    }
}
