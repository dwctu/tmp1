package com.wear.main.patterns;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class SingleChoosePatternsActivity_ViewBinding implements Unbinder {
    public SingleChoosePatternsActivity a;

    @UiThread
    public SingleChoosePatternsActivity_ViewBinding(SingleChoosePatternsActivity singleChoosePatternsActivity, View view) {
        this.a = singleChoosePatternsActivity;
        singleChoosePatternsActivity.ivBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_back, "field 'ivBack'", ImageView.class);
        singleChoosePatternsActivity.tvSend = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_send, "field 'tvSend'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SingleChoosePatternsActivity singleChoosePatternsActivity = this.a;
        if (singleChoosePatternsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        singleChoosePatternsActivity.ivBack = null;
        singleChoosePatternsActivity.tvSend = null;
    }
}
