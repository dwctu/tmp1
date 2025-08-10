package com.wear.main.toy;

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
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import com.yydcdut.sdlv.SlideAndDragListView;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public class ToyProgramActivity_ViewBinding implements Unbinder {
    public ToyProgramActivity a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ToyProgramActivity a;

        public a(ToyProgramActivity_ViewBinding toyProgramActivity_ViewBinding, ToyProgramActivity toyProgramActivity) {
            this.a = toyProgramActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ToyProgramActivity a;

        public b(ToyProgramActivity_ViewBinding toyProgramActivity_ViewBinding, ToyProgramActivity toyProgramActivity) {
            this.a = toyProgramActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ToyProgramActivity a;

        public c(ToyProgramActivity_ViewBinding toyProgramActivity_ViewBinding, ToyProgramActivity toyProgramActivity) {
            this.a = toyProgramActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ToyProgramActivity_ViewBinding(ToyProgramActivity toyProgramActivity, View view) {
        this.a = toyProgramActivity;
        toyProgramActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        toyProgramActivity.toyImg = (CircleImageView) Utils.findRequiredViewAsType(view, R.id.toy_img, "field 'toyImg'", CircleImageView.class);
        toyProgramActivity.toyName = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_name, "field 'toyName'", TextView.class);
        toyProgramActivity.toyBatteryImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.toy_battery_img, "field 'toyBatteryImg'", ImageView.class);
        toyProgramActivity.toyStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_status, "field 'toyStatus'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.setting_change_levels, "field 'settingChangeLevels' and method 'onClick'");
        toyProgramActivity.settingChangeLevels = (RelativeLayout) Utils.castView(viewFindRequiredView, R.id.setting_change_levels, "field 'settingChangeLevels'", RelativeLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, toyProgramActivity));
        toyProgramActivity.createTvTextHint = (TextView) Utils.findRequiredViewAsType(view, R.id.create_tv_text_hint, "field 'createTvTextHint'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.pattern_list_to_add, "field 'patternListToAdd' and method 'onClick'");
        toyProgramActivity.patternListToAdd = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.pattern_list_to_add, "field 'patternListToAdd'", LinearLayout.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, toyProgramActivity));
        toyProgramActivity.patternList = (SlideAndDragListView) Utils.findRequiredViewAsType(view, R.id.pattern_list, "field 'patternList'", SlideAndDragListView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.pattern_list_empty_to_add, "field 'patternListEmptyToAdd' and method 'onClick'");
        toyProgramActivity.patternListEmptyToAdd = (LinearLayout) Utils.castView(viewFindRequiredView3, R.id.pattern_list_empty_to_add, "field 'patternListEmptyToAdd'", LinearLayout.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, toyProgramActivity));
        toyProgramActivity.patternListEmpty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.pattern_list_empty, "field 'patternListEmpty'", LinearLayout.class);
        toyProgramActivity.settingLightsSwith = (SwitchView) Utils.findRequiredViewAsType(view, R.id.setting_lights_swith, "field 'settingLightsSwith'", SwitchView.class);
        toyProgramActivity.settingChangeLightsLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.setting_change_lights_layout, "field 'settingChangeLightsLayout'", LinearLayout.class);
        toyProgramActivity.loadingLayer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.loading_layer, "field 'loadingLayer'", LinearLayout.class);
        toyProgramActivity.loadingSetLevel = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.loading_set_level, "field 'loadingSetLevel'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ToyProgramActivity toyProgramActivity = this.a;
        if (toyProgramActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        toyProgramActivity.actionbar = null;
        toyProgramActivity.toyImg = null;
        toyProgramActivity.toyName = null;
        toyProgramActivity.toyBatteryImg = null;
        toyProgramActivity.toyStatus = null;
        toyProgramActivity.settingChangeLevels = null;
        toyProgramActivity.createTvTextHint = null;
        toyProgramActivity.patternListToAdd = null;
        toyProgramActivity.patternList = null;
        toyProgramActivity.patternListEmptyToAdd = null;
        toyProgramActivity.patternListEmpty = null;
        toyProgramActivity.settingLightsSwith = null;
        toyProgramActivity.settingChangeLightsLayout = null;
        toyProgramActivity.loadingLayer = null;
        toyProgramActivity.loadingSetLevel = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
