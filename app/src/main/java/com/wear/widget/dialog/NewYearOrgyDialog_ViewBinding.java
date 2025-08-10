package com.wear.widget.dialog;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.ui.longDistance.video.player.MyVideoView;
import com.wear.widget.CountDownView;

/* loaded from: classes4.dex */
public class NewYearOrgyDialog_ViewBinding implements Unbinder {
    public NewYearOrgyDialog a;

    @UiThread
    public NewYearOrgyDialog_ViewBinding(NewYearOrgyDialog newYearOrgyDialog, View view) {
        this.a = newYearOrgyDialog;
        newYearOrgyDialog.title = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", AppCompatTextView.class);
        newYearOrgyDialog.text = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.text, "field 'text'", AppCompatTextView.class);
        newYearOrgyDialog.countDownView = (CountDownView) Utils.findRequiredViewAsType(view, R.id.countDownView, "field 'countDownView'", CountDownView.class);
        newYearOrgyDialog.videoAnimation = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.videoAnimation, "field 'videoAnimation'", LottieAnimationView.class);
        newYearOrgyDialog.videoLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.videoLayout, "field 'videoLayout'", ConstraintLayout.class);
        newYearOrgyDialog.parentLinear = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.parentLinear, "field 'parentLinear'", LinearLayout.class);
        newYearOrgyDialog.countDownLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.countDownLayout, "field 'countDownLayout'", ConstraintLayout.class);
        newYearOrgyDialog.videoPlayer = (MyVideoView) Utils.findRequiredViewAsType(view, R.id.videoPlayer, "field 'videoPlayer'", MyVideoView.class);
        newYearOrgyDialog.text1 = (TextView) Utils.findRequiredViewAsType(view, R.id.text1, "field 'text1'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        NewYearOrgyDialog newYearOrgyDialog = this.a;
        if (newYearOrgyDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        newYearOrgyDialog.title = null;
        newYearOrgyDialog.text = null;
        newYearOrgyDialog.countDownView = null;
        newYearOrgyDialog.videoAnimation = null;
        newYearOrgyDialog.videoLayout = null;
        newYearOrgyDialog.parentLinear = null;
        newYearOrgyDialog.countDownLayout = null;
        newYearOrgyDialog.videoPlayer = null;
        newYearOrgyDialog.text1 = null;
    }
}
