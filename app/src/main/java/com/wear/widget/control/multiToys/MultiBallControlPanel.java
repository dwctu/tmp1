package com.wear.widget.control.multiToys;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.bean.controlmutlitoys.BaseBallBean;
import com.wear.bean.controlmutlitoys.ControlBallBean;
import com.wear.util.WearUtils;
import com.wear.widget.control.FingImageLayout;
import com.wear.widget.control.multiToys.MultiBallTraditionalPanel;
import com.wear.widget.control.multiToys.MultiControlPanel;
import com.wear.widget.control.multiToys.MultiFysControlPanel;
import com.wear.widget.control.multiToys.MultiVelvoPanel;
import dc.ah4;
import dc.ce3;
import dc.gg3;
import dc.my2;
import dc.pc1;
import dc.sg3;
import dc.th4;
import dc.uu1;
import dc.ye3;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes4.dex */
public class MultiBallControlPanel extends FrameLayout implements MultiBallTraditionalPanel.b, MultiFysControlPanel.g {
    public static final String G = MultiBallControlPanel.class.getName();
    public int A;
    public View B;
    public final int[] C;
    public MultiControlPanel.n D;
    public MultiControlPanel.m E;
    public MultiControlPanel.l F;
    public View a;
    public MultiControlBallView b;

    @BindView(R.id.bottom_line)
    public View bottomLine;
    public String c;
    public boolean d;
    public long e;
    public LayoutInflater f;

    @BindView(R.id.fl_control_fys_panel)
    public FrameLayout flControlFysPanel;

    @BindView(R.id.fl_control_panel)
    public FrameLayout flControlPanel;

    @BindView(R.id.fl_expand_panel)
    public FrameLayout flExpandPanel;
    public List<ControlBallBean> g;

    @BindView(R.id.guide_line_panel)
    public MultiBallGuideLinePanel guideLinePanel;
    public List<MultiControlBallView> h;
    public List<ControlBallBean> i;

    @BindView(R.id.iv_control_mode_chat_end)
    public ImageView ivControlEnd;

    @BindView(R.id.iv_control_mode_float)
    public ImageView ivControlModeFloat;

    @BindView(R.id.iv_control_mode_fys_choose_panel)
    public ImageView ivControlModeFysChoosePanel;

    @BindView(R.id.iv_control_mode_fys_panel)
    public ImageView ivControlModeFysPanel;

    @BindView(R.id.iv_control_mode_loop)
    public ImageView ivControlModeLoop;

    @BindView(R.id.iv_control_mode_slide)
    public ImageView ivControlModeSlide;

    @BindView(R.id.iv_control_mode_traditional_panel)
    public ImageView ivControlModeTrad;

    @BindView(R.id.iv_control_mode_chat_endvis)
    public ImageView ivControlTimer;

    @BindView(R.id.iv_control_mode_controlling_panel)
    public ImageView ivControlling;

    @BindView(R.id.iv_marker)
    public ImageView ivMarker;

    @BindView(R.id.iv_control_mode_traditional_choose_panel)
    public ImageView ivTraditionalChoose;
    public HashMap<ControlBallBean, MultiControlBallView> j;
    public m k;
    public n l;

    @BindView(R.id.ll_control_mode_end_panel)
    public LinearLayout llControlEnd;

    @BindView(R.id.ll_control_mode_endvis_panel)
    public LinearLayout llControlEndShow;

    @BindView(R.id.ll_control_mode_layout_choose)
    public LinearLayout llControlModeChoosePanel;

    @BindView(R.id.ll_control_mode_float)
    public LinearLayout llControlModeFloat;

    @BindView(R.id.ll_control_mode_fys_choose_panel)
    public LinearLayout llControlModeFysChoosePanel;

    @BindView(R.id.ll_control_mode_fys_panel)
    public LinearLayout llControlModeFysPanel;

    @BindView(R.id.ll_control_mode_loop)
    public LinearLayout llControlModeLoop;

    @BindView(R.id.ll_control_mode_traditional_panel)
    public LinearLayout llControlModeTraditionalPanel;

    @BindView(R.id.ll_control_mode_controlling_panel)
    public LinearLayout llControlling;

    @BindView(R.id.ll_control_mode_slide)
    public LinearLayout llSlide;

    @BindView(R.id.ll_timer)
    public LinearLayout llTimer;

    @BindView(R.id.ll_control_mode_traditional_choose_panel)
    public LinearLayout llTraditionalChoose;
    public o m;

    @BindView(R.id.multi_control_fys_panel)
    public MultiFysControlPanel multiControlFysPanel;

    @BindView(R.id.multi_solace_panel)
    public MultiVelvoPanel multiVelvoPanel;
    public int n;
    public int o;
    public View.OnTouchListener p;

    @BindView(R.id.control_panel_parent)
    public ConstraintLayout parentLayout;
    public View.OnTouchListener q;
    public ControlBallBean r;

    @BindView(R.id.right_line)
    public View rightLine;
    public ControlBallBean s;
    public Disposable t;

    @BindView(R.id.multi_ball_control_trad_panel)
    public MultiBallTraditionalPanel traditionalPanel;

    @BindView(R.id.fl_control_trad_panel)
    public FrameLayout traditionalPanelLayout;

    @BindView(R.id.tv_control_mode_float)
    public TextView tvControlModeFloat;

    @BindView(R.id.tv_control_mode_fys_choose_panel)
    public TextView tvControlModeFysChoosePanel;

    @BindView(R.id.tv_control_mode_fys_panel)
    public TextView tvControlModeFysPanel;

    @BindView(R.id.tv_control_mode_loop)
    public TextView tvControlModeLoop;

    @BindView(R.id.tv_control_mode_slide)
    public TextView tvControlModeSlide;

    @BindView(R.id.tv_control_mode_traditional_panel)
    public TextView tvControlModeTrad;

    @BindView(R.id.tv_control_mode_chat_end_timer)
    public TextView tvControlTimer;

    @BindView(R.id.tv_control_mode_chat_endvis_timer)
    public TextView tvControlVisTimer;

    @BindView(R.id.tv_control_mode_controlling_panel)
    public TextView tvControlling;

    @BindView(R.id.tv_marker_0)
    public TextView tvMarker0;

    @BindView(R.id.tv_marker_100)
    public TextView tvMarker100;

    @BindView(R.id.tv_timer)
    public TextView tvTimer;
    public Disposable u;
    public boolean v;
    public boolean w;
    public int x;
    public long y;
    public long z;

    public class a implements Consumer<Long> {
        public final /* synthetic */ ControlBallBean a;
        public final /* synthetic */ MultiControlBallView b;

        public a(ControlBallBean controlBallBean, MultiControlBallView multiControlBallView) {
            this.a = controlBallBean;
            this.b = multiControlBallView;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l) throws Exception {
            if (l.longValue() == 9) {
                this.a.setLongPressed(true);
                MultiBallControlPanel.this.h0(this.b);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException, IllegalArgumentException {
            MultiBallControlPanel.this.v0();
            MultiBallControlPanel.this.g1();
            MultiBallControlPanel.this.D0();
            for (int i = 0; i < MultiBallControlPanel.this.g.size(); i++) {
                ControlBallBean controlBallBean = (ControlBallBean) MultiBallControlPanel.this.g.get(i);
                MultiBallControlPanel multiBallControlPanel = MultiBallControlPanel.this;
                multiBallControlPanel.flControlPanel.addView(multiBallControlPanel.m0(controlBallBean));
                if (i == MultiBallControlPanel.this.g.size() - 1) {
                    MultiBallControlPanel.this.S0(controlBallBean);
                }
                MultiBallControlPanel.this.W0();
                MultiBallControlPanel.this.M0();
                MultiBallControlPanel.this.Z0();
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiBallControlPanel.this.D0();
        }
    }

    public class d implements View.OnTouchListener {
        public d() {
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00e1  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) throws java.lang.IllegalArgumentException {
            /*
                Method dump skipped, instructions count: 337
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.multiToys.MultiBallControlPanel.d.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public class e implements View.OnTouchListener {
        public e() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) throws java.lang.IllegalArgumentException {
            /*
                r5 = this;
                com.wear.widget.control.multiToys.MultiBallControlPanel r0 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                java.util.HashMap r0 = com.wear.widget.control.multiToys.MultiBallControlPanel.l(r0)
                com.wear.widget.control.multiToys.MultiBallControlPanel r1 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                com.wear.bean.controlmutlitoys.ControlBallBean r1 = com.wear.widget.control.multiToys.MultiBallControlPanel.k(r1)
                java.lang.Object r0 = r0.get(r1)
                com.wear.widget.control.multiToys.MultiControlBallView r0 = (com.wear.widget.control.multiToys.MultiControlBallView) r0
                r1 = 0
                if (r0 == 0) goto La5
                int r2 = r7.getActionMasked()
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L43
                if (r2 == r4) goto L2d
                if (r2 == r3) goto L26
                r6 = 3
                if (r2 == r6) goto L2d
                goto La5
            L26:
                com.wear.widget.control.multiToys.MultiBallControlPanel r2 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                com.wear.widget.control.multiToys.MultiBallControlPanel.m(r2, r7, r6, r0)
                goto La5
            L2d:
                com.wear.widget.control.multiToys.MultiBallControlPanel r6 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                java.util.List r6 = com.wear.widget.control.multiToys.MultiBallControlPanel.i(r6)
                boolean r6 = r6.contains(r0)
                if (r6 == 0) goto La5
                com.wear.widget.control.multiToys.MultiBallControlPanel r6 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                com.wear.bean.controlmutlitoys.ControlBallBean r7 = com.wear.widget.control.multiToys.MultiBallControlPanel.k(r6)
                com.wear.widget.control.multiToys.MultiBallControlPanel.j(r6, r7, r0)
                goto La5
            L43:
                com.wear.widget.control.multiToys.MultiBallControlPanel r2 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                int r2 = com.wear.widget.control.multiToys.MultiBallControlPanel.I(r2)
                if (r2 != r3) goto L54
                com.wear.widget.control.multiToys.MultiBallControlPanel r2 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                com.wear.bean.controlmutlitoys.ControlBallBean r2 = com.wear.widget.control.multiToys.MultiBallControlPanel.k(r2)
                r2.setLooping(r4)
            L54:
                com.wear.widget.control.multiToys.MultiBallControlPanel r2 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                com.wear.bean.controlmutlitoys.ControlBallBean r2 = com.wear.widget.control.multiToys.MultiBallControlPanel.k(r2)
                r2.setLoopIndex(r1)
                com.wear.widget.control.multiToys.MultiBallControlPanel r1 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                com.wear.bean.controlmutlitoys.ControlBallBean r1 = com.wear.widget.control.multiToys.MultiBallControlPanel.k(r1)
                java.util.List r1 = r1.getDatas()
                r1.clear()
                com.wear.widget.control.multiToys.MultiBallControlPanel r1 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                com.wear.bean.controlmutlitoys.ControlBallBean r2 = com.wear.widget.control.multiToys.MultiBallControlPanel.k(r1)
                com.wear.widget.control.multiToys.MultiBallControlPanel.J(r1, r2)
                com.wear.widget.control.multiToys.MultiBallControlPanel r1 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                com.wear.widget.control.multiToys.MultiBallControlPanel.m(r1, r7, r6, r0)
                com.wear.widget.control.multiToys.MultiBallControlPanel r6 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                com.wear.widget.control.multiToys.MultiBallControlPanel.f(r6, r0)
                com.wear.widget.control.multiToys.MultiBallControlPanel r6 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                com.wear.widget.control.multiToys.MultiBallControlPanel$n r6 = com.wear.widget.control.multiToys.MultiBallControlPanel.r(r6)
                if (r6 == 0) goto L9d
                com.wear.widget.control.multiToys.MultiBallControlPanel r6 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                com.wear.widget.control.multiToys.MultiBallControlPanel$n r6 = com.wear.widget.control.multiToys.MultiBallControlPanel.r(r6)
                r6.e()
                com.wear.widget.control.multiToys.MultiBallControlPanel r6 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                com.wear.widget.control.multiToys.MultiBallControlPanel$n r6 = com.wear.widget.control.multiToys.MultiBallControlPanel.r(r6)
                com.wear.widget.control.multiToys.MultiBallControlPanel r7 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                java.util.List r7 = com.wear.widget.control.multiToys.MultiBallControlPanel.K(r7)
                r6.c(r7)
            L9d:
                com.wear.widget.control.multiToys.MultiBallControlPanel r6 = com.wear.widget.control.multiToys.MultiBallControlPanel.this
                com.wear.widget.control.multiToys.MultiVelvoPanel r6 = r6.multiVelvoPanel
                r6.c()
                return r4
            La5:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.multiToys.MultiBallControlPanel.e.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) throws Resources.NotFoundException, IllegalArgumentException {
            ControlBallBean controlBallBean = (ControlBallBean) view.getTag();
            MultiControlBallView multiControlBallView = (MultiControlBallView) view;
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                controlBallBean.getCurrentLocation()[0] = motionEvent.getRawX();
                controlBallBean.getCurrentLocation()[1] = motionEvent.getRawY();
                return true;
            }
            if (actionMasked == 1) {
                MultiBallControlPanel.this.V(controlBallBean, multiControlBallView);
            } else if (actionMasked == 2) {
                MultiBallControlPanel.this.j0(motionEvent, multiControlBallView);
            }
            return false;
        }
    }

    public class g implements View.OnTouchListener {
        public g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() != 0) {
                return false;
            }
            MultiBallControlPanel.this.setExpandPanelGone();
            return false;
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MultiBallControlPanel.this.setExpandPanelGone();
        }
    }

    public class i implements Consumer<List<Ball2CurveEventBean>> {
        public i() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<Ball2CurveEventBean> list) throws Exception {
            if (MultiBallControlPanel.this.x != 4) {
                MultiBallControlPanel.this.o0(list);
            }
            if (MultiBallControlPanel.this.w) {
                return;
            }
            MultiBallControlPanel.q(MultiBallControlPanel.this, 100L);
            if (MultiBallControlPanel.this.y % 1000 == 0) {
                MultiBallControlPanel multiBallControlPanel = MultiBallControlPanel.this;
                multiBallControlPanel.z = multiBallControlPanel.y / 1000;
                MultiBallControlPanel multiBallControlPanel2 = MultiBallControlPanel.this;
                multiBallControlPanel2.tvTimer.setText(WearUtils.Q(multiBallControlPanel2.z));
            }
        }
    }

    public class j implements Function<Long, List<Ball2CurveEventBean>> {
        public j() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<Ball2CurveEventBean> apply(@NotNull Long l) throws Exception {
            try {
                if (!MultiBallControlPanel.this.w) {
                    return MultiBallControlPanel.this.x == 3 ? MultiBallControlPanel.this.traditionalPanel.getBall2CurveEventBeans() : MultiBallControlPanel.this.getBall2CurveEventBeans();
                }
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(new Throwable("getBall2CurveEventBeans多线程操作crash", e));
            }
            return new ArrayList();
        }
    }

    public class k implements Consumer<List<MultiControlBallView>> {
        public k() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<MultiControlBallView> list) throws Exception {
            for (MultiControlBallView multiControlBallView : MultiBallControlPanel.this.j.values()) {
                if (list.isEmpty() || !list.contains(multiControlBallView)) {
                    multiControlBallView.setIvCrossBgVisible(false);
                    if (!MultiBallControlPanel.this.h.contains(multiControlBallView) && Build.VERSION.SDK_INT >= 21) {
                        multiControlBallView.setElevation(multiControlBallView.ivControlMode.getVisibility() == 0 ? 1.0f : 0.0f);
                    }
                } else {
                    if (!multiControlBallView.l()) {
                        MultiBallControlPanel.this.l1();
                    }
                    multiControlBallView.setIvCrossBgVisible(true);
                    if (Build.VERSION.SDK_INT >= 21) {
                        multiControlBallView.setElevation(2.0f);
                    }
                }
            }
        }
    }

    public class l implements Function<Long, List<MultiControlBallView>> {
        public l() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<MultiControlBallView> apply(@NotNull Long l) throws Exception {
            ArrayList arrayList = new ArrayList();
            try {
                if (!MultiBallControlPanel.this.h.isEmpty()) {
                    Collection<MultiControlBallView> collectionValues = MultiBallControlPanel.this.j.values();
                    if (MultiBallControlPanel.this.h.size() != collectionValues.size()) {
                        for (MultiControlBallView multiControlBallView : collectionValues) {
                            if (!MultiBallControlPanel.this.h.contains(multiControlBallView)) {
                                for (MultiControlBallView multiControlBallView2 : MultiBallControlPanel.this.h) {
                                    if (multiControlBallView2 != null && multiControlBallView2.b(multiControlBallView)) {
                                        arrayList.add(multiControlBallView);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(new Throwable("mergeBall多线程操作crash", e));
            }
            return arrayList;
        }
    }

    public interface m {
        void a(List<Ball2CurveEventBean> list);
    }

    public interface n {
        void c(List<ControlBallBean> list);

        void e();
    }

    public interface o {
        void o(Toy toy);

        void s(boolean z);
    }

    public MultiBallControlPanel(Context context) {
        super(context);
        this.d = false;
        this.e = 0L;
        new HashMap();
        this.n = 0;
        this.o = 0;
        this.C = new int[2];
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g0(boolean z) {
        if (!z) {
            sg3.l(ah4.e(R.string.cant_use_fys));
            return;
        }
        this.x = 4;
        this.multiControlFysPanel.H();
        d1();
        this.traditionalPanelLayout.setVisibility(8);
        this.flControlFysPanel.setVisibility(0);
        this.llControlModeTraditionalPanel.setVisibility(0);
        this.llTraditionalChoose.setVisibility(8);
        if (TextUtils.equals("REMOTE_CONTROL", this.c)) {
            this.llControlModeFysChoosePanel.setVisibility(0);
        }
        this.llControlModeFysPanel.setVisibility(8);
        o oVar = this.m;
        if (oVar != null) {
            oVar.s(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Ball2CurveEventBean> getBall2CurveEventBeans() {
        ArrayList arrayList = new ArrayList();
        if (!this.g.isEmpty()) {
            for (ControlBallBean controlBallBean : this.g) {
                List<BaseBallBean> baseBallBeans = controlBallBean.getBaseBallBeans();
                String strValueOf = String.valueOf(controlBallBean.getProgress());
                if (controlBallBean.isLooping()) {
                    controlBallBean.getDatas().add(strValueOf);
                } else if (!controlBallBean.getDatas().isEmpty()) {
                    int loopIndex = controlBallBean.getLoopIndex() + 1;
                    controlBallBean.setLoopIndex(loopIndex);
                    strValueOf = controlBallBean.getDatas().get(loopIndex % controlBallBean.getDatas().size());
                }
                for (BaseBallBean baseBallBean : baseBallBeans) {
                    if (baseBallBean.getToyFun().equals("p") && controlBallBean.getProgress() > 0 && controlBallBean.getProgress() < 33) {
                        strValueOf = "35";
                    }
                    Ball2CurveEventBean ball2CurveEventBean = new Ball2CurveEventBean(baseBallBean.getToyAddress(), baseBallBean.getToyFun(), strValueOf);
                    ball2CurveEventBean.setSymbol(baseBallBean.getSymbol());
                    arrayList.add(ball2CurveEventBean);
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ long q(MultiBallControlPanel multiBallControlPanel, long j2) {
        long j3 = multiBallControlPanel.y + j2;
        multiBallControlPanel.y = j3;
        return j3;
    }

    private void setExpandBallVisible(boolean z) {
        ControlBallBean controlBallBean = this.s;
        if (controlBallBean != null) {
            MultiControlBallView multiControlBallView = this.j.get(controlBallBean);
            if (multiControlBallView != null) {
                multiControlBallView.setVisibility(z ? 0 : 8);
            }
            if (z) {
                this.s = null;
            }
        }
    }

    public void A0() {
        this.flControlPanel.post(new b());
    }

    public void B0(List<BaseBallBean> list) {
        w0();
        List<ControlBallBean> list2 = this.g;
        if (list2 != null) {
            list2.clear();
        }
        HashMap<ControlBallBean, MultiControlBallView> map = this.j;
        if (map != null) {
            map.clear();
        }
        this.x = 0;
        this.traditionalPanel.h();
        for (int i2 = 0; i2 < list.size(); i2++) {
            O0(list.get(i2), true);
        }
        this.ivControlModeFloat.setImageResource(this.A == 2 ? R.drawable.multi_rightfunction_cell_float_dark : R.drawable.multi_rightfunction_cell_float);
        TextView textView = this.tvControlModeFloat;
        Resources resources = getResources();
        int i3 = this.A;
        int i4 = R.color.multi_control_mode_unselect_color_dark;
        textView.setTextColor(resources.getColor(i3 == 2 ? R.color.multi_control_mode_unselect_color_dark : R.color.multi_control_mode_unselect_color));
        this.ivControlModeLoop.setImageResource(this.A == 2 ? R.drawable.multi_rightfunction_cell_loop_dark : R.drawable.multi_rightfunction_cell_loop);
        this.tvControlModeLoop.setTextColor(getResources().getColor(this.A == 2 ? R.color.multi_control_mode_unselect_color_dark : R.color.multi_control_mode_unselect_color));
        this.ivControlModeTrad.setImageResource(this.A == 2 ? R.drawable.multi_rightfunction_cell_traditional_dark : R.drawable.multi_rightfunction_cell_traditional);
        this.tvControlModeTrad.setTextColor(getResources().getColor(this.A == 2 ? R.color.multi_control_mode_unselect_color_dark : R.color.multi_control_mode_unselect_color));
        this.ivControlModeSlide.setImageResource(this.A == 2 ? R.drawable.multi_rightfunction_cell_slide_dark : R.drawable.multi_rightfunction_cell_slide);
        TextView textView2 = this.tvControlModeSlide;
        Resources resources2 = getResources();
        if (this.A != 2) {
            i4 = R.color.multi_control_mode_unselect_color;
        }
        textView2.setTextColor(resources2.getColor(i4));
        this.traditionalPanelLayout.setVisibility(4);
        this.flControlPanel.setVisibility(0);
        this.llControlModeLoop.setVisibility(0);
        this.llControlModeFloat.setVisibility(0);
        this.llControlModeTraditionalPanel.setVisibility(0);
        this.llSlide.setVisibility(8);
        this.llTraditionalChoose.setVisibility(8);
        this.flExpandPanel.removeAllViews();
        this.flExpandPanel.setVisibility(8);
    }

    public void C0() {
        this.y = 0L;
        this.z = 0L;
    }

    public final void D0() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ivMarker.getLayoutParams();
        int measuredHeight = this.tvMarker100.getMeasuredHeight();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.tvMarker100.getLayoutParams();
        layoutParams2.topMargin = layoutParams.topMargin - (measuredHeight / 2);
        layoutParams2.leftMargin = this.ivMarker.getWidth() + 8;
        this.tvMarker100.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.tvMarker0.getLayoutParams();
        layoutParams3.topMargin = ((this.flControlPanel.getMeasuredHeight() - layoutParams.bottomMargin) - r1) - 4;
        layoutParams3.leftMargin = this.ivMarker.getWidth() + 8;
        this.tvMarker0.setLayoutParams(layoutParams3);
    }

    public void E0(@NonNull boolean z, int i2) {
        if ("CHAT_SYNC_CONTROL".equals(this.c) || "GROUP_CHAT_DS_CONTROL".equals(this.c)) {
            if (z && this.llControlEndShow.getVisibility() == 8) {
                this.llControlEndShow.setVisibility(0);
                this.o += i2;
            } else if (!z && this.llControlEndShow.getVisibility() == 0) {
                this.llControlEndShow.setVisibility(8);
                this.o -= i2;
            }
            this.tvControlVisTimer.setVisibility(this.d ? 8 : 0);
            Z0();
            this.ivMarker.post(new c());
        }
    }

    public void F0() {
        this.w = false;
    }

    public final void G0(boolean z) {
        if (!z || this.x == 1) {
            return;
        }
        this.llControlModeLoop.setVisibility(0);
        this.llControlModeFloat.setVisibility(0);
        this.llControlModeTraditionalPanel.setVisibility(0);
        this.llSlide.setVisibility(8);
        this.llTraditionalChoose.setVisibility(8);
        this.x = 1;
        d1();
    }

    public void H0(int i2) {
        this.multiVelvoPanel.o(i2);
        if (i2 == 0) {
            this.multiControlFysPanel.t();
            if (this.x != 1) {
                this.traditionalPanelLayout.setVisibility(4);
                this.flControlPanel.setVisibility(0);
                G0(true);
                N(this.traditionalPanel.getListBalls());
            }
            this.flControlFysPanel.setVisibility(8);
            if (TextUtils.equals("REMOTE_CONTROL", this.c)) {
                this.llControlModeFysPanel.setVisibility(0);
            }
            this.llControlModeFysChoosePanel.setVisibility(8);
            o oVar = this.m;
            if (oVar != null) {
                oVar.s(false);
                return;
            }
            return;
        }
        if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            this.multiControlFysPanel.A(new MultiFysControlPanel.f() { // from class: dc.zo3
                @Override // com.wear.widget.control.multiToys.MultiFysControlPanel.f
                public final void a(boolean z) {
                    this.a.g0(z);
                }
            });
            return;
        }
        this.multiControlFysPanel.t();
        if (this.x != 3) {
            this.traditionalPanel.setDatas(this.g);
            this.x = 3;
            this.traditionalPanelLayout.setVisibility(0);
            this.flControlPanel.setVisibility(4);
            this.llControlModeLoop.setVisibility(8);
            this.llControlModeFloat.setVisibility(8);
            this.llControlModeTraditionalPanel.setVisibility(8);
            this.llSlide.setVisibility(0);
            this.llTraditionalChoose.setVisibility(0);
            d1();
            setExpandPanelGone();
        }
        this.flControlFysPanel.setVisibility(8);
        if (TextUtils.equals("REMOTE_CONTROL", this.c)) {
            this.llControlModeFysPanel.setVisibility(0);
        }
        this.llControlModeFysChoosePanel.setVisibility(8);
        o oVar2 = this.m;
        if (oVar2 != null) {
            oVar2.s(false);
        }
    }

    public void I0() {
        this.k = null;
    }

    public void J0() {
        this.m = null;
    }

    public void K0() {
        this.l = null;
    }

    public final void L0(ControlBallBean controlBallBean, MultiControlBallView multiControlBallView) throws IllegalArgumentException {
        int controlMode = controlBallBean.getControlMode();
        if (controlMode == 0) {
            l0(multiControlBallView, controlBallBean.getOriginalLocation()[0], controlBallBean.getOriginalLocation()[1]);
            controlBallBean.resetCurrentLocation();
            controlBallBean.setProgress(0);
            controlBallBean.setLoopIndex(0);
            controlBallBean.getDatas().clear();
        } else if (controlMode == 2) {
            if (!controlBallBean.isLongPressed()) {
                r0(controlBallBean);
                String strValueOf = String.valueOf((controlBallBean.getProgress() / 5) * 5);
                if (controlBallBean.getControlMode() == 2) {
                    controlBallBean.getDatas().add(strValueOf);
                }
            }
            controlBallBean.setLooping(false);
        }
        this.guideLinePanel.c(controlBallBean);
        this.guideLinePanel.invalidate();
        c1(true);
        this.h.remove(multiControlBallView);
        this.i.remove(controlBallBean);
        n nVar = this.l;
        if (nVar != null) {
            nVar.c(this.i);
        }
        if (multiControlBallView.n(this.d)) {
            this.g.remove(controlBallBean);
            this.j.remove(controlBallBean);
            if (this.r == controlBallBean) {
                this.r = null;
            }
            M0();
            this.v = true;
        } else {
            multiControlBallView.c();
            if (Build.VERSION.SDK_INT >= 21) {
                multiControlBallView.setElevation(multiControlBallView.ivControlMode.getVisibility() == 0 ? 1.0f : 0.0f);
            }
        }
        if (this.h.isEmpty()) {
            if (this.v) {
                W0();
                M0();
                U0();
            }
            this.v = false;
        }
        controlBallBean.setMoving(false);
    }

    public final void M(BaseBallBean baseBallBean, boolean z) throws Resources.NotFoundException, IllegalArgumentException {
        if (baseBallBean.isSelected()) {
            ControlBallBean controlBallBean = new ControlBallBean();
            controlBallBean.getBaseBallBeans().add(baseBallBean);
            MultiControlBallView multiControlBallViewM0 = m0(controlBallBean);
            boolean zIsEmpty = z ? this.g.isEmpty() : true;
            this.g.add(controlBallBean);
            if (zIsEmpty) {
                S0(controlBallBean);
            }
            W0();
            M0();
            if (this.o <= 0 && this.n >= 0) {
                g1();
                D0();
            }
            U0();
            if (!(multiControlBallViewM0.getX() == 0.0f && multiControlBallViewM0.getY() == 0.0f) && this.g.contains(controlBallBean) && this.j.containsValue(multiControlBallViewM0)) {
                try {
                    ViewGroup viewGroup = (ViewGroup) multiControlBallViewM0.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(multiControlBallViewM0);
                    }
                    this.flControlPanel.addView(multiControlBallViewM0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void M0() throws IllegalArgumentException {
        Iterator<ControlBallBean> it = this.g.iterator();
        while (it.hasNext()) {
            N0(it.next());
        }
    }

    public final void N(@NonNull List<ControlBallBean> list) throws IllegalArgumentException {
        if (list == null) {
            return;
        }
        if (WearUtils.A.toJson(this.g).equals(WearUtils.A.toJson(list))) {
            for (ControlBallBean controlBallBean : list) {
                if (controlBallBean.getControlMode() != 1) {
                    for (ControlBallBean controlBallBean2 : this.j.keySet()) {
                        if (TextUtils.equals(controlBallBean2.getId(), controlBallBean.getId())) {
                            controlBallBean2.setControlMode(1);
                            this.j.get(controlBallBean2).u(1, controlBallBean.getBaseBallBeans().get(0).getToyFun(), true);
                        }
                    }
                }
            }
            return;
        }
        List<ControlBallBean> list2 = this.g;
        if (list2 != null) {
            if (list2.size() > 0) {
                Iterator<ControlBallBean> it = this.g.iterator();
                while (it.hasNext()) {
                    this.flControlPanel.removeView(this.j.get(it.next()));
                }
            }
            this.g.clear();
            this.j.clear();
        } else {
            this.g = Collections.synchronizedList(new ArrayList());
        }
        this.g.addAll(list);
        if (this.g.size() > 0) {
            for (ControlBallBean controlBallBean3 : this.g) {
                controlBallBean3.setControlMode(1);
                this.flControlPanel.addView(m0(controlBallBean3));
            }
            S0(this.g.get(0));
            Y0(true);
            M0();
            V0();
        }
    }

    public final void N0(ControlBallBean controlBallBean) throws IllegalArgumentException {
        MultiControlBallView multiControlBallView = this.j.get(controlBallBean);
        if (multiControlBallView != null) {
            if (controlBallBean.isMergeBall()) {
                multiControlBallView.B();
            } else {
                multiControlBallView.w();
                multiControlBallView.v();
            }
        }
    }

    public void O() {
        this.multiVelvoPanel.c();
    }

    public void O0(BaseBallBean baseBallBean, boolean z) {
        if (baseBallBean == null) {
            return;
        }
        if (!baseBallBean.isSelected()) {
            this.multiVelvoPanel.q(baseBallBean);
            if (this.x == 3) {
                this.traditionalPanel.i(baseBallBean);
                return;
            } else {
                y0(baseBallBean);
                return;
            }
        }
        if (!z) {
            this.multiVelvoPanel.b(baseBallBean);
        }
        if (this.x == 3) {
            this.traditionalPanel.d(baseBallBean, z);
        } else {
            M(baseBallBean, z);
        }
    }

    public void P(String str) {
        this.multiVelvoPanel.setMultiPanelType(str);
    }

    public void P0(@NonNull List<BaseBallBean> list) {
        if (list == null) {
            return;
        }
        if (this.x == 3) {
            this.traditionalPanel.j(list);
        } else {
            Q0(list);
        }
    }

    public final boolean Q(float f2, float f3, float f4, float f5) {
        return Math.abs(f4 - f2) <= 15.0f && Math.abs(f5 - f3) <= 15.0f;
    }

    public final void Q0(@NonNull List<BaseBallBean> list) throws Resources.NotFoundException, IllegalArgumentException {
        boolean z;
        if (list == null) {
            return;
        }
        if (this.g == null) {
            this.g = new ArrayList();
        }
        ArrayList<BaseBallBean> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        if (this.g.size() > 0) {
            Iterator<ControlBallBean> it = this.g.iterator();
            while (it.hasNext()) {
                for (BaseBallBean baseBallBean : it.next().getBaseBallBeans()) {
                    Iterator<BaseBallBean> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        BaseBallBean next = it2.next();
                        if (baseBallBean.isEqual(MultiControlPanel.A, next.getToyAddress(), next.getToyFun())) {
                            map.put(baseBallBean, next);
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        arrayList.add(baseBallBean);
                    }
                }
            }
        }
        if (list.size() > 0) {
            for (BaseBallBean baseBallBean2 : list) {
                Iterator<ControlBallBean> it3 = this.g.iterator();
                boolean z2 = false;
                while (it3.hasNext()) {
                    Iterator<BaseBallBean> it4 = it3.next().getBaseBallBeans().iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            BaseBallBean next2 = it4.next();
                            if (baseBallBean2.isEqual(MultiControlPanel.A, next2.getToyAddress(), next2.getToyFun())) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                }
                if (!z2) {
                    arrayList2.add(baseBallBean2);
                }
            }
        }
        for (BaseBallBean baseBallBean3 : arrayList) {
            z0(baseBallBean3);
            y0(baseBallBean3);
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            M((BaseBallBean) it5.next(), false);
        }
        for (BaseBallBean baseBallBean4 : map.keySet()) {
            BaseBallBean baseBallBean5 = (BaseBallBean) map.get(baseBallBean4);
            if (baseBallBean5 != null) {
                R0(baseBallBean4, baseBallBean5);
            }
        }
        i1(list);
    }

    public void R() {
        MultiControlPanel.l lVar = this.F;
        if (lVar != null) {
            lVar.c();
        }
    }

    public final void R0(BaseBallBean baseBallBean, BaseBallBean baseBallBean2) throws IllegalArgumentException {
        ControlBallBean controlBallBean;
        int size;
        String toyFun = baseBallBean.getToyFun();
        String toyFun2 = baseBallBean2.getToyFun();
        if (toyFun == null || toyFun2 == null) {
            return;
        }
        if (toyFun.equals("t") || toyFun.equals("pos")) {
            if ((toyFun2.equals("t") || toyFun2.equals("pos")) && !toyFun.equals(toyFun2)) {
                ControlBallBean controlBallBean2 = null;
                MultiControlBallView multiControlBallView = null;
                for (ControlBallBean controlBallBean3 : this.j.keySet()) {
                    Iterator<BaseBallBean> it = controlBallBean3.getBaseBallBeans().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        BaseBallBean next = it.next();
                        if (next == baseBallBean) {
                            if (uu1.g(next.getSymbol())) {
                                controlBallBean3.setProgress(0);
                            }
                            multiControlBallView = this.j.get(controlBallBean3);
                            controlBallBean2 = controlBallBean3;
                        }
                    }
                }
                if (controlBallBean2 == null || multiControlBallView == null) {
                    return;
                }
                List<BaseBallBean> baseBallBeans = controlBallBean2.getBaseBallBeans();
                baseBallBeans.remove(baseBallBean);
                baseBallBeans.add(baseBallBean2);
                multiControlBallView.i(controlBallBean2);
                if (this.flExpandPanel.getVisibility() != 0 || (controlBallBean = (ControlBallBean) multiControlBallView.getTag()) == null || (size = controlBallBean.getBaseBallBeans().size()) <= 1) {
                    return;
                }
                e1(multiControlBallView, controlBallBean, size);
            }
        }
    }

    public final void S(Disposable disposable) {
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        disposable.dispose();
    }

    public final void S0(ControlBallBean controlBallBean) {
        this.r = controlBallBean;
        Iterator<ControlBallBean> it = this.g.iterator();
        while (it.hasNext()) {
            ControlBallBean next = it.next();
            next.setActivate(next == controlBallBean);
            MultiControlBallView multiControlBallView = this.j.get(next);
            if (multiControlBallView != null) {
                multiControlBallView.ivActivate.setVisibility(next.isActivate() ? 0 : 4);
            }
        }
    }

    public void T() {
        Disposable disposable = this.t;
        if (disposable != null && !disposable.isDisposed()) {
            this.t.dispose();
            this.t = null;
            this.y = 0L;
            this.tvTimer.setText("00:00");
        }
        List<ControlBallBean> list = this.g;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<ControlBallBean> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().getDatas().clear();
        }
    }

    public final void T0(ControlBallBean controlBallBean, MultiControlBallView multiControlBallView) {
        if (controlBallBean.getControlMode() == 0 || multiControlBallView == null) {
            return;
        }
        float currentSize = multiControlBallView.getCurrentSize();
        float size = controlBallBean.getSize() / 2.0f;
        float x = (multiControlBallView.getX() + size) - multiControlBallView.f();
        float y = (multiControlBallView.getY() + size) - multiControlBallView.f();
        if (x < 0.0f) {
            x = 0.0f;
        } else if (x + currentSize > this.flControlPanel.getWidth()) {
            x = this.flControlPanel.getWidth() - currentSize;
        }
        int i2 = this.n;
        if (y < i2) {
            y = i2 - multiControlBallView.f();
        } else {
            int i3 = this.o;
            if (y > i3) {
                y = i3 + multiControlBallView.f();
            }
        }
        multiControlBallView.x(x, y);
    }

    public final void U(MultiControlBallView multiControlBallView) {
        c1(false);
        this.h.add(multiControlBallView);
        this.i.add((ControlBallBean) multiControlBallView.getTag());
    }

    public final void U0() {
        int size = this.g.size();
        if (size == 0) {
            return;
        }
        int width = this.flControlPanel.getWidth();
        if (width == 0) {
            width = gg3.e(getContext()) - ce3.a(getContext(), 2.1311656E9f);
        }
        this.flControlPanel.getHeight();
        int iMin = Math.min(size, 6);
        float fFloatValue = new BigDecimal(width).divide(new BigDecimal(iMin * 2), 4, 4).floatValue();
        String str = "decimal:" + fFloatValue;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = i2 / 6;
            int i4 = i2 % 6;
            ControlBallBean controlBallBean = this.g.get(i2);
            MultiControlBallView multiControlBallView = this.j.get(controlBallBean);
            if (multiControlBallView != null) {
                if (iMin == 6) {
                    controlBallBean.getOriginalLocation()[0] = i4 * (multiControlBallView.getCurrentSize() - multiControlBallView.getCurrentMargin());
                } else {
                    controlBallBean.getOriginalLocation()[0] = (((i4 * 2) + 1) * fFloatValue) - multiControlBallView.f();
                }
                controlBallBean.getOriginalLocation()[1] = (this.o - multiControlBallView.f()) - (i3 * (multiControlBallView.getCurrentSize() - multiControlBallView.getCurrentMargin()));
                if (!this.i.contains(controlBallBean)) {
                    if (controlBallBean.getControlMode() == 0) {
                        multiControlBallView.x(controlBallBean.getOriginalLocation()[0], controlBallBean.getOriginalLocation()[1]);
                    } else if (controlBallBean.getControlMode() == 1 && controlBallBean.getCurrentLocation()[1] == 0.0f) {
                        multiControlBallView.x(controlBallBean.getOriginalLocation()[0], controlBallBean.getOriginalLocation()[1]);
                    }
                }
            }
        }
    }

    public final void V(ControlBallBean controlBallBean, MultiControlBallView multiControlBallView) throws Resources.NotFoundException, IllegalArgumentException {
        int controlMode;
        MultiControlBallView multiControlBallView2;
        if (e0(multiControlBallView.llBall, this.a)) {
            l0(multiControlBallView, controlBallBean.getOriginalLocation()[0], controlBallBean.getOriginalLocation()[1]);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) multiControlBallView.getParent();
        int iY0 = y0(controlBallBean.getBaseBallBeans().get(0));
        M(controlBallBean.getBaseBallBeans().get(0), false);
        viewGroup.removeView(multiControlBallView);
        ControlBallBean controlBallBean2 = this.s;
        if (controlBallBean2 != null && (controlMode = controlBallBean2.getControlMode()) != 0 && (multiControlBallView2 = this.j.get(this.s)) != null) {
            multiControlBallView2.t(controlMode, this.s.getBaseBallBeans().get(0).getToyFun());
        }
        if (iY0 == 1) {
            viewGroup.setVisibility(8);
            setExpandBallVisible(true);
        }
    }

    public final void V0() {
        int size = this.g.size();
        if (size == 0) {
            return;
        }
        int width = this.flControlPanel.getWidth();
        if (width == 0) {
            width = gg3.e(getContext()) - ce3.a(getContext(), 2.1311656E9f);
        }
        this.flControlPanel.getHeight();
        int iMin = Math.min(size, 6);
        float fFloatValue = new BigDecimal(width).divide(new BigDecimal(iMin * 2), 4, 4).floatValue();
        String str = "decimal:" + fFloatValue;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = i2 % 6;
            ControlBallBean controlBallBean = this.g.get(i2);
            MultiControlBallView multiControlBallView = this.j.get(controlBallBean);
            int currentSize = (multiControlBallView.getCurrentSize() - multiControlBallView.getCurrentMargin()) * (i2 / 6);
            if (iMin == 6) {
                controlBallBean.getOriginalLocation()[0] = i3 * (multiControlBallView.getCurrentSize() - multiControlBallView.getCurrentMargin());
            } else {
                controlBallBean.getOriginalLocation()[0] = (((i3 * 2) + 1) * fFloatValue) - multiControlBallView.f();
            }
            controlBallBean.getOriginalLocation()[1] = (this.o - multiControlBallView.f()) - (r6 * (multiControlBallView.getCurrentSize() - multiControlBallView.getCurrentMargin()));
            float f2 = controlBallBean.getOriginalLocation()[0];
            int i4 = this.o;
            float fW = W(controlBallBean.getProgress(), multiControlBallView.f(), (i4 - (((i4 - this.n) * controlBallBean.getProgress()) / 100)) - multiControlBallView.f());
            if (controlBallBean.getProgress() == 0) {
                fW -= currentSize;
            }
            if (multiControlBallView != null && controlBallBean.getControlMode() == 1) {
                multiControlBallView.x(f2, fW);
            }
            if (controlBallBean.getProgress() <= 0) {
                controlBallBean.getCurrentLocation()[0] = 0.0f;
                controlBallBean.getCurrentLocation()[1] = 0.0f;
            } else {
                controlBallBean.getCurrentLocation()[0] = f2 + multiControlBallView.f();
                controlBallBean.getCurrentLocation()[1] = fW - multiControlBallView.f();
            }
        }
    }

    public final float W(int i2, float f2, float f3) {
        boolean z = false;
        while (!z) {
            int iX = X(f2, f3);
            if (iX != i2) {
                f3 = iX > i2 ? f3 + 1.0f : f3 - 1.0f;
            } else {
                z = true;
            }
        }
        return f3;
    }

    public final void W0() {
        Y0(false);
    }

    public final int X(float f2, float f3) {
        float f4 = f3 + f2;
        int i2 = this.o;
        int i3 = this.n;
        float f5 = (i2 - i3) / 100.0f;
        if (f4 < i3) {
            f4 = i3;
        } else if (f4 > i2) {
            f4 = i2;
        }
        int i4 = (int) (100.0f - ((f4 - i3) / f5));
        if (i4 == 0 && f4 < i2 - 8) {
            i4 = 1;
        }
        if (i4 < 0) {
            return 0;
        }
        if (i4 > 100) {
            return 100;
        }
        return i4;
    }

    public final void X0(int i2, ControlBallBean controlBallBean, boolean z) {
        MultiControlBallView multiControlBallView = this.j.get(controlBallBean);
        if (multiControlBallView != null) {
            if (multiControlBallView.getCurrentSizeLevel() != i2 || z) {
                multiControlBallView.setCurrentSizeLevel(i2);
                multiControlBallView.q();
                multiControlBallView.y();
                T0(controlBallBean, multiControlBallView);
                controlBallBean.setSize(multiControlBallView.getCurrentSize());
            }
        }
    }

    public final void Y() {
        this.g = Collections.synchronizedList(new ArrayList());
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new HashMap<>();
        this.x = 0;
        d0();
        b0();
    }

    public final void Y0(boolean z) {
        int size = this.g.size();
        if (size == 0) {
            return;
        }
        int i2 = size < 3 ? 1 : 2;
        Iterator<ControlBallBean> it = this.g.iterator();
        while (it.hasNext()) {
            X0(i2, it.next(), z);
        }
    }

    public void Z(List<BaseBallBean> list) {
        w0();
        List<ControlBallBean> list2 = this.g;
        if (list2 != null) {
            list2.clear();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            O0(list.get(i2), true);
        }
        i1(list);
    }

    public final void Z0() {
        U0();
        for (ControlBallBean controlBallBean : this.g) {
            MultiControlBallView multiControlBallView = this.j.get(controlBallBean);
            if (multiControlBallView != null && (controlBallBean.getControlMode() == 2 || controlBallBean.getControlMode() == 1)) {
                multiControlBallView.setY((((this.o - this.n) * (1.0f - (new BigDecimal(controlBallBean.getProgress()).floatValue() / 100.0f))) + this.n) - multiControlBallView.f());
            }
        }
    }

    @Override // com.wear.widget.control.multiToys.MultiFysControlPanel.g
    public void a(Toy toy) {
        o oVar;
        if (this.x != 4 || (oVar = this.m) == null) {
            return;
        }
        oVar.o(toy);
    }

    public void a0(String str, List<Toy> list) {
        this.c = str;
        if ("CHAT_LIVE_CONTROL".equals(str)) {
            this.llControlEnd.setVisibility(0);
            this.tvControlTimer.setVisibility(this.d ? 8 : 0);
        } else if ("CHAT_SYNC_CONTROL".equals(str)) {
            this.llControlling.setVisibility(0);
            this.llControlEndShow.setVisibility(8);
        } else if ("CREATE_PATTERN".equals(str)) {
            this.llTimer.setVisibility(0);
        }
        this.x = 0;
        d1();
        this.traditionalPanelLayout.setVisibility(4);
        this.flControlPanel.setVisibility(0);
        if (TextUtils.equals(str, "REMOTE_CONTROL")) {
            this.multiControlFysPanel.D(this);
            this.multiControlFysPanel.setFysCommandListener(new MultiFysControlPanel.d() { // from class: dc.hp3
                @Override // com.wear.widget.control.multiToys.MultiFysControlPanel.d
                public final void a(List list2) {
                    this.a.o0(list2);
                }
            });
            this.multiControlFysPanel.v(list);
            this.llControlModeFysPanel.setVisibility(0);
        } else {
            this.llControlModeFysPanel.setVisibility(8);
        }
        this.llControlModeLoop.setVisibility(0);
        this.llControlModeFloat.setVisibility(0);
        this.llControlModeTraditionalPanel.setVisibility("CREATE_PATTERN".equals(str) ? 8 : 0);
        this.llSlide.setVisibility(8);
        this.llTraditionalChoose.setVisibility(8);
        if (this.g == null) {
            this.g = Collections.synchronizedList(new ArrayList());
        }
        if (this.h == null) {
            this.h = new ArrayList();
        }
        if (this.i == null) {
            this.i = new ArrayList();
        }
        if (this.j == null) {
            this.j = new HashMap<>();
        }
        this.traditionalPanel.g();
        c0();
        if ("CHAT_LIVE_CONTROL".equals(str) || "CHAT_VIDEO_CONTROL".equals(str) || "CHAT_VOICE_CONTROL".equals(str) || "CHAT_SYNC_CONTROL".equals(str) || "GROUP_CHAT_SYNC_CONTROL".equals(str) || "GROUP_CHAT_DS_CONTROL".equals(str)) {
            this.bottomLine.setVisibility(8);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mutli_toys_control_mode_icon_weight);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mutli_toys_control_right_martop);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.llControlModeChoosePanel.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelSize2;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = 0;
            this.llControlModeChoosePanel.setLayoutParams(layoutParams);
            ImageView[] imageViewArr = {this.ivControlModeLoop, this.ivControlModeFloat, this.ivControlModeTrad, this.ivControlModeSlide, this.ivTraditionalChoose, this.ivControlling, this.ivControlEnd, this.ivControlTimer};
            for (int i2 = 0; i2 < 8; i2++) {
                ImageView imageView = imageViewArr[i2];
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.bottomMargin = 0;
                layoutParams2.width = dimensionPixelSize;
                layoutParams2.height = dimensionPixelSize;
                imageView.setLayoutParams(layoutParams2);
            }
        }
    }

    public void a1(@NonNull List<BaseBallBean> list) {
        if (list == null) {
            return;
        }
        this.traditionalPanel.j(list);
        Q0(list);
    }

    @Override // com.wear.widget.control.multiToys.MultiBallTraditionalPanel.b
    public void b(List<BaseBallBean> list) {
        this.multiVelvoPanel.g(list, this.c);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void b0() {
        this.p = new d();
        this.flControlPanel.setOnTouchListener(new e());
        this.q = new f();
        this.flExpandPanel.setOnTouchListener(new g());
        this.a.setOnClickListener(new h());
        this.traditionalPanel.setTradOnTouchListener(this);
    }

    public final void b1(ControlBallBean controlBallBean) {
        int controlMode = controlBallBean.getControlMode();
        int i2 = this.x;
        if (controlMode != i2) {
            controlBallBean.setControlMode(i2);
            MultiControlBallView multiControlBallView = this.j.get(controlBallBean);
            if (multiControlBallView != null) {
                if (this.x == 0) {
                    multiControlBallView.ivControlMode.setVisibility(8);
                    return;
                }
                multiControlBallView.ivControlMode.setVisibility(0);
                multiControlBallView.t(this.x, controlBallBean.getBaseBallBeans().get(0).getToyFun());
            }
        }
    }

    @Override // com.wear.widget.control.multiToys.MultiBallTraditionalPanel.b
    public void c(List<ControlBallBean> list) {
        n nVar = this.l;
        if (nVar != null) {
            nVar.c(list);
        }
    }

    public void c0() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.t = Observable.interval(100L, timeUnit).map(new j()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i());
        this.u = Observable.interval(100L, timeUnit).map(new l()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k());
    }

    public final void c1(boolean z) {
        this.llControlModeLoop.setEnabled(z);
        this.llControlModeFloat.setEnabled(z);
        this.llControlModeTraditionalPanel.setEnabled(z);
        this.llControlModeFysPanel.setEnabled(z);
    }

    @Override // com.wear.widget.control.multiToys.MultiBallTraditionalPanel.b
    public void d() {
        n nVar = this.l;
        if (nVar != null) {
            nVar.e();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void d0() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        this.f = layoutInflaterFrom;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.layout_multi_ball_control_panel, (ViewGroup) null);
        this.B = viewInflate;
        addView(viewInflate);
        ButterKnife.bind(this, this.B);
        if (Build.VERSION.SDK_INT >= 21) {
            this.flExpandPanel.setElevation(4.0f);
        }
        this.a = new View(getContext());
    }

    public final void d1() {
        if (this.A == 2) {
            this.ivControlModeLoop.setImageResource(this.x == 2 ? R.drawable.multi_rightfunction_cell_loop_choose_dark : R.drawable.multi_rightfunction_cell_loop_dark);
            TextView textView = this.tvControlModeLoop;
            Resources resources = getResources();
            int i2 = this.x;
            int i3 = R.color.multi_control_mode_select_color_dark;
            textView.setTextColor(resources.getColor(i2 == 2 ? R.color.multi_control_mode_select_color_dark : R.color.multi_control_mode_unselect_color_dark));
            this.ivControlModeFloat.setImageResource(this.x == 1 ? R.drawable.multi_rightfunction_cell_float_choose_dark : R.drawable.multi_rightfunction_cell_float_dark);
            TextView textView2 = this.tvControlModeFloat;
            Resources resources2 = getResources();
            if (this.x != 1) {
                i3 = R.color.multi_control_mode_unselect_color_dark;
            }
            textView2.setTextColor(resources2.getColor(i3));
            return;
        }
        this.ivControlModeLoop.setImageResource(this.x == 2 ? R.drawable.multi_rightfunction_cell_loop_choose : R.drawable.multi_rightfunction_cell_loop);
        TextView textView3 = this.tvControlModeLoop;
        Resources resources3 = getResources();
        int i4 = this.x;
        int i5 = R.color.multi_control_mode_select_color;
        textView3.setTextColor(resources3.getColor(i4 == 2 ? R.color.multi_control_mode_select_color : R.color.multi_control_mode_unselect_color));
        this.ivControlModeFloat.setImageResource(this.x == 1 ? R.drawable.multi_rightfunction_cell_float_choose : R.drawable.multi_rightfunction_cell_float);
        TextView textView4 = this.tvControlModeFloat;
        Resources resources4 = getResources();
        if (this.x != 1) {
            i5 = R.color.multi_control_mode_unselect_color;
        }
        textView4.setTextColor(resources4.getColor(i5));
    }

    public final boolean e0(View view, View view2) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view2.getGlobalVisibleRect(rect2);
        return Rect.intersects(rect, rect2);
    }

    public final void e1(MultiControlBallView multiControlBallView, ControlBallBean controlBallBean, int i2) throws IllegalArgumentException {
        int iE = multiControlBallView.e(3);
        double d2 = iE;
        String str = this.c;
        int i3 = (int) ((str == "REMOTE_CONTROL" ? 0.6d : 0.3d) * d2);
        int i4 = (int) ((str == "REMOTE_CONTROL" ? 0.3d : 0.15d) * d2);
        int i5 = (int) (d2 * (str != "REMOTE_CONTROL" ? 0.3d : 0.6d));
        int iA = ce3.a(getContext(), 38.0f);
        int i6 = 2;
        int i7 = 0;
        int iIntValue = 0;
        while (true) {
            if (i6 > 5) {
                i6 = 2;
                break;
            }
            iIntValue = new BigDecimal(i2).divide(new BigDecimal(i6), 0, RoundingMode.UP).intValue();
            i7 = (iIntValue * iE) + ((iIntValue - 1) * i4) + (i3 * 2);
            if (i7 < this.flControlPanel.getHeight() - iA) {
                break;
            } else {
                i6++;
            }
        }
        int i8 = (i6 * iE) + ((i6 - 1) * i5) + (i3 * 2);
        float x = multiControlBallView.getX();
        float y = multiControlBallView.getY();
        float f2 = i8;
        if (f2 > this.flControlPanel.getWidth() - x) {
            x = (x + multiControlBallView.getCurrentSize()) - f2;
            if (x < 0.0f) {
                x = 0.0f;
            }
        }
        if (i7 > this.flControlPanel.getHeight() - y) {
            y = this.flControlPanel.getHeight() - i7;
            float f3 = iA;
            if (y < f3) {
                y = f3;
            }
        }
        this.flExpandPanel.removeAllViews();
        this.flExpandPanel.setVisibility(0);
        multiControlBallView.setVisibility(8);
        this.s = controlBallBean;
        setExpandBallVisible(false);
        l1();
        this.a.setLayoutParams(new FrameLayout.LayoutParams(i8, i7));
        this.a.setX(x);
        this.a.setY(y);
        this.a.setBackground(th4.d(getContext(), this.A == 2 ? R.drawable.shape_multi_control_expand_panel_bg_dark : R.drawable.shape_multi_control_expand_panel_bg));
        this.flExpandPanel.addView(this.a);
        for (int i9 = 0; i9 < controlBallBean.getBaseBallBeans().size(); i9++) {
            ControlBallBean controlBallBean2 = new ControlBallBean();
            controlBallBean2.getBaseBallBeans().add(controlBallBean.getBaseBallBeans().get(i9));
            if (i9 % i6 == 0) {
                controlBallBean2.getOriginalLocation()[0] = i3;
            } else {
                controlBallBean2.getOriginalLocation()[0] = (r9 * (iE + i5)) + i3;
            }
            float[] originalLocation = controlBallBean2.getOriginalLocation();
            originalLocation[0] = originalLocation[0] + this.a.getX();
            controlBallBean2.getOriginalLocation()[1] = (((iIntValue - (i9 / i6)) - 1) * (iE + i4)) + i3 + this.a.getY();
            MultiControlBallView multiControlBallView2 = new MultiControlBallView(getContext(), this.c);
            this.b = multiControlBallView2;
            multiControlBallView2.i(controlBallBean2);
            this.b.setElevation(5.0f);
            this.flExpandPanel.addView(this.b);
            this.b.setCurrentSizeLevel(3);
            this.b.r(iE);
            this.b.z(multiControlBallView.d(3));
            this.b.w();
            this.b.v();
            controlBallBean2.setSize(this.b.getCurrentSize());
            this.b.setOnTouchListener(this.q);
        }
    }

    public void f1(int i2) {
        if (i2 == 0) {
            this.ivControlling.setImageResource(R.drawable.chat_sync_toolbar_interactive);
            this.tvControlling.setText(ah4.e(R.string.chat_control_ldr_ways));
        } else if (i2 == 1) {
            this.ivControlling.setImageResource(R.drawable.multi_toys_chat_controlling);
            this.tvControlling.setText(ah4.e(R.string.patterns_in_control));
        } else if (i2 == 2) {
            this.ivControlling.setImageResource(R.drawable.chat_sync_toolbar_controlling);
            this.tvControlling.setText(ah4.e(R.string.patterns_begin_control));
        }
    }

    public final void g1() throws Resources.NotFoundException {
        int measuredHeight = this.flControlPanel.getMeasuredHeight();
        if (measuredHeight == 0) {
            measuredHeight = WearUtils.x.getResources().getDimensionPixelSize(R.dimen.mutli_toys_sync_control_panel_height);
        }
        float f2 = (TextUtils.equals("REMOTE_CONTROL", this.c) || TextUtils.equals("CREATE_PATTERN", this.c)) ? 0.169f : 0.25f;
        float f3 = (TextUtils.equals("REMOTE_CONTROL", this.c) || TextUtils.equals("CREATE_PATTERN", this.c)) ? 0.085f : 0.12f;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ivMarker.getLayoutParams();
        float f4 = measuredHeight;
        layoutParams.topMargin = (int) (f2 * f4);
        layoutParams.bottomMargin = (int) (f3 * f4);
        this.ivMarker.setLayoutParams(layoutParams);
        this.o = (measuredHeight - layoutParams.bottomMargin) - 2;
        this.n = layoutParams.topMargin + 2;
    }

    public int getCurrControlMode() {
        return this.x;
    }

    public Toy getFysSelectToy() {
        return this.multiControlFysPanel.getSelectedToy();
    }

    public long getTime() {
        return this.z;
    }

    public final void h0(MultiControlBallView multiControlBallView) throws IllegalArgumentException {
        int size;
        ControlBallBean controlBallBean = (ControlBallBean) multiControlBallView.getTag();
        this.multiVelvoPanel.c();
        if (controlBallBean == null || (size = controlBallBean.getBaseBallBeans().size()) <= 1 || this.flExpandPanel.getVisibility() == 0) {
            return;
        }
        e1(multiControlBallView, controlBallBean, size);
    }

    public void h1(@NonNull String str, boolean z) {
        this.multiControlFysPanel.J(str, z);
    }

    public final void i0(MotionEvent motionEvent, View view, MultiControlBallView multiControlBallView) {
        k0(view, multiControlBallView, motionEvent.getX(), motionEvent.getY(), motionEvent.getRawX(), motionEvent.getRawY());
    }

    public final void i1(@NonNull List<BaseBallBean> list) {
        this.multiVelvoPanel.g(list, this.c);
    }

    public final void j0(MotionEvent motionEvent, MultiControlBallView multiControlBallView) {
        float rawX = motionEvent.getRawX();
        this.flControlPanel.getLocationOnScreen(this.C);
        k0(this.flControlPanel, multiControlBallView, rawX, motionEvent.getRawY() - this.C[1], rawX, motionEvent.getRawY());
    }

    public void j1() {
        if (my2.i.a().getB()) {
            return;
        }
        HashMap map = new HashMap();
        int i2 = this.x;
        if (i2 == 1) {
            map.put("type", "Float");
        } else if (i2 == 2) {
            map.put("type", "Loop");
        } else if (i2 == 3) {
            map.put("type", "TraditionalPanel");
        }
        if (map.isEmpty()) {
            return;
        }
        ye3.d("M0042", WearUtils.A.toJson(map));
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0007 A[PHI: r0
  0x0007: PHI (r0v6 int) = (r0v0 int), (r0v1 int) binds: [B:3:0x0005, B:6:0x000e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void k0(android.view.View r3, com.wear.widget.control.multiToys.MultiControlBallView r4, float r5, float r6, float r7, float r8) {
        /*
            r2 = this;
            int r0 = r2.n
            float r1 = (float) r0
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 > 0) goto L9
        L7:
            float r6 = (float) r0
            goto L11
        L9:
            int r0 = r2.o
            float r1 = (float) r0
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 <= 0) goto L11
            goto L7
        L11:
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r1 = r4.f()
            float r0 = r0 - r1
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L2b
            int r3 = r3.getWidth()
            float r3 = (float) r3
            float r5 = r4.f()
            float r5 = r3 - r5
            goto L37
        L2b:
            float r3 = r4.f()
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 >= 0) goto L37
            float r5 = r4.f()
        L37:
            float r3 = r4.f()
            float r5 = r5 - r3
            float r3 = r4.f()
            float r6 = r6 - r3
            r2.l0(r4, r5, r6)
            com.wear.bean.controlmutlitoys.ControlBallBean r3 = r2.r
            r5 = 0
            if (r3 == 0) goto L58
            float[] r3 = r3.getCurrentLocation()
            r3[r5] = r7
            com.wear.bean.controlmutlitoys.ControlBallBean r3 = r2.r
            float[] r3 = r3.getCurrentLocation()
            r6 = 1
            r3[r6] = r8
        L58:
            com.wear.widget.control.multiToys.MultiBallGuideLinePanel r3 = r2.guideLinePanel
            com.wear.bean.controlmutlitoys.ControlBallBean r6 = r2.r
            float r7 = r4.getY()
            float r8 = r4.f()
            float r7 = r7 + r8
            r3.d(r6, r7)
            com.wear.widget.control.multiToys.MultiBallGuideLinePanel r3 = r2.guideLinePanel
            r3.invalidate()
            r2.c1(r5)
            r3 = 1077936128(0x40400000, float:3.0)
            r4.setElevation(r3)
            java.lang.Object r3 = r4.getTag()
            com.wear.bean.controlmutlitoys.ControlBallBean r3 = (com.wear.bean.controlmutlitoys.ControlBallBean) r3
            if (r3 == 0) goto L80
            r2.r0(r3)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.multiToys.MultiBallControlPanel.k0(android.view.View, com.wear.widget.control.multiToys.MultiControlBallView, float, float, float, float):void");
    }

    public void k1() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ("REMOTE_CONTROL".equals(this.c)) {
            long j2 = this.e;
            if (jCurrentTimeMillis > 5000 + j2 && j2 > 0) {
                HashMap map = new HashMap();
                int i2 = this.x;
                if (i2 == 1) {
                    map.put("type", "Float");
                } else if (i2 == 2) {
                    map.put("type", "Loop");
                } else if (i2 == 3) {
                    map.put("type", "TraditionalPanel");
                }
                map.put(TypedValues.TransitionType.S_DURATION, String.valueOf((int) ((jCurrentTimeMillis - this.e) / 1000)));
                ArrayList arrayList = new ArrayList();
                Iterator<Toy> it = pc1.a.P().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getDeviceId());
                }
                map.put("toy_mac", arrayList);
                ye3.d("M0043", WearUtils.A.toJson(map));
            }
            this.e = jCurrentTimeMillis;
        }
    }

    public final void l0(View view, float f2, float f3) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, FingImageLayout.ObjectAnimatorY, view.getY(), f3);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "x", view.getX(), f2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat);
        animatorSet.setDuration(0L);
        animatorSet.start();
    }

    public final void l1() {
        Vibrator vibrator = (Vibrator) getContext().getSystemService("vibrator");
        vibrator.cancel();
        if (Build.VERSION.SDK_INT >= 26) {
            String str = "hasAmplitudeControl:" + vibrator.hasAmplitudeControl();
            if (vibrator.hasAmplitudeControl()) {
                vibrator.vibrate(VibrationEffect.createOneShot(100L, 5));
                return;
            }
        }
        vibrator.vibrate(100L);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final MultiControlBallView m0(ControlBallBean controlBallBean) {
        MultiControlBallView multiControlBallView = new MultiControlBallView(getContext(), this.c);
        multiControlBallView.setStyle(this.A);
        multiControlBallView.i(controlBallBean);
        multiControlBallView.setOnTouchListener(this.p);
        multiControlBallView.k(gg3.e(getContext()) - getResources().getDimensionPixelSize(R.dimen.mutli_toys_control_right_width));
        this.j.put(controlBallBean, multiControlBallView);
        return multiControlBallView;
    }

    public final Disposable n0(ControlBallBean controlBallBean, MultiControlBallView multiControlBallView) {
        return Observable.intervalRange(0L, 10L, 0L, 100L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(controlBallBean, multiControlBallView));
    }

    public void o0(List<Ball2CurveEventBean> list) {
        m mVar = this.k;
        if (mVar != null) {
            mVar.a(list);
        }
    }

    @OnClick({R.id.ll_control_mode_loop, R.id.ll_control_mode_float, R.id.ll_control_mode_traditional_panel, R.id.ll_control_mode_slide, R.id.ll_control_mode_fys_panel, R.id.ll_control_mode_controlling_panel, R.id.iv_control_mode_chat_end, R.id.iv_control_mode_chat_endvis, R.id.iv_control_mode_chat_endvis_show})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_control_mode_chat_end /* 2131363128 */:
            case R.id.iv_control_mode_chat_endvis /* 2131363129 */:
                MultiControlPanel.m mVar = this.E;
                if (mVar != null) {
                    mVar.m();
                    break;
                }
                break;
            case R.id.iv_control_mode_chat_endvis_show /* 2131363130 */:
                R();
                break;
            case R.id.ll_control_mode_controlling_panel /* 2131363476 */:
                MultiControlPanel.n nVar = this.D;
                if (nVar != null) {
                    nVar.a();
                    break;
                }
                break;
            case R.id.ll_control_mode_float /* 2131363479 */:
                k1();
                j1();
                this.multiControlFysPanel.t();
                if (this.x == 1) {
                    this.x = 0;
                    this.e = 0L;
                } else {
                    this.x = 1;
                }
                j1();
                this.flControlFysPanel.setVisibility(8);
                this.llControlModeFysChoosePanel.setVisibility(8);
                if (TextUtils.equals("REMOTE_CONTROL", this.c)) {
                    this.llControlModeFysPanel.setVisibility(0);
                }
                d1();
                o oVar = this.m;
                if (oVar != null) {
                    oVar.s(false);
                    break;
                }
                break;
            case R.id.ll_control_mode_fys_panel /* 2131363481 */:
                H0(4);
                break;
            case R.id.ll_control_mode_loop /* 2131363483 */:
                k1();
                this.multiControlFysPanel.t();
                if (this.x == 2) {
                    this.x = 0;
                } else {
                    this.x = 2;
                }
                j1();
                this.flControlFysPanel.setVisibility(8);
                this.llControlModeFysChoosePanel.setVisibility(8);
                if (TextUtils.equals("REMOTE_CONTROL", this.c)) {
                    this.llControlModeFysPanel.setVisibility(0);
                }
                d1();
                o oVar2 = this.m;
                if (oVar2 != null) {
                    oVar2.s(false);
                    break;
                }
                break;
            case R.id.ll_control_mode_slide /* 2131363484 */:
                H0(0);
                break;
            case R.id.ll_control_mode_traditional_panel /* 2131363486 */:
                k1();
                H0(3);
                j1();
                break;
        }
    }

    public void p0() {
        this.multiControlFysPanel.B();
    }

    public void q0() {
        this.multiControlFysPanel.C();
        this.multiVelvoPanel.m();
        S(this.t);
        S(this.u);
        x0();
        setExpandPanelGone();
        this.o = 0;
        this.n = 0;
        this.guideLinePanel.b();
        C0();
    }

    public final void r0(ControlBallBean controlBallBean) {
        MultiControlBallView multiControlBallView = this.j.get(controlBallBean);
        if (multiControlBallView == null || multiControlBallView.getHeight() == 0) {
            controlBallBean.setProgress(0);
            return;
        }
        if (controlBallBean.getCurrentLocation()[0] == 0.0f && controlBallBean.getCurrentLocation()[1] == 0.0f) {
            controlBallBean.setProgress(0);
            return;
        }
        float y = multiControlBallView.getY() + (multiControlBallView.getHeight() / 2);
        int i2 = this.o;
        int i3 = this.n;
        float f2 = (i2 - i3) / 100.0f;
        if (y < i3) {
            y = i3;
        } else if (y > i2) {
            y = i2;
        }
        int i4 = (int) (100.0f - ((y - i3) / f2));
        int i5 = (i4 != 0 || y >= ((float) (i2 + (-8)))) ? i4 : 1;
        controlBallBean.setProgress(i5 >= 0 ? i5 > 100 ? 100 : i5 : 0);
    }

    public void s0(m mVar) {
        this.k = mVar;
    }

    public void setAllProgress(int i2) {
        int i3 = this.x;
        if (i3 == 3) {
            this.traditionalPanel.setAllProgress(i2);
            return;
        }
        if (i3 != 4) {
            G0(true);
        }
        List<ControlBallBean> list = this.g;
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = this.g.size();
        int width = this.flControlPanel.getWidth();
        int iMin = Math.min(size, 6);
        float fFloatValue = new BigDecimal(width).divide(new BigDecimal(iMin * 2), 4, 4).floatValue();
        String str = "decimal:" + fFloatValue;
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = i4 / 6;
            int i6 = i4 % 6;
            ControlBallBean controlBallBean = this.g.get(i4);
            if (controlBallBean != null) {
                controlBallBean.setProgress(i2);
                controlBallBean.setControlMode(1);
                controlBallBean.setLooping(false);
                controlBallBean.getDatas().clear();
                MultiControlBallView multiControlBallView = this.j.get(controlBallBean);
                if (multiControlBallView != null) {
                    int currentSize = (multiControlBallView.getCurrentSize() - multiControlBallView.getCurrentMargin()) * i5;
                    if (iMin == 6) {
                        controlBallBean.getOriginalLocation()[0] = i6 * (multiControlBallView.getCurrentSize() - multiControlBallView.getCurrentMargin());
                    } else {
                        controlBallBean.getOriginalLocation()[0] = (((i6 * 2) + 1) * fFloatValue) - multiControlBallView.f();
                    }
                    controlBallBean.getOriginalLocation()[1] = (this.o - multiControlBallView.f()) - (i5 * (multiControlBallView.getCurrentSize() - multiControlBallView.getCurrentMargin()));
                    int i7 = this.o;
                    float fW = W(controlBallBean.getProgress(), multiControlBallView.f(), (i7 - (((i7 - this.n) * controlBallBean.getProgress()) / 100)) - multiControlBallView.f());
                    if (controlBallBean.getProgress() == 0) {
                        fW -= currentSize;
                    }
                    if (multiControlBallView != null) {
                        multiControlBallView.x(controlBallBean.getCurrentLocation()[0] - multiControlBallView.f() > 0.0f ? controlBallBean.getCurrentLocation()[0] - multiControlBallView.f() : controlBallBean.getOriginalLocation()[0], fW);
                        multiControlBallView.u(1, controlBallBean.getBaseBallBeans().get(0).getToyFun(), true);
                    }
                    if (controlBallBean.getProgress() <= 0) {
                        controlBallBean.getCurrentLocation()[1] = 0.0f;
                    } else {
                        controlBallBean.getCurrentLocation()[1] = fW - multiControlBallView.f();
                    }
                }
            }
        }
    }

    public void setBackground(int i2) {
        this.parentLayout.setBackgroundResource(th4.b(getContext(), R.color.transparent));
        this.flControlPanel.setBackgroundResource(th4.b(getContext(), R.color.transparent));
    }

    public void setControShowMorelListener(MultiControlPanel.l lVar) {
        this.F = lVar;
    }

    public void setControlLink(boolean z) {
        this.d = z;
    }

    public void setControlTimer(@NonNull String str) {
        if ("CHAT_LIVE_CONTROL".equals(this.c)) {
            this.tvControlTimer.setText(str);
        } else if ("CHAT_SYNC_CONTROL".equals(this.c) || "GROUP_CHAT_DS_CONTROL".equals(this.c)) {
            this.tvControlVisTimer.setText(str);
        }
    }

    public void setEndControlListener(MultiControlPanel.m mVar) {
        this.E = mVar;
    }

    public void setExpandPanelGone() {
        this.flExpandPanel.removeAllViews();
        this.flExpandPanel.setVisibility(8);
        setExpandBallVisible(true);
    }

    public void setMultiSolacePanelListener(MultiVelvoPanel.b bVar) {
        this.multiVelvoPanel.setOnSolaceProPanelListener(bVar);
    }

    public void setOnSolacePanelInterceptListener(MultiVelvoPanel.a aVar) {
        this.multiVelvoPanel.setOnSolacePanelInterceptListener(aVar);
    }

    public void setStyle(int i2) {
        this.A = i2;
        if (i2 == 2) {
            this.ivMarker.setImageResource(R.drawable.multi_ball_control_panel_marker_dark);
            this.tvMarker0.setTextColor(getResources().getColor(R.color.multi_control_marker_text_color_dark));
            this.tvMarker100.setTextColor(getResources().getColor(R.color.multi_control_marker_text_color_dark));
            this.ivControlModeFloat.setImageResource(R.drawable.multi_rightfunction_cell_float_dark);
            this.tvControlModeFloat.setTextColor(getResources().getColor(R.color.multi_control_mode_unselect_color_dark));
            this.ivControlModeLoop.setImageResource(R.drawable.multi_rightfunction_cell_loop_dark);
            this.tvControlModeLoop.setTextColor(getResources().getColor(R.color.multi_control_mode_unselect_color_dark));
            this.ivControlModeTrad.setImageResource(R.drawable.multi_rightfunction_cell_traditional_dark);
            this.tvControlModeTrad.setTextColor(getResources().getColor(R.color.multi_control_mode_unselect_color_dark));
            this.ivControlModeSlide.setImageResource(R.drawable.multi_rightfunction_cell_slide_dark);
            this.tvControlModeSlide.setTextColor(getResources().getColor(R.color.multi_control_mode_unselect_color_dark));
            this.tvControlModeFysPanel.setTextColor(getResources().getColor(R.color.multi_control_mode_unselect_color_dark));
            this.bottomLine.setBackgroundResource(R.color.multi_toys_select_line_dark);
            this.rightLine.setBackgroundColor(th4.b(getContext(), R.color.multi_toys_select_line_dark));
            this.guideLinePanel.setLineColor(getResources().getColor(R.color.remote_control_line_dark));
        }
    }

    public void setSwitchControlListener(MultiControlPanel.n nVar) {
        this.D = nVar;
    }

    public void setSyncControlBtnVisible(boolean z) {
        this.llControlling.setVisibility(z ? 0 : 8);
    }

    public void t0(o oVar) {
        this.m = oVar;
    }

    public void u0(n nVar) {
        this.l = nVar;
    }

    public final void v0() {
        for (MultiControlBallView multiControlBallView : this.j.values()) {
            multiControlBallView.c();
            this.flControlPanel.removeView(multiControlBallView);
        }
        List<MultiControlBallView> list = this.h;
        if (list != null) {
            list.clear();
        }
        List<ControlBallBean> list2 = this.i;
        if (list2 != null) {
            list2.clear();
        }
        HashMap<ControlBallBean, MultiControlBallView> map = this.j;
        if (map != null) {
            map.clear();
        }
    }

    public void w0() {
        v0();
        List<ControlBallBean> list = this.g;
        if (list != null) {
            list.clear();
        }
    }

    public final void x0() {
        w0();
        I0();
        K0();
        this.multiControlFysPanel.I();
        k1();
    }

    public final int y0(BaseBallBean baseBallBean) throws IllegalArgumentException {
        if (this.g.isEmpty()) {
            return 0;
        }
        for (ControlBallBean controlBallBean : this.g) {
            List<BaseBallBean> baseBallBeans = controlBallBean.getBaseBallBeans();
            if (baseBallBeans != null && !baseBallBeans.isEmpty()) {
                for (BaseBallBean baseBallBean2 : baseBallBeans) {
                    if ((controlBallBean.isFunction() && baseBallBean2.getToyFun().equals(baseBallBean.getToyFun())) || (!controlBallBean.isFunction() && baseBallBean2.getToyAddress().equals(baseBallBean.getToyAddress()) && baseBallBean2.getToyFun().equals(baseBallBean.getToyFun()))) {
                        baseBallBeans.remove(baseBallBean2);
                        MultiControlBallView multiControlBallView = this.j.get(controlBallBean);
                        if (baseBallBeans.size() == 0) {
                            this.g.remove(controlBallBean);
                            this.j.remove(controlBallBean);
                            this.flControlPanel.removeView(multiControlBallView);
                            W0();
                            U0();
                            M0();
                        } else {
                            multiControlBallView.p();
                            N0(controlBallBean);
                        }
                        return baseBallBeans.size();
                    }
                }
            }
        }
        return 0;
    }

    public final void z0(BaseBallBean baseBallBean) {
        ControlBallBean controlBallBean;
        if (this.flExpandPanel.getVisibility() != 0 || (controlBallBean = this.s) == null) {
            return;
        }
        List<BaseBallBean> baseBallBeans = controlBallBean.getBaseBallBeans();
        if (baseBallBeans.contains(baseBallBean)) {
            int childCount = this.flExpandPanel.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.flExpandPanel.getChildAt(i2);
                if ((childAt instanceof MultiControlBallView) && ((ControlBallBean) childAt.getTag()).getBaseBallBeans().contains(baseBallBean)) {
                    this.flExpandPanel.removeView(childAt);
                    if (baseBallBeans.size() == 2) {
                        setExpandPanelGone();
                        return;
                    }
                    return;
                }
            }
        }
    }

    public MultiBallControlPanel(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = false;
        this.e = 0L;
        new HashMap();
        this.n = 0;
        this.o = 0;
        this.C = new int[2];
        Y();
    }

    public MultiBallControlPanel(Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.d = false;
        this.e = 0L;
        new HashMap();
        this.n = 0;
        this.o = 0;
        this.C = new int[2];
        Y();
    }
}
