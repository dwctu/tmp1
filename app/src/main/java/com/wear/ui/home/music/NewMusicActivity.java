package com.wear.ui.home.music;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.backgroundservice.service.MusicCaptureService;
import com.wear.bean.MusicPlaylist;
import com.wear.bean.MusicPlaylistItems;
import com.wear.bean.event.OpenLockEvent;
import com.wear.dao.DaoUtils;
import com.wear.dao.MusicDao;
import com.wear.dao.TestValueDao;
import com.wear.main.MainActivity;
import com.wear.main.closeRange.MusicRecordActivity;
import com.wear.main.closeRange.localMusic.CreateMusicPlaylistActivity;
import com.wear.main.closeRange.localMusic.PlaylistDetailsActivity;
import com.wear.main.closeRange.localMusic.SearchLocalMusicActivity;
import com.wear.main.closeRange.localMusic.SearchPlayListActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.closeRange.spotifyMusic.SearchStreamMusicActivity;
import com.wear.main.toy.ToyActivity;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.ui.home.music.fragment.MusicAppListFragment;
import com.wear.ui.home.music.fragment.MusicLocalFragment;
import com.wear.ui.home.music.fragment.MusicPlayListFragment;
import com.wear.ui.home.music.fragment.MusicSpotifyFragment;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MediumBoldRadioButton;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.cj3;
import dc.cs3;
import dc.g12;
import dc.is3;
import dc.k12;
import dc.kn3;
import dc.ku1;
import dc.l12;
import dc.me3;
import dc.na2;
import dc.nd3;
import dc.pe3;
import dc.pj3;
import dc.q61;
import dc.se3;
import dc.sg3;
import dc.t51;
import dc.u51;
import dc.ye3;
import dc.zt3;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class NewMusicActivity extends BaseActivity implements View.OnClickListener {
    public static boolean o = false;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.bib_icon_music_panel_record)
    public View bibIconMusicPanelRecord;
    public boolean e;
    public MusicLocalFragment f;
    public MusicSpotifyFragment g;
    public MusicPlayListFragment h;
    public MusicAppListFragment i;

    @BindView(R.id.iv_permission)
    public ImageView ivPermission;

    @BindView(R.id.iv_search)
    public ImageView ivSearch;

    @BindView(R.id.iv_music_search)
    public ImageView iv_music_search;

    @BindView(R.id.ll_permission)
    public LinearLayout llPermission;

    @BindView(R.id.loading_layer)
    public LinearLayout loadingLayer;

    @BindView(R.id.local_red_dot)
    public View localRedDot;

    @BindView(R.id.local_music)
    public MediumBoldRadioButton local_music;

    @BindView(R.id.fl_sound_record)
    public FrameLayout mFlSoundRecord;

    @BindView(R.id.app_list_music)
    public View mVAppListMusicRedDot;

    @BindView(R.id.music_album_list)
    public RadioButton music_album_list;

    @BindView(R.id.music_app)
    public MediumBoldRadioButton music_app;

    @BindView(R.id.music_artist_list)
    public RadioButton music_artist_list;

    @BindView(R.id.music_create_layout)
    public View music_create_layout;

    @BindView(R.id.music_create_layout_bottom_line)
    public View music_create_layout_bottom_line;

    @BindView(R.id.music_list_layout)
    public View music_list_layout;

    @BindView(R.id.music_song_list)
    public RadioButton music_song_list;

    @BindView(R.id.music_type_layout)
    public View music_type_layout;
    public Unbinder n;

    @BindView(R.id.playlist_red_dot)
    public View playlistRedDot;

    @BindView(R.id.playlist_music)
    public MediumBoldRadioButton playlist_music;

    @BindView(R.id.rl_icon_music_panel_record)
    public RelativeLayout rlIconMusicPanelRecord;

    @BindView(R.id.stream_red_dot)
    public View streamRedDot;

    @BindView(R.id.stream_music)
    public MediumBoldRadioButton stream_music;
    public int a = -1;
    public int b = -1;
    public boolean c = false;
    public int d = -1;
    public FragmentManager j = getSupportFragmentManager();
    public boolean k = false;
    public MusicControl.f l = new a();
    public long m = 0;

    public class a implements MusicControl.f {

        /* renamed from: com.wear.ui.home.music.NewMusicActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0145a implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ boolean c;

            public RunnableC0145a(int i, int i2, boolean z) {
                this.a = i;
                this.b = i2;
                this.c = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = this.a;
                if (i == 0) {
                    NewMusicActivity.this.D4(R.id.local_music, this.b, this.c);
                    if (NewMusicActivity.this.k) {
                        NewMusicActivity.this.k = false;
                        return;
                    }
                    return;
                }
                if (i != 2) {
                    if (i == 1) {
                        NewMusicActivity.this.D4(R.id.playlist_music, this.b, this.c);
                    }
                } else {
                    String str = "run: " + this.b;
                    NewMusicActivity.this.D4(R.id.stream_music, this.b, this.c);
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NewMusicActivity.this.g.d0();
                NewMusicActivity.this.music_type_layout.setVisibility(8);
                NewMusicActivity.this.music_create_layout_bottom_line.setVisibility(8);
                NewMusicActivity.this.music_create_layout.setVisibility(8);
                NewMusicActivity.this.music_list_layout.invalidate();
                MusicControl.h0().e.onLoggedOut();
                sg3.l(ah4.e(R.string.music_stream_login_error));
            }
        }

        public a() {
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void a(int i) {
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void b(boolean z) {
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void c(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("test doGetAsyn 000: ");
            sb.append(Looper.getMainLooper() == Looper.myLooper());
            sb.toString();
            MusicLocalFragment musicLocalFragment = NewMusicActivity.this.f;
            if (musicLocalFragment != null && musicLocalFragment.isAdded()) {
                NewMusicActivity.this.f.j0(i);
            }
            MusicSpotifyFragment musicSpotifyFragment = NewMusicActivity.this.g;
            if (musicSpotifyFragment != null && musicSpotifyFragment.isAdded()) {
                NewMusicActivity.this.g.g0(i);
            }
            NewMusicActivity.this.d = i;
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void d(int i) {
            if (i == 0 && NewMusicActivity.this.a == R.id.stream_music && MusicControl.h0().e.i.size() == 0) {
                NewMusicActivity.this.runOnUiThread(new b());
            }
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void e(boolean z) {
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void f(int i, int i2, boolean z) {
            NewMusicActivity.this.runOnUiThread(new RunnableC0145a(i, i2, z));
        }
    }

    public class b extends TimerTask {
        public b(NewMusicActivity newMusicActivity) {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (MusicControl.h0().d != null) {
                MusicControl.h0().d.h();
            }
        }
    }

    public class c extends HashMap<String, String> {
        public c() {
            put("sensitivity", "50");
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
            RequestPermissionActivity.s4(NewMusicActivity.this);
        }
    }

    public class e implements u51 {
        public e() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            t51.a(this, list, z);
            LinearLayout linearLayout = NewMusicActivity.this.llPermission;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            NewMusicActivity newMusicActivity = NewMusicActivity.this;
            if (newMusicActivity.e) {
                return;
            }
            newMusicActivity.I4(ah4.e(R.string.app_open_must_permission_new), false);
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            LinearLayout linearLayout;
            if (!z || (linearLayout = NewMusicActivity.this.llPermission) == null) {
                return;
            }
            linearLayout.setVisibility(8);
        }
    }

    public class f implements kn3.d {
        public f() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            RequestPermissionActivity.s4(NewMusicActivity.this);
        }
    }

    public class g implements MyActionBar.f {
        public g() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            pj3.f(NewMusicActivity.this, ToyActivity.class);
        }
    }

    public class h implements MyActionBar.f {

        public class a implements g12.f {
            public a() {
            }

            @Override // dc.g12.f
            public void a() {
                NewMusicActivity.this.finish();
            }
        }

        public h() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            if (MusicControl.h0().f == null || !MusicControl.h0().O()) {
                NewMusicActivity.this.finish();
            } else {
                MusicControl.h0().Z(NewMusicActivity.this, new a());
            }
        }
    }

    public class i implements is3.d {
        public i() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            NewMusicActivity.this.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + NewMusicActivity.this.getPackageName())), 0);
        }
    }

    public class j implements is3.c {
        public j(NewMusicActivity newMusicActivity) {
        }

        @Override // dc.is3.c
        public void doCancel() {
            DaoUtils.getTestValueDao().save(zt3.k, "0", TestValueDao.NINJA_MODE_SWITCH_TYPE);
            EventBus.getDefault().post(new OpenLockEvent(false));
        }
    }

    public class k implements g12.f {
        public k() {
        }

        @Override // dc.g12.f
        public void a() {
            NewMusicActivity.this.finish();
        }
    }

    public class l implements l12.k {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.d0 = false;
                try {
                    NewMusicActivity newMusicActivity = NewMusicActivity.this;
                    newMusicActivity.x4(newMusicActivity.a);
                    MusicControl.h0().e();
                    MusicControl.f fVar = NewMusicActivity.this.l;
                    if (fVar != null) {
                        fVar.d(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.d0 = true;
                try {
                    NewMusicActivity newMusicActivity = NewMusicActivity.this;
                    newMusicActivity.x4(newMusicActivity.a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public l() {
        }

        @Override // dc.l12.k
        public void i(boolean z) {
            NewMusicActivity.this.runOnMainThread(new b());
            String str = "initLoginSpotify finish:  " + MusicControl.h0().e.t();
        }

        @Override // dc.l12.k
        public void l(boolean z) {
            NewMusicActivity.this.runOnMainThread(new a());
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NewMusicActivity.this.rlIconMusicPanelRecord.setEnabled(true);
            NewMusicActivity.this.bibIconMusicPanelRecord.setEnabled(true);
            if (MusicControl.h0().f == null) {
                return;
            }
            pj3.f(NewMusicActivity.this, MusicRecordActivity.class);
        }
    }

    public final void A4(Bundle bundle) {
        if (bundle != null) {
            this.a = bundle.getInt("tabId", R.id.ll_app_list_music);
            this.b = bundle.getInt("typeId", R.id.music_song_list);
            this.f = (MusicLocalFragment) this.j.getFragment(bundle, MusicLocalFragment.class.getSimpleName());
            this.g = (MusicSpotifyFragment) this.j.getFragment(bundle, MusicSpotifyFragment.class.getSimpleName());
            this.h = (MusicPlayListFragment) this.j.getFragment(bundle, MusicPlayListFragment.class.getSimpleName());
            this.i = (MusicAppListFragment) this.j.getFragment(bundle, MusicAppListFragment.class.getSimpleName());
            MusicLocalFragment musicLocalFragment = this.f;
            if (musicLocalFragment != null) {
                musicLocalFragment.n0(this.b);
            }
            MusicSpotifyFragment musicSpotifyFragment = this.g;
            if (musicSpotifyFragment != null) {
                musicSpotifyFragment.i0(this.b);
            }
            MusicAppListFragment musicAppListFragment = this.i;
            if (musicAppListFragment != null) {
                musicAppListFragment.h0(this.b);
            }
            int i2 = this.a;
            if (i2 == R.id.playlist_music) {
                this.music_type_layout.setVisibility(8);
                this.music_create_layout.setVisibility(0);
                this.music_create_layout_bottom_line.setVisibility(0);
                this.music_list_layout.invalidate();
            } else if (i2 == R.id.stream_music) {
                if (MusicControl.h0().e.t()) {
                    this.music_type_layout.setVisibility(0);
                    this.music_create_layout_bottom_line.setVisibility(0);
                } else {
                    this.music_type_layout.setVisibility(8);
                    this.music_create_layout_bottom_line.setVisibility(8);
                }
                this.music_create_layout.setVisibility(8);
                this.music_list_layout.invalidate();
            } else {
                this.music_type_layout.setVisibility(0);
                this.music_create_layout.setVisibility(8);
                this.music_create_layout_bottom_line.setVisibility(0);
                this.music_list_layout.invalidate();
            }
        } else {
            if (q61.f(this, "android.permission.READ_MEDIA_AUDIO")) {
                this.a = R.id.local_music;
            } else {
                this.a = R.id.music_app;
            }
            this.b = R.id.music_song_list;
            if (getIntent() != null && getIntent().getIntExtra("intoType", 0) == 1) {
                MainActivity.d0 = true;
                this.a = R.id.stream_music;
            }
        }
        if (this.f == null) {
            this.f = new MusicLocalFragment();
        }
        if (this.g == null) {
            this.g = new MusicSpotifyFragment();
        }
        if (this.h == null) {
            this.h = new MusicPlayListFragment();
        }
        if (this.i == null) {
            this.i = new MusicAppListFragment();
        }
        if (MusicControl.h0().f != null) {
            if (MusicControl.h0().f.getMusicType() == 0) {
                this.a = R.id.local_music;
            } else if (MusicControl.h0().f.getMusicType() == 2) {
                this.a = R.id.music_app;
            } else if (MusicControl.h0().f.getMusicType() == 1) {
                this.a = R.id.stream_music;
            }
        }
        H4(this.a);
    }

    public void B4() {
        if (MusicControl.h0().e.t()) {
            MainActivity.d0 = true;
            x4(this.a);
        } else if (WearUtils.e1(l12.m(2, ""))) {
            x4(this.a);
        } else {
            spotifyCheckIn(true, new l());
        }
    }

    public void C4() throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        onResume();
    }

    public void D4(int i2, int i3, boolean z) {
        MusicPlayListFragment musicPlayListFragment;
        if (i2 == R.id.local_music) {
            MusicLocalFragment musicLocalFragment = this.f;
            if (musicLocalFragment == null || !musicLocalFragment.isAdded()) {
                return;
            }
            this.f.p0(i3);
            this.f.k0(this.b);
            return;
        }
        if (i2 != R.id.stream_music) {
            if (i2 == R.id.playlist_music && (musicPlayListFragment = this.h) != null && musicPlayListFragment.isAdded()) {
                this.h.X();
                return;
            }
            return;
        }
        MusicSpotifyFragment musicSpotifyFragment = this.g;
        if (musicSpotifyFragment == null || !musicSpotifyFragment.isAdded()) {
            return;
        }
        this.g.j0(i3, z);
        this.music_type_layout.setVisibility(0);
        if (i3 > 20 && !k12.n) {
            this.g.b0(this.b);
        } else {
            k12.n = false;
            this.g.h0(this.b);
        }
    }

    public void E4() {
        MusicLocalFragment musicLocalFragment = this.f;
        if (musicLocalFragment != null && musicLocalFragment.isAdded()) {
            this.f.k0(this.b);
        }
        MusicSpotifyFragment musicSpotifyFragment = this.g;
        if (musicSpotifyFragment == null || !musicSpotifyFragment.isAdded()) {
            return;
        }
        this.g.h0(this.b);
    }

    @SuppressLint({"CheckResult"})
    public final void F4() {
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.RECORD_AUDIO");
        q61VarM.j(new e());
    }

    public void G4(int i2) {
    }

    public final void H4(int i2) {
        if (i2 == R.id.local_music) {
            this.local_music.setChecked(true);
            this.stream_music.setChecked(false);
            this.playlist_music.setChecked(false);
            this.music_app.setChecked(false);
            this.localRedDot.setVisibility(0);
            this.streamRedDot.setVisibility(8);
            this.playlistRedDot.setVisibility(8);
            this.mVAppListMusicRedDot.setVisibility(8);
            return;
        }
        if (i2 == R.id.stream_music) {
            this.local_music.setChecked(false);
            this.stream_music.setChecked(true);
            this.playlist_music.setChecked(false);
            this.music_app.setChecked(false);
            this.localRedDot.setVisibility(8);
            this.streamRedDot.setVisibility(0);
            this.playlistRedDot.setVisibility(8);
            this.mVAppListMusicRedDot.setVisibility(8);
            return;
        }
        if (i2 == R.id.music_app) {
            this.local_music.setChecked(false);
            this.stream_music.setChecked(false);
            this.playlist_music.setChecked(false);
            this.music_app.setChecked(true);
            this.localRedDot.setVisibility(8);
            this.streamRedDot.setVisibility(8);
            this.playlistRedDot.setVisibility(8);
            this.mVAppListMusicRedDot.setVisibility(0);
            return;
        }
        this.local_music.setChecked(false);
        this.stream_music.setChecked(false);
        this.playlist_music.setChecked(true);
        this.music_app.setChecked(false);
        this.localRedDot.setVisibility(8);
        this.streamRedDot.setVisibility(8);
        this.playlistRedDot.setVisibility(0);
        this.mVAppListMusicRedDot.setVisibility(8);
    }

    public final void I4(String str, boolean z) {
        kn3 kn3Var = new kn3((Context) this, str, ah4.e(R.string.common_go_setting), ah4.e(R.string.common_ok), false, (kn3.d) new f());
        kn3Var.show();
        kn3Var.p();
    }

    public void J4(MusicPlaylist musicPlaylist) {
        if (musicPlaylist.getItemsList().size() >= 0) {
            this.c = true;
            Bundle bundle = new Bundle();
            String strE = ah4.e(R.string.music_tab_playlist);
            int i2 = this.b;
            if (i2 == R.id.music_album_list) {
                strE = ah4.e(R.string.music_album_list);
            } else if (i2 == R.id.music_artist_list) {
                strE = ah4.e(R.string.music_artist_list);
            }
            if (this.a == R.id.playlist_music) {
                strE = ah4.e(R.string.music_tab_playlist);
                bundle.putBoolean("isFromPlayList", true);
            }
            bundle.putString(MessageBundle.TITLE_ENTRY, strE);
            bundle.putSerializable("playListItem", musicPlaylist);
            pj3.g(this, PlaylistDetailsActivity.class, bundle);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (MusicControl.h0().O()) {
            MusicControl.h0().r = true;
            cj3.f().c(false);
        }
        o = false;
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 24 && intent != null) {
            MusicPlaylist musicPlaylist = (MusicPlaylist) intent.getSerializableExtra("new_playlist_item");
            if (musicPlaylist != null) {
                MusicControl.h0().d.g.add(1, musicPlaylist);
                MusicControl.h0().d(musicPlaylist, 1);
                MusicPlayListFragment musicPlayListFragment = this.h;
                if (musicPlayListFragment == null || !musicPlayListFragment.isAdded()) {
                    return;
                }
                this.h.X();
                return;
            }
            return;
        }
        if (i2 == 33) {
            if (k12.m == null || intent == null) {
                return;
            }
            this.g.c0();
            return;
        }
        MusicControl.h0();
        if (i2 == 119) {
            if (i3 == -1) {
                boolean booleanExtra = intent.getBooleanExtra("grant_all", false);
                intent.getIntArrayExtra("grant_results");
                if (booleanExtra) {
                    this.llPermission.setVisibility(8);
                    return;
                } else {
                    new kn3((Context) this, ah4.e(R.string.app_open_must_permission_new), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new d()).show();
                    return;
                }
            }
            return;
        }
        if (i2 == 13) {
            if (i3 != -1) {
                G4(0);
                return;
            }
            if (intent == null || Build.VERSION.SDK_INT < 26) {
                return;
            }
            Intent intent2 = new Intent(this, (Class<?>) MusicCaptureService.class);
            intent2.setAction("AudioCaptureService:Start");
            intent2.putExtra("AudioCaptureService:Extra:ResultData", intent);
            startForegroundService(intent2);
            G4(1);
            MusicControl.h0().u = true;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (MusicControl.h0().O()) {
            MusicControl.h0().Z(this, new k());
        } else {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bib_icon_music_panel_record /* 2131362142 */:
            case R.id.fl_sound_record /* 2131362781 */:
            case R.id.rl_icon_music_panel_record /* 2131364276 */:
                if (System.currentTimeMillis() - this.m >= 500) {
                    this.m = System.currentTimeMillis();
                    if (!se3.c(this) && MusicControl.h0().f.getMusicType() == 1) {
                        sg3.e(this, R.string.music_record_net_connect_error_tip);
                        break;
                    } else if (!na2.m().i()) {
                        this.rlIconMusicPanelRecord.setEnabled(false);
                        this.bibIconMusicPanelRecord.setEnabled(false);
                        if (MusicControl.h0().f.getMusicType() != 2) {
                            MusicControl.h0().B0();
                        }
                        new Handler().postDelayed(new m(), MusicControl.h0().f.getMusicType() == 0 ? 0L : 500L);
                        break;
                    } else {
                        na2.m().t();
                        break;
                    }
                }
                break;
            case R.id.iv_permission /* 2131363249 */:
                this.llPermission.setVisibility(8);
                break;
            case R.id.iv_search /* 2131363291 */:
                w4(view.getId());
                int i2 = this.a;
                if (i2 != R.id.local_music) {
                    if (i2 != R.id.stream_music) {
                        if (i2 != R.id.playlist_music) {
                            if (i2 == R.id.music_app) {
                                this.c = true;
                                pj3.f(this, SearchStreamMusicActivity.class);
                                break;
                            }
                        } else {
                            this.c = true;
                            pj3.f(this, SearchPlayListActivity.class);
                            break;
                        }
                    } else {
                        this.c = true;
                        pj3.f(this, SearchStreamMusicActivity.class);
                        break;
                    }
                } else {
                    this.c = true;
                    pj3.h(this, SearchLocalMusicActivity.class, "currentMusicTypeId", this.b);
                    break;
                }
                break;
            case R.id.ll_permission /* 2131363556 */:
                this.e = true;
                F4();
                break;
            case R.id.local_music /* 2131363652 */:
                if (this.a != view.getId()) {
                    x4(view.getId());
                    if (this.f.isAdded()) {
                        this.f.k0(this.b);
                    }
                    this.music_type_layout.setVisibility(0);
                    this.music_create_layout.setVisibility(8);
                    this.music_create_layout_bottom_line.setVisibility(0);
                    this.music_list_layout.invalidate();
                    break;
                }
                break;
            case R.id.music_album_list /* 2131363806 */:
            case R.id.music_artist_list /* 2131363814 */:
            case R.id.music_song_list /* 2131363865 */:
                this.b = view.getId();
                E4();
                break;
            case R.id.music_app /* 2131363807 */:
                if (this.a != view.getId()) {
                    x4(view.getId());
                    this.music_type_layout.setVisibility(8);
                    this.music_create_layout.setVisibility(0);
                    this.music_create_layout_bottom_line.setVisibility(0);
                    this.music_list_layout.invalidate();
                    break;
                }
                break;
            case R.id.music_create_layout /* 2131363819 */:
                pj3.o(this, CreateMusicPlaylistActivity.class, 24);
                break;
            case R.id.music_like /* 2131363828 */:
            case R.id.music_like_layout /* 2131363829 */:
                ImageView imageView = (ImageView) view;
                if (MusicControl.h0().f.isFavorite()) {
                    imageView.setImageResource(R.drawable.like_it);
                } else {
                    imageView.setImageResource(R.drawable.liked);
                }
                MusicControl.h0().f.setIsFavorite(!MusicControl.h0().f.isFavorite());
                DaoUtils.getMusicDao().update((MusicDao) MusicControl.h0().f);
                break;
            case R.id.playlist_music /* 2131364120 */:
                if (this.a != view.getId()) {
                    x4(view.getId());
                    if (this.h.isAdded()) {
                        this.h.X();
                    }
                    this.music_type_layout.setVisibility(8);
                    this.music_create_layout.setVisibility(0);
                    this.music_create_layout_bottom_line.setVisibility(0);
                    this.music_list_layout.invalidate();
                    break;
                }
                break;
            case R.id.stream_music /* 2131364642 */:
                if (this.a != view.getId()) {
                    String str = "stream_music " + MusicControl.h0().e.t();
                    x4(view.getId());
                    if (this.g.isAdded()) {
                        this.g.h0(this.b);
                    }
                    if (MusicControl.h0().e.t()) {
                        this.music_type_layout.setVisibility(0);
                        this.music_create_layout_bottom_line.setVisibility(0);
                    } else {
                        this.music_type_layout.setVisibility(8);
                        this.music_create_layout_bottom_line.setVisibility(8);
                    }
                    this.music_create_layout.setVisibility(8);
                    this.music_list_layout.invalidate();
                    break;
                }
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R.layout.remote_music_new);
        me3.c(me3.c.MUSIC_UI_ENTER);
        ye3.c("music", "into page", null);
        this.n = ButterKnife.bind(this);
        setCurrentScreen(this, "music_screen_view", NewMusicActivity.class.getSimpleName());
        setVolumeControlStream(3);
        A4(bundle);
        B4();
        this.actionbar.setToysAction(new g(), true, this);
        this.actionbar.n();
        this.actionbar.setBackAction(new h());
        this.actionbar.n();
        this.local_music.setOnClickListener(this);
        this.playlist_music.setOnClickListener(this);
        this.stream_music.setOnClickListener(this);
        this.music_app.setOnClickListener(this);
        this.ivSearch.setOnClickListener(this);
        this.music_create_layout.setOnClickListener(this);
        this.music_artist_list.setOnClickListener(this);
        this.music_song_list.setOnClickListener(this);
        this.music_album_list.setOnClickListener(this);
        this.iv_music_search.setOnClickListener(this);
        this.ivPermission.setOnClickListener(this);
        this.llPermission.setOnClickListener(this);
        this.mFlSoundRecord.setOnClickListener(this);
        this.bibIconMusicPanelRecord.setOnClickListener(this);
        this.rlIconMusicPanelRecord.setOnClickListener(this);
        this.rlIconMusicPanelRecord.setVisibility(0);
        EventBus.getDefault().register(this);
        this.k = false;
        this.llPermission.setVisibility(8);
        this.e = pe3.b("come_in_again");
        k12.m.d(this, findViewById(R.id.music_control_bar), findViewById(R.id.music_play_layer_placeholder), this.l);
        if (!y4()) {
            cs3.d(this, ah4.e(R.string.ninja_mode_permission), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), new i(), new j(this)).show();
        }
        pe3.h("come_in_again", Boolean.TRUE);
        o = MusicControl.h0().O();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        me3.c(me3.c.MUSIC_UI_EXIT);
        EventBus.getDefault().unregister(this);
        this.actionbar.s();
        this.n.unbind();
        addAnalyticsEventId("music_adjustSensitivity", new c());
        k12.m.F();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 24 && i2 != 25) {
            return super.onKeyDown(i2, keyEvent);
        }
        new Timer().schedule(new b(this), 100L);
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MusicPlaylistItems musicPlaylistItems) {
        MusicControl.h0().d.f();
        MusicControl.h0().r(null, null, true);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.c) {
            return;
        }
        MusicControl.h0().T();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        MusicPlayListFragment musicPlayListFragment;
        LinearLayout linearLayout;
        super.onResume();
        k12.m.j(this, findViewById(R.id.music_control_bar), findViewById(R.id.music_play_layer_placeholder), this.l);
        if (MusicControl.h0().O()) {
            k12.m.s(false);
        } else {
            k12.m.s(true);
        }
        if (MusicControl.h0().f == null) {
            findViewById(R.id.music_control_bar).setVisibility(8);
        } else if (MusicControl.h0().f.getMusicType() == 2) {
            findViewById(R.id.music_control_bar).setVisibility(0);
            MusicControl.h0().F0();
        } else {
            findViewById(R.id.music_control_bar).setVisibility(0);
            MusicControl.h0().H0();
        }
        if (this.c) {
            this.c = false;
            if (this.a == R.id.playlist_music && (musicPlayListFragment = this.h) != null && musicPlayListFragment.isAdded()) {
                this.h.X();
            }
        } else {
            MusicControl.h0().U();
        }
        if (this.a == R.id.stream_music && !MusicControl.h0().e.t()) {
            this.music_type_layout.setVisibility(8);
            this.music_create_layout_bottom_line.setVisibility(8);
        }
        if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() != 2) {
            k12.m.A();
        }
        MusicControl.h0().C0();
        if (MusicControl.h0().s != 0) {
            MusicControl.h0().E0();
            MusicControl.h0().d.a();
            MusicControl.h0().e.a();
        }
        if (z4()) {
            this.llPermission.setVisibility(8);
        }
        MusicLocalFragment musicLocalFragment = this.f;
        if (musicLocalFragment != null) {
            musicLocalFragment.i0();
        }
        MusicSpotifyFragment musicSpotifyFragment = this.g;
        if (musicSpotifyFragment != null) {
            musicSpotifyFragment.f0();
        }
        if (MusicControl.h0().O()) {
            MusicControl.h0().r = true;
        } else {
            MusicControl.h0().r = false;
        }
        MusicControl.h0().P();
        g12 g12Var = k12.m;
        if (g12Var == null || (linearLayout = g12Var.b) == null) {
            return;
        }
        if (linearLayout.getVisibility() == 0) {
            k12.m.F.setVisibility(0);
            k12.m.x.setBackgroundColor(getResources().getColor(R.color.bg_relativelayout_000));
        } else {
            k12.m.x.setBackgroundColor(getResources().getColor(R.color.transparent));
            k12.m.F.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("tabId", this.a);
        bundle.putInt("typeId", this.b);
        super.onSaveInstanceState(bundle);
        MusicLocalFragment musicLocalFragment = this.f;
        if (musicLocalFragment != null && musicLocalFragment.isAdded()) {
            this.j.putFragment(bundle, this.f.getClass().getSimpleName(), this.f);
        }
        MusicSpotifyFragment musicSpotifyFragment = this.g;
        if (musicSpotifyFragment != null && musicSpotifyFragment.isAdded()) {
            this.j.putFragment(bundle, this.g.getClass().getSimpleName(), this.g);
        }
        MusicPlayListFragment musicPlayListFragment = this.h;
        if (musicPlayListFragment == null || !musicPlayListFragment.isAdded()) {
            return;
        }
        this.j.putFragment(bundle, this.h.getClass().getSimpleName(), this.h);
    }

    public final void w4(int i2) {
        String str;
        String str2 = "";
        if (i2 == R.id.music_app) {
            str2 = "music_music_app_page_exposure";
            str = "music_music_app_page";
        } else if (i2 == R.id.local_music) {
            str2 = "music_my_library_page_exposure";
            str = "music_my_library_page";
        } else if (i2 == R.id.playlist_music) {
            str2 = "music_playlist_page_exposure";
            str = "music_playlist_page";
        } else if (i2 == R.id.iv_search) {
            str2 = "music_search_page_exposure";
            str = "music_search_page";
        } else {
            str = "";
        }
        ku1.i("Music", str2, "exposure", str, null);
    }

    public final void x4(int i2) {
        try {
            if (!isFinishing() && !isDestroyed()) {
                H4(i2);
                FragmentTransaction fragmentTransactionBeginTransaction = this.j.beginTransaction();
                this.a = i2;
                w4(i2);
                int i3 = this.a;
                if (i3 == R.id.local_music) {
                    this.ivSearch.setVisibility(0);
                    if (this.j.findFragmentByTag("local_music") != null || this.f.isAdded()) {
                        fragmentTransactionBeginTransaction.show(this.f);
                    } else {
                        fragmentTransactionBeginTransaction.add(R.id.fl_content, this.f, "local_music");
                    }
                    MusicSpotifyFragment musicSpotifyFragment = this.g;
                    if (musicSpotifyFragment != null && musicSpotifyFragment.isAdded()) {
                        fragmentTransactionBeginTransaction.hide(this.g);
                    }
                    MusicPlayListFragment musicPlayListFragment = this.h;
                    if (musicPlayListFragment != null && musicPlayListFragment.isAdded()) {
                        fragmentTransactionBeginTransaction.hide(this.h);
                    }
                    MusicAppListFragment musicAppListFragment = this.i;
                    if (musicAppListFragment != null && musicAppListFragment.isAdded()) {
                        fragmentTransactionBeginTransaction.hide(this.i);
                    }
                } else if (i3 == R.id.stream_music) {
                    this.ivSearch.setVisibility(0);
                    if (this.j.findFragmentByTag("spotify_music") != null || this.g.isAdded()) {
                        fragmentTransactionBeginTransaction.show(this.g);
                    } else {
                        fragmentTransactionBeginTransaction.add(R.id.fl_content, this.g, "spotify_music");
                    }
                    MusicLocalFragment musicLocalFragment = this.f;
                    if (musicLocalFragment != null && musicLocalFragment.isAdded()) {
                        fragmentTransactionBeginTransaction.hide(this.f);
                    }
                    MusicPlayListFragment musicPlayListFragment2 = this.h;
                    if (musicPlayListFragment2 != null && musicPlayListFragment2.isAdded()) {
                        fragmentTransactionBeginTransaction.hide(this.h);
                    }
                    MusicAppListFragment musicAppListFragment2 = this.i;
                    if (musicAppListFragment2 != null && musicAppListFragment2.isAdded()) {
                        fragmentTransactionBeginTransaction.hide(this.i);
                    }
                } else if (i3 == R.id.music_app) {
                    this.ivSearch.setVisibility(0);
                    if (this.j.findFragmentByTag("app_music") != null || this.i.isAdded()) {
                        fragmentTransactionBeginTransaction.show(this.i);
                        this.i.k0();
                    } else {
                        fragmentTransactionBeginTransaction.add(R.id.fl_content, this.i, "app_music");
                        this.i.k0();
                    }
                    MusicLocalFragment musicLocalFragment2 = this.f;
                    if (musicLocalFragment2 != null && musicLocalFragment2.isAdded()) {
                        fragmentTransactionBeginTransaction.hide(this.f);
                    }
                    MusicPlayListFragment musicPlayListFragment3 = this.h;
                    if (musicPlayListFragment3 != null && musicPlayListFragment3.isAdded()) {
                        fragmentTransactionBeginTransaction.hide(this.h);
                    }
                    MusicSpotifyFragment musicSpotifyFragment2 = this.g;
                    if (musicSpotifyFragment2 != null && musicSpotifyFragment2.isAdded()) {
                        fragmentTransactionBeginTransaction.hide(this.g);
                    }
                } else {
                    this.ivSearch.setVisibility(0);
                    if (this.j.findFragmentByTag("play_list") != null || this.h.isAdded()) {
                        fragmentTransactionBeginTransaction.show(this.h);
                    } else {
                        fragmentTransactionBeginTransaction.add(R.id.fl_content, this.h, "play_list");
                    }
                    MusicLocalFragment musicLocalFragment3 = this.f;
                    if (musicLocalFragment3 != null && musicLocalFragment3.isAdded()) {
                        fragmentTransactionBeginTransaction.hide(this.f);
                    }
                    MusicSpotifyFragment musicSpotifyFragment3 = this.g;
                    if (musicSpotifyFragment3 != null && musicSpotifyFragment3.isAdded()) {
                        fragmentTransactionBeginTransaction.hide(this.g);
                    }
                    MusicAppListFragment musicAppListFragment3 = this.i;
                    if (musicAppListFragment3 != null && musicAppListFragment3.isAdded()) {
                        fragmentTransactionBeginTransaction.hide(this.i);
                    }
                }
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public final boolean y4() {
        return MyApplication.Z || DaoUtils.getTestValueDao().getExistKey(nd3.u(zt3.k), TestValueDao.NINJA_MODE_SWITCH_TYPE) != null || Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this);
    }

    public final boolean z4() {
        if (Build.VERSION.SDK_INT > 22) {
            if (!RequestPermissionActivity.r4(this.application, new String[]{"android.permission.RECORD_AUDIO"})) {
                return false;
            }
        }
        return true;
    }
}
