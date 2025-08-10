package com.wear.widget.dialog;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.ui.longDistance.video.player.MyVideoView;
import com.wear.widget.CountDownView;

/* loaded from: classes4.dex */
public class NewYearOrgyDialog extends AppCompatDialog {

    @BindView(R.id.countDownLayout)
    public ConstraintLayout countDownLayout;

    @BindView(R.id.countDownView)
    public CountDownView countDownView;

    @BindView(R.id.parentLinear)
    public LinearLayout parentLinear;

    @BindView(R.id.text)
    public AppCompatTextView text;

    @BindView(R.id.text1)
    public TextView text1;

    @BindView(R.id.title)
    public AppCompatTextView title;

    @BindView(R.id.videoAnimation)
    public LottieAnimationView videoAnimation;

    @BindView(R.id.videoLayout)
    public ConstraintLayout videoLayout;

    @BindView(R.id.videoPlayer)
    public MyVideoView videoPlayer;

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.countDownView.b();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
    }
}
