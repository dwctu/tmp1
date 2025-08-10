package com.wear.main.longDistance.report;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.util.WearUtils;
import dc.pj3;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ResultActivity extends BaseActivity {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t4(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v4(String str, String str2, String str3, String str4, String str5, View view) {
        Bundle bundle = new Bundle();
        bundle.putString("user_id", str);
        bundle.putString(FirebaseAnalytics.Param.GROUP_ID, str2);
        bundle.putString("group_name", str3);
        bundle.putString("group_owner", str4);
        bundle.putString("user_img", str5);
        pj3.g(this, ReasonOptionActivity.class, bundle);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x4(View view) {
        Iterator<Activity> it = WearUtils.F.iterator();
        while (it.hasNext()) {
            it.next().finish();
        }
        WearUtils.F.clear();
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.report_result_activity);
        int intExtra = getIntent().getIntExtra("status", 0);
        AppCompatButton appCompatButton = (AppCompatButton) findViewById(R.id.ok_btn);
        ImageView imageView = (ImageView) findViewById(R.id.nav_back);
        TextView textView = (TextView) findViewById(R.id.result_text);
        TextView textView2 = (TextView) findViewById(R.id.result_text2);
        ImageView imageView2 = (ImageView) findViewById(R.id.report_icon);
        TextView textView3 = (TextView) findViewById(R.id.report_gain);
        if (intExtra == 0) {
            appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: dc.rc2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.x4(view);
                }
            });
            return;
        }
        final String stringExtra = getIntent().getStringExtra("user_id");
        final String stringExtra2 = getIntent().getStringExtra(FirebaseAnalytics.Param.GROUP_ID);
        final String stringExtra3 = getIntent().getStringExtra("group_name");
        final String stringExtra4 = getIntent().getStringExtra("group_owner");
        final String stringExtra5 = getIntent().getStringExtra("user_img");
        imageView.setVisibility(0);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.sc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.t4(view);
            }
        });
        appCompatButton.setVisibility(8);
        textView2.setVisibility(0);
        textView.setText(R.string.report_under_review_title);
        imageView2.setImageResource(R.drawable.submit_under_review);
        textView3.setVisibility(0);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: dc.tc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.v4(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, view);
            }
        });
    }
}
