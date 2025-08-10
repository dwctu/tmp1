package com.wear.widget.control.multiToys;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.bean.ToySelectEvent;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.FadingRecyclerView;
import com.wear.widget.llong.MyStrengthControlViewL;
import dc.ah4;
import dc.be3;
import dc.ce3;
import dc.cs3;
import dc.eg3;
import dc.is3;
import dc.my2;
import dc.pc1;
import dc.rq1;
import dc.sg3;
import dc.th4;
import dc.ua2;
import dc.vc1;
import dc.yc1;
import dc.ye3;
import dc.yo3;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes4.dex */
public class MultiFysControlPanel extends FrameLayout implements yc1, MyStrengthControlViewL.c {
    public static String y = "v";
    public RecyclerView.LayoutManager a;
    public LayoutInflater b;

    @BindView(R.id.bottom_layout)
    public ConstraintLayout bottomLayout;
    public Context c;
    public Dialog d;
    public e e;
    public View f;
    public List<Toy> g;
    public Map<String, Boolean> h;
    public ToyAdapter i;
    public pc1 j;
    public boolean k;
    public List<Toy> l;
    public List<Toy> m;
    public Toy n;
    public Map<Toy, ImageView> o;
    public Map<String, ImageView> p;
    public List<Ball2CurveEventBean> q;
    public long r;
    public long s;

    @BindView(R.id.sensitivity_progress)
    public MyStrengthControlViewL sensitivityProgress;
    public g t;

    @BindView(R.id.toy_recyclerview)
    public FadingRecyclerView toyRecyclerview;
    public d u;
    public int v;
    public int w;
    public Disposable x;

    public class ToyAdapter extends RecyclerView.Adapter<ToyViewHolder> {
        public List<Toy> a;

        public class ToyViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.batter_feedback_linear)
            public LinearLayout batterFeedbackLinear;

            @BindView(R.id.battery)
            public ImageView battery;

            @BindView(R.id.feedback)
            public ImageView feedback;

            @BindView(R.id.lottie_animation)
            public LottieAnimationView lottieAnimation;

            @BindView(R.id.nora_rotation_icon)
            public ImageView noraRotation;

            @BindView(R.id.toy_name)
            public TextView toyName;

            public ToyViewHolder(@NonNull ToyAdapter toyAdapter, View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }

        public class ToyViewHolder_ViewBinding implements Unbinder {
            public ToyViewHolder a;

            @UiThread
            public ToyViewHolder_ViewBinding(ToyViewHolder toyViewHolder, View view) {
                this.a = toyViewHolder;
                toyViewHolder.toyName = (TextView) Utils.findRequiredViewAsType(view, R.id.toy_name, "field 'toyName'", TextView.class);
                toyViewHolder.battery = (ImageView) Utils.findRequiredViewAsType(view, R.id.battery, "field 'battery'", ImageView.class);
                toyViewHolder.feedback = (ImageView) Utils.findRequiredViewAsType(view, R.id.feedback, "field 'feedback'", ImageView.class);
                toyViewHolder.batterFeedbackLinear = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.batter_feedback_linear, "field 'batterFeedbackLinear'", LinearLayout.class);
                toyViewHolder.noraRotation = (ImageView) Utils.findRequiredViewAsType(view, R.id.nora_rotation_icon, "field 'noraRotation'", ImageView.class);
                toyViewHolder.lottieAnimation = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.lottie_animation, "field 'lottieAnimation'", LottieAnimationView.class);
            }

            @Override // butterknife.Unbinder
            @CallSuper
            public void unbind() {
                ToyViewHolder toyViewHolder = this.a;
                if (toyViewHolder == null) {
                    throw new IllegalStateException("Bindings already cleared.");
                }
                this.a = null;
                toyViewHolder.toyName = null;
                toyViewHolder.battery = null;
                toyViewHolder.feedback = null;
                toyViewHolder.batterFeedbackLinear = null;
                toyViewHolder.noraRotation = null;
                toyViewHolder.lottieAnimation = null;
            }
        }

        public class a implements View.OnClickListener {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WearUtils.U0(MultiFysControlPanel.this.l);
                ToyAdapter toyAdapter = ToyAdapter.this;
                toyAdapter.o((Toy) toyAdapter.a.get(this.a), false);
            }
        }

        public class b implements View.OnClickListener {
            public final /* synthetic */ Toy a;
            public final /* synthetic */ int b;
            public final /* synthetic */ ToyViewHolder c;

            public b(Toy toy, int i, ToyViewHolder toyViewHolder) {
                this.a = toy;
                this.b = i;
                this.c = toyViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MultiFysControlPanel.this.h.containsKey(this.a.getDeviceId())) {
                    MultiFysControlPanel.this.h.put(this.a.getDeviceId(), Boolean.valueOf(!((Boolean) MultiFysControlPanel.this.h.get(this.a.getDeviceId())).booleanValue()));
                    ToyAdapter.this.notifyItemChanged(this.b, this.c.noraRotation);
                    rq1.d.f(this.a.getAddress());
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (MultiFysControlPanel.this.n == null) {
                    return;
                }
                MultiFysControlPanel.this.j.s0(MultiFysControlPanel.this.n);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MultiFysControlPanel.this.j.s0(MultiFysControlPanel.this.n);
            }
        }

        public ToyAdapter(List<Toy> list) {
            this.a = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull ToyViewHolder toyViewHolder, @SuppressLint({RecyclerView.TAG}) int i) {
            LinearLayout.LayoutParams layoutParams;
            Toy toy = this.a.get(i);
            if (toy == MultiFysControlPanel.this.n) {
                toyViewHolder.toyName.setBackground(th4.d(MultiFysControlPanel.this.c, R.drawable.shape_item_fys));
            } else {
                toyViewHolder.toyName.setBackground(th4.d(MultiFysControlPanel.this.c, R.drawable.shape_item_fys_unselected));
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) toyViewHolder.batterFeedbackLinear.getLayoutParams();
            if (toy.isF01Toy()) {
                toyViewHolder.battery.setVisibility(8);
                layoutParams2.setMarginStart(ce3.a(MultiFysControlPanel.this.c, 41.0f));
            } else {
                toyViewHolder.battery.setVisibility(0);
                layoutParams2.setMarginStart(ce3.a(MultiFysControlPanel.this.c, 34.0f));
            }
            toyViewHolder.batterFeedbackLinear.setLayoutParams(layoutParams2);
            if (getItemCount() > 2) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (toy.isF01Toy()) {
                    layoutParams.setMarginEnd(ce3.a(MultiFysControlPanel.this.c, 10.0f));
                }
            } else {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            toy.isNora();
            toyViewHolder.noraRotation.setVisibility(8);
            toyViewHolder.itemView.setLayoutParams(layoutParams);
            toyViewHolder.toyName.setText(toy.getToyUINameSpecialForMiniXMachine(3));
            if (toy.isF01Toy()) {
                toyViewHolder.battery.setVisibility(8);
            } else {
                Toy.updateToyBattery(toyViewHolder.battery, toy.getBattery());
            }
            MultiFysControlPanel.this.o.put(toy, toyViewHolder.feedback);
            MultiFysControlPanel.this.p.put(toy.getAndUpdateDeviceId(), toyViewHolder.battery);
            MultiFysControlPanel multiFysControlPanel = MultiFysControlPanel.this;
            multiFysControlPanel.K(toyViewHolder.feedback, multiFysControlPanel.w);
            toyViewHolder.toyName.setOnClickListener(new a(i));
            toyViewHolder.noraRotation.setOnClickListener(new b(toy, i, toyViewHolder));
            if (toy != MultiFysControlPanel.this.n || !toy.isSynControlAnimation()) {
                toyViewHolder.lottieAnimation.setVisibility(8);
                toyViewHolder.lottieAnimation.q();
                toyViewHolder.toyName.setVisibility(0);
                toyViewHolder.batterFeedbackLinear.setVisibility(0);
                return;
            }
            toyViewHolder.toyName.setVisibility(8);
            toyViewHolder.lottieAnimation.setVisibility(0);
            String strH = WearUtils.H(toy);
            if (TextUtils.isEmpty(strH)) {
                toyViewHolder.lottieAnimation.setVisibility(8);
                toyViewHolder.toyName.setVisibility(0);
                toyViewHolder.batterFeedbackLinear.setVisibility(0);
                return;
            }
            if (toy.isBAToy()) {
                toyViewHolder.lottieAnimation.setImageAssetsFolder("anim/solacepro/images/");
                toyViewHolder.lottieAnimation.setAnimation("anim/solacepro/solace_pro.json");
            } else {
                toyViewHolder.lottieAnimation.setAnimation(strH);
            }
            toyViewHolder.lottieAnimation.r();
            ua2.e(MyApplication.H(), toyViewHolder.lottieAnimation, MultiFysControlPanel.this.n);
            toyViewHolder.batterFeedbackLinear.setVisibility(8);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public ToyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ToyViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_fys_toy_layout, viewGroup, false));
        }

        public void o(Toy toy, boolean z) {
            if (MultiFysControlPanel.this.l.size() == 0) {
                return;
            }
            if (!((toy.isSupportLdr() && !toy.isV01Toy()) || MultiFysControlPanel.this.y(toy))) {
                if (MultiFysControlPanel.this.n == null) {
                    MultiFysControlPanel.this.j.B();
                    MultiFysControlPanel.this.j.u0();
                } else if (!MultiFysControlPanel.this.n.isConnected()) {
                    MultiFysControlPanel.this.j.E(MultiFysControlPanel.this.n);
                    MultiFysControlPanel.this.j.B();
                    MultiFysControlPanel.this.j.u0();
                }
                if (z) {
                    MultiFysControlPanel.this.F();
                    return;
                } else {
                    if (MultiFysControlPanel.this.d == null || !MultiFysControlPanel.this.d.isShowing()) {
                        sg3.l(ah4.e(R.string.fys_tip_popup));
                        return;
                    }
                    return;
                }
            }
            MultiFysControlPanel.this.j.E(MultiFysControlPanel.this.n);
            MultiFysControlPanel.this.j.B();
            MultiFysControlPanel.this.j.u0();
            if (toy != MultiFysControlPanel.this.n || !MultiFysControlPanel.this.k) {
                MultiFysControlPanel.this.n = toy;
                if (MultiFysControlPanel.this.t != null) {
                    MultiFysControlPanel.this.t.a(MultiFysControlPanel.this.n);
                }
            }
            if (!MultiFysControlPanel.this.g.contains(MultiFysControlPanel.this.n)) {
                new Handler().postDelayed(new c(), 1000L);
            }
            if (MultiFysControlPanel.this.g.size() > 0) {
                Iterator it = MultiFysControlPanel.this.g.iterator();
                while (it.hasNext()) {
                    if (((Toy) it.next()) == MultiFysControlPanel.this.n) {
                        MultiFysControlPanel.this.j.r0(MultiFysControlPanel.this.n);
                    } else {
                        new Handler().postDelayed(new d(), 1000L);
                    }
                }
            }
            notifyDataSetChanged();
            if (MultiFysControlPanel.this.d == null || !MultiFysControlPanel.this.d.isShowing()) {
                return;
            }
            MultiFysControlPanel.this.d.dismiss();
        }

        public void p(List<Toy> list) {
            this.a.clear();
            this.a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public class a implements Consumer<List<Ball2CurveEventBean>> {
        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<Ball2CurveEventBean> list) throws Exception {
            String str = "accept: 发送的数据：=" + list.toString();
            if (MultiFysControlPanel.this.u != null) {
                MultiFysControlPanel.this.u.a(list);
            }
        }
    }

    public class b implements Function<Long, List<Ball2CurveEventBean>> {
        public b() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<Ball2CurveEventBean> apply(@NotNull Long l) throws Exception {
            try {
                return MultiFysControlPanel.this.q;
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(new Throwable("getBall2CurveEventBeans多线程操作crash", e));
                return new ArrayList();
            }
        }
    }

    public class c implements is3.d {
        public c(MultiFysControlPanel multiFysControlPanel) {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            FragmentActivity fragmentActivity = MyApplication.K;
            if (fragmentActivity != null) {
                fragmentActivity.finish();
            }
        }
    }

    public interface d {
        void a(List<Ball2CurveEventBean> list);
    }

    public class e extends RecyclerView.ItemDecoration {
        public e(MultiFysControlPanel multiFysControlPanel) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getLayoutManager().getChildCount() > 1) {
                rect.top = ce3.a(recyclerView.getContext(), 18.0f);
                rect.bottom = ce3.a(recyclerView.getContext(), 18.0f);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.onDraw(canvas, recyclerView, state);
        }
    }

    public interface f {
        void a(boolean z);
    }

    public interface g {
        void a(Toy toy);
    }

    public MultiFysControlPanel(@NonNull Context context) {
        super(context);
        this.g = new ArrayList();
        this.h = new HashMap();
        this.k = false;
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.o = new HashMap();
        this.p = new HashMap();
        this.q = new ArrayList();
        this.w = 0;
        this.c = context;
        u();
    }

    public void A(f fVar) {
        if (this.l.hashCode() != this.r || this.l.size() != this.j.P().size()) {
            this.l = G();
            this.r = r0.hashCode();
        }
        if (this.m.size() <= 0) {
            if (fVar != null) {
                fVar.a(false);
            }
        } else {
            int iIntValue = ((Integer) eg3.b(WearUtils.x, "ldrSensitivity", 75)).intValue();
            this.v = iIntValue;
            this.sensitivityProgress.setViewLocation(iIntValue);
            if (fVar != null) {
                fVar.a(true);
            }
        }
    }

    public void B() {
        if (this.k) {
            if (this.l.hashCode() != this.r || this.l.size() != this.j.P().size()) {
                this.l = G();
                this.r = r0.hashCode();
            }
            z(true);
        }
    }

    public void C() {
        t();
        this.n = null;
        if (this.j != null) {
            this.j = null;
        }
        List<Toy> list = this.m;
        if (list != null) {
            list.clear();
            this.m = null;
        }
        List<Toy> list2 = this.l;
        if (list2 != null) {
            list2.clear();
            this.l = null;
        }
        Map<String, ImageView> map = this.p;
        if (map != null) {
            map.clear();
            this.p = null;
        }
        Map<Toy, ImageView> map2 = this.o;
        if (map2 != null) {
            map2.clear();
            this.o = null;
        }
        this.u = null;
        EventBus.getDefault().unregister(this);
    }

    public void D(g gVar) {
        this.t = gVar;
    }

    public final void E(String str, int i) {
        for (Toy toy : this.l) {
            if (!toy.isThridPartToy() || !toy.getAddress().equals(str)) {
                rq1.d.m(toy.getAddress(), i);
            }
        }
    }

    public final void F() {
        if (this.d == null) {
            this.d = cs3.k(this.c, ah4.f(R.string.fys_tip_popup, 0), new c(this));
        }
        if (!this.d.isShowing()) {
            this.d.show();
        }
        this.n = null;
    }

    public final List<Toy> G() {
        this.m.clear();
        ArrayList<Toy> arrayListP = this.j.P();
        ArrayList arrayList = new ArrayList();
        if (arrayListP != null && arrayListP.size() > 0) {
            for (Toy toy : arrayListP) {
                if (toy.isF01Toy()) {
                    this.g.add(toy);
                }
                if (toy.isNora()) {
                    this.h.put(toy.getDeviceId(), Boolean.TRUE);
                }
                if ((toy.isSupportLdr() && !toy.isV01Toy()) || y(toy)) {
                    this.m.add(toy);
                }
            }
            if (this.m.contains(this.n)) {
                this.m.remove(this.n);
                this.m.add(0, this.n);
            } else {
                this.n = null;
            }
            arrayList.addAll(this.m);
            for (Toy toy2 : arrayListP) {
                if (!this.m.contains(toy2)) {
                    arrayList.add(toy2);
                }
            }
        }
        return arrayList;
    }

    public void H() {
        this.j.u0();
        this.j.t(new yo3(this));
        this.k = true;
        z(false);
        this.s = be3.r();
        if (!my2.i.a().getB()) {
            HashMap map = new HashMap();
            map.put("type", "FYS");
            ye3.d("M0042", WearUtils.A.toJson(map));
        }
        w();
    }

    public void I() {
        this.t = null;
    }

    public void J(String str, boolean z) {
        String str2 = "updateToyStatus: toyAddress=" + str + "  isConnected=" + z;
        if (this.k) {
            this.l = G();
            this.r = r3.hashCode();
            z(true);
        }
    }

    public void K(ImageView imageView, int i) {
        if (i <= 0) {
            imageView.setImageResource(R.drawable.chat_ldr_feedback_level0);
            return;
        }
        if (i < 5) {
            imageView.setImageResource(R.drawable.chat_ldr_feedback_level1);
            return;
        }
        if (i < 10) {
            imageView.setImageResource(R.drawable.chat_ldr_feedback_level2);
        } else if (i < 15) {
            imageView.setImageResource(R.drawable.chat_ldr_feedback_level3);
        } else {
            imageView.setImageResource(R.drawable.chat_ldr_feedback_level4);
        }
    }

    @Override // com.wear.widget.llong.MyStrengthControlViewL.c
    public void e(int i) {
        String str = "postV: v=" + i;
    }

    public pc1 getBtWork() {
        return this.j;
    }

    public Toy getSelectedToy() {
        return this.n;
    }

    @Override // dc.yc1
    public void j(String str, List<Integer> list, List<Integer> list2) {
        if (this.k && TextUtils.equals(this.n.getAddress(), str)) {
            this.q.clear();
            int iIntValue = list.size() > 0 ? list.get(0).intValue() : 0;
            this.w = iIntValue;
            if (list2.size() > 0) {
                list2.get(0).intValue();
            }
            if (iIntValue != 0) {
                ua2.a();
                WearUtils.p2(this.l, str);
                this.i.notifyDataSetChanged();
            } else {
                Iterator<Map.Entry<Toy, ImageView>> it = this.o.entrySet().iterator();
                while (it.hasNext()) {
                    K(it.next().getValue(), iIntValue);
                }
            }
            this.q.add(new Ball2CurveEventBean(str, y, String.valueOf(iIntValue * 5)));
            E(str, iIntValue);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ToySelectEvent toySelectEvent) {
        if (this.k) {
            this.l = G();
            this.r = r3.hashCode();
            z(true);
        }
    }

    @Override // com.wear.widget.llong.MyStrengthControlViewL.c
    public void setDeth(int i) {
        String str = "setDeth: v=" + i;
        this.v = i;
        eg3.i(WearUtils.x, "ldrSensitivity", Integer.valueOf(i));
    }

    public void setFysCommandListener(d dVar) {
        this.u = dVar;
    }

    public void t() {
        if (this.k) {
            Disposable disposable = this.x;
            if (disposable != null && !disposable.isDisposed()) {
                this.x.dispose();
                this.x = null;
            }
            this.j.E(this.n);
            this.j.B();
            this.j.Z(new yo3(this));
            this.j.u0();
            this.k = false;
            int iR = (int) ((be3.r() - this.s) / 1000);
            if (iR > 5 && this.n != null) {
                ArrayList arrayList = new ArrayList();
                for (Toy toy : this.l) {
                    if (toy != this.n) {
                        arrayList.add(toy.getDeviceId());
                    }
                }
                HashMap map = new HashMap();
                map.put("type", "FYS");
                map.put("nums", Integer.valueOf(this.l.size()));
                map.put(TypedValues.TransitionType.S_DURATION, Integer.valueOf(iR));
                map.put("toy_mac", this.n.getDeviceId());
                map.put("controlled_toy_mac", arrayList);
                ye3.d("M0043", WearUtils.A.toJson(map));
            }
            this.n = null;
        }
    }

    public final void u() {
        EventBus.getDefault().register(this);
        this.j = pc1.a;
        x();
    }

    public void v(List<Toy> list) {
        this.l = G();
        this.r = r3.hashCode();
        WearUtils.U0(this.l);
    }

    public final void w() {
        this.x = Observable.interval(100L, TimeUnit.MILLISECONDS).map(new b()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
    }

    public final void x() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        this.b = layoutInflaterFrom;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.layout_fys_panel, (ViewGroup) null);
        this.f = viewInflate;
        addView(viewInflate);
        ButterKnife.bind(this, this.f);
        this.sensitivityProgress.setListener(this);
        ToyAdapter toyAdapter = new ToyAdapter(this.l);
        this.i = toyAdapter;
        this.toyRecyclerview.setAdapter(toyAdapter);
    }

    public final boolean y(Toy toy) {
        return toy.isH01Toy() || toy.isBAToy();
    }

    public final void z(boolean z) {
        if (this.l == null) {
            return;
        }
        e eVar = this.e;
        if (eVar != null) {
            this.toyRecyclerview.removeItemDecoration(eVar);
        }
        RecyclerView.LayoutManager layoutManager = this.a;
        if (layoutManager != null) {
            this.toyRecyclerview.setLayoutManager(layoutManager);
        }
        if (this.l.size() > 1) {
            this.a = new GridLayoutManager(this.c, 2, 1, false);
            if (this.e == null) {
                this.e = new e(this);
            }
            this.toyRecyclerview.addItemDecoration(this.e);
        } else {
            this.a = new LinearLayoutManager(this.c, 1, false);
        }
        this.toyRecyclerview.setLayoutManager(this.a);
        this.i.p(this.l);
        if (this.l.size() == 0) {
            F();
            return;
        }
        Toy toy = this.n;
        if (toy == null) {
            this.i.o(this.l.get(0), z);
        } else {
            this.i.o(toy, z);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(vc1 vc1Var) {
        ImageView imageView;
        Toy toyQ = this.j.Q(vc1Var.a());
        if (toyQ == null || (imageView = this.p.get(toyQ.getAndUpdateDeviceId())) == null) {
            return;
        }
        if (toyQ.isF01Toy()) {
            imageView.setVisibility(8);
        } else {
            Toy.updateToyBattery(imageView, vc1Var.b());
        }
    }

    public MultiFysControlPanel(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new ArrayList();
        this.h = new HashMap();
        this.k = false;
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.o = new HashMap();
        this.p = new HashMap();
        this.q = new ArrayList();
        this.w = 0;
        this.c = context;
        u();
    }

    public MultiFysControlPanel(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new ArrayList();
        this.h = new HashMap();
        this.k = false;
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.o = new HashMap();
        this.p = new HashMap();
        this.q = new ArrayList();
        this.w = 0;
        this.c = context;
        u();
    }
}
