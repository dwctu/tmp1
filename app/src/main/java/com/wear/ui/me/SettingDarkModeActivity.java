package com.wear.ui.me;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.util.MyApplication;
import com.wear.widget.MyActionBar;
import dc.pe3;

/* loaded from: classes4.dex */
public class SettingDarkModeActivity extends BaseActivity {

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.iv_off)
    public ImageView ivOff;

    @BindView(R.id.iv_on)
    public ImageView ivOn;

    @BindView(R.id.iv_sys)
    public ImageView ivSys;

    @OnClick({R.id.ll_sys, R.id.ll_open, R.id.ll_off, R.id.tv_sys})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_off /* 2131363544 */:
                if (MyApplication.m0 != 1) {
                    initTheme(1, true);
                    s4();
                    break;
                }
                break;
            case R.id.ll_open /* 2131363546 */:
                if (MyApplication.m0 != 2) {
                    initTheme(2, true);
                    s4();
                    break;
                }
                break;
            case R.id.ll_sys /* 2131363598 */:
            case R.id.tv_sys /* 2131365347 */:
                if (MyApplication.m0 != 0) {
                    pe3.i("SKIN", 0);
                    MyApplication.m0 = 0;
                    initTheme(MyApplication.l0 ? 2 : 1, false);
                    s4();
                    break;
                }
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_dark_mode);
        ButterKnife.bind(this);
        s4();
    }

    public final void s4() {
        int i = MyApplication.m0;
        if (i == 0) {
            this.ivSys.setVisibility(0);
            this.ivOn.setVisibility(8);
            this.ivOff.setVisibility(8);
        } else if (i == 2) {
            this.ivOn.setVisibility(0);
            this.ivSys.setVisibility(8);
            this.ivOff.setVisibility(8);
        } else {
            this.ivOff.setVisibility(0);
            this.ivSys.setVisibility(8);
            this.ivOn.setVisibility(8);
        }
    }
}
