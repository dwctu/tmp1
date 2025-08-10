package com.wear.ui.home.pattern.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.yydcdut.sdlv.SlideAndDragListView;

/* loaded from: classes3.dex */
public class MyPatternsFragment_ViewBinding implements Unbinder {
    public MyPatternsFragment a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ MyPatternsFragment a;

        public a(MyPatternsFragment_ViewBinding myPatternsFragment_ViewBinding, MyPatternsFragment myPatternsFragment) {
            this.a = myPatternsFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ MyPatternsFragment a;

        public b(MyPatternsFragment_ViewBinding myPatternsFragment_ViewBinding, MyPatternsFragment myPatternsFragment) {
            this.a = myPatternsFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ MyPatternsFragment a;

        public c(MyPatternsFragment_ViewBinding myPatternsFragment_ViewBinding, MyPatternsFragment myPatternsFragment) {
            this.a = myPatternsFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ MyPatternsFragment a;

        public d(MyPatternsFragment_ViewBinding myPatternsFragment_ViewBinding, MyPatternsFragment myPatternsFragment) {
            this.a = myPatternsFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ MyPatternsFragment a;

        public e(MyPatternsFragment_ViewBinding myPatternsFragment_ViewBinding, MyPatternsFragment myPatternsFragment) {
            this.a = myPatternsFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ MyPatternsFragment a;

        public f(MyPatternsFragment_ViewBinding myPatternsFragment_ViewBinding, MyPatternsFragment myPatternsFragment) {
            this.a = myPatternsFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public MyPatternsFragment_ViewBinding(MyPatternsFragment myPatternsFragment, View view) {
        this.a = myPatternsFragment;
        myPatternsFragment.createPatternPlayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.create_pattern_playout, "field 'createPatternPlayout'", LinearLayout.class);
        myPatternsFragment.pattern_list = (SlideAndDragListView) Utils.findRequiredViewAsType(view, R.id.pattern_data_list, "field 'pattern_list'", SlideAndDragListView.class);
        myPatternsFragment.patternListEmpty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.pattern_list_empty, "field 'patternListEmpty'", LinearLayout.class);
        myPatternsFragment.create_tv_text = (TextView) Utils.findRequiredViewAsType(view, R.id.create_tv_text, "field 'create_tv_text'", TextView.class);
        myPatternsFragment.list_empty_notice = (TextView) Utils.findRequiredViewAsType(view, R.id.list_empty_notice, "field 'list_empty_notice'", TextView.class);
        myPatternsFragment.ivPresetPulseSelected = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_preset_pulse_selected, "field 'ivPresetPulseSelected'", ImageView.class);
        myPatternsFragment.rlPresetPulse = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_preset_pulse, "field 'rlPresetPulse'", RelativeLayout.class);
        myPatternsFragment.patternsPresetPulse = (TextView) Utils.findRequiredViewAsType(view, R.id.patterns_preset_pulse, "field 'patternsPresetPulse'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_pulse_layout, "field 'llPulseLayout' and method 'onViewClicked'");
        myPatternsFragment.llPulseLayout = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.ll_pulse_layout, "field 'llPulseLayout'", LinearLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, myPatternsFragment));
        myPatternsFragment.ivPresetWaveSelected = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_preset_wave_selected, "field 'ivPresetWaveSelected'", ImageView.class);
        myPatternsFragment.rlPresetWave = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_preset_wave, "field 'rlPresetWave'", RelativeLayout.class);
        myPatternsFragment.patternsPresetWave = (TextView) Utils.findRequiredViewAsType(view, R.id.patterns_preset_wave, "field 'patternsPresetWave'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_wave_layout, "field 'llWaveLayout' and method 'onViewClicked'");
        myPatternsFragment.llWaveLayout = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.ll_wave_layout, "field 'llWaveLayout'", LinearLayout.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, myPatternsFragment));
        myPatternsFragment.ivPresetFireworksSelected = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_preset_fireworks_selected, "field 'ivPresetFireworksSelected'", ImageView.class);
        myPatternsFragment.rlPresetFireworks = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_preset_fireworks, "field 'rlPresetFireworks'", RelativeLayout.class);
        myPatternsFragment.patternsPresetFireworks = (TextView) Utils.findRequiredViewAsType(view, R.id.patterns_preset_fireworks, "field 'patternsPresetFireworks'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_fireworks_layout, "field 'llFireworksLayout' and method 'onViewClicked'");
        myPatternsFragment.llFireworksLayout = (LinearLayout) Utils.castView(viewFindRequiredView3, R.id.ll_fireworks_layout, "field 'llFireworksLayout'", LinearLayout.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, myPatternsFragment));
        myPatternsFragment.ivPresetEarthquakeSelected = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_preset_earthquake_selected, "field 'ivPresetEarthquakeSelected'", ImageView.class);
        myPatternsFragment.rlPresetEarthquake = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_preset_earthquake, "field 'rlPresetEarthquake'", RelativeLayout.class);
        myPatternsFragment.patternsPresetEarthquake = (TextView) Utils.findRequiredViewAsType(view, R.id.patterns_preset_earthquake, "field 'patternsPresetEarthquake'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_earthquake_layout, "field 'llEarthquakeLayout' and method 'onViewClicked'");
        myPatternsFragment.llEarthquakeLayout = (LinearLayout) Utils.castView(viewFindRequiredView4, R.id.ll_earthquake_layout, "field 'llEarthquakeLayout'", LinearLayout.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, myPatternsFragment));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.create_pattern, "field 'createPattern' and method 'onViewClicked'");
        myPatternsFragment.createPattern = (LinearLayout) Utils.castView(viewFindRequiredView5, R.id.create_pattern, "field 'createPattern'", LinearLayout.class);
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, myPatternsFragment));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.create_pattern_image, "field 'createPatternImage' and method 'onViewClicked'");
        myPatternsFragment.createPatternImage = (ImageView) Utils.castView(viewFindRequiredView6, R.id.create_pattern_image, "field 'createPatternImage'", ImageView.class);
        this.g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, myPatternsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MyPatternsFragment myPatternsFragment = this.a;
        if (myPatternsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        myPatternsFragment.createPatternPlayout = null;
        myPatternsFragment.pattern_list = null;
        myPatternsFragment.patternListEmpty = null;
        myPatternsFragment.create_tv_text = null;
        myPatternsFragment.list_empty_notice = null;
        myPatternsFragment.ivPresetPulseSelected = null;
        myPatternsFragment.rlPresetPulse = null;
        myPatternsFragment.patternsPresetPulse = null;
        myPatternsFragment.llPulseLayout = null;
        myPatternsFragment.ivPresetWaveSelected = null;
        myPatternsFragment.rlPresetWave = null;
        myPatternsFragment.patternsPresetWave = null;
        myPatternsFragment.llWaveLayout = null;
        myPatternsFragment.ivPresetFireworksSelected = null;
        myPatternsFragment.rlPresetFireworks = null;
        myPatternsFragment.patternsPresetFireworks = null;
        myPatternsFragment.llFireworksLayout = null;
        myPatternsFragment.ivPresetEarthquakeSelected = null;
        myPatternsFragment.rlPresetEarthquake = null;
        myPatternsFragment.patternsPresetEarthquake = null;
        myPatternsFragment.llEarthquakeLayout = null;
        myPatternsFragment.createPattern = null;
        myPatternsFragment.createPatternImage = null;
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
    }
}
