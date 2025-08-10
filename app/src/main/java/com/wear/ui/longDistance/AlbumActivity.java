package com.wear.ui.longDistance;

import android.os.Bundle;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;

/* loaded from: classes3.dex */
public class AlbumActivity extends BaseActivity {
    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_album);
        ButterKnife.bind(this);
    }
}
