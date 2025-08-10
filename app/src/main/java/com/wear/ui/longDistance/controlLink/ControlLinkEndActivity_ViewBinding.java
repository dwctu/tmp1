package com.wear.ui.longDistance.controlLink;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.MyActionBar;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public class ControlLinkEndActivity_ViewBinding implements Unbinder {
    public ControlLinkEndActivity a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ControlLinkEndActivity a;

        public a(ControlLinkEndActivity_ViewBinding controlLinkEndActivity_ViewBinding, ControlLinkEndActivity controlLinkEndActivity) {
            this.a = controlLinkEndActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ControlLinkEndActivity a;

        public b(ControlLinkEndActivity_ViewBinding controlLinkEndActivity_ViewBinding, ControlLinkEndActivity controlLinkEndActivity) {
            this.a = controlLinkEndActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ControlLinkEndActivity a;

        public c(ControlLinkEndActivity_ViewBinding controlLinkEndActivity_ViewBinding, ControlLinkEndActivity controlLinkEndActivity) {
            this.a = controlLinkEndActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ControlLinkEndActivity_ViewBinding(ControlLinkEndActivity controlLinkEndActivity, View view) {
        this.a = controlLinkEndActivity;
        controlLinkEndActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        controlLinkEndActivity.tv_title = (MediumBoldTextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tv_title'", MediumBoldTextView.class);
        controlLinkEndActivity.tv_content = (MediumBoldTextView) Utils.findRequiredViewAsType(view, R.id.tv_content, "field 'tv_content'", MediumBoldTextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_confirm, "field 'tv_confirm' and method 'onClick'");
        controlLinkEndActivity.tv_confirm = (MediumBoldTextView) Utils.castView(viewFindRequiredView, R.id.tv_confirm, "field 'tv_confirm'", MediumBoldTextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, controlLinkEndActivity));
        controlLinkEndActivity.cl_survey_banner = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cl_survey_banner, "field 'cl_survey_banner'", ConstraintLayout.class);
        controlLinkEndActivity.repeatText = (MediumBoldTextView) Utils.findRequiredViewAsType(view, R.id.repeat_text, "field 'repeatText'", MediumBoldTextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_reactivate, "field 'tvReactivate' and method 'onClick'");
        controlLinkEndActivity.tvReactivate = (MediumBoldTextView) Utils.castView(viewFindRequiredView2, R.id.tv_reactivate, "field 'tvReactivate'", MediumBoldTextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, controlLinkEndActivity));
        controlLinkEndActivity.dpgIv = (ImageView) Utils.findRequiredViewAsType(view, R.id.dpgIv, "field 'dpgIv'", ImageView.class);
        controlLinkEndActivity.adRly = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ad_rly, "field 'adRly'", RelativeLayout.class);
        controlLinkEndActivity.closeIv = (ImageView) Utils.findRequiredViewAsType(view, R.id.close_iv, "field 'closeIv'", ImageView.class);
        controlLinkEndActivity.mIvEndImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_end_image, "field 'mIvEndImage'", ImageView.class);
        controlLinkEndActivity.mTvEndDescribe = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_end_describe, "field 'mTvEndDescribe'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_survey_check, "method 'onClick'");
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, controlLinkEndActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ControlLinkEndActivity controlLinkEndActivity = this.a;
        if (controlLinkEndActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        controlLinkEndActivity.actionbar = null;
        controlLinkEndActivity.tv_title = null;
        controlLinkEndActivity.tv_content = null;
        controlLinkEndActivity.tv_confirm = null;
        controlLinkEndActivity.cl_survey_banner = null;
        controlLinkEndActivity.repeatText = null;
        controlLinkEndActivity.tvReactivate = null;
        controlLinkEndActivity.dpgIv = null;
        controlLinkEndActivity.adRly = null;
        controlLinkEndActivity.closeIv = null;
        controlLinkEndActivity.mIvEndImage = null;
        controlLinkEndActivity.mTvEndDescribe = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
