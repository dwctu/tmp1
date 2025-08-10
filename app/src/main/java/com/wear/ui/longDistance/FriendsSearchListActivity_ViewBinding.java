package com.wear.ui.longDistance;

import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldRadioButton;

/* loaded from: classes3.dex */
public class FriendsSearchListActivity_ViewBinding implements Unbinder {
    public FriendsSearchListActivity a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ FriendsSearchListActivity a;

        public a(FriendsSearchListActivity_ViewBinding friendsSearchListActivity_ViewBinding, FriendsSearchListActivity friendsSearchListActivity) {
            this.a = friendsSearchListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ FriendsSearchListActivity a;

        public b(FriendsSearchListActivity_ViewBinding friendsSearchListActivity_ViewBinding, FriendsSearchListActivity friendsSearchListActivity) {
            this.a = friendsSearchListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ FriendsSearchListActivity a;

        public c(FriendsSearchListActivity_ViewBinding friendsSearchListActivity_ViewBinding, FriendsSearchListActivity friendsSearchListActivity) {
            this.a = friendsSearchListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.a.onClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ FriendsSearchListActivity a;

        public d(FriendsSearchListActivity_ViewBinding friendsSearchListActivity_ViewBinding, FriendsSearchListActivity friendsSearchListActivity) {
            this.a = friendsSearchListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.a.onClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ FriendsSearchListActivity a;

        public e(FriendsSearchListActivity_ViewBinding friendsSearchListActivity_ViewBinding, FriendsSearchListActivity friendsSearchListActivity) {
            this.a = friendsSearchListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.a.onClick(view);
        }
    }

    @UiThread
    public FriendsSearchListActivity_ViewBinding(FriendsSearchListActivity friendsSearchListActivity, View view) {
        this.a = friendsSearchListActivity;
        friendsSearchListActivity.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.view_pager, "field 'viewPager'", ViewPager.class);
        friendsSearchListActivity.etSearch = (EditText) Utils.findRequiredViewAsType(view, R.id.et_search, "field 'etSearch'", EditText.class);
        friendsSearchListActivity.vFriendsRedDot = Utils.findRequiredView(view, R.id.v_friends_red_dot, "field 'vFriendsRedDot'");
        friendsSearchListActivity.vRequestRedDot = Utils.findRequiredView(view, R.id.v_request_red_dot, "field 'vRequestRedDot'");
        friendsSearchListActivity.vBlockRedDot = Utils.findRequiredView(view, R.id.v_block_red_dot, "field 'vBlockRedDot'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rb_friends, "field 'rbFriends' and method 'onClick'");
        friendsSearchListActivity.rbFriends = (MediumBoldRadioButton) Utils.castView(viewFindRequiredView, R.id.rb_friends, "field 'rbFriends'", MediumBoldRadioButton.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, friendsSearchListActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rb_request, "field 'rbRequest' and method 'onClick'");
        friendsSearchListActivity.rbRequest = (MediumBoldRadioButton) Utils.castView(viewFindRequiredView2, R.id.rb_request, "field 'rbRequest'", MediumBoldRadioButton.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, friendsSearchListActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rb_block, "field 'rbBlock' and method 'onClick'");
        friendsSearchListActivity.rbBlock = (MediumBoldRadioButton) Utils.castView(viewFindRequiredView3, R.id.rb_block, "field 'rbBlock'", MediumBoldRadioButton.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, friendsSearchListActivity));
        friendsSearchListActivity.mLlAllOrder = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.all_order, "field 'mLlAllOrder'", LinearLayout.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_clear, "field 'ivClear' and method 'onClick'");
        friendsSearchListActivity.ivClear = (ImageView) Utils.castView(viewFindRequiredView4, R.id.iv_clear, "field 'ivClear'", ImageView.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, friendsSearchListActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.back, "method 'onClick'");
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, friendsSearchListActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FriendsSearchListActivity friendsSearchListActivity = this.a;
        if (friendsSearchListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        friendsSearchListActivity.viewPager = null;
        friendsSearchListActivity.etSearch = null;
        friendsSearchListActivity.vFriendsRedDot = null;
        friendsSearchListActivity.vRequestRedDot = null;
        friendsSearchListActivity.vBlockRedDot = null;
        friendsSearchListActivity.rbFriends = null;
        friendsSearchListActivity.rbRequest = null;
        friendsSearchListActivity.rbBlock = null;
        friendsSearchListActivity.mLlAllOrder = null;
        friendsSearchListActivity.ivClear = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
    }
}
