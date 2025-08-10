package com.wear.main.longDistance;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.util.WearUtils;
import dc.ie3;
import dc.nz1;

/* loaded from: classes3.dex */
public class ChatMsgDetailActivity extends BaseActivity {
    public String a;
    public ie3 b = new ie3();

    @BindView(R.id.iv_rootbg)
    public ImageView iv_rootbg;

    @BindView(R.id.tv_msg_detail)
    public TextView tv_msg_detail;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatMsgDetailActivity.this.finish();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_msg_detail);
        ButterKnife.bind(this);
        nz1.e().k(this.iv_rootbg);
        String stringExtra = getIntent().getStringExtra("chat");
        this.a = stringExtra;
        this.b.j(this.tv_msg_detail, WearUtils.e1(stringExtra) ? "" : this.a, 22);
        this.tv_msg_detail.setOnClickListener(new a());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
