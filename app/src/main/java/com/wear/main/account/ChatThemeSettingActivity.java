package com.wear.main.account;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.widget.MyActionBar;
import dc.nz1;
import dc.th4;

/* loaded from: classes3.dex */
public class ChatThemeSettingActivity extends BaseActivity {
    public int a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.iv_default)
    public ImageView ivDefault;

    @BindView(R.id.iv_select)
    public ImageView ivSelect;

    @BindView(R.id.iv_skype)
    public ImageView ivSkype;

    @BindView(R.id.iv_wechat)
    public ImageView ivWechat;

    @BindView(R.id.iv_whats)
    public ImageView ivWhats;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            nz1.e().m(ChatThemeSettingActivity.this.a);
            ChatThemeSettingActivity.this.finish();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_chat_theme_setting);
        ButterKnife.bind(this);
        this.actionbar.setYesAction(R.string.common_done, new a());
        this.actionbar.getYesBtn().setEnabled(true);
        int iG = nz1.e().g();
        this.a = iG;
        s4(iG);
    }

    @OnClick({R.id.rl_default, R.id.rl_whats, R.id.rl_skype, R.id.rl_wechat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_default /* 2131364259 */:
                if (this.a != 0) {
                    s4(0);
                    break;
                }
                break;
            case R.id.rl_skype /* 2131364302 */:
                if (this.a != 2) {
                    s4(2);
                    break;
                }
                break;
            case R.id.rl_wechat /* 2131364326 */:
                if (this.a != 3) {
                    s4(3);
                    break;
                }
                break;
            case R.id.rl_whats /* 2131364327 */:
                if (this.a != 1) {
                    s4(1);
                    break;
                }
                break;
        }
    }

    public final void s4(int i) {
        this.a = i;
        if (i == 1) {
            this.ivDefault.setVisibility(8);
            this.ivWhats.setVisibility(0);
            this.ivSkype.setVisibility(8);
            this.ivWechat.setVisibility(8);
            this.ivSelect.setImageDrawable(th4.d(this, R.drawable.theme_preview_whatapp));
            return;
        }
        if (i == 2) {
            this.ivDefault.setVisibility(8);
            this.ivWhats.setVisibility(8);
            this.ivSkype.setVisibility(0);
            this.ivWechat.setVisibility(8);
            this.ivSelect.setImageDrawable(th4.d(this, R.drawable.theme_preview_skype));
            return;
        }
        if (i == 3) {
            this.ivDefault.setVisibility(8);
            this.ivWhats.setVisibility(8);
            this.ivSkype.setVisibility(8);
            this.ivWechat.setVisibility(0);
            this.ivSelect.setImageDrawable(th4.d(this, R.drawable.theme_preview_wechat));
            return;
        }
        this.a = 0;
        this.ivDefault.setVisibility(0);
        this.ivWhats.setVisibility(8);
        this.ivSkype.setVisibility(8);
        this.ivWechat.setVisibility(8);
        this.ivSelect.setImageDrawable(th4.d(this, R.drawable.theme_preview_default));
    }
}
