package com.wear.main.toy;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class SerialNumberActivity_ViewBinding implements Unbinder {
    public SerialNumberActivity a;

    @UiThread
    public SerialNumberActivity_ViewBinding(SerialNumberActivity serialNumberActivity, View view) {
        this.a = serialNumberActivity;
        serialNumberActivity.mTvSerialNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_serial_number, "field 'mTvSerialNumber'", TextView.class);
        serialNumberActivity.mTvNoSerialNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_no_serial_num, "field 'mTvNoSerialNum'", TextView.class);
        serialNumberActivity.mFlSerialNumber = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_serial_number, "field 'mFlSerialNumber'", FrameLayout.class);
        serialNumberActivity.mIvSerialnumberLoading = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_serial_number_loading, "field 'mIvSerialnumberLoading'", ImageView.class);
        serialNumberActivity.mLlSerialNumberBg = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_serial_number_bg, "field 'mLlSerialNumberBg'", LinearLayout.class);
        serialNumberActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SerialNumberActivity serialNumberActivity = this.a;
        if (serialNumberActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        serialNumberActivity.mTvSerialNumber = null;
        serialNumberActivity.mTvNoSerialNum = null;
        serialNumberActivity.mFlSerialNumber = null;
        serialNumberActivity.mIvSerialnumberLoading = null;
        serialNumberActivity.mLlSerialNumberBg = null;
        serialNumberActivity.actionbar = null;
    }
}
