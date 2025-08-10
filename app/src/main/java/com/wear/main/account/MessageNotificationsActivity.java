package com.wear.main.account;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import dc.fp2;
import dc.og3;
import dc.wm2;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class MessageNotificationsActivity extends BaseActivity implements fp2 {
    public wm2 a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.app_other_notification_control)
    public LinearLayout appOtherNotificationControl;

    @BindView(R.id.setting_notification_swith)
    public SwitchView settingNotificationSwith;

    @BindView(R.id.setting_preview_swith)
    public SwitchView settingPreviewSwith;

    @BindView(R.id.setting_sound_swith)
    public SwitchView settingSoundSwith;

    @BindView(R.id.setting_video_swith)
    public SwitchView settingVideoSwith;

    @BindView(R.id.system_notification_disabled_tips)
    public TextView systemNotificationDisabledTips;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            og3.e(1, z ? 1 : 0);
            if (z) {
                MessageNotificationsActivity.this.appOtherNotificationControl.setVisibility(0);
            } else {
                MessageNotificationsActivity.this.appOtherNotificationControl.setVisibility(8);
            }
            MessageNotificationsActivity.this.u4("notification", z ? 1 : 0);
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            og3.e(2, z ? 1 : 0);
            MessageNotificationsActivity.this.u4("notificationSound", z ? 1 : 0);
        }
    }

    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            og3.e(3, z ? 1 : 0);
            MessageNotificationsActivity.this.u4("notificationCall", z ? 1 : 0);
        }
    }

    public class d implements CompoundButton.OnCheckedChangeListener {
        public d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            og3.e(4, z ? 1 : 0);
            MessageNotificationsActivity.this.u4("notificationPreview", z ? 1 : 0);
        }
    }

    @Override // dc.fp2
    public void D3(boolean z, BaseResponseBean baseResponseBean) {
        System.out.println(baseResponseBean.getMessage());
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.o(this);
        this.mPresenter = this.a;
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_message_notification);
        ButterKnife.bind(this);
        if (og3.b(1)) {
            this.appOtherNotificationControl.setVisibility(0);
        } else {
            this.appOtherNotificationControl.setVisibility(8);
        }
        this.settingNotificationSwith.setCheckedImmediatelyNoEvent(og3.b(1));
        this.settingSoundSwith.setCheckedImmediatelyNoEvent(og3.b(2));
        this.settingVideoSwith.setCheckedImmediatelyNoEvent(og3.b(3));
        this.settingPreviewSwith.setCheckedImmediatelyNoEvent(og3.b(4));
        this.settingNotificationSwith.setOnCheckedChangeListener(new a());
        this.settingSoundSwith.setOnCheckedChangeListener(new b());
        this.settingVideoSwith.setOnCheckedChangeListener(new c());
        this.settingPreviewSwith.setOnCheckedChangeListener(new d());
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        t4();
    }

    public final void t4() {
        if (NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            this.systemNotificationDisabledTips.setVisibility(8);
        } else {
            this.systemNotificationDisabledTips.setVisibility(0);
        }
    }

    public final void u4(String str, int i) {
        if (WearUtils.y.u() != null) {
            HashMap map = new HashMap();
            map.put(str, Integer.valueOf(i));
            HashMap map2 = new HashMap();
            map2.put("config", WearUtils.A.toJson(map));
            this.a.h(false, map2);
        }
    }
}
