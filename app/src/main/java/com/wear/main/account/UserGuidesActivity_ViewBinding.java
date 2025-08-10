package com.wear.main.account;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class UserGuidesActivity_ViewBinding implements Unbinder {
    public UserGuidesActivity a;

    @UiThread
    public UserGuidesActivity_ViewBinding(UserGuidesActivity userGuidesActivity, View view) {
        this.a = userGuidesActivity;
        userGuidesActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        userGuidesActivity.firstMenuRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.first_menu_recycler_view, "field 'firstMenuRecyclerView'", RecyclerView.class);
        userGuidesActivity.secondMenuRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.second_menu_recycler_view, "field 'secondMenuRecyclerView'", RecyclerView.class);
        userGuidesActivity.firstMenuOneData = (TextView) Utils.findRequiredViewAsType(view, R.id.first_menu_one_data, "field 'firstMenuOneData'", TextView.class);
        userGuidesActivity.firstMenuOneLl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.first_menu_one_ll, "field 'firstMenuOneLl'", LinearLayout.class);
        userGuidesActivity.firstMenuTwoOne = (TextView) Utils.findRequiredViewAsType(view, R.id.first_menu_two_one, "field 'firstMenuTwoOne'", TextView.class);
        userGuidesActivity.firstMenuTwoTwo = (TextView) Utils.findRequiredViewAsType(view, R.id.first_menu_two_two, "field 'firstMenuTwoTwo'", TextView.class);
        userGuidesActivity.firstMenuTwoLl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.first_menu_two_ll, "field 'firstMenuTwoLl'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UserGuidesActivity userGuidesActivity = this.a;
        if (userGuidesActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        userGuidesActivity.actionbar = null;
        userGuidesActivity.firstMenuRecyclerView = null;
        userGuidesActivity.secondMenuRecyclerView = null;
        userGuidesActivity.firstMenuOneData = null;
        userGuidesActivity.firstMenuOneLl = null;
        userGuidesActivity.firstMenuTwoOne = null;
        userGuidesActivity.firstMenuTwoTwo = null;
        userGuidesActivity.firstMenuTwoLl = null;
    }
}
