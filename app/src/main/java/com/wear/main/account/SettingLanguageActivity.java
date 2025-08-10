package com.wear.main.account;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.activity.orgySetting.OrgySetting;
import com.wear.bean.event.LanguageEvent;
import com.wear.bean.event.UpdateDiscoverAdsEvent;
import com.wear.main.MainActivity;
import com.wear.main.longDistance.alarm.SetAlarmActivity;
import com.wear.util.MyApplication;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.go1;
import dc.lg3;
import java.util.ArrayList;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class SettingLanguageActivity extends BaseActivity {
    public go1 a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public Button b;
    public String c;
    public String d;

    @BindView(R.id.lv_language)
    public ListView lvLanguage;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            MainActivity.c0 = true;
            SettingLanguageActivity settingLanguageActivity = SettingLanguageActivity.this;
            lg3.g(settingLanguageActivity, settingLanguageActivity.d);
            EventBus.getDefault().post(new LanguageEvent(lg3.c(lg3.e(SettingLanguageActivity.this))));
            EventBus.getDefault().post(new UpdateDiscoverAdsEvent());
            if (MyApplication.O) {
                OrgySetting.getInstance().syncOrgyActivity(null);
            }
            lg3.a(SettingLanguageActivity.this.getApplicationContext());
            SetAlarmActivity.J4();
            SettingLanguageActivity.this.finish();
        }
    }

    public class b implements go1.b {
        public b() {
        }

        @Override // dc.go1.b
        public void a(String str) {
            SettingLanguageActivity.this.d = lg3.a.get(str);
            SettingLanguageActivity settingLanguageActivity = SettingLanguageActivity.this;
            if (settingLanguageActivity.d.equals(settingLanguageActivity.c)) {
                SettingLanguageActivity.this.b.setEnabled(false);
            } else {
                SettingLanguageActivity.this.b.setEnabled(true);
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_language);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.c = lg3.d(this);
        ArrayList arrayList = new ArrayList();
        this.a = new go1(arrayList, this, R.layout.item_setting_language);
        for (Map.Entry<String, String> entry : lg3.a.entrySet()) {
            arrayList.add(entry.getKey());
            if (entry.getValue().equals(this.c)) {
                this.a.d(entry.getKey());
            }
        }
        this.lvLanguage.setAdapter((ListAdapter) this.a);
        this.actionbar.setYesAction(ah4.e(R.string.common_done), new a());
        this.b = this.actionbar.getYesBtn();
        this.a.c(new b());
        this.d = this.c;
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }
}
