package com.wear.ui.home.pattern.control;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.SyncAccessActivity;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.bean.event.MusicNotificationEvent;
import com.wear.bean.event.NinjaPatternChangeEvent;
import com.wear.bean.event.NotificationCloseEvent;
import com.wear.bean.event.NotificationPatternCloseEvent;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.closeRange.MusicRecordActivity;
import com.wear.main.closeRange.MusicRecordPreviewActivity;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.closeRange.RemoteControlActivity;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.closeRange.alarm.AlarmSoundPlayActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.game.ui.GameActivity;
import com.wear.main.longDistance.player.ui.PlayerActivity;
import com.wear.main.ninja.NinjaLockActivity;
import com.wear.main.ninja.service.PlayService;
import com.wear.main.patterns.CreatePatternActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.ui.discover.pattern.PatternSearchActivity;
import com.wear.ui.discover.pattern.PatternStoreActivity;
import com.wear.ui.discover.pattern.PatternUserActivity;
import com.wear.ui.home.sound.SoundPlayActivity;
import com.wear.ui.me.PatternsHiddenActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.vibematevideo.ui.InteractiveVideoActivity;
import com.wear.widget.control.TouchControlView;
import com.wear.widget.dialog.PatternExpandDialog;
import dc.Event;
import dc.ExpandData;
import dc.ToyControlBuilder;
import dc.a22;
import dc.ah4;
import dc.be3;
import dc.c22;
import dc.cs3;
import dc.db2;
import dc.de0;
import dc.e22;
import dc.eg3;
import dc.f22;
import dc.g22;
import dc.gk2;
import dc.h12;
import dc.h22;
import dc.hv1;
import dc.is3;
import dc.ll3;
import dc.me3;
import dc.mk2;
import dc.mk3;
import dc.mp1;
import dc.na2;
import dc.nd3;
import dc.od3;
import dc.pc1;
import dc.pj3;
import dc.qf3;
import dc.rq1;
import dc.sg3;
import dc.tn2;
import dc.ue2;
import dc.w12;
import dc.wq1;
import dc.x12;
import dc.xe2;
import dc.y12;
import dc.zn2;
import dc.zt3;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.functions.Function2;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class PatternPlayManagerImpl implements x12 {
    public static boolean H = false;
    public h22 A;
    public g22 B;
    public final e22 C;
    public List<Class<? extends Activity>> D;
    public String F;
    public String G;
    public Handler d;
    public boolean e;
    public Runnable f;
    public MyApplication g;
    public PlayReceiver h;
    public PatternExpandDialog i;
    public WeakReference<Dialog> j;
    public PatternHodler k;
    public Pattern s;
    public List<String> u;
    public long y;
    public f22 z;
    public final Set<hv1> a = new CopyOnWriteArraySet();
    public List<Pattern> b = new ArrayList();
    public int c = 0;
    public boolean l = false;
    public boolean m = false;
    public int n = 100;
    public final double[] o = {4.0d, 2.0d, 1.0d, 0.5d, 0.25d};
    public boolean p = true;
    public boolean q = true;
    public String[] r = null;
    public int t = 0;
    public final List<String> v = Arrays.asList("loop", "random", "repeat");
    public String w = "loop";
    public int x = 0;
    public boolean E = false;

    public class PlayReceiver extends BroadcastReceiver {
        public PlayReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                String str = action + "   " + PlayService.R;
                if (PlayService.R) {
                    PatternPlayManagerImpl.this.C0();
                    if ("com.wear.pattern.notify.prev".equals(action)) {
                        PatternPlayManagerImpl.this.H0(-1);
                        return;
                    }
                    if ("com.wear.pattern.notify.play_state".equals(action)) {
                        PatternPlayManagerImpl.this.E0();
                        return;
                    }
                    if ("com.wear.pattern.notify.next".equals(action)) {
                        PatternPlayManagerImpl.this.H0(1);
                        return;
                    }
                    if ("com.wear.pattern.notify.loop".equals(action)) {
                        PatternPlayManagerImpl.this.W0(true);
                        return;
                    }
                    if ("com.wear.pattern.notify.close".equals(action)) {
                        if (MyApplication.K instanceof PatternPlayActivity) {
                            PatternPlayManagerImpl.this.p = true;
                            PatternPlayManagerImpl.this.q = true;
                            Iterator it = PatternPlayManagerImpl.this.a.iterator();
                            while (it.hasNext()) {
                                ((hv1) it.next()).V1(PatternPlayManagerImpl.this.p, PatternPlayManagerImpl.this.x);
                            }
                            if (PatternPlayManagerImpl.this.x == 2 && PatternPlayManagerImpl.this.p && PatternPlayManagerImpl.this.s != null && PatternPlayManagerImpl.this.r != null) {
                                ll3.E().d0("stop", (PatternPlayManagerImpl.this.t / 10) + "", (PatternPlayManagerImpl.this.r.length / 100) + "", PatternPlayManagerImpl.this.s.getName());
                            }
                            if (PatternPlayManagerImpl.this.p) {
                                PatternPlayManagerImpl.this.C.e();
                            } else {
                                PatternPlayManagerImpl.this.C.c();
                            }
                            PatternPlayManagerImpl.this.V0();
                        } else {
                            PatternPlayManagerImpl.this.B0();
                        }
                        EventBus.getDefault().post(new NotificationCloseEvent());
                        MusicControl.h0().r = false;
                        MusicControl.h0().p0();
                        MusicControl.h0().P();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
    }

    public class a extends h22 {
        public a(PatternPlayManagerImpl patternPlayManagerImpl) {
        }

        @Override // dc.f22
        public void b(Map map) {
        }

        @Override // dc.f22
        public void c(Map map) {
        }
    }

    public class b extends g22 {
        public b() {
        }

        @Override // dc.g22, dc.f22
        public void b(Map map) {
            super.b(map);
            PatternPlayManagerImpl.H = true;
            h12.D.playPatternPause = true;
            PatternPlayManagerImpl.this.b.clear();
            PatternPlayManagerImpl.this.b.addAll(map.get("patternList") == null ? new ArrayList<>() : (List) map.get("patternList"));
            PatternPlayManagerImpl.this.n = 100;
            PatternPlayManagerImpl.this.x = map.get("patternType") == null ? 0 : ((Integer) map.get("patternType")).intValue();
            if (PatternPlayManagerImpl.this.x == 0) {
                PatternPlayManagerImpl patternPlayManagerImpl = PatternPlayManagerImpl.this;
                patternPlayManagerImpl.w = eg3.h(patternPlayManagerImpl.g, "patternPlayModel", "loop");
                PatternPlayManagerImpl.this.W0(false);
                String str = "2";
                String strH = eg3.h(PatternPlayManagerImpl.this.g, "patternPlaySpeed", "2");
                if (Double.parseDouble(strH) < 1.0d) {
                    eg3.i(PatternPlayManagerImpl.this.g, "patternPlaySpeed", "2");
                } else {
                    str = strH;
                }
                PatternPlayManagerImpl patternPlayManagerImpl2 = PatternPlayManagerImpl.this;
                patternPlayManagerImpl2.n = (int) ((1.0d / patternPlayManagerImpl2.o[Integer.parseInt(str)]) * 100.0d);
            } else {
                PatternPlayManagerImpl.this.w = "loop";
            }
            me3.e(me3.a.PATTERN_PLAY);
        }

        @Override // dc.f22
        public void c(Map map) {
            if (mk2.P().h0() && PatternPlayManagerImpl.H) {
                mk2.P().n0(false);
            }
            PatternPlayManagerImpl.this.H();
            if (PatternPlayManagerImpl.H) {
                me3.e(me3.a.OTHERS);
            }
            PatternPlayManagerImpl.H = false;
            PatternPlayManagerImpl.this.U0();
            PatternPlayManagerImpl.this.J();
            PatternPlayManagerImpl.this.b.clear();
            PatternPlayManagerImpl.this.s = null;
            PatternPlayManagerImpl.this.a.clear();
            EventBus.getDefault().post(new MusicNotificationEvent());
            EventBus.getDefault().post(new NotificationPatternCloseEvent());
        }
    }

    public class c implements ue2.a {
        public final /* synthetic */ Pattern a;

        public c(Pattern pattern) {
            this.a = pattern;
        }

        @Override // dc.ue2.a
        public void a(int i, String str) {
            sg3.l(String.format(ah4.e(R.string.pattern_havent_download), this.a.getName()));
            PatternPlayManagerImpl patternPlayManagerImpl = PatternPlayManagerImpl.this;
            patternPlayManagerImpl.e = true;
            patternPlayManagerImpl.H0(1 ^ (patternPlayManagerImpl.w.equals("repeat") ? 1 : 0));
        }

        @Override // dc.ue2.a
        public void b(File file) {
            Pattern pattern = this.a;
            if (pattern.setDataNoCheckFormat(WearUtils.N1(pattern.getFile().getPath()))) {
                PatternPlayManagerImpl.this.G0(this.a);
                return;
            }
            sg3.l(String.format(ah4.e(R.string.pattern_havent_download), this.a.getName()));
            PatternPlayManagerImpl patternPlayManagerImpl = PatternPlayManagerImpl.this;
            patternPlayManagerImpl.e = true;
            patternPlayManagerImpl.H0(1 ^ (patternPlayManagerImpl.w.equals("repeat") ? 1 : 0));
        }
    }

    public class d implements zn2<String> {
        public d() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            PatternPlayManagerImpl.this.m = true;
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    public class e implements PatternExpandDialog.c {
        public e() {
        }

        @Override // com.wear.widget.dialog.PatternExpandDialog.c
        public void a() {
            if (PatternPlayManagerImpl.this.M()) {
                return;
            }
            PatternPlayManagerImpl.this.C0();
            PatternPlayManagerImpl.this.E0();
        }

        @Override // com.wear.widget.dialog.PatternExpandDialog.c
        public void b() {
            if (PatternPlayManagerImpl.this.M()) {
                return;
            }
            PatternPlayManagerImpl.this.C0();
            PatternPlayManagerImpl.this.H0(1);
        }

        @Override // com.wear.widget.dialog.PatternExpandDialog.c
        public void c() {
            if (PatternPlayManagerImpl.this.M()) {
                return;
            }
            PatternPlayManagerImpl.this.C0();
            PatternPlayManagerImpl.this.H0(-1);
            EventBus.getDefault().post(new MusicNotificationEvent());
        }

        @Override // com.wear.widget.dialog.PatternExpandDialog.c
        public void end() {
            PatternPlayManagerImpl.this.B0();
        }
    }

    public interface f {
        void a(Pattern pattern, int i, boolean z, String str, String str2, int i2, String[] strArr);
    }

    public PatternPlayManagerImpl(e22 e22Var) {
        this.C = e22Var;
        W();
    }

    public static PatternPlayManagerImpl O() {
        return (PatternPlayManagerImpl) y12.c.a().i(y12.c.TYPE_PATTERN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j0() {
        H0(!this.w.equals("repeat") ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l0() {
        if (!na2.m().t() && O().f0(this.s) > 0) {
            O().E0();
            h12.D.isPlayPatternOnHomePattern = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n0() {
        if (!na2.m().t() && O().f0(this.s) > 0) {
            O().E0();
            h12.D.isPlayPatternOnHomePattern = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p0(Activity activity) {
        Pattern pattern;
        if (this.x == 0 || ((pattern = this.s) != null && WearUtils.e1(pattern.getPatternStoreTag()))) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("pattern", this.s);
            bundle.putSerializable("intoType", 1);
            bundle.putString("from", "MianActivity");
            ((xe2) xe2.L0()).J1(new ArrayList(this.b));
            pj3.g(activity, PatternPlayActivity.class, bundle);
            return;
        }
        if (this.x == 2) {
            if (!(activity instanceof InteractiveVideoActivity)) {
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("intoType", "1");
                pj3.g(activity, InteractiveVideoActivity.class, bundle2);
                return;
            }
            if (O().d0()) {
                db2.A().q(new db2.s() { // from class: dc.q43
                    @Override // dc.db2.s
                    public final void a() {
                        this.a.l0();
                    }
                });
            }
            Bundle bundle3 = new Bundle();
            bundle3.putSerializable("pattern", this.s);
            bundle3.putSerializable("intoType", 1);
            bundle3.putSerializable("isFlow", 1);
            bundle3.putString("from", "is_from_vibeMate_pattern");
            ((xe2) xe2.L0()).J1(new ArrayList(this.b));
            pj3.g(activity, PatternPlayActivity.class, bundle3);
            return;
        }
        if (!(activity instanceof PatternStoreActivity) && !(activity instanceof PatternSearchActivity) && !(activity instanceof PatternUserActivity)) {
            Pattern patternT = O().T();
            if (patternT == null || WearUtils.e1(patternT.getPatternStoreTag()) || !patternT.getPatternStoreTag().contains("#Hidden")) {
                pj3.f(activity, PatternStoreActivity.class);
                return;
            } else {
                pj3.f(activity, PatternsHiddenActivity.class);
                return;
            }
        }
        if (O().d0()) {
            db2.A().q(new db2.s() { // from class: dc.r43
                @Override // dc.db2.s
                public final void a() {
                    this.a.n0();
                }
            });
        }
        Bundle bundle4 = new Bundle();
        bundle4.putSerializable("pattern", this.s);
        bundle4.putSerializable("intoType", 1);
        bundle4.putSerializable("isFlow", 1);
        bundle4.putString("from", "pattern_select_page");
        ((xe2) xe2.L0()).J1(new ArrayList(this.b));
        pj3.g(activity, PatternPlayActivity.class, bundle4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r0(DialogInterface dialogInterface) {
        this.k = null;
        this.i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t0() {
        this.p = true;
        PatternHodler patternHodler = this.k;
        if (patternHodler != null) {
            patternHodler.ivPlayOrPause.setImageResource(R.drawable.ic_expand_play);
        }
        Iterator<hv1> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().V1(this.p, this.x);
        }
        if (this.x == 2 && this.p && this.s != null && this.r != null) {
            ll3.E().d0("stop", (this.t / 10) + "", (this.r.length / 100) + "", this.s.getName());
        }
        if (PlayService.R) {
            EventBus.getDefault().post(new NinjaPatternChangeEvent(this.p));
        } else {
            O0(this.s);
        }
        this.C.e();
        V0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y0() {
        this.j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A0(Activity activity) {
        try {
            this.j = null;
            od3.d(activity);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void B0() {
        gk2.e().l(false);
        h(new Event(c22.EVENT_STOP, null));
    }

    public void C0() {
        if (!h12.D.playPatternPause || WearUtils.r1()) {
            return;
        }
        h12.D.playPatternPause = false;
        qf3.C();
    }

    public void D0() {
        this.g.l.post(new Runnable() { // from class: dc.u43
            @Override // java.lang.Runnable
            public final void run() {
                this.a.t0();
            }
        });
    }

    public void E0() {
        boolean z = !this.p;
        this.p = z;
        this.q = z;
        PatternHodler patternHodler = this.k;
        if (patternHodler != null) {
            patternHodler.ivPlayOrPause.setImageResource(z ? R.drawable.ic_expand_play : R.drawable.ic_expand_pause);
        }
        if (this.x == 2 && this.p && this.s != null && this.r != null) {
            ll3.E().d0("stop", (this.t / 10) + "", (this.r.length / 10) + "", this.s.getName());
        }
        Iterator<hv1> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().V1(this.p, this.x);
        }
        if (PlayService.R) {
            EventBus.getDefault().post(new NinjaPatternChangeEvent(this.p));
        } else {
            O0(this.s);
        }
        if (gk2.e().j(this.s)) {
            gk2.e().k(this.p, this.t, true);
        } else {
            V0();
        }
        if (this.p) {
            this.C.e();
            H();
        } else {
            this.C.c();
            this.y = be3.r();
        }
    }

    public void F0() {
        if (this.p) {
            this.C.e();
        } else {
            this.C.c();
        }
    }

    public void G(hv1 hv1Var) {
        this.a.add(hv1Var);
    }

    public void G0(final Pattern pattern) {
        H();
        this.y = be3.r();
        if (pattern == null) {
            return;
        }
        File file = pattern.getFile();
        if (!WearUtils.e1(pattern.getData()) || file == null) {
            this.G = pattern.getData();
        } else {
            String path = file.getPath();
            this.F = path;
            this.G = WearUtils.N1(path);
        }
        if (!WearUtils.g1(this.b)) {
            Iterator<Pattern> it = this.b.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().getId().equals(pattern.getId())) {
                    this.c = i;
                }
                i++;
            }
        }
        Iterator<hv1> it2 = this.a.iterator();
        while (it2.hasNext()) {
            it2.next().A3(pattern, this.x);
        }
        if (L(pattern, file)) {
            return;
        }
        O0(pattern);
        String strF = gk2.e().f(pattern);
        this.e = false;
        this.p = false;
        this.q = false;
        Iterator<hv1> it3 = this.a.iterator();
        while (it3.hasNext()) {
            it3.next().D2(pattern, this.x);
        }
        T0(MyApplication.H());
        this.C.c();
        if (this.x == 0) {
            DaoUtils.getTestValueDao().save(zt3.k, nd3.u(WearUtils.A.toJson(pattern)), TestValueDao.HOME_PLAY_PATTERN_HIS);
        }
        this.s = pattern;
        Z(pattern);
        pattern.setData(this.G);
        this.t = 0;
        if (!this.E) {
            gk2.e().i(pattern, this.G, 0);
            this.E = false;
        }
        if (strF.equals("pos")) {
            gk2.e().h(pattern, this.G, this.n, this.t, true);
        }
        if (pattern.getHead() == null) {
            this.r = this.G.split(",");
            Iterator<hv1> it4 = this.a.iterator();
            while (it4.hasNext()) {
                it4.next().u3(false);
            }
        } else {
            this.r = this.G.split(TouchControlView.P);
            boolean zIsMulFunction = pattern.getHead().isMulFunction();
            Iterator<hv1> it5 = this.a.iterator();
            while (it5.hasNext()) {
                it5.next().u3(zIsMulFunction);
            }
        }
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Runnable runnable = new Runnable() { // from class: dc.v43
            @Override // java.lang.Runnable
            public final void run() {
                this.a.v0(pattern);
            }
        };
        this.f = runnable;
        Handler handler2 = this.d;
        if (handler2 != null) {
            handler2.postDelayed(runnable, 0L);
        }
        if (mk2.P().h0()) {
            mk2.P().n0(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void H() {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.home.pattern.control.PatternPlayManagerImpl.H():void");
    }

    public void H0(int i) {
        Random random;
        int iNextInt;
        int size;
        this.E = true;
        random = new Random();
        List<Pattern> list = this.b;
        iNextInt = 0;
        size = list == null ? 0 : list.size();
        String str = this.w;
        str.hashCode();
        switch (str) {
            case "random":
                if (size != 0) {
                    iNextInt = random.nextInt(size);
                    break;
                }
                break;
            case "repeat":
            case "loop":
                if (size != 0) {
                    if (this.e) {
                        i = 1;
                    }
                    iNextInt = ((this.c + i) + size) % size;
                    break;
                }
                break;
        }
        List<Pattern> list2 = this.b;
        if (list2 == null || list2.size() <= 0) {
            J();
        } else {
            this.g.G().u0();
            G0(this.b.get(iNextInt));
        }
    }

    public String I(int i, int i2) {
        if (i <= 0) {
            return "00:01";
        }
        int iFloor = (int) Math.floor(i * (i2 / 1000.0f));
        String str = "sec====" + iFloor;
        return WearUtils.Q(iFloor <= 0 ? 1L : iFloor);
    }

    public void I0(Pattern pattern, int i) {
        int i2 = 0;
        if (WearUtils.g1(this.b) || pattern == null) {
            this.c = 0;
        } else {
            Iterator<Pattern> it = this.b.iterator();
            while (it.hasNext()) {
                if (it.next().getId().equals(pattern.getId())) {
                    this.c = i2;
                }
                i2++;
            }
        }
        H0(i);
    }

    public final void J() {
        this.p = true;
        this.q = true;
    }

    public final void J0(final Pattern pattern, String str, String str2) {
        String str3 = "processNewPattern: " + str2;
        this.u = pattern.getHead().createCommands(str2);
        if (this.t % 10 == 0) {
            Iterator<hv1> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().X3(I(this.r.length - this.t, 100), L0(this.r.length - 1, this.t), this.x, str);
            }
            PatternHodler patternHodler = this.k;
            if (patternHodler != null) {
                patternHodler.tvTime.setText(I(this.r.length - this.t, 100));
            }
            Y0(this.t);
            String[] strArr = this.r;
            X0(strArr.length, strArr.length - this.t);
        }
        List<String> list = this.u;
        if (list == null || list.size() == 0) {
            return;
        }
        if (this.u.size() != 0) {
            List<String> list2 = this.u;
            if (!WearUtils.e1(list2.get(list2.size() - 1))) {
                List<String> list3 = this.u;
                String str4 = list3.get(list3.size() - 1);
                if (str4.split(",").length <= 2 || !pattern.getHead().isAllFunc()) {
                    Iterator<hv1> it2 = this.a.iterator();
                    while (it2.hasNext()) {
                        it2.next().T3(str4, this.x, str);
                    }
                } else {
                    String str5 = str4.split(",")[0];
                    Iterator<hv1> it3 = this.a.iterator();
                    while (it3.hasNext()) {
                        it3.next().T3(str5, this.x, str);
                    }
                }
            }
        }
        List<String> list4 = this.u;
        if (list4 == null || list4.size() <= 0) {
            return;
        }
        Iterator<String> it4 = this.u.iterator();
        while (it4.hasNext()) {
            de0.j("ble_pattern", "after cmd: " + it4.next());
        }
        if (!mp1.h()) {
            for (Toy toy : this.g.G().P()) {
                if (!toy.isBAToy() || !gk2.e().f(pattern).contains("pos")) {
                    pc1.a.m0(toy, pattern.isSystemPattern(), this.u, false, true, false, false);
                }
            }
            return;
        }
        if (this.u.size() > 0) {
            List<String> list5 = this.u;
            String str6 = list5.get(list5.size() - 1);
            ToyControlBuilder toyControlBuilder = new ToyControlBuilder(true, true, false, ToyControlBuilder.a.SPEED);
            toyControlBuilder.f(new Function2() { // from class: dc.y43
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(((Toy) obj).isBAToy() && gk2.e().f(pattern).contains("pos"));
                }
            });
            wq1.a(str6, pattern, toyControlBuilder);
        }
    }

    public void K(List<Pattern> list, Integer num, Pattern pattern) {
        this.b.clear();
        this.b.addAll(list);
        Pattern pattern2 = this.s;
        if (pattern2 != null && pattern2.getId().equals(pattern.getId())) {
            this.c--;
            this.s = pattern;
            return;
        }
        if (WearUtils.g1(this.b) || this.s == null) {
            return;
        }
        int i = 0;
        for (Pattern pattern3 : this.b) {
            if (pattern3.getId().equals(this.s.getId())) {
                this.s = pattern3;
                this.c = i;
            }
            i++;
        }
    }

    public final void K0(String str, String str2) {
        float f2 = WearUtils.q1(str2) ? Float.parseFloat(str2) : 0.0f;
        Iterator<hv1> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().z3(101.0f - f2);
        }
        rq1.d.e((int) f2, new ToyControlBuilder(true, true, false));
        if (this.t % 10 == 0) {
            Iterator<hv1> it2 = this.a.iterator();
            while (it2.hasNext()) {
                it2.next().X3(I(this.r.length - this.t, 100), L0(this.r.length - 1, this.t), this.x, str);
            }
            PatternHodler patternHodler = this.k;
            if (patternHodler != null) {
                patternHodler.tvTime.setText(I(this.r.length - this.t, 100));
            }
            Y0(this.t);
            String[] strArr = this.r;
            X0(strArr.length, strArr.length - this.t);
        }
    }

    public final boolean L(Pattern pattern, File file) {
        boolean z = file != null && file.exists();
        if (TextUtils.isEmpty(pattern.getData()) && !z && TextUtils.isEmpty(pattern.getPath())) {
            sg3.h(R.string.file_notfound);
            this.e = true;
            H0(!this.w.equals("repeat") ? 1 : 0);
            return true;
        }
        if (TextUtils.isEmpty(pattern.getData())) {
            if (!z) {
                N(pattern);
                return true;
            }
            if (!pattern.setDataNoCheckFormat(WearUtils.N1(pattern.getFile().getPath()))) {
                sg3.h(R.string.pattern_format_error_delete);
                this.e = true;
                H0(!this.w.equals("repeat") ? 1 : 0);
                return true;
            }
        }
        return false;
    }

    public int L0(int i, int i2) {
        if (i2 >= i) {
            return 100;
        }
        if (i == 0) {
            return 0;
        }
        return (i2 * 100) / i;
    }

    public boolean M() {
        return false;
    }

    public void M0(Pattern pattern) {
        Pattern pattern2;
        if (!H || (pattern2 = this.s) == null) {
            return;
        }
        if (!pattern2.getId().equals(pattern.getId())) {
            for (Pattern pattern3 : this.b) {
                if (pattern3.getId().equals(pattern.getId())) {
                    this.b.remove(pattern3);
                    return;
                }
            }
            return;
        }
        if (this.b.size() <= 1) {
            B0();
            return;
        }
        H0(1);
        for (Pattern pattern4 : this.b) {
            if (pattern4.getId().equals(pattern.getId())) {
                this.b.remove(pattern4);
                return;
            }
        }
    }

    public final void N(Pattern pattern) {
        xe2.L0().f(pattern.getId(), pattern.getPath(), new c(pattern));
    }

    public void N0(hv1 hv1Var) {
        this.a.remove(hv1Var);
    }

    public void O0(Pattern pattern) {
        String strE;
        if (pattern == null) {
            return;
        }
        try {
            if ((WearUtils.e1(pattern.getIsShowReview()) || !pattern.getIsShowReview().equals("1")) && (WearUtils.e1(pattern.getStatus()) || !pattern.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE) || TextUtils.isEmpty(pattern.getPatternStoreTag()))) {
                strE = WearUtils.e1(pattern.getName()) ? ah4.e(R.string.pattern_name) : pattern.getName();
            } else {
                strE = ah4.e(R.string.patterns_under_review) + "/*!/";
            }
            if (PlayService.R) {
                EventBus.getDefault().post(new NinjaPatternChangeEvent(strE, WearUtils.e1(pattern.getAuthor()) ? ah4.e(R.string.common_anonymous) : pattern.getAuthor(), this.w, false));
                return;
            }
            Intent intent = new Intent(this.g, (Class<?>) PlayService.class);
            intent.setAction("pattern_start");
            intent.putExtra("play_name", strE);
            intent.putExtra("play_author", WearUtils.e1(pattern.getAuthor()) ? ah4.e(R.string.common_anonymous) : pattern.getAuthor());
            intent.putExtra("play_mode", this.v.indexOf(this.w));
            if (Build.VERSION.SDK_INT >= 26) {
                this.g.startForegroundService(intent);
            } else {
                this.g.startService(intent);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public boolean P() {
        if (this.s.getHead() != null) {
            return this.s.getHead().isAllFunc();
        }
        return false;
    }

    public void P0(String str, boolean z) {
        Pattern pattern = this.s;
        if (pattern == null || !pattern.getId().equals(str)) {
            return;
        }
        this.s.setFavorite(z);
    }

    public String Q() {
        return this.w;
    }

    public void Q0(int i) {
        this.t = (this.r.length * i) / 100;
        this.l = true;
        if (gk2.e().j(this.s)) {
            gk2.e().m(this.n, this.t, d0());
        }
    }

    public void R(Pattern pattern, f fVar) {
        if (pattern == null) {
            return;
        }
        this.s = pattern;
        if (pattern == null) {
            return;
        }
        boolean zIsMulFunction = pattern.getHead() != null ? this.s.getHead().isMulFunction() : false;
        List<String> list = this.u;
        if (list == null || list.size() == 0) {
            return;
        }
        if (WearUtils.e1(this.u.get(r10.size() - 1))) {
            return;
        }
        String str = this.u.get(r10.size() - 1);
        if (str.split(",").length > 2 && this.s.getHead() != null && this.s.getHead().isAllFunc()) {
            str = str.split(",")[0];
        }
        fVar.a(this.s, this.x, zIsMulFunction, I(this.r.length - this.t, 100), str, this.t, this.r);
    }

    public void R0(int i) {
        this.n = i;
    }

    public List<Pattern> S() {
        return this.b;
    }

    public void S0(int i) {
        this.n = i;
        gk2.e().n(i, this.t, true, d0());
    }

    public Pattern T() {
        return this.s;
    }

    public void T0(final Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || this.D.contains(activity.getClass())) {
            return;
        }
        if (od3.c(activity)) {
            this.C.b();
            return;
        }
        WeakReference<Dialog> weakReference = this.j;
        if (weakReference == null || weakReference.get() == null || !this.j.get().isShowing()) {
            is3.c cVar = new is3.c() { // from class: dc.p43
                @Override // dc.is3.c
                public final void doCancel() {
                    this.a.y0();
                }
            };
            is3.b bVar = new is3.b(activity);
            bVar.p(ah4.e(R.string.enable_floating_window_des));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.d(new is3.d() { // from class: dc.w43
                @Override // dc.is3.d
                public final void doConfirm() {
                    this.a.A0(activity);
                }
            });
            bVar.c(cVar);
            bVar.q(ah4.e(R.string.enable_floating_window_title));
            WeakReference<Dialog> weakReference2 = new WeakReference<>(cs3.h(bVar));
            this.j = weakReference2;
            if (weakReference2.get() != null) {
                this.j.get().show();
            }
        }
    }

    public String U() {
        return I(this.t, 100);
    }

    public void U0() {
        if (this.p) {
            this.g.G().u0();
        }
        if (PlayService.R) {
            EventBus.getDefault().post(new NinjaPatternChangeEvent(true));
        } else {
            O0(this.s);
        }
        this.p = true;
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.s != null) {
            this.g.G().u0();
        }
        Iterator<hv1> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().z1();
        }
        gk2.e().o();
    }

    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final void v0(Pattern pattern) {
        this.d.postDelayed(this.f, this.n);
        if (this.p) {
            return;
        }
        String patternStoreTag = pattern.getPatternStoreTag();
        int i = this.t;
        if (i >= this.r.length - 1) {
            this.p = true;
            this.t = i - 1;
            this.g.G().u0();
            Iterator<hv1> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().X3(I(this.r.length - this.t, 100), L0(this.r.length - 1, this.t), this.x, patternStoreTag);
            }
            PatternHodler patternHodler = this.k;
            if (patternHodler != null) {
                patternHodler.tvTime.setText(I(this.r.length - this.t, 100));
                if (this.p) {
                    this.k.ivPlayOrPause.setImageResource(R.drawable.ic_expand_play);
                } else {
                    this.k.ivPlayOrPause.setImageResource(R.drawable.ic_expand_pause);
                }
            }
            this.g.l.postDelayed(new Runnable() { // from class: dc.t43
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.j0();
                }
            }, 300L);
        }
        int i2 = this.t;
        if (i2 < 0) {
            return;
        }
        String[] strArr = this.r;
        if (i2 >= strArr.length - 1) {
            return;
        }
        String str = strArr[i2];
        if (WearUtils.e1(str)) {
            this.t++;
            return;
        }
        Iterator<hv1> it2 = this.a.iterator();
        while (it2.hasNext()) {
            it2.next().O2(this.t, pattern, this.r);
        }
        if (pattern.getHead() == null) {
            K0(patternStoreTag, str);
        } else {
            J0(pattern, patternStoreTag, str);
        }
        this.t++;
    }

    public void V0() {
        if (na2.m().i()) {
            return;
        }
        this.g.G().u0();
    }

    public void W() {
        this.d = new Handler(Looper.getMainLooper());
        this.g = MyApplication.N();
        a0();
        b0();
        Y();
    }

    public void W0(boolean z) {
        int iIndexOf = this.v.indexOf(this.w);
        if (z) {
            iIndexOf = (iIndexOf + 1) % this.v.size();
        }
        String str = this.v.get(iIndexOf);
        this.w = str;
        eg3.i(this.g, "patternPlayModel", str);
        if (PlayService.R) {
            EventBus.getDefault().post(new NinjaPatternChangeEvent(this.w));
        } else {
            O0(this.s);
        }
        Iterator<hv1> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().B3(this.w);
        }
    }

    public void X(List<Pattern> list, int i) {
        HashMap map = new HashMap();
        map.put("patternList", list);
        map.put("patternType", Integer.valueOf(i));
        h(new Event(c22.EVENT_START, map));
    }

    public final void X0(int i, int i2) {
        if (WearUtils.g1(WearUtils.x.G().P())) {
            return;
        }
        int iFloor = (int) Math.floor(i * 0.1f);
        int iFloor2 = (int) Math.floor(i2 * 0.1f);
        int iFloor3 = iFloor - ((int) Math.floor((i * 0.3d) * 0.1f));
        boolean z = iFloor3 == iFloor2 && i >= 30;
        if (this.l) {
            boolean z2 = iFloor3 >= iFloor2;
            this.l = false;
            z = z2;
        }
        if (iFloor == iFloor2) {
            this.m = false;
        }
        if (!z || this.m) {
            return;
        }
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, this.s.getId());
        tn2.x(this.g).l("/wear/pattern/addRealPlayCount", map, new d());
    }

    public final void Y() {
        ArrayList arrayList = new ArrayList();
        this.D = arrayList;
        arrayList.add(SyncAccessActivity.class);
        this.D.add(NinjaLockActivity.class);
        this.D.add(PatternPlayActivity.class);
    }

    public final void Y0(int i) {
        if (this.x == 2 && i > 1800) {
            mk3.a.d(this.s.getId());
        }
    }

    public final void Z(Pattern pattern) {
        PatternHodler patternHodler = this.k;
        if (patternHodler != null) {
            patternHodler.tvTime.setText("00:00");
            if ((WearUtils.e1(pattern.getIsShowReview()) || !pattern.getIsShowReview().equals("1")) && (WearUtils.e1(pattern.getStatus()) || !pattern.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE) || TextUtils.isEmpty(pattern.getPatternStoreTag()))) {
                this.k.iv_under_preview.setVisibility(8);
                this.k.tvUserName.setText(TextUtils.isEmpty(pattern.getName()) ? "" : pattern.getName());
            } else {
                this.k.iv_under_preview.setVisibility(0);
                this.k.tvUserName.setText(R.string.patterns_under_review);
            }
            if (this.p) {
                this.k.ivPlayOrPause.setImageResource(R.drawable.ic_expand_play);
            } else {
                this.k.ivPlayOrPause.setImageResource(R.drawable.ic_expand_pause);
            }
        }
    }

    @Override // dc.x12
    public boolean a() {
        PatternExpandDialog patternExpandDialog = this.i;
        return patternExpandDialog != null && patternExpandDialog.isShowing();
    }

    public final void a0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.wear.pattern.notify.prev");
        intentFilter.addAction("com.wear.pattern.notify.play_state");
        intentFilter.addAction("com.wear.pattern.notify.next");
        intentFilter.addAction("com.wear.pattern.notify.loop");
        intentFilter.addAction("com.wear.pattern.notify.close");
        PlayReceiver playReceiver = new PlayReceiver();
        this.h = playReceiver;
        if (Build.VERSION.SDK_INT >= 33) {
            this.g.registerReceiver(playReceiver, intentFilter, 4);
        } else {
            this.g.registerReceiver(playReceiver, intentFilter);
        }
    }

    @Override // dc.x12
    public /* synthetic */ boolean b(f22 f22Var, Map map) {
        return w12.a(this, f22Var, map);
    }

    public final void b0() {
        a aVar = new a(this);
        this.A = aVar;
        this.B = new b();
        this.z = aVar;
    }

    @Override // dc.x12
    public void c(@Nullable f22 f22Var) {
        this.z = f22Var;
    }

    public boolean c0() {
        int i;
        return (!H || (i = this.x) == 1 || i == 2 || this.s == null) ? false : true;
    }

    @Override // dc.x12
    @Nullable
    public String d() {
        return null;
    }

    public boolean d0() {
        return this.p;
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: e */
    public f22 getI() {
        return this.z;
    }

    public boolean e0() {
        return this.q;
    }

    @Override // dc.x12
    public boolean f() {
        return true;
    }

    public int f0(Pattern pattern) {
        Pattern pattern2 = this.s;
        if (pattern2 == null || pattern2.getPatternStoreTag() == null || pattern.getPatternStoreTag() == null || !this.s.getPatternStoreTag().equals(pattern.getPatternStoreTag())) {
            return 0;
        }
        return this.p ? 1 : 2;
    }

    @Override // dc.x12
    public void g() {
        PatternExpandDialog patternExpandDialog = this.i;
        if (patternExpandDialog != null) {
            patternExpandDialog.dismiss();
        }
    }

    public boolean g0() {
        return this.s != null && this.x == 1 && this.q;
    }

    @Override // dc.x12
    @NonNull
    public a22 getPriority() {
        return a22.PRIORITY_1;
    }

    @Override // dc.x12
    public /* synthetic */ boolean h(Event event) {
        return w12.b(this, event);
    }

    public void h0(String str, f fVar) {
        Pattern pattern = this.s;
        if (pattern == null || this.x == 0 || pattern.getPatternStoreTag() == null || !this.s.getPatternStoreTag().endsWith(str)) {
            return;
        }
        boolean zIsMulFunction = this.s.getHead() != null ? this.s.getHead().isMulFunction() : false;
        List<String> list = this.u;
        if (list == null || list.size() == 0) {
            return;
        }
        if (WearUtils.e1(this.u.get(r10.size() - 1))) {
            return;
        }
        String str2 = this.u.get(r10.size() - 1);
        if (str2.split(",").length > 2 && P()) {
            str2 = str2.split(",")[0];
        }
        fVar.a(this.s, this.x, zIsMulFunction, I(this.r.length - this.t, 100), str2, this.t, this.r);
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: i */
    public h22 getJ() {
        return this.A;
    }

    @Override // dc.x12
    public void j(boolean z, int i, int i2) {
        final FragmentActivity fragmentActivityH;
        if (this.s == null || (fragmentActivityH = MyApplication.H()) == null || fragmentActivityH.isDestroyed() || fragmentActivityH.isFinishing()) {
            return;
        }
        this.C.f();
        ExpandData expandData = new ExpandData();
        expandData.k(z);
        expandData.p(i);
        expandData.q(i2);
        expandData.l(this.s.getName());
        expandData.j(R.drawable.full_control_pattern_expand);
        if ((!WearUtils.e1(this.s.getIsShowReview()) && this.s.getIsShowReview().equals("1")) || (!WearUtils.e1(this.s.getStatus()) && this.s.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE) && !TextUtils.isEmpty(this.s.getPatternStoreTag()))) {
            expandData.o(1);
        }
        is3.b bVar = new is3.b(fragmentActivityH);
        bVar.d(new is3.d() { // from class: dc.s43
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.p0(fragmentActivityH);
            }
        });
        bVar.e(expandData);
        bVar.f(new DialogInterface.OnDismissListener() { // from class: dc.x43
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.a.r0(dialogInterface);
            }
        });
        final e22 e22Var = this.C;
        Objects.requireNonNull(e22Var);
        bVar.c(new is3.c() { // from class: dc.o43
            @Override // dc.is3.c
            public final void doCancel() {
                e22Var.b();
            }
        });
        PatternExpandDialog patternExpandDialog = (PatternExpandDialog) cs3.i(bVar, PatternExpandDialog.class);
        this.i = patternExpandDialog;
        patternExpandDialog.p(fragmentActivityH);
        this.i.show();
        this.i.setListener(new e());
        PatternHodler patternHodler = new PatternHodler(this.i.findViewById(R.id.fl_root_view));
        this.k = patternHodler;
        patternHodler.tvTime.setText(I(this.r.length - this.t, 100));
        if (this.p) {
            this.k.ivPlayOrPause.setImageResource(R.drawable.ic_expand_play);
        } else {
            this.k.ivPlayOrPause.setImageResource(R.drawable.ic_expand_pause);
        }
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: k */
    public e22 getA() {
        return this.C;
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: l */
    public g22 getK() {
        return this.B;
    }

    @Override // dc.x12
    public void m(Activity activity) {
        if ((activity instanceof SoundPlayActivity) || (activity instanceof MusicRecordActivity) || (activity instanceof AlarmSoundPlayActivity) || (activity instanceof RemoteControlActivity) || (activity instanceof RemoteMultiControlActivity) || (activity instanceof CreatePatternActivity) || (activity instanceof GameActivity) || (activity instanceof MusicRecordPreviewActivity) || (activity instanceof PlayerActivity)) {
            if (this.p && this.s == null) {
                return;
            }
            B0();
        }
    }

    @Override // dc.x12
    @NonNull
    public List<Class<? extends Activity>> n() {
        return this.D;
    }

    @Override // dc.x12
    @Nullable
    public String o() {
        return "pattern_anim.json";
    }
}
