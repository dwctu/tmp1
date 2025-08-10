package com.wear.main.longDistance;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.kproduce.roundcorners.CircleImageView;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;

/* loaded from: classes3.dex */
public class HandlerBlockedFriendsActivity_ViewBinding implements Unbinder {
    public HandlerBlockedFriendsActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ HandlerBlockedFriendsActivity a;

        public a(HandlerBlockedFriendsActivity_ViewBinding handlerBlockedFriendsActivity_ViewBinding, HandlerBlockedFriendsActivity handlerBlockedFriendsActivity) {
            this.a = handlerBlockedFriendsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ HandlerBlockedFriendsActivity a;

        public b(HandlerBlockedFriendsActivity_ViewBinding handlerBlockedFriendsActivity_ViewBinding, HandlerBlockedFriendsActivity handlerBlockedFriendsActivity) {
            this.a = handlerBlockedFriendsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public HandlerBlockedFriendsActivity_ViewBinding(HandlerBlockedFriendsActivity handlerBlockedFriendsActivity, View view) {
        this.a = handlerBlockedFriendsActivity;
        handlerBlockedFriendsActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        handlerBlockedFriendsActivity.rivUserImg = (CircleImageView) Utils.findRequiredViewAsType(view, R.id.riv_user_img, "field 'rivUserImg'", CircleImageView.class);
        handlerBlockedFriendsActivity.tvRemarks = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_remarks, "field 'tvRemarks'", TextView.class);
        handlerBlockedFriendsActivity.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_names, "field 'tvName'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_clear_history, "field 'tvClearHistory' and method 'onViewClicked'");
        handlerBlockedFriendsActivity.tvClearHistory = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_clear_history, "field 'tvClearHistory'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, handlerBlockedFriendsActivity));
        handlerBlockedFriendsActivity.blackSetting = (SwitchView) Utils.findRequiredViewAsType(view, R.id.black_setting, "field 'blackSetting'", SwitchView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_send_message, "field 'btnSendMessage' and method 'onViewClicked'");
        handlerBlockedFriendsActivity.btnSendMessage = viewFindRequiredView2;
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, handlerBlockedFriendsActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HandlerBlockedFriendsActivity handlerBlockedFriendsActivity = this.a;
        if (handlerBlockedFriendsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        handlerBlockedFriendsActivity.actionbar = null;
        handlerBlockedFriendsActivity.rivUserImg = null;
        handlerBlockedFriendsActivity.tvRemarks = null;
        handlerBlockedFriendsActivity.tvName = null;
        handlerBlockedFriendsActivity.tvClearHistory = null;
        handlerBlockedFriendsActivity.blackSetting = null;
        handlerBlockedFriendsActivity.btnSendMessage = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
