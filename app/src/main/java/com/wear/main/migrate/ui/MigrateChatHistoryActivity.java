package com.wear.main.migrate.ui;

import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import dc.kd2;
import dc.pj3;

/* loaded from: classes3.dex */
public class MigrateChatHistoryActivity extends BaseActivity {
    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_migrate_chat_history);
        ButterKnife.bind(this);
        kd2.C().s(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        kd2.C().J(this);
    }

    @OnClick({R.id.rl_chat_migrate})
    public void onViewClicked(View view) {
        if (view.getId() != R.id.rl_chat_migrate) {
            return;
        }
        pj3.f(this, ChatMigratePtoActivity.class);
    }
}
