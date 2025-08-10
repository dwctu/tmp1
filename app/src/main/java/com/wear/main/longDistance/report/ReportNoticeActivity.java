package com.wear.main.longDistance.report;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.main.longDistance.ChatHistorySelectActivity;

/* loaded from: classes3.dex */
public class ReportNoticeActivity extends BaseActivity {
    public int a;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t4(View view) {
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_notice);
        this.a = getIntent().getIntExtra(ChatHistorySelectActivity.P, 0);
        TextView textView = (TextView) findViewById(R.id.title);
        if (this.a == 1) {
            textView.setText(R.string.report_notice_title);
        }
        ((RecyclerView) findViewById(R.id.content_recycler_view)).setAdapter(new NoticeAdapter(this, this.a));
        findViewById(R.id.nv_back).setOnClickListener(new View.OnClickListener() { // from class: dc.qc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.t4(view);
            }
        });
    }
}
