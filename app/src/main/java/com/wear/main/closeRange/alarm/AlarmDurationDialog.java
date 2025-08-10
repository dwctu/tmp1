package com.wear.main.closeRange.alarm;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.bean.AlarmListItems;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.bf;
import dc.y02;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AlarmDurationDialog extends Dialog implements View.OnClickListener {
    public Context a;
    public y02 b;
    public AlarmListItems c;
    public c d;
    public int e;
    public int f;
    public List<String> g;
    public List<String> h;

    @BindView(R.id.ll_alarm_duration)
    public LinearLayout llAlarmDuration;

    @BindView(R.id.tv_cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_done)
    public TextView tvDone;

    @BindView(R.id.tv_title)
    public TextView tvTitle;

    @BindView(R.id.v_line_1)
    public View vLine1;

    @BindView(R.id.v_line_2)
    public View vLine2;

    public class a implements y02.b {
        public a() {
        }

        @Override // dc.y02.b
        public void a(int i, int i2, int i3, int i4, View view) {
            if (i2 != 0 || i3 >= 5) {
                AlarmDurationDialog alarmDurationDialog = AlarmDurationDialog.this;
                alarmDurationDialog.tvDone.setBackgroundColor(ContextCompat.getColor(alarmDurationDialog.a, R.color.buttom_select_background));
                AlarmDurationDialog.this.tvDone.setEnabled(true);
            } else {
                AlarmDurationDialog alarmDurationDialog2 = AlarmDurationDialog.this;
                alarmDurationDialog2.tvDone.setBackgroundColor(ContextCompat.getColor(alarmDurationDialog2.a, R.color.tab_top_line_light));
                AlarmDurationDialog.this.tvDone.setEnabled(false);
            }
            AlarmDurationDialog alarmDurationDialog3 = AlarmDurationDialog.this;
            alarmDurationDialog3.e = i2;
            alarmDurationDialog3.f = i3;
        }

        @Override // dc.y02.b
        public void b() {
        }
    }

    public class b implements bf {
        public b(AlarmDurationDialog alarmDurationDialog) {
        }

        @Override // dc.bf
        public void a(View view) {
            view.findViewById(R.id.top_action_layout).setVisibility(8);
        }
    }

    public interface c {
        void a(AlarmListItems alarmListItems);
    }

    public AlarmDurationDialog(Context context, AlarmListItems alarmListItems) {
        super(context, R.style.MaterialDialogSheet);
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.a = context;
        this.c = alarmListItems;
    }

    public final y02 a(ViewGroup viewGroup, y02.b bVar) {
        this.g.clear();
        this.h.clear();
        for (int i = 0; i <= 59; i++) {
            if (i < 10) {
                this.g.add(i + ah4.e(R.string.str_alarm_minute));
                this.h.add(i + ah4.e(R.string.str_alarm_second));
            } else {
                this.g.add(i + ah4.e(R.string.str_alarm_minute));
                this.h.add(i + ah4.e(R.string.str_alarm_second));
            }
        }
        y02.a aVar = new y02.a(this.a, bVar);
        aVar.W(true);
        aVar.V(true);
        aVar.R(true, true, false);
        aVar.S(viewGroup);
        aVar.U(true);
        aVar.M(true);
        aVar.X(R.layout.view_alarm_duration, new b(this));
        aVar.T(ContextCompat.getColor(this.a, R.color.list_divider_light));
        aVar.N(false);
        aVar.Y(false);
        aVar.Y(false);
        if (MyApplication.m0 == 2 || MyApplication.l0) {
            aVar.Z(this.a.getResources().getColor(R.color.white));
        } else {
            aVar.Z(this.a.getResources().getColor(R.color.text_primary_light));
        }
        y02 y02Var = new y02(aVar);
        List<String> list = this.g;
        y02Var.C(list, this.h, list);
        y02Var.v(false);
        return y02Var;
    }

    public void b() {
        setContentView(LayoutInflater.from(this.a).inflate(R.layout.dialog_alarm_create_duration, (ViewGroup) null));
        ButterKnife.bind(this);
        WearUtils.q2(this);
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setAttributes(attributes);
        this.b = a(this.llAlarmDuration, new a());
        if (this.c != null) {
            this.tvDone.setBackgroundColor(ContextCompat.getColor(this.a, R.color.buttom_select_background));
            this.tvDone.setEnabled(true);
            if (this.c.getDuration() != 0) {
                this.e = this.c.getDuration() / 60;
                int duration = this.c.getDuration() % 60;
                this.f = duration;
                this.b.E(this.e, duration, 0);
            } else {
                this.e = 1;
                this.f = 0;
                this.b.E(1, 0, 0);
            }
        }
        this.tvDone.setOnClickListener(this);
        this.tvCancel.setOnClickListener(this);
    }

    public void c(c cVar) {
        this.d = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            dismiss();
        } else {
            if (id != R.id.tv_done) {
                return;
            }
            if (this.d != null) {
                this.c.setDuration((this.e * 60) + this.f);
                this.d.a(this.c);
            }
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
    }
}
