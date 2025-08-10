package com.wear.main.longDistance.report;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.main.longDistance.ChatHistorySelectActivity;
import com.wear.util.WearUtils;
import dc.pj3;
import dc.th4;

/* loaded from: classes3.dex */
public class ReasonOptionActivity extends BaseActivity {
    public ImageView a;
    public RecyclerView b;
    public TextView c;
    public TextView d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t4(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v4(View view) {
        w4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_report_option);
        WearUtils.F.add(this);
        this.a = (ImageView) findViewById(R.id.nv_back);
        this.b = (RecyclerView) findViewById(R.id.recycler_view);
        this.c = (TextView) findViewById(R.id.notice_text_view);
        this.d = (TextView) findViewById(R.id.hint_text_view);
        this.e = getIntent().getStringExtra("group_owner");
        this.f = getIntent().getStringExtra("group_name");
        this.g = getIntent().getStringExtra(FirebaseAnalytics.Param.GROUP_ID);
        this.h = getIntent().getStringExtra("user_id");
        this.i = getIntent().getStringExtra("user_img");
        if (WearUtils.e1(this.h) && !WearUtils.e1(this.g)) {
            this.d.setText(R.string.group_report_reason_des);
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: dc.hc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.t4(view);
            }
        });
        this.b.setBackground(th4.d(this, R.drawable.report_reason_option_background));
        this.b.setAdapter(new ReasonOptionAdapter(this, this.h, this.g, this.f, this.e, this.i));
        this.c.setOnClickListener(new View.OnClickListener() { // from class: dc.ic2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.v4(view);
            }
        });
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WearUtils.F.remove(this);
    }

    public final void w4() {
        pj3.h(this, ReportNoticeActivity.class, ChatHistorySelectActivity.P, WearUtils.e1(this.h) ? 1 : 0);
    }
}
