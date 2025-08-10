package com.wear.main.account.login;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class EditEmailActivity_ViewBinding implements Unbinder {
    public EditEmailActivity a;

    @UiThread
    public EditEmailActivity_ViewBinding(EditEmailActivity editEmailActivity, View view) {
        this.a = editEmailActivity;
        editEmailActivity.actionBar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionBar'", MyActionBar.class);
        editEmailActivity.email = (EditText) Utils.findRequiredViewAsType(view, R.id.email, "field 'email'", EditText.class);
        editEmailActivity.emailContentDelete = (ImageView) Utils.findRequiredViewAsType(view, R.id.email_content_delete, "field 'emailContentDelete'", ImageView.class);
        editEmailActivity.sendEmailBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.send_email_btn, "field 'sendEmailBtn'", TextView.class);
        editEmailActivity.actionbarBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.actionbar_back, "field 'actionbarBack'", ImageView.class);
        editEmailActivity.tv_email_notice = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_email_notice, "field 'tv_email_notice'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EditEmailActivity editEmailActivity = this.a;
        if (editEmailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        editEmailActivity.actionBar = null;
        editEmailActivity.email = null;
        editEmailActivity.emailContentDelete = null;
        editEmailActivity.sendEmailBtn = null;
        editEmailActivity.actionbarBack = null;
        editEmailActivity.tv_email_notice = null;
    }
}
