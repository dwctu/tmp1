package com.wear.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;
import com.lovense.wear.R;
import dc.gg3;
import dc.is3;

/* loaded from: classes4.dex */
public class FullScreenDialog<D> extends is3<D> {
    public Activity f;

    public FullScreenDialog(Context context) {
        super(context, R.style.Fulldialog);
    }

    @Override // dc.is3
    public void h() {
        getWindow().setGravity(17);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = gg3.e(getContext());
        attributes.height = -1;
        attributes.dimAmount = 0.0f;
        getWindow().setAttributes(attributes);
    }

    public FullScreenDialog p(Activity activity) {
        this.f = activity;
        return this;
    }
}
