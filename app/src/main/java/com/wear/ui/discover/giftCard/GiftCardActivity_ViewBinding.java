package com.wear.ui.discover.giftCard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import skin.support.widget.SkinCompatButton;

/* loaded from: classes3.dex */
public class GiftCardActivity_ViewBinding implements Unbinder {
    public GiftCardActivity a;

    @UiThread
    public GiftCardActivity_ViewBinding(GiftCardActivity giftCardActivity, View view) {
        this.a = giftCardActivity;
        giftCardActivity.navBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.nav_back, "field 'navBack'", ImageView.class);
        giftCardActivity.startGift = (SkinCompatButton) Utils.findRequiredViewAsType(view, R.id.start_gift, "field 'startGift'", SkinCompatButton.class);
        giftCardActivity.appBarLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.app_bar_layout, "field 'appBarLayout'", ConstraintLayout.class);
        giftCardActivity.innerTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.inner_title, "field 'innerTitle'", TextView.class);
        giftCardActivity.giftImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.gift_image, "field 'giftImage'", ImageView.class);
        giftCardActivity.checkoutImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.checkout_image, "field 'checkoutImage'", ImageView.class);
        giftCardActivity.shareImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.share_image, "field 'shareImage'", ImageView.class);
        giftCardActivity.waitImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.wait_image, "field 'waitImage'", ImageView.class);
        giftCardActivity.innnerLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.innner_layout, "field 'innnerLayout'", ConstraintLayout.class);
        giftCardActivity.guidePage = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.guide_page, "field 'guidePage'", ConstraintLayout.class);
        giftCardActivity.giftList = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.gift_list, "field 'giftList'", ConstraintLayout.class);
        giftCardActivity.setNewGiftImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.set_new_gift_image, "field 'setNewGiftImage'", ImageView.class);
        giftCardActivity.setNewGiftLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.set_new_gift_layout, "field 'setNewGiftLayout'", ConstraintLayout.class);
        giftCardActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        giftCardActivity.smartRefresh = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.smartRefresh, "field 'smartRefresh'", SmartRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GiftCardActivity giftCardActivity = this.a;
        if (giftCardActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        giftCardActivity.navBack = null;
        giftCardActivity.startGift = null;
        giftCardActivity.appBarLayout = null;
        giftCardActivity.innerTitle = null;
        giftCardActivity.giftImage = null;
        giftCardActivity.checkoutImage = null;
        giftCardActivity.shareImage = null;
        giftCardActivity.waitImage = null;
        giftCardActivity.innnerLayout = null;
        giftCardActivity.guidePage = null;
        giftCardActivity.giftList = null;
        giftCardActivity.setNewGiftImage = null;
        giftCardActivity.setNewGiftLayout = null;
        giftCardActivity.recyclerView = null;
        giftCardActivity.smartRefresh = null;
    }
}
