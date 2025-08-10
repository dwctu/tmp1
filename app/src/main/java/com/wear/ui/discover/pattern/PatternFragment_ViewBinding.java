package com.wear.ui.discover.pattern;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldTextView;

/* loaded from: classes3.dex */
public class PatternFragment_ViewBinding implements Unbinder {
    public PatternFragment a;

    @UiThread
    public PatternFragment_ViewBinding(PatternFragment patternFragment, View view) {
        this.a = patternFragment;
        patternFragment.ivBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_back, "field 'ivBack'", ImageView.class);
        patternFragment.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        patternFragment.rlToy1 = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.rl_toy_1, "field 'rlToy1'", AppCompatTextView.class);
        patternFragment.rlToy2 = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.rl_toy_2, "field 'rlToy2'", AppCompatTextView.class);
        patternFragment.ivNotToy = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_not_toy, "field 'ivNotToy'", ImageView.class);
        patternFragment.ivPatternSearch = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_pattern_search, "field 'ivPatternSearch'", ImageView.class);
        patternFragment.titleAdd = (ImageView) Utils.findRequiredViewAsType(view, R.id.title_add, "field 'titleAdd'", ImageView.class);
        patternFragment.rvToytypeHorizontal = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_toytype_horizontal, "field 'rvToytypeHorizontal'", RecyclerView.class);
        patternFragment.patternsViewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.patterns_viewpager, "field 'patternsViewpager'", ViewPager.class);
        patternFragment.patternFilter = (ImageView) Utils.findRequiredViewAsType(view, R.id.pattern_filter, "field 'patternFilter'", ImageView.class);
        patternFragment.loginPattern = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.login_patterns, "field 'loginPattern'", LinearLayout.class);
        patternFragment.offlinePattern = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.offline_patterns, "field 'offlinePattern'", LinearLayout.class);
        patternFragment.offlineLogin = (MediumBoldTextView) Utils.findRequiredViewAsType(view, R.id.offline_login, "field 'offlineLogin'", MediumBoldTextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PatternFragment patternFragment = this.a;
        if (patternFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        patternFragment.ivBack = null;
        patternFragment.tvTitle = null;
        patternFragment.rlToy1 = null;
        patternFragment.rlToy2 = null;
        patternFragment.ivNotToy = null;
        patternFragment.ivPatternSearch = null;
        patternFragment.titleAdd = null;
        patternFragment.rvToytypeHorizontal = null;
        patternFragment.patternsViewpager = null;
        patternFragment.patternFilter = null;
        patternFragment.loginPattern = null;
        patternFragment.offlinePattern = null;
        patternFragment.offlineLogin = null;
    }
}
