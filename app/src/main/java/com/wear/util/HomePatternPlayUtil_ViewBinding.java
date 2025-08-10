package com.wear.util;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.llong.CircularProgressView;

/* loaded from: classes4.dex */
public class HomePatternPlayUtil_ViewBinding implements Unbinder {
    public HomePatternPlayUtil a;

    @UiThread
    public HomePatternPlayUtil_ViewBinding(HomePatternPlayUtil homePatternPlayUtil, View view) {
        this.a = homePatternPlayUtil;
        homePatternPlayUtil.homePatternTitle = (MediumBoldTextView) Utils.findRequiredViewAsType(view, R.id.home_pattern_title, "field 'homePatternTitle'", MediumBoldTextView.class);
        homePatternPlayUtil.homePatternToyType1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_pattern_toy_type_1, "field 'homePatternToyType1'", ImageView.class);
        homePatternPlayUtil.homePatternToyType2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_pattern_toy_type_2, "field 'homePatternToyType2'", ImageView.class);
        homePatternPlayUtil.homePatternToyType3 = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_pattern_toy_type_3, "field 'homePatternToyType3'", ImageView.class);
        homePatternPlayUtil.homePatternLlType = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.home_pattern_ll_type, "field 'homePatternLlType'", LinearLayout.class);
        homePatternPlayUtil.homePatternPrevious = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_pattern_previous, "field 'homePatternPrevious'", ImageView.class);
        homePatternPlayUtil.homePatternPlay = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_pattern_play, "field 'homePatternPlay'", ImageView.class);
        homePatternPlayUtil.homePatternNext = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_pattern_next, "field 'homePatternNext'", ImageView.class);
        homePatternPlayUtil.homePatternCpv = (CircularProgressView) Utils.findRequiredViewAsType(view, R.id.home_pattern_cpv, "field 'homePatternCpv'", CircularProgressView.class);
        homePatternPlayUtil.llPatternPlay = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_pattern_play, "field 'llPatternPlay'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HomePatternPlayUtil homePatternPlayUtil = this.a;
        if (homePatternPlayUtil == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        homePatternPlayUtil.homePatternTitle = null;
        homePatternPlayUtil.homePatternToyType1 = null;
        homePatternPlayUtil.homePatternToyType2 = null;
        homePatternPlayUtil.homePatternToyType3 = null;
        homePatternPlayUtil.homePatternLlType = null;
        homePatternPlayUtil.homePatternPrevious = null;
        homePatternPlayUtil.homePatternPlay = null;
        homePatternPlayUtil.homePatternNext = null;
        homePatternPlayUtil.homePatternCpv = null;
        homePatternPlayUtil.llPatternPlay = null;
    }
}
