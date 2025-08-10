package com.wear.main.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.common.internal.ImagesContract;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.main.closeRange.alexa.AlexaPinActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.closeRange.spotifyMusic.StreamMusicLoginActivity;
import com.wear.protocol.EntityAlexa;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.a12;
import dc.ah4;
import dc.kn3;
import dc.l12;
import dc.nd3;
import dc.og3;
import dc.pj3;
import java.util.HashMap;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class MusicLinkedAccountActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.actionbar_account)
    public MyActionBar actionBar;

    @BindView(R.id.alexa_account)
    public LinearLayout alexaAccount;

    @BindView(R.id.alexa_account_linked)
    public TextView alexaAccountLinked;
    public boolean b;

    @BindView(R.id.music_account_google)
    public LinearLayout musicAccountGoogle;

    @BindView(R.id.music_account_google_linked)
    public TextView musicAccountGoogleLinked;

    @BindView(R.id.music_account_google_logo)
    public ImageView musicAccountGoogleLogo;

    @BindView(R.id.music_account_pandora)
    public LinearLayout musicAccountPandora;

    @BindView(R.id.music_account_pandora_linked)
    public TextView musicAccountPandoraLinked;

    @BindView(R.id.music_account_pandora_logo)
    public ImageView musicAccountPandoraLogo;

    @BindView(R.id.music_account_spotify)
    public LinearLayout musicAccountSpotify;

    @BindView(R.id.music_account_spotify_linked)
    public TextView musicAccountSpotifyLinked;

    @BindView(R.id.spotify_music_layout)
    public LinearLayout spotifyMusicLayout;
    public boolean a = false;
    public l12.k c = new f();

    public class a implements a12.d {

        /* renamed from: com.wear.main.account.MusicLinkedAccountActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0087a implements Runnable {
            public final /* synthetic */ boolean a;

            public RunnableC0087a(boolean z) {
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                MusicLinkedAccountActivity.this.w4(this.a);
            }
        }

        public a() {
        }

        @Override // dc.a12.d
        public void a(boolean z) {
            MusicLinkedAccountActivity.this.runOnUiThread(new RunnableC0087a(z));
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!WearUtils.e1(l12.m(2, ""))) {
                MusicLinkedAccountActivity.this.musicAccountSpotifyLinked.setText(ah4.e(R.string.music_login_linked));
                MusicLinkedAccountActivity.this.a = true;
            } else {
                MusicLinkedAccountActivity.this.musicAccountSpotifyLinked.setText(ah4.e(R.string.music_login_not_linked));
                MusicLinkedAccountActivity.this.a = false;
                MusicControl.h0().e.w();
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ boolean a;

        public c(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            MusicLinkedAccountActivity.this.alexaAccountLinked.setVisibility(0);
            if (this.a) {
                MusicLinkedAccountActivity.this.alexaAccountLinked.setText(ah4.e(R.string.music_login_linked));
                MusicLinkedAccountActivity.this.b = true;
            } else {
                MusicLinkedAccountActivity.this.alexaAccountLinked.setText(ah4.e(R.string.music_login_not_linked));
                MusicLinkedAccountActivity.this.b = false;
            }
        }
    }

    public class d implements kn3.d {
        public d() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            MusicControl.h0().e.n(MusicLinkedAccountActivity.this);
            MusicLinkedAccountActivity musicLinkedAccountActivity = MusicLinkedAccountActivity.this;
            musicLinkedAccountActivity.spotifyCheckIn(false, musicLinkedAccountActivity.c);
        }
    }

    public class e implements a12.d {

        public class a implements Runnable {
            public final /* synthetic */ boolean a;

            public a(boolean z) {
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("status", "-1");
                if (this.a) {
                    Bundle bundle = new Bundle();
                    bundle.putString("tag", "alexa-linked");
                    bundle.putString(MessageBundle.TITLE_ENTRY, ah4.e(R.string.remote_alexa));
                    StringBuilder sb = new StringBuilder();
                    sb.append("/alexa/guide/help?e=");
                    sb.append(WearUtils.e1(WearUtils.y.r()) ? "" : nd3.n(WearUtils.y.r()));
                    bundle.putString(ImagesContract.URL, sb.toString());
                    pj3.g(MusicLinkedAccountActivity.this, FrequentActivity.class, bundle);
                    map.put("status", "1");
                } else {
                    pj3.f(MusicLinkedAccountActivity.this, AlexaPinActivity.class);
                    map.put("status", "0");
                }
                MusicLinkedAccountActivity.this.addAnalyticsEventId("alexa", map);
            }
        }

        public e() {
        }

        @Override // dc.a12.d
        public void a(boolean z) {
            MusicLinkedAccountActivity.this.runOnUiThread(new a(z));
        }
    }

    public class f implements l12.k {
        public f() {
        }

        @Override // dc.l12.k
        public void i(boolean z) {
            if (z) {
                MusicLinkedAccountActivity musicLinkedAccountActivity = MusicLinkedAccountActivity.this;
                musicLinkedAccountActivity.a = true;
                musicLinkedAccountActivity.x4();
            } else {
                MusicLinkedAccountActivity musicLinkedAccountActivity2 = MusicLinkedAccountActivity.this;
                musicLinkedAccountActivity2.a = false;
                musicLinkedAccountActivity2.x4();
            }
        }

        @Override // dc.l12.k
        public void l(boolean z) {
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 33 || intent == null) {
            return;
        }
        this.a = true;
        x4();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.alexa_account) {
            a12.e().g(WearUtils.y.r(), false, new e());
            return;
        }
        if (id != R.id.music_account_spotify) {
            return;
        }
        if (!this.a) {
            spotifyCheckIn(false, this.c);
            pj3.o(this, StreamMusicLoginActivity.class, 33);
        } else {
            kn3 kn3Var = new kn3((Context) this, ah4.e(R.string.music_login_linked_accounts_notice), ah4.e(R.string.common_yes), ah4.e(R.string.common_no), false, (kn3.d) new d());
            kn3Var.show();
            kn3Var.r();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.remote_music_login_flow);
        ButterKnife.bind(this);
        this.actionBar.setVisibility(0);
        this.musicAccountSpotify.setOnClickListener(this);
        this.alexaAccount.setOnClickListener(this);
        this.musicAccountSpotifyLinked.setVisibility(0);
        if (og3.a(1)) {
            this.alexaAccount.setVisibility(0);
        } else {
            this.alexaAccount.setVisibility(8);
        }
        this.musicAccountGoogleLogo.setImageAlpha(85);
        this.musicAccountPandoraLogo.setImageAlpha(85);
        EventBus.getDefault().register(this);
        v4(false);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EntityAlexa entityAlexa) {
        if (entityAlexa != null) {
            v4(true);
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        x4();
    }

    public final void v4(boolean z) {
        a12.e().g(WearUtils.y.r(), z, new a());
    }

    public final void w4(boolean z) {
        runOnUiThread(new c(z));
    }

    public final void x4() {
        runOnUiThread(new b());
        v4(true);
    }
}
