package com.wear.main.closeRange.spotifyMusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.toy.ToyActivity;
import com.wear.ui.home.music.NewMusicActivity;
import com.wear.widget.MyActionBar;
import dc.g12;
import dc.k12;
import dc.l12;
import dc.pj3;
import dc.sg3;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class StreamMusicLoginActivity extends BaseActivity {
    public MyActionBar a;
    public Button b;
    public StreamMusicLoginActivity c;
    public int d;
    public l12.k e = new c();

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            pj3.f(StreamMusicLoginActivity.this, ToyActivity.class);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StreamMusicLoginActivity streamMusicLoginActivity = StreamMusicLoginActivity.this;
            streamMusicLoginActivity.spotifyCheckIn(true, streamMusicLoginActivity.e);
        }
    }

    public class c implements l12.k {
        public c() {
        }

        @Override // dc.l12.k
        public void i(boolean z) {
            MusicControl.h0().e();
            if (z) {
                if (StreamMusicLoginActivity.this.d != 1) {
                    StreamMusicLoginActivity.this.setResult(33, new Intent());
                    StreamMusicLoginActivity.this.c.finish();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("intoType", 1);
                    pj3.g(StreamMusicLoginActivity.this.c, NewMusicActivity.class, bundle);
                    StreamMusicLoginActivity.this.c.finish();
                }
            }
        }

        @Override // dc.l12.k
        public void l(boolean z) {
            MusicControl.h0().e();
            sg3.i(StreamMusicLoginActivity.this.c, R.string.music_stream_login_error);
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        MusicControl.h0().e();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.remote_music_spotify);
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.a = myActionBar;
        myActionBar.setToysAction(new a(), false, this);
        this.d = getIntent().getIntExtra("intoType", 0);
        this.c = this;
        g12 g12Var = k12.m;
        Button button = (Button) findViewById(R.id.spotify_music_login);
        this.b = button;
        button.setOnClickListener(new b());
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
