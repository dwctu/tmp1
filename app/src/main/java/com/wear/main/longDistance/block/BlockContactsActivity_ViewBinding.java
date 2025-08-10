package com.wear.main.longDistance.block;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class BlockContactsActivity_ViewBinding implements Unbinder {
    public BlockContactsActivity a;

    @UiThread
    public BlockContactsActivity_ViewBinding(BlockContactsActivity blockContactsActivity, View view) {
        this.a = blockContactsActivity;
        blockContactsActivity.actionbarAccount = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar_account, "field 'actionbarAccount'", MyActionBar.class);
        blockContactsActivity.blackContactsList = (ListView) Utils.findRequiredViewAsType(view, R.id.black_contacts_list, "field 'blackContactsList'", ListView.class);
        blockContactsActivity.listEmptyTip = (TextView) Utils.findRequiredViewAsType(view, R.id.list_empty_tip, "field 'listEmptyTip'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BlockContactsActivity blockContactsActivity = this.a;
        if (blockContactsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        blockContactsActivity.actionbarAccount = null;
        blockContactsActivity.blackContactsList = null;
        blockContactsActivity.listEmptyTip = null;
    }
}
