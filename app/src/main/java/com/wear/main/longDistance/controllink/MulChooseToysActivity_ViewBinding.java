package com.wear.main.longDistance.controllink;

import android.view.View;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class MulChooseToysActivity_ViewBinding implements Unbinder {
    public MulChooseToysActivity a;

    @UiThread
    public MulChooseToysActivity_ViewBinding(MulChooseToysActivity mulChooseToysActivity, View view) {
        this.a = mulChooseToysActivity;
        mulChooseToysActivity.toysList = (ListView) Utils.findRequiredViewAsType(view, R.id.toys_list, "field 'toysList'", ListView.class);
        mulChooseToysActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MulChooseToysActivity mulChooseToysActivity = this.a;
        if (mulChooseToysActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mulChooseToysActivity.toysList = null;
        mulChooseToysActivity.actionbar = null;
    }
}
