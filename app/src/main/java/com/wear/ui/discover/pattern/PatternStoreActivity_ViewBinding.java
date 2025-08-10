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
public class PatternStoreActivity_ViewBinding implements Unbinder {
    public PatternStoreActivity a;

    @UiThread
    public PatternStoreActivity_ViewBinding(PatternStoreActivity patternStoreActivity, View view) {
        this.a = patternStoreActivity;
        patternStoreActivity.ivBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_back, "field 'ivBack'", ImageView.class);
        patternStoreActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        patternStoreActivity.rlToy1 = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.rl_toy_1, "field 'rlToy1'", AppCompatTextView.class);
        patternStoreActivity.rlToy2 = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.rl_toy_2, "field 'rlToy2'", AppCompatTextView.class);
        patternStoreActivity.ivNotToy = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_not_toy, "field 'ivNotToy'", ImageView.class);
        patternStoreActivity.toysNumber = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.toys_number_text, "field 'toysNumber'", AppCompatTextView.class);
        patternStoreActivity.ivPatternSearch = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_pattern_search, "field 'ivPatternSearch'", ImageView.class);
        patternStoreActivity.rvToytypeHorizontal = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_toytype_horizontal, "field 'rvToytypeHorizontal'", RecyclerView.class);
        patternStoreActivity.patternsViewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.patterns_viewpager, "field 'patternsViewpager'", ViewPager.class);
        patternStoreActivity.patternFilter = (ImageView) Utils.findRequiredViewAsType(view, R.id.pattern_filter, "field 'patternFilter'", ImageView.class);
        patternStoreActivity.loginPattern = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.login_patterns, "field 'loginPattern'", LinearLayout.class);
        patternStoreActivity.offlinePattern = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.offline_patterns, "field 'offlinePattern'", LinearLayout.class);
        patternStoreActivity.offlineLogin = (MediumBoldTextView) Utils.findRequiredViewAsType(view, R.id.offline_login, "field 'offlineLogin'", MediumBoldTextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PatternStoreActivity patternStoreActivity = this.a;
        if (patternStoreActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        patternStoreActivity.ivBack = null;
        patternStoreActivity.tvTitle = null;
        patternStoreActivity.rlToy1 = null;
        patternStoreActivity.rlToy2 = null;
        patternStoreActivity.ivNotToy = null;
        patternStoreActivity.toysNumber = null;
        patternStoreActivity.ivPatternSearch = null;
        patternStoreActivity.rvToytypeHorizontal = null;
        patternStoreActivity.patternsViewpager = null;
        patternStoreActivity.patternFilter = null;
        patternStoreActivity.loginPattern = null;
        patternStoreActivity.offlinePattern = null;
        patternStoreActivity.offlineLogin = null;
    }
}
