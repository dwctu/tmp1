package com.wear.main.closeRange.alarm;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.HorizontalLinearLayout;

/* loaded from: classes3.dex */
public class AlarmSnoozeDialog_ViewBinding implements Unbinder {
    public AlarmSnoozeDialog a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ AlarmSnoozeDialog a;

        public a(AlarmSnoozeDialog_ViewBinding alarmSnoozeDialog_ViewBinding, AlarmSnoozeDialog alarmSnoozeDialog) {
            this.a = alarmSnoozeDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ AlarmSnoozeDialog a;

        public b(AlarmSnoozeDialog_ViewBinding alarmSnoozeDialog_ViewBinding, AlarmSnoozeDialog alarmSnoozeDialog) {
            this.a = alarmSnoozeDialog;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AlarmSnoozeDialog_ViewBinding(AlarmSnoozeDialog alarmSnoozeDialog, View view) {
        this.a = alarmSnoozeDialog;
        alarmSnoozeDialog.hllSnoozeCount = (HorizontalLinearLayout) Utils.findRequiredViewAsType(view, R.id.hll_snooze_count, "field 'hllSnoozeCount'", HorizontalLinearLayout.class);
        alarmSnoozeDialog.hllSnoozeDuration = (HorizontalLinearLayout) Utils.findRequiredViewAsType(view, R.id.hll_snooze_duration, "field 'hllSnoozeDuration'", HorizontalLinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_cancel, "field 'tvCancel' and method 'onViewClicked'");
        alarmSnoozeDialog.tvCancel = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, alarmSnoozeDialog));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_done, "field 'tvDone' and method 'onViewClicked'");
        alarmSnoozeDialog.tvDone = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_done, "field 'tvDone'", TextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, alarmSnoozeDialog));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AlarmSnoozeDialog alarmSnoozeDialog = this.a;
        if (alarmSnoozeDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        alarmSnoozeDialog.hllSnoozeCount = null;
        alarmSnoozeDialog.hllSnoozeDuration = null;
        alarmSnoozeDialog.tvCancel = null;
        alarmSnoozeDialog.tvDone = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
