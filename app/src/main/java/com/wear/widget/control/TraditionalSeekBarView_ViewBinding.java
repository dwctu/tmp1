package com.wear.widget.control;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class TraditionalSeekBarView_ViewBinding implements Unbinder {
    public TraditionalSeekBarView a;

    @UiThread
    public TraditionalSeekBarView_ViewBinding(TraditionalSeekBarView traditionalSeekBarView, View view) {
        this.a = traditionalSeekBarView;
        traditionalSeekBarView.vseekBar = (VerticalSeekBar) Utils.findRequiredViewAsType(view, R.id.vseekBar, "field 'vseekBar'", VerticalSeekBar.class);
        traditionalSeekBarView.tvFuc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fuc, "field 'tvFuc'", TextView.class);
        traditionalSeekBarView.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
        traditionalSeekBarView.llIcon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_icon, "field 'llIcon'", LinearLayout.class);
        traditionalSeekBarView.vseekBarBg = (TraditionalSeekBarViewBg) Utils.findRequiredViewAsType(view, R.id.vseekBar_bg, "field 'vseekBarBg'", TraditionalSeekBarViewBg.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TraditionalSeekBarView traditionalSeekBarView = this.a;
        if (traditionalSeekBarView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        traditionalSeekBarView.vseekBar = null;
        traditionalSeekBarView.tvFuc = null;
        traditionalSeekBarView.ivIcon = null;
        traditionalSeekBarView.llIcon = null;
        traditionalSeekBarView.vseekBarBg = null;
    }
}
