package com.wear.main.closeRange.music;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.spotify.sdk.android.player.SpotifyPlayer;
import com.wear.BaseActivity;
import com.wear.bean.HomeMusicBean;
import com.wear.bean.Music;
import com.wear.bean.MusicBean;
import com.wear.bean.MusicCover;
import com.wear.bean.MusicPlaylist;
import com.wear.bean.Setting;
import com.wear.bean.Toy;
import com.wear.bean.event.MusicNotificationEvent;
import com.wear.bean.event.MusicPlayEvent;
import com.wear.bean.event.NinjaMusicChangeEvent;
import com.wear.bean.event.NotificationCloseEvent;
import com.wear.dao.DaoUtils;
import com.wear.dao.SettingDao;
import com.wear.main.closeRange.MusicRecordActivity;
import com.wear.main.closeRange.localMusic.MusicHodler;
import com.wear.main.ninja.service.PlayService;
import com.wear.util.MyApplication;
import com.wear.util.VolumeChangeHelper;
import com.wear.util.WearUtils;
import com.wear.widget.dialog.MusicExpandDialog;
import dc.be3;
import dc.cj3;
import dc.eg3;
import dc.f12;
import dc.g12;
import dc.h12;
import dc.i12;
import dc.k12;
import dc.m12;
import dc.me3;
import dc.mk2;
import dc.na2;
import dc.pc1;
import dc.pd3;
import dc.rd3;
import dc.sg3;
import dc.so3;
import dc.sz1;
import dc.tz1;
import dc.ye3;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class MusicControl extends h12 implements tz1, pd3.b {
    public MusicPlaylist E;
    public PlayControlReceiver K;
    public Setting L;
    public int M;
    public long O;
    public List<h> P;
    public int F = 100;
    public Handler G = new Handler(Looper.getMainLooper());
    public boolean N = true;

    public class PlayControlReceiver extends BroadcastReceiver {
        public PlayControlReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (MyApplication.H() instanceof MusicRecordActivity) {
                    sg3.h(R.string.ninja_mode_record_music_conflict);
                    return;
                }
                if (PlayService.R && !MusicControl.this.L()) {
                    if ("com.wear.music.notify.prev".equals(action)) {
                        if (MusicControl.h0().f != null && MusicControl.this.f.getMusicType() == 2) {
                            return;
                        } else {
                            MusicControl.this.Y();
                        }
                    } else if ("com.wear.music.notify.play_state".equals(action)) {
                        if (!MusicControl.this.f0(-1)) {
                            return;
                        } else {
                            MusicControl.this.X();
                        }
                    } else if ("com.wear.music.notify.next".equals(action)) {
                        if (MusicControl.h0().f != null && MusicControl.this.f.getMusicType() == 2) {
                            return;
                        } else {
                            MusicControl.this.W();
                        }
                    } else if ("com.wear.music.notify.loop".equals(action)) {
                        if (MusicControl.h0().f != null && MusicControl.this.f.getMusicType() == 2) {
                            return;
                        } else {
                            MusicControl.this.y0(false);
                        }
                    } else if ("com.wear.music.notify.close".equals(action)) {
                        EventBus.getDefault().post(new NotificationCloseEvent());
                        MusicControl musicControl = MusicControl.this;
                        musicControl.r = false;
                        musicControl.p0();
                        MusicControl.this.P();
                    }
                    EventBus.getDefault().post(new MusicNotificationEvent());
                }
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
    }

    public class a implements VolumeChangeHelper.a {
        public a() {
        }

        @Override // com.wear.util.VolumeChangeHelper.a
        public void a() {
            f12 f12Var = MusicControl.this.d;
            if (f12Var == null || !f12Var.h()) {
                return;
            }
            MusicControl.this.g0(false);
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Object obj = message.obj;
                if (obj instanceof MusicBean) {
                    MusicControl.this.d.h.clear();
                    MusicControl.this.d.h.addAll(((MusicBean) obj).musics);
                }
                MusicControl.this.d.f();
                MusicControl musicControl = MusicControl.this;
                f fVar = musicControl.j;
                if (fVar != null) {
                    fVar.f(0, musicControl.d.h.size(), false);
                }
                Music music = MusicControl.this.f;
                if (music == null) {
                    EventBus.getDefault().post(new HomeMusicBean(8));
                    return;
                } else {
                    if (music.getMusicType() != 2) {
                        EventBus.getDefault().post(new HomeMusicBean(8));
                        return;
                    }
                    return;
                }
            }
            if (i == 2) {
                MusicControl.this.e.K();
                MusicControl musicControl2 = MusicControl.this;
                f fVar2 = musicControl2.j;
                if (fVar2 != null) {
                    fVar2.f(1, musicControl2.e.i.size(), false);
                    return;
                }
                return;
            }
            if (i != 4) {
                if (i != 5) {
                    return;
                }
                MusicControl.this.e0();
                return;
            }
            boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
            MusicControl.this.e.K();
            MusicControl musicControl3 = MusicControl.this;
            f fVar3 = musicControl3.j;
            if (fVar3 != null) {
                fVar3.f(2, musicControl3.e.i.size(), zBooleanValue);
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Boolean a;

        public c(Boolean bool) {
            this.a = bool;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = "run: " + MusicControl.this.f.toString();
            if (MusicControl.this.O()) {
                MusicControl musicControl = MusicControl.this;
                if (musicControl.x != null) {
                    Music music = musicControl.f;
                    if (music == null || music.getMusicType() != 2) {
                        MusicControl.this.x.a().setImageResource(R.drawable.ic_expand_play);
                    } else {
                        MusicControl.this.x.a().setImageResource(R.drawable.pattern_play_play);
                    }
                }
                cj3.f().c(true);
            } else {
                cj3.f().c(false);
                if (MusicControl.this.x != null) {
                    if (MusicControl.h0().f == null || MusicControl.this.f.getMusicType() != 2) {
                        MusicControl.this.x.a().setImageResource(R.drawable.ic_expand_pause);
                    } else {
                        MusicControl.this.x.a().setImageResource(R.drawable.pattern_play_pause);
                    }
                }
            }
            MusicControl musicControl2 = MusicControl.this;
            Boolean bool = this.a;
            musicControl2.t0(bool != null && bool.booleanValue());
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public d(MusicControl musicControl, int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a <= this.b) {
                k12.m.L.setVisibility(0);
            } else {
                k12.m.L.setVisibility(8);
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            MusicControl.this.v0();
        }
    }

    public interface f {
        void a(int i);

        void b(boolean z);

        void c(int i);

        void d(int i);

        void e(boolean z);

        void f(int i, int i2, boolean z);
    }

    public static class g {
        public static MusicControl a = new MusicControl();
    }

    public interface h {
        void e1(i12 i12Var);
    }

    public static MusicControl h0() {
        return g.a;
    }

    public void A0(boolean z) {
        BaseActivity baseActivity;
        k12.m.s(z);
        if (h0().u && ((baseActivity = this.a) == null || !(baseActivity instanceof MusicRecordActivity) || z)) {
            if (PlayService.R && h0().f != null) {
                EventBus.getDefault().post(new NinjaMusicChangeEvent(z));
            } else if (!z) {
                h0().z0();
            }
        }
        EventBus.getDefault().post(new HomeMusicBean(2, !z));
    }

    public void B0() {
        SpotifyPlayer spotifyPlayer;
        Music music = this.f;
        if (music == null) {
            this.s = 0L;
            return;
        }
        if (music.getMusicType() == 1) {
            m12 m12Var = this.e;
            if (m12Var != null && (spotifyPlayer = m12Var.h) != null) {
                this.s = (int) spotifyPlayer.getPlaybackState().positionMs;
            }
        } else {
            this.s = this.d.b.n();
        }
        if (this.s == 0) {
            this.s = 1L;
        }
        g12 g12Var = k12.m;
        if (g12Var == null) {
            this.s = 0L;
        } else {
            g12Var.t();
            this.M = 2;
        }
    }

    public void C0() {
        SpotifyPlayer spotifyPlayer;
        Music music = this.f;
        if (music == null) {
            this.s = 0L;
            return;
        }
        if (music.getMusicType() == 1) {
            m12 m12Var = this.e;
            if (m12Var != null && (spotifyPlayer = m12Var.h) != null) {
                this.s = (int) spotifyPlayer.getPlaybackState().positionMs;
            }
        } else {
            this.s = this.d.b.n();
        }
        if (this.s == 0) {
            this.s = 1L;
        }
        g12 g12Var = k12.m;
        if (g12Var == null) {
            this.s = 0L;
        } else {
            g12Var.u();
            this.M = 2;
        }
    }

    public void D0(SeekBar seekBar) throws IllegalStateException {
        m12 m12Var;
        so3 so3Var;
        Music music = this.f;
        if (music != null && music.getMusicType() == 0) {
            f12 f12Var = this.d;
            if (f12Var == null || (so3Var = f12Var.b) == null || seekBar == null) {
                return;
            }
            so3Var.y(seekBar.getProgress());
            return;
        }
        Music music2 = this.f;
        if (music2 == null || music2.getMusicType() != 1 || (m12Var = this.e) == null || seekBar == null) {
            return;
        }
        m12Var.X(seekBar.getProgress());
    }

    public void E0() throws IllegalStateException {
        m12 m12Var;
        so3 so3Var;
        k12.m.w();
        Music music = this.f;
        if (music == null || music.getMusicType() != 0) {
            Music music2 = this.f;
            if (music2 != null && music2.getMusicType() == 1 && (m12Var = this.e) != null) {
                m12Var.X((int) this.s);
            }
        } else {
            f12 f12Var = this.d;
            if (f12Var != null && (so3Var = f12Var.b) != null) {
                so3Var.y((int) this.s);
            }
        }
        this.s = 0L;
        this.d.a();
        if (!MyApplication.P) {
            this.M = eg3.e(WearUtils.x, "model_music_play");
            return;
        }
        Setting settingS = WearUtils.x.S();
        this.L = settingS;
        if (settingS == null) {
            this.M = 0;
        } else {
            this.M = settingS.getPlayMusicModel();
        }
    }

    public void F0() {
        k12.m.r(false);
        k12.m.q(R.color.toolbar_music_play_layer_bg);
        k12.m.C();
    }

    public void G0() {
        k12.m.z();
        z0();
    }

    public void H0() {
        k12.m.r(true);
        k12.m.q(R.color.toolbar_music_play_layer_bg);
        k12.m.D();
    }

    public void I0() {
        if (this.f != null) {
            k12.m.b.setVisibility(8);
            k12.m.c.setVisibility(0);
            k12.m.a.setVisibility(0);
            G0();
        }
    }

    public void J0() throws IllegalStateException {
        if (O()) {
            f fVar = this.j;
            if (fVar != null) {
                fVar.e(true);
            }
            K();
            k12.m.E();
            if (this.d.h()) {
                this.d.b.u();
            }
            if (this.e.P()) {
                this.e.b.u();
            }
            b0();
        }
        f fVar2 = this.j;
        if (fVar2 != null) {
            fVar2.c(this.g);
        }
        h0().Q(i12.a.d(h0().g));
    }

    public void K0(@NonNull h hVar) {
        List<h> list = this.P;
        if (list == null || !list.contains(hVar)) {
            return;
        }
        this.P.remove(hVar);
    }

    public void L0(MusicPlaylist musicPlaylist) {
        for (MusicPlaylist musicPlaylist2 : this.d.g) {
            if (musicPlaylist2.getId().equals(musicPlaylist.getId()) && !WearUtils.e1(musicPlaylist.getCover()) && !musicPlaylist.getCover().equals(WearUtils.H0(musicPlaylist2.getCover()))) {
                musicPlaylist2.setCover(musicPlaylist.getCover());
                EventBus.getDefault().post(new MusicCover(musicPlaylist.getId()));
            }
        }
    }

    public void M0(int i) {
        this.f = this.i.get(i);
        this.g = i;
    }

    public void N0(Music music) {
        this.f = music;
    }

    @Override // dc.h12
    public void Q(i12 i12Var) {
        List<h> list = this.P;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<h> it = this.P.iterator();
        while (it.hasNext()) {
            it.next().e1(i12Var);
        }
    }

    @Override // dc.h12
    public void S() {
        if (mk2.P().h0() && this.u) {
            mk2.P().n0(false);
        }
        Music music = this.f;
        if (music != null) {
            d0(music.getFuncType());
        }
        rd3.f().B(false);
        super.S();
    }

    @Override // dc.h12
    public void T() {
        super.T();
    }

    @Override // dc.h12
    public void U() {
        super.U();
    }

    @Override // dc.h12
    public void W() throws IllegalStateException {
        if (na2.m().i()) {
            na2.m().t();
            return;
        }
        Music music = this.f;
        if (music == null || music.getMusicType() == 2) {
            return;
        }
        int iJ0 = j0(true, false);
        d0(this.f.getFuncType());
        s0(iJ0);
    }

    @Override // dc.h12
    public void X() throws IllegalStateException {
        u0(null);
    }

    @Override // dc.h12
    public void Y() throws IllegalStateException {
        if (na2.m().i()) {
            na2.m().t();
            return;
        }
        Music music = this.f;
        if (music == null || music.getMusicType() == 2) {
            return;
        }
        int iJ0 = j0(false, false);
        d0(this.f.getFuncType());
        s0(iJ0);
    }

    public final void d0(int i) {
        long jR = be3.r();
        long j = this.O;
        int i2 = (int) ((jR - j) / 1000);
        if (j > 0 && i2 >= 5) {
            HashMap map = new HashMap();
            map.put(TypedValues.TransitionType.S_DURATION, Integer.valueOf(i2));
            ArrayList arrayList = new ArrayList();
            Iterator<Toy> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getDeviceId());
            }
            map.put("toy_mac", arrayList);
            map.put("type", Integer.valueOf(i));
            ye3.d("M0046", WearUtils.A.toJson(map));
        }
        this.O = 0L;
    }

    public void e0() {
        this.y = 0;
        if (this.d.h()) {
            int iN = this.d.b.n();
            this.y = iN;
            Q(i12.a.h(iN));
            MusicHodler musicHodler = this.x;
            if (musicHodler != null) {
                musicHodler.b().setText(WearUtils.Q(this.y / 1000));
                return;
            }
            return;
        }
        if (!this.e.P()) {
            Q(i12.a.e());
            return;
        }
        int i = (int) this.e.h.getPlaybackState().positionMs;
        this.y = i;
        Q(i12.a.h(i));
        MusicHodler musicHodler2 = this.x;
        if (musicHodler2 != null) {
            musicHodler2.b().setText(WearUtils.Q(this.y / 1000));
        }
    }

    public final boolean f0(int i) {
        return true;
    }

    @Override // dc.k12
    public void g() {
        this.b = new b(Looper.getMainLooper());
    }

    public void g0(boolean z) {
        if ((h0().d == null || !h0().d.h()) && !z) {
            return;
        }
        AudioManager audioManager = (AudioManager) MyApplication.N().getSystemService("audio");
        audioManager.getStreamMaxVolume(3);
        int streamMinVolume = Build.VERSION.SDK_INT >= 28 ? audioManager.getStreamMinVolume(3) : 0;
        int streamVolume = audioManager.getStreamVolume(3);
        if (k12.m.L != null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                this.G.post(new d(this, streamVolume, streamMinVolume));
            } else if (streamVolume <= streamMinVolume) {
                k12.m.L.setVisibility(0);
            } else {
                k12.m.L.setVisibility(8);
            }
        }
    }

    @Override // dc.tz1
    public int getPriority() {
        return 4;
    }

    public int i0() {
        return this.M;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int j0(boolean r5, boolean r6) {
        /*
            r4 = this;
            int r0 = r4.g
            int r1 = r4.M
            r2 = 1
            if (r1 == r2) goto L17
            r3 = 2
            if (r1 == r3) goto L12
            if (r5 == 0) goto Lf
        Lc:
            int r0 = r0 + 1
            goto L32
        Lf:
            int r0 = r0 + (-1)
            goto L32
        L12:
            if (r6 == 0) goto L32
            if (r5 == 0) goto Lf
            goto Lc
        L17:
            java.util.List<com.wear.bean.Music> r5 = r4.i
            int r5 = r5.size()
            if (r5 <= r2) goto L32
        L1f:
            java.util.Random r5 = new java.util.Random
            r5.<init>()
            java.util.List<com.wear.bean.Music> r6 = r4.i
            int r6 = r6.size()
            int r0 = r5.nextInt(r6)
            int r5 = r4.g
            if (r0 == r5) goto L1f
        L32:
            if (r0 >= 0) goto L46
            java.util.List<com.wear.bean.Music> r5 = r4.i
            if (r5 == 0) goto L46
            int r5 = r5.size()
            if (r5 <= 0) goto L46
            java.util.List<com.wear.bean.Music> r5 = r4.i
            int r5 = r5.size()
            int r0 = r5 + (-1)
        L46:
            java.util.List<com.wear.bean.Music> r5 = r4.i
            if (r5 == 0) goto L59
            int r5 = r5.size()
            if (r5 <= 0) goto L59
            java.util.List<com.wear.bean.Music> r5 = r4.i
            int r5 = r5.size()
            if (r0 < r5) goto L59
            r0 = 0
        L59:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.closeRange.music.MusicControl.j0(boolean, boolean):int");
    }

    public int k0() {
        return this.F;
    }

    public void l0() {
        k12.m = new g12(WearUtils.x);
        this.d = new f12(WearUtils.x);
        this.e = new m12(WearUtils.x);
        o0();
        EventBus.getDefault().register(this);
        sz1.d().n(this);
        cj3.f().k(0, this);
        pd3.j().o(this);
        f fVar = this.j;
        if (fVar != null) {
            fVar.b(true);
        }
        if (eg3.b(WearUtils.x, "sensitivity_seek", 0) != null) {
            this.F = Integer.parseInt(String.valueOf(eg3.b(WearUtils.x, "sensitivity_seek", 100)));
        }
        f fVar2 = this.j;
        if (fVar2 != null) {
            fVar2.e(!O());
        }
        new VolumeChangeHelper(MyApplication.N()).c(new a());
        y0(true);
    }

    public void m0() {
        k12.m.f();
        EventBus.getDefault().post(new NinjaMusicChangeEvent(true, 3));
        f fVar = this.j;
        if (fVar != null) {
            fVar.b(false);
        }
        G(true);
        Q(i12.a.j());
    }

    @Override // dc.pd3.b
    public void n() {
    }

    public void n0() {
        k12.m.g();
        f fVar = this.j;
        if (fVar != null) {
            fVar.b(true);
        }
        G(false);
        Q(i12.a.a());
    }

    public final void o0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.wear.music.notify.prev");
        intentFilter.addAction("com.wear.music.notify.play_state");
        intentFilter.addAction("com.wear.music.notify.next");
        intentFilter.addAction("com.wear.music.notify.loop");
        intentFilter.addAction("com.wear.music.notify.close");
        PlayControlReceiver playControlReceiver = new PlayControlReceiver();
        this.K = playControlReceiver;
        if (Build.VERSION.SDK_INT >= 33) {
            WearUtils.x.registerReceiver(playControlReceiver, intentFilter, 4);
        } else {
            WearUtils.x.registerReceiver(playControlReceiver, intentFilter);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MusicPlayEvent musicPlayEvent) {
        if (O()) {
            if (musicPlayEvent.isPause() || musicPlayEvent.isPatternPause()) {
                t0(false);
                cj3.f().c(true);
            }
        }
    }

    @Override // dc.pd3.b
    public void p() {
        if (!this.r || cj3.f().j(0)) {
            return;
        }
        cj3.f().l(0);
    }

    public void p0() {
        if (O()) {
            t0(false);
        }
    }

    @Override // dc.tz1
    public void pauseConnon(int i) throws IllegalStateException {
        MusicExpandDialog musicExpandDialog;
        if (i > 4 && (musicExpandDialog = this.z) != null && musicExpandDialog.isShowing()) {
            this.z.dismiss();
        }
        if (O()) {
            this.r = false;
            X();
        }
    }

    @Override // dc.pd3.b
    public void q() {
        if (!this.r || cj3.f().j(0)) {
            return;
        }
        cj3.f().d(0);
    }

    public void q0() throws IllegalStateException {
        if (f0(-1)) {
            X();
        }
    }

    public void r0() {
        h0().b0();
        if (k12.m.b() != null) {
            k12.m.b().runOnUiThread(new e());
        }
    }

    @Override // dc.tz1
    public void recovery() {
    }

    public void s0(int i) throws IllegalStateException {
        List<Music> list;
        boolean zO = O();
        g0(true);
        if (L()) {
            return;
        }
        if (na2.m().i()) {
            na2.m().t();
            return;
        }
        String str = i + "" + h0().O();
        if (!f0(i) || (list = this.i) == null) {
            return;
        }
        if (list == null || list.size() != 0) {
            if (!cj3.f().e()) {
                cj3.f().c(false);
            }
            if (i < 0) {
                if (this.i.size() <= 0) {
                    MyApplication myApplication = WearUtils.x;
                    sg3.i(MyApplication.K, R.string.music_first);
                    return;
                }
                i = this.i.size() - 1;
            } else if (i >= this.i.size()) {
                if (this.i.size() <= 0) {
                    MyApplication myApplication2 = WearUtils.x;
                    sg3.i(MyApplication.K, R.string.music_last);
                    return;
                }
                i = 0;
            }
            if (!this.u) {
                me3.e(me3.a.MUSIC_PLAY);
            }
            this.u = true;
            Q(i12.a.i());
            this.d.k();
            this.e.Y();
            k12.m.h();
            this.f = null;
            Music music = this.i.get(i);
            this.f = music;
            if (music == null || music.getMusicType() == 2) {
                rd3.f().B(true);
                F0();
            } else {
                H0();
                rd3.f().B(false);
            }
            this.E = null;
            this.g = i;
            f fVar = this.j;
            if (fVar != null) {
                fVar.a(i);
            }
            k12.m.B();
            if (this.f.getMusicType() == 1) {
                this.N = false;
                G0();
                this.e.B(this.f.getData());
            } else {
                n0();
                A0(true);
                f fVar2 = this.j;
                if (fVar2 != null) {
                    fVar2.e(true);
                }
                so3 so3Var = this.d.b;
                if (so3Var != null) {
                    so3Var.G();
                    this.t = true;
                    this.d.i(!zO);
                }
            }
            f fVar3 = this.j;
            if (fVar3 != null) {
                fVar3.c(i);
            }
            MusicHodler musicHodler = this.x;
            if (musicHodler != null) {
                musicHodler.b().setText("00:00");
                this.x.c().setText(this.f.getTitle());
                this.x.a().setImageResource(R.drawable.ic_expand_pause);
            }
            if (this.O == 0) {
                this.O = be3.r();
            }
            Q(i12.a.d(i));
            Q(i12.a.c());
            if (mk2.P().h0()) {
                mk2.P().n0(true);
            }
        }
    }

    @Override // dc.tz1
    public void stop(int i) {
    }

    public void t0(boolean z) {
        k12.m.l();
        f fVar = this.j;
        if (fVar != null) {
            fVar.b(true);
        }
        Music music = this.f;
        if (music != null) {
            if (music.getMusicType() == 0) {
                this.d.i(z);
            } else if (this.f.getMusicType() == 1) {
                this.e.S(false);
            } else if (this.f.getMusicType() == 2) {
                rd3.f().z(!rd3.f().o());
                rd3.f().B(!rd3.f().n());
                h0().A0(!rd3.f().o());
            }
        }
        if (O()) {
            Q(i12.a.f());
            if (mk2.P().h0()) {
                mk2.P().n0(true);
            }
            this.O = be3.r();
        } else {
            Q(i12.a.e());
            d0(this.f.getFuncType());
        }
        G(false);
    }

    public void u0(Boolean bool) throws IllegalStateException {
        int i;
        if (f0(-1)) {
            if (na2.m().i()) {
                na2.m().t();
                return;
            }
            if (this.f == null) {
                return;
            }
            if (!this.u) {
                me3.e(me3.a.MUSIC_PLAY);
            }
            this.u = true;
            if (this.f.getMusicType() == 0) {
                rd3.f().B(false);
            } else if (this.f.getMusicType() == 2) {
                this.d.b.t();
            }
            if (this.N && this.f.getMusicType() == 1 && (i = this.g) >= 0) {
                this.N = false;
                s0(i);
                return;
            }
            c cVar = new c(bool);
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                cVar.run();
            } else {
                this.b.post(cVar);
            }
        }
    }

    public void v0() throws IllegalStateException {
        h0().t = true;
        k12.m.m();
        if (h0().j != null) {
            h0().j.e(true);
        }
        h0().W();
    }

    public void w0(@NonNull h hVar) {
        if (this.P == null) {
            this.P = new ArrayList();
        }
        if (this.P.contains(hVar)) {
            return;
        }
        this.P.add(hVar);
    }

    public void x0(BaseActivity baseActivity, f fVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.a = baseActivity;
        this.j = fVar;
        if (fVar != null) {
            fVar.b(true);
        }
        if (fVar != null) {
            fVar.e(!O());
            if (this.k) {
                fVar.b(false);
            }
        }
        y0(true);
    }

    public void y0(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Setting setting;
        if (!z) {
            int i = (this.M + 1) % 3;
            this.M = i;
            if (!MyApplication.P || (setting = this.L) == null) {
                eg3.k(WearUtils.x, "model_music_play", i);
            } else {
                setting.setPlayMusicModel(i);
                DaoUtils.getSettingDao().update((SettingDao) this.L);
            }
            this.u = true;
        } else if (MyApplication.P) {
            Setting settingS = WearUtils.x.S();
            this.L = settingS;
            if (settingS == null) {
                this.M = 0;
            } else {
                this.M = settingS.getPlayMusicModel();
            }
        } else {
            this.M = eg3.e(WearUtils.x, "model_music_play");
        }
        if (this.u) {
            EventBus.getDefault().post(new NinjaMusicChangeEvent(this.M));
        }
        Q(i12.a.b(this.M));
    }

    public synchronized void z0() {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
        if (this.f == null) {
            return;
        }
        if (this.u) {
            String imageUrl = "content://media/external/audio/albumart/" + this.f.getAlbumId();
            boolean z = true;
            if (this.f.getMusicType() == 1) {
                imageUrl = this.f.getImageUrl();
            }
            String str = imageUrl;
            String str2 = "setNotificationMusic: " + this.f.getTitle();
            if (!(k12.m.b() instanceof MusicRecordActivity)) {
                if (PlayService.R) {
                    EventBus.getDefault().post(new NinjaMusicChangeEvent(this.f.getTitle(), this.f.getArtist(), this.M, str, !O(), this.f.getDuration(), this.f.getMusicType()));
                } else {
                    Intent intent = new Intent(k12.m.b(), (Class<?>) PlayService.class);
                    intent.setAction("music_start");
                    intent.putExtra("play_name", this.f.getTitle());
                    intent.putExtra("play_author", this.f.getArtist());
                    intent.putExtra("music_cover", str);
                    intent.putExtra("music_duration", this.f.getDuration());
                    intent.putExtra("play_mode", this.M);
                    intent.putExtra("play_music_type", this.f.getMusicType());
                    if (O()) {
                        z = false;
                    }
                    intent.putExtra("pattern_pause", z);
                    if (Build.VERSION.SDK_INT >= 26) {
                        k12.m.b().startForegroundService(intent);
                    } else {
                        k12.m.b().startService(intent);
                    }
                }
            }
        }
    }
}
