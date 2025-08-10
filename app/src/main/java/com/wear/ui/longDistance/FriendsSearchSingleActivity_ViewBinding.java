package com.wear.ui.longDistance;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.fragment.app.FragmentContainerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class FriendsSearchSingleActivity_ViewBinding implements Unbinder {
    public FriendsSearchSingleActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ FriendsSearchSingleActivity a;

        public a(FriendsSearchSingleActivity_ViewBinding friendsSearchSingleActivity_ViewBinding, FriendsSearchSingleActivity friendsSearchSingleActivity) {
            this.a = friendsSearchSingleActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ FriendsSearchSingleActivity a;

        public b(FriendsSearchSingleActivity_ViewBinding friendsSearchSingleActivity_ViewBinding, FriendsSearchSingleActivity friendsSearchSingleActivity) {
            this.a = friendsSearchSingleActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public FriendsSearchSingleActivity_ViewBinding(FriendsSearchSingleActivity friendsSearchSingleActivity, View view) {
        this.a = friendsSearchSingleActivity;
        friendsSearchSingleActivity.etSearch = (EditText) Utils.findRequiredViewAsType(view, R.id.et_search, "field 'etSearch'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_clear, "field 'ivClear' and method 'onClick'");
        friendsSearchSingleActivity.ivClear = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_clear, "field 'ivClear'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, friendsSearchSingleActivity));
        friendsSearchSingleActivity.fragmentContainerView = (FragmentContainerView) Utils.findRequiredViewAsType(view, R.id.fragment_container, "field 'fragmentContainerView'", FragmentContainerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.back, "method 'onClick'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, friendsSearchSingleActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FriendsSearchSingleActivity friendsSearchSingleActivity = this.a;
        if (friendsSearchSingleActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        friendsSearchSingleActivity.etSearch = null;
        friendsSearchSingleActivity.ivClear = null;
        friendsSearchSingleActivity.fragmentContainerView = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
