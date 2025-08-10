package com.wear.widget.dialog;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.bean.User;
import com.wear.util.WearUtils;
import dc.kn3;

/* loaded from: classes4.dex */
public class VideoWaitAcceptDialog extends FullScreenDialog {
    public kn3.d g;

    @BindView(R.id.iv_accept)
    public ImageView ivAccept;

    @BindView(R.id.iv_cancel)
    public ImageView ivCancel;

    @BindView(R.id.iv_friend_avatar)
    public RoundedImageView ivFriendAvatar;

    @BindView(R.id.iv_reject)
    public ImageView ivReject;

    @BindView(R.id.layout_receive)
    public ConstraintLayout layoutReceive;

    @BindView(R.id.rl_max_view)
    public FrameLayout rlMaxView;

    @BindView(R.id.tv_accept)
    public TextView tvAccept;

    @BindView(R.id.tv_calling_notice)
    public TextView tvCallingNotice;

    @BindView(R.id.tv_cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_friend_name)
    public TextView tvFriendName;

    @BindView(R.id.tv_reject)
    public TextView tvReject;

    public VideoWaitAcceptDialog(Context context) {
        super(context);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_video_request_wait_accept_dialog;
    }

    @OnClick({R.id.iv_reject, R.id.tv_reject, R.id.iv_cancel, R.id.tv_cancel, R.id.iv_accept, R.id.tv_accept})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_accept /* 2131363069 */:
            case R.id.tv_accept /* 2131364900 */:
                dismiss();
                break;
            case R.id.iv_cancel /* 2131363108 */:
            case R.id.tv_cancel /* 2131364956 */:
                dismiss();
                kn3.d dVar = this.g;
                if (dVar != null) {
                    dVar.doConfirm();
                    break;
                }
                break;
            case R.id.iv_reject /* 2131363274 */:
            case R.id.tv_reject /* 2131365268 */:
                dismiss();
                break;
        }
    }

    public void setClickListener(kn3.d dVar) {
        this.g = dVar;
    }

    public void setUser(User user) {
        if (this.tvAccept == null || user == null) {
            return;
        }
        WearUtils.t2(this.ivFriendAvatar, user);
        this.tvFriendName.setText(user.getShowNickName());
    }
}
