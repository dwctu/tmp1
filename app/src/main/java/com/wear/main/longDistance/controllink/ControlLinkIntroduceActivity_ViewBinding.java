package com.wear.main.longDistance.controllink;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class ControlLinkIntroduceActivity_ViewBinding implements Unbinder {
    public ControlLinkIntroduceActivity a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ControlLinkIntroduceActivity a;

        public a(ControlLinkIntroduceActivity_ViewBinding controlLinkIntroduceActivity_ViewBinding, ControlLinkIntroduceActivity controlLinkIntroduceActivity) {
            this.a = controlLinkIntroduceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ControlLinkIntroduceActivity_ViewBinding(ControlLinkIntroduceActivity controlLinkIntroduceActivity, View view) {
        this.a = controlLinkIntroduceActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_start, "method 'onClick'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, controlLinkIntroduceActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
