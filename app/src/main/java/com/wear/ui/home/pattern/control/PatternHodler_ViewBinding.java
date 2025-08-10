package com.wear.ui.home.pattern.control;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class PatternHodler_ViewBinding implements Unbinder {
    public PatternHodler a;

    @UiThread
    public PatternHodler_ViewBinding(PatternHodler patternHodler, View view) {
        this.a = patternHodler;
        patternHodler.tvUserName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvUserName'", TextView.class);
        patternHodler.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        patternHodler.ivPlayOrPause = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_play_or_pause, "field 'ivPlayOrPause'", ImageView.class);
        patternHodler.iv_under_preview = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_under_preview, "field 'iv_under_preview'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PatternHodler patternHodler = this.a;
        if (patternHodler == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        patternHodler.tvUserName = null;
        patternHodler.tvTime = null;
        patternHodler.ivPlayOrPause = null;
        patternHodler.iv_under_preview = null;
    }
}
