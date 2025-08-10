package com.wear.main.longDistance.alarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class AlarmCustomerWeekActivity extends BaseActivity implements View.OnClickListener {
    public LayoutInflater a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public int[] b = {R.string.set_alarm_customer_week_monday, R.string.set_alarm_customer_week_tuesday, R.string.set_alarm_customer_week_wednesday, R.string.set_alarm_customer_week_thursday, R.string.set_alarm_customer_week_friday, R.string.set_alarm_customer_week_saturday, R.string.set_alarm_customer_week_sunday};
    public int[] c = {0, 0, 0, 0, 0, 0, 0};

    @BindView(R.id.custom_week_layout)
    public LinearLayout customWeekLayout;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < AlarmCustomerWeekActivity.this.c.length; i++) {
                if (AlarmCustomerWeekActivity.this.c[i] > 0) {
                    arrayList.add(Integer.valueOf(i + 1));
                }
            }
            if (arrayList.size() > 0) {
                int size = arrayList.size();
                String[] strArr = new String[size];
                for (int i2 = 0; i2 < size; i2++) {
                    strArr[i2] = "" + arrayList.get(i2);
                }
                Intent intent = new Intent();
                intent.putExtra("dates", strArr);
                AlarmCustomerWeekActivity.this.setResult(-1, intent);
                AlarmCustomerWeekActivity.this.finish();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIntValue = Integer.valueOf(view.getTag().toString()).intValue();
        int[] iArr = this.c;
        iArr[iIntValue] = iArr[iIntValue] > 0 ? 0 : 1;
        u4(this.customWeekLayout.getChildAt(iIntValue), this.c[iIntValue]);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.alarm_edit_custom_week);
        ButterKnife.bind(this);
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.actionbar = myActionBar;
        myActionBar.setYesAction(R.string.common_done, new a());
        this.a = getLayoutInflater();
        String[] stringArrayExtra = getIntent().getStringArrayExtra("dates");
        if (stringArrayExtra != null) {
            for (String str : stringArrayExtra) {
                if (WearUtils.q1(str) && Integer.valueOf(str).intValue() > 0) {
                    int iIntValue = Integer.valueOf(str).intValue();
                    int[] iArr = this.c;
                    if (iIntValue <= iArr.length) {
                        iArr[Integer.valueOf(str).intValue() - 1] = 1;
                    }
                }
            }
        }
        t4();
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public final void t4() {
        this.customWeekLayout.removeAllViews();
        int[] iArr = this.c;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            View viewInflate = this.a.inflate(R.layout.alarm_custom_week_item, (ViewGroup) null);
            u4(viewInflate, i3);
            ((TextView) viewInflate.findViewById(R.id.name)).setText(ah4.e(this.b[i2]));
            viewInflate.setTag("" + i2);
            viewInflate.setOnClickListener(this);
            this.customWeekLayout.addView(viewInflate);
            i++;
            i2++;
        }
    }

    public final void u4(View view, int i) {
        ImageView imageView = (ImageView) view.findViewById(R.id.select_icon);
        if (i > 0) {
            imageView.setImageResource(R.drawable.content_icon_selectpattern_selected);
        } else {
            imageView.setImageResource(R.drawable.content_icon_selectpattern_normal);
        }
    }
}
