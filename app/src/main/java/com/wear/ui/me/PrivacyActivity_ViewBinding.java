package com.wear.ui.me;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.HtmlTextView;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;

/* loaded from: classes4.dex */
public class PrivacyActivity_ViewBinding implements Unbinder {
    public PrivacyActivity a;

    @UiThread
    public PrivacyActivity_ViewBinding(PrivacyActivity privacyActivity, View view) {
        this.a = privacyActivity;
        privacyActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        privacyActivity.acceptLogsSwith = (SwitchView) Utils.findRequiredViewAsType(view, R.id.accept_logs_swith, "field 'acceptLogsSwith'", SwitchView.class);
        privacyActivity.webLink = (HtmlTextView) Utils.findRequiredViewAsType(view, R.id.web_link, "field 'webLink'", HtmlTextView.class);
        privacyActivity.sbAddGroupFriendMode = (SwitchView) Utils.findRequiredViewAsType(view, R.id.sb_add_group_friend_mode, "field 'sbAddGroupFriendMode'", SwitchView.class);
        privacyActivity.llAddGroupFriendMode = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_add_group_friend_mode, "field 'llAddGroupFriendMode'", LinearLayout.class);
        privacyActivity.llHiddenPatterns = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_hidden_patterns, "field 'llHiddenPatterns'", LinearLayout.class);
        privacyActivity.llBlockedList = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_blocked_list, "field 'llBlockedList'", LinearLayout.class);
        privacyActivity.viewBlockRed = Utils.findRequiredView(view, R.id.view_block_red, "field 'viewBlockRed'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PrivacyActivity privacyActivity = this.a;
        if (privacyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        privacyActivity.actionbar = null;
        privacyActivity.acceptLogsSwith = null;
        privacyActivity.webLink = null;
        privacyActivity.sbAddGroupFriendMode = null;
        privacyActivity.llAddGroupFriendMode = null;
        privacyActivity.llHiddenPatterns = null;
        privacyActivity.llBlockedList = null;
        privacyActivity.viewBlockRed = null;
    }
}
