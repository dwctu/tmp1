package com.wear.main.toy;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.ExoPlayer;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.toy.ToyRecyclerViewAdapter;
import com.wear.bean.Toy;
import com.wear.bean.ToyRename;
import com.wear.bean.ToySelectEvent;
import com.wear.bean.controlmutlitoys.ToyDSLocalEvent;
import com.wear.bean.event.ToyAddClickEvent;
import com.wear.dao.DaoUtils;
import com.wear.main.toy.ToyActivity;
import com.wear.main.toy.pin.ToyPinRemoveFailTipActivity;
import com.wear.main.toy.pin.ToyPinTipActivity;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.RecyclerViewNoBugLinearLayoutManager;
import dc.ah4;
import dc.be3;
import dc.ce3;
import dc.cs3;
import dc.db2;
import dc.ep1;
import dc.fq1;
import dc.h32;
import dc.hu3;
import dc.i30;
import dc.is3;
import dc.kn3;
import dc.lp1;
import dc.me3;
import dc.og3;
import dc.pc1;
import dc.q61;
import dc.re3;
import dc.rp1;
import dc.rq1;
import dc.sg3;
import dc.u51;
import dc.uc1;
import dc.ud3;
import dc.v51;
import dc.vc1;
import dc.ve3;
import dc.vg3;
import dc.vl2;
import dc.wi2;
import dc.xb1;
import dc.xc1;
import dc.xe3;
import dc.ye3;
import dc.ze3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class ToyActivity extends BaseActivity<vl2> {
    public LinearLayout a;
    public LinearLayout b;
    public String c;
    public MyApplication d;
    public RecyclerView e;
    public ToyRecyclerViewAdapter f;
    public View g;
    public Handler h;
    public Button i;
    public TextView j;
    public pc1 k;
    public Timer l;
    public final BroadcastReceiver m = new a();

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0)) {
                    case 10:
                    case 13:
                        ToyActivity.this.j.setVisibility(0);
                        break;
                    case 11:
                    case 12:
                        ToyActivity.this.j.setVisibility(8);
                        break;
                }
            }
        }
    }

    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ToyActivity.this.H4();
        }
    }

    public class c implements u51 {
        public c() {
        }

        public static /* synthetic */ void c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e() {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", ToyActivity.this.getPackageName(), null));
            ToyActivity.this.startActivity(intent);
        }

        @Override // dc.u51
        public void a(@NonNull List<String> list, boolean z) {
            is3.b bVar = new is3.b(ToyActivity.this);
            bVar.o(ah4.e(R.string.button_continue));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.c(new is3.c() { // from class: dc.og2
                @Override // dc.is3.c
                public final void doCancel() {
                    ToyActivity.c.c();
                }
            });
            bVar.d(new is3.d() { // from class: dc.pg2
                @Override // dc.is3.d
                public final void doConfirm() {
                    this.a.e();
                }
            });
            bVar.p(ah4.e(R.string.permission_buletooth_forground));
            cs3.h(bVar).show();
        }

        @Override // dc.u51
        public void b(@NonNull List<String> list, boolean z) {
            if (z) {
                ToyActivity.this.s5();
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
            RequestPermissionActivity.s4(ToyActivity.this);
        }
    }

    public class e implements kn3.d {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public class a extends HashMap<String, String> {
            public final /* synthetic */ String val$finalDeviceType;

            public a(String str) {
                this.val$finalDeviceType = str;
                put("count", "" + ToyActivity.this.f.getItemCount());
                put("type", str);
            }
        }

        public e(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b() {
            ToyActivity.this.k.resetBleParams();
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            rq1.d.r(this.a);
            Toy toyQ = ToyActivity.this.d.G().Q(this.a);
            if (toyQ == null) {
                return;
            }
            ToyActivity.this.d.G().E(toyQ);
            toyQ.setDisConnectType(1);
            toyQ.setRealDeviceType(false);
            toyQ.setIsLongRange(0);
            ToyActivity.this.d.G().a0(toyQ.getAddress(), true);
            ToyActivity.this.f.g.remove(toyQ.getAddress());
            vg3.b().a(new Runnable() { // from class: dc.rg2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            });
            ToyActivity.this.k.p0(true);
            re3.u(toyQ);
            rp1.h(toyQ);
            ToyActivity.this.addAnalyticsEventId("toy_remove", new a(toyQ.getDeviceType()));
            db2.A().P();
            h32.i().z();
            wi2.e().f("ToyActivity.delToy()-->toyId:" + this.a + ", toyName:" + this.b);
            ArrayList<Toy> arrayListO = ToyActivity.this.d.G().o();
            StringBuilder sb = new StringBuilder();
            sb.append("doConfirm: ");
            sb.append(arrayListO.size());
            xe3.a("test", sb.toString());
            MyApplication.l0();
            EventBus.getDefault().post(new uc1(toyQ.getAddress(), -10));
            EventBus.getDefault().post(new xc1(toyQ.getAddress(), -1));
            ToyActivity.this.notifyDataSetChanged();
            me3.g();
        }
    }

    public class f extends HashMap<String, String> {
        public f() {
            String str;
            if (ToyActivity.this.f == null) {
                str = "0";
            } else {
                str = "" + ToyActivity.this.f.getItemCount();
            }
            put("count", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M4(List list, boolean z) {
        if (z) {
            s5();
        }
    }

    public static /* synthetic */ void N4(Toy toy, ToyRecyclerViewAdapter.ToyHolder toyHolder, View view) {
        toy.setConnectTryNumb(4);
        toyHolder.w.setVisibility(8);
        toyHolder.g.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P4() {
        ToyRecyclerViewAdapter toyRecyclerViewAdapter = this.f;
        if (toyRecyclerViewAdapter != null) {
            boolean z = false;
            synchronized (toyRecyclerViewAdapter.g) {
                for (Map.Entry<String, ToyRecyclerViewAdapter.ToyHolder> entry : this.f.g.entrySet()) {
                    ToyRecyclerViewAdapter.ToyHolder value = entry.getValue();
                    String key = entry.getKey();
                    if (TextUtils.equals(key, value.a())) {
                        Toy toyQ = this.d.G().Q(key);
                        if (toyQ == null) {
                            z = true;
                        } else if (!E4(value, toyQ)) {
                            if (toyQ.isSelect()) {
                                C4(value, toyQ);
                            } else {
                                D4(value, toyQ);
                            }
                        }
                    }
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R4() {
        ToyRecyclerViewAdapter toyRecyclerViewAdapter = this.f;
        if (toyRecyclerViewAdapter != null) {
            toyRecyclerViewAdapter.Q(this.c);
            this.c = null;
            this.f.notifyDataSetChanged();
            if (this.f.getItemCount() <= 0) {
                this.e.setVisibility(8);
                this.g.setVisibility(0);
            } else {
                this.e.setVisibility(0);
                this.g.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T4(View view) {
        G4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V4(View view) {
        w5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X4(View view) {
        w5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z4(View view) {
        this.k.y(this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b5(View view) {
        w5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d5() {
        this.f.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f5(Toy toy, List list, boolean z) {
        if (z) {
            t5(toy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h5(String str) {
        this.i.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j5(final String str, View view) {
        sg3.l("Debug:清除玩具");
        DaoUtils.getToyTypeDao().clearTable();
        this.h.postDelayed(new Runnable() { // from class: dc.vg2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.h5(str);
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l5(Toy toy) {
        if (toy.isConnected()) {
            lp1.a.e(this, toy.getAddress());
        } else {
            sg3.h(R.string.toy_settings_no_toy_toast);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n5(Toy toy) {
        EventBus.getDefault().post(new xc1(toy.getAddress(), -1));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p5() {
        ze3.d();
        if (this.d.h0()) {
            B4();
        } else {
            sg3.i(this, R.string.ble_not_support);
        }
    }

    public void A4() {
        List<Toy> listFindAll = DaoUtils.getToyDao().findAll();
        ArrayList<Toy> arrayListO = this.d.G().o();
        if (listFindAll.size() > arrayListO.size()) {
            re3.l();
        }
        for (Toy toy : arrayListO) {
            ToyRename toyRenameFindToyRenameByAddress = DaoUtils.getToyRenameDao().findToyRenameByAddress(toy.getAddress());
            if (toyRenameFindToyRenameByAddress != null) {
                toy.setDefineRename(toyRenameFindToyRenameByAddress.getName());
            }
            toy.setRenameDeviceName();
            if (toy.isConnected()) {
                fq1.b(toy.getAddress());
            }
        }
        notifyDataSetChanged();
        this.k.p0(true);
    }

    public final void B4() {
        int i = Build.VERSION.SDK_INT;
        if (i > 22 && i <= 30) {
            q61 q61VarM = q61.m(this);
            q61VarM.h("android.permission.ACCESS_FINE_LOCATION");
            q61VarM.h("android.permission.ACCESS_COARSE_LOCATION");
            q61VarM.j(new c());
            return;
        }
        if (i < 31) {
            s5();
            return;
        }
        q61 q61VarM2 = q61.m(this);
        q61VarM2.h(v51.a.a);
        q61VarM2.j(new u51() { // from class: dc.ch2
            @Override // dc.u51
            public /* synthetic */ void a(List list, boolean z) {
                t51.a(this, list, z);
            }

            @Override // dc.u51
            public final void b(List list, boolean z) {
                this.a.M4(list, z);
            }
        });
    }

    public final void C4(ToyRecyclerViewAdapter.ToyHolder toyHolder, Toy toy) {
        toyHolder.A.setVisibility(8);
        toyHolder.b.setImageResource(toy.getToyIcon());
        if (this.k.a(toy.getAddress()) || toy.getConnectType() == 3) {
            return;
        }
        toyHolder.q.setVisibility(8);
        if (toy.getConnectTryNumb() > 10 && toy.getConnectType() == 0 && toy.isSelect()) {
            toyHolder.s.setVisibility(8);
            toyHolder.n.setVisibility(0);
            if (xb1.b(toy.getUuid(), toy.getAddress()) || !og3.a(9)) {
                toyHolder.u.setVisibility(8);
            } else {
                toyHolder.u.setVisibility(0);
            }
            toyHolder.w.setVisibility(8);
            toyHolder.l.setText(String.format(ah4.e(R.string.toy_reconnect_time), ((toy.getConnectTryNumb() + 1) - ((be3.I().getTime() - toy.getConnectScanTime()) / 1000)) + "s"));
            return;
        }
        toyHolder.s.setVisibility(0);
        toyHolder.k.setVisibility(8);
        toyHolder.n.setVisibility(8);
        toyHolder.v.setVisibility(8);
        if (xb1.b(toy.getUuid(), toy.getAddress()) || !og3.a(9)) {
            toyHolder.t.setVisibility(8);
        } else {
            toyHolder.t.setVisibility(0);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) toyHolder.f.getLayoutParams();
        layoutParams.setMarginStart(ce3.a(this, 0.0f));
        toyHolder.f.setLayoutParams(layoutParams);
        toyHolder.f.setVisibility(0);
        toyHolder.f.setText(ah4.e(R.string.toy_connecting));
    }

    public final void D4(ToyRecyclerViewAdapter.ToyHolder toyHolder, Toy toy) {
        toyHolder.w.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) toyHolder.f.getLayoutParams();
        layoutParams.setMarginStart(ce3.a(this, 0.0f));
        toyHolder.f.setLayoutParams(layoutParams);
        if (toy.getConnectApp() != 1 || TextUtils.equals("Lovense Remote", toy.getFormApp())) {
            toyHolder.b.setImageResource(toy.getToyIcon());
            toyHolder.A.setVisibility(8);
            toyHolder.f.setText(ah4.e(R.string.not_connect));
        } else {
            toyHolder.f.setText(String.format(ah4.e(R.string.toy_connected_to_other_apps), toy.getFormApp()));
            toyHolder.A.setVisibility(0);
            toyHolder.b.setImageResource(R.drawable.nav_unknown_1);
        }
        toyHolder.d.setVisibility(0);
        toyHolder.e.setVisibility(0);
        if (xb1.b(toy.getUuid(), toy.getAddress()) || !og3.a(9)) {
            toyHolder.t.setVisibility(8);
        } else {
            toyHolder.t.setVisibility(0);
        }
    }

    public final boolean E4(final ToyRecyclerViewAdapter.ToyHolder toyHolder, final Toy toy) {
        if (toy.getConnectTryNumb() <= 15) {
            return false;
        }
        toyHolder.s.setVisibility(0);
        toyHolder.n.setVisibility(8);
        toyHolder.k.setVisibility(8);
        toyHolder.w.setVisibility(0);
        toyHolder.w.setText(ah4.e(R.string.connect_now));
        toyHolder.w.setOnClickListener(new View.OnClickListener() { // from class: dc.lg2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToyActivity.N4(toy, toyHolder, view);
            }
        });
        toyHolder.f.setText(ah4.e(R.string.not_connect));
        toyHolder.g.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) toyHolder.f.getLayoutParams();
        layoutParams.setMarginStart(ce3.a(this, 8.0f));
        toyHolder.f.setLayoutParams(layoutParams);
        return true;
    }

    public final void F4(String str, String str2) {
        kn3 kn3Var = new kn3((Context) this, String.format(String.valueOf(ah4.e(R.string.common_dialog_delete)), str2), ah4.e(R.string.common_delete), ah4.e(R.string.common_cancel), true, (kn3.d) new e(str, str2));
        kn3Var.show();
        kn3Var.p();
    }

    public final void G4() {
        Toy next;
        ArrayList<Toy> arrayListP = this.k.P();
        if (arrayListP.size() > 0) {
            Iterator<Toy> it = arrayListP.iterator();
            while (it.hasNext()) {
                next = it.next();
                if ((next.isEI01Toy() && next.getVersion().intValue() < 3) || (next.isEAToy() && next.getVersion().intValue() < 4)) {
                    break;
                }
            }
            next = null;
        } else {
            next = null;
        }
        if (next == null) {
            finish();
        } else if (next.isEI01Toy()) {
            u5(next, R.string.notification_update_flexer_firmware);
        } else if (next.isEAToy()) {
            u5(next, R.string.notification_update__firmware4);
        }
    }

    public final void H4() {
        runOnMainThread(new Runnable() { // from class: dc.tg2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.P4();
            }
        });
    }

    public final void I4() {
        Timer timer = this.l;
        if (timer != null) {
            timer.cancel();
            this.l = null;
        }
        Timer timer2 = new Timer();
        this.l = timer2;
        timer2.schedule(new b(), 500L, 1000L);
    }

    public final boolean J4() {
        BluetoothAdapter adapter = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        return adapter != null && adapter.isEnabled();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return false;
        }
        G4();
        return false;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void notifyDataSetChanged() {
        runOnMainThread(new Runnable() { // from class: dc.ah2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.R4();
            }
        });
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == 1) {
            if (MyApplication.P) {
                hu3.T();
                return;
            } else {
                if (MyApplication.Q != 0) {
                    ep1.b().p();
                    return;
                }
                return;
            }
        }
        if (i == 1) {
            this.d.G().t0();
            return;
        }
        if (i == 888 && i2 == -1) {
            if (intent.getBooleanExtra("grant_all", false)) {
                s5();
            } else {
                new kn3((Context) this, ah4.e(R.string.app_open_bluetooth_permission), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new d()).show();
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NotifyDataSetChanged"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_toy);
        me3.c(me3.c.MY_TOYS_LIST_UI_ENTER);
        ye3.c("My toys", "into page", null);
        MyApplication myApplication = (MyApplication) getApplication();
        this.d = myApplication;
        this.k = myApplication.G();
        if (getIntent().getExtras() != null) {
            this.c = getIntent().getExtras().getString("multi_toys");
        }
        EventBus.getDefault().register(this);
        ((MyActionBar) findViewById(R.id.actionbar)).setBackAction(new MyActionBar.f() { // from class: dc.eh2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                this.a.T4(view);
            }
        });
        this.i = (Button) findViewById(R.id.clean_toy_type_db);
        this.j = (TextView) findViewById(R.id.blue_tooth_tip);
        ImageView imageView = (ImageView) findViewById(R.id.iv_roate);
        View viewFindViewById = findViewById(R.id.fl_root);
        this.a = (LinearLayout) findViewById(R.id.ll_add_toy);
        this.b = (LinearLayout) findViewById(R.id.empty_add_toy);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.dh2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.V4(view);
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: dc.ng2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.X4(view);
            }
        });
        if (this.k.y(this, false)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
        this.j.setOnClickListener(new View.OnClickListener() { // from class: dc.ug2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Z4(view);
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: dc.wg2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.b5(view);
            }
        });
        this.g = findViewById(R.id.toy_empty);
        this.e = (RecyclerView) findViewById(R.id.toy_list);
        RecyclerViewNoBugLinearLayoutManager recyclerViewNoBugLinearLayoutManager = new RecyclerViewNoBugLinearLayoutManager(this);
        recyclerViewNoBugLinearLayoutManager.setOrientation(1);
        this.e.setLayoutManager(recyclerViewNoBugLinearLayoutManager);
        ToyRecyclerViewAdapter toyRecyclerViewAdapter = new ToyRecyclerViewAdapter(this);
        this.f = toyRecyclerViewAdapter;
        toyRecyclerViewAdapter.R(new ToyRecyclerViewAdapter.b() { // from class: dc.yg2
            @Override // com.wear.adapter.toy.ToyRecyclerViewAdapter.b
            public final void a(String str, String str2) {
                this.a.F4(str, str2);
            }
        });
        this.f.setHasStableIds(true);
        this.e.setAdapter(this.f);
        viewFindViewById.post(new Runnable() { // from class: dc.sg2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d5();
            }
        });
        this.h = new Handler();
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.m, q5(), 2);
        } else {
            registerReceiver(this.m, q5());
        }
        I4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        unregisterReceiver(this.m);
        EventBus.getDefault().unregister(this);
        this.f.g.clear();
        Timer timer = this.l;
        if (timer != null) {
            try {
                timer.cancel();
                this.l = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        addAnalyticsEventId("toy_count", new f());
        me3.d(me3.c.MY_TOYS_LIST_UI_EXIT, me3.a());
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        Toy toyQ;
        if (xc1Var.b() == 1 && (toyQ = this.d.G().Q(xc1Var.a())) != null) {
            toyQ.setRenameDeviceName();
        }
        notifyDataSetChanged();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @SuppressLint({"NotifyDataSetChanged"})
    public void onResume() {
        super.onResume();
        v5();
        A4();
        this.i.setVisibility(8);
        if (WearUtils.v) {
            this.i.setVisibility(0);
            final String str = String.format("Clean ToyType Cache(%s)" + Build.CPU_ABI, Integer.valueOf(DaoUtils.getToyTypeDao().totalNumber()));
            this.i.setText(str);
            this.i.setOnClickListener(new View.OnClickListener() { // from class: dc.mg2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.j5(str, view);
                }
            });
        }
        this.f.Q(this.c);
        this.f.notifyDataSetChanged();
    }

    public final IntentFilter q5() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        return intentFilter;
    }

    public void r5(String str, boolean z) {
        final Toy toyQ = this.d.G().Q(str);
        if (toyQ == null) {
            return;
        }
        if (z) {
            String[] strArr = null;
            int i = Build.VERSION.SDK_INT;
            if (i > 22 && i <= 30) {
                strArr = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
            } else if (i >= 31) {
                strArr = v51.a.a;
            } else {
                toyQ.setIsSelect(1);
                EventBus.getDefault().post(new uc1(toyQ.getAddress(), 10));
                t5(toyQ);
            }
            if (strArr != null) {
                q61 q61VarM = q61.m(this);
                q61VarM.h(strArr);
                q61VarM.j(new u51() { // from class: dc.zg2
                    @Override // dc.u51
                    public /* synthetic */ void a(List list, boolean z2) {
                        t51.a(this, list, z2);
                    }

                    @Override // dc.u51
                    public final void b(List list, boolean z2) {
                        this.a.f5(toyQ, list, z2);
                    }
                });
            }
        } else {
            toyQ.setIsSelect(0);
            toyQ.setStatus(-1);
            WearUtils.x.G().E(toyQ);
            this.d.G().v0(toyQ.getAddress());
            toyQ.setDisConnectType(1);
            toyQ.setRealDeviceType(false);
            toyQ.setIsLongRange(0);
            if (toyQ.isConnected()) {
                rp1.a(toyQ);
            }
            this.d.G().disconnect(toyQ.getAddress());
            db2.A().P();
            h32.i().z();
            ve3.d().g();
            EventBus.getDefault().post(new uc1(toyQ.getAddress(), -10));
            me3.g();
            toyQ.setConnectApp(-1);
        }
        toyQ.setLogFormApp(toyQ.getFormApp());
        toyQ.setFormApp("Lovense Remote");
        this.d.G().w0(this, toyQ);
        wi2.e().f("ToyActivity.onItemClickAction()-->toyAddress:" + str + ", isSelect:" + z);
        notifyDataSetChanged();
        EventBus.getDefault().post(new ToyDSLocalEvent());
    }

    public final void s5() {
    }

    public final void t5(Toy toy) {
        if (!xb1.b(toy.getUuid(), toy.getAddress()) && DaoUtils.getToyPinStatusDao().findToyPinStatus(toy.getAddress()) == null && og3.a(9)) {
            Intent intent = new Intent(this, (Class<?>) ToyPinTipActivity.class);
            intent.putExtra("toyId", toy.getAddress());
            startActivity(intent);
        } else if (xb1.b(toy.getUuid(), toy.getAddress()) && ud3.a(toy.getAddress()) && !ud3.c(null, toy.getAddress()) && og3.a(9)) {
            Intent intent2 = new Intent(this, (Class<?>) ToyPinRemoveFailTipActivity.class);
            intent2.putExtra("toyId", toy.getAddress());
            intent2.putExtra("type", 1);
            startActivity(intent2);
        } else {
            toy.setIsSelect(1);
        }
        toy.setConnectApp(0);
        if (TextUtils.equals("Lovense Remote", toy.getFormApp())) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("toy_mac", (Object) toy.getAddress().replace(SignatureImpl.INNER_SEP, ""));
        jSONObject.put("connected_app", (Object) toy.getFormApp());
        rp1.u(jSONObject.toJSONString());
    }

    public void u5(final Toy toy, int i) {
        cs3.e(this, ah4.e(R.string.button_notice), ah4.e(i), ah4.e(R.string.common_update), ah4.e(R.string.button_not_now), new is3.d() { // from class: dc.bh2
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.l5(toy);
            }
        }, new is3.c() { // from class: dc.xg2
            @Override // dc.is3.c
            public final void doCancel() {
                this.a.n5(toy);
            }
        }).show();
    }

    public final void v5() {
        if (WearUtils.g1(DaoUtils.getToyDao().findAll())) {
            return;
        }
        notifyDataSetChanged();
        this.k.p0(true);
    }

    public void w5() {
        if (J4()) {
            if (this.d.h0()) {
                B4();
                return;
            } else {
                sg3.i(this, R.string.ble_not_support);
                return;
            }
        }
        is3.b bVar = new is3.b(this);
        bVar.p(ah4.e(R.string.system_bluetooth_off));
        bVar.b(false);
        bVar.o(ah4.e(R.string.common_ok));
        bVar.d(new is3.d() { // from class: dc.qg2
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.p5();
            }
        });
        cs3.h(bVar).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(vc1 vc1Var) {
        notifyDataSetChanged();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(i30 i30Var) {
        notifyDataSetChanged();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ToySelectEvent toySelectEvent) {
        r5(toySelectEvent.getAddress(), toySelectEvent.isSelect());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ToyAddClickEvent toyAddClickEvent) {
        w5();
    }
}
