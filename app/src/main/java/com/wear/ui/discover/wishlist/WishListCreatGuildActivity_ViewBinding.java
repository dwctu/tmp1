package com.wear.ui.discover.wishlist;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class WishListCreatGuildActivity_ViewBinding implements Unbinder {
    public WishListCreatGuildActivity a;

    @UiThread
    public WishListCreatGuildActivity_ViewBinding(WishListCreatGuildActivity wishListCreatGuildActivity, View view) {
        this.a = wishListCreatGuildActivity;
        wishListCreatGuildActivity.create_btn = (Button) Utils.findRequiredViewAsType(view, R.id.create_wish_list_btn, "field 'create_btn'", Button.class);
        wishListCreatGuildActivity.navBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.nav_back, "field 'navBack'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WishListCreatGuildActivity wishListCreatGuildActivity = this.a;
        if (wishListCreatGuildActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        wishListCreatGuildActivity.create_btn = null;
        wishListCreatGuildActivity.navBack = null;
    }
}
