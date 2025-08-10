package com.wear.main.longDistance;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class JoinGroupChatActivity_ViewBinding implements Unbinder {
    public JoinGroupChatActivity a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ JoinGroupChatActivity a;

        public a(JoinGroupChatActivity_ViewBinding joinGroupChatActivity_ViewBinding, JoinGroupChatActivity joinGroupChatActivity) {
            this.a = joinGroupChatActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick();
        }
    }

    @UiThread
    public JoinGroupChatActivity_ViewBinding(JoinGroupChatActivity joinGroupChatActivity, View view) {
        this.a = joinGroupChatActivity;
        joinGroupChatActivity.abTitle = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.ab_title, "field 'abTitle'", MyActionBar.class);
        joinGroupChatActivity.ivUserImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_user_img, "field 'ivUserImg'", RoundedImageView.class);
        joinGroupChatActivity.tvGroupName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_group_name, "field 'tvGroupName'", TextView.class);
        joinGroupChatActivity.tvCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_count, "field 'tvCount'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_join, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, joinGroupChatActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        JoinGroupChatActivity joinGroupChatActivity = this.a;
        if (joinGroupChatActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        joinGroupChatActivity.abTitle = null;
        joinGroupChatActivity.ivUserImg = null;
        joinGroupChatActivity.tvGroupName = null;
        joinGroupChatActivity.tvCount = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
