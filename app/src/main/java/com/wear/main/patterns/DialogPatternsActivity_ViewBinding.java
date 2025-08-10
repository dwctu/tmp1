package com.wear.main.patterns;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class DialogPatternsActivity_ViewBinding implements Unbinder {
    public DialogPatternsActivity a;

    @UiThread
    public DialogPatternsActivity_ViewBinding(DialogPatternsActivity dialogPatternsActivity, View view) {
        this.a = dialogPatternsActivity;
        dialogPatternsActivity.patternList = (ListView) Utils.findRequiredViewAsType(view, R.id.pattern_list, "field 'patternList'", ListView.class);
        dialogPatternsActivity.patternListEmpty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.pattern_list_empty, "field 'patternListEmpty'", LinearLayout.class);
        dialogPatternsActivity.ivBack = (TextView) Utils.findRequiredViewAsType(view, R.id.iv_back, "field 'ivBack'", TextView.class);
        dialogPatternsActivity.tvSend = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_send, "field 'tvSend'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DialogPatternsActivity dialogPatternsActivity = this.a;
        if (dialogPatternsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        dialogPatternsActivity.patternList = null;
        dialogPatternsActivity.patternListEmpty = null;
        dialogPatternsActivity.ivBack = null;
        dialogPatternsActivity.tvSend = null;
    }
}
