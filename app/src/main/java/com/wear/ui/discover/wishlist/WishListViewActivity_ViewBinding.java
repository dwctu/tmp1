package com.wear.ui.discover.wishlist;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class WishListViewActivity_ViewBinding implements Unbinder {
    public WishListViewActivity a;

    @UiThread
    public WishListViewActivity_ViewBinding(WishListViewActivity wishListViewActivity, View view) {
        this.a = wishListViewActivity;
        wishListViewActivity.wishListName = (TextView) Utils.findRequiredViewAsType(view, R.id.wishlist_name_view, "field 'wishListName'", TextView.class);
        wishListViewActivity.wishListDescription = (TextView) Utils.findRequiredViewAsType(view, R.id.wishlist_description_view, "field 'wishListDescription'", TextView.class);
        wishListViewActivity.link = (TextView) Utils.findRequiredViewAsType(view, R.id.link_text, "field 'link'", TextView.class);
        wishListViewActivity.copyBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.copy_btn, "field 'copyBtn'", ImageView.class);
        wishListViewActivity.shareBtn = (Button) Utils.findRequiredViewAsType(view, R.id.share_wish_list_btn, "field 'shareBtn'", Button.class);
        wishListViewActivity.toyRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.toys_recycler_view, "field 'toyRecyclerView'", RecyclerView.class);
        wishListViewActivity.toyNameView = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_name_view, "field 'toyNameView'", TextView.class);
        wishListViewActivity.progressNumber = (ImageView) Utils.findRequiredViewAsType(view, R.id.progress_number, "field 'progressNumber'", ImageView.class);
        wishListViewActivity.fundDescription = (TextView) Utils.findRequiredViewAsType(view, R.id.fund_description, "field 'fundDescription'", TextView.class);
        wishListViewActivity.profileView = (ImageView) Utils.findRequiredViewAsType(view, R.id.profile_view, "field 'profileView'", ImageView.class);
        wishListViewActivity.navBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.nav_back, "field 'navBack'", ImageView.class);
        wishListViewActivity.editTextView = (TextView) Utils.findRequiredViewAsType(view, R.id.edit_btn, "field 'editTextView'", TextView.class);
        wishListViewActivity.noticeBar = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.contribution_bar, "field 'noticeBar'", ConstraintLayout.class);
        wishListViewActivity.num_contribute_view = (TextView) Utils.findRequiredViewAsType(view, R.id.num_contribute_view, "field 'num_contribute_view'", TextView.class);
        wishListViewActivity.peopleContribution = (TextView) Utils.findRequiredViewAsType(view, R.id.people_contribution_text_view, "field 'peopleContribution'", TextView.class);
        wishListViewActivity.percentView = (TextView) Utils.findRequiredViewAsType(view, R.id.percent_text_view, "field 'percentView'", TextView.class);
        wishListViewActivity.toysLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.toys_layout, "field 'toysLayout'", ConstraintLayout.class);
        wishListViewActivity.fanLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.fan_layout, "field 'fanLayout'", ConstraintLayout.class);
        wishListViewActivity.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refresh_layout_view, "field 'refreshLayout'", SwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WishListViewActivity wishListViewActivity = this.a;
        if (wishListViewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        wishListViewActivity.wishListName = null;
        wishListViewActivity.wishListDescription = null;
        wishListViewActivity.link = null;
        wishListViewActivity.copyBtn = null;
        wishListViewActivity.shareBtn = null;
        wishListViewActivity.toyRecyclerView = null;
        wishListViewActivity.toyNameView = null;
        wishListViewActivity.progressNumber = null;
        wishListViewActivity.fundDescription = null;
        wishListViewActivity.profileView = null;
        wishListViewActivity.navBack = null;
        wishListViewActivity.editTextView = null;
        wishListViewActivity.noticeBar = null;
        wishListViewActivity.num_contribute_view = null;
        wishListViewActivity.peopleContribution = null;
        wishListViewActivity.percentView = null;
        wishListViewActivity.toysLayout = null;
        wishListViewActivity.fanLayout = null;
        wishListViewActivity.refreshLayout = null;
    }
}
