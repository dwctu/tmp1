package com.wear.main.toy;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Pattern;
import com.wear.bean.ProgramPattern;
import com.wear.bean.Toy;
import com.wear.dao.DaoUtils;
import com.wear.dao.ProgramPatternDao;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.patterns.MulChoosePatternsActivity;
import com.wear.ui.discover.speedMode.SpeedModeControl;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.ui.home.sound.SoundPlayControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import com.wear.widget.control.LevelControlView;
import com.yydcdut.sdlv.SlideAndDragListView;
import dc.ah4;
import dc.bo3;
import dc.h12;
import dc.kd0;
import dc.kn3;
import dc.ll3;
import dc.pc1;
import dc.qr1;
import dc.rq1;
import dc.sg3;
import dc.vc1;
import dc.vg3;
import dc.wc1;
import dc.xe2;
import dc.yo1;
import dc.yu3;
import de.hdodenhof.circleimageview.CircleImageView;
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
public class ToyProgramActivity extends BaseActivity {
    public static final String P = ToyProgramActivity.class.getSimpleName();
    public List<ProgramPattern> K;
    public boolean L;
    public Handler M;
    public int N;
    public Map<String, ProgramPattern> O;
    public MyApplication a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public String b;
    public MyActionBar c;

    @BindView(R.id.create_tv_text_hint)
    public TextView createTvTextHint;
    public ProgramPattern d;
    public e0 f;
    public Timer g;
    public TimerTask h;

    @BindView(R.id.loading_layer)
    public LinearLayout loadingLayer;

    @BindView(R.id.loading_set_level)
    public LinearLayout loadingSetLevel;
    public LevelControlView m;
    public String n;

    @BindView(R.id.pattern_list)
    public SlideAndDragListView patternList;

    @BindView(R.id.pattern_list_empty)
    public LinearLayout patternListEmpty;

    @BindView(R.id.pattern_list_empty_to_add)
    public LinearLayout patternListEmptyToAdd;

    @BindView(R.id.pattern_list_to_add)
    public LinearLayout patternListToAdd;
    public ProgressDialog q;

    @BindView(R.id.setting_change_levels)
    public RelativeLayout settingChangeLevels;

    @BindView(R.id.setting_change_lights_layout)
    public LinearLayout settingChangeLightsLayout;

    @BindView(R.id.setting_lights_swith)
    public SwitchView settingLightsSwith;
    public kn3 t;

    @BindView(R.id.toy_battery_img)
    public ImageView toyBatteryImg;

    @BindView(R.id.toy_img)
    public CircleImageView toyImg;

    @BindView(R.id.toy_name)
    public TextView toyName;

    @BindView(R.id.toy_status)
    public TextView toyStatus;
    public yo1 u;
    public Toy w;
    public List<ProgramPattern> e = new ArrayList();
    public boolean i = true;
    public String[] j = null;
    public int k = 0;
    public int l = 0;
    public String o = "";
    public bo3 p = null;
    public Handler s = new Handler(new k());
    public int v = 0;
    public pc1 x = null;
    public boolean y = false;
    public kn3 z = null;
    public Map<String, ProgramPattern> A = new HashMap();
    public int B = 0;
    public Runnable C = new j();
    public Map<String, String> D = new HashMap();
    public int E = 0;
    public int F = 0;
    public boolean G = false;

    public class a implements kn3.d {
        public a() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            ToyProgramActivity.this.finish();
        }
    }

    public class a0 implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ToyProgramActivity toyProgramActivity = ToyProgramActivity.this;
                toyProgramActivity.parentHandler.postDelayed(toyProgramActivity.C, 5000L);
                ToyProgramActivity toyProgramActivity2 = ToyProgramActivity.this;
                toyProgramActivity2.x.l(toyProgramActivity2.w.getAddress(), "GetPatten;");
            }
        }

        public a0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            qr1.b(ToyProgramActivity.this.w.getAddress());
            ToyProgramActivity.this.s.postDelayed(new a(), 200L);
        }
    }

    public class b extends TimerTask {

        public class a implements Runnable {

            /* renamed from: com.wear.main.toy.ToyProgramActivity$b$a$a, reason: collision with other inner class name */
            public class RunnableC0135a implements Runnable {
                public RunnableC0135a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ToyProgramActivity.this.c5();
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ToyProgramActivity.this.runOnUiThread(new RunnableC0135a());
            }
        }

        public b() {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(7:4|(4:6|(1:8)|9|(2:24|18)(1:12))(1:13)|20|14|25|18|2) */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0072, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
        
            r0.printStackTrace();
         */
        @Override // java.util.TimerTask, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.InterruptedException, java.lang.NumberFormatException {
            /*
                r6 = this;
            L0:
                com.wear.main.toy.ToyProgramActivity r0 = com.wear.main.toy.ToyProgramActivity.this
                int r0 = com.wear.main.toy.ToyProgramActivity.Q4(r0)
                com.wear.main.toy.ToyProgramActivity r1 = com.wear.main.toy.ToyProgramActivity.this
                java.lang.String[] r1 = com.wear.main.toy.ToyProgramActivity.T4(r1)
                int r1 = r1.length
                if (r0 >= r1) goto L7c
                com.wear.main.toy.ToyProgramActivity r0 = com.wear.main.toy.ToyProgramActivity.this
                boolean r1 = r0.i
                if (r1 != 0) goto L64
                int r0 = com.wear.main.toy.ToyProgramActivity.Q4(r0)
                com.wear.main.toy.ToyProgramActivity r1 = com.wear.main.toy.ToyProgramActivity.this
                java.lang.String[] r1 = com.wear.main.toy.ToyProgramActivity.T4(r1)
                int r1 = r1.length
                r2 = 1
                int r1 = r1 - r2
                if (r0 < r1) goto L39
                com.wear.main.toy.ToyProgramActivity r0 = com.wear.main.toy.ToyProgramActivity.this
                com.wear.main.toy.ToyProgramActivity.R4(r0)
                com.wear.main.toy.ToyProgramActivity r0 = com.wear.main.toy.ToyProgramActivity.this
                r0.i = r2
                android.os.Handler r0 = r0.s
                com.wear.main.toy.ToyProgramActivity$b$a r1 = new com.wear.main.toy.ToyProgramActivity$b$a
                r1.<init>()
                r3 = 500(0x1f4, double:2.47E-321)
                r0.postDelayed(r1, r3)
            L39:
                com.wear.main.toy.ToyProgramActivity r0 = com.wear.main.toy.ToyProgramActivity.this
                java.lang.String[] r0 = com.wear.main.toy.ToyProgramActivity.T4(r0)
                com.wear.main.toy.ToyProgramActivity r1 = com.wear.main.toy.ToyProgramActivity.this
                int r1 = com.wear.main.toy.ToyProgramActivity.Q4(r1)
                r0 = r0[r1]
                boolean r1 = com.wear.util.WearUtils.e1(r0)
                if (r1 == 0) goto L4e
                goto L76
            L4e:
                int r0 = java.lang.Integer.parseInt(r0)
                dc.rq1 r1 = dc.rq1.d
                com.wear.main.toy.ToyProgramActivity r3 = com.wear.main.toy.ToyProgramActivity.this
                java.lang.String r3 = com.wear.main.toy.ToyProgramActivity.s4(r3)
                dc.tq1 r4 = new dc.tq1
                r5 = 0
                r4.<init>(r2, r5, r5)
                r1.a(r3, r0, r4)
                goto L67
            L64:
                com.wear.main.toy.ToyProgramActivity.R4(r0)
            L67:
                com.wear.main.toy.ToyProgramActivity r0 = com.wear.main.toy.ToyProgramActivity.this     // Catch: java.lang.InterruptedException -> L72
                int r0 = com.wear.main.toy.ToyProgramActivity.u4(r0)     // Catch: java.lang.InterruptedException -> L72
                long r0 = (long) r0     // Catch: java.lang.InterruptedException -> L72
                java.lang.Thread.sleep(r0)     // Catch: java.lang.InterruptedException -> L72
                goto L76
            L72:
                r0 = move-exception
                r0.printStackTrace()
            L76:
                com.wear.main.toy.ToyProgramActivity r0 = com.wear.main.toy.ToyProgramActivity.this
                com.wear.main.toy.ToyProgramActivity.S4(r0)
                goto L0
            L7c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.main.toy.ToyProgramActivity.b.run():void");
        }
    }

    public class b0 implements View.OnClickListener {
        public b0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            qr1.b(ToyProgramActivity.this.w.getAddress());
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyProgramActivity toyProgramActivity = ToyProgramActivity.this;
            toyProgramActivity.b5(toyProgramActivity.p);
        }
    }

    public class c0 implements SlideAndDragListView.a {
        public ProgramPattern a = null;

        public c0() {
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void a(int i, int i2) {
            ToyProgramActivity.this.e.add(i2, ToyProgramActivity.this.e.remove(i));
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void b(int i) {
            System.out.println("onDragViewDown.position=" + i);
            ToyProgramActivity.this.e.set(i, this.a);
            ToyProgramActivity.this.loadingLayer.setVisibility(0);
            ToyProgramActivity.this.F = 0;
            ToyProgramActivity.this.a5();
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void c(int i) {
            this.a = ToyProgramActivity.this.e.get(i);
        }
    }

    public class d implements bo3.d {
        public d() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            ToyProgramActivity.this.p.dismiss();
            rq1.d.r(ToyProgramActivity.this.b);
            ToyProgramActivity toyProgramActivity = ToyProgramActivity.this;
            toyProgramActivity.j5(toyProgramActivity.m.getLevelCommandStrings());
        }
    }

    public class d0 implements Runnable {
        public final /* synthetic */ vc1 a;

        public d0(vc1 vc1Var) {
            this.a = vc1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            vc1 vc1Var = this.a;
            if (vc1Var == null || !vc1Var.a().equals(ToyProgramActivity.this.b)) {
                return;
            }
            ToyProgramActivity.this.w.updateToyBattery(ToyProgramActivity.this.toyBatteryImg);
        }
    }

    public class e implements bo3.d {
        public e() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            MusicControl.h0();
            h12.D.playPatternPause = false;
            ToyProgramActivity toyProgramActivity = ToyProgramActivity.this;
            toyProgramActivity.b5(toyProgramActivity.p);
        }
    }

    public class e0 extends BroadcastReceiver {
        public e0() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("ACTION_TOY_UPDATE")) {
                ToyProgramActivity.this.notifyDataSetChanged();
            }
        }
    }

    public class f implements kn3.d {
        public f() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() throws InterruptedException {
            ToyProgramActivity toyProgramActivity = ToyProgramActivity.this;
            toyProgramActivity.i5(toyProgramActivity.m.getLevelCommandStrings());
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ String a;

        public g(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            for (String str : this.a.split("#")) {
                if (!WearUtils.e1(str)) {
                    ToyProgramActivity.this.h5(str);
                    try {
                        Thread.sleep(ToyProgramActivity.this.y ? 500L : 1000L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            Message message = new Message();
            message.what = 85;
            ToyProgramActivity.this.s.sendMessage(message);
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyProgramActivity.this.u.notifyDataSetChanged();
            ToyProgramActivity.this.o5();
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyProgramActivity.this.notifyDataSetChanged();
            ToyProgramActivity.this.n5();
            ToyProgramActivity.this.A.clear();
            ToyProgramActivity.this.l5();
            ToyProgramActivity.this.F = 0;
            ToyProgramActivity.this.a5();
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyProgramActivity.this.Y4();
        }
    }

    public class k implements Handler.Callback {
        public k() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 85) {
                MusicControl.h0();
                h12.D.playPatternPause = false;
                ToyProgramActivity.this.loadingSetLevel.setVisibility(8);
            }
            return false;
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyProgramActivity.this.a5();
        }
    }

    public class m implements Runnable {

        public class a implements Runnable {
            public final /* synthetic */ ProgramPattern a;

            public a(ProgramPattern programPattern) {
                this.a = programPattern;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.setIndex(String.valueOf(ToyProgramActivity.this.F));
                System.out.println("uploadItem.index = " + ToyProgramActivity.this.F);
                ToyProgramActivity.this.m5(this.a);
            }
        }

        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ToyProgramActivity.this.e.size() <= 0 || ToyProgramActivity.this.F >= ToyProgramActivity.this.e.size()) {
                ToyProgramActivity.this.F = 999;
                ToyProgramActivity.this.G = false;
                ToyProgramActivity.this.Y4();
                return;
            }
            ToyProgramActivity toyProgramActivity = ToyProgramActivity.this;
            ProgramPattern programPattern = toyProgramActivity.e.get(toyProgramActivity.F);
            if (ToyProgramActivity.this.F >= Integer.valueOf(programPattern.getIndex()).intValue() && ToyProgramActivity.this.F <= Integer.valueOf(programPattern.getIndex()).intValue()) {
                if (ToyProgramActivity.this.F < ToyProgramActivity.this.e.size()) {
                    ToyProgramActivity.O4(ToyProgramActivity.this);
                    ToyProgramActivity.this.a5();
                    return;
                }
                return;
            }
            if (ToyProgramActivity.this.F < Integer.valueOf(programPattern.getIndex()).intValue()) {
                ToyProgramActivity toyProgramActivity2 = ToyProgramActivity.this;
                toyProgramActivity2.x.l(toyProgramActivity2.w.getAddress(), "Remove:" + programPattern.getIndex() + ",d" + programPattern.getIndex() + ";");
            }
            ToyProgramActivity.this.s.postDelayed(new a(programPattern), 350L);
        }
    }

    public class n implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ToyProgramActivity.this.loadingLayer.setVisibility(8);
                if (ToyProgramActivity.this.q != null) {
                    ToyProgramActivity.this.q.dismiss();
                }
                ToyProgramActivity.this.l5();
            }
        }

        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyProgramActivity.this.runOnUiThread(new a());
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyProgramActivity.this.n5();
            ToyProgramActivity.this.notifyDataSetChanged();
        }
    }

    public class p extends HashMap<String, String> {
        public p() {
            put("type", ToyProgramActivity.this.w == null ? "" : ToyProgramActivity.this.w.getDeviceType());
        }
    }

    public class q extends ArrayList<String> {
        public q() {
            add("0355395703530");
            add("0507090");
            add("0948570");
        }
    }

    public class r extends ArrayList<String> {
        public r() {
            add("90");
            add("346797643");
            add("3456990");
            add("34596990");
        }
    }

    public class s extends ArrayList<String> {
        public s() {
            add("90");
            add("346797643");
            add("3456990");
            add("34596990");
        }
    }

    public class t implements ProgramPattern.UploadToyListener {
        public final /* synthetic */ ProgramPattern a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ToyProgramActivity toyProgramActivity = ToyProgramActivity.this;
                if (toyProgramActivity.L) {
                    return;
                }
                if (toyProgramActivity.q != null) {
                    ToyProgramActivity.this.q.dismiss();
                }
                ToyProgramActivity.this.y = false;
                sg3.h(R.string.toy_program_failed_notice);
            }
        }

        public t(ProgramPattern programPattern) {
            this.a = programPattern;
        }

        @Override // com.wear.bean.ProgramPattern.UploadToyListener
        public void finish(String str) {
            ProgramPattern programPattern = (ProgramPattern) ToyProgramActivity.this.O.get(ProgramPattern.writePatternChar);
            ToyProgramActivity.this.q5("OK" + str + programPattern.getUploadToToyTotalComman() + ";");
        }

        @Override // com.wear.bean.ProgramPattern.UploadToyListener
        public void params(String str, int i) {
            this.a.setUploadToToyTotalComman(i);
            ToyProgramActivity.this.O.put(str, this.a);
            ToyProgramActivity toyProgramActivity = ToyProgramActivity.this;
            if (toyProgramActivity.y) {
                toyProgramActivity.L = false;
                long j = (i * 160) + DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
                toyProgramActivity.M.removeCallbacksAndMessages(null);
                ToyProgramActivity.this.M.postDelayed(new a(), j);
            }
        }
    }

    public class u implements Runnable {
        public u() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyProgramActivity.this.l5();
        }
    }

    public class v implements MyActionBar.f {
        public v() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ToyProgramActivity toyProgramActivity = ToyProgramActivity.this;
            toyProgramActivity.i = true;
            rq1.d.r(toyProgramActivity.b);
            ToyProgramActivity.this.finish();
        }
    }

    public class w implements MyActionBar.f {

        public class a implements kn3.d {

            /* renamed from: com.wear.main.toy.ToyProgramActivity$w$a$a, reason: collision with other inner class name */
            public class RunnableC0136a implements Runnable {
                public RunnableC0136a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ToyProgramActivity.this.g5();
                }
            }

            public a() {
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                ToyProgramActivity toyProgramActivity = ToyProgramActivity.this;
                if (!toyProgramActivity.i) {
                    toyProgramActivity.c5();
                }
                ToyProgramActivity toyProgramActivity2 = ToyProgramActivity.this;
                toyProgramActivity2.x.v0(toyProgramActivity2.b);
                new Handler().postDelayed(new RunnableC0136a(), 500L);
            }
        }

        public w() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            if ((ToyProgramActivity.this.q != null && ToyProgramActivity.this.q.isShowing()) || ToyProgramActivity.this.loadingLayer.getVisibility() == 0 || ToyProgramActivity.this.w == null) {
                return;
            }
            if (ToyProgramActivity.this.w == null || ToyProgramActivity.this.w.isConnected()) {
                kn3 kn3Var = ToyProgramActivity.this.z;
                if (kn3Var != null) {
                    kn3Var.dismiss();
                    ToyProgramActivity.this.z = null;
                }
                String strE = ah4.e(R.string.toy_program_notice);
                ToyProgramActivity.this.z = new kn3((Context) ToyProgramActivity.this, strE, ah4.e(R.string.toy_program_restore), ah4.e(R.string.common_cancel), false, (kn3.d) new a(), true);
                ToyProgramActivity.this.z.show();
                ToyProgramActivity.this.z.p();
            }
        }
    }

    public class x implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ToyProgramActivity.this.q != null) {
                    ToyProgramActivity.this.q.dismiss();
                }
                sg3.h(R.string.toy_program_success_notice);
            }
        }

        public x() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            ToyProgramActivity toyProgramActivity = ToyProgramActivity.this;
            if (!toyProgramActivity.y) {
                if (toyProgramActivity.q != null) {
                    ToyProgramActivity.this.q.dismiss();
                }
            } else {
                toyProgramActivity.y = false;
                toyProgramActivity.loadingLayer.setVisibility(8);
                ToyProgramActivity.this.r5();
                WearUtils.x.l.postDelayed(new a(), 1000L);
            }
        }
    }

    public class y implements AdapterView.OnItemLongClickListener {
        public y(ToyProgramActivity toyProgramActivity) {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            return false;
        }
    }

    public class z implements AdapterView.OnItemClickListener {
        public z() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ToyProgramActivity toyProgramActivity = ToyProgramActivity.this;
            if (!toyProgramActivity.i) {
                rq1.d.r(toyProgramActivity.b);
            }
            ToyProgramActivity toyProgramActivity2 = ToyProgramActivity.this;
            ProgramPattern programPattern = toyProgramActivity2.d;
            if (programPattern != null && programPattern == toyProgramActivity2.e.get(i)) {
                ToyProgramActivity toyProgramActivity3 = ToyProgramActivity.this;
                if (!toyProgramActivity3.i) {
                    rq1.d.r(toyProgramActivity3.b);
                    ToyProgramActivity.this.c5();
                    return;
                }
            }
            ToyProgramActivity toyProgramActivity4 = ToyProgramActivity.this;
            toyProgramActivity4.d = toyProgramActivity4.e.get(i);
            ProgramPattern programPattern2 = ToyProgramActivity.this.d;
            if (programPattern2 != null && WearUtils.e1(programPattern2.getData())) {
                sg3.i(ToyProgramActivity.this, R.string.file_notfound);
                ToyProgramActivity.this.f5();
                return;
            }
            ToyProgramActivity toyProgramActivity5 = ToyProgramActivity.this;
            if (!toyProgramActivity5.i) {
                rq1.d.r(toyProgramActivity5.b);
            }
            ToyProgramActivity toyProgramActivity6 = ToyProgramActivity.this;
            toyProgramActivity6.d5(toyProgramActivity6.d);
            ToyProgramActivity.this.notifyDataSetChanged();
        }
    }

    public ToyProgramActivity() {
        new q();
        new r();
        new s();
        this.K = new ArrayList();
        this.L = false;
        this.M = new Handler(Looper.getMainLooper());
        this.N = 0;
        this.O = new HashMap();
    }

    public static /* synthetic */ int O4(ToyProgramActivity toyProgramActivity) {
        int i2 = toyProgramActivity.F;
        toyProgramActivity.F = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int R4(ToyProgramActivity toyProgramActivity) {
        int i2 = toyProgramActivity.k - 1;
        toyProgramActivity.k = i2;
        return i2;
    }

    public static /* synthetic */ int S4(ToyProgramActivity toyProgramActivity) {
        int i2 = toyProgramActivity.k;
        toyProgramActivity.k = i2 + 1;
        return i2;
    }

    public void U4(String str) {
        if (this.d != null) {
            if (str.toLowerCase().indexOf(",d" + this.d.getIndex()) == -1 || this.A.get(this.d.getIndex()) == null || this.G) {
                return;
            }
            DaoUtils.getProgramPatternDao().delById(this.d.getId());
            this.e.remove(this.d);
            if (!this.y) {
                e5();
                return;
            }
            this.A.clear();
            if (this.e.size() > 0) {
                List<ProgramPattern> list = this.e;
                this.d = list.get(list.size() - 1);
                f5();
            } else {
                this.y = false;
                this.F = 0;
                p5();
            }
        }
    }

    public void V4(String str) {
        if (str.toLowerCase().split(",").length == 3) {
            this.n = str;
        }
    }

    public void W4(String str) {
        if (str.toLowerCase().contains("p:")) {
            String strReplace = str.toLowerCase().replace("p:", "").toLowerCase().replace(";", "");
            this.o = strReplace;
            this.B = 0;
            if (strReplace.length() == 0) {
                Y4();
            }
            this.x.l(this.w.getAddress(), "GetPatten:" + String.valueOf(this.o.charAt(this.B)) + ";");
            this.parentHandler.removeCallbacks(this.C);
            this.parentHandler.postDelayed(this.C, 5000L);
        }
    }

    public void X4(String str) {
        if (str.toLowerCase().startsWith("p") && str.contains("/") && str.split(SignatureImpl.INNER_SEP).length == 3) {
            str.contains("P5:11/11");
            String[] strArrSplit = str.toLowerCase().split(SignatureImpl.INNER_SEP);
            this.D.put(strArrSplit[0] + SignatureImpl.INNER_SEP + strArrSplit[1], strArrSplit[2].replace(";", ""));
            String[] strArrSplit2 = strArrSplit[1].split("/");
            boolean z2 = this.w.getType().toLowerCase().equals("domi".toLowerCase()) && this.w.getVersion().intValue() <= 37 && Integer.valueOf(strArrSplit2[1]).intValue() - Integer.valueOf(strArrSplit2[0]).intValue() == 1 && Integer.valueOf(strArrSplit2[1]).intValue() == 9;
            if (Integer.valueOf(strArrSplit2[0]).intValue() == 1) {
                int iIntValue = Integer.valueOf(strArrSplit2[1]).intValue() * 1000;
                this.parentHandler.removeCallbacks(this.C);
                String str2 = "" + iIntValue;
                this.parentHandler.postDelayed(this.C, iIntValue);
            }
            if (strArrSplit2[0].equals(strArrSplit2[1]) || z2) {
                this.parentHandler.removeCallbacks(this.C);
                ProgramPattern programPattern = new ProgramPattern();
                programPattern.setName("P" + (Integer.valueOf(String.valueOf(strArrSplit[0].charAt(1))).intValue() + 1));
                programPattern.setIndex(String.valueOf(String.valueOf(strArrSplit[0].charAt(1))));
                MyApplication myApplication = WearUtils.x;
                if (MyApplication.Z) {
                    programPattern.setEmail(WearUtils.a);
                    programPattern.setAuthor(ah4.e(R.string.common_anonymous));
                } else {
                    programPattern.setEmail(WearUtils.y.r());
                    programPattern.setAuthor(WearUtils.y.u().getUserName());
                }
                programPattern.setBtAddress(this.w.getAddress());
                int iIntValue2 = Integer.valueOf(strArrSplit2[1]).intValue();
                String[] strArr = new String[iIntValue2];
                for (Map.Entry<String, String> entry : this.D.entrySet()) {
                    if (entry.getKey().indexOf(strArrSplit[0]) != -1) {
                        strArr[Integer.valueOf(entry.getKey().split(SignatureImpl.INNER_SEP)[1].split("/")[0]).intValue() - 1] = entry.getValue();
                    }
                }
                for (int i2 = 0; i2 < iIntValue2; i2++) {
                    String str3 = strArr[i2];
                    if (!WearUtils.e1(str3)) {
                        programPattern.addData(str3);
                    }
                }
                System.out.println("all-data:" + programPattern.getData() + "  size:" + programPattern.getData().length());
                programPattern.calculateTime(this.l);
                ProgramPattern programPatternFindPatterns = DaoUtils.getProgramPatternDao().findPatterns(WearUtils.y.r(), this.w.getAddress(), programPattern.getData());
                if (programPatternFindPatterns != null) {
                    programPattern.setName(programPatternFindPatterns.getName());
                    programPattern.setAuthor(programPatternFindPatterns.getAuthor());
                }
                if (this.e.size() > 0) {
                    for (ProgramPattern programPattern2 : this.e) {
                        if (programPattern.getName().equals(programPattern2.getName()) && programPattern.getTimer().equals(programPattern2.getTimer())) {
                            break;
                        }
                    }
                }
                this.e.add(programPattern);
                l5();
                int i3 = this.E + 1;
                this.E = i3;
                if (i3 == this.o.length()) {
                    ProgressDialog progressDialog = this.q;
                    if (progressDialog != null) {
                        progressDialog.dismiss();
                    }
                    this.F = 0;
                    this.s.postDelayed(new l(), 300L);
                    return;
                }
                this.B++;
                this.x.l(this.w.getAddress(), "GetPatten:" + String.valueOf(this.o.charAt(this.B)) + ";");
                this.parentHandler.postDelayed(this.C, 5000L);
            }
        }
    }

    public final void Y4() {
        this.s.postDelayed(new n(), 200L);
    }

    public final void Z4() {
        this.patternList.setOnDragDropListener(new c0());
    }

    public final void a5() {
        this.G = true;
        this.s.post(new m());
    }

    public final void b5(Dialog dialog) {
        rq1.d.r(this.b);
        dialog.dismiss();
        if (this.m.j()) {
            new kn3((Context) this, ah4.e(R.string.programs_change_save), ah4.e(R.string.common_yes), ah4.e(R.string.common_no), false, (kn3.d) new f()).show();
        }
    }

    public void c5() {
        this.d = null;
        this.i = true;
        h12.D.playPatternPause = false;
        rq1.d.r(this.b);
        notifyDataSetChanged();
    }

    public final void d5(ProgramPattern programPattern) {
        if (programPattern == null || WearUtils.e1(programPattern.getData())) {
            return;
        }
        MusicControl.h0();
        h12.D.playPatternPause = true;
        if (MusicControl.h0().O()) {
            EventBus eventBus = EventBus.getDefault();
            MusicControl.h0();
            eventBus.post(h12.D);
        }
        if (!PatternPlayManagerImpl.O().d0()) {
            PatternPlayManagerImpl.O().D0();
        }
        if (SpeedModeControl.C().K()) {
            SpeedModeControl.C().N();
        }
        if (SoundPlayControl.M().a && !SoundPlayControl.M().b) {
            SoundPlayControl.M().U();
        }
        if (ll3.E().I()) {
            ll3.E().V();
        }
        this.i = false;
        this.k = 0;
        this.j = programPattern.splitData();
        if (this.h == null) {
            this.h = new b();
        }
        if (this.g == null) {
            Timer timer = new Timer();
            this.g = timer;
            timer.schedule(this.h, this.l);
        }
    }

    public final void e5() {
        runOnUiThread(new i());
    }

    public void f5() {
        ProgramPattern programPattern = this.d;
        if (programPattern != null) {
            this.A.put(programPattern.getIndex(), this.d);
            this.q.show();
            String str = "Remove:" + this.d.getIndex() + ",d" + this.d.getIndex() + ";";
            this.x.l(this.w.getAddress(), "Remove:" + this.d.getIndex() + ",d" + this.d.getIndex() + ";");
        }
    }

    public final void g5() {
        this.y = true;
        ProgressDialog progressDialog = this.q;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        this.q = ProgressDialog.show(this, "", ah4.e(R.string.common_inprocessing), true, false);
        List<ProgramPattern> list = this.e;
        if (list == null || list.size() <= 0) {
            p5();
            return;
        }
        List<ProgramPattern> list2 = this.e;
        this.d = list2.get(list2.size() - 1);
        f5();
    }

    public final void h5(String str) {
        String[] strArrSplit = str.replace(";", "").split(SignatureImpl.INNER_SEP);
        if (strArrSplit.length == 3 && TextUtils.equals("SetLevel", strArrSplit[0])) {
            qr1.d(this.w.getAddress(), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
        }
    }

    public final void i5(String str) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append(this.m.r[0]);
        sb.append(",");
        sb.append(this.m.r[1]);
        sb.append(",");
        sb.append(this.m.r[2]);
        sb.append(";");
        this.n = sb.toString();
        Toy toy = this.w;
        if (toy != null) {
            Toy toyQ = this.x.Q(toy.getAddress());
            if (toyQ.getStatus() == 0) {
                this.toyBatteryImg.setVisibility(8);
                this.toyImg.setImageResource(Toy.getToyIconLinkedId(this.w.getType(), 0, false));
                return;
            }
            if (toyQ.getStatus() == 1) {
                if (this.w.isF01Toy()) {
                    this.toyBatteryImg.setVisibility(8);
                } else {
                    this.toyBatteryImg.setVisibility(0);
                }
                this.toyImg.setImageResource(Toy.getToyIconLinkedId(this.w.getType(), 0, true));
                for (String str2 : str.split("#")) {
                    if (!WearUtils.e1(str2)) {
                        h5(str2);
                        try {
                            Thread.sleep(this.y ? 500L : 1000L);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public final void j5(String str) {
        this.n = this.m.r[0] + "," + this.m.r[1] + "," + this.m.r[2] + ";";
        Toy toy = this.w;
        if (toy != null) {
            Toy toyQ = this.x.Q(toy.getAddress());
            if (toyQ.getStatus() == 0) {
                this.toyBatteryImg.setVisibility(8);
                this.toyImg.setImageResource(Toy.getToyIconLinkedId(this.w.getType(), 0, false));
            } else if (toyQ.getStatus() == 1) {
                if (this.w.isF01Toy()) {
                    this.toyBatteryImg.setVisibility(8);
                } else {
                    this.toyBatteryImg.setVisibility(0);
                }
                this.toyImg.setImageResource(Toy.getToyIconLinkedId(this.w.getType(), 0, true));
                this.loadingSetLevel.setVisibility(0);
                vg3.b().a(new g(str));
            }
        }
    }

    public final void k5() {
        Intent intent = new Intent(this, (Class<?>) MulChoosePatternsActivity.class);
        intent.putExtra("choose_patterns_number", 10 - this.e.size());
        intent.putExtra("is_program_pattern", 1);
        kd0.b("extras_toy", this.w);
        startActivityForResult(intent, 22);
        addAnalyticsEventId("toy_program_choose_pattern", new p());
    }

    public synchronized void l5() {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            int i3 = 0;
            while (i3 < (this.e.size() - i2) - 1) {
                int i4 = i3 + 1;
                if (Integer.valueOf(this.e.get(i3).getIndex()).intValue() > Integer.valueOf(this.e.get(i4).getIndex()).intValue()) {
                    ProgramPattern programPattern = this.e.get(i3);
                    List<ProgramPattern> list = this.e;
                    list.set(i3, list.get(i4));
                    this.e.set(i4, programPattern);
                }
                i3 = i4;
            }
        }
        this.s.postDelayed(new o(), 300L);
    }

    public synchronized void m5(ProgramPattern programPattern) {
        programPattern.writeToToy(this.y, this.a, this.x, this.w, new t(programPattern));
    }

    public final void n5() {
        this.v = this.e.size();
        this.createTvTextHint.setText(String.format(ah4.e(R.string.programs_add_exist_notice), "" + (10 - this.v)));
        if (this.v == 0) {
            this.patternListToAdd.setVisibility(8);
            this.patternList.setVisibility(8);
        } else {
            this.patternListToAdd.setVisibility(0);
            this.patternList.setVisibility(0);
            if (10 - this.v == 0) {
                this.patternListToAdd.setAlpha(0.4f);
                this.patternListToAdd.setEnabled(false);
            } else {
                this.patternListToAdd.setAlpha(1.0f);
                this.patternListToAdd.setEnabled(true);
            }
        }
        Z4();
    }

    public final void notifyDataSetChanged() {
        runOnUiThread(new h());
    }

    public final void o5() {
        Toy toy = this.w;
        if (toy == null) {
            this.toyBatteryImg.setVisibility(8);
            return;
        }
        this.toyName.setText(toy.getName());
        Toy toyQ = this.x.Q(this.w.getAddress());
        if (toyQ != null) {
            if (toyQ.getStatus() != 0 && toyQ.getStatus() == 1) {
                if (this.w.isF01Toy()) {
                    this.toyBatteryImg.setVisibility(8);
                } else {
                    this.toyBatteryImg.setVisibility(0);
                }
                this.toyImg.setImageResource(Toy.getToyIconLinkedId(this.w.getType(), 0, true));
                kn3 kn3Var = this.t;
                if (kn3Var != null) {
                    if (this.y && kn3Var.isShowing()) {
                        g5();
                    }
                    this.t.dismiss();
                }
                this.t = null;
            } else {
                this.toyBatteryImg.setVisibility(8);
                this.toyImg.setImageResource(Toy.getToyIconLinkedId(this.w.getType(), 0, false));
            }
        }
        if (toyQ.getStatus() == -1 && this.t == null) {
            kn3 kn3Var2 = new kn3((Context) this, ah4.e(R.string.toy_program_disconnected), ah4.e(R.string.common_back), false, false, (kn3.d) new a());
            this.t = kn3Var2;
            kn3Var2.show();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) throws NumberFormatException {
        ArrayList<String> stringArrayListExtra;
        List<Pattern> listZ;
        super.onActivityResult(i2, i3, intent);
        if ((i2 == 22 && i3 == 24 && intent != null && intent.getExtras().getInt("is_program_pattern", 0) > 0) || (i2 == 24 && i2 == 24 && intent != null)) {
            Pattern pattern = (Pattern) intent.getExtras().getSerializable("program_pattern");
            if (pattern == null || this.w == null) {
                return;
            }
            if (this.q == null) {
                this.q = ProgressDialog.show(this, "", ah4.e(R.string.common_inprocessing), true, false);
            }
            this.q.show();
            List<List<String>> motors = this.w.getMotors();
            ProgramPattern programPattern = new ProgramPattern();
            programPattern.setName(pattern.getName());
            programPattern.setEmail(WearUtils.y.r());
            programPattern.setAuthor(pattern.getAuthor());
            programPattern.setBtAddress(this.w.getAddress());
            programPattern.setData(pattern, this.l, motors);
            WearUtils.S1(pattern.getId());
            programPattern.setIndex(String.valueOf(this.e.size()));
            programPattern.calculateTime(this.l);
            this.K.add(programPattern);
            if (this.K.size() > 0) {
                m5(this.K.get(0));
            }
        }
        if (i2 != 22 || i3 != 22 || intent == null || (stringArrayListExtra = intent.getStringArrayListExtra("choose_patterns")) == null) {
            return;
        }
        if ((stringArrayListExtra != null && stringArrayListExtra.size() == 0) || (listZ = xe2.L0().z(WearUtils.y.r(), 50)) == null || this.w == null) {
            return;
        }
        if (this.q == null) {
            this.q = ProgressDialog.show(this, "", ah4.e(R.string.common_inprocessing), true, false);
        }
        this.q.show();
        this.K.clear();
        List<List<String>> motors2 = this.w.getMotors();
        int i4 = 0;
        for (Pattern pattern2 : listZ) {
            Iterator<String> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                if (it.next().equals(pattern2.getId())) {
                    ProgramPattern programPattern2 = new ProgramPattern();
                    programPattern2.setName(pattern2.getName());
                    programPattern2.setEmail(WearUtils.y.r());
                    programPattern2.setAuthor(pattern2.getAuthor());
                    programPattern2.setBtAddress(this.w.getAddress());
                    programPattern2.setData(pattern2, this.l, motors2);
                    i4++;
                    programPattern2.setIndex(String.valueOf((this.e.size() + i4) - 1));
                    programPattern2.calculateTime(this.l);
                    this.K.add(programPattern2);
                }
            }
        }
        if (this.K.size() > 0) {
            m5(this.K.get(0));
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick({R.id.pattern_list_to_add, R.id.pattern_list_empty_to_add, R.id.setting_change_levels})
    public void onClick(View view) {
        this.i = true;
        rq1.d.r(this.b);
        notifyDataSetChanged();
        switch (view.getId()) {
            case R.id.pattern_list_empty_to_add /* 2131364041 */:
            case R.id.pattern_list_to_add /* 2131364042 */:
                this.i = true;
                notifyDataSetChanged();
                if (this.v < 10) {
                    k5();
                    break;
                }
                break;
            case R.id.setting_change_levels /* 2131364489 */:
                bo3 bo3Var = new bo3(this, R.layout.program_toy_level, new c());
                this.p = bo3Var;
                bo3Var.show();
                LevelControlView levelControlView = (LevelControlView) this.p.findViewById(R.id.level_control_group);
                this.m = levelControlView;
                levelControlView.k(this.a, this.b, this.n);
                this.p.c(R.id.change_level_save, new d());
                this.p.c(R.id.change_level_close, new e());
                MusicControl.h0();
                h12.D.playPatternPause = true;
                if (MusicControl.h0().O()) {
                    EventBus eventBus = EventBus.getDefault();
                    MusicControl.h0();
                    eventBus.post(h12.D);
                }
                if (!PatternPlayManagerImpl.O().d0()) {
                    PatternPlayManagerImpl.O().D0();
                }
                if (SpeedModeControl.C().K()) {
                    SpeedModeControl.C().N();
                }
                if (SoundPlayControl.M().a && !SoundPlayControl.M().b) {
                    SoundPlayControl.M().U();
                }
                if (ll3.E().I()) {
                    ll3.E().V();
                    break;
                }
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ambi_program);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        MyApplication myApplication = (MyApplication) getApplication();
        this.a = myApplication;
        this.x = myApplication.G();
        this.b = getIntent().getStringExtra("program_toy_address_Id");
        o5();
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.c = myActionBar;
        myActionBar.setTitle(ah4.e(R.string.program_title));
        this.c.setBackAction(new v());
        this.c.setYesAction(R.string.toy_program_restore, new w());
        this.patternList.setMenu(new yu3(false, 0));
        yo1 yo1Var = new yo1(this, this.a);
        this.u = yo1Var;
        this.patternList.setAdapter((ListAdapter) yo1Var);
        this.patternList.setEmptyView(this.patternListEmpty);
        this.patternList.setOnItemLongClickListener(new y(this));
        this.patternList.setOnItemClickListener(new z());
        Toy toyQ = this.x.Q(this.b);
        this.w = toyQ;
        if (toyQ == null) {
            finish();
            return;
        }
        if (this.l == 0) {
            this.l = toyQ.getProgramSpeed();
        }
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.settingChangeLightsLayout.setVisibility(8);
        this.loadingLayer.setVisibility(8);
        ProgressDialog progressDialog = this.q;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        ProgressDialog progressDialogShow = ProgressDialog.show(this, "", ah4.e(R.string.common_inprocessing), true, true);
        this.q = progressDialogShow;
        progressDialogShow.show();
        this.s.postDelayed(new a0(), 500L);
        this.toyImg.setOnClickListener(new b0());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        ProgressDialog progressDialog = this.q;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.q = null;
        }
        Timer timer = this.g;
        if (timer != null) {
            timer.cancel();
            this.g = null;
            this.i = true;
            MusicControl.h0();
            h12.D.playPatternPause = false;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(vc1 vc1Var) {
        runOnUiThread(new d0(vc1Var));
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(WearUtils.x).unregisterReceiver(this.f);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f = new e0();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_TOY_UPDATE");
        intentFilter.addAction("ACTION_TOY_BATTERY_UPDATE");
        LocalBroadcastManager.getInstance(WearUtils.x).registerReceiver(this.f, intentFilter);
        notifyDataSetChanged();
        n5();
        TextView textView = this.toyName;
        Toy toy = this.w;
        textView.setText(toy == null ? "" : toy.getName());
        this.toyStatus.setText(WearUtils.e1(this.w.getDefineRename()) ? "" : this.w.getDefineRename());
        if (this.w.isF01Toy()) {
            this.toyBatteryImg.setVisibility(8);
        } else {
            this.w.updateToyBattery(this.toyBatteryImg);
        }
    }

    public final void p5() {
        Toy toy = this.w;
        if (toy == null) {
            e5();
            return;
        }
        if (!toy.hasProgramToy()) {
            e5();
            return;
        }
        this.K.clear();
        this.w.getToyVersion();
        int i2 = 0;
        for (String str : this.w.getProgramDefaultProgram()) {
            ProgramPattern programPattern = new ProgramPattern();
            StringBuilder sb = new StringBuilder();
            sb.append("P");
            i2++;
            sb.append(i2);
            programPattern.setName(sb.toString());
            programPattern.setEmail(WearUtils.y.r());
            programPattern.setAuthor(null);
            programPattern.setBtAddress(this.w.getAddress());
            programPattern.setData(str);
            programPattern.calculateTime(this.l);
            this.K.add(programPattern);
        }
        if (this.K.size() < 1) {
            return;
        }
        this.N = 0;
        this.y = true;
        this.F = 0;
        Iterator<ProgramPattern> it = this.K.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3++;
            it.next().setIndex(String.valueOf(i3 - 1));
        }
        m5(this.K.get(0));
    }

    public void q5(String str) {
        String strSubstring;
        if (!WearUtils.e1(str) && str.toLowerCase().indexOf("er,w") != -1 && this.y) {
            sg3.h(R.string.toy_program_failed_notice);
            if (this.e.size() > 0) {
                this.N++;
                List<ProgramPattern> list = this.e;
                list.remove(list.size() - 1);
            }
        }
        if (WearUtils.e1(str) || str.toLowerCase().indexOf(ProgramPattern.writePatternChar) == -1 || this.O.get(ProgramPattern.writePatternChar) == null) {
            return;
        }
        ProgramPattern programPattern = this.O.get(ProgramPattern.writePatternChar);
        if (str.indexOf(",wf") > 0) {
            strSubstring = "" + programPattern.getUploadToToyTotalComman();
        } else {
            strSubstring = str.substring(str.indexOf(ProgramPattern.writePatternChar) + 2, str.length() - 1);
        }
        if (Integer.valueOf(strSubstring).intValue() == programPattern.getUploadToToyTotalComman()) {
            this.K.remove(programPattern);
            this.O.clear();
            if (this.G) {
                this.F++;
                a5();
                return;
            }
            DaoUtils.getProgramPatternDao().add((ProgramPatternDao) programPattern);
            this.e.add(Integer.valueOf(programPattern.getIndex()).intValue(), programPattern);
            runOnUiThread(new u());
            this.L = true;
            if (this.K.size() > 0) {
                m5(this.K.get(0));
            } else {
                runOnUiThread(new x());
            }
        }
    }

    public final void r5() throws InterruptedException {
        LevelControlView levelControlView = this.m;
        if (levelControlView != null) {
            i5(levelControlView.l(this.w));
            this.m.i();
            return;
        }
        String strM = LevelControlView.m(this.w);
        this.n = LevelControlView.f(this.w);
        if (this.x.Q(this.w.getAddress()).getStatus() == 1) {
            for (String str : strM.split("#")) {
                if (!WearUtils.e1(str)) {
                    h5(str);
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(wc1 wc1Var) {
        String strB = wc1Var.b();
        if (this.b.equals(wc1Var.a())) {
            String str = "message:" + strB;
            U4(strB);
            q5(strB);
            V4(strB);
            W4(strB);
            X4(strB);
        }
    }
}
