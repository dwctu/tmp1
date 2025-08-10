package com.wear.main;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class MainActivity_ViewBinding implements Unbinder {
    public MainActivity a;

    @UiThread
    public MainActivity_ViewBinding(MainActivity mainActivity, View view) {
        this.a = mainActivity;
        mainActivity.viewStubGuide = (ViewStub) Utils.findRequiredViewAsType(view, R.id.view_stub_guide, "field 'viewStubGuide'", ViewStub.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MainActivity mainActivity = this.a;
        if (mainActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mainActivity.viewStubGuide = null;
    }
}
