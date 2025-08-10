package com.wear.ui.home.pattern;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.event.OpenLockEvent;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.toy.ToyActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.ui.home.pattern.fragment.MyPatternListFragment;
import com.wear.ui.home.pattern.fragment.MyPatternsFragment;
import com.wear.ui.me.SettingActivity;
import com.wear.util.MyApplication;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.ch3;
import dc.cs3;
import dc.hf3;
import dc.is3;
import dc.me3;
import dc.nd3;
import dc.od3;
import dc.pj3;
import dc.rf3;
import dc.sg3;
import dc.te2;
import dc.tn2;
import dc.xe2;
import dc.xe3;
import dc.ye3;
import dc.zn2;
import dc.zt3;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class NewPatternActivity extends BaseActivity implements te2.b {
    public static int i;
    public MyPatternsFragment a;

    @BindView(R.id.actionbar)
    public MyActionBar actionBar;
    public MyPatternListFragment b;

    @BindView(R.id.choose_patterns_notice)
    public TextView choosePatternsNotice;

    @BindView(R.id.fl_content)
    public FrameLayout flContent;
    public boolean g;

    @BindView(R.id.iv_sync_top_tip)
    public ImageView ivSyncTopTip;

    @BindView(R.id.rl_sync_top_tip)
    public RelativeLayout rlSyncTopTip;

    @BindView(R.id.tv_sync_top_tip)
    public TextView tvSyncTopTip;
    public FragmentManager c = getSupportFragmentManager();
    public te2 d = xe2.L0();
    public xe2 e = (xe2) xe2.L0();
    public int f = 0;
    public Handler h = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            if (ch3.n().X()) {
                NewPatternActivity newPatternActivity = NewPatternActivity.this;
                if (newPatternActivity.f == 1) {
                    newPatternActivity.D4();
                }
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ch3.n().X()) {
                NewPatternActivity newPatternActivity = NewPatternActivity.this;
                int i = newPatternActivity.f;
                if (i == 3 || i == 4) {
                    newPatternActivity.C4();
                }
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NewPatternActivity.this.rlSyncTopTip.getVisibility() == 0 && ch3.n().X()) {
                NewPatternActivity newPatternActivity = NewPatternActivity.this;
                if (newPatternActivity.f == 2 && newPatternActivity.g) {
                    newPatternActivity.E4();
                } else {
                    newPatternActivity.F4(0L);
                }
            }
        }
    }

    public class d implements MyActionBar.f {
        public d() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            NewPatternActivity.this.y4(0);
        }
    }

    public class e implements MyActionBar.f {
        public e() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            NewPatternActivity.this.y4(1);
        }
    }

    public class f implements MyActionBar.f {
        public f() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            pj3.f(NewPatternActivity.this, ToyActivity.class);
        }
    }

    public class g implements is3.c {
        public g() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            NewPatternActivity.this.G4();
        }
    }

    public class h implements is3.d {
        public h() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            NewPatternActivity.this.G4();
            pj3.f(NewPatternActivity.this, SettingActivity.class);
        }
    }

    public class i implements is3.d {
        public i() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            od3.d(NewPatternActivity.this.activity);
        }
    }

    public class j implements is3.c {
        public j(NewPatternActivity newPatternActivity) {
        }

        @Override // dc.is3.c
        public void doCancel() {
            DaoUtils.getTestValueDao().save(zt3.k, "0", TestValueDao.NINJA_MODE_SWITCH_TYPE);
            EventBus.getDefault().post(new OpenLockEvent(false));
        }
    }

    public class k implements zn2<String> {
        public k(NewPatternActivity newPatternActivity) {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NewPatternActivity newPatternActivity = NewPatternActivity.this;
            if (newPatternActivity.f == 2) {
                newPatternActivity.rlSyncTopTip.setVisibility(8);
            }
        }
    }

    public final void A4() throws Resources.NotFoundException {
        this.ivSyncTopTip.clearAnimation();
        if (!ch3.n().X() || MyApplication.Z) {
            this.f = 0;
            this.rlSyncTopTip.setEnabled(false);
            this.rlSyncTopTip.setVisibility(8);
        } else if (this.d.p()) {
            this.f = 2;
            this.rlSyncTopTip.setEnabled(false);
            this.rlSyncTopTip.setVisibility(8);
        } else if (this.d.r()) {
            D4();
        } else if (this.d.H()) {
            C4();
        }
    }

    public final void B4() throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.sync_roate_img);
        animationLoadAnimation.setInterpolator(new LinearInterpolator());
        this.ivSyncTopTip.startAnimation(animationLoadAnimation);
    }

    public final void C4() {
        this.ivSyncTopTip.clearAnimation();
        this.f = 3;
        this.g = false;
        this.rlSyncTopTip.setVisibility(0);
        this.rlSyncTopTip.setEnabled(true);
        this.ivSyncTopTip.setImageResource(R.drawable.home_pattern_sync_fail);
        this.tvSyncTopTip.setText(ah4.e(R.string.pattern_sync_failed_server_error));
        if (hf3.d(this)) {
            return;
        }
        this.f = 4;
        this.tvSyncTopTip.setText(ah4.e(R.string.pattern_sync_failed_network_error));
    }

    public final void D4() throws Resources.NotFoundException {
        this.ivSyncTopTip.clearAnimation();
        this.g = true;
        this.f = 1;
        this.rlSyncTopTip.setVisibility(0);
        this.rlSyncTopTip.setEnabled(false);
        this.tvSyncTopTip.setText(ah4.e(R.string.pattern_in_sync));
        this.ivSyncTopTip.setImageResource(R.drawable.tip_syncing);
        B4();
    }

    public final void E4() {
        F4(5000L);
    }

    public final void F4(long j2) {
        this.ivSyncTopTip.clearAnimation();
        this.f = 2;
        this.g = false;
        this.rlSyncTopTip.setVisibility(0);
        this.rlSyncTopTip.setEnabled(false);
        this.tvSyncTopTip.setText(ah4.e(R.string.pattern_sync_success));
        this.ivSyncTopTip.setImageResource(R.drawable.tip_sync_success);
        this.h.postDelayed(new l(), j2);
    }

    @Override // dc.te2.b
    public void G() {
        xe3.a(xe2.r, "所有任务已完成：但是同步失败   status=" + this.f + " showUi=" + this.g);
        int i2 = this.f;
        if (i2 == 3 || i2 == 4) {
            return;
        }
        this.f = 3;
        this.h.removeCallbacksAndMessages(null);
        runOnMainThread(new b());
    }

    public final void G4() {
        if (ch3.n().o() == null) {
            xe2 xe2Var = this.e;
            xe2Var.l = true;
            SettingActivity.f = true;
            xe2Var.Z("patternSync_tipSee");
            return;
        }
        HashMap map = new HashMap();
        map.put("type", "syncPatternTips");
        this.e.Z("patternSync_tipSee");
        this.e.l = true;
        SettingActivity.f = true;
        ch3.n().o().setSyncPatternTips(1);
        tn2.x(this.application).l("/api/user/updateUserTipsConfig", map, new k(this));
    }

    @Override // dc.te2.b
    public void I3(te2.a aVar) {
        xe3.a(xe2.r, "任务成功：" + aVar.b);
    }

    @Override // dc.te2.b
    public void Y(te2.a aVar) {
        xe3.a(xe2.r, "开始任务：" + aVar.b + "   status=" + this.f + " showUi=" + this.g);
        if (this.f == 1 || isDestroyed() || isFinishing()) {
            return;
        }
        int i2 = this.f;
        this.f = 1;
        this.h.removeCallbacksAndMessages(null);
        this.h.postDelayed(new a(), (i2 == 3 || i2 == 4) ? 0L : 1000L);
    }

    @Override // dc.te2.b
    public void d() {
        xe3.a(xe2.r, "所有任务已完成并且同步成功   status=" + this.f + " showUi=" + this.g);
        int i2 = this.f;
        if (i2 == 3 || i2 == 4) {
            this.g = true;
        }
        this.f = 2;
        this.h.removeCallbacksAndMessages(null);
        runOnMainThread(new c());
    }

    @Override // dc.te2.b
    public void d4(te2.a aVar) {
        xe3.a(xe2.r, "任务失败：" + aVar.b);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_new_pattern);
        me3.c(me3.c.MY_PATTERNS_UI_ENTER);
        ye3.c("my patterns", "into page", null);
        ButterKnife.bind(this);
        setCurrentScreen(this, "pattern_local_play_screen_view", NewPatternActivity.class.getSimpleName());
        A4();
        this.choosePatternsNotice.setVisibility(0);
        this.choosePatternsNotice.setText(ah4.e(R.string.patternslist_drag_notice));
        this.actionBar.setTabAction(0, ah4.e(R.string.main_patterns), new d());
        this.actionBar.setTabAction(1, ah4.e(R.string.main_playlist), new e());
        this.actionBar.setToysAction(new f(), false, this);
        this.actionBar.n();
        if (bundle != null) {
            this.a = (MyPatternsFragment) this.c.getFragment(bundle, MyPatternsFragment.class.getSimpleName());
            this.b = (MyPatternListFragment) this.c.getFragment(bundle, MyPatternListFragment.class.getSimpleName());
        }
        if (this.a == null) {
            this.a = new MyPatternsFragment();
            i = -1;
        }
        if (this.b == null) {
            this.b = new MyPatternListFragment();
        }
        int i2 = i;
        y4(i2 != -1 ? i2 : 0);
        if (!ch3.n().Y() && !MyApplication.Z) {
            is3.b bVar = new is3.b(this);
            bVar.p(ah4.e(R.string.pattern_support_sync));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.d(new h());
            bVar.c(new g());
            cs3.h(bVar).show();
        }
        this.d.k(this);
        if (z4()) {
            return;
        }
        cs3.d(this, ah4.e(R.string.ninja_mode_permission), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), new i(), new j(this)).show();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        me3.c(me3.c.MY_PATTERNS_UI_EXIT);
        this.actionBar.s();
        this.ivSyncTopTip.clearAnimation();
        this.d.D(this);
        this.h.removeCallbacksAndMessages(null);
        rf3.e();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        MyPatternsFragment myPatternsFragment = this.a;
        if (myPatternsFragment != null && myPatternsFragment.isAdded()) {
            this.c.putFragment(bundle, this.a.getClass().getSimpleName(), this.a);
        }
        MyPatternListFragment myPatternListFragment = this.b;
        if (myPatternListFragment == null || !myPatternListFragment.isAdded()) {
            return;
        }
        this.c.putFragment(bundle, this.b.getClass().getSimpleName(), this.b);
    }

    @OnClick({R.id.rl_sync_top_tip})
    public void onViewClicked() throws Resources.NotFoundException {
        if (!hf3.d(this)) {
            sg3.h(R.string.net_connect_error_tip);
        } else {
            D4();
            this.d.j();
        }
    }

    public final void y4(int i2) {
        if (i == i2) {
            return;
        }
        i = i2;
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        if (i2 == 0) {
            if (this.a.isAdded()) {
                fragmentTransactionBeginTransaction.show(this.a);
            } else {
                fragmentTransactionBeginTransaction.add(R.id.fl_content, this.a);
            }
            MyPatternListFragment myPatternListFragment = this.b;
            if (myPatternListFragment != null && myPatternListFragment.isAdded()) {
                fragmentTransactionBeginTransaction.hide(this.b);
            }
        } else {
            if (this.b.isAdded()) {
                fragmentTransactionBeginTransaction.show(this.b);
            } else {
                fragmentTransactionBeginTransaction.add(R.id.fl_content, this.b);
            }
            MyPatternsFragment myPatternsFragment = this.a;
            if (myPatternsFragment != null && myPatternsFragment.isAdded()) {
                fragmentTransactionBeginTransaction.hide(this.a);
            }
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public final boolean z4() {
        return MyApplication.Z || DaoUtils.getTestValueDao().getExistKey(nd3.u(zt3.k), TestValueDao.NINJA_MODE_SWITCH_TYPE) != null || Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this);
    }
}
