package com.wear.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.widget.CycleWheelView;
import dc.ah4;
import dc.sg3;
import dc.th4;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TimePickerDialog extends BottomDialog {
    public int c;

    @BindView(R.id.cancel_btn)
    public TextView cancelBtn;

    @BindView(R.id.cycleWheelView0)
    public CycleWheelView cycleWheelView0;

    @BindView(R.id.cycleWheelView1)
    public CycleWheelView cycleWheelView1;

    @BindView(R.id.cycleWheelView2)
    public CycleWheelView cycleWheelView2;
    public int d;
    public int e;
    public final String f;
    public final String g;
    public final String h;
    public f i;

    @BindView(R.id.linear)
    public LinearLayout linear;

    @BindView(R.id.ok_btn)
    public TextView okBtn;

    @BindView(R.id.title)
    public TextView title;

    public class a implements CycleWheelView.e {
        public a() {
        }

        @Override // com.wear.widget.CycleWheelView.e
        public void a(int i, String str) {
            String str2 = "onItemSelected: " + str + "hour";
            TimePickerDialog.this.c = Integer.parseInt(str);
            TimePickerDialog.this.m();
        }
    }

    public class b implements CycleWheelView.e {
        public b() {
        }

        @Override // com.wear.widget.CycleWheelView.e
        public void a(int i, String str) {
            String str2 = "onItemSelected: " + str + "minute";
            TimePickerDialog.this.d = Integer.parseInt(str);
            TimePickerDialog.this.m();
        }
    }

    public class c implements CycleWheelView.e {
        public c() {
        }

        @Override // com.wear.widget.CycleWheelView.e
        public void a(int i, String str) {
            String str2 = "onItemSelected: " + str + "second";
            TimePickerDialog.this.e = Integer.parseInt(str);
            TimePickerDialog.this.m();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePickerDialog.this.cancel();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TimePickerDialog.this.c == 0 && TimePickerDialog.this.d == 0 && TimePickerDialog.this.e == 0) {
                sg3.l(ah4.e(R.string.common_done));
                return;
            }
            if (TimePickerDialog.this.i != null) {
                TimePickerDialog.this.i.a(TimePickerDialog.this.c, TimePickerDialog.this.d, TimePickerDialog.this.e);
            }
            TimePickerDialog.this.dismiss();
        }
    }

    public interface f {
        void a(int i, int i2, int i3);
    }

    public TimePickerDialog(Context context) {
        super(context);
        this.f = ah4.e(R.string.control_link_duration_hour);
        this.g = ah4.e(R.string.str_alarm_minute);
        this.h = ah4.e(R.string.str_alarm_second);
    }

    @Override // com.wear.widget.BottomDialog
    public View b() {
        return LayoutInflater.from(this.b).inflate(R.layout.dialog_time_picker, (ViewGroup) null, false);
    }

    @Override // com.wear.widget.BottomDialog
    public void c(View view) {
        ButterKnife.bind(this, view);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 24; i++) {
            arrayList.add(i + "");
        }
        this.cycleWheelView0.setLabels(arrayList, this.f);
        this.cycleWheelView0.setAlphaGradual(0.5f);
        this.cycleWheelView0.setCycleEnable(true);
        this.cycleWheelView0.setOnWheelItemSelectedListener(new a());
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < 60; i2++) {
            arrayList2.add(i2 + "");
        }
        this.cycleWheelView1.setLabels(arrayList2, this.g);
        this.cycleWheelView1.setAlphaGradual(0.5f);
        this.cycleWheelView1.setCycleEnable(true);
        this.cycleWheelView1.setOnWheelItemSelectedListener(new b());
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < 60; i3++) {
            arrayList3.add(i3 + "");
        }
        this.cycleWheelView2.setLabels(arrayList3, this.h);
        this.cycleWheelView2.setAlphaGradual(0.5f);
        this.cycleWheelView2.setCycleEnable(true);
        this.cycleWheelView2.setOnWheelItemSelectedListener(new c());
        this.cancelBtn.setOnClickListener(new d());
        this.okBtn.setOnClickListener(new e());
    }

    public void l(int i, int i2, int i3) {
        super.show();
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.cycleWheelView0.setSelection(i);
        this.cycleWheelView1.setSelection(this.d);
        this.cycleWheelView2.setSelection(this.e);
        m();
    }

    public final void m() {
        if (this.c == 0 && this.d == 0 && this.e == 0) {
            this.okBtn.setEnabled(false);
            this.okBtn.setBackground(th4.d(this.b, R.drawable.ok_to_gray_background));
            this.okBtn.setTextColor(th4.b(this.b, R.color.ok_to_gray_text_color));
        } else {
            this.okBtn.setBackground(th4.d(this.b, R.drawable.dialog_toy_select_ok_background));
            this.okBtn.setTextColor(th4.b(this.b, R.color.dialog_toy_select_ok_color));
            this.okBtn.setEnabled(true);
        }
    }

    public TimePickerDialog(Context context, f fVar) {
        this(context);
        this.i = fVar;
    }
}
