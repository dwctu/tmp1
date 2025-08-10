package com.wear.main.longDistance;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ChangeGroupPhotoActivity_ViewBinding implements Unbinder {
    public ChangeGroupPhotoActivity a;

    @UiThread
    public ChangeGroupPhotoActivity_ViewBinding(ChangeGroupPhotoActivity changeGroupPhotoActivity, View view) {
        this.a = changeGroupPhotoActivity;
        changeGroupPhotoActivity.abTitle = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.ab_title, "field 'abTitle'", MyActionBar.class);
        changeGroupPhotoActivity.ivShowBigImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_show_big_img, "field 'ivShowBigImg'", RoundedImageView.class);
        changeGroupPhotoActivity.llScreanRootLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_screan_root_layout, "field 'llScreanRootLayout'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChangeGroupPhotoActivity changeGroupPhotoActivity = this.a;
        if (changeGroupPhotoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        changeGroupPhotoActivity.abTitle = null;
        changeGroupPhotoActivity.ivShowBigImg = null;
        changeGroupPhotoActivity.llScreanRootLayout = null;
    }
}
