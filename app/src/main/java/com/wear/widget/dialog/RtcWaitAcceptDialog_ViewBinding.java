package com.wear.widget.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;

/* loaded from: classes4.dex */
public class RtcWaitAcceptDialog_ViewBinding implements Unbinder {
    public RtcWaitAcceptDialog a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ RtcWaitAcceptDialog a;

        public a(RtcWaitAcceptDialog_ViewBinding rtcWaitAcceptDialog_ViewBinding, RtcWaitAcceptDialog rtcWaitAcceptDialog) {
            this.a = rtcWaitAcceptDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ RtcWaitAcceptDialog a;

        public b(RtcWaitAcceptDialog_ViewBinding rtcWaitAcceptDialog_ViewBinding, RtcWaitAcceptDialog rtcWaitAcceptDialog) {
            this.a = rtcWaitAcceptDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ RtcWaitAcceptDialog a;

        public c(RtcWaitAcceptDialog_ViewBinding rtcWaitAcceptDialog_ViewBinding, RtcWaitAcceptDialog rtcWaitAcceptDialog) {
            this.a = rtcWaitAcceptDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public RtcWaitAcceptDialog_ViewBinding(RtcWaitAcceptDialog rtcWaitAcceptDialog, View view) {
        this.a = rtcWaitAcceptDialog;
        rtcWaitAcceptDialog.ivFriendAvatar = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_friend_avatar, "field 'ivFriendAvatar'", RoundedImageView.class);
        rtcWaitAcceptDialog.tvFriendName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_friend_name, "field 'tvFriendName'", TextView.class);
        rtcWaitAcceptDialog.tvCallingNotice = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_calling_notice, "field 'tvCallingNotice'", TextView.class);
        rtcWaitAcceptDialog.tvComeInNotice = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_come_in_notice, "field 'tvComeInNotice'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_cancel, "field 'ivCancel' and method 'onViewClicked'");
        rtcWaitAcceptDialog.ivCancel = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_cancel, "field 'ivCancel'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, rtcWaitAcceptDialog));
        rtcWaitAcceptDialog.layoutCallingCancel = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_calling_cancel, "field 'layoutCallingCancel'", LinearLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_reject, "field 'ivReject' and method 'onViewClicked'");
        rtcWaitAcceptDialog.ivReject = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_reject, "field 'ivReject'", ImageView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, rtcWaitAcceptDialog));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_accept, "field 'ivAccept' and method 'onViewClicked'");
        rtcWaitAcceptDialog.ivAccept = (ImageView) Utils.castView(viewFindRequiredView3, R.id.iv_accept, "field 'ivAccept'", ImageView.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, rtcWaitAcceptDialog));
        rtcWaitAcceptDialog.layoutReceive = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_receive, "field 'layoutReceive'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RtcWaitAcceptDialog rtcWaitAcceptDialog = this.a;
        if (rtcWaitAcceptDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        rtcWaitAcceptDialog.ivFriendAvatar = null;
        rtcWaitAcceptDialog.tvFriendName = null;
        rtcWaitAcceptDialog.tvCallingNotice = null;
        rtcWaitAcceptDialog.tvComeInNotice = null;
        rtcWaitAcceptDialog.ivCancel = null;
        rtcWaitAcceptDialog.layoutCallingCancel = null;
        rtcWaitAcceptDialog.ivReject = null;
        rtcWaitAcceptDialog.ivAccept = null;
        rtcWaitAcceptDialog.layoutReceive = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
