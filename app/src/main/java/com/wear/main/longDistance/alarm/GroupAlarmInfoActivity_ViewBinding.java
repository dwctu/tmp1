package com.wear.main.longDistance.alarm;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import java.text.ParseException;

/* loaded from: classes3.dex */
public class GroupAlarmInfoActivity_ViewBinding implements Unbinder {
    public GroupAlarmInfoActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ GroupAlarmInfoActivity a;

        public a(GroupAlarmInfoActivity_ViewBinding groupAlarmInfoActivity_ViewBinding, GroupAlarmInfoActivity groupAlarmInfoActivity) {
            this.a = groupAlarmInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws ParseException {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ GroupAlarmInfoActivity a;

        public b(GroupAlarmInfoActivity_ViewBinding groupAlarmInfoActivity_ViewBinding, GroupAlarmInfoActivity groupAlarmInfoActivity) {
            this.a = groupAlarmInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws ParseException {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public GroupAlarmInfoActivity_ViewBinding(GroupAlarmInfoActivity groupAlarmInfoActivity, View view) {
        this.a = groupAlarmInfoActivity;
        groupAlarmInfoActivity.ivUserImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_user_img, "field 'ivUserImg'", RoundedImageView.class);
        groupAlarmInfoActivity.tvUserName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_user_name, "field 'tvUserName'", TextView.class);
        groupAlarmInfoActivity.tvAlarmName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alarm_name, "field 'tvAlarmName'", TextView.class);
        groupAlarmInfoActivity.tvAlarmState = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alarm_state, "field 'tvAlarmState'", TextView.class);
        groupAlarmInfoActivity.llAlarmStatus = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_alarm_status, "field 'llAlarmStatus'", LinearLayout.class);
        groupAlarmInfoActivity.rvMemberAccept = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_member_accept, "field 'rvMemberAccept'", RecyclerView.class);
        groupAlarmInfoActivity.tvAcceptedMembers = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_accepted_members, "field 'tvAcceptedMembers'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_alarm_status_accept, "field 'ivAlarmStatusAccept' and method 'onViewClicked'");
        groupAlarmInfoActivity.ivAlarmStatusAccept = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_alarm_status_accept, "field 'ivAlarmStatusAccept'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, groupAlarmInfoActivity));
        groupAlarmInfoActivity.tvAlarmStatusAccept = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alarm_status_accept, "field 'tvAlarmStatusAccept'", TextView.class);
        groupAlarmInfoActivity.llAlarmStatusAccept = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_alarm_status_accept, "field 'llAlarmStatusAccept'", LinearLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_alarm_status_decline, "field 'ivAlarmStatusDecline' and method 'onViewClicked'");
        groupAlarmInfoActivity.ivAlarmStatusDecline = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_alarm_status_decline, "field 'ivAlarmStatusDecline'", ImageView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, groupAlarmInfoActivity));
        groupAlarmInfoActivity.tvAlarmStatusDecline = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alarm_status_decline, "field 'tvAlarmStatusDecline'", TextView.class);
        groupAlarmInfoActivity.llAlarmStatusDecline = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_alarm_status_decline, "field 'llAlarmStatusDecline'", LinearLayout.class);
        groupAlarmInfoActivity.ivAlarmStatusExpired = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_alarm_status_expired, "field 'ivAlarmStatusExpired'", ImageView.class);
        groupAlarmInfoActivity.tvAlarmStatusExpired = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alarm_status_expired, "field 'tvAlarmStatusExpired'", TextView.class);
        groupAlarmInfoActivity.llAlarmStatusExpired = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_alarm_status_expired, "field 'llAlarmStatusExpired'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GroupAlarmInfoActivity groupAlarmInfoActivity = this.a;
        if (groupAlarmInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        groupAlarmInfoActivity.ivUserImg = null;
        groupAlarmInfoActivity.tvUserName = null;
        groupAlarmInfoActivity.tvAlarmName = null;
        groupAlarmInfoActivity.tvAlarmState = null;
        groupAlarmInfoActivity.llAlarmStatus = null;
        groupAlarmInfoActivity.rvMemberAccept = null;
        groupAlarmInfoActivity.tvAcceptedMembers = null;
        groupAlarmInfoActivity.ivAlarmStatusAccept = null;
        groupAlarmInfoActivity.tvAlarmStatusAccept = null;
        groupAlarmInfoActivity.llAlarmStatusAccept = null;
        groupAlarmInfoActivity.ivAlarmStatusDecline = null;
        groupAlarmInfoActivity.tvAlarmStatusDecline = null;
        groupAlarmInfoActivity.llAlarmStatusDecline = null;
        groupAlarmInfoActivity.ivAlarmStatusExpired = null;
        groupAlarmInfoActivity.tvAlarmStatusExpired = null;
        groupAlarmInfoActivity.llAlarmStatusExpired = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
