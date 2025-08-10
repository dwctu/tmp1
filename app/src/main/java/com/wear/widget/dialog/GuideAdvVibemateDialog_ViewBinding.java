package com.wear.widget.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class GuideAdvVibemateDialog_ViewBinding implements Unbinder {
    public GuideAdvVibemateDialog a;

    @UiThread
    public GuideAdvVibemateDialog_ViewBinding(GuideAdvVibemateDialog guideAdvVibemateDialog, View view) {
        this.a = guideAdvVibemateDialog;
        guideAdvVibemateDialog.tvDes1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_des1, "field 'tvDes1'", TextView.class);
        guideAdvVibemateDialog.tvDes2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_des2, "field 'tvDes2'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GuideAdvVibemateDialog guideAdvVibemateDialog = this.a;
        if (guideAdvVibemateDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        guideAdvVibemateDialog.tvDes1 = null;
        guideAdvVibemateDialog.tvDes2 = null;
    }
}
