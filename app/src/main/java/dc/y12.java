package dc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActivityChooserModel;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.wear.ui.discover.speedMode.SpeedModeControl;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.ui.home.sound.SoundPlayControl;
import com.wear.util.MyApplication;
import com.wear.widget.FloatingNewControlView;
import dc.pd3;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ControlMediator.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0002'(B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010\u0015\u001a\u0004\u0018\u00010\tJ\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0006\u0010\u0017\u001a\u00020\u000bJ\u001c\u0010\u0018\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010#\u001a\u00020\u000eH\u0016J\u0006\u0010$\u001a\u00020\u000eJ\u0012\u0010%\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/wear/main/control/ControlMediator;", "Lcom/wear/main/control/Mediator;", "Lcom/wear/util/AppMonitor$Callback;", "()V", "floatView", "Lcom/wear/widget/FloatingNewControlView;", "mControllers", "", "Lcom/wear/main/control/ControlMediator$ControllerType;", "Lcom/wear/main/control/ControlInterface;", "check", "", "controlInterface", "checkBlack", "", "clazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "dismissFloatView", "getController", "type", "getCurrentController", "initFloatView", "isControlling", "notify", "state", "Lcom/wear/main/control/state/ControlState;", "onActivityCreated", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "onAppBackground", "onAppForeground", "onAppUIDestroyed", "pauseFloatViewAnimation", "playFloatViewAnimation", "requestControlAuthority", "showFloatView", "stopAllController", "updateFloatView", "controller", "Companion", "ControllerType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class y12 implements e22, pd3.b {

    @NotNull
    public static final b c = new b(null);

    @NotNull
    public static final Lazy<y12> d = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) a.a);

    @NotNull
    public Map<c, x12> a;

    @Nullable
    public FloatingNewControlView b;

    /* compiled from: ControlMediator.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/main/control/ControlMediator;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<y12> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final y12 invoke() {
            return new y12(null);
        }
    }

    /* compiled from: ControlMediator.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/wear/main/control/ControlMediator$Companion;", "", "()V", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/wear/main/control/ControlMediator;", "getInstance", "()Lcom/wear/main/control/ControlMediator;", "instance$delegate", "Lkotlin/Lazy;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final y12 a() {
            return (y12) y12.d.getValue();
        }
    }

    /* compiled from: ControlMediator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/wear/main/control/ControlMediator$ControllerType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TYPE_SOUND", "TYPE_VOICE_BOOK", "TYPE_SPEED_MODE", "TYPE_PATTERN", "TYPE_MEDIA_PATTERN", "TYPE_TOY_ROULETTE", "TYPE_VOICE_CONTROL", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum c {
        TYPE_SOUND("sound"),
        TYPE_VOICE_BOOK("voice_book"),
        TYPE_SPEED_MODE("speed_mode"),
        TYPE_PATTERN("pattern"),
        TYPE_MEDIA_PATTERN("media_pattern"),
        TYPE_TOY_ROULETTE("toy_roulette"),
        TYPE_VOICE_CONTROL("voice_control");


        @NotNull
        private final String type;

        c(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    /* compiled from: ControlMediator.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/wear/main/control/ControlMediator$initFloatView$1$1", "Lcom/wear/listenter/IFloatDrayListener;", "dragUp", "", TtmlNode.LEFT, "", "startMove", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements fv1 {
        public final /* synthetic */ FloatingNewControlView a;

        public d(FloatingNewControlView floatingNewControlView) {
            this.a = floatingNewControlView;
        }

        @Override // dc.fv1
        public void a() {
            this.a.getChildAt(0).setBackgroundResource(R.drawable.minimize_drag);
        }

        @Override // dc.fv1
        public void b(boolean z) {
            this.a.getChildAt(0).setBackgroundResource(z ? R.drawable.minimize_left_bg : R.drawable.minimize_right_bg);
        }
    }

    public y12() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.a = linkedHashMap;
        linkedHashMap.put(c.TYPE_SOUND, new SoundPlayControl(this));
        this.a.put(c.TYPE_PATTERN, new PatternPlayManagerImpl(this));
        this.a.put(c.TYPE_VOICE_BOOK, new k22(this));
        this.a.put(c.TYPE_SPEED_MODE, new SpeedModeControl(this));
        this.a.put(c.TYPE_MEDIA_PATTERN, new ll3(this));
        this.a.put(c.TYPE_TOY_ROULETTE, new my2(this));
        this.a.put(c.TYPE_VOICE_CONTROL, new c13(this));
        pd3.j().o(this);
    }

    public /* synthetic */ y12(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final void l(y12 this$0, FloatingNewControlView it, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        x12 x12VarJ = this$0.j();
        if (x12VarJ != null) {
            x12VarJ.j(it.getData().c, it.getData().a, it.getData().b);
        }
    }

    @Override // dc.e22
    public void a(@Nullable x12 x12Var, @Nullable f22 f22Var) {
        if (x12Var != null) {
            for (Map.Entry<c, x12> entry : this.a.entrySet()) {
                if (entry.getValue() != x12Var && !(entry.getValue().getI() instanceof h22)) {
                    entry.getValue().h(new Event(c22.EVENT_STOP, null, 2, null));
                    return;
                } else if (entry.getValue() == x12Var && !(entry.getValue().getI() instanceof h22) && (f22Var instanceof h22)) {
                    f();
                    c();
                    entry.getValue().g();
                    return;
                }
            }
        }
    }

    @Override // dc.e22
    public void b() {
        x12 x12VarJ = j();
        if (x12VarJ != null && x12VarJ.f() && od3.c(MyApplication.N())) {
            k();
            FloatingNewControlView floatingNewControlView = this.b;
            if (floatingNewControlView == null || floatingNewControlView.getVisibility() != 8 || (x12VarJ.getI() instanceof h22)) {
                return;
            }
            String strO = x12VarJ.o();
            if ((strO == null || strO.length() == 0) || x12VarJ.a()) {
                return;
            }
            u(x12VarJ);
            floatingNewControlView.setVisibility(0);
        }
    }

    @Override // dc.e22
    public void c() {
        FloatingNewControlView floatingNewControlView = this.b;
        View childAt = floatingNewControlView != null ? floatingNewControlView.getChildAt(0) : null;
        ViewGroup viewGroup = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
        LottieAnimationView lottieAnimationView = viewGroup != null ? (LottieAnimationView) viewGroup.findViewById(R.id.iv_small) : null;
        LottieAnimationView lottieAnimationView2 = lottieAnimationView instanceof LottieAnimationView ? lottieAnimationView : null;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.r();
        }
    }

    @Override // dc.e22
    public boolean d(@Nullable x12 x12Var) {
        if (x12Var == null) {
            return false;
        }
        Iterator<Map.Entry<c, x12>> it = this.a.entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                return true;
            }
            Map.Entry<c, x12> next = it.next();
            if (next.getValue() != x12Var && !(next.getValue().getI() instanceof h22) && next.getValue().getPriority().getPriority() > x12Var.getPriority().getPriority()) {
                String strD = next.getValue().d();
                if (strD != null && strD.length() != 0) {
                    z = false;
                }
                if (!z) {
                    sg3.l(next.getValue().d());
                }
                return false;
            }
        }
    }

    @Override // dc.e22
    public void e() {
        FloatingNewControlView floatingNewControlView = this.b;
        View childAt = floatingNewControlView != null ? floatingNewControlView.getChildAt(0) : null;
        ViewGroup viewGroup = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
        LottieAnimationView lottieAnimationView = viewGroup != null ? (LottieAnimationView) viewGroup.findViewById(R.id.iv_small) : null;
        LottieAnimationView lottieAnimationView2 = lottieAnimationView instanceof LottieAnimationView ? lottieAnimationView : null;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.q();
        }
    }

    @Override // dc.e22
    public void f() {
        FloatingNewControlView floatingNewControlView = this.b;
        if (floatingNewControlView == null || floatingNewControlView.getVisibility() != 0) {
            return;
        }
        floatingNewControlView.setVisibility(8);
    }

    public final void h(@Nullable Class<? extends Activity> cls) {
        x12 x12VarJ = j();
        if (x12VarJ != null) {
            List<Class<? extends Activity>> listN = x12VarJ.n();
            if (listN != null) {
                Iterator<T> it = listN.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual((Class) it.next(), cls)) {
                        f();
                        return;
                    }
                }
            }
            if (x12VarJ.a()) {
                return;
            }
            b();
        }
    }

    @Nullable
    public final x12 i(@NotNull c type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.a.get(type);
    }

    @Nullable
    public final x12 j() {
        for (Map.Entry<c, x12> entry : this.a.entrySet()) {
            if (entry.getValue().getI() instanceof g22) {
                return entry.getValue();
            }
        }
        return null;
    }

    public final void k() {
        if (this.b != null) {
            return;
        }
        final FloatingNewControlView floatingNewControlView = new FloatingNewControlView(MyApplication.N());
        this.b = floatingNewControlView;
        if (floatingNewControlView != null) {
            floatingNewControlView.addView(LayoutInflater.from(MyApplication.N()).inflate(R.layout.view_float_drag_view, (ViewGroup) null));
            floatingNewControlView.setWidthAndHeight(null, ce3.a(MyApplication.N(), 60.0f), ce3.a(MyApplication.N(), 60.0f));
            f();
            floatingNewControlView.setListener(new d(floatingNewControlView));
            floatingNewControlView.setOnClickListener(new View.OnClickListener() { // from class: dc.v12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    y12.l(this.a, floatingNewControlView, view);
                }
            });
        }
    }

    public final boolean m() {
        Iterator<Map.Entry<c, x12>> it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            if (!(it.next().getValue().getI() instanceof h22)) {
                return true;
            }
        }
        return false;
    }

    @Override // dc.pd3.b
    public void n() {
        t();
    }

    @Override // dc.pd3.b
    public void p() {
    }

    @Override // dc.pd3.b
    public void q() {
        f();
    }

    public final void r(@Nullable Activity activity) {
        x12 x12VarJ;
        if (activity == null || (x12VarJ = j()) == null) {
            return;
        }
        x12VarJ.m(activity);
    }

    public final boolean s(@NotNull c type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return d(this.a.get(type));
    }

    public final void t() {
        for (Map.Entry<c, x12> entry : this.a.entrySet()) {
            if (!(entry.getValue().getI() instanceof h22)) {
                entry.getValue().h(new Event(c22.EVENT_STOP, null, 2, null));
                entry.getValue().g();
            }
        }
        f();
    }

    public final void u(x12 x12Var) {
        if (x12Var != null) {
            FloatingNewControlView floatingNewControlView = this.b;
            View childAt = floatingNewControlView != null ? floatingNewControlView.getChildAt(0) : null;
            ViewGroup viewGroup = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
            LottieAnimationView lottieAnimationView = viewGroup != null ? (LottieAnimationView) viewGroup.findViewById(R.id.iv_small) : null;
            LottieAnimationView lottieAnimationView2 = lottieAnimationView instanceof LottieAnimationView ? lottieAnimationView : null;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.setImageAssetsFolder("images");
            }
            String strO = x12Var.o();
            if (strO == null || lottieAnimationView2 == null) {
                return;
            }
            lottieAnimationView2.setAnimation(strO);
        }
    }
}
