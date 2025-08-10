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

/* loaded from: classes3.dex */
public class ChatBackGroudSysActivity extends BaseActivity {
    public int a = 0;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.iv_default_select)
    public ImageView ivDefaultSelect;

    @BindView(R.id.iv_whats_select)
    public ImageView ivWhatsSelect;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            nz1.e().j(ChatBackGroudSysActivity.this.a);
            ChatBackGroudSysActivity.this.finish();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_chat_back_groud_sys);
        ButterKnife.bind(this);
        int iB = nz1.e().b();
        this.a = iB;
        s4(iB);
        this.actionbar.setYesAction(R.string.common_done, new a());
        this.actionbar.getYesBtn().setEnabled(true);
    }

    @OnClick({R.id.iv_default, R.id.iv_whats})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.iv_default) {
            if (this.a == 0) {
                return;
            }
            this.a = 0;
            s4(0);
            this.actionbar.getYesBtn().setEnabled(true);
            return;
        }
        if (id == R.id.iv_whats && this.a != 1) {
            this.a = 1;
            s4(1);
            this.actionbar.getYesBtn().setEnabled(true);
        }
    }

    public final void s4(int i) {
        if (i == -1) {
            this.ivDefaultSelect.setVisibility(8);
            this.ivWhatsSelect.setVisibility(8);
        } else if (i == 1) {
            this.ivDefaultSelect.setVisibility(8);
            this.ivWhatsSelect.setVisibility(0);
        } else {
            this.ivDefaultSelect.setVisibility(0);
            this.ivWhatsSelect.setVisibility(8);
        }
    }
}
