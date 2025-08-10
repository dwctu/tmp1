package dc;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.SyncAccessActivity;
import com.wear.bean.KeepScreenSetting;
import com.wear.bean.Music;
import com.wear.bean.event.MusicNotificationEvent;
import com.wear.bean.event.MusicPlayEvent;
import com.wear.bean.event.NotificationCloseEvent;
import com.wear.bean.event.NotificationMusicCloseEvent;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.closeRange.MusicRecordActivity;
import com.wear.main.closeRange.MusicRecordPreviewActivity;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.closeRange.PlayListDetailsDActivity;
import com.wear.main.closeRange.RemoteControlActivity;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.closeRange.alarm.AlarmSoundPlayActivity;
import com.wear.main.closeRange.localMusic.MusicHodler;
import com.wear.main.closeRange.localMusic.SearchLocalMusicActivity;
import com.wear.main.closeRange.localMusic.SoreMusicPlaylistsActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.closeRange.spotifyMusic.SearchStreamMusicActivity;
import com.wear.main.closeRange.spotifyMusic.StreamMusicLoginActivity;
import com.wear.main.game.ui.GameActivity;
import com.wear.main.longDistance.player.ui.PlayerActivity;
import com.wear.main.ninja.NinjaLockActivity;
import com.wear.main.ninja.service.PlayService;
import com.wear.main.patterns.CreatePatternActivity;
import com.wear.ui.discover.speedMode.SpeedModeActivity;
import com.wear.ui.home.HomeFragment;
import com.wear.ui.home.music.NewMusicActivity;
import com.wear.ui.home.sound.SoundPlayActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.dialog.MusicExpandDialog;
import dc.cj3;
import dc.g12;
import dc.i12;
import dc.is3;
import dc.me3;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;

/* compiled from: MusicDesControl.java */
/* loaded from: classes3.dex */
public abstract class h12 extends k12 implements cj3.c {
    public static MusicPlayEvent D = new MusicPlayEvent();
    public Dialog A;
    public Timer B;
    public TimerTask C;
    public boolean r;
    public boolean u;
    public boolean v;
    public boolean w;
    public MusicHodler x;
    public MusicExpandDialog z;
    public long s = 0;
    public boolean t = true;
    public int y = 0;

    /* compiled from: MusicDesControl.java */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            h12 h12Var = h12.this;
            if (h12Var.v) {
                return;
            }
            if (h12Var.b == null) {
                FirebaseCrashlytics.getInstance().recordException(new Throwable("音乐播放进度回调 handler为空"));
                h12.this.g();
            }
            h12.this.b.sendEmptyMessage(5);
        }
    }

    /* compiled from: MusicDesControl.java */
    public class b implements is3.d {
        public b(h12 h12Var) {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            pj3.f(MyApplication.H(), NewMusicActivity.class);
        }
    }

    /* compiled from: MusicDesControl.java */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            h12 h12Var = h12.this;
            h12Var.x = null;
            h12Var.z = null;
        }
    }

    /* compiled from: MusicDesControl.java */
    public class d implements is3.c {
        public d(h12 h12Var) {
        }

        @Override // dc.is3.c
        public void doCancel() {
            cj3.f().l(0);
        }
    }

    /* compiled from: MusicDesControl.java */
    public class e implements MusicExpandDialog.d {
        public e() {
        }

        @Override // com.wear.widget.dialog.MusicExpandDialog.d
        public void a() {
            if (h12.this.L()) {
                return;
            }
            h12.this.X();
            EventBus.getDefault().post(new MusicNotificationEvent());
        }

        @Override // com.wear.widget.dialog.MusicExpandDialog.d
        public void b() {
            if (h12.this.L()) {
                return;
            }
            h12.this.Y();
            EventBus.getDefault().post(new MusicNotificationEvent());
        }

        @Override // com.wear.widget.dialog.MusicExpandDialog.d
        public void c() {
            if (h12.this.L()) {
                return;
            }
            h12.this.W();
            EventBus.getDefault().post(new MusicNotificationEvent());
        }

        @Override // com.wear.widget.dialog.MusicExpandDialog.d
        public void end() throws IllegalStateException {
            h12.this.S();
            if (MusicControl.h0().f.getMusicType() == 2) {
                rd3.f().B(false);
            }
            EventBus.getDefault().post(new NotificationCloseEvent());
            EventBus.getDefault().post(new MusicNotificationEvent());
        }
    }

    /* compiled from: MusicDesControl.java */
    public class f implements is3.c {
        public final /* synthetic */ g12.f a;

        public f(g12.f fVar) {
            this.a = fVar;
        }

        @Override // dc.is3.c
        public void doCancel() {
            h12.this.A = null;
            g12.f fVar = this.a;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    /* compiled from: MusicDesControl.java */
    public class g implements is3.d {
        public final /* synthetic */ g12.f a;
        public final /* synthetic */ Activity b;

        public g(g12.f fVar, Activity activity) {
            this.a = fVar;
            this.b = activity;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            try {
                h12.this.A = null;
                g12.f fVar = this.a;
                if (fVar != null) {
                    fVar.a();
                }
                od3.d(this.b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void J(Activity activity) {
        if (this.r && this.x == null) {
            cj3.f().b(activity, true, 0);
            cj3.f().c(!MusicControl.h0().O());
            return;
        }
        cj3.f().b(activity, false, 0);
        if (this.r || !PlayService.R || (activity instanceof SyncAccessActivity) || (activity instanceof PatternPlayActivity) || (activity instanceof NinjaLockActivity) || !this.u || MusicControl.h0().O()) {
            return;
        }
        EventBus.getDefault().post(new NotificationMusicCloseEvent());
    }

    public void K() {
        Timer timer = this.B;
        if (timer != null) {
            timer.cancel();
            this.B = null;
        }
        if (DaoUtils.getTestValueDao().getExistKey(nd3.u(TestValueDao.SAVE_KEY_KEEP_SCREEN_KEY), TestValueDao.SAVE_KEY_KEEP_SCREEN_TYPE) == null) {
            EventBus.getDefault().post(new KeepScreenSetting(false));
        }
    }

    public boolean L() {
        if (my2.i.a().getB()) {
            na2.m().t();
            return true;
        }
        V();
        if (!D.isPause() && !WearUtils.r1()) {
            return false;
        }
        if (MyApplication.H() != null) {
            sg3.l(D.getTip(MyApplication.H()));
        }
        return true;
    }

    public final void M() {
        Music music = this.f;
        if (music == null) {
            return;
        }
        cj3.f().d(0);
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null || fragmentActivityH.isDestroyed() || fragmentActivityH.isFinishing()) {
            return;
        }
        is3.b bVar = new is3.b(fragmentActivityH);
        bVar.d(new b(this));
        MusicExpandDialog.c cVar = new MusicExpandDialog.c();
        cVar.b = cj3.f().h().c;
        int i = cj3.f().h().a;
        cVar.a = cj3.f().h().b;
        cVar.d = music.getTitle();
        cVar.c = R.drawable.full_control_music_expand;
        bVar.e(cVar);
        bVar.f(new c());
        bVar.c(new d(this));
        MusicExpandDialog musicExpandDialog = (MusicExpandDialog) cs3.i(bVar, MusicExpandDialog.class);
        this.z = musicExpandDialog;
        musicExpandDialog.p(fragmentActivityH);
        this.z.show();
        this.z.setListener(new e());
        this.x = new MusicHodler(this.z.findViewById(R.id.fl_root_view));
        if (MusicControl.h0().f == null || MusicControl.h0().f.getMusicType() != 2) {
            this.x.b().setText(WearUtils.Q(this.y / 1000));
        } else {
            this.x.b().setText(WearUtils.Q(MusicControl.h0().f.getDuration() / 1000));
        }
        if (O()) {
            if (MusicControl.h0().f == null || MusicControl.h0().f.getMusicType() != 2) {
                this.x.a().setImageResource(R.drawable.ic_expand_pause);
                return;
            } else {
                this.x.a().setImageResource(R.drawable.pattern_play_pause);
                return;
            }
        }
        if (MusicControl.h0().f == null || MusicControl.h0().f.getMusicType() != 2) {
            this.x.a().setImageResource(R.drawable.ic_expand_play);
        } else {
            this.x.a().setImageResource(R.drawable.pattern_play_play);
        }
    }

    public void N() {
        K();
        HomeFragment.E = 0;
        this.B = new Timer();
        a aVar = new a();
        this.C = aVar;
        this.B.schedule(aVar, 1000L, 200L);
    }

    public boolean O() {
        return this.d.h() || this.e.P() || rd3.f().o();
    }

    public void P() {
        cj3.f().d(0);
        if (this.r) {
            return;
        }
        String str = "stopService: " + PlayService.R;
        if (!PlayService.R || (cj3.f().g().getContext() instanceof SyncAccessActivity) || (cj3.f().g().getContext() instanceof PatternPlayActivity)) {
            return;
        }
        EventBus.getDefault().post(new NotificationCloseEvent());
    }

    public abstract void Q(i12 i12Var);

    public void R(Activity activity) {
        boolean z = (activity instanceof SoundPlayActivity) || (activity instanceof CreatePatternActivity) || (activity instanceof PatternPlayActivity) || (activity instanceof AlarmSoundPlayActivity) || (activity instanceof RemoteControlActivity) || (activity instanceof RemoteMultiControlActivity) || (activity instanceof SpeedModeActivity);
        this.w = z;
        if (z && O() && this.f != null) {
            S();
        }
        Music music = this.f;
        if (music != null && (activity instanceof MusicRecordPreviewActivity) && music.getMusicType() != 2) {
            rd3.f().B(false);
        }
        if ((activity instanceof GameActivity) || (activity instanceof NewMusicActivity) || (activity instanceof MusicRecordActivity) || (activity instanceof MusicRecordPreviewActivity) || (activity instanceof PlayerActivity) || (activity instanceof PlayListDetailsDActivity) || (activity instanceof SearchLocalMusicActivity) || (activity instanceof SearchStreamMusicActivity) || (activity instanceof SoreMusicPlaylistsActivity) || (activity instanceof StreamMusicLoginActivity)) {
            this.r = false;
        }
    }

    public void S() throws IllegalStateException {
        m12 m12Var = this.e;
        if (m12Var != null) {
            m12Var.X(0);
        }
        this.t = true;
        this.r = false;
        K();
        this.d.b.G();
        this.e.Y();
        this.e.b.G();
        if (this.u) {
            me3.e(me3.a.OTHERS);
        }
        this.u = false;
        b0();
        cj3.f().d(0);
        EventBus.getDefault().post(new MusicNotificationEvent());
        Q(i12.a.e());
        try {
            MusicExpandDialog musicExpandDialog = this.z;
            if (musicExpandDialog == null || !musicExpandDialog.isShowing()) {
                return;
            }
            this.z.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void T() {
        this.e.R();
    }

    public void U() {
        this.e.T();
    }

    public final void V() {
        if (D.isPatternPause() && !WearUtils.r1()) {
            MusicPlayEvent musicPlayEvent = D;
            musicPlayEvent.isPlayPatternOnHomePattern = false;
            musicPlayEvent.playPatternPause = false;
            qf3.C();
        }
        y12.c.a().t();
    }

    public abstract void W();

    public abstract void X();

    public abstract void Y();

    public void Z(Activity activity, g12.f fVar) {
        if (od3.c(activity)) {
            if (fVar != null) {
                fVar.a();
                return;
            }
            return;
        }
        Dialog dialog = this.A;
        if (dialog == null || !dialog.isShowing()) {
            f fVar2 = new f(fVar);
            is3.b bVar = new is3.b(activity);
            bVar.p(ah4.e(R.string.enable_music_floating_window_des));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.d(new g(fVar, activity));
            bVar.c(fVar2);
            bVar.q(ah4.e(R.string.enable_floating_window_title));
            is3 is3VarH = cs3.h(bVar);
            this.A = is3VarH;
            is3VarH.show();
        }
    }

    @Override // dc.cj3.c
    public void a() {
        M();
    }

    public void a0(int i) {
        rq1.d.j(i);
    }

    public void b0() {
        if (na2.m().i()) {
            return;
        }
        rq1.d.q();
    }
}
