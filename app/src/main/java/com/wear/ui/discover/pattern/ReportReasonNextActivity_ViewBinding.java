package com.wear.ui.discover.pattern;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;

/* loaded from: classes3.dex */
public class ReportReasonNextActivity_ViewBinding implements Unbinder {
    public ReportReasonNextActivity a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ReportReasonNextActivity a;

        public a(ReportReasonNextActivity_ViewBinding reportReasonNextActivity_ViewBinding, ReportReasonNextActivity reportReasonNextActivity) {
            this.a = reportReasonNextActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ReportReasonNextActivity_ViewBinding(ReportReasonNextActivity reportReasonNextActivity, View view) {
        this.a = reportReasonNextActivity;
        reportReasonNextActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        reportReasonNextActivity.messageTextNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.message_text_number, "field 'messageTextNumber'", TextView.class);
        reportReasonNextActivity.tv_ednum_tip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ednum_tip, "field 'tv_ednum_tip'", TextView.class);
        reportReasonNextActivity.messageText = (EditText) Utils.findRequiredViewAsType(view, R.id.message_text, "field 'messageText'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.submit_btn, "field 'submit_btn' and method 'onClick'");
        reportReasonNextActivity.submit_btn = (MediumBoldTextView) Utils.castView(viewFindRequiredView, R.id.submit_btn, "field 'submit_btn'", MediumBoldTextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, reportReasonNextActivity));
        reportReasonNextActivity.tv_selected_reason = (MediumBoldTextView) Utils.findRequiredViewAsType(view, R.id.tv_selected_reason, "field 'tv_selected_reason'", MediumBoldTextView.class);
        reportReasonNextActivity.swbtn_is_hidden = (SwitchView) Utils.findRequiredViewAsType(view, R.id.swbtn_is_hidden, "field 'swbtn_is_hidden'", SwitchView.class);
        reportReasonNextActivity.ll_edt_bg = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_edt_bg, "field 'll_edt_bg'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ReportReasonNextActivity reportReasonNextActivity = this.a;
        if (reportReasonNextActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        reportReasonNextActivity.actionbar = null;
        reportReasonNextActivity.messageTextNumber = null;
        reportReasonNextActivity.tv_ednum_tip = null;
        reportReasonNextActivity.messageText = null;
        reportReasonNextActivity.submit_btn = null;
        reportReasonNextActivity.tv_selected_reason = null;
        reportReasonNextActivity.swbtn_is_hidden = null;
        reportReasonNextActivity.ll_edt_bg = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
