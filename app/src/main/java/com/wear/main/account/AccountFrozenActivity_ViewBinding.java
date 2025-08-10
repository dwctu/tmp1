package com.wear.main.account;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class AccountFrozenActivity_ViewBinding implements Unbinder {
    public AccountFrozenActivity a;

    @UiThread
    public AccountFrozenActivity_ViewBinding(AccountFrozenActivity accountFrozenActivity, View view) {
        this.a = accountFrozenActivity;
        accountFrozenActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        accountFrozenActivity.linear = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.linear, "field 'linear'", LinearLayout.class);
        accountFrozenActivity.image = (ImageView) Utils.findRequiredViewAsType(view, R.id.image, "field 'image'", ImageView.class);
        accountFrozenActivity.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        accountFrozenActivity.text1 = (TextView) Utils.findRequiredViewAsType(view, R.id.text_1, "field 'text1'", TextView.class);
        accountFrozenActivity.text2 = (TextView) Utils.findRequiredViewAsType(view, R.id.text_2, "field 'text2'", TextView.class);
        accountFrozenActivity.recoverAccount = (Button) Utils.findRequiredViewAsType(view, R.id.recover_account, "field 'recoverAccount'", Button.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AccountFrozenActivity accountFrozenActivity = this.a;
        if (accountFrozenActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        accountFrozenActivity.actionbar = null;
        accountFrozenActivity.linear = null;
        accountFrozenActivity.image = null;
        accountFrozenActivity.title = null;
        accountFrozenActivity.text1 = null;
        accountFrozenActivity.text2 = null;
        accountFrozenActivity.recoverAccount = null;
    }
}
