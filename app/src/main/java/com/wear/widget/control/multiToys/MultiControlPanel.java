package com.wear.widget.control.multiToys;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.bean.LimitQueue;
import com.wear.bean.Toy;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.bean.controlmutlitoys.BaseBallBean;
import com.wear.bean.controlmutlitoys.ControlBallBean;
import com.wear.bean.controlmutlitoys.MultiToyOFunBean;
import com.wear.bean.event.SolaceProFunctionChangeEvent;
import com.wear.bean.socketio.msg.response.DSMultiToySelectChangeResponse;
import com.wear.util.MyApplication;
import com.wear.widget.control.multiToys.MultiBallControlPanel;
import com.wear.widget.control.multiToys.MultiBallSelectPanel;
import com.wear.widget.control.multiToys.MultiCurveLineView;
import com.wear.widget.control.multiToys.MultiToysCurvePanel;
import com.wear.widget.control.multiToys.MultiVelvoPanel;
import com.wear.widget.dialog.NewToyGuideDialog;
import com.wear.widget.llong.sliding.SlidingUpPanelLayout;
import dc.ah4;
import dc.ek2;
import dc.fk2;
import dc.ke3;
import dc.qa2;
import dc.th4;
import dc.v20;
import dc.xc1;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes4.dex */
public class MultiControlPanel extends LinearLayout implements MultiBallSelectPanel.b, MultiBallControlPanel.n, MultiBallControlPanel.m, MultiBallControlPanel.o, MultiVelvoPanel.b, MultiVelvoPanel.a {
    public static boolean A = false;
    public o a;
    public s b;
    public String c;
    public boolean d;

    @BindView(R.id.divider)
    public View divider;
    public Context e;
    public LayoutInflater f;
    public int g;

    @BindView(R.id.multi_ball_control_guideline3)
    public Guideline guideline;
    public long h;
    public float i;
    public boolean j;
    public r k;
    public w l;
    public u m;

    @BindView(R.id.multi_ball_control_panel)
    public MultiBallControlPanel multiBallControlPanel;

    @BindView(R.id.multi_ball_select_panel)
    public MultiBallSelectPanel multiBallSelectPanel;

    @BindView(R.id.multi_toys_curve_panel)
    public MultiToysCurvePanel multiToysCurvePanel;
    public v n;
    public List<Toy> o;
    public int p;
    public t q;
    public SlidingUpPanelLayout.c r;
    public boolean s;

    @BindView(R.id.multi_ball_slidingpanelayout)
    public SlidingUpPanelLayout slidingPaneLayout;
    public Map<String, LimitQueue<Integer>> t;
    public Disposable u;
    public boolean v;
    public q w;
    public p x;
    public Ball2CurveEventBean y;
    public boolean z;

    public class a implements Runnable {
        public final /* synthetic */ List a;

        public a(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiControlPanel.this.multiBallControlPanel.Z(this.a);
        }
    }

    public class b implements MultiToysCurvePanel.d {
        public b() {
        }

        @Override // com.wear.widget.control.multiToys.MultiToysCurvePanel.d
        public void a(int i, int i2) {
            if ("CHAT_LIVE_CONTROL".equals(MultiControlPanel.this.c) || "CHAT_VIDEO_CONTROL".equals(MultiControlPanel.this.c) || "CHAT_VOICE_CONTROL".equals(MultiControlPanel.this.c) || "GROUP_CHAT_DS_CONTROL".equals(MultiControlPanel.this.c)) {
                MultiControlPanel multiControlPanel = MultiControlPanel.this;
                multiControlPanel.setPanelHeight(multiControlPanel.multiBallControlPanel.getHeight(), i2, i);
            }
        }
    }

    public class c implements SlidingUpPanelLayout.c {
        public c() {
        }

        @Override // com.wear.widget.llong.sliding.SlidingUpPanelLayout.c
        public void a(View view, SlidingUpPanelLayout.d dVar, SlidingUpPanelLayout.d dVar2) {
            if (dVar2 == SlidingUpPanelLayout.d.DRAGGING) {
                if (MultiControlPanel.this.i > 0.0f) {
                    MultiControlPanel.this.multiBallSelectPanel.s(true);
                }
            } else {
                if (dVar2 != SlidingUpPanelLayout.d.EXPANDED) {
                    if (dVar2 == SlidingUpPanelLayout.d.COLLAPSED) {
                        MultiControlPanel.this.g = -1;
                        MultiControlPanel.this.multiBallSelectPanel.s(false);
                        return;
                    }
                    return;
                }
                if (MultiControlPanel.this.g >= 1 && MultiControlPanel.this.g <= 5) {
                    MultiControlPanel.z(MultiControlPanel.this);
                    MultiControlPanel.this.n(false, true);
                }
                MultiControlPanel.this.multiBallSelectPanel.s(true);
                MultiControlPanel.this.multiBallControlPanel.O();
            }
        }

        @Override // com.wear.widget.llong.sliding.SlidingUpPanelLayout.c
        public void onPanelSlide(View view, float f) {
            if (f <= 0.0f) {
                if (MultiControlPanel.this.i > 0.0f) {
                    MultiControlPanel.this.i = f;
                    MultiControlPanel.this.multiBallSelectPanel.s(false);
                    return;
                }
                return;
            }
            if (MultiControlPanel.this.i <= 0.0f) {
                MultiControlPanel.this.i = f;
                MultiControlPanel.this.multiBallSelectPanel.s(true);
                MultiControlPanel.this.multiBallControlPanel.O();
                MultiControlPanel.this.K();
                MultiControlPanel.this.e0();
            }
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ Activity a;

        public d(Activity activity) {
            this.a = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b() {
            if (MultiControlPanel.this.multiBallSelectPanel.getBaseBalls().size() > 1) {
                MultiControlPanel.this.f0();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            NewToyGuideDialog newToyGuideDialog = new NewToyGuideDialog((Context) this.a, true);
            newToyGuideDialog.setOnButtonClick(new NewToyGuideDialog.b() { // from class: dc.ap3
                @Override // com.wear.widget.dialog.NewToyGuideDialog.b
                public final void a() {
                    this.a.b();
                }
            });
            newToyGuideDialog.show();
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ Activity a;

        public e(MultiControlPanel multiControlPanel, Activity activity) {
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            new NewToyGuideDialog((Context) this.a, false).show();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MultiControlPanel.this.multiBallSelectPanel.getBaseBalls() != null) {
                if (MultiControlPanel.this.multiBallSelectPanel.getBaseBalls().size() > MultiControlPanel.this.p) {
                    MultiControlPanel.this.e0();
                } else if (MultiControlPanel.this.multiBallSelectPanel.getBaseBalls().size() > 1) {
                    MultiControlPanel.this.f0();
                }
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiControlPanel.this.n(false, false);
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiControlPanel.this.n(false, false);
        }
    }

    public class i implements Observer<List<Ball2CurveEventBean>> {
        public i() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(@NotNull List<Ball2CurveEventBean> list) {
            if (MultiControlPanel.this.v || MultiControlPanel.this.k == null || list.isEmpty()) {
                return;
            }
            MultiControlPanel.this.k.f(list);
            MultiControlPanel.this.y = list.get(list.size() - 1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(@NotNull Throwable th) {
            th.printStackTrace();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(@NotNull Disposable disposable) {
            MultiControlPanel.this.u = disposable;
        }
    }

    public class j implements Function<List<Ball2CurveEventBean>, List<Ball2CurveEventBean>> {
        public j() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<Ball2CurveEventBean> apply(@NotNull List<Ball2CurveEventBean> list) throws Exception {
            LimitQueue limitQueue;
            ArrayList arrayList = new ArrayList();
            try {
                if (MultiControlPanel.this.multiBallSelectPanel.getBaseBalls() != null && !MultiControlPanel.this.multiBallSelectPanel.getBaseBalls().isEmpty()) {
                    for (BaseBallBean baseBallBean : MultiControlPanel.this.multiBallSelectPanel.getBaseBalls()) {
                        if (!baseBallBean.isSelected()) {
                            Ball2CurveEventBean ball2CurveEventBean = new Ball2CurveEventBean(baseBallBean.getToyAddress(), baseBallBean.getToyFun(), "0");
                            ball2CurveEventBean.setSymbol(baseBallBean.getSymbol());
                            list.add(ball2CurveEventBean);
                        }
                    }
                }
                if (MultiControlPanel.this.s) {
                    for (Ball2CurveEventBean ball2CurveEventBean2 : list) {
                        String str = ball2CurveEventBean2.getToyAddress() + "," + ball2CurveEventBean2.getFunction();
                        if (MultiControlPanel.this.t.containsKey(str)) {
                            limitQueue = (LimitQueue) MultiControlPanel.this.t.get(str);
                        } else {
                            limitQueue = new LimitQueue(6);
                            MultiControlPanel.this.t.put(str, limitQueue);
                        }
                        limitQueue.offer(Integer.valueOf(ball2CurveEventBean2.getGroups()));
                        if (limitQueue.size() != 6 || new HashSet(limitQueue.getQueue()).size() != 1) {
                            arrayList.add(ball2CurveEventBean2);
                        }
                    }
                } else {
                    arrayList.addAll(list);
                }
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(new Throwable("指令过滤crash", e));
            }
            return arrayList;
        }
    }

    public class k implements Runnable {
        public final /* synthetic */ BaseBallBean a;
        public final /* synthetic */ boolean b;

        public k(BaseBallBean baseBallBean, boolean z) {
            this.a = baseBallBean;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiControlPanel.this.multiBallControlPanel.O0(this.a, this.b);
        }
    }

    public interface l {
        void c();
    }

    public interface m {
        void m();
    }

    public interface n {
        void a();
    }

    public interface o {
        void a(List<MultiToyOFunBean> list, boolean z);
    }

    public interface p {
        void a(List<BaseBallBean> list);
    }

    public interface q {
        void a(List<BaseBallBean> list);
    }

    public interface r {
        void b(String str);

        void f(List<Ball2CurveEventBean> list);
    }

    public interface s {
        void a(MotionEvent motionEvent);
    }

    public interface t {
        void c(List<ControlBallBean> list);
    }

    public interface u {
        void a(@NonNull Function0<Unit> function0);
    }

    public interface v {
        void a(boolean z);

        void c(boolean z, String str);
    }

    public interface w {
        void a();
    }

    public MultiControlPanel(Context context) {
        this(context, null);
    }

    public static /* synthetic */ int z(MultiControlPanel multiControlPanel) {
        int i2 = multiControlPanel.g;
        multiControlPanel.g = i2 + 1;
        return i2;
    }

    public void I(v vVar) {
        this.n = vVar;
    }

    public void J(boolean z, @NonNull List<Toy> list) {
        A = z;
        this.o.clear();
        this.o.addAll(list);
        fk2.a.a(list, true);
        this.multiBallSelectPanel.g(z, list);
        postDelayed(new g(), 50L);
    }

    public void K() {
        this.multiBallControlPanel.setExpandPanelGone();
    }

    public void L(@NonNull Map<String, String> map) {
        if (map == null || this.j) {
            return;
        }
        this.multiToysCurvePanel.l(map);
    }

    public final void M(Context context) {
        this.e = context;
        P();
    }

    public void N(boolean z, @NonNull String str, List<Toy> list) {
        O(z, str, list, 4, -1);
    }

    public void O(boolean z, @NonNull String str, List<Toy> list, int i2, int i3) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        A = z;
        this.c = str;
        this.multiBallControlPanel.P(str);
        this.p = i2;
        if (this.o == null) {
            this.o = new ArrayList();
        }
        this.o.clear();
        this.o.addAll(list);
        fk2.a.a(list, !str.equals("GROUP_CHAT_DS_CONTROL"));
        this.multiBallControlPanel.s0(this);
        this.multiBallControlPanel.u0(this);
        this.multiBallSelectPanel.p(this);
        this.multiBallControlPanel.setOnSolacePanelInterceptListener(this);
        this.multiBallControlPanel.setMultiSolacePanelListener(this);
        this.multiBallControlPanel.t0(this);
        Y(this.multiToysCurvePanel);
        this.multiToysCurvePanel.n(this.c, i3);
        this.multiBallControlPanel.a0(this.c, list);
        this.multiBallSelectPanel.setControlPanelType(this.c);
        this.multiBallSelectPanel.setListConnectToys(list, z, i2);
        this.multiBallSelectPanel.setVisibility(str == "CREATE_PATTERN" ? 8 : 0);
    }

    public void P() {
        LayoutInflater layoutInflater = (LayoutInflater) this.e.getSystemService("layout_inflater");
        this.f = layoutInflater;
        ButterKnife.bind(this, layoutInflater.inflate(R.layout.layout_multi_control_panel, this));
        c cVar = new c();
        this.r = cVar;
        this.slidingPaneLayout.n(cVar);
    }

    public boolean Q() {
        return this.d;
    }

    public boolean R() {
        return this.v;
    }

    public void S(List<Ball2CurveEventBean> list) {
        this.multiToysCurvePanel.s(list);
    }

    public void T() {
        this.multiBallControlPanel.p0();
    }

    public void U() {
        this.multiBallControlPanel.I0();
        this.multiBallControlPanel.K0();
        this.multiBallControlPanel.J0();
        this.multiToysCurvePanel.r();
        this.multiBallSelectPanel.o();
        this.multiBallControlPanel.q0();
        Disposable disposable = this.u;
        if (disposable != null && !disposable.isDisposed()) {
            this.u.dispose();
        }
        this.a = null;
        EventBus.getDefault().unregister(this);
    }

    public final void V(boolean z) {
        v vVar = this.n;
        if (vVar != null) {
            vVar.a(z);
        }
        this.multiBallControlPanel.multiVelvoPanel.p(this.d);
    }

    public void W() {
        this.v = true;
        this.j = false;
        a0(null);
    }

    public void X(r rVar) {
        this.k = rVar;
    }

    public void Y(t tVar) {
        this.q = tVar;
    }

    public void Z() {
        a0(null);
        this.multiBallSelectPanel.q();
        this.j = false;
        postDelayed(new h(), 50L);
    }

    @Override // com.wear.widget.control.multiToys.MultiBallControlPanel.m
    public void a(List<Ball2CurveEventBean> list) {
        if (this.j) {
            this.multiToysCurvePanel.s(list);
        }
        if (this.d) {
            a0(null);
            return;
        }
        Disposable disposable = this.u;
        if (disposable != null && !disposable.isDisposed()) {
            this.u.dispose();
        }
        Observable.just(list).map(new j()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i());
    }

    public void a0(String str) {
        if (TextUtils.isEmpty(str)) {
            this.t.clear();
            return;
        }
        for (Map.Entry<String, LimitQueue<Integer>> entry : this.t.entrySet()) {
            if (entry.getKey().contains(str)) {
                this.t.remove(entry.getKey());
            }
        }
    }

    @Override // com.wear.widget.control.multiToys.MultiBallSelectPanel.b
    public void b(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Ball2CurveEventBean(str, "", "", true));
            r rVar = this.k;
            if (rVar != null) {
                rVar.f(arrayList);
                this.k.b(str);
            }
        }
    }

    public void b0() {
        this.multiBallControlPanel.C0();
        this.multiToysCurvePanel.v();
    }

    @Override // com.wear.widget.control.multiToys.MultiBallControlPanel.n
    public void c(List<ControlBallBean> list) {
        t tVar = this.q;
        if (tVar != null) {
            tVar.c(list);
        }
    }

    public final void c0(boolean z, boolean z2) {
        MultiBallControlPanel multiBallControlPanel = this.multiBallControlPanel;
        if (multiBallControlPanel == null || multiBallControlPanel.getVisibility() != 0 || this.y == null) {
            return;
        }
        int currControlMode = this.multiBallControlPanel.getCurrControlMode();
        String str = "resetVelvoCommand:" + currControlMode;
        if (z || currControlMode == 1 || currControlMode == 3) {
            if (z2) {
                this.y.setGroups("0");
            }
            r rVar = this.k;
            if (rVar != null) {
                rVar.f(Arrays.asList(this.y));
            }
        }
    }

    @Override // com.wear.widget.control.multiToys.MultiBallSelectPanel.b
    public void d(List<MultiToyOFunBean> list, boolean z) {
        this.multiToysCurvePanel.B(list, z, false, new b());
        o oVar = this.a;
        if (oVar != null) {
            oVar.a(list, z);
        }
    }

    public void d0() {
        ArrayList arrayList = new ArrayList();
        if (this.multiBallSelectPanel.getBaseBalls() != null && !this.multiBallSelectPanel.getBaseBalls().isEmpty()) {
            for (BaseBallBean baseBallBean : this.multiBallSelectPanel.getBaseBalls()) {
                if (baseBallBean.isSelected()) {
                    Ball2CurveEventBean ball2CurveEventBean = new Ball2CurveEventBean(baseBallBean.getToyAddress(), baseBallBean.getToyFun(), "0");
                    ball2CurveEventBean.setSymbol(baseBallBean.getSymbol());
                    arrayList.add(ball2CurveEventBean);
                }
            }
        }
        if (this.k == null || arrayList.isEmpty()) {
            return;
        }
        this.k.f(arrayList);
        this.y = null;
    }

    @Override // com.wear.widget.control.multiToys.MultiBallControlPanel.n
    public void e() {
        if (System.currentTimeMillis() - this.h >= 100 && this.slidingPaneLayout.getPanelState() != SlidingUpPanelLayout.d.COLLAPSED) {
            this.h = System.currentTimeMillis();
            this.g = 1;
            n(false, true);
        }
    }

    public void e0() {
        Activity activityPeek;
        if (ke3.a("new_user", "hasShowChooseBall")) {
            Stack<Activity> stack = MyApplication.N().q;
            if (stack.isEmpty() || (activityPeek = stack.peek()) == null || activityPeek.isFinishing()) {
                return;
            }
            String str = "当前acitivity" + activityPeek.getLocalClassName();
            activityPeek.runOnUiThread(new d(activityPeek));
        }
    }

    @Override // com.wear.widget.control.multiToys.MultiBallSelectPanel.b
    public void f(List<BaseBallBean> list, List<MultiToyOFunBean> list2) {
        this.multiBallControlPanel.B0(list);
        this.multiToysCurvePanel.w(list2);
    }

    public void f0() {
        if (ke3.a("new_user", "hasShowCombineSeparate")) {
            Activity activityPeek = MyApplication.N().q.peek();
            String str = "当前acitivity" + activityPeek.getLocalClassName();
            if (activityPeek == null || activityPeek.isFinishing()) {
                return;
            }
            activityPeek.runOnUiThread(new e(this, activityPeek));
        }
    }

    @Override // com.wear.widget.control.multiToys.MultiVelvoPanel.a
    public void g(@NonNull Function0<Unit> function0) {
        u uVar = this.m;
        if (uVar == null) {
            function0.invoke();
        } else {
            uVar.a(function0);
        }
    }

    public void g0() {
        new Handler(Looper.getMainLooper()).postDelayed(new f(), 1000L);
    }

    public Toy getFysSelectToy() {
        return this.multiBallControlPanel.getFysSelectToy();
    }

    public List<MultiToyOFunBean> getListConnectToyOFuns() {
        return this.multiBallSelectPanel.getListConnectToyOFuns();
    }

    public List<MultiToyOFunBean> getListSelectedToyOFuns() {
        return this.multiBallSelectPanel.getListSelectedToyOFuns();
    }

    public List<Toy> getListToys() {
        return this.o;
    }

    public long getTime() {
        return this.multiBallControlPanel.getTime();
    }

    @Override // com.wear.widget.control.multiToys.MultiVelvoPanel.b
    public void h(String str, int i2, int i3) {
        c0(fk2.a.c(str) == ek2.POSITION, false);
    }

    public void h0() {
        this.v = false;
        this.j = true;
        this.multiBallControlPanel.F0();
    }

    @Override // com.wear.widget.control.multiToys.MultiBallSelectPanel.b
    public void i(List<BaseBallBean> list) {
        this.multiBallControlPanel.post(new a(list));
        q qVar = this.w;
        if (qVar != null) {
            qVar.a(list);
        }
    }

    public void i0(boolean z) {
        this.j = z;
    }

    @Override // com.wear.widget.control.multiToys.MultiBallSelectPanel.b
    public void j(List<MultiToyOFunBean> list) {
        this.multiToysCurvePanel.y(list);
    }

    public void j0(boolean z, boolean z2) {
        this.slidingPaneLayout.setVisibility(z ? 0 : 8);
        if (z2) {
            a0(null);
            this.multiBallControlPanel.A0();
        }
        this.j = z;
    }

    @Override // com.wear.widget.control.multiToys.MultiBallSelectPanel.b
    public void k(List<BaseBallBean> list) {
        this.multiBallControlPanel.P0(list);
    }

    public void k0(boolean z) {
        this.multiBallControlPanel.H0(!z ? 0 : 3);
    }

    @Override // com.wear.widget.control.multiToys.MultiVelvoPanel.b
    public void l(boolean z, @Nullable String str) {
        v vVar = this.n;
        if (vVar != null) {
            vVar.c(z, str);
        }
    }

    public void l0(int i2) {
        this.p = i2;
        this.multiBallSelectPanel.v(i2);
    }

    @Override // com.wear.widget.control.multiToys.MultiBallSelectPanel.b
    public void m(BaseBallBean baseBallBean, boolean z) {
        this.multiBallControlPanel.post(new k(baseBallBean, z));
        p pVar = this.x;
        if (pVar != null) {
            pVar.a(this.multiBallSelectPanel.getBaseBalls());
        }
    }

    public void m0(int i2) {
        this.multiBallControlPanel.f1(i2);
    }

    @Override // com.wear.widget.control.multiToys.MultiBallSelectPanel.b
    public void n(boolean z, boolean z2) {
        if (this.c == "CREATE_PATTERN") {
            return;
        }
        if (z) {
            if (this.slidingPaneLayout.getPanelState() == SlidingUpPanelLayout.d.COLLAPSED) {
                this.g = -1;
                this.slidingPaneLayout.setPanelState(SlidingUpPanelLayout.d.EXPANDED);
                return;
            }
            return;
        }
        if (this.slidingPaneLayout.getPanelState() == SlidingUpPanelLayout.d.EXPANDED) {
            if (z2) {
                this.slidingPaneLayout.setPanelState(SlidingUpPanelLayout.d.COLLAPSED, true);
            } else {
                this.slidingPaneLayout.setPanelState(SlidingUpPanelLayout.d.COLLAPSED);
            }
        }
    }

    public void n0(@NonNull List<DSMultiToySelectChangeResponse.BallSelectBean> list) {
        if (list != null) {
            this.multiBallSelectPanel.w(list);
        }
    }

    @Override // com.wear.widget.control.multiToys.MultiBallControlPanel.o
    public void o(Toy toy) {
        MultiToyOFunBean multiToyOFunBean = new MultiToyOFunBean(false, toy.getSimpleName(), MultiFysControlPanel.y, toy.getAddress(), toy.getBattery(), toy.isConnected(), toy.isF01Toy(), toy.getToySymbol());
        multiToyOFunBean.setFysModel(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(multiToyOFunBean);
        this.multiToysCurvePanel.A(arrayList);
        this.multiBallSelectPanel.d.setText(String.format(ah4.e(R.string.fys_tip), toy.getToyUINameSpecialForMiniXMachine(1)));
    }

    public void o0(String str, int i2) {
        this.multiToysCurvePanel.z(str, i2);
        this.multiBallSelectPanel.x(str, i2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        String str = "onInterceptTouchEvent: " + motionEvent.getAction();
        s sVar = this.b;
        if (sVar != null) {
            sVar.a(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onToyBatteryChange(v20 v20Var) {
        o0(v20Var.getA(), v20Var.getB());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onToysChange(xc1 xc1Var) {
        p0(xc1Var.a(), xc1Var.b() == 1);
        if (xc1Var.b() == 1) {
            Iterator it = new ArrayList(this.t.keySet()).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (TextUtils.equals(xc1Var.a(), str.split(",")[0])) {
                    this.t.remove(str);
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onVelvoModelChange(SolaceProFunctionChangeEvent solaceProFunctionChangeEvent) {
        r(false, solaceProFunctionChangeEvent.getToy() == null ? "" : solaceProFunctionChangeEvent.getToy().getAddress(), solaceProFunctionChangeEvent.getNewMode());
    }

    @Override // com.wear.widget.control.multiToys.MultiVelvoPanel.b
    public void p(boolean z) {
        this.multiBallControlPanel.setExpandPanelGone();
        if (this.slidingPaneLayout.getPanelState() == SlidingUpPanelLayout.d.EXPANDED) {
            n(false, false);
        }
    }

    public void p0(String str, boolean z) {
        this.multiToysCurvePanel.C(str, z);
        this.multiBallSelectPanel.y(str, z);
        this.multiBallControlPanel.h1(str, z);
    }

    @Override // com.wear.widget.control.multiToys.MultiBallSelectPanel.b
    public void q(List<BaseBallBean> list) {
        this.multiBallControlPanel.a1(list);
    }

    public void q0(@NonNull List<Toy> list) {
        r0(list, false);
    }

    @Override // com.wear.widget.control.multiToys.MultiVelvoPanel.b
    public void r(boolean z, @Nullable String str, @Nullable ek2 ek2Var) {
        t0();
        this.multiBallControlPanel.T();
        this.multiBallControlPanel.c0();
        w wVar = this.l;
        if (wVar != null) {
            wVar.a();
        }
        c0(fk2.a.c(str) == ek2.POSITION, true);
    }

    public void r0(@NonNull List<Toy> list, boolean z) {
        if (list != null) {
            if (this.o == null) {
                this.o = new ArrayList();
            }
            this.o.clear();
            this.o.addAll(list);
            fk2.a.a(list, false);
            this.multiBallSelectPanel.A(list, z, false, this.d);
        }
    }

    @Override // com.wear.widget.control.multiToys.MultiBallControlPanel.o
    public void s(boolean z) {
        this.d = z;
        this.slidingPaneLayout.setTouchEnabled(!z);
        boolean z2 = false;
        n(false, false);
        if (z) {
            this.multiBallControlPanel.setExpandPanelGone();
            this.multiBallSelectPanel.f.setVisibility(8);
            this.multiBallSelectPanel.e.setVisibility(0);
            this.multiBallSelectPanel.b.setVisibility(8);
            this.multiBallSelectPanel.a.setVisibility(8);
            Toy fysSelectToy = this.multiBallControlPanel.getFysSelectToy();
            if (fysSelectToy != null) {
                o(fysSelectToy);
            }
        } else {
            this.multiToysCurvePanel.t();
            this.multiBallSelectPanel.f.setVisibility(qa2.a() ? 8 : 0);
            this.multiBallSelectPanel.e.setVisibility(8);
            this.multiBallSelectPanel.b.setVisibility(0);
            this.multiBallSelectPanel.a.setVisibility(0);
            this.slidingPaneLayout.n(this.r);
        }
        List<Toy> list = this.o;
        if (list != null) {
            Iterator<Toy> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().isBAToy()) {
                    z2 = true;
                    break;
                }
            }
        }
        if (z2) {
            if (this.z != z && !z) {
                t0();
            }
            this.z = z;
            V(!z);
        }
    }

    public void s0(List<Toy> list, boolean z, boolean z2, int i2) {
        List<Toy> list2 = this.o;
        if (list2 != null) {
            if (list2 == null) {
                this.o = new ArrayList();
            }
            this.o.clear();
            this.o.addAll(list);
            if (i2 == 1) {
                fk2.a.a(this.o, true);
            }
            this.multiBallSelectPanel.z(this.o, z, z2, i2);
        }
    }

    public void setAllProgress(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 100) {
            i2 = 100;
        }
        this.multiBallControlPanel.setAllProgress(i2);
    }

    public void setControShowMorelListener(l lVar) {
        this.multiBallControlPanel.setControShowMorelListener(lVar);
    }

    public void setControlLink(boolean z) {
        this.multiBallSelectPanel.setControlLink(z);
        this.multiBallControlPanel.setControlLink(z);
    }

    public void setControlTimer(@NonNull String str) {
        this.multiBallControlPanel.setControlTimer(str);
    }

    public void setControllingBtnVisible(boolean z) {
        this.multiBallControlPanel.setSyncControlBtnVisible(z);
    }

    public void setCurvePanelVisible(int i2) {
        this.multiToysCurvePanel.setVisibility(i2);
        this.multiBallSelectPanel.a.setVisibility(i2);
    }

    public void setDividerVisible(boolean z) {
        this.divider.setVisibility(z ? 0 : 8);
    }

    public void setEndControlListener(m mVar) {
        this.multiBallControlPanel.setEndControlListener(mVar);
    }

    public void setFilter(boolean z) {
        this.s = z;
    }

    public void setHiddenVelvoIcon(boolean z) {
        this.multiToysCurvePanel.setHiddenVelvoIcon(z);
    }

    public void setMultiToysCurveShowMode(boolean z) {
        this.multiToysCurvePanel.setMultiToysCurveShowMode(Boolean.valueOf(z));
    }

    public void setOnBallsChangeListener(p pVar) {
        this.x = pVar;
    }

    public void setOnBallsInitListener(q qVar) {
        this.w = qVar;
    }

    public void setOnChangeModelListener(w wVar) {
        this.l = wVar;
    }

    public void setOnPanelTouchListener(s sVar) {
        this.b = sVar;
    }

    public void setOnVelvoInterceptListener(u uVar) {
        this.m = uVar;
    }

    public void setPanelChildHeight(int i2, int i3, int i4, float f2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.multiToysCurvePanel.getLayoutParams();
        if (i4 == 0) {
            i4 = 1;
        } else if (i4 > 2) {
            i4 = 2;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).height = i3 * i4;
        this.multiToysCurvePanel.setLayoutParams(layoutParams);
        setPanelPercent(f2);
        if (f2 >= 1.0f) {
            this.slidingPaneLayout.setVisibility(8);
            return;
        }
        this.slidingPaneLayout.setVisibility(0);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.slidingPaneLayout.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = i2;
        this.slidingPaneLayout.setLayoutParams(layoutParams2);
    }

    public void setPanelHeight(int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (i4 == 0) {
            i4 = 1;
        } else if (i4 > 2) {
            i4 = 2;
        }
        int i5 = i3 * i4;
        layoutParams.height = i2 + i5;
        setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.multiToysCurvePanel.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = i5;
        this.multiToysCurvePanel.setLayoutParams(layoutParams2);
        setPanelPercent(new BigDecimal(i5).divide(new BigDecimal(layoutParams.height), 4, 4).floatValue());
    }

    public void setPanelPercent(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.guideline.setGuidelinePercent(f2);
    }

    public void setSelectPanelVisible(int i2) {
        this.multiBallSelectPanel.setSlideTopPanelVisibility(i2);
    }

    public void setSlidingPaneLayoutTouchEnable(boolean z) {
        this.slidingPaneLayout.setTouchEnabled(z);
    }

    public void setStyle() {
        setBackgroundColor(th4.b(getContext(), R.color.transparent));
        this.multiBallSelectPanel.setBackground(R.color.multi_control_panel_bg_transparent);
        this.multiBallControlPanel.setBackground(R.color.multi_control_panel_bg_transparent);
        this.divider.setBackgroundColor(th4.b(getContext(), R.color.multi_toys_select_line_dark));
        this.multiToysCurvePanel.setStyle(2);
        this.multiBallControlPanel.setStyle(2);
    }

    public void setSwitchControlListener(n nVar) {
        this.multiBallControlPanel.setSwitchControlListener(nVar);
    }

    public void setSyncControlMode(boolean z, int i2) {
        this.multiBallControlPanel.E0(z, i2);
    }

    public void setToyChangeListener(o oVar) {
        this.a = oVar;
    }

    @Override // com.wear.widget.control.multiToys.MultiBallSelectPanel.b
    public void t(List<MultiToyOFunBean> list, boolean z) {
        this.multiToysCurvePanel.B(list, false, z, null);
    }

    public final void t0() {
        if (Q()) {
            return;
        }
        this.multiBallSelectPanel.A(this.o, false, true, this.d);
    }

    public void u(MultiCurveLineView.a aVar) {
        this.multiToysCurvePanel.a(aVar);
    }

    public MultiControlPanel(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiControlPanel(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = "REMOTE_CONTROL";
        this.d = false;
        this.j = true;
        this.s = false;
        this.t = new HashMap();
        this.z = false;
        M(context);
    }
}
