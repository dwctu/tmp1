package com.wear.main.longDistance.report;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.util.WearUtils;
import dc.pj3;
import dc.sg3;
import dc.ue3;

/* loaded from: classes3.dex */
public class OtherReason extends BaseActivity {
    public String a;
    public String b;
    public String c;
    public String d;
    public EditText e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u4(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w4(View view) {
        String string = this.e.getText().toString();
        if (string.length() < 6) {
            sg3.h(R.string.notification_enter_reason);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("user_id", this.a);
        bundle.putString(FirebaseAnalytics.Param.GROUP_ID, this.b);
        bundle.putString("group_name", this.c);
        bundle.putString("group_owner", this.d);
        bundle.putString("reason_key", "t4");
        bundle.putString("other_reasul_key", string);
        pj3.g(this, ReportActivity.class, bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return getWindow().superDispatchTouchEvent(motionEvent) || onTouchEvent(motionEvent);
        }
        if (s4(getCurrentFocus(), motionEvent) && ((InputMethodManager) getSystemService("input_method")) != null) {
            ue3.a(this.e, this);
            EditText editText = this.e;
            if (editText != null) {
                editText.clearFocus();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_other_reason);
        this.a = getIntent().getStringExtra("user_id");
        this.b = getIntent().getStringExtra(FirebaseAnalytics.Param.GROUP_ID);
        this.c = getIntent().getStringExtra("group_name");
        this.d = getIntent().getStringExtra("group_owner");
        this.e = (EditText) findViewById(R.id.edit_text_view);
        WearUtils.F.add(this);
        findViewById(R.id.nv_back).setOnClickListener(new View.OnClickListener() { // from class: dc.fc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.u4(view);
            }
        });
        findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener() { // from class: dc.gc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.w4(view);
            }
        });
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WearUtils.F.remove(this);
    }

    public boolean s4(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) (view.getWidth() + i)) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) (view.getHeight() + i2));
    }
}
