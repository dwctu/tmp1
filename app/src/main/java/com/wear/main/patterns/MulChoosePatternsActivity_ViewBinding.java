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
public class MulChoosePatternsActivity_ViewBinding implements Unbinder {
    public MulChoosePatternsActivity a;

    @UiThread
    public MulChoosePatternsActivity_ViewBinding(MulChoosePatternsActivity mulChoosePatternsActivity, View view) {
        this.a = mulChoosePatternsActivity;
        mulChoosePatternsActivity.ivBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_back, "field 'ivBack'", ImageView.class);
        mulChoosePatternsActivity.tvSend = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_send, "field 'tvSend'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MulChoosePatternsActivity mulChoosePatternsActivity = this.a;
        if (mulChoosePatternsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mulChoosePatternsActivity.ivBack = null;
        mulChoosePatternsActivity.tvSend = null;
    }
}
