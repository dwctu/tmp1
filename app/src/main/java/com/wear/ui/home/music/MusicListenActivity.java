package com.wear.ui.home.music;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.ui.home.sound.SoundPlayActivity;
import dc.pj3;
import dc.q61;
import dc.t51;
import dc.u51;
import java.util.List;

/* loaded from: classes3.dex */
public class MusicListenActivity extends BaseActivity implements View.OnClickListener {
    public TextView a;
    public TextView b;

    public class a implements u51 {
        public a() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            t51.a(this, list, z);
            MusicListenActivity.this.finish();
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                pj3.f(MusicListenActivity.this, SoundPlayActivity.class);
                MusicListenActivity.this.finish();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.cancel_tv) {
            finish();
        } else {
            if (id != R.id.connect_tv) {
                return;
            }
            q61 q61VarM = q61.m(this);
            q61VarM.h("android.permission.RECORD_AUDIO");
            q61VarM.j(new a());
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_music_listen);
        s4();
    }

    public final void s4() {
        this.a = (TextView) findViewById(R.id.connect_tv);
        this.b = (TextView) findViewById(R.id.cancel_tv);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
    }
}
