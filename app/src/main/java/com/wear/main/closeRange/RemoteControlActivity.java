package com.wear.main.closeRange;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.main.toy.ToyActivity;
import com.wear.ui.home.remote.RemoteControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.control.CurveLineTimeView;
import com.wear.widget.control.MultipleControlLayout;
import dc.ah4;
import dc.g12;
import dc.pc1;
import dc.pj3;
import dc.q53;
import dc.qf3;
import dc.sz1;
import dc.tz1;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class RemoteControlActivity extends BaseActivity implements tz1, q53 {
    public MyActionBar a;
    public MyApplication b;

    @BindView(R.id.curveBottomSpace)
    public View curveBottomSpace;

    @BindView(R.id.curveLayout2)
    public LinearLayout curveLayout2;

    @BindView(R.id.curveTimeLine)
    public CurveLineTimeView curveTimeLine;

    @BindView(R.id.curveTimeLine2)
    public CurveLineTimeView curveTimeLine2;

    @BindView(R.id.curveTopSpace)
    public View curveTopSpace;
    public Unbinder e;

    @BindView(R.id.multiControl)
    public MultipleControlLayout multiControl;
    public boolean c = false;
    public Handler d = new Handler();

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            pj3.f(RemoteControlActivity.this, ToyActivity.class);
        }
    }

    public class b implements MyActionBar.f {
        public b() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            RemoteControlActivity.this.u4();
        }
    }

    public class c implements CurveLineTimeView.c {
        public c() {
        }

        @Override // com.wear.widget.control.CurveLineTimeView.c
        public void a(String str) {
            MultipleControlLayout multipleControlLayout = RemoteControlActivity.this.multiControl;
            if (multipleControlLayout != null) {
                multipleControlLayout.getTopTimer().setText(str);
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RemoteControlActivity.this.multiControl.i();
            if (RemoteControl.j().k() > 0) {
                RemoteControlActivity.this.multiControl.s();
                RemoteControlActivity.this.multiControl.f();
                RemoteControlActivity.this.multiControl.l();
                RemoteControlActivity.this.multiControl.setAllProgress(RemoteControl.j().k());
            }
        }
    }

    public class e implements g12.f {
        public e() {
        }

        @Override // dc.g12.f
        public void a() {
            RemoteControlActivity.this.finish();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RemoteControlActivity.this.b.G().u0();
        }
    }

    @Override // dc.q53
    public void F() {
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        RemoteControl.j().s();
    }

    @Override // dc.tz1
    public int getPriority() {
        return 0;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        RemoteControl.j().z(this, new e());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.remote_control);
        this.e = ButterKnife.bind(this);
        this.b = (MyApplication) getApplication();
        setCurrentScreen(this, "remote_screen_view", RemoteControlActivity.class.getSimpleName());
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.a = myActionBar;
        myActionBar.setToysAction(new a(), true, this);
        this.a.setBackAction(new b());
        this.a.n();
        this.curveTimeLine.setTimeCallBack(new c());
        this.multiControl.setApplication(this.b);
        t4(false);
        v4();
        if (qf3.a && !this.b.o) {
            qf3.C();
        }
        addAnalyticsEventId("remote_control", null);
        WearUtils.x.m0();
        pc1.a.F();
        EventBus.getDefault().register(this);
        sz1.d().n(this);
        if (!RemoteControl.j().a) {
            RemoteControl.j().A();
        }
        RemoteControl.j().x();
        RemoteControl.j().y(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        pc1.a.I();
        RemoteControl.j().g();
        this.multiControl.u();
        this.multiControl.j();
        this.curveTimeLine.h();
        this.curveTimeLine.h();
        this.a.s();
        this.e.unbind();
        EventBus.getDefault().unregister(this);
        sz1.d().s(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (this.multiControl.d()) {
            return;
        }
        this.b.G().u0();
        t4(true);
        v4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z || this.c) {
            return;
        }
        this.multiControl.m();
        this.c = true;
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
        u4();
    }

    public final void t4(boolean z) throws Resources.NotFoundException {
        this.curveTimeLine.i();
        ArrayList<Toy> arrayListP = this.b.G().P();
        if (arrayListP == null || arrayListP.size() <= 0) {
            finish();
            return;
        }
        if (arrayListP.size() == 1) {
            this.multiControl.setBindToySize(1);
            MultipleControlLayout multipleControlLayout = this.multiControl;
            MultipleControlLayout.d dVar = MultipleControlLayout.d.Base;
            multipleControlLayout.k(dVar, this.curveTimeLine, arrayListP.get(0), false, true);
            this.multiControl.k(MultipleControlLayout.d.Right, this.curveTimeLine2, null, false, true);
            this.multiControl.k(MultipleControlLayout.d.Bottom, this.curveTimeLine2, null, false, true);
            this.curveTimeLine.setToyName("");
            this.multiControl.setTapNameVisibility(dVar, 0, ah4.e(R.string.toy_control_tip_max_level));
            this.multiControl.n();
            this.multiControl.p(0);
            this.multiControl.g(false);
        } else if (arrayListP.size() > 1) {
            this.multiControl.setBindToySize(2);
            MultipleControlLayout multipleControlLayout2 = this.multiControl;
            MultipleControlLayout.d dVar2 = MultipleControlLayout.d.Base;
            multipleControlLayout2.k(dVar2, this.curveTimeLine, arrayListP.get(0), false, true);
            MultipleControlLayout multipleControlLayout3 = this.multiControl;
            MultipleControlLayout.d dVar3 = MultipleControlLayout.d.Right;
            multipleControlLayout3.k(dVar3, this.curveTimeLine2, arrayListP.get(1), false, true);
            this.multiControl.k(MultipleControlLayout.d.Bottom, this.curveTimeLine2, arrayListP.get(1), false, true);
            this.curveTimeLine.setToyName(WearUtils.e1(arrayListP.get(0).getDefineRename()) ? arrayListP.get(0).getName() : arrayListP.get(0).getDefineRename());
            this.multiControl.setTapNameVisibility(dVar2, 0, WearUtils.e1(arrayListP.get(0).getDefineRename()) ? arrayListP.get(0).getName() : arrayListP.get(0).getDefineRename());
            this.curveTimeLine2.setToyName(WearUtils.e1(arrayListP.get(1).getDefineRename()) ? arrayListP.get(1).getName() : arrayListP.get(1).getDefineRename());
            MultipleControlLayout multipleControlLayout4 = this.multiControl;
            boolean zE1 = WearUtils.e1(arrayListP.get(1).getDefineRename());
            Toy toy = arrayListP.get(1);
            multipleControlLayout4.setTapNameVisibility(dVar3, 0, zE1 ? toy.getName() : toy.getDefineRename());
            this.multiControl.p(0);
            this.multiControl.g(false);
            this.multiControl.n();
        }
        this.multiControl.m();
        this.multiControl.i();
        this.d.postDelayed(new d(), 200L);
    }

    public void u4() {
        this.multiControl.t();
        new Handler().post(new f());
        finish();
    }

    public final void v4() {
        if (this.multiControl.getBindToySize() == 1) {
            this.curveTopSpace.setVisibility(0);
            this.curveBottomSpace.setVisibility(0);
            this.curveLayout2.setVisibility(8);
        } else {
            this.curveTopSpace.setVisibility(8);
            this.curveBottomSpace.setVisibility(8);
            this.curveLayout2.setVisibility(0);
        }
    }
}
