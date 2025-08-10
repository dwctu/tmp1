package com.wear.widget.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import dc.kn3;

/* loaded from: classes4.dex */
public class RtcWaitAcceptDialog extends FullScreenDialog {
    public kn3.d g;

    @BindView(R.id.iv_accept)
    public ImageView ivAccept;

    @BindView(R.id.iv_cancel)
    public ImageView ivCancel;

    @BindView(R.id.iv_friend_avatar)
    public RoundedImageView ivFriendAvatar;

    @BindView(R.id.iv_reject)
    public ImageView ivReject;

    @BindView(R.id.layout_calling_cancel)
    public LinearLayout layoutCallingCancel;

    @BindView(R.id.layout_receive)
    public LinearLayout layoutReceive;

    @BindView(R.id.tv_calling_notice)
    public TextView tvCallingNotice;

    @BindView(R.id.tv_come_in_notice)
    public TextView tvComeInNotice;

    @BindView(R.id.tv_friend_name)
    public TextView tvFriendName;

    public RtcWaitAcceptDialog(Context context) {
        super(context);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.activity_calling;
    }

    @OnClick({R.id.iv_cancel, R.id.iv_reject, R.id.iv_accept})
    public void onViewClicked(View view) {
        view.getId();
    }

    public void setClickListener(kn3.d dVar) {
        this.g = dVar;
    }
}
