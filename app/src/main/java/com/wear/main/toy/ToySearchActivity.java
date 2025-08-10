package com.wear.main.toy;

import android.animation.Animator;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.dao.DaoUtils;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.ap1;
import dc.cs3;
import dc.dg3;
import dc.is3;
import dc.me3;
import dc.n90;
import dc.og3;
import dc.pc1;
import dc.pj3;
import dc.q61;
import dc.re3;
import dc.rp1;
import dc.sg3;
import dc.t51;
import dc.u51;
import dc.uc1;
import dc.v51;
import dc.wf3;
import dc.xb1;
import dc.ye3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class ToySearchActivity extends BaseActivity implements dg3.b {
    public MyActionBar a;
    public ListView b;
    public LinearLayout c;
    public TextView d;
    public View e;
    public LottieAnimationView f;
    public pc1 h;
    public ap1 i;
    public LottieAnimationView j;
    public long g = 0;
    public Handler k = new Handler();

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            dg3.b();
            ToySearchActivity.this.h.i(false);
            ToySearchActivity.this.finish();
        }
    }

    public class b implements is3.d {

        public class a implements u51 {
            public a() {
            }

            @Override // dc.u51
            public /* synthetic */ void a(List list, boolean z) {
                t51.a(this, list, z);
            }

            @Override // dc.u51
            public void b(List<String> list, boolean z) {
                if (z) {
                    Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
                    intent.addFlags(268435456);
                    ToySearchActivity.this.startActivity(intent);
                }
            }
        }

        public b() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            if (!ToySearchActivity.this.application.h0()) {
                sg3.i(ToySearchActivity.this, R.string.ble_not_support);
                return;
            }
            q61 q61VarM = q61.m(ToySearchActivity.this);
            q61VarM.h(v51.a.a);
            q61VarM.j(new a());
        }
    }

    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ToySearchActivity.this.j.setVisibility(8);
            ToySearchActivity.this.f.setVisibility(0);
            ToySearchActivity.this.f.r();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class d implements MyActionBar.f {
        public d() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ToySearchActivity.this.x4();
        }
    }

    public class e extends HashMap<String, String> {
        public final /* synthetic */ int val$finalSearchCount;
        public final /* synthetic */ String val$finalSearchDeviceTypes;

        public e(int i, String str) {
            this.val$finalSearchCount = i;
            this.val$finalSearchDeviceTypes = str;
            put("count", "" + i + "#" + ToySearchActivity.this.h.o().size());
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(str);
            put("type", sb.toString());
        }
    }

    @Override // dc.dg3.b
    public void T1(long j) {
        if (this.g >= Long.MAX_VALUE) {
            this.g = 0L;
        }
        long j2 = this.g + 1;
        this.g = j2;
        if (j2 % 3 == 0) {
            this.d.setText(ah4.e(R.string.toy_search_tip));
            return;
        }
        if (j2 % 3 == 1) {
            this.d.setText(ah4.e(R.string.toy_search_tip).replace("...", "") + ".  ");
            return;
        }
        if (j2 % 3 == 2) {
            this.d.setText(ah4.e(R.string.toy_search_tip).replace("...", "") + ".. ");
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_toy_search);
        me3.c(me3.c.SEARCH_TOYS_START);
        ye3.c("My toys", "searching for toy", null);
        this.a = (MyActionBar) findViewById(R.id.actionbar);
        this.j = (LottieAnimationView) findViewById(R.id.iv_roate);
        setCurrentScreen(this, "toy_search_screen_view", ToySearchActivity.class.getSimpleName());
        re3.i();
        pc1 pc1VarG = WearUtils.x.G();
        this.h = pc1VarG;
        pc1VarG.h();
        this.a.setBackAction(new a());
        if (!w4()) {
            is3.b bVar = new is3.b(this);
            bVar.p(ah4.e(R.string.system_bluetooth_off));
            bVar.b(false);
            bVar.o(ah4.e(R.string.common_ok));
            bVar.d(new b());
            cs3.h(bVar).show();
        }
        getLayoutInflater();
        this.b = (ListView) findViewById(R.id.lv_toy_list);
        this.c = (LinearLayout) findViewById(R.id.toy_search_tips);
        this.f = (LottieAnimationView) findViewById(R.id.search_gif_loading);
        this.d = (TextView) findViewById(R.id.search_text_loading);
        this.e = findViewById(R.id.trun_on_empty);
        this.j.e(new c());
        int i = Build.VERSION.SDK_INT;
        if (i >= 23 && i < 31) {
            this.e.setVisibility(0);
        }
        WearUtils.x.p = true;
        EventBus.getDefault().register(this);
        ap1 ap1Var = new ap1(this);
        this.i = ap1Var;
        this.b.setAdapter((ListAdapter) ap1Var);
        this.h.h();
        this.i.notifyDataSetChanged();
        this.h.i(true);
        dg3.c(1000L, this);
        rp1.d();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dg3.b();
        me3.c(me3.c.SEARCH_TOYS_STOP);
        WearUtils.x.p = false;
        this.h.i(false);
        this.h.p0(true);
        this.k.removeCallbacksAndMessages(null);
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(n90 n90Var) {
        if (this.i.getCount() > 0) {
            this.e.setVisibility(8);
            this.c.setVisibility(8);
            this.a.setYesAction(R.string.common_done, new d());
        }
        if (this.h.n(n90Var.getA()) == null || !this.h.n(n90Var.getA()).isJ01Toy()) {
            return;
        }
        wf3.b().a();
    }

    public final boolean w4() {
        BluetoothAdapter adapter = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        return adapter != null && adapter.isEnabled();
    }

    public final void x4() {
        this.h.i(false);
        ArrayList<Toy> arrayListQ = this.h.q();
        if (arrayListQ.size() < 1) {
            sg3.i(this, R.string.toy_selectOne);
            return;
        }
        re3.i();
        StringBuilder sb = new StringBuilder();
        Iterator<Toy> it = arrayListQ.iterator();
        int i = 0;
        while (it.hasNext()) {
            Toy next = it.next();
            if (next == null || !next.isSelect()) {
                re3.g(next);
            } else {
                sb.append(next.getDeviceType());
                sb.append("#");
                i++;
                String[] strArrSplit = next.getDeviceType().split(";")[0].split(SignatureImpl.INNER_SEP);
                if (!DaoUtils.getToyDao().existToyByEmail(WearUtils.y.r(), next.getAddress()) && Toy.NAME_MAP.containsKey(next.getType())) {
                    next.setId(next.getAddress() + WearUtils.y.r());
                    next.setVersion(Integer.valueOf(Integer.parseInt(strArrSplit[1])));
                    next.setUuid(next.getUuid());
                    next.setF01IsNotice(true);
                    boolean z = !xb1.b(next.getUuid(), next.getAddress()) && og3.a(9);
                    next.setIsSelect(1);
                    if (z) {
                        next.setIsSelect(0);
                    }
                    this.h.v(next, true);
                    MyApplication.T = true;
                }
            }
            next.setRenameDeviceName();
        }
        addAnalyticsEventId("toy_add", new e(i, sb.toString()));
        this.h.t0();
        setResult(1, new Intent());
        if (!WearUtils.e1(sb.toString()) && sb.toString().endsWith("#")) {
            rp1.e(new StringBuilder(sb.substring(0, sb.length() - 1)).toString());
        }
        rp1.f();
        if (MyApplication.T) {
            EventBus.getDefault().post(new uc1(null, 10));
        }
        if (getIntent().getBooleanExtra("isFirstConnect", false)) {
            pj3.f(this, ToyActivity.class);
        }
        finish();
    }
}
