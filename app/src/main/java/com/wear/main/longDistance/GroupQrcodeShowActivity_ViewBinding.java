package com.wear.main.longDistance;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.widget.MyActionBar;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public class GroupQrcodeShowActivity_ViewBinding implements Unbinder {
    public GroupQrcodeShowActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ GroupQrcodeShowActivity a;

        public a(GroupQrcodeShowActivity_ViewBinding groupQrcodeShowActivity_ViewBinding, GroupQrcodeShowActivity groupQrcodeShowActivity) {
            this.a = groupQrcodeShowActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ GroupQrcodeShowActivity a;

        public b(GroupQrcodeShowActivity_ViewBinding groupQrcodeShowActivity_ViewBinding, GroupQrcodeShowActivity groupQrcodeShowActivity) {
            this.a = groupQrcodeShowActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public GroupQrcodeShowActivity_ViewBinding(GroupQrcodeShowActivity groupQrcodeShowActivity, View view) {
        this.a = groupQrcodeShowActivity;
        groupQrcodeShowActivity.abTitle = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.ab_title, "field 'abTitle'", MyActionBar.class);
        groupQrcodeShowActivity.ivUserImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_user_img, "field 'ivUserImg'", RoundedImageView.class);
        groupQrcodeShowActivity.tvGroupName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_group_name, "field 'tvGroupName'", TextView.class);
        groupQrcodeShowActivity.ivQrcode = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_qrcode, "field 'ivQrcode'", ImageView.class);
        groupQrcodeShowActivity.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'tvTip'", TextView.class);
        groupQrcodeShowActivity.rootQrCode = (SkinCompatConstraintLayout) Utils.findRequiredViewAsType(view, R.id.root_qr_code, "field 'rootQrCode'", SkinCompatConstraintLayout.class);
        groupQrcodeShowActivity.tvLogoDes = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_logo_des, "field 'tvLogoDes'", TextView.class);
        groupQrcodeShowActivity.tvQrUpdateHint = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_qr_update_hint, "field 'tvQrUpdateHint'", TextView.class);
        groupQrcodeShowActivity.tvSaveQR = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_save_qr, "field 'tvSaveQR'", TextView.class);
        groupQrcodeShowActivity.tvShareQR = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_share_qr, "field 'tvShareQR'", TextView.class);
        groupQrcodeShowActivity.ivQrCodeBlurBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_qr_code_blur_bg, "field 'ivQrCodeBlurBg'", ImageView.class);
        groupQrcodeShowActivity.ivQrCodeBlur = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_qr_code_blur, "field 'ivQrCodeBlur'", ImageView.class);
        groupQrcodeShowActivity.tvQrShareHint = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_qr_share_hint, "field 'tvQrShareHint'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_qr_code_save, "method 'onViewClicked'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, groupQrcodeShowActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_qr_code_share, "method 'onViewClicked'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, groupQrcodeShowActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GroupQrcodeShowActivity groupQrcodeShowActivity = this.a;
        if (groupQrcodeShowActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        groupQrcodeShowActivity.abTitle = null;
        groupQrcodeShowActivity.ivUserImg = null;
        groupQrcodeShowActivity.tvGroupName = null;
        groupQrcodeShowActivity.ivQrcode = null;
        groupQrcodeShowActivity.tvTip = null;
        groupQrcodeShowActivity.rootQrCode = null;
        groupQrcodeShowActivity.tvLogoDes = null;
        groupQrcodeShowActivity.tvQrUpdateHint = null;
        groupQrcodeShowActivity.tvSaveQR = null;
        groupQrcodeShowActivity.tvShareQR = null;
        groupQrcodeShowActivity.ivQrCodeBlurBg = null;
        groupQrcodeShowActivity.ivQrCodeBlur = null;
        groupQrcodeShowActivity.tvQrShareHint = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
