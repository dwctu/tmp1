package com.wear.ui.discover.pattern;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.event.ReportSuccEvent;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.pj3;
import dc.sg3;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class ReportReasonActivity extends BaseActivity {
    public String a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public String b;
    public int c = -1;
    public int d;
    public String e;

    @BindView(R.id.reason_layout_1)
    public LinearLayout reasonLayout1;

    @BindView(R.id.reason_layout_2)
    public LinearLayout reasonLayout2;

    @BindView(R.id.reason_layout_3)
    public LinearLayout reasonLayout3;

    @BindView(R.id.reason_layout_4)
    public LinearLayout reasonLayout4;

    @BindView(R.id.reason_layout_5)
    public LinearLayout reasonLayout5;

    @BindView(R.id.reason_layout_6)
    public LinearLayout reasonLayout6;

    @BindView(R.id.submit_btn)
    public Button submitBtn;

    @OnClick({R.id.reason_layout_1, R.id.reason_layout_2, R.id.reason_layout_3, R.id.reason_layout_4, R.id.reason_layout_5, R.id.reason_layout_6, R.id.submit_btn})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.submit_btn) {
            if (this.c == 0) {
                sg3.i(this, R.string.patterns_result_report_failed);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(TtmlNode.ATTR_ID, this.a);
            String str = this.b;
            if (str != null) {
                bundle.putString("hidePatternId", str);
            }
            bundle.putInt("reportType", this.c);
            bundle.putString("reason", this.e);
            pj3.g(this, ReportReasonNextActivity.class, bundle);
        }
        switch (id) {
            case R.id.reason_layout_1 /* 2131364174 */:
                s4(view);
                this.c = 1;
                this.d = R.id.reason_layout_1;
                break;
            case R.id.reason_layout_2 /* 2131364175 */:
                s4(view);
                this.d = R.id.reason_layout_2;
                this.c = 2;
                break;
            case R.id.reason_layout_3 /* 2131364176 */:
                s4(view);
                this.d = R.id.reason_layout_3;
                this.c = 3;
                break;
            case R.id.reason_layout_4 /* 2131364177 */:
                s4(view);
                this.d = R.id.reason_layout_4;
                this.c = 4;
                break;
            case R.id.reason_layout_5 /* 2131364178 */:
                s4(view);
                this.d = R.id.reason_layout_5;
                this.c = 5;
                break;
            case R.id.reason_layout_6 /* 2131364179 */:
                s4(view);
                this.d = R.id.reason_layout_6;
                this.c = 6;
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_report_reason);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        this.a = intent.getStringExtra(TtmlNode.ATTR_ID);
        this.b = intent.getStringExtra("hidePatternId");
        this.actionbar.setTitle(ah4.e(R.string.patterns_menu_report));
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ReportSuccEvent reportSuccEvent) {
        finish();
    }

    public final void s4(View view) {
        if (this.c != -1) {
            ((ImageView) findViewById(this.d).findViewById(R.id.reason_icon)).setBackgroundResource(R.drawable.report_pattern_choose_unselect);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.reason_icon);
        TextView textView = (TextView) view.findViewById(R.id.reason_text);
        imageView.setBackgroundResource(R.drawable.report_pattern_choose_select);
        this.e = textView.getText().toString();
        findViewById(R.id.submit_btn).setEnabled(true);
    }
}
