package com.wear.main.closeRange.alarm;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.bean.AlarmListItems;
import com.wear.util.WearUtils;
import com.wear.widget.HorizontalLinearLayout;

/* loaded from: classes3.dex */
public class AlarmSnoozeDialog extends Dialog {
    public Context a;
    public AlarmListItems b;
    public a c;

    @BindView(R.id.hll_snooze_count)
    public HorizontalLinearLayout hllSnoozeCount;

    @BindView(R.id.hll_snooze_duration)
    public HorizontalLinearLayout hllSnoozeDuration;

    @BindView(R.id.tv_cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_done)
    public TextView tvDone;

    public interface a {
        void a(AlarmListItems alarmListItems);
    }

    public AlarmSnoozeDialog(Context context, AlarmListItems alarmListItems) {
        super(context, R.style.MaterialDialogSheet);
        this.a = context;
        this.b = alarmListItems;
    }

    public void a() {
        setContentView(LayoutInflater.from(this.a).inflate(R.layout.dialog_alarm_snooze, (ViewGroup) null));
        ButterKnife.bind(this);
        WearUtils.q2(this);
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setAttributes(attributes);
        AlarmListItems alarmListItems = this.b;
        if (alarmListItems != null) {
            this.hllSnoozeCount.setSelect(alarmListItems.getSnoozeCount());
            this.hllSnoozeDuration.setSelect(this.b.getSnoozeDuration());
            if (this.b.getSnoozeDuration() == 0) {
                this.hllSnoozeDuration.setSelect(10);
                this.hllSnoozeCount.setSelect(0);
            }
        }
    }

    public void b(a aVar) {
        this.c = aVar;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    @OnClick({R.id.tv_cancel, R.id.tv_done})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            dismiss();
            return;
        }
        if (id != R.id.tv_done) {
            return;
        }
        AlarmListItems alarmListItems = this.b;
        if (alarmListItems != null) {
            alarmListItems.setSnoozeCount(this.hllSnoozeCount.getSelect());
            this.b.setSnoozeDuration(this.hllSnoozeDuration.getSelect());
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(this.b);
        }
        dismiss();
    }
}
