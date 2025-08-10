package com.wear.main.longDistance;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.widget.RainView;

/* loaded from: classes3.dex */
public class TestActivity extends BaseActivity {

    @BindView(R.id.test_view)
    public RainView testView;

    @BindView(R.id.v_0)
    public TextView v0;

    @OnClick({R.id.btn_dog, R.id.btn_cake})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_cake) {
            this.testView.setImgResId(R.drawable.toolbar_icon_bottom_favorite);
            this.testView.d(true);
        } else {
            if (id != R.id.btn_dog) {
                return;
            }
            this.testView.setImgResId(R.drawable.toolbar_icon_bottom_emojis);
            this.testView.d(true);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
    }
}
