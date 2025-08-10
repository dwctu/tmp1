package com.wear.ui.discover.wishlist;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class VisitWishListConfirmActivity_ViewBinding implements Unbinder {
    public VisitWishListConfirmActivity a;

    @UiThread
    public VisitWishListConfirmActivity_ViewBinding(VisitWishListConfirmActivity visitWishListConfirmActivity, View view) {
        this.a = visitWishListConfirmActivity;
        visitWishListConfirmActivity.profileView = (ImageView) Utils.findRequiredViewAsType(view, R.id.profile_icon_view, "field 'profileView'", ImageView.class);
        visitWishListConfirmActivity.wishListName = (TextView) Utils.findRequiredViewAsType(view, R.id.wishlist_name_view, "field 'wishListName'", TextView.class);
        visitWishListConfirmActivity.continueBtn = (Button) Utils.findRequiredViewAsType(view, R.id.continue_btn, "field 'continueBtn'", Button.class);
        visitWishListConfirmActivity.navBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.nav_back, "field 'navBack'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VisitWishListConfirmActivity visitWishListConfirmActivity = this.a;
        if (visitWishListConfirmActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        visitWishListConfirmActivity.profileView = null;
        visitWishListConfirmActivity.wishListName = null;
        visitWishListConfirmActivity.continueBtn = null;
        visitWishListConfirmActivity.navBack = null;
    }
}
