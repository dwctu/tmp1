package com.wear.main.closeRange;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.RateFeature;
import com.wear.bean.Toy;
import com.wear.bean.ToySelectEvent;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.bean.event.ChangeToyEvent;
import com.wear.bean.event.UpdateToyStrengthEvent;
import com.wear.main.toy.newtoy.NewToyActivity;
import com.wear.ui.home.remote.RemoteControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.control.multiToys.MultiControlPanel;
import com.wear.widget.control.multiToys.MultiCurveLineView;
import com.wear.widget.velvo.VelvoPreviewView;
import dc.ToyControlBuilder;
import dc.dk2;
import dc.ek2;
import dc.fk2;
import dc.jp3;
import dc.k;
import dc.me3;
import dc.mk2;
import dc.mp1;
import dc.pc1;
import dc.pj3;
import dc.q53;
import dc.qf3;
import dc.sz1;
import dc.tz1;
import dc.vg3;
import dc.vu1;
import dc.wq1;
import dc.xc1;
import dc.ye3;
import dc.yf3;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class RemoteMultiControlActivity extends BaseActivity implements tz1, q53 {
    public boolean a = false;
    public Disposable b;

    @BindView(R.id.actionbar)
    public MyActionBar bar;
    public long c;
    public f d;
    public jp3 e;

    @BindView(R.id.multi_control_panel)
    public MultiControlPanel multiControlPanel;

    @BindView(R.id.velvo_preview)
    public VelvoPreviewView velvoPreviewView;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            RemoteMultiControlActivity.this.application.G().u0();
            RemoteMultiControlActivity.this.application.G().B();
            RemoteMultiControlActivity.this.finish();
        }
    }

    public class b implements MyActionBar.f {
        public b() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            pj3.o(RemoteMultiControlActivity.this, NewToyActivity.class, 1);
        }
    }

    public class c implements Consumer<Long> {
        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l) throws Exception {
            RemoteMultiControlActivity.this.bar.setSubTitle(WearUtils.Q(l.longValue()));
            RemoteMultiControlActivity.this.c = l.longValue();
        }
    }

    public class d implements MultiControlPanel.r {
        public d() {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.r
        public void b(String str) {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.r
        public void f(List<Ball2CurveEventBean> list) {
            if (RemoteMultiControlActivity.this.e != null) {
                RemoteMultiControlActivity.this.e.k(list);
            }
            RemoteMultiControlActivity.this.d.e(list);
            vg3.b().a(RemoteMultiControlActivity.this.d);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RemoteMultiControlActivity.this.application.G().u0();
            RemoteMultiControlActivity.this.application.G().B();
        }
    }

    public static class f implements Runnable {
        public HashMap<String, List<String>> a = new HashMap<>();
        public List<Ball2CurveEventBean> b = new ArrayList();

        public final void a(Toy toy, List<Ball2CurveEventBean> list) {
            ek2 ek2VarC = fk2.a.c(toy.getAddress());
            for (Ball2CurveEventBean ball2CurveEventBean : list) {
                if (ball2CurveEventBean != null && TextUtils.equals(toy.getAddress(), ball2CurveEventBean.getToyAddress())) {
                    if (!WearUtils.n1(ball2CurveEventBean.getGroups())) {
                        return;
                    }
                    int iIntValue = Integer.valueOf(ball2CurveEventBean.getGroups()).intValue();
                    if (ek2VarC == ek2.POSITION) {
                        dk2.a.e(toy.getAddress(), iIntValue, true);
                    } else if (ek2VarC == ek2.SPEED) {
                        pc1.a.d0(toy, iIntValue, true, true);
                    }
                }
            }
        }

        public final void b(Toy toy, List<Ball2CurveEventBean> list) {
            List<String> arrayList = this.a.get(toy.getAddress());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            List<List<String>> motors = toy.getMotors();
            if (motors == null || motors.isEmpty()) {
                return;
            }
            for (int i = 0; i < motors.size(); i++) {
                List<String> list2 = motors.get(i);
                if (arrayList.size() != i) {
                    arrayList.get(i);
                }
                for (String str : list2) {
                    for (Ball2CurveEventBean ball2CurveEventBean : list) {
                        if (ball2CurveEventBean != null && TextUtils.equals(toy.getAddress(), ball2CurveEventBean.getToyAddress())) {
                            if (ball2CurveEventBean.isRotateChange()) {
                                toy.setDirection(!toy.isDirection());
                            } else if (TextUtils.equals(str, ball2CurveEventBean.getFunction())) {
                                String strC = vu1.c(toy.getAndUpdateDeviceId(), str, Toy.changeSinglefuncLineToTayValue(str, ball2CurveEventBean.getGroups()));
                                if (arrayList.size() == i) {
                                    arrayList.add(i, strC);
                                } else {
                                    arrayList.set(i, strC);
                                }
                            }
                        }
                    }
                }
            }
            this.a.put(toy.getAddress(), arrayList);
            pc1.a.l0(toy.getAddress(), arrayList, false, false);
        }

        public final void c(Toy toy, List<Ball2CurveEventBean> list) {
            List<String> arrayList = this.a.get(toy.getAddress());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            List<List<String>> motors = toy.getMotors();
            if (motors == null || motors.isEmpty()) {
                return;
            }
            String multiplayOrder = toy.getMultiplayOrder();
            int i = 0;
            boolean z = false;
            while (i < motors.size()) {
                List<String> list2 = motors.get(i);
                String strC = arrayList.size() == i ? "-1" : arrayList.get(i);
                for (String str : list2) {
                    for (Ball2CurveEventBean ball2CurveEventBean : list) {
                        if (ball2CurveEventBean != null && TextUtils.equals(toy.getAddress(), ball2CurveEventBean.getToyAddress())) {
                            if (ball2CurveEventBean.isRotateChange()) {
                                pc1.a.e(ball2CurveEventBean.getToyAddress(), "RotateChange;");
                            } else if (TextUtils.equals(str, ball2CurveEventBean.getFunction())) {
                                strC = vu1.c(toy.getAndUpdateDeviceId(), str, Toy.changeSinglefuncLineToTayValue(str, ball2CurveEventBean.getGroups()));
                                if (arrayList.size() == i) {
                                    arrayList.add(i, strC);
                                } else {
                                    arrayList.set(i, strC);
                                }
                                z = true;
                            }
                        }
                    }
                }
                multiplayOrder = multiplayOrder + SignatureImpl.INNER_SEP + strC;
                i++;
            }
            this.a.put(toy.getAddress(), arrayList);
            if (z) {
                pc1.a.e(toy.getAddress(), multiplayOrder + ";");
            }
        }

        public final void d(Toy toy, List<Ball2CurveEventBean> list) throws NumberFormatException {
            for (Ball2CurveEventBean ball2CurveEventBean : list) {
                if (ball2CurveEventBean != null && TextUtils.equals(toy.getAddress(), ball2CurveEventBean.getToyAddress())) {
                    if (!ball2CurveEventBean.isRotateChange()) {
                        String function = ball2CurveEventBean.getFunction();
                        int i = Integer.parseInt(ball2CurveEventBean.getGroups());
                        String[] strArr = Toy.TOY_OPERATION.get(function);
                        if (!WearUtils.j1(strArr) && strArr.length >= 2) {
                            int i2 = 100 / Integer.parseInt(strArr[1]);
                            if (i > 0 && i / i2 == 0) {
                                i = i2;
                            }
                            int iB = vu1.b(toy.getAndUpdateDeviceId(), function, i / i2);
                            pc1.a.i0(toy.getAddress(), strArr[0].replace("#", "" + iB));
                        }
                    } else if (ball2CurveEventBean.getToyAddress().equals(toy.getAddress())) {
                        pc1.a.e(ball2CurveEventBean.getToyAddress(), "RotateChange;");
                    }
                }
            }
        }

        public void e(List<Ball2CurveEventBean> list) {
            this.b.clear();
            this.b.addAll(list);
        }

        @Override // java.lang.Runnable
        public void run() {
            Toy next;
            try {
                if (mp1.h()) {
                    wq1.b(this.b, new ToyControlBuilder(true, true, false, ToyControlBuilder.a.SETTING_ONLY));
                    return;
                }
                List<Ball2CurveEventBean> list = this.b;
                if (list == null || list.isEmpty()) {
                    return;
                }
                Iterator<Toy> it = pc1.a.P().iterator();
                while (it.hasNext() && (next = it.next()) != null && !TextUtils.isEmpty(next.getAddress())) {
                    if (next.isBAToy()) {
                        a(next, this.b);
                    } else if (next.isMultiplyInstruct()) {
                        c(next, this.b);
                    } else if (next.isSupportLVS()) {
                        b(next, this.b);
                    } else {
                        d(next, this.b);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(new Throwable("指令处理crash", e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B4(String str) {
        this.e.m(str);
    }

    public void C4() {
        new Handler().post(new e());
        finish();
    }

    @Override // dc.q53
    public void F() {
        finish();
    }

    @Override // dc.tz1
    public int getPriority() {
        return 0;
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            pc1 pc1Var = pc1.a;
            if (pc1Var.P().isEmpty()) {
                finish();
            } else {
                this.multiControlPanel.s0(pc1Var.P(), true, this.multiControlPanel.Q(), 1);
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.remote_multi_control);
        me3.c(me3.c.REMOTE_CONTROL_UI_ENTER);
        me3.e(me3.a.REMOTE_CONTROL);
        ye3.c("remote", "into page", null);
        ButterKnife.bind(this);
        this.application = (MyApplication) getApplication();
        setCurrentScreen(this, "remote_screen_view", RemoteMultiControlActivity.class.getSimpleName());
        this.bar.setBackAction(new a());
        this.bar.setToysAction(new b(), false, this);
        this.bar.n();
        this.bar.setSubTitle("00:00");
        this.b = Observable.interval(1L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c());
        if (qf3.a && !this.application.o) {
            qf3.C();
        }
        if (mk2.P().h0()) {
            mk2.P().n0(true);
        }
        addAnalyticsEventId("remote_control", null);
        WearUtils.x.m0();
        pc1 pc1Var = pc1.a;
        pc1Var.F();
        EventBus.getDefault().register(this);
        sz1.d().n(this);
        this.d = new f();
        this.multiControlPanel.setFilter(true);
        this.multiControlPanel.X(new d());
        this.multiControlPanel.N(false, "REMOTE_CONTROL", pc1Var.P());
        this.multiControlPanel.g0();
        this.multiControlPanel.setDividerVisible(false);
        RemoteControl.j().l(WearUtils.x, this.multiControlPanel);
        if (!RemoteControl.j().a) {
            RemoteControl.j().A();
        }
        RemoteControl.j().x();
        RemoteControl.j().y(this);
        this.e = new jp3(this.multiControlPanel, this.velvoPreviewView, "REMOTE_CONTROL");
        this.multiControlPanel.u(new MultiCurveLineView.a() { // from class: dc.t02
            @Override // com.wear.widget.control.multiToys.MultiCurveLineView.a
            public final void a(String str) {
                this.a.B4(str);
            }
        });
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        me3.c(me3.c.REMOTE_CONTROL_UI_EXIT);
        me3.e(me3.a.OTHERS);
        sz1.d().s(this);
        pc1.a.I();
        this.bar.s();
        EventBus.getDefault().unregister(this);
        this.application.G().u0();
        this.application.G().B();
        this.multiControlPanel.U();
        if (mk2.P().h0()) {
            mk2.P().n0(false);
        }
        RemoteControl.j().g();
        Disposable disposable = this.b;
        if (disposable != null && !disposable.isDisposed()) {
            this.b.dispose();
        }
        z4();
        yf3.i.a().s(RateFeature.RemoteControl, Integer.valueOf(k.a(this.c)));
        this.c = 0L;
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(xc1 xc1Var) {
        if (this.a) {
            pc1 pc1Var = pc1.a;
            Toy toyQ = pc1Var.Q(xc1Var.a());
            if (toyQ == null || !toyQ.isBAToy() || xc1Var.b() == 1) {
                this.multiControlPanel.s0(pc1Var.P(), false, this.multiControlPanel.Q(), 2);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ChangeToyEvent changeToyEvent) {
        Toy fysSelectToy;
        if (!this.multiControlPanel.Q() || (fysSelectToy = this.multiControlPanel.getFysSelectToy()) == null || !TextUtils.equals(fysSelectToy.getAddress(), changeToyEvent.getAddress()) || changeToyEvent.isAdd()) {
            return;
        }
        pc1.a.u0();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.a = false;
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.a = true;
        this.multiControlPanel.T();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    @Override // dc.tz1
    public void recovery() {
    }

    @Override // dc.q53
    public void s(int i, boolean z) {
    }

    @Override // dc.tz1
    public void stop(int i) {
        this.application.G().u0();
        this.application.G().B();
        finish();
    }

    public final void z4() {
        if (this.c >= 5) {
            HashMap map = new HashMap();
            map.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(this.c));
            ArrayList arrayList = new ArrayList();
            Iterator<Toy> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getDeviceId());
            }
            map.put("toy_mac", arrayList);
            ye3.d("M0045", WearUtils.A.toJson(map));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(UpdateToyStrengthEvent updateToyStrengthEvent) {
        if (updateToyStrengthEvent == null || updateToyStrengthEvent.getToy() == null) {
            return;
        }
        this.multiControlPanel.a0(updateToyStrengthEvent.getToy().getAddress());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ToySelectEvent toySelectEvent) {
        Toy fysSelectToy;
        if (!this.multiControlPanel.Q() || (fysSelectToy = this.multiControlPanel.getFysSelectToy()) == null || !TextUtils.equals(fysSelectToy.getAddress(), toySelectEvent.getAddress()) || toySelectEvent.isSelect()) {
            return;
        }
        pc1.a.u0();
    }
}
