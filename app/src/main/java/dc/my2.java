package dc;

import android.app.Activity;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.FrameMetricsAggregator;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.lovense.wear.R;
import com.wear.bean.RateFeature;
import com.wear.bean.UserJoinChatBean;
import com.wear.dao.DaoUtils;
import com.wear.ext.ActivityKt;
import com.wear.ui.chat.NewChatActivity;
import com.wear.ui.discover.roulette.ToyRouletteActivity;
import com.wear.util.MyApplication;
import com.wear.widget.control.FingImageLayout;
import com.wear.widget.dialog.RouletteExpandDialog;
import dc.is3;
import dc.kr2;
import dc.x12;
import dc.y12;
import dc.yf3;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteControl.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 :2\u00020\u0001:\u0001:B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u0014\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010#0\"\u0018\u00010!H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010&\u001a\u00020\u001fH\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u0004\u0018\u00010\u001aJ\b\u0010-\u001a\u00020\u0015H\u0016J\u0012\u0010.\u001a\u00020\u001c2\b\u0010/\u001a\u0004\u0018\u00010#H\u0016J\u000e\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0015J \u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0016J\u0012\u00107\u001a\u00020\u001c2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0006\u00108\u001a\u00020\u001cJ\u000e\u00109\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0015R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/wear/ui/discover/roulette/action/RouletteControl;", "Lcom/wear/main/control/ControlInterface;", "mediator", "Lcom/wear/main/control/ControlMediator;", "(Lcom/wear/main/control/ControlMediator;)V", "chatMessageAction", "Lcom/wear/ui/chat/action/ChatMessageAction;", "getChatMessageAction", "()Lcom/wear/ui/chat/action/ChatMessageAction;", "chatMessageAction$delegate", "Lkotlin/Lazy;", "controlState", "Lcom/wear/main/control/state/ControlState;", "controllingState", "Lcom/wear/main/control/state/ControllingState;", "expandDialog", "Ljava/lang/ref/WeakReference;", "Lcom/wear/widget/dialog/RouletteExpandDialog;", "idleState", "Lcom/wear/main/control/state/IdleState;", "isPlaying", "", "()Z", "setPlaying", "(Z)V", "userJoinChatBean", "Lcom/wear/bean/UserJoinChatBean;", "bindUserJoinChatBean", "", "closeExpandWindow", "getAnimation", "", "getBlackList", "", "Ljava/lang/Class;", "Landroid/app/Activity;", "getControlState", "getControllingState", "getControllingTip", "getIdleState", "getMediator", "Lcom/wear/main/control/Mediator;", "getPriority", "Lcom/wear/main/control/ControlPriority;", "getUserJoinChatBean", "isOpeningExpandWindow", "onActivityCreated", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "onDestroy", "isActive", "openExpandWindow", TtmlNode.LEFT, "x", "", FingImageLayout.ObjectAnimatorY, "setControlState", TtmlNode.START, "stop", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class my2 implements x12 {

    @NotNull
    public static final c i = new c(null);

    @NotNull
    public final y12 a;
    public boolean b;

    @Nullable
    public UserJoinChatBean c;

    @Nullable
    public WeakReference<RouletteExpandDialog> d;

    @NotNull
    public final Lazy e;

    @Nullable
    public f22 f;

    @Nullable
    public h22 g;

    @Nullable
    public g22 h;

    /* compiled from: RouletteControl.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016J\u001e\u0010\b\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/roulette/action/RouletteControl$1", "Lcom/wear/main/control/state/IdleState;", "onEnter", "", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "", "", "onExit", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends h22 {
        @Override // dc.f22
        public void b(@Nullable Map<String, ? extends Object> map) {
        }

        @Override // dc.f22
        public void c(@Nullable Map<String, ? extends Object> map) {
        }
    }

    /* compiled from: RouletteControl.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016J\u001e\u0010\b\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/roulette/action/RouletteControl$2", "Lcom/wear/main/control/state/ControllingState;", "onEnter", "", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "", "", "onExit", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends g22 {
        public b() {
        }

        @Override // dc.g22, dc.f22
        public void b(@Nullable Map<String, ? extends Object> map) {
            super.b(map);
            h12.D.isRouletteControl = true;
            pc1.a.u0();
        }

        @Override // dc.f22
        public void c(@Nullable Map<String, ? extends Object> map) {
            UserJoinChatBean userJoinChatBean;
            int iLongValue = 0;
            h12.D.isRouletteControl = false;
            Object obj = map != null ? map.get("isActive") : null;
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            if ((bool != null ? bool.booleanValue() : false) && (userJoinChatBean = my2.this.c) != null) {
                if (!au1.a(userJoinChatBean.getStartTime())) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Long startTime = userJoinChatBean.getStartTime();
                    iLongValue = (int) ((jCurrentTimeMillis - (startTime != null ? startTime.longValue() : 0L)) / 1000);
                }
                yf3.b bVar = yf3.i;
                bVar.a().s(RateFeature.ControlRoulette, Integer.valueOf(iLongValue));
                bVar.a().n();
            }
            my2.this.c = null;
            ht2.a.l();
            pc1.a.u0();
        }
    }

    /* compiled from: RouletteControl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/wear/ui/discover/roulette/action/RouletteControl$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/wear/ui/discover/roulette/action/RouletteControl;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final my2 a() {
            x12 x12VarI = y12.c.a().i(y12.c.TYPE_TOY_ROULETTE);
            Intrinsics.checkNotNull(x12VarI, "null cannot be cast to non-null type com.wear.ui.discover.roulette.action.RouletteControl");
            return (my2) x12VarI;
        }
    }

    /* compiled from: RouletteControl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/ui/chat/action/ChatMessageAction;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<kr2> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kr2 invoke() {
            return kr2.c.a(kr2.b.MESSAGE);
        }
    }

    /* compiled from: RouletteControl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.action.RouletteControl$onDestroy$1", f = "RouletteControl.kt", i = {0}, l = {106}, m = "invokeSuspend", n = {"userAccountCode"}, s = {"L$0"})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ boolean $isActive;
        public Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(boolean z, Continuation<? super e> continuation) {
            super(2, continuation);
            this.$isActive = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return my2.this.new e(this.$isActive, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            String str;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UserJoinChatBean userJoinChatBean = my2.this.c;
                String userAccountCode = userJoinChatBean != null ? userJoinChatBean.getUserAccountCode() : null;
                my2.this.D(this.$isActive);
                if (userAccountCode == null || userAccountCode.length() == 0) {
                    return Unit.INSTANCE;
                }
                kr2 kr2VarT = my2.this.t();
                this.L$0 = userAccountCode;
                this.label = 1;
                if (kr2VarT.g(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = userAccountCode;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            DaoUtils.getRouletteUserDao().delete(str);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteControl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function0<Unit> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            qf3.C();
            y12.c.a().t();
            my2.this.h(new Event(c22.EVENT_START, null, 2, null));
            my2.this.B(true);
        }
    }

    /* compiled from: RouletteControl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $isActive;
        public final /* synthetic */ my2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(boolean z, my2 my2Var) {
            super(0);
            this.$isActive = z;
            this.this$0 = my2Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("isActive", Boolean.valueOf(this.$isActive));
            this.this$0.h(new Event(c22.EVENT_STOP, linkedHashMap));
            qf3.C();
            y12.c.a().t();
            na2.m().x();
            this.this$0.B(false);
        }
    }

    public my2(@NotNull y12 mediator) {
        Intrinsics.checkNotNullParameter(mediator, "mediator");
        this.a = mediator;
        this.e = LazyKt__LazyJVMKt.lazy(d.a);
        a aVar = new a();
        this.g = aVar;
        this.h = new b();
        this.f = aVar;
    }

    public static final void A(my2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a.b();
    }

    public static final void z(my2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UserJoinChatBean userJoinChatBean = this$0.c;
        if (userJoinChatBean != null) {
            userJoinChatBean.setFromOuter(true);
            Activity activityE = ActivityKt.e();
            if (activityE != null) {
                NewChatActivity.a.b(NewChatActivity.n, activityE, userJoinChatBean, false, false, 12, null);
            }
        }
    }

    public final void B(boolean z) {
        this.b = z;
    }

    public final void C() {
        su1.d(new f());
    }

    public final void D(boolean z) {
        if (this.b) {
            su1.d(new g(z, this));
        }
    }

    @Override // dc.x12
    public boolean a() {
        RouletteExpandDialog rouletteExpandDialog;
        WeakReference<RouletteExpandDialog> weakReference = this.d;
        return (weakReference == null || (rouletteExpandDialog = weakReference.get()) == null || !rouletteExpandDialog.isShowing()) ? false : true;
    }

    @Override // dc.x12
    public /* synthetic */ boolean b(f22 f22Var, Map map) {
        return w12.a(this, f22Var, map);
    }

    @Override // dc.x12
    public void c(@Nullable f22 f22Var) {
        this.f = f22Var;
    }

    @Override // dc.x12
    @NotNull
    public String d() {
        return "Control Roulette is controlling";
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: e, reason: from getter */
    public f22 getI() {
        return this.f;
    }

    @Override // dc.x12
    public boolean f() {
        return x12.b.a(this);
    }

    @Override // dc.x12
    public void g() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        RouletteExpandDialog rouletteExpandDialog;
        y(false);
        WeakReference<RouletteExpandDialog> weakReference = this.d;
        if (weakReference == null || (rouletteExpandDialog = weakReference.get()) == null) {
            return;
        }
        rouletteExpandDialog.dismiss();
    }

    @Override // dc.x12
    @NotNull
    public a22 getPriority() {
        return a22.PRIORITY_2;
    }

    @Override // dc.x12
    public /* synthetic */ boolean h(Event event) {
        return w12.b(this, event);
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: i, reason: from getter */
    public h22 getJ() {
        return this.g;
    }

    @Override // dc.x12
    public void j(boolean z, int i2, int i3) {
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null || fragmentActivityH.isDestroyed() || fragmentActivityH.isFinishing()) {
            return;
        }
        if (fragmentActivityH instanceof NewChatActivity) {
            ((NewChatActivity) fragmentActivityH).j5();
            return;
        }
        this.a.f();
        ExpandData expandData = new ExpandData(0, 0, false, 0, null, 0, 0L, 0L, false, FrameMetricsAggregator.EVERY_DURATION, null);
        expandData.k(z);
        expandData.p(i2);
        expandData.q(i3);
        String strE = ah4.e(R.string.control_roulette);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.control_roulette)");
        expandData.l(strE);
        expandData.j(R.drawable.icon_roulette_control);
        is3.b bVar = new is3.b(fragmentActivityH);
        bVar.e(expandData);
        bVar.d(new is3.d() { // from class: dc.ly2
            @Override // dc.is3.d
            public final void doConfirm() {
                my2.z(this.a);
            }
        });
        bVar.c(new is3.c() { // from class: dc.ky2
            @Override // dc.is3.c
            public final void doCancel() {
                my2.A(this.a);
            }
        });
        RouletteExpandDialog rouletteExpandDialog = (RouletteExpandDialog) cs3.i(bVar, RouletteExpandDialog.class);
        if (rouletteExpandDialog == null) {
            return;
        }
        rouletteExpandDialog.p(fragmentActivityH);
        rouletteExpandDialog.show();
        this.d = new WeakReference<>(rouletteExpandDialog);
    }

    @Override // dc.x12
    @NotNull
    /* renamed from: k */
    public e22 getA() {
        return this.a;
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: l, reason: from getter */
    public g22 getK() {
        return this.h;
    }

    @Override // dc.x12
    public void m(@Nullable Activity activity) {
    }

    @Override // dc.x12
    @Nullable
    public List<Class<? extends Activity>> n() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{NewChatActivity.class, ToyRouletteActivity.class});
    }

    @Override // dc.x12
    @NotNull
    public String o() {
        return "roulette_mode_anim.json";
    }

    public final void s(@NotNull UserJoinChatBean userJoinChatBean) {
        Intrinsics.checkNotNullParameter(userJoinChatBean, "userJoinChatBean");
        if (userJoinChatBean.getStartTime() == null) {
            userJoinChatBean.setStartTime(Long.valueOf(System.currentTimeMillis()));
        }
        this.c = userJoinChatBean;
    }

    public final kr2 t() {
        return (kr2) this.e.getValue();
    }

    @Nullable
    /* renamed from: u, reason: from getter */
    public final UserJoinChatBean getC() {
        return this.c;
    }

    /* renamed from: v, reason: from getter */
    public final boolean getB() {
        return this.b;
    }

    public final void y(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        eg3.j(bu1.a(), "isInRouletteRoom", false);
        ny2.a.n();
        uy3.d(a14.a, null, null, new e(z, null), 3, null);
    }
}
