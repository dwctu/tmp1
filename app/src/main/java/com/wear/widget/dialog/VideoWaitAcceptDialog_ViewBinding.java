package com.wear.widget.dialog;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;

/* loaded from: classes4.dex */
public class VideoWaitAcceptDialog_ViewBinding implements Unbinder {
    public VideoWaitAcceptDialog a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ VideoWaitAcceptDialog a;

        public a(VideoWaitAcceptDialog_ViewBinding videoWaitAcceptDialog_ViewBinding, VideoWaitAcceptDialog videoWaitAcceptDialog) {
            this.a = videoWaitAcceptDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ VideoWaitAcceptDialog a;

        public b(VideoWaitAcceptDialog_ViewBinding videoWaitAcceptDialog_ViewBinding, VideoWaitAcceptDialog videoWaitAcceptDialog) {
            this.a = videoWaitAcceptDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ VideoWaitAcceptDialog a;

        public c(VideoWaitAcceptDialog_ViewBinding videoWaitAcceptDialog_ViewBinding, VideoWaitAcceptDialog videoWaitAcceptDialog) {
            this.a = videoWaitAcceptDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ VideoWaitAcceptDialog a;

        public d(VideoWaitAcceptDialog_ViewBinding videoWaitAcceptDialog_ViewBinding, VideoWaitAcceptDialog videoWaitAcceptDialog) {
            this.a = videoWaitAcceptDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ VideoWaitAcceptDialog a;

        public e(VideoWaitAcceptDialog_ViewBinding videoWaitAcceptDialog_ViewBinding, VideoWaitAcceptDialog videoWaitAcceptDialog) {
            this.a = videoWaitAcceptDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ VideoWaitAcceptDialog a;

        public f(VideoWaitAcceptDialog_ViewBinding videoWaitAcceptDialog_ViewBinding, VideoWaitAcceptDialog videoWaitAcceptDialog) {
            this.a = videoWaitAcceptDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public VideoWaitAcceptDialog_ViewBinding(VideoWaitAcceptDialog videoWaitAcceptDialog, View view) {
        this.a = videoWaitAcceptDialog;
        videoWaitAcceptDialog.ivFriendAvatar = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_friend_avatar, "field 'ivFriendAvatar'", RoundedImageView.class);
        videoWaitAcceptDialog.tvFriendName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_friend_name, "field 'tvFriendName'", TextView.class);
        videoWaitAcceptDialog.tvCallingNotice = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_calling_notice, "field 'tvCallingNotice'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_reject, "field 'ivReject' and method 'onViewClicked'");
        videoWaitAcceptDialog.ivReject = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_reject, "field 'ivReject'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, videoWaitAcceptDialog));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_reject, "field 'tvReject' and method 'onViewClicked'");
        videoWaitAcceptDialog.tvReject = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_reject, "field 'tvReject'", TextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, videoWaitAcceptDialog));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_cancel, "field 'ivCancel' and method 'onViewClicked'");
        videoWaitAcceptDialog.ivCancel = (ImageView) Utils.castView(viewFindRequiredView3, R.id.iv_cancel, "field 'ivCancel'", ImageView.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, videoWaitAcceptDialog));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_cancel, "field 'tvCancel' and method 'onViewClicked'");
        videoWaitAcceptDialog.tvCancel = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, videoWaitAcceptDialog));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.iv_accept, "field 'ivAccept' and method 'onViewClicked'");
        videoWaitAcceptDialog.ivAccept = (ImageView) Utils.castView(viewFindRequiredView5, R.id.iv_accept, "field 'ivAccept'", ImageView.class);
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, videoWaitAcceptDialog));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.tv_accept, "field 'tvAccept' and method 'onViewClicked'");
        videoWaitAcceptDialog.tvAccept = (TextView) Utils.castView(viewFindRequiredView6, R.id.tv_accept, "field 'tvAccept'", TextView.class);
        this.g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, videoWaitAcceptDialog));
        videoWaitAcceptDialog.layoutReceive = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.layout_receive, "field 'layoutReceive'", ConstraintLayout.class);
        videoWaitAcceptDialog.rlMaxView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.rl_max_view, "field 'rlMaxView'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VideoWaitAcceptDialog videoWaitAcceptDialog = this.a;
        if (videoWaitAcceptDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        videoWaitAcceptDialog.ivFriendAvatar = null;
        videoWaitAcceptDialog.tvFriendName = null;
        videoWaitAcceptDialog.tvCallingNotice = null;
        videoWaitAcceptDialog.ivReject = null;
        videoWaitAcceptDialog.tvReject = null;
        videoWaitAcceptDialog.ivCancel = null;
        videoWaitAcceptDialog.tvCancel = null;
        videoWaitAcceptDialog.ivAccept = null;
        videoWaitAcceptDialog.tvAccept = null;
        videoWaitAcceptDialog.layoutReceive = null;
        videoWaitAcceptDialog.rlMaxView = null;
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
        this.g.setOnClickListener(null);
        this.g = null;
    }
}
