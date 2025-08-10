package com.wear.ui.me;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class MoreInformationActivity_ViewBinding implements Unbinder {
    public MoreInformationActivity a;

    @UiThread
    public MoreInformationActivity_ViewBinding(MoreInformationActivity moreInformationActivity, View view) {
        this.a = moreInformationActivity;
        moreInformationActivity.tvAge = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.tv_age, "field 'tvAge'", AppCompatTextView.class);
        moreInformationActivity.ageLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.age_layout, "field 'ageLayout'", LinearLayout.class);
        moreInformationActivity.tvMoodMessage = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.mood_message, "field 'tvMoodMessage'", AppCompatTextView.class);
        moreInformationActivity.moodLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mood_layout, "field 'moodLayout'", LinearLayout.class);
        moreInformationActivity.screanRootLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.screan_root_layout, "field 'screanRootLayout'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MoreInformationActivity moreInformationActivity = this.a;
        if (moreInformationActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        moreInformationActivity.tvAge = null;
        moreInformationActivity.ageLayout = null;
        moreInformationActivity.tvMoodMessage = null;
        moreInformationActivity.moodLayout = null;
        moreInformationActivity.screanRootLayout = null;
    }
}
