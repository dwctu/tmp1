package com.wear.main.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class AccountDeleteActivity_ViewBinding implements Unbinder {
    public AccountDeleteActivity a;

    @UiThread
    public AccountDeleteActivity_ViewBinding(AccountDeleteActivity accountDeleteActivity, View view) {
        this.a = accountDeleteActivity;
        accountDeleteActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        accountDeleteActivity.linear = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.linear, "field 'linear'", LinearLayout.class);
        accountDeleteActivity.image = (ImageView) Utils.findRequiredViewAsType(view, R.id.image, "field 'image'", ImageView.class);
        accountDeleteActivity.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        accountDeleteActivity.editText = (EditText) Utils.findRequiredViewAsType(view, R.id.editText, "field 'editText'", EditText.class);
        accountDeleteActivity.confirm = (Button) Utils.findRequiredViewAsType(view, R.id.confirm, "field 'confirm'", Button.class);
        accountDeleteActivity.eyeImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.eyeImage, "field 'eyeImage'", ImageView.class);
        accountDeleteActivity.editTextCons = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.editTextCons, "field 'editTextCons'", ConstraintLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AccountDeleteActivity accountDeleteActivity = this.a;
        if (accountDeleteActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        accountDeleteActivity.actionbar = null;
        accountDeleteActivity.linear = null;
        accountDeleteActivity.image = null;
        accountDeleteActivity.title = null;
        accountDeleteActivity.editText = null;
        accountDeleteActivity.confirm = null;
        accountDeleteActivity.eyeImage = null;
        accountDeleteActivity.editTextCons = null;
    }
}
