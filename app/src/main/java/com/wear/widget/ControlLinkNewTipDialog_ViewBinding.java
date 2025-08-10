package com.wear.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class ControlLinkNewTipDialog_ViewBinding implements Unbinder {
    public ControlLinkNewTipDialog a;

    @UiThread
    public ControlLinkNewTipDialog_ViewBinding(ControlLinkNewTipDialog controlLinkNewTipDialog, View view) {
        this.a = controlLinkNewTipDialog;
        controlLinkNewTipDialog.cancelBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.cancel_btn, "field 'cancelBtn'", TextView.class);
        controlLinkNewTipDialog.okBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.ok_btn, "field 'okBtn'", TextView.class);
        controlLinkNewTipDialog.mIivGuide = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_guide, "field 'mIivGuide'", ImageView.class);
        controlLinkNewTipDialog.mLlTipsGetTophy = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tips_get_tophy, "field 'mLlTipsGetTophy'", LinearLayout.class);
        controlLinkNewTipDialog.mLlTipsGotoDiscord = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tips_goto_discord, "field 'mLlTipsGotoDiscord'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ControlLinkNewTipDialog controlLinkNewTipDialog = this.a;
        if (controlLinkNewTipDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        controlLinkNewTipDialog.cancelBtn = null;
        controlLinkNewTipDialog.okBtn = null;
        controlLinkNewTipDialog.mIivGuide = null;
        controlLinkNewTipDialog.mLlTipsGetTophy = null;
        controlLinkNewTipDialog.mLlTipsGotoDiscord = null;
    }
}
