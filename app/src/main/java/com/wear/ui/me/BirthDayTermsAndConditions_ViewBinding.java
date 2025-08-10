package com.wear.ui.me;

import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class BirthDayTermsAndConditions_ViewBinding implements Unbinder {
    public BirthDayTermsAndConditions a;

    @UiThread
    public BirthDayTermsAndConditions_ViewBinding(BirthDayTermsAndConditions birthDayTermsAndConditions, View view) {
        this.a = birthDayTermsAndConditions;
        birthDayTermsAndConditions.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
        birthDayTermsAndConditions.backButton = (ImageButton) Utils.findRequiredViewAsType(view, R.id.actionbar_back, "field 'backButton'", ImageButton.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BirthDayTermsAndConditions birthDayTermsAndConditions = this.a;
        if (birthDayTermsAndConditions == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        birthDayTermsAndConditions.recyclerView = null;
        birthDayTermsAndConditions.backButton = null;
    }
}
