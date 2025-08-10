package com.wear.main.longDistance.controllink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.util.WearUtils;
import dc.pj3;

/* loaded from: classes3.dex */
public class ControlLinkIntroduceActivity extends BaseActivity {
    @OnClick({R.id.tv_start})
    public void onClick(View view) {
        if (view.getId() != R.id.tv_start) {
            return;
        }
        WearUtils.x.q("controlLink", null);
        Intent intent = new Intent(this, (Class<?>) ControlLinkNewActivity.class);
        pj3.d(intent);
        startActivity(intent);
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_control_link_introduce);
        ButterKnife.bind(this);
    }
}
